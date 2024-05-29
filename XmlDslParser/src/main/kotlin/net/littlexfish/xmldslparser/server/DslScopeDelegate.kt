package net.littlexfish.xmldslparser.server

import org.antlr.v4.runtime.Token

class DslScopeDelegate private constructor(private val base: DslScope,
                                           private val inner: DslScope,
                                           private val acceptJumpType: Set<Class<out JumpType>>,
                                           private val acceptField: Set<String>) : DslScope {

	constructor(base: DslScope, acceptJumpType: Set<Class<out JumpType>> = setOf(JumpType.Next::class.java))
		: this(base, DslScopeImpl(base, acceptJumpType), acceptJumpType, base.getAllFieldName())

	override fun hasFieldLocal(name: String): Boolean {
		return inner.hasFieldLocal(name)
	}

	override fun getParent(): DslScope {
		return base
	}

	override fun getDsl(): XmlDsl = base.getDsl()

	override fun trySetField(name: String, symbol: Token?, stmtBegin: Token?, stmtEnd: Token?, value: DslValue) {
		if(hasFieldLocal(name)) {
			inner.trySetField(name, symbol, stmtBegin, stmtEnd, value)
			return
		}
		else if(name in acceptField) {
			base.trySetField(name, symbol, stmtBegin, stmtEnd, value)
		}
		else {
			throw DslFieldNotFoundException(symbol, name)
		}
	}

	override fun defineField(name: String, symbol: Token?, modifiers: DslFieldModifiers) {
		inner.defineField(name, symbol, modifiers)
	}

	override fun getFieldsLocal(): Map<String, DslValueState> {
		return inner.getFieldsLocal()
	}

	override fun getFieldState(name: String, symbol: Token?): DslValueState {
		return if(hasFieldLocal(name)) {
			inner.getFieldState(name, symbol)
		}
		else if(name in acceptField) {
			base.getFieldState(name, symbol)
		}
		else {
			throw DslFieldNotFoundException(symbol, name)
		}
	}

	override fun getFieldStatesLocal(): Collection<DslValueState> {
		return inner.getFieldStatesLocal()
	}

	override fun canDoJump(type: Class<out JumpType>): Boolean {
		return inner.canDoJump(type)
	}

	override fun importScope(scope: DslScope, symbol: Token?) {
		inner.importScope(scope, symbol)
	}

	override fun dump() {
		inner.dump()
	}

	fun copy(): DslScopeDelegate {
		return DslScopeDelegate(base, DslScopeImpl(base, acceptJumpType), acceptJumpType, acceptField)
	}

}