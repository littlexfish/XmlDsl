package net.littlexfish.xmldslparser.server.builtin

import net.littlexfish.xmldslparser.server.*

private fun panic(message: String): Nothing {
	throw DslPanicException(message)
}

object PrintFunc : DslFunction(listOf("value"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
		errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue? {
		val value = param["value"]!!
		println(value.toString("", processOption))
		return null
	}
}

object PanicFunc : DslFunction(listOf("msg"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
		errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue? {
		val message = param["msg"]!!
		panic(message.toString("", processOption) ?: "<null>")
	}
}

object PairFunc : DslFunction(listOf("first", "second"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
		errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		val first = param["first"]!!
		val second = param["second"]!!
		return DslPair(Pair(first, second))
	}
}

object PairsFunc : DslFunction(listOf("d"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
		errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		val d = param["d"]
		if(d !is DslDict) {
			panic("Parameter 1 not Dict type")
		}
		return d.toPairList()
	}
}

object TypeOfFunc : DslFunction(listOf("value"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
		errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		val value = param["value"]!!
		return DslType(value.getType())
	}
}

object LenFunc : DslFunction(listOf("value"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
		errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		return when(val value = param["value"]!!) {
			is DslList -> DslNumber(value.value.size.toDouble())
			is DslSet -> DslNumber(value.value.size.toDouble())
			is DslDict -> DslNumber(value.value.size.toDouble())
			is DslString -> DslNumber(value.value.length.toDouble())
			else -> panic("Parameter 1 not List, Set, Dict or String type")
		}
	}
}

object KeysFunc : DslFunction(listOf("d"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
		errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		val d = param["d"]
		if(d !is DslDict) {
			panic("Parameter 1 not Dict type")
		}
		return DslSet(d.value.keys)
	}
}

object ValuesFunc : DslFunction(listOf("d"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
		errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		val d = param["d"]
		if(d !is DslDict) {
			panic("Parameter 1 not Dict type")
		}
		return DslList(d.value.values.toList())
	}
}

