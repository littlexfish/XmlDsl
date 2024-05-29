package net.littlexfish.xmldslparser.server

import org.antlr.v4.runtime.Token

sealed class JumpType(val name: String) {
	data object Next : JumpType("Next")
	data object Break : JumpType("Break")
	data object Continue : JumpType("Continue")
	data class Return(val value: DslValue?) : JumpType("Return")
}

interface DslScope {
	fun hasFieldLocal(name: String): Boolean
	fun getParent(): DslScope?
	fun hasField(name: String): Boolean {
		if(hasFieldLocal(name))
			return true
		return getParent()?.hasField(name) ?: false
	}
	fun getDsl(): XmlDsl
	fun trySetField(name: String, symbol: Token?, stmtBegin: Token?, stmtEnd: Token?, value: DslValue)
	fun defineField(name: String, symbol: Token?, modifiers: DslFieldModifiers)
	fun getAllFieldName(): Set<String> {
		val set = HashSet<String>()
		getFieldsLocal().keys.forEach(set::add)
		getParent()?.getAllFieldName()?.forEach(set::add)
		return set
	}
	fun getField(name: String, symbol: Token?): DslValue {
		return getFieldState(name, symbol).getValue(symbol)
	}
	fun getFieldsLocal(): Map<String, DslValueState>
	fun getFieldState(name: String, symbol: Token?): DslValueState
	fun getFieldStatesLocal(): Collection<DslValueState>
	fun canDoJump(type: Class<out JumpType>): Boolean
	fun importScope(scope: DslScope, symbol: Token?)
	fun dump()
}

class DslScopeImpl(private val parent: DslScope? = null, private val acceptJumpType: Set<Class<out JumpType>> = setOf(JumpType.Next::class.java), private val dsl: XmlDsl = parent!!.getDsl()) : DslScope {

	private val fields = HashMap<String, DslValueState>()

	override fun getDsl(): XmlDsl = dsl

	override fun hasFieldLocal(name: String): Boolean {
		return fields.containsKey(name)
	}

	override fun getParent(): DslScope? {
		return parent
	}

	override fun trySetField(name: String, symbol: Token?, stmtBegin: Token?, stmtEnd: Token?, value: DslValue) {
		if(fields.containsKey(name)) {
			if(!fields[name]!!.tryModify(value))
				throw DslFieldCannotModifyException(name, stmtBegin, stmtEnd)
			fields[name]!!.tryModify(value)
			return
		}
		parent?.trySetField(name, symbol, stmtBegin, stmtEnd, value) ?: throw DslFieldNotFoundException(symbol, name)
	}

	override fun defineField(name: String, symbol: Token?, modifiers: DslFieldModifiers) {
		if(fields.containsKey(name))
			throw DslFieldAlreadyExistsException(symbol, name)
		fields[name] = DslValueState(name, modifiers)
	}

	override fun getFieldState(name: String, symbol: Token?): DslValueState {
		if(fields.containsKey(name))
			return fields[name]!!
		return parent?.getFieldState(name, symbol) ?: throw DslFieldNotFoundException(symbol, name)
	}

	override fun getFieldStatesLocal() = fields.values

	override fun canDoJump(type: Class<out JumpType>) = acceptJumpType.contains(type)

	override fun importScope(scope: DslScope, symbol: Token?) {
		scope.getFieldsLocal().values.forEach {
			if(it.modifier.isExport) {
				try {
					defineField(it.name, symbol, it.modifier.copyWithoutExport())
					trySetField(it.name, symbol, symbol, symbol, it.getValue(symbol))
				}
				catch(ignore: DslParseException) {}
			}
		}
	}

	override fun getFieldsLocal(): Map<String, DslValueState> = fields

	override fun dump() {
		fields.values.forEach(DslValueState::dump)
	}

}