package net.littlexfish.xmldslparser.server

import org.antlr.v4.runtime.Token
import java.io.OutputStream

sealed class DslValue {

	abstract fun getType(): String

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
	override fun getType(): String = "number"
	override fun toString(name: String, option: ProcessOption): String = value.toString().removeSuffix(".0")
	override fun equals(other: Any?): Boolean {
		if(this === other) return true
		if(other !is DslNumber) return false
		return value == other.value
	}
	override fun hashCode(): Int {
		return value.hashCode()
	}
}

class DslString(val value: String) : DslValue() {
	override fun getType(): String = "string"
	override fun toString(name: String, option: ProcessOption): String = value
	override fun equals(other: Any?): Boolean {
		if(this === other) return true
		if(other !is DslString) return false
		return value == other.value
	}
	override fun hashCode(): Int {
		return value.hashCode()
	}
}

class DslBoolean(val value: Boolean) : DslValue() {
	override fun getType(): String = "boolean"
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
	override fun getType(): String = "list"
	override fun toString(name: String, option: ProcessOption): String = option.onListToString(name, value)
	override fun equals(other: Any?): Boolean {
		if(this === other) return true
		if(other !is DslList) return false
		return value == other.value
	}
	override fun hashCode(): Int {
		return value.hashCode()
	}
}

object DslEmpty : DslValue() {
	override fun getType(): String = "empty"
	override fun toString(name: String, option: ProcessOption): String = ""
	override fun equals(other: Any?): Boolean {
		return other is DslEmpty
	}
	override fun hashCode(): Int = 1
}

object DslNull : DslValue() {
	override fun getType(): String = "null"
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
			val attrStr = attrs.mapNotNull { it.value.toXmlAttributeString(it.name, processOption) }
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

	override fun getType(): String = "element"

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

class DslValueState(val name: String, private val defineSymbol: Token?, val modifier: DslFieldModifiers) {

	private var pValue: DslValue? = null
	val value: DslValue
		get() = pValue ?: throw DslFieldNotInitializedException(defineSymbol, name)

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

}
