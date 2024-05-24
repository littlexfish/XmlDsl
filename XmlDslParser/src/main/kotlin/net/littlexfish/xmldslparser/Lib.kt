package net.littlexfish.xmldslparser

import net.littlexfish.xmldslparser.antlr.XmlDslLexer
import net.littlexfish.xmldslparser.server.ParseErrorHandler
import net.littlexfish.xmldslparser.server.ParseOption
import net.littlexfish.xmldslparser.server.ProcessOption
import net.littlexfish.xmldslparser.server.XmlDslParser
import net.littlexfish.xmldslparser.antlr.XmlDslParser as AntlrXmlDslParser
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.Token
import java.io.InputStream
import java.io.OutputStream
import java.nio.charset.Charset

const val version = "0.1.2-beta"

abstract class DslSource {
	internal abstract fun toCharStream(): CharStream
}
class StringDslSource(private val source: String) : DslSource() {
	override fun toCharStream(): CharStream = CharStreams.fromString(source)
}
class FileDslSource(internal val path: String, private val charset: Charset = Charsets.UTF_8) : DslSource() {
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
		  env: Map<String, String?>) {
	val lexer = XmlDslLexer(source.toCharStream())
	val parser = AntlrXmlDslParser(CommonTokenStream(lexer))
	val dsl = XmlDslParser.parseDslFile(parser.dslFile(), processOption, errorHandler, env)
	if(errorHandler.getDetails().isEmpty()) {
		dsl.toXml(option, outputStream)
	}
}

fun tokens(source: DslSource): List<Token> {
	val lexer = XmlDslLexer(source.toCharStream())
	return lexer.allTokens
}





