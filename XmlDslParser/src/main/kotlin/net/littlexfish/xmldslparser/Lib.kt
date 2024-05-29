package net.littlexfish.xmldslparser

import net.littlexfish.xmldslparser.antlr.XmlDslLexer
import net.littlexfish.xmldslparser.server.*
import net.littlexfish.xmldslparser.antlr.XmlDslParser as AntlrXmlDslParser
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.Token
import java.io.File
import java.io.InputStream
import java.io.OutputStream
import java.nio.charset.Charset

const val version = "0.1.3-beta"

abstract class DslSource {
	internal abstract fun toCharStream(): CharStream
}
class StringDslSource(private val source: String) : DslSource() {
	override fun toCharStream(): CharStream = CharStreams.fromString(source)
}
class FileDslSource(private val path: String, private val charset: Charset = Charsets.UTF_8) : DslSource() {
	override fun toCharStream(): CharStream = CharStreams.fromFileName(path, charset)
}
class InputStreamDslSource(private val inputStream: InputStream, private val charset: Charset = Charsets.UTF_8) : DslSource() {
	override fun toCharStream(): CharStream = CharStreams.fromStream(inputStream, charset)
}

fun parse(source: DslSource,
          outputStream: OutputStream,
          option: ParseOption = ParseOption(),
          processOption: ProcessOption = ProcessOption(),
          errorHandler: ParseErrorHandler = ParseErrorHandler(),
		  env: Map<String, String?>,
		  paths: Set<File>) {
	val dsl = parseXmlDsl(source, processOption, errorHandler, env, paths)
	if(errorHandler.getDetails().isEmpty()) {
		dsl.toXml(option, outputStream)
	}
}

fun parseXmlDsl(source: DslSource,
                processOption: ProcessOption = ProcessOption(),
                errorHandler: ParseErrorHandler = ParseErrorHandler(),
                env: Map<String, String?>,
                paths: Set<File>): XmlDsl {
	val lexer = XmlDslLexer(source.toCharStream())
	val parser = AntlrXmlDslParser(CommonTokenStream(lexer))
	return XmlDslParser.parseDslFile(parser.dslFile(), processOption, errorHandler, env, paths)
}

data class XmlDslToken(
	val type: Int,
	val typeString: String,
	val text: String,
	val line: Int,
	val charPositionInLine: Int,
	val beginIndex: Int,
	val endIndex: Int) {
	override fun toString(): String {
		val textReplace = text.replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t")
		return "[$line:$charPositionInLine] $typeString -> $textReplace"
	}
}

fun tokens(source: DslSource): List<XmlDslToken> {
	val lexer = XmlDslLexer(source.toCharStream())
	val typeMap = lexer.tokenTypeMap.map { it.value to it.key }.toMap()
	return lexer.allTokens.map {
		XmlDslToken(
			it.type,
			typeMap[it.type] ?: "Unknown",
			it.text,
			it.line,
			it.charPositionInLine,
			it.startIndex,
			it.stopIndex
		)
	}
}





