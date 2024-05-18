package net.littlexfish.xmldslparser.server

import org.antlr.v4.runtime.Token

abstract class DslParseException(val beginSymbol: Token?, val endSymbol: Token?, message: String):
	RuntimeException("At ${getSymbolBegin(beginSymbol)} to ${getSymbolEnd(endSymbol)}, $message")

private fun getSymbolBegin(symbol: Token?): String {
	return "[${symbol?.line}:${symbol?.charPositionInLine?.plus(1)}]"
}

private fun getSymbolEnd(symbol: Token?): String {
	return "[${symbol?.line}:${symbol?.charPositionInLine?.plus(2 + symbol.stopIndex - symbol.startIndex)}]"
}

class DslValueOperationException(symbol: Token?, val operation: String, val left: DslValue, val right: DslValue) :
	DslParseException(symbol, symbol, "Cannot \"$operation\" ${right.getType()} to ${left.getType()}")
class DslFieldNotFoundException(symbol: Token?, name: String) :
	DslParseException(symbol, symbol, "Field \"$name\" not found")
class DslFieldAlreadyExistsException(symbol: Token?, name: String) :
	DslParseException(symbol, symbol, "Field \"$name\" already exists")
class DslFieldCannotModifyException(name: String, val stmtBegin: Token?, val stmtEnd: Token?) :
	DslParseException(stmtBegin, stmtEnd, "Field \"$name\" cannot be modified")
class DslFieldNotInitializedException(symbol: Token?, name: String) :
	DslParseException(symbol, symbol, "Field \"$name\" not initialized")
class DslNonLoopJumpException(symbol: Token) :
	DslParseException(symbol, symbol, "Cannot do ${symbol.text} operation outside of loop")
class DslListAccessException(beginSymbol: Token?, endSymbol: Token, val gotType: DslValueType) :
	DslParseException(beginSymbol, endSymbol, "Access list content must use number as index, but got $gotType")
class DslListIndexOutOfBoundsException(beginSymbol: Token, endSymbol: Token, val index: Int, val size: Int) :
	DslParseException(beginSymbol, endSymbol, "List index out of bounds: $index, size: $size")
class DslTypeException(beginSymbol: Token, endSymbol: Token, val expectType: DslValueType, val gotType: DslValueType) :
	DslParseException(beginSymbol, endSymbol, "Expect type $expectType, but got $gotType")
class DslTypesException(beginSymbol: Token, endSymbol: Token, val expectTypes: Set<DslValueType>, val gotType: DslValueType) :
	DslParseException(beginSymbol, endSymbol, "Expect types [${expectTypes.joinToString(", ")}], but got $gotType")

