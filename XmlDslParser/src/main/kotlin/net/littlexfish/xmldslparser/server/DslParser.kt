package net.littlexfish.xmldslparser.server

import net.littlexfish.xmldslparser.antlr.XmlDslParser.*
import net.littlexfish.xmldslparser.server.builtin.*
import net.littlexfish.xmldslparser.version
import org.antlr.v4.runtime.Token
import java.io.File
import java.io.OutputStream
import java.nio.charset.Charset

data class ParseOption(
	val prettyPrint: Boolean = false,
	val indent: String = "\t",
	val shortenEmpty: Boolean = false,
	val endTagNewLine: Boolean = true,
	val charset: Charset = Charsets.UTF_8,
)

data class ProcessOption(
	val onListToString: (String /* name */, List<DslValue> /* list */) -> String = { _, list ->
		"[${list.mapNotNull { it.toString("", ProcessOption()) }.joinToString(", ")}]"
	},
	val onPairToString: (String /* name */, Pair<DslValue, DslValue> /* list */) -> String = { _, pair ->
		"(${pair.first.toString("", ProcessOption())}, ${pair.second.toString("", ProcessOption())})"
	},
	val onDictToString: (String /* name */, Map<DslValue, DslValue> /* dict */) -> String = { _, dict ->
		"{${dict.map { (k, v) -> "${k.toString("", ProcessOption())}: ${v.toString("", ProcessOption())}" }.joinToString(", ")}}"
	},
	val onSetToString: (String /* name */, Set<DslValue> /* set */) -> String = { _, set ->
		"<${set.mapNotNull { it.toString("", ProcessOption()) }.joinToString(", ")}>"
	}
)

val HtmlProcessOption = ProcessOption(
	onListToString = onListToString@{ name, list ->
		return@onListToString processHtmlToString(name, list, "[%s]")
	},
	onDictToString = onDictToString@{ name, dict ->
		return@onDictToString when(name) {
			"style" -> dict.mapNotNull { (k, v) -> "${k.toString("", ProcessOption())}: ${v.toString("", ProcessOption())}" }.joinToString("; ")
			else -> "{${dict.map { (k, v) -> "${k.toString("", ProcessOption())}: ${v.toString("", ProcessOption())}" }.joinToString(", ")}}"
		}
	},
	onSetToString = onSetToString@{ name, set ->
		return@onSetToString processHtmlToString(name, set.toList(), "<%s>")
	}
)

private fun processHtmlToString(name: String, list: List<DslValue>, unprocessFormat: String): String {
	return when (name) {
		"class" -> list.mapNotNull { it.toString("", ProcessOption()) }.joinToString(" ")
		"style" -> list.mapNotNull { it.toString("", ProcessOption()) }.joinToString("; ")
		else -> unprocessFormat.format(list.mapNotNull { it.toString("", ProcessOption()) }.joinToString(", "))
	}
}

class ParseErrorHandler {
	private val detailList = ArrayList<ParseErrorDetail>()
	private var listener: (ParseErrorDetail) -> Unit = { it.dslParseException.printStackTrace() }

	fun setListener(listener: (ParseErrorDetail) -> Unit) {
		this.listener = listener
	}

	private fun addDetail(detail: ParseErrorDetail) {
		detailList.add(detail)
		listener(detail)
	}

	internal fun handleException(name: String, dslParseException: DslParseException) {
		addDetail(ParseErrorDetail(name, dslParseException))
	}

	fun getDetails() = detailList.toList()

}

data class ParseErrorDetail(val text: String, val dslParseException: DslParseException)


private fun createGlobalScope(env: Map<String, String?>): DslScope {
	return DslScope().apply {
		// pre-defined field
		addGlobalField("VERSION", DslString(version))
		addGlobalField("JAVA_VERSION", DslString(System.getProperty("java.version")))
		addGlobalField("OS", DslString(System. getProperty("os.name")))
		addGlobalField("ARCH", DslString(System.getProperty("os.arch")))
		addGlobalField("FILE_SEPARATOR", DslString(File.separator))
		addGlobalField("PATH_SEPARATOR", DslString(File.pathSeparator))
		addGlobalField("LINE_SEPARATOR", DslString(System.lineSeparator()))
		addGlobalField("USER_NAME", DslString(System.getProperty("user.name")))
		addGlobalField("USER_HOME", DslString(System.getProperty("user.home")))
		addGlobalField("DIR", DslString(System.getProperty("user.dir")))
		addGlobalField("PI", DslNumber(Math.PI))
		// type field, to prevent code be detected as identifier
		for(type in DslValueType.entries) {
			addGlobalField(type.name.lowercase(), DslType(type))
		}
		// pre-defined function
		addGlobalField("print", PrintFunc)
		addGlobalField("panic", PanicFunc)
		addGlobalField("pairOf", PairFunc)
		addGlobalField("pairs", PairsFunc)
		addGlobalField("keys", KeysFunc)
		addGlobalField("values", ValuesFunc)
		addGlobalField("len", LenFunc)
		addGlobalField("indexOf", IndexOfFunc)
		addGlobalField("join", JoinFunc)
		addGlobalField("split", SplitFunc)
		addGlobalField("replace", ReplaceFunc)
		addGlobalField("trim", TrimFunc)
		addGlobalField("lower", LowerFunc)
		addGlobalField("upper", UpperFunc)
		addGlobalField("typeOf", TypeOfFunc)
		addGlobalField("toInt", ToIntFunc)
		addGlobalField("toString", ToStringFunc)
		addGlobalField("format", FormatFunc)
		addGlobalField("toList", ToListFunc)
		addGlobalField("toSet", ToSetFunc)
		addGlobalField("floor", FloorFunc)
		addGlobalField("ceil", CeilFunc)
		addGlobalField("round", RoundFunc)
		addGlobalField("abs", AbsFunc)
		addGlobalField("sqrt", SqrtFunc)
		addGlobalField("pow", PowFunc)
		addGlobalField("toRad", ToRadFunc)
		addGlobalField("toDeg", ToDegFunc)
		addGlobalField("sin", SinFunc)
		addGlobalField("cos", CosFunc)
		addGlobalField("tan", TanFunc)
		addGlobalField("asin", AsinFunc)
		addGlobalField("acos", AcosFunc)
		addGlobalField("atan", AtanFunc)
		addGlobalField("log", LogFunc)
		addGlobalField("log10", Log10Func)
		addGlobalField("exp", ExpFunc)
		addGlobalField("random", RandomFunc)
		addGlobalField("randomRange", RandomRangeFunc)
		// user field
		for((key, value) in env) {
			addGlobalField(key, value?.let { DslString(it) } ?: DslNull)
		}
	}
}

