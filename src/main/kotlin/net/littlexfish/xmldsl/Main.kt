@file:Suppress("unchecked_cast")
package net.littlexfish.xmldsl

import net.littlexfish.xmldslparser.*
import net.littlexfish.xmldslparser.server.ParseOption
import net.littlexfish.xmldslparser.server.ProcessOption
import java.io.*
import java.nio.charset.Charset
import kotlin.collections.HashMap

fun main(args: Array<String>) {
	val settings = parseArgs(args) ?: return
	val inputs = (settings[SETTINGS_NOT_PARAM] as? MutableList<String> ?: mutableListOf()).mapNotNull {
		val file = File(it)
		if(file.exists()) file else null
	}
	// FIXME: cannot read from terminal when user not press ENTER,
	//  cause by java not flush input stream,
	//  so disable user input for now
	val userInput = false // settings[SETTINGS_USER_INPUT] as? Boolean ?: false
	if(inputs.isEmpty() && !userInput) {
		throw IllegalArgumentException("No input file")
	}
	var output = (settings[SETTINGS_OUTPUT] as? String)?.let { File(it) }
	val terminalOutput = settings[SETTINGS_TERMINAL_OUTPUT] as? Boolean ?: false

	if(output == null && !terminalOutput) {
		if(userInput || inputs.isEmpty()) {
			throw IllegalArgumentException("No output file")
		}
		else {
			val first = inputs.first()
			output = first.parentFile
		}
	}
	output?.let {
		if(!it.exists() && !it.mkdirs()) {
			throw IllegalStateException("Cannot create output directory")
		}
	}

	val prettyPrint = settings[SETTINGS_PRETTY_PRINT] as? Boolean ?: false
	val inputCharset = settings[SETTINGS_INPUT_CHARSET] as? Charset ?: Charsets.UTF_8
	val outputCharset = settings[SETTINGS_OUTPUT_CHARSET] as? Charset ?: Charsets.UTF_8
	val indent = settings[SETTINGS_INDENT] as? String ?: "\t"
	val shortenEmpty = settings[SETTINGS_SHORTEN_EMPTY] as? Boolean ?: false
	val env = HashMap<String, String?>(settings[SETTINGS_ENV] as? Map<String, String> ?: mapOf())
//	val mode = settings[SETTINGS_MODE] as? String // keep to set mode in future

	val option = ParseOption(prettyPrint, indent, shortenEmpty, charset = outputCharset)
	if(userInput) {
		val bytes = System.`in`.readBytes()
		val bais = ByteArrayInputStream(bytes)
		val source = InputStreamDslSource(bais, inputCharset)
		if(terminalOutput) {
			val baos = ByteArrayOutputStream()
			parse(source, baos, option, ProcessOption(), env = env)
			println(baos.toString(outputCharset))
		}
		else {
			val out = FileOutputStream(File(output, "output.xml"))
			parse(source, out, option, ProcessOption(), env = env)
			out.close()
		}
	}
	else {
		for(input in inputs) {
			val ins = FileInputStream(input)
			val source = InputStreamDslSource(ins, inputCharset)
			if(terminalOutput) {
				val baos = ByteArrayOutputStream()
				parse(source, baos, option, ProcessOption(), env = env)
				println(baos.toString(outputCharset))
			}
			else {
				val out = FileOutputStream(File(output, input.nameWithoutExtension + ".xml"))
				parse(source, out, option, ProcessOption(), env = env)
				out.close()
			}
			ins.close()
		}
	}
}

private fun argEquals(current: String, vararg arg: String): Boolean {
	if(current.startsWith("-")) {
		val sub = current.substring(1)
		return if(sub.startsWith("-")) {
			arg.any { it == current }
		}
		else {
			arg.map { it.substring(1) }.any { it == sub }
		}
	}
	if(current.startsWith("+")) {
		val sub = current.substring(1)
		return if(sub.startsWith("+")) {
			arg.any { it == current }
		}
		else {
			arg.map { it.substring(1) }.any { it == sub }
		}
	}
	return false
}

private fun getArgValue(args: Array<String>, arg: String, idx: Int): String {
	if(idx + 1 < args.size) {
		val next = args[idx + 1]
		if(!next.startsWith("-") || !next.startsWith("+")) {
			return next
		}
	}
	throw IllegalArgumentException("Argument $arg requires a value")
}

