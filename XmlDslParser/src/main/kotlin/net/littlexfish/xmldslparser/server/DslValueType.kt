package net.littlexfish.xmldslparser.server

enum class DslValueType {
	Number, String, Boolean,
	List, Empty, Null,
	Element, Function, Type,
	Set, Dict, Any
}