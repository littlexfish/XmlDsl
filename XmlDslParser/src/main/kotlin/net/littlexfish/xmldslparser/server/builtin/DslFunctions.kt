package net.littlexfish.xmldslparser.server.builtin

import net.littlexfish.xmldslparser.server.*
import java.lang.Math.random
import java.lang.Math.toRadians
import kotlin.math.*

private fun panic(message: String): Nothing {
	throw DslPanicException(message)
}

// terminal

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

// pair

object PairFunc : DslFunction(listOf("first", "second"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
		errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		val first = param["first"]!!
		val second = param["second"]!!
		return DslPair(Pair(first, second))
	}
}

// dict

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

// collection

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

object IndexOfFunc : DslFunction(listOf("value", "element"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
	                    errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		val value = param["value"]!!
		val element = param["element"]!!
		return when(value) {
			is DslList -> DslNumber(value.value.indexOf(element).toDouble())
			is DslString -> {
				if(element !is DslString) panic("Parameter 2 not String type")
				DslNumber(value.value.indexOf(element.value).toDouble())
			}
			else -> panic("Parameter 1 not List or String type")
		}
	}
}

object JoinFunc : DslFunction(listOf("value", "separator"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
	                    errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		val value = param["value"]!!
		val separator = param["separator"]!!
		return when(value) {
			is DslList -> DslString(value.value.joinToString(separator.toString("", processOption) ?: "<null>")
			{ it.toString("", processOption) ?: "<null>" })
			else -> panic("Parameter 1 not List type")
		}
	}
}

object SplitFunc : DslFunction(listOf("value", "separator"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
	                    errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		val value = param["value"]!!
		val separator = param["separator"]!!
		if(value !is DslString) panic("Parameter 1 not String type")
		if(separator !is DslString) panic("Parameter 2 not String type")
		return DslList(value.value.split(separator.value).map { DslString(it) })
	}
}

object ReplaceFunc : DslFunction(listOf("value", "old", "new"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
	                    errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		val value = param["value"]!!
		val old = param["old"]!!
		val new = param["new"]!!
		if(value !is DslString) panic("Parameter 1 not String type")
		if(old !is DslString) panic("Parameter 2 not String type")
		if(new !is DslString) panic("Parameter 3 not String type")
		return DslString(value.value.replace(old.value, new.value))
	}
}

object TrimFunc : DslFunction(listOf("value"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
	                    errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		val value = param["value"]!!
		if(value !is DslString) panic("Parameter 1 not String type")
		return DslString(value.value.trim())
	}
}

object LowerFunc : DslFunction(listOf("value"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
	                    errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		val value = param["value"]!!
		if(value !is DslString) panic("Parameter 1 not String type")
		return DslString(value.value.lowercase())
	}
}

object UpperFunc : DslFunction(listOf("value"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
	                    errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		val value = param["value"]!!
		if(value !is DslString) panic("Parameter 1 not String type")
		return DslString(value.value.uppercase())
	}
}

// type

object TypeOfFunc : DslFunction(listOf("value"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
	                    errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		val value = param["value"]!!
		return DslType(value.getType())
	}
}

// format

object ToIntFunc : DslFunction(listOf("value"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
	                    errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		return when(val value = param["value"]!!) {
			is DslNumber -> DslNumber(value.value.toInt().toDouble())
			is DslBoolean -> DslNumber(if(value.value) 1.0 else 0.0)
			is DslString -> {
				try {
					DslNumber(value.value.toInt().toDouble())
				}
				catch(e: NumberFormatException) {
					panic("Cannot convert string to int: ${value.value}")
				}
			}
			else -> panic("Parameter 1 not Number or String type")
		}
	}
}

object ToStringFunc : DslFunction(listOf("value"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
	                    errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		val value = param["value"]!!
		return DslString(value.toString("", processOption) ?: "<null>")
	}
}

object FormatFunc : DslFunction(listOf("value", "format"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
	                    errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		val value = param["value"]!!
		val format = param["format"]!!
		if(value !is DslString) panic("Parameter 1 not String type")
		val str = value.value
		return when(format) {
			is DslList -> DslString(str.format(*format.value.map { it.toString("", processOption) ?: "<null>" }.toTypedArray()))
			else -> DslString(str.format(format.toString("", processOption) ?: "<null>"))
		}
	}
}