private fun printHelp() {


}

private const val SETTINGS_OUTPUT = "output"
private const val SETTINGS_USER_INPUT = "user-input"
private const val SETTINGS_TERMINAL_OUTPUT = "terminal-output"
private const val SETTINGS_PRETTY_PRINT = "pretty-print"
private const val SETTINGS_INPUT_CHARSET = "input-charset"
private const val SETTINGS_OUTPUT_CHARSET = "output-charset"
private const val SETTINGS_INDENT = "indent"
private const val SETTINGS_SHORTEN_EMPTY = "shorten-empty"
private const val SETTINGS_ENV = "env"
private const val SETTINGS_NOT_PARAM = "not-param"
private const val SETTINGS_MODE = "mode" // keep to set mode in future

private fun getDefaultSettings(): HashMap<String, Any?> {
	return hashMapOf(
		SETTINGS_OUTPUT to null,
		SETTINGS_USER_INPUT to false,
		SETTINGS_TERMINAL_OUTPUT to false,
		SETTINGS_PRETTY_PRINT to false,
		SETTINGS_INPUT_CHARSET to Charsets.UTF_8,
		SETTINGS_OUTPUT_CHARSET to Charsets.UTF_8,
		SETTINGS_INDENT to "\t",
		SETTINGS_SHORTEN_EMPTY to false,
		SETTINGS_ENV to mutableMapOf<String, String>(),
		SETTINGS_NOT_PARAM to mutableListOf<String>(),
		SETTINGS_MODE to null,
	)
}

private fun parseArgs(args: Array<String>): HashMap<String, Any?>? {
	val settings = getDefaultSettings()
	var idx = 0
	while(idx < args.size) {
		val arg = args[idx]
		when {
			argEquals(arg, "-h", "--help") -> {
				printHelp()
				return null
			}
			argEquals(arg, "-v", "--version") -> {
				println(version)
				return null
			}
			argEquals(arg, "-o", "--output") -> {
				settings[SETTINGS_OUTPUT] = getArgValue(args, arg, idx + 1)
				idx++
			}
			argEquals(arg, "--") -> {
				settings[SETTINGS_USER_INPUT] = true
			}
			argEquals(arg, "++") -> {
				settings[SETTINGS_TERMINAL_OUTPUT] = true
			}
			argEquals(arg, "--pretty-print") -> {
				settings[SETTINGS_PRETTY_PRINT] = true
			}
			argEquals(arg, "--shorten-empty") -> {
				settings[SETTINGS_SHORTEN_EMPTY] = true
			}
			argEquals(arg, "--input-charset") -> {
				val charset = getArgValue(args, arg, idx + 1)
				if(!Charset.isSupported(charset)) {
					throw IllegalArgumentException("Charset $charset is not supported")
				}
				settings[SETTINGS_INPUT_CHARSET] = Charset.forName(charset)
				idx++
			}
			argEquals(arg, "--output-charset") -> {
				val charset = getArgValue(args, arg, idx + 1)
				if(!Charset.isSupported(charset)) {
					throw IllegalArgumentException("Charset $charset is not supported")
				}
				settings[SETTINGS_OUTPUT_CHARSET] = Charset.forName(charset)
				idx++
			}
			argEquals(arg, "--indent") -> {
				settings[SETTINGS_INDENT] = getArgValue(args, arg, idx + 1)
				idx++
			}
			argEquals(arg, "-e", "--env") -> {
				val map = settings[SETTINGS_ENV] as? MutableMap<String, String> ?: mutableMapOf()
				val kv = getArgValue(args, arg, idx + 1)
				val split = kv.split("=", limit = 2)
				if(split.size != 2) {
					throw IllegalArgumentException("Invalid environment variable $kv")
				}
				map[split[0]] = split[1]
				settings[SETTINGS_ENV] = map
				idx++
			}
			argEquals(arg, "--mode") -> {
				settings[SETTINGS_MODE] = getArgValue(args, arg, idx + 1)
				idx++
			}
			else -> {
				if(!arg.startsWith("-")) {
					val list = settings[SETTINGS_NOT_PARAM] as? MutableList<String> ?: mutableListOf()
					list.add(arg)
				}
			}
		}
		idx++
	}
	return settings
}