private fun DslScope.addGlobalField(name: String, value: DslValue) {
	defineField(name, null, DslFieldModifiers(DslFieldModifiers.FieldState.Block))
	trySetField(name, null, null, null, value)
}

class XmlDsl(private val processOption: ProcessOption, env: Map<String, String?>) {

	internal val root = DslElement("<root>", DslScope(createGlobalScope(env)))
	internal val rootScope: DslScope
		get() = root.scope

	fun toXml(option: ParseOption, outputStream: OutputStream) {
		for(ele in root.elements) {
			ele.toXml(option, processOption, outputStream)
			if(option.prettyPrint) outputStream.write(System.lineSeparator().toByteArray(option.charset))
		}
	}

}

object XmlDslParser {

	fun parseDslFile(ctx: DslFileContext, processOption: ProcessOption, errorHandler: ParseErrorHandler, env: Map<String, String?>): XmlDsl {
		val root = XmlDsl(processOption, env)
		parseStatements(ctx.statements(), processOption, errorHandler, root.root, root.rootScope)
		return root
	}

	private fun parseStatements(ctx: StatementsContext, processOption: ProcessOption, errorHandler: ParseErrorHandler,
	                            currentElement: DslElement, currentScope: DslScope): JumpType {
		val stmts = ctx.statement()
		for(stmt in stmts) {
			stmt.declaration()?.let {
				parseDeclaration(it, processOption, errorHandler, currentElement, currentScope)
			}
			stmt.assignmentExpression()?.let {
				parseAssignmentExpression(it, processOption, errorHandler, currentElement, currentScope)
			}
			stmt.expression()?.let {
				val expr = parseExpression(it, processOption, errorHandler, currentElement, currentScope)
				currentElement.addValue(expr)
			}
			stmt.flowExpression()?.let {
				val jmp = parseFlowExpression(it, processOption, errorHandler, currentElement, currentScope)
				if(jmp != JumpType.Next) return jmp
			}
		}
		return JumpType.Next
	}

	private fun parseDeclaration(ctx: DeclarationContext, processOption: ProcessOption, errorHandler: ParseErrorHandler,
	                             currentElement: DslElement, currentScope: DslScope) {
		ctx.propertyDeclaration()?.let {
			val state = it.dslFieldModifierState()
			for(p in it.singlePropertyDecl()) {
				val id = parseIdentifier(p.identifier())
				val symbol = id.first
				val name = id.second
				try {
					currentScope.defineField(name, symbol, DslFieldModifiers(state))
				}
				catch(e: DslParseException) {
					errorHandler.handleException(name, e)
				}
				if(p.ASSIGNMENT() != null) {
					val expr = parseExpression(p.expression(), processOption, errorHandler, currentElement, currentScope)
					try {
						currentScope.trySetField(name, symbol, p.expression().start, p.expression().stop, expr)
					}
					catch(e: DslParseException) {
						errorHandler.handleException(name, e)
					}
				}
			}
		}
		ctx.functionDeclaration()?.let {
			parseFunctionDeclaration(it, errorHandler, currentScope)
		}
	}

	private fun PropertyDeclarationContext.dslFieldModifierState(): DslFieldModifiers.FieldState {
		return if(VAR() != null) DslFieldModifiers.FieldState.Modify
		else if(ATTR() != null) DslFieldModifiers.FieldState.Attribute
		else DslFieldModifiers.FieldState.Block
	}

