package net.littlexfish.xmldslparser.server

import org.antlr.v4.runtime.Token

enum class JumpType {
	Next, Break, Continue
}

class DslScope(private val parent: DslScope? = null, private val acceptJumpType: Set<JumpType> = setOf(JumpType.Next)) {

	private val fields = HashMap<String, DslValueState>()

	fun trySetField(name: String, symbol: Token?, stmtBegin: Token?, stmtEnd: Token?, value: DslValue) {
		if(fields.containsKey(name)) {
			if(!fields[name]!!.tryModify(value))
				throw DslFieldCannotModifyException(name, stmtBegin, stmtEnd)
			fields[name]!!.tryModify(value)
			return
		}
		parent?.trySetField(name, symbol, stmtBegin, stmtEnd, value) ?: throw DslFieldNotFoundException(symbol, name)
	}

	fun defineField(name: String, symbol: Token?, modifiers: DslFieldModifiers) {
		if(fields.containsKey(name))
			throw DslFieldAlreadyExistsException(symbol, name)
		fields[name] = DslValueState(name, symbol, modifiers)
	}

	fun getField(name: String, symbol: Token?): DslValue {
		return getFieldState(name, symbol).value
	}

	fun getFieldState(name: String, symbol: Token?): DslValueState {
		if(fields.containsKey(name))
			return fields[name]!!
		return parent?.getFieldState(name, symbol) ?: throw DslFieldNotFoundException(symbol, name)
	}

	internal fun getFieldStates() = fields.values

	fun canDoJump(type: JumpType) = acceptJumpType.contains(type)

}