package net.littlexfish.xmldslparser.server

import net.littlexfish.xmldslparser.antlr.XmlDslParser.BlockContext
import org.antlr.v4.runtime.Token
import java.io.OutputStream

sealed class DslValue {

	abstract fun getType(): DslValueType

	abstract fun toString(name: String, option: ProcessOption): String?

	abstract override fun equals(other: Any?): Boolean
	abstract override fun hashCode(): Int

	fun toXml(option: ParseOption, processOption: ProcessOption, outputStream: OutputStream) {
		pToXml(option, processOption, outputStream, 0)
	}

	internal open fun pToXml(option: ParseOption, processOption: ProcessOption, outputStream: OutputStream, indentLevel: Int) {
		val str = toString("", processOption) ?: return
		if(option.prettyPrint) outputStream.write(option.indent.repeat(indentLevel).toByteArray(option.charset))
		outputStream.write(str.toByteArray(option.charset))
	}

	fun toXmlAttributeString(name: String, option: ProcessOption): String? {
		val value = toString(name, option) ?: return null
		if(this is DslEmpty) return name
		return "$name=\"${value.replace("\"", "\\\"")}\""
	}

}

class DslNumber(val value: Double) : DslValue() {
	override fun getType() = DslValueType.Number
	override fun toString(name: String, option: ProcessOption): String = value.toString().removeSuffix(".0")
	override fun equals(other: Any?): Boolean {
		if(this === other) return true
		if(other !is DslNumber) return false
		return value == other.value
	}
	override fun hashCode(): Int {
		return value.hashCode()
	}
	fun isInt() = value % 1 == 0.0
	fun isNotInt() = !isInt()
}

class DslString(val value: String) : DslValue() {
	override fun getType() = DslValueType.String
	override fun toString(name: String, option: ProcessOption): String = value
	override fun equals(other: Any?): Boolean {
		if(this === other) return true
		if(other !is DslString) return false
		return value == other.value
	}
	override fun hashCode(): Int {
		return value.hashCode()
	}
	operator fun get(index: Int) = DslString(value[index].toString())
}

class DslBoolean(val value: Boolean) : DslValue() {
	override fun getType() = DslValueType.Boolean
	override fun toString(name: String, option: ProcessOption): String = value.toString()
	override fun equals(other: Any?): Boolean {
		if(this === other) return true
		if(other !is DslBoolean) return false
		return value == other.value
	}
	override fun hashCode(): Int {
		return value.hashCode()
	}
}

class DslList(val value: List<DslValue>) : DslValue() {
	override fun getType() = DslValueType.List
	override fun toString(name: String, option: ProcessOption): String = option.onListToString(name, value)
	override fun equals(other: Any?): Boolean {
		if(this === other) return true
		if(other !is DslList) return false
		return value == other.value
	}
	override fun hashCode(): Int {
		return value.hashCode()
	}
	operator fun get(index: Int) = value[index]
}

object DslEmpty : DslValue() {
	override fun getType() = DslValueType.Empty
	override fun toString(name: String, option: ProcessOption): String = ""
	override fun equals(other: Any?): Boolean {
		return other is DslEmpty
	}
	override fun hashCode(): Int = 1
}

object DslNull : DslValue() {
	override fun getType() = DslValueType.Null
	override fun toString(name: String, option: ProcessOption): String? = null
	override fun equals(other: Any?): Boolean {
		return other is DslNull
	}
	override fun hashCode(): Int = 0
}

class DslElement(private val name: String, val scope: DslScope) : DslValue() {

	internal val elements = ArrayList<DslValue>()

	fun addValue(value: DslValue) {
		if(value != DslNull) elements.add(value)
	}

	private fun getBeginTagLeft(processOption: ProcessOption): String {
		val left = "<$name"
		val attrs = scope.getFieldStates().filter { it.modifier.isAttribute }
		return if(attrs.isEmpty()) left
		else {
			val attrStr = attrs.mapNotNull {
				try {
					it.getValue(null).toXmlAttributeString(it.name, processOption)
				}
				catch(e: DslFieldNotInitializedException) {
					null
				}
			}
				.joinToString(" ")
			"$left $attrStr"
		}
	}

	private fun getEndTag() = "</$name>"

	override fun pToXml(option: ParseOption, processOption: ProcessOption, outputStream: OutputStream, indentLevel: Int) {
		if(option.shortenEmpty && elements.isEmpty()) {
			if(option.prettyPrint) outputStream.write(option.indent.repeat(indentLevel).toByteArray(option.charset))
			outputStream.write((getBeginTagLeft(processOption) + " />").toByteArray(option.charset))
			return
		}
		if(option.prettyPrint) outputStream.write(option.indent.repeat(indentLevel).toByteArray(option.charset))
		outputStream.write((getBeginTagLeft(processOption) + ">").toByteArray(option.charset))
		if(elements.isNotEmpty()) {
			for(ele in elements) {
				if(option.prettyPrint) outputStream.write(System.lineSeparator().toByteArray(option.charset))
				ele.pToXml(option, processOption, outputStream, indentLevel + 1)
			}
		}
		if(option.prettyPrint && option.endTagNewLine) {
			outputStream.write(System.lineSeparator().toByteArray(option.charset))
			outputStream.write(option.indent.repeat(indentLevel).toByteArray(option.charset))
		}
		outputStream.write(getEndTag().toByteArray(option.charset))
	}