	private fun parseAssignmentExpression(ctx: AssignmentExpressionContext, processOption: ProcessOption,
	                                      errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope) {
		val assignment = ctx.assignmentOperator()
		val expr = parseExpression(ctx.expression(), processOption, errorHandler, currentElement, currentScope)
		val id = parseIdentifier(ctx.identifier())
		val symbol = id.first
		val name = id.second
		if(ctx.contentAccess() != null) {
			val left = currentScope.getFieldState(name, symbol)
			val ex = ctx.contentAccess().expression()
			val listIdx = parseExpression(ex, processOption, errorHandler, currentElement, currentScope)
			when(left.getValue(symbol)) {
				is DslList, is DslString, is DslPair -> {
					if(listIdx !is DslNumber) {
						errorHandler.handleException(
							ex.text, DslTypeException(ex.start, ex.stop, DslValueType.Number,
								listIdx.getType()))
						return
					}
					if(listIdx.isNotInt()) {
						errorHandler.handleException(
							ex.text, DslNumberNotIntegerException(ex.start, ex.stop, listIdx.value))
						return
					}
					val idx = listIdx.value.toInt()
					val size = when(left.getValue(symbol)) {
						is DslList -> (left.getValue(symbol) as DslList).value.size
						is DslPair -> 2
						else -> 0
					}
					if(idx < 0 || idx >= size) {
						errorHandler.handleException(
							ex.text, DslIndexOutOfBoundsException(
								ex.start, ex.stop, idx, size))
						return
					}
					when(left.getValue(symbol)) {
						is DslList -> {
							val newList = (left.getValue(symbol) as DslList).value.toMutableList()
							newList[idx] = expr
							left.forceModify(DslList(newList))
						}
						is DslPair -> {
							var newPair = (left.getValue(symbol) as DslPair).value
							if(idx == 0) newPair = expr to newPair.second
							else newPair.first to expr
							left.forceModify(DslPair(newPair))
						}
						else -> { /* do nothing */ }
					}
				}
				is DslDict -> {
					val newDict = (left.getValue(symbol) as DslDict).value.toMutableMap()
					newDict[listIdx] = expr
					left.forceModify(DslDict(newDict))
				}
				else -> {
					errorHandler.handleException(
						name, DslTypesException(ex.start, ex.stop,
							setOf(DslValueType.List, DslValueType.String, DslValueType.Pair, DslValueType.Dict),
							left.getValue(symbol).getType()))
					return
				}
			}
		}
		if(assignment.ASSIGNMENT() != null) {
			try {
				currentScope.trySetField(name, symbol, ctx.expression().start, ctx.expression().stop, expr)
			}
			catch(e: DslParseException) {
				errorHandler.handleException(name, e)
			}
		}
		else {
			val originalValue = currentScope.getField(name, symbol)
			try {
				currentScope.trySetField(name, symbol, ctx.expression().start,
					ctx.expression().stop, when(assignment.text) {
						"+=" -> DslOperation.tryDoPlus(originalValue, assignment.ADD_ASSIGNMENT().symbol, expr, processOption)
						"-=" -> DslOperation.tryDoMinus(originalValue, assignment.SUB_ASSIGNMENT().symbol, expr)
						"*=" -> DslOperation.tryDoTimes(originalValue, assignment.MULT_ASSIGNMENT().symbol, expr)
						"/=" -> DslOperation.tryDoDiv(originalValue, assignment.DIV_ASSIGNMENT().symbol, expr)
						"%=" -> DslOperation.tryDoRem(originalValue, assignment.MOD_ASSIGNMENT().symbol, expr)
						else -> originalValue
				})
			}
			catch(e: DslParseException) {
				errorHandler.handleException(name, e)
			}
		}
	}

	private fun parseFlowExpression(ctx: FlowExpressionContext, processOption: ProcessOption, errorHandler: ParseErrorHandler,
	                                currentElement: DslElement, currentScope: DslScope): JumpType {
		ctx.ifExpression()?.let {
			val expr = parseExpression(it.expression(), processOption, errorHandler, currentElement, currentScope)
			if(expr !is DslBoolean) {
				errorHandler.handleException(it.IF().symbol.text,
					DslTypeException(it.expression().start, it.expression().stop,
						DslValueType.Boolean, expr.getType()))
				return JumpType.Next
			}
			if(expr.value) {
				val jmp = parseBlock(it.block(0), processOption, errorHandler, currentElement, currentScope)
				if(jmp != JumpType.Next) return jmp
			}
			else if(it.ELSE() != null) {
				val jmp = parseBlock(it.block(1), processOption, errorHandler, currentElement, currentScope)
				if(jmp != JumpType.Next) return jmp
			}
			return JumpType.Next
		}
		ctx.jumpExpression()?.let {
			val type = if(it.BREAK() != null) JumpType.Break
			else if(it.CONTINUE() != null) JumpType.Continue
			else {
				if(it.expression() == null) JumpType.Return(null)
				else {
					val expr = parseExpression(it.expression(), processOption, errorHandler, currentElement, currentScope)
					JumpType.Return(expr)
				}
			}
			val symbol = ctx.jumpExpression().BREAK()?.symbol ?: ctx.jumpExpression().CONTINUE()?.symbol ?: ctx.jumpExpression().RETURN().symbol
			if(!currentScope.canDoJump(type::class.java))
				errorHandler.handleException(type.name.lowercase(), DslNonLoopJumpException(symbol))
			return type
		}
		ctx.loopExpression()?.let {
			it.forExpression()?.let { f -> parseForExpression(f, processOption, errorHandler, currentElement, currentScope) }
			it.whileExpression()?.let { w ->
				var expr = parseExpression(w.expression(), processOption, errorHandler, currentElement, currentScope)
				while(true) {
					if(expr !is DslBoolean) {
						errorHandler.handleException(w.WHILE().symbol.text,
							DslTypeException(w.expression().start, w.expression().stop,
								DslValueType.Boolean, expr.getType()))
						break
					}
					if(!expr.value) break
					val subScope = DslScope(currentScope, setOf(JumpType.Next::class.java,
						JumpType.Break::class.java, JumpType.Continue::class.java))
					if(parseBlock(w.block(), processOption, errorHandler, currentElement, subScope) == JumpType.Break) break
					expr = parseExpression(w.expression(), processOption, errorHandler, currentElement, currentScope)
				}
			}
		}
		return JumpType.Next
	}

