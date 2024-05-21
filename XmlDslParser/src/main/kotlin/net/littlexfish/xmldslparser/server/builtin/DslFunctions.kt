package net.littlexfish.xmldslparser.server.builtin

import net.littlexfish.xmldslparser.server.*

class PrintFunc : DslFunction(listOf("value"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
		errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue? {
		val value = param["value"]!!
		println(value.toString("", processOption))
		return null
	}
}

class PanicFunc : DslFunction(listOf("msg"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
		errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue? {
		val message = param["msg"]!!
		throw DslPanicException(message.toString("", processOption) ?: "<null>")
	}
}

class PairFunc : DslFunction(listOf("first", "second"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
		errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		val first = param["first"]!!
		val second = param["second"]!!
		return DslPair(Pair(first, second))
	}
}

class DictToPairsFunc : DslFunction(listOf("d"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
		errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue? {
		val d = param["d"]
		if(d !is DslDict) {
			(currentScope.getField("panic", null) as DslFunction)
				.invoke(mapOf("msg" to DslString("Parameter 1 not Dict type")), processOption, errorHandler, currentElement, currentScope)
			return null
		}
		return d.toPairList()
	}
}

class TypeOfFunc : DslFunction(listOf("value"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
		errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		val value = param["value"]!!
		return DslType(value.getType())
	}
}