package net.littlexfish.xmldslparser.server

class DslFieldModifiers(private val state: FieldState = FieldState.Block) {

	enum class FieldState {
		Block, Modify, Attribute
	}

	val canModify: Boolean
		get() = state != FieldState.Block
	val isAttribute: Boolean
		get() = state == FieldState.Attribute


}