	private fun parseForExpression(ctx: ForExpressionContext, processOption: ProcessOption,
	                               errorHandler: ParseErrorHandler, currentElement: DslElement,
	                               currentScope: DslScope) {
		val expr = parseExpression(ctx.expression(), processOption, errorHandler, currentElement, currentScope)
		val id = parseIdentifier(ctx.identifier())
		val symbol = id.first
		val name = id.second
		val list = when(expr) {
			is DslList -> expr
			is DslDict -> expr.toPairList()
			else -> {
				errorHandler.handleException(ctx.FOR().symbol.text,
					DslTypeException(ctx.expression().start, ctx.expression().stop,
						DslValueType.List, expr.getType()))
				return
			}
		}
		for(dslValue in list.value) {
			val subScope = DslScope(currentScope, setOf(JumpType.Next::class.java,
				JumpType.Break::class.java, JumpType.Continue::class.java))
			subScope.defineField(name, symbol, DslFieldModifiers(DslFieldModifiers.FieldState.Block))
			subScope.trySetField(name, symbol, ctx.expression().start, ctx.expression().stop, dslValue)
			if(parseBlock(ctx.block(), processOption, errorHandler, currentElement, subScope) == JumpType.Break) break
		}
	}

	private fun parseElementDeclaration(ctx: ElementDeclarationContext, processOption: ProcessOption,
	                                    errorHandler: ParseErrorHandler, currentScope: DslScope): DslElement {
		val name = parseIdentifier(ctx.identifier()).second
		val subScope = DslScope(currentScope)
		val element = DslElement(name, subScope)
		parseBlock(ctx.block(), processOption, errorHandler, element, subScope)
		return element
	}

	internal fun parseBlock(ctx: BlockContext, processOption: ProcessOption, errorHandler: ParseErrorHandler,
	                       currentElement: DslElement, subScope: DslScope): JumpType {
		return parseStatements(ctx.statements(), processOption, errorHandler, currentElement, subScope)
	}


	private fun parseExpression(ctx: ExpressionContext, processOption: ProcessOption, errorHandler: ParseErrorHandler,
	                            currentElement: DslElement, currentScope: DslScope): DslValue {
		ctx.disjunction()?.let {
			return parseDisjunction(it, processOption, errorHandler, currentElement, currentScope)
		}
		ctx.elementDeclaration()?.let {
			return parseElementDeclaration(it, processOption, errorHandler, currentScope)
		}
		return DslNull // here should not be reached
	}

	private fun parseDisjunction(ctx: DisjunctionContext, processOption: ProcessOption, errorHandler: ParseErrorHandler,
	                             currentElement: DslElement, currentScope: DslScope): DslValue {
		var expr = parseConjunction(ctx.conjunction(0), processOption, errorHandler, currentElement, currentScope)
		if(ctx.DISJ().isNotEmpty() && expr !is DslBoolean) {
			errorHandler.handleException(ctx.conjunction(0).text,
				DslTypeException(ctx.conjunction(0).start, ctx.conjunction(0).stop,
					DslValueType.Boolean, expr.getType()))
			return DslNull
		}
		for(i in 0..<ctx.DISJ().size) {
			val right = parseConjunction(ctx.conjunction(i + 1), processOption, errorHandler, currentElement, currentScope)
			if(right !is DslBoolean) {
				errorHandler.handleException(ctx.conjunction(i + 1).text,
					DslTypeException(ctx.conjunction(i + 1).start, ctx.conjunction(i + 1).stop,
						DslValueType.Boolean, right.getType()))
				return DslNull
			}
			expr = DslBoolean((expr as DslBoolean).value || right.value)
		}
		return expr
	}

	private fun parseConjunction(ctx: ConjunctionContext, processOption: ProcessOption, errorHandler: ParseErrorHandler,
	                             currentElement: DslElement, currentScope: DslScope): DslValue {
		var expr = parseEqualityComparison(ctx.equalityComparison(0), processOption, errorHandler, currentElement, currentScope)
		if(ctx.CONJ().isNotEmpty() && expr !is DslBoolean) {
			errorHandler.handleException(ctx.equalityComparison(0).text,
				DslTypeException(ctx.equalityComparison(0).start, ctx.equalityComparison(0).stop,
					DslValueType.Boolean, expr.getType()))
			return DslNull
		}
		for(i in 0..<ctx.CONJ().size) {
			val right = parseEqualityComparison(ctx.equalityComparison(i + 1), processOption, errorHandler, currentElement, currentScope)
			if(right !is DslBoolean) {
				errorHandler.handleException(ctx.equalityComparison(i + 1).text,
					DslTypeException(ctx.equalityComparison(i + 1).start, ctx.equalityComparison(i + 1).stop,
						DslValueType.Boolean, right.getType()))
				return DslNull
			}
			expr = DslBoolean((expr as DslBoolean).value && right.value)
		}
		return expr
	}

	private fun parseEqualityComparison(ctx: EqualityComparisonContext, processOption: ProcessOption, errorHandler: ParseErrorHandler,
	                                    currentElement: DslElement, currentScope: DslScope): DslValue {
		val left = parseComparison(ctx.comparison(0), processOption, errorHandler, currentElement, currentScope)
		if(ctx.equalityOperation() != null) {
			val right = parseComparison(ctx.comparison(1), processOption, errorHandler, currentElement, currentScope)
			val result = when(ctx.equalityOperation().text) {
				"==" -> left == right
				"!=" -> left != right
				else -> false
			}
			return DslBoolean(result)
		}
		return left
	}

	private fun parseComparison(ctx: ComparisonContext, processOption: ProcessOption, errorHandler: ParseErrorHandler,
								currentElement:DslElement, currentScope: DslScope): DslValue {
		val left = parseInExpression(ctx.inExpression(0), processOption, errorHandler, currentElement, currentScope)
		if(ctx.comparisonOperator() != null) {
			val right = parseInExpression(ctx.inExpression(1), processOption, errorHandler, currentElement, currentScope)
			if(left !is DslNumber || right !is DslNumber) {
				val idx = if(left !is DslNumber) 0 else 1
				val text = ctx.inExpression(idx).text
				val start = ctx.inExpression(idx).start
				val stop = ctx.inExpression(idx).stop
				errorHandler.handleException(text,
					DslTypeException(start, stop, DslValueType.Number, if(idx == 0) left.getType() else right.getType()))
				return DslNull
			}
			val result = when(ctx.comparisonOperator().text) {
				"<" -> left.value < right.value
				"<=" -> left.value <= right.value
				">" -> left.value > right.value
				">=" -> left.value >= right.value
				else -> false
			}
			return DslBoolean(result)
		}
		return left
	}