object ToListFunc : DslFunction(listOf("value"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
		errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		return when(val value = param["value"]!!) {
			is DslList -> value
			is DslSet -> DslList(value.value.toList())
			is DslDict -> value.toPairList()
			is DslNull, is DslEmpty -> DslList(emptyList())
			else -> DslList(listOf(value))
		}
	}
}

object ToSetFunc : DslFunction(listOf("value"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
		errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		return when(val value = param["value"]!!) {
			is DslList -> DslSet(value.value.toSet())
			is DslSet -> value
			is DslDict -> DslSet(value.toPairList().value.toSet())
			is DslNull, is DslEmpty -> DslSet(emptySet())
			else -> DslSet(setOf(value))
		}
	}
}

// math

private fun requireNumber(value: DslValue?): DslNumber {
	if(value !is DslNumber) panic("Parameter 1 not Number type")
	return value
}

object FloorFunc : DslFunction(listOf("value"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
	                    errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		return DslNumber(floor(requireNumber(param["value"]).value))
	}
}

object CeilFunc : DslFunction(listOf("value"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
	                    errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		return DslNumber(ceil(requireNumber(param["value"]).value))
	}
}

object RoundFunc : DslFunction(listOf("value"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
	                    errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		return DslNumber(round(requireNumber(param["value"]).value))
	}
}

object AbsFunc : DslFunction(listOf("value"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
	                    errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		return DslNumber(requireNumber(param["value"]).value.absoluteValue)
	}
}

object SqrtFunc : DslFunction(listOf("value"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
	                    errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		return DslNumber(sqrt(requireNumber(param["value"]).value))
	}
}

object PowFunc : DslFunction(listOf("base", "exponent"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
	                    errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		val base = requireNumber(param["base"])
		val exponent = requireNumber(param["exponent"])
		return DslNumber(base.value.pow(exponent.value))
	}
}

object ToRadFunc : DslFunction(listOf("degree"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
	                    errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		return DslNumber(toRadians(requireNumber(param["degree"]).value))
	}
}

object ToDegFunc : DslFunction(listOf("radian"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
	                    errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		return DslNumber(Math.toDegrees(requireNumber(param["radian"]).value))
	}
}

object SinFunc : DslFunction(listOf("value"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
	                    errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		return DslNumber(sin(requireNumber(param["value"]).value))
	}
}

object CosFunc : DslFunction(listOf("value"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
	                    errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		return DslNumber(cos(requireNumber(param["value"]).value))
	}
}

object TanFunc : DslFunction(listOf("value"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
	                    errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		return DslNumber(tan(requireNumber(param["value"]).value))
	}
}

object AsinFunc : DslFunction(listOf("value"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
	                    errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		return DslNumber(asin(requireNumber(param["value"]).value))
	}
}

object AcosFunc : DslFunction(listOf("value"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
	                    errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		return DslNumber(acos(requireNumber(param["value"]).value))
	}
}

object AtanFunc : DslFunction(listOf("value"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
	                    errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		return DslNumber(atan(requireNumber(param["value"]).value))
	}
}

object LogFunc : DslFunction(listOf("value", "base"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
	                    errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		val value = requireNumber(param["value"])
		val base = requireNumber(param["base"])
		return DslNumber(log(value.value, base.value))
	}
}

object Log10Func : DslFunction(listOf("value"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
	                    errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		return DslNumber(log10(requireNumber(param["value"]).value))
	}
}

object ExpFunc : DslFunction(listOf("value"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
	                    errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		return DslNumber(exp(requireNumber(param["value"]).value))
	}
}

object RandomFunc : DslFunction(listOf(), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
	                    errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		return DslNumber(random())
	}
}

object RandomRangeFunc : DslFunction(listOf("min", "max"), null) {
	override fun invoke(param: Map<String, DslValue>, processOption: ProcessOption,
	                    errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		val min = requireNumber(param["min"])
		val max = requireNumber(param["max"])
		return DslNumber(random() * (max.value - min.value) + min.value)
	}
}
