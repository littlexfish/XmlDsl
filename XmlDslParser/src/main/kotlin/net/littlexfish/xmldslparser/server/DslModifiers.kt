package net.littlexfish.xmldslparser.server

class DslFieldModifiers(private val state: FieldState = FieldState.Block, private val export: Boolean = false) {

	enum class FieldState {
		Block, Modify, Attribute
		;
		fun toDecl(): String = when(this) {
			Block -> "val"
			Modify -> "var"
			Attribute -> "attr"
		}
	}

	val canModify: Boolean
		get() = state != FieldState.Block
	val isAttribute: Boolean
		get() = state == FieldState.Attribute
	val isExport: Boolean
		get() = export

	fun dumpString(): String {
		val ret = state.toDecl()
		if(export) return "export $ret"
		return ret
	}

	fun copyWithoutExport(): DslFieldModifiers {
		return DslFieldModifiers(state, false)
	}

}