	private fun parseInExpression(ctx: InExpressionContext, processOption: ProcessOption, errorHandler: ParseErrorHandler,
	                              currentElement: DslElement, currentScope: DslScope): DslValue {
		val left = parseRangeExpression(ctx.rangeExpression(0), processOption, errorHandler, currentElement, currentScope)
		if(ctx.inOperator() != null) {
			val right = parseRangeExpression(ctx.rangeExpression(1), processOption, errorHandler, currentElement, currentScope)
			return when(right) {
				is DslList -> {
					if(ctx.inOperator().IN() != null) {
						DslBoolean(left in right.value)
					}
					else {
						DslBoolean(left !in right.value)
					}
				}
				is DslSet -> {
					if(ctx.inOperator().IN() != null) {
						DslBoolean(left in right.value)
					}
					else {
						DslBoolean(left !in right.value)
					}
				}
				is DslString -> {
					if(left !is DslString) {
						errorHandler.handleException(ctx.rangeExpression(0).text,
							DslTypeException(ctx.rangeExpression(0).start, ctx.rangeExpression(0).stop,
								DslValueType.String, left.getType()))
						return DslNull
					}
					if(ctx.inOperator().IN() != null) {
						DslBoolean(left.value in right.value)
					}
					else {
						DslBoolean(left.value !in right.value)
					}
				}
				is DslDict -> {
					if(ctx.inOperator().IN() != null) {
						DslBoolean(left in right.value)
					}
					else {
						DslBoolean(left !in right.value)
					}
				}
				else -> {
					errorHandler.handleException(ctx.rangeExpression(1).text,
						DslTypesException(ctx.rangeExpression(1).start, ctx.rangeExpression(1).stop,
							setOf(DslValueType.List, DslValueType.Set, DslValueType.String,
								DslValueType.Dict), right.getType()))
					DslNull
				}
			}
		}
		return left
	}

	private fun parseRangeExpression(ctx: RangeExpressionContext, processOption: ProcessOption,
	                                 errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		val left = parseAdditiveExpression(ctx.additiveExpression(0), processOption, errorHandler, currentElement, currentScope)
		if(ctx.RANGE() != null) {
			val right = parseAdditiveExpression(ctx.additiveExpression(1), processOption, errorHandler, currentElement, currentScope)
			if(left !is DslNumber) {
				val le = ctx.additiveExpression(0)
				errorHandler.handleException(le.text,
					DslTypeException(le.start, le.stop, DslValueType.Number, left.getType()))
				return DslNull
			}
			if(right !is DslNumber) {
				val re = ctx.additiveExpression(1)
				errorHandler.handleException(re.text,
					DslTypeException(re.start, re.stop, DslValueType.Number, right.getType()))
				return DslNull
			}
			if(left.isNotInt()) {
				val le = ctx.additiveExpression(0)
				errorHandler.handleException(le.text,
					DslNumberNotIntegerException(le.start, le.stop, left.value))
				return DslNull
			}
			if(right.isNotInt()) {
				val re = ctx.additiveExpression(1)
				errorHandler.handleException(re.text,
					DslNumberNotIntegerException(re.start, re.stop, right.value))
				return DslNull
			}
			val begin = left.value.toInt()
			val end = right.value.toInt()
			val list = (begin..<end).toList().map { DslNumber(it.toDouble()) }
			return DslList(list)
		}
		return left
	}

	private fun parseAdditiveExpression(ctx: AdditiveExpressionContext, processOption: ProcessOption,
	                                    errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		var expr = parseMultiplicativeExpression(ctx.multiplicativeExpression(0), processOption, errorHandler, currentElement, currentScope)
		for(i in 0..<ctx.additiveOperator().size) {
			val right = parseMultiplicativeExpression(ctx.multiplicativeExpression(i + 1), processOption,
				errorHandler, currentElement, currentScope)
			val op = ctx.additiveOperator(i)
			try {
				expr = when(op.text) {
					"+" -> DslOperation.tryDoPlus(expr, op.ADD().symbol, right, processOption)
					"-" -> DslOperation.tryDoMinus(expr, op.SUB().symbol, right)
					else -> expr
				}
			}
			catch(e: DslParseException) {
				errorHandler.handleException(op.text, e)
				return DslNull
			}
		}
		return expr
	}

	private fun parseMultiplicativeExpression(ctx: MultiplicativeExpressionContext, processOption: ProcessOption,
	                                          errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		var expr = parsePrefixUnaryExpression(ctx.prefixUnaryExpression(0), processOption, errorHandler, currentElement, currentScope)

		for(i in 0..<ctx.multiplicativeOperation().size) {
			val right = parsePrefixUnaryExpression(ctx.prefixUnaryExpression(i + 1), processOption, errorHandler, currentElement, currentScope)
			val op = ctx.multiplicativeOperation(i)
			try {
				expr = when(op.text) {
					"*" -> DslOperation.tryDoTimes(expr, op.MULT().symbol, right)
					"/" -> DslOperation.tryDoDiv(expr, op.DIV().symbol, right)
					"%" -> DslOperation.tryDoRem(expr, op.MOD().symbol, right)
					else -> expr
				}
			}
			catch(e: DslParseException) {
				errorHandler.handleException(op.text, e)
				return DslNull
			}
		}
		return expr
	}

	private fun parsePrefixUnaryExpression(ctx: PrefixUnaryExpressionContext, processOption: ProcessOption,
	                                       errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		var expr = parsePostfixUnaryExpression(ctx.postfixUnaryExpression(), processOption, errorHandler, currentElement, currentScope)
		val ops = ctx.prefixUnaryOperation()
		for(op in ops) {
			expr = when(op.text) {
				"+" -> when(expr) {
					is DslNumber -> expr
					is DslBoolean -> DslNumber(if(expr.value) 1.0 else 0.0)
					is DslString -> DslNumber(expr.value.toDouble())
					else -> {
						errorHandler.handleException(op.ADD().text,
							DslTypesException(ctx.postfixUnaryExpression().start,
								ctx.postfixUnaryExpression().stop,
								setOf(DslValueType.Number, DslValueType.Boolean, DslValueType.String),
								expr.getType()))
						return DslNull
					}
				}
				"-" -> when(expr) {
					is DslNumber -> DslNumber(-expr.value)
					is DslBoolean -> DslNumber(if(expr.value) -1.0 else -0.0)
					is DslString -> DslNumber(-expr.value.toDouble())
					else -> {
						errorHandler.handleException(op.SUB().text,
							DslTypesException(ctx.postfixUnaryExpression().start,
								ctx.postfixUnaryExpression().stop,
								setOf(DslValueType.Number, DslValueType.Boolean, DslValueType.String),
								expr.getType()))
						return DslNull
					}
				}
				"!" -> when(expr) {
					is DslBoolean -> DslBoolean(!expr.value)
					else -> {
						errorHandler.handleException(op.EXCL().text,
							DslTypeException(ctx.postfixUnaryExpression().start,
								ctx.postfixUnaryExpression().stop,
								DslValueType.Boolean, expr.getType()))
						return DslNull
					}
				}
				else -> expr
			}
		}
		return expr
	}

	private fun parsePostfixUnaryExpression(ctx: PostfixUnaryExpressionContext, processOption: ProcessOption,
	                                        errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		val atomic = parseAtomicExpression(ctx.atomicExpression(), processOption, errorHandler, currentElement, currentScope)
		ctx.postfixUnaryOperation()?.let { c ->
			c.contentAccess()?.let { l ->
				val expr = l.expression()
				val listIdx = parseExpression(expr, processOption, errorHandler, currentElement, currentScope)
				when(atomic) {
					is DslList, is DslString, is DslPair -> {
						if(listIdx !is DslNumber) {
							errorHandler.handleException(
								expr.text,
								DslTypeException(
									expr.start, expr.stop, DslValueType.Number,
									listIdx.getType()))
							return DslNull
						}
						if(listIdx.isNotInt()) {
							errorHandler.handleException(
								expr.text, DslNumberNotIntegerException(
									expr.start, expr.stop, listIdx.value))
							return DslNull
						}
						val idx = listIdx.value.toInt()
						val size = when(atomic) {
							is DslList -> atomic.value.size
							is DslString -> atomic.value.length
							is DslPair -> 2
							else -> 0
						}
						if(idx < 0 || idx >= size) {
							errorHandler.handleException(
								expr.text,
								DslIndexOutOfBoundsException(
									expr.start, expr.stop,
									idx, size))
							return DslNull
						}
						return when(atomic) {
							is DslList -> atomic[idx]
							is DslString -> atomic[idx]
							is DslPair -> atomic[idx]
							else -> DslNull
						}
					}
					is DslDict -> {
						return atomic[listIdx] ?: DslNull
					}
					else -> {
						errorHandler.handleException(
							ctx.postfixUnaryOperation().text,
							DslTypesException(ctx.start, ctx.stop,
								setOf(DslValueType.List, DslValueType.Dict, DslValueType.String, DslValueType.Pair), atomic.getType()))
						return DslNull
					}
				}
			}
			c.functionCall()?.let {
				try {
					if(atomic !is DslFunction) {
						errorHandler.handleException(it.text, DslTypeException(it.start, it.stop, DslValueType.Function, atomic.getType()))
						return DslNull
					}
					val args = it.expression().map { expr ->
						parseExpression(expr, processOption, errorHandler, currentElement, currentScope)
					}
					val paramMap = atomic.getParamListToMap(args, it.start, it.stop)
					return atomic(paramMap, processOption, errorHandler, currentElement, currentScope) ?: DslNull
				}
				catch(e: DslParseException) {
					errorHandler.handleException(it.text, e)
				}
			}
		}
		return atomic
	}

	private fun parseAtomicExpression(ctx: AtomicExpressionContext, processOption: ProcessOption,
	                                  errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		ctx.parenthesizedExpression()?.let {
			return parseParenthesizedExpression(it, processOption, errorHandler, currentElement, currentScope)
		}
		ctx.literalConstant()?.let {
			return parseLiteralConstant(it, processOption, errorHandler, currentElement, currentScope)
		}
		ctx.listLiteral()?.let {
			return parseListLiteral(it, processOption, errorHandler, currentElement, currentScope)
		}
		ctx.dictLiteral()?.let {
			val dict = HashMap<DslValue, DslValue>()
			it.dictEntry().forEach { d ->
				val k = d.expression(0)
				val v = d.expression(1)
				val key = parseExpression(k, processOption, errorHandler, currentElement, currentScope)
				val value = parseExpression(v, processOption, errorHandler, currentElement, currentScope)
				dict[key] = value
			}
			return DslDict(dict)
		}
		ctx.setLiteral()?.let {
			val set = HashSet<DslValue>()
			it.expression().forEach { e ->
				set.add(parseExpression(e, processOption, errorHandler, currentElement, currentScope))
			}
			return DslSet(set)
		}
		ctx.identifier()?.let {
			val id = parseIdentifier(it)
			val symbol = id.first
			val name = id.second
			try {
				return currentScope.getField(name, symbol)
			}
			catch(e: DslParseException) {
				errorHandler.handleException(name, e)
			}
		}
		ctx.type()?.let {
			val type = when(it.text) {
				"number" -> DslValueType.Number
				"string" -> DslValueType.String
				"boolean" -> DslValueType.Boolean
				"list" -> DslValueType.List
				"empty" -> DslValueType.Empty
				"null" -> DslValueType.Null
				"element" -> DslValueType.Element
				"function" -> DslValueType.Function
				"type" -> DslValueType.Type
				"set" -> DslValueType.Set
				"dict" -> DslValueType.Dict
				"pair" -> DslValueType.Pair
				else -> DslValueType.Any
			}
			return DslType(type)
		}
		return DslNull // here should not be reached
	}

	private fun parseParenthesizedExpression(ctx: ParenthesizedExpressionContext, processOption: ProcessOption,
	                                         errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		return parseExpression(ctx.expression(), processOption, errorHandler, currentElement, currentScope)
	}

	private fun parseLiteralConstant(ctx: LiteralConstantContext, processOption: ProcessOption,
	                                 errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		ctx.BooleanLiteral()?.let {
			return DslBoolean(it.text.toBoolean())
		}
		ctx.NumberLiteral()?.let {
			val neg = it.text.startsWith("-")
			val text = it.text.replace("_", "")
			val numStr = if(neg) text.substring(1) else text
			val d = if(numStr.startsWith("0b", ignoreCase = true))
				numStr.substring(2).toInt(2).toDouble()
			else if(numStr.startsWith("0o", ignoreCase = true))
				numStr.substring(2).toInt(8).toDouble()
			else if(numStr.startsWith("0x", ignoreCase = true))
				numStr.substring(2).toInt(16).toDouble()
			else
				numStr.toDouble()
			return DslNumber(d)
		}
		ctx.stringLiteral()?.let {
			return parseStringLiteral(it, processOption, errorHandler, currentElement, currentScope)
		}
		ctx.NullLiteral()?.let {
			return DslNull
		}
		ctx.EMPTY()?.let {
			return DslEmpty
		}
		return DslNull // here should not be reached
	}

	private fun parseStringLiteral(ctx: StringLiteralContext, processOption: ProcessOption,
	                               errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		val sb = StringBuilder()
		ctx.stringContent().forEach {
			sb.append(parseStringContent(it, processOption, errorHandler, currentElement, currentScope))
		}
		var ret = sb.toString()
		val lines = ret.lines()
		ret = lines.joinToString("<br>")
		return DslString(ret)
	}

	private fun parseStringContent(ctx: StringContentContext, processOption: ProcessOption,
	                               errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): String {
		ctx.StrText()?.let {
			return it.text
		}
		ctx.StrEscapedChar()?.let {
			val text = it.text
			if(text.startsWith("\\u")) {
				val code = text.substring(2).toInt(16)
				return code.toChar().toString()
			}
			else {
				return when(text[1]) {
					't' -> "\t"
					'b' -> "\b"
					'r' -> "\r"
					'n' -> "\n"
					'\'' -> "\'"
					'\"' -> "\""
					'\\' -> "\\"
					'$' -> "$"
					else -> text
				}
			}
		}
		ctx.StrRef()?.let {
			val symbol = it.symbol
			val field = currentScope.getField(symbol.text.substring(1), symbol)
			return field.toString(symbol.text, processOption) ?: "<null>"
		}
		ctx.stringExpression()?.let {
			val expr = parseStringExpression(it, processOption, errorHandler, currentElement, currentScope)
			return expr.toString("", processOption) ?: "<null>"
		}
		return "" // here should not be reached
	}

	private fun parseStringExpression(ctx: StringExpressionContext, processOption: ProcessOption,
	                                  errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		return parseExpression(ctx.expression(), processOption, errorHandler, currentElement, currentScope)
	}

	private fun parseListLiteral(ctx: ListLiteralContext, processOption: ProcessOption,
	                             errorHandler: ParseErrorHandler, currentElement: DslElement, currentScope: DslScope): DslValue {
		val list = ArrayList<DslValue>()
		ctx.expression().forEach {
			list.add(parseExpression(it, processOption, errorHandler, currentElement, currentScope))
		}
		return DslList(list.filter { it != DslNull && it != DslEmpty })
	}

	private fun parseFunctionDeclaration(ctx: FunctionDeclarationContext, errorHandler: ParseErrorHandler, currentScope: DslScope) {
		val id = parseIdentifier(ctx.identifier())
		val symbol = id.first
		val name = id.second
		try {
			currentScope.defineField(name, symbol, DslFieldModifiers(DslFieldModifiers.FieldState.Block))
		}
		catch(e: DslParseException) {
			errorHandler.handleException(name, e)
			return
		}
		val params = ctx.functionParameters().identifier().map { parseIdentifier(it) }
		val pSet = mutableSetOf<String>()
		for(p in params) {
			if(!pSet.add(p.second)) {
				errorHandler.handleException(p.second, DslDuplicateParameterException(p.first, p.second))
			}
		}
		if(params.size != pSet.size) return
		val block = ctx.block()
		val func = DslFunction(params.map { it.second }, block)
		currentScope.trySetField(name, symbol, ctx.start, ctx.stop, func)
	}

	private fun parseIdentifier(ctx: IdentifierContext): Pair<Token, String> {
		return ctx.Identifier()?.symbol?.let { it to it.text } ?:
			ctx.FullIdentifier().let { it.symbol to it.text.substring(1..<it.text.length - 1) }
	}

}