	override fun getType() = DslValueType.Element

	// element serialize will not contain its content, so use hashcode as its id
	override fun toString(name: String, option: ProcessOption): String =
		"<element#${hashCode().toUInt().toString(16)}>"

	override fun equals(other: Any?): Boolean {
		return this === other // must be the same instance
	}

	override fun hashCode(): Int {
		var result = name.hashCode()
		result = 31 * result + scope.hashCode()
		result = 31 * result + elements.hashCode()
		return result
	}

}

open class DslFunction(private val paramNames: List<String>, private val block: BlockContext?) : DslValue() {
	override fun getType() = DslValueType.Function
	override fun toString(name: String, option: ProcessOption): String = "<element#${hashCode().toUInt().toString(16)}>"
	override fun equals(other: Any?): Boolean {
		return other is DslFunction
	}

	override fun hashCode(): Int {
		var result = paramNames.hashCode()
		result = 31 * result + block.hashCode()
		return result
	}
	fun getParamListToMap(list: List<DslValue>, beginToken: Token, endToken: Token): Map<String, DslValue> {
		if(list.size != paramNames.size) throw DslParamNotMatchException(beginToken, endToken, paramNames.size, list.size)
		return paramNames.zip(list).toMap()
	}
	open operator fun invoke(param: Map<String, DslValue>, processOption: ProcessOption, errorHandler: ParseErrorHandler,
	        currentElement: DslElement, currentScope: DslScope): DslValue? {
		block ?: throw IllegalStateException("User function shall not have null block")
		val subScope = DslScope(currentScope, setOf(JumpType.Next::class.java, JumpType.Return::class.java))
		for((name, value) in param) {
			subScope.defineField(name, null, DslFieldModifiers())
			subScope.trySetField(name, null, null, null, value)
		}
		return when(val jmp = XmlDslParser.parseBlock(block, processOption, errorHandler, currentElement, subScope)) {
			JumpType.Next -> null
			is JumpType.Return -> jmp.value
			else -> null
		}
	}
}

class DslType(private val type: DslValueType) : DslValue() {
	override fun getType() = DslValueType.Type
	override fun toString(name: String, option: ProcessOption): String = "<type:${type.name}>"
	override fun equals(other: Any?): Boolean {
		if(this === other) return true
		if(other !is DslType) return false
		return type == other.type
	}
	override fun hashCode(): Int {
		return type.hashCode()
	}
}

class DslSet(val value: Set<DslValue>) : DslValue() {
	override fun getType() = DslValueType.Set
	override fun toString(name: String, option: ProcessOption): String = option.onSetToString(name, value)
	override fun equals(other: Any?): Boolean {
		if(this === other) return true
		if(other !is DslSet) return false
		return value == other.value
	}
	override fun hashCode(): Int {
		return value.hashCode()
	}
}

class DslDict(val value: Map<DslValue, DslValue>) : DslValue() {
	override fun getType() = DslValueType.Dict
	override fun toString(name: String, option: ProcessOption): String = option.onDictToString(name, value)
	override fun equals(other: Any?): Boolean {
		if(this === other) return true
		if(other !is DslDict) return false
		return value == other.value
	}
	override fun hashCode(): Int {
		return value.hashCode()
	}
	fun toPairList(): DslList = DslList(value.map { DslPair(it.key to it.value) })
	operator fun get(key: DslValue): DslValue? = value[key]
}

class DslPair(val value: Pair<DslValue, DslValue>) : DslValue() {
	override fun getType() = DslValueType.Pair
	override fun toString(name: String, option: ProcessOption): String = option.onPairToString(name, value)
	override fun equals(other: Any?): Boolean {
		if(this === other) return true
		if(other !is DslPair) return false
		return value == other.value
	}
	override fun hashCode(): Int = value.hashCode()
	operator fun get(index: Int): DslValue = value.toList()[index]
}

class DslAny(val value: DslValue) : DslValue() {
	override fun getType() = value.getType()
	override fun toString(name: String, option: ProcessOption): String? = value.toString(name, option)
	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is DslAny) return false
		return value == other.value
	}
	override fun hashCode(): Int = value.hashCode()
}

class DslValueState(val name: String, val modifier: DslFieldModifiers) {

	private var pValue: DslValue? = null

	internal fun tryModify(value: DslValue): Boolean {
		if(this.pValue == null || modifier.canModify) {
			this.pValue = value
			return true
		}
		return false
	}

	internal fun forceModify(value: DslValue) {
		this.pValue = value
	}

	fun getValue(symbol: Token?) = pValue ?: throw DslFieldNotInitializedException(symbol, name)

}
