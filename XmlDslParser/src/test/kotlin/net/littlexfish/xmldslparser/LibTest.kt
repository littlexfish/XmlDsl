package net.littlexfish.xmldslparser

import net.littlexfish.xmldslparser.server.HtmlProcessOption
import net.littlexfish.xmldslparser.server.ParseErrorHandler
import net.littlexfish.xmldslparser.server.ParseOption
import net.littlexfish.xmldslparser.server.ProcessOption
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.File

class LibTest {

	@Test
	fun testBaseElement() {
		val source = StringDslSource("test {}")
		val outputStream = ByteArrayOutputStream()
		val parseOption = ParseOption()
		val processOption = ProcessOption()
		val env = HashMap<String, String?>()
		parse(source, outputStream, parseOption, processOption, env = env)
		assert(outputStream.toString() == "<test></test>")
	}

	@Test
	fun testFileInput() {
		val source = FileDslSource("src/test/resources/test.xd")
		val outputStream = ByteArrayOutputStream()
		val env = HashMap<String, String?>()
		parse(source, outputStream, env = env)
		assert(outputStream.toString() == File("src/test/resources/test.xml").readText())
	}

	@Test
	fun testInputStreamInput() {
		val source = InputStreamDslSource(File("src/test/resources/test.xd").inputStream())
		val outputStream = ByteArrayOutputStream()
		val parseOption = ParseOption(prettyPrint = true)
		val processOption = ProcessOption()
		val env = HashMap<String, String?>()
		parse(source, outputStream, parseOption, processOption, env = env)
		assert(outputStream.toString() == File("src/test/resources/testPrettyPrint.xml").readText())
	}

	@Test
	fun testFileFull() {
		val source = FileDslSource("src/test/resources/testFull.xd")
		val outputStream = ByteArrayOutputStream()
		val env = HashMap<String, String?>().apply {
			put("name", "test")
		}
		parse(source, outputStream, ParseOption(prettyPrint = true, shortenEmpty = true), env = env)
		assert(outputStream.toString().isNotEmpty())
	}

	@Test
	fun testFileHtml() {
		val source = FileDslSource("src/test/resources/html.xd")
		val outputStream = ByteArrayOutputStream()
		val env = HashMap<String, String?>().apply {
			put("name", "test")
		}
		parse(source, outputStream, ParseOption(prettyPrint = true, shortenEmpty = true), HtmlProcessOption, env = env)
		assert(outputStream.toString().isNotEmpty())
	}

	@Test
	fun testFileFail() {
		val source = FileDslSource("src/test/resources/testError.xd")
		val outputStream = ByteArrayOutputStream()
		val env = HashMap<String, String?>()
		val errorHandler = ParseErrorHandler()
		errorHandler.setListener { /* do nothing */ }
		parse(source, outputStream, ParseOption(prettyPrint = true, shortenEmpty = true), errorHandler = errorHandler, env = env)
		assert(errorHandler.getDetails().isNotEmpty())
	}

}