package net.littlexfish.xmldslparser.server.builtin

import net.littlexfish.xmldslparser.server.*

class PairFunc : DslFunction(listOf("first", "second"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
		errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		val first = param["first"]!!
		val second = param["second"]!!
		return DslPair(Pair(first, second))
	}
}