private object DslOperation {

	fun tryDoPlus(left: DslValue, operationSymbol: Token, right: DslValue, processOption: ProcessOption): DslValue {
		return when(left) {
			is DslNumber -> when(right) {
				is DslNumber -> DslNumber(left.value + right.value)
				is DslBoolean -> DslNumber(left.value + if(right.value) 1.0 else 0.0)
				is DslEmpty -> left
				else -> throw DslValueOperationException(operationSymbol, "+", left, right)
			}
			is DslString -> when(right) {
				is DslList, is DslElement -> throw DslValueOperationException(operationSymbol, "+", left, right)
				is DslNull, is DslEmpty -> left
				else -> DslString(left.value + right.toString("", processOption))
			}
			is DslList -> when(right) {
				is DslNull, is DslEmpty -> left
				is DslList -> DslList(left.value + right.value)
				else -> DslList(left.value + right)
			}
			is DslDict -> when(right) {
				is DslDict -> DslDict(left.value + right.value)
				is DslNull, is DslEmpty -> left
				is DslPair -> DslDict(left.value + mapOf(right.value))
				else -> throw DslValueOperationException(operationSymbol, "+", left, right)
			}
			is DslSet -> when(right) {
				is DslSet -> DslSet(left.value + right.value)
				is DslNull, is DslEmpty -> left
				else -> DslSet(left.value + right)
			}
			is DslPair -> when(right) {
				is DslPair -> DslDict(mapOf(left.value, right.value))
				is DslDict -> DslDict(mapOf(left.value) + right.value)
				else -> throw DslValueOperationException(operationSymbol, "+", left, right)
			}
			is DslEmpty -> right
			is DslAny -> when(right) {
				is DslAny -> tryDoPlus(left.value, operationSymbol, right.value, processOption)
				else -> tryDoPlus(left.value, operationSymbol, right, processOption)
			}
			else -> throw DslValueOperationException(operationSymbol, "+", left, right)
		}
	}

	fun tryDoMinus(left: DslValue, operationSymbol: Token, right: DslValue): DslValue {
		return when(left) {
			is DslNumber -> when(right) {
				is DslNumber -> DslNumber(left.value - right.value)
				is DslBoolean -> DslNumber(left.value - if(right.value) 1.0 else 0.0)
				is DslEmpty -> left
				else -> throw DslValueOperationException(operationSymbol, "-", left, right)
			}
			is DslList -> when(right) {
				is DslList -> DslList(left.value - right.value.toSet())
				is DslEmpty, is DslNull -> left
				else -> DslList(left.value - right)
			}
			is DslDict -> when(right) {
				is DslDict -> DslDict(left.value - right.value.keys)
				is DslEmpty, is DslNull -> left
				else -> DslDict(left.value - right)
			}
			is DslSet -> when(right) {
				is DslSet -> DslSet(left.value - right.value)
				is DslEmpty, is DslNull -> left
				else -> DslSet(left.value - right)
			}
			is DslEmpty -> when(right) {
				is DslNumber -> DslNumber(-right.value)
				is DslBoolean -> DslNumber(if (right.value) -1.0 else -0.0)
				is DslEmpty -> left
				else -> throw DslValueOperationException(operationSymbol, "-", left, right)
			}
			is DslAny -> when(right) {
				is DslAny -> tryDoMinus(left.value, operationSymbol, right.value)
				else -> tryDoMinus(left.value, operationSymbol, right)
			}
			else -> throw DslValueOperationException(operationSymbol, "-", left, right)
		}
	}

	fun tryDoTimes(left: DslValue, operationSymbol: Token, right: DslValue): DslValue {
		return when(left) {
			is DslNumber -> when(right) {
				is DslNumber -> DslNumber(left.value * right.value)
				is DslBoolean -> DslNumber(left.value * if(right.value) 1.0 else 0.0)
				is DslEmpty -> left
				else -> throw DslValueOperationException(operationSymbol, "*", left, right)
			}
			is DslAny -> when(right) {
				is DslAny -> tryDoTimes(left.value, operationSymbol, right.value)
				else -> tryDoTimes(left.value, operationSymbol, right)
			}
			else -> throw DslValueOperationException(operationSymbol, "*", left, right)
		}
	}

	fun tryDoDiv(left: DslValue, operationSymbol: Token, right: DslValue): DslValue {
		return when(left) {
			is DslNumber -> when(right) {
				is DslNumber -> DslNumber(left.value / right.value)
				is DslBoolean -> DslNumber(left.value / if(right.value) 1.0 else 0.0)
				is DslEmpty -> left
				else -> throw DslValueOperationException(operationSymbol, "/", left, right)
			}
			is DslAny -> when(right) {
				is DslAny -> tryDoDiv(left.value, operationSymbol, right.value)
				else -> tryDoDiv(left.value, operationSymbol, right)
			}
			else -> throw DslValueOperationException(operationSymbol, "/", left, right)
		}
	}

	fun tryDoRem(left: DslValue, operationSymbol: Token, right: DslValue): DslValue {
		return when(left) {
			is DslNumber -> when(right) {
				is DslNumber -> DslNumber(left.value % right.value)
				is DslBoolean -> DslNumber(left.value % if(right.value) 1.0 else 0.0)
				is DslEmpty -> left
				else -> throw DslValueOperationException(operationSymbol, "%", left, right)
			}
			is DslAny -> when(right) {
				is DslAny -> tryDoRem(left.value, operationSymbol, right.value)
				else -> tryDoRem(left.value, operationSymbol, right)
			}
			else -> throw DslValueOperationException(operationSymbol, "%", left, right)
		}
	}

}

