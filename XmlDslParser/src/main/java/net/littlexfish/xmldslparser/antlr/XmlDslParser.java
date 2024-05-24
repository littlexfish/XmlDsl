// Generated from C:/LF/Development/IDEAProject/XmlDsl/antlr/XmlDslParser.g4 by ANTLR 4.13.1
package net.littlexfish.xmldslparser.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class XmlDslParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DelimitedComment=1, LineComment=2, WS=3, NL=4, DOT=5, COMMA=6, LPAREN=7, 
		RPAREN=8, LSQUARE=9, RSQUARE=10, LCURL=11, RCURL=12, MULT=13, MOD=14, 
		DIV=15, ADD=16, SUB=17, CONJ=18, DISJ=19, EXCL=20, COLON=21, SEMICOLON=22, 
		ASSIGNMENT=23, ADD_ASSIGNMENT=24, SUB_ASSIGNMENT=25, MULT_ASSIGNMENT=26, 
		DIV_ASSIGNMENT=27, MOD_ASSIGNMENT=28, RANGE=29, HASH=30, AT=31, QUEST=32, 
		LANGLE=33, RANGLE=34, LE=35, GE=36, EXCL_EQ=37, EQEQ=38, SINGLE_QUOTE_OPEN=39, 
		DOUBLE_QUOTE_OPEN=40, VAL=41, VAR=42, ATTR=43, IF=44, ELSE=45, FOR=46, 
		WHILE=47, EMPTY=48, CONTINUE=49, BREAK=50, IN=51, NOT_IN=52, ANY=53, NUMBER=54, 
		STRING=55, BOOLEAN=56, LIST=57, ELEMENT=58, FUNCTION=59, TYPE=60, SET=61, 
		DICT=62, PAIR=63, ELLIPSIS=64, IMPORT=65, INCLUDE=66, FUN=67, RETURN=68, 
		EXPORT=69, AS=70, AS_SAFE=71, IS=72, NOT_IS=73, VOID=74, NumberLiteral=75, 
		BooleanLiteral=76, NullLiteral=77, Identifier=78, FullIdentifier=79, Inside_Comment=80, 
		Inside_WS=81, Inside_NL=82, DOUBLE_QUOTE_CLOSE=83, StrText=84, StrEscapedChar=85, 
		StrRef=86, StrExprStart=87, StrLineNL=88, SINGLE_QUOTE_CLOSE=89, Single_StrLineNL=90, 
		StrExpr_Comment=91, StrExpr_WS=92, StrExpr_NL=93;
	public static final int
		RULE_dslFile = 0, RULE_anysemi = 1, RULE_elementDeclaration = 2, RULE_identifier = 3, 
		RULE_block = 4, RULE_statements = 5, RULE_statement = 6, RULE_declaration = 7, 
		RULE_propertyDeclaration = 8, RULE_singlePropertyDecl = 9, RULE_assignmentExpression = 10, 
		RULE_expression = 11, RULE_flowExpression = 12, RULE_disjunction = 13, 
		RULE_conjunction = 14, RULE_equalityComparison = 15, RULE_comparison = 16, 
		RULE_inExpression = 17, RULE_rangeExpression = 18, RULE_additiveExpression = 19, 
		RULE_multiplicativeExpression = 20, RULE_prefixUnaryExpression = 21, RULE_prefixUnaryOperation = 22, 
		RULE_postfixUnaryExpression = 23, RULE_atomicExpression = 24, RULE_parenthesizedExpression = 25, 
		RULE_literalConstant = 26, RULE_stringLiteral = 27, RULE_stringContent = 28, 
		RULE_stringExpression = 29, RULE_ifExpression = 30, RULE_jumpExpression = 31, 
		RULE_loopExpression = 32, RULE_forExpression = 33, RULE_whileExpression = 34, 
		RULE_listLiteral = 35, RULE_dictLiteral = 36, RULE_dictEntry = 37, RULE_setLiteral = 38, 
		RULE_postfixUnaryOperation = 39, RULE_contentAccess = 40, RULE_functionCall = 41, 
		RULE_multiplicativeOperation = 42, RULE_additiveOperator = 43, RULE_inOperator = 44, 
		RULE_comparisonOperator = 45, RULE_equalityOperation = 46, RULE_assignmentOperator = 47, 
		RULE_functionDeclaration = 48, RULE_functionParameters = 49, RULE_type = 50;
	private static String[] makeRuleNames() {
		return new String[] {
			"dslFile", "anysemi", "elementDeclaration", "identifier", "block", "statements", 
			"statement", "declaration", "propertyDeclaration", "singlePropertyDecl", 
			"assignmentExpression", "expression", "flowExpression", "disjunction", 
			"conjunction", "equalityComparison", "comparison", "inExpression", "rangeExpression", 
			"additiveExpression", "multiplicativeExpression", "prefixUnaryExpression", 
			"prefixUnaryOperation", "postfixUnaryExpression", "atomicExpression", 
			"parenthesizedExpression", "literalConstant", "stringLiteral", "stringContent", 
			"stringExpression", "ifExpression", "jumpExpression", "loopExpression", 
			"forExpression", "whileExpression", "listLiteral", "dictLiteral", "dictEntry", 
			"setLiteral", "postfixUnaryOperation", "contentAccess", "functionCall", 
			"multiplicativeOperation", "additiveOperator", "inOperator", "comparisonOperator", 
			"equalityOperation", "assignmentOperator", "functionDeclaration", "functionParameters", 
			"type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'.'", "','", "'('", null, "'['", null, 
			"'{'", "'}'", "'*'", "'%'", "'/'", "'+'", "'-'", "'&&'", "'||'", "'!'", 
			"':'", "';'", "'='", "'+='", "'-='", "'*='", "'/='", "'%='", "'..'", 
			"'#'", "'@'", "'?'", "'<'", "'>'", "'<='", "'>='", "'!='", "'=='", null, 
			null, "'val'", "'var'", "'attr'", "'if'", "'else'", "'for'", "'while'", 
			"'empty'", "'continue'", "'break'", "'in'", null, "'any'", "'number'", 
			"'string'", "'boolean'", "'list'", "'element'", "'function'", "'type'", 
			"'set'", "'dict'", "'pair'", "'...'", "'import'", "'include'", "'fun'", 
			"'return'", "'export'", "'as'", "'as?'", "'is'", null, "'void'", null, 
			null, "'null'", null, null, null, null, null, null, null, null, null, 
			"'${'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DelimitedComment", "LineComment", "WS", "NL", "DOT", "COMMA", 
			"LPAREN", "RPAREN", "LSQUARE", "RSQUARE", "LCURL", "RCURL", "MULT", "MOD", 
			"DIV", "ADD", "SUB", "CONJ", "DISJ", "EXCL", "COLON", "SEMICOLON", "ASSIGNMENT", 
			"ADD_ASSIGNMENT", "SUB_ASSIGNMENT", "MULT_ASSIGNMENT", "DIV_ASSIGNMENT", 
			"MOD_ASSIGNMENT", "RANGE", "HASH", "AT", "QUEST", "LANGLE", "RANGLE", 
			"LE", "GE", "EXCL_EQ", "EQEQ", "SINGLE_QUOTE_OPEN", "DOUBLE_QUOTE_OPEN", 
			"VAL", "VAR", "ATTR", "IF", "ELSE", "FOR", "WHILE", "EMPTY", "CONTINUE", 
			"BREAK", "IN", "NOT_IN", "ANY", "NUMBER", "STRING", "BOOLEAN", "LIST", 
			"ELEMENT", "FUNCTION", "TYPE", "SET", "DICT", "PAIR", "ELLIPSIS", "IMPORT", 
			"INCLUDE", "FUN", "RETURN", "EXPORT", "AS", "AS_SAFE", "IS", "NOT_IS", 
			"VOID", "NumberLiteral", "BooleanLiteral", "NullLiteral", "Identifier", 
			"FullIdentifier", "Inside_Comment", "Inside_WS", "Inside_NL", "DOUBLE_QUOTE_CLOSE", 
			"StrText", "StrEscapedChar", "StrRef", "StrExprStart", "StrLineNL", "SINGLE_QUOTE_CLOSE", 
			"Single_StrLineNL", "StrExpr_Comment", "StrExpr_WS", "StrExpr_NL"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "XmlDslParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XmlDslParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DslFileContext extends ParserRuleContext {
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(XmlDslParser.EOF, 0); }
		public DslFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dslFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterDslFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitDslFile(this);
		}
	}

	public final DslFileContext dslFile() throws RecognitionException {
		DslFileContext _localctx = new DslFileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_dslFile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			statements();
			setState(103);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnysemiContext extends ParserRuleContext {
		public TerminalNode NL() { return getToken(XmlDslParser.NL, 0); }
		public TerminalNode SEMICOLON() { return getToken(XmlDslParser.SEMICOLON, 0); }
		public AnysemiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anysemi; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterAnysemi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitAnysemi(this);
		}
	}

	public final AnysemiContext anysemi() throws RecognitionException {
		AnysemiContext _localctx = new AnysemiContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_anysemi);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			_la = _input.LA(1);
			if ( !(_la==NL || _la==SEMICOLON) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElementDeclarationContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(XmlDslParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(XmlDslParser.NL, i);
		}
		public ElementDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterElementDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitElementDeclaration(this);
		}
	}

	public final ElementDeclarationContext elementDeclaration() throws RecognitionException {
		ElementDeclarationContext _localctx = new ElementDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_elementDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			identifier();
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(108);
				match(NL);
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(114);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(XmlDslParser.Identifier, 0); }
		public TerminalNode FullIdentifier() { return getToken(XmlDslParser.FullIdentifier, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			_la = _input.LA(1);
			if ( !(_la==Identifier || _la==FullIdentifier) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LCURL() { return getToken(XmlDslParser.LCURL, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode RCURL() { return getToken(XmlDslParser.RCURL, 0); }
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(LCURL);
			setState(119);
			statements();
			setState(120);
			match(RCURL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementsContext extends ParserRuleContext {
		public List<AnysemiContext> anysemi() {
			return getRuleContexts(AnysemiContext.class);
		}
		public AnysemiContext anysemi(int i) {
			return getRuleContext(AnysemiContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statements);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL || _la==SEMICOLON) {
				{
				{
				setState(122);
				anysemi();
				}
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -6791124977776000L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 7939L) != 0)) {
				{
				setState(128);
				statement();
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL || _la==SEMICOLON) {
					{
					{
					setState(130); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(129);
							anysemi();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(132); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(135);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -6791124977776000L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 7939L) != 0)) {
						{
						setState(134);
						statement();
						}
					}

					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FlowExpressionContext flowExpression() {
			return getRuleContext(FlowExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statement);
		try {
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				declaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				assignmentExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(146);
				expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(147);
				flowExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public PropertyDeclarationContext propertyDeclaration() {
			return getRuleContext(PropertyDeclarationContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_declaration);
		try {
			setState(152);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAL:
			case VAR:
			case ATTR:
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				propertyDeclaration();
				}
				break;
			case FUN:
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
				functionDeclaration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PropertyDeclarationContext extends ParserRuleContext {
		public List<SinglePropertyDeclContext> singlePropertyDecl() {
			return getRuleContexts(SinglePropertyDeclContext.class);
		}
		public SinglePropertyDeclContext singlePropertyDecl(int i) {
			return getRuleContext(SinglePropertyDeclContext.class,i);
		}
		public TerminalNode VAL() { return getToken(XmlDslParser.VAL, 0); }
		public TerminalNode VAR() { return getToken(XmlDslParser.VAR, 0); }
		public TerminalNode ATTR() { return getToken(XmlDslParser.ATTR, 0); }
		public List<TerminalNode> NL() { return getTokens(XmlDslParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(XmlDslParser.NL, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(XmlDslParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(XmlDslParser.COMMA, i);
		}
		public PropertyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterPropertyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitPropertyDeclaration(this);
		}
	}

	public final PropertyDeclarationContext propertyDeclaration() throws RecognitionException {
		PropertyDeclarationContext _localctx = new PropertyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_propertyDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 15393162788864L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(155);
				match(NL);
				}
				}
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(161);
			singlePropertyDecl();
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(162);
				match(COMMA);
				setState(163);
				singlePropertyDecl();
				}
				}
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SinglePropertyDeclContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGNMENT() { return getToken(XmlDslParser.ASSIGNMENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(XmlDslParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(XmlDslParser.NL, i);
		}
		public SinglePropertyDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singlePropertyDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterSinglePropertyDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitSinglePropertyDecl(this);
		}
	}

	public final SinglePropertyDeclContext singlePropertyDecl() throws RecognitionException {
		SinglePropertyDeclContext _localctx = new SinglePropertyDeclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_singlePropertyDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			identifier();
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(170);
					match(NL);
					}
					}
					setState(175);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(176);
				match(ASSIGNMENT);
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(177);
					match(NL);
					}
					}
					setState(182);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(183);
				expression();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentExpressionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AssignmentOperatorContext assignmentOperator() {
			return getRuleContext(AssignmentOperatorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ContentAccessContext contentAccess() {
			return getRuleContext(ContentAccessContext.class,0);
		}
		public AssignmentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterAssignmentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitAssignmentExpression(this);
		}
	}

	public final AssignmentExpressionContext assignmentExpression() throws RecognitionException {
		AssignmentExpressionContext _localctx = new AssignmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_assignmentExpression);
		try {
			setState(195);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(186);
				identifier();
				setState(187);
				assignmentOperator();
				setState(188);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				identifier();
				setState(191);
				contentAccess();
				setState(192);
				assignmentOperator();
				setState(193);
				expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ElementDeclarationContext elementDeclaration() {
			return getRuleContext(ElementDeclarationContext.class,0);
		}
		public DisjunctionContext disjunction() {
			return getRuleContext(DisjunctionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expression);
		try {
			setState(199);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				elementDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(198);
				disjunction();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FlowExpressionContext extends ParserRuleContext {
		public IfExpressionContext ifExpression() {
			return getRuleContext(IfExpressionContext.class,0);
		}
		public JumpExpressionContext jumpExpression() {
			return getRuleContext(JumpExpressionContext.class,0);
		}
		public LoopExpressionContext loopExpression() {
			return getRuleContext(LoopExpressionContext.class,0);
		}
		public FlowExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flowExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterFlowExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitFlowExpression(this);
		}
	}

	public final FlowExpressionContext flowExpression() throws RecognitionException {
		FlowExpressionContext _localctx = new FlowExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_flowExpression);
		try {
			setState(204);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(201);
				ifExpression();
				}
				break;
			case CONTINUE:
			case BREAK:
			case RETURN:
				enterOuterAlt(_localctx, 2);
				{
				setState(202);
				jumpExpression();
				}
				break;
			case FOR:
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(203);
				loopExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DisjunctionContext extends ParserRuleContext {
		public List<ConjunctionContext> conjunction() {
			return getRuleContexts(ConjunctionContext.class);
		}
		public ConjunctionContext conjunction(int i) {
			return getRuleContext(ConjunctionContext.class,i);
		}
		public List<TerminalNode> DISJ() { return getTokens(XmlDslParser.DISJ); }
		public TerminalNode DISJ(int i) {
			return getToken(XmlDslParser.DISJ, i);
		}
		public List<TerminalNode> NL() { return getTokens(XmlDslParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(XmlDslParser.NL, i);
		}
		public DisjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disjunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterDisjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitDisjunction(this);
		}
	}

	public final DisjunctionContext disjunction() throws RecognitionException {
		DisjunctionContext _localctx = new DisjunctionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_disjunction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			conjunction();
			setState(223);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(210);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(207);
						match(NL);
						}
						}
						setState(212);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(213);
					match(DISJ);
					setState(217);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(214);
						match(NL);
						}
						}
						setState(219);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(220);
					conjunction();
					}
					} 
				}
				setState(225);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConjunctionContext extends ParserRuleContext {
		public List<EqualityComparisonContext> equalityComparison() {
			return getRuleContexts(EqualityComparisonContext.class);
		}
		public EqualityComparisonContext equalityComparison(int i) {
			return getRuleContext(EqualityComparisonContext.class,i);
		}
		public List<TerminalNode> CONJ() { return getTokens(XmlDslParser.CONJ); }
		public TerminalNode CONJ(int i) {
			return getToken(XmlDslParser.CONJ, i);
		}
		public List<TerminalNode> NL() { return getTokens(XmlDslParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(XmlDslParser.NL, i);
		}
		public ConjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterConjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitConjunction(this);
		}
	}

	public final ConjunctionContext conjunction() throws RecognitionException {
		ConjunctionContext _localctx = new ConjunctionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_conjunction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			equalityComparison();
			setState(243);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(230);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(227);
						match(NL);
						}
						}
						setState(232);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(233);
					match(CONJ);
					setState(237);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(234);
						match(NL);
						}
						}
						setState(239);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(240);
					equalityComparison();
					}
					} 
				}
				setState(245);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EqualityComparisonContext extends ParserRuleContext {
		public List<ComparisonContext> comparison() {
			return getRuleContexts(ComparisonContext.class);
		}
		public ComparisonContext comparison(int i) {
			return getRuleContext(ComparisonContext.class,i);
		}
		public EqualityOperationContext equalityOperation() {
			return getRuleContext(EqualityOperationContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(XmlDslParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(XmlDslParser.NL, i);
		}
		public EqualityComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityComparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterEqualityComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitEqualityComparison(this);
		}
	}

	public final EqualityComparisonContext equalityComparison() throws RecognitionException {
		EqualityComparisonContext _localctx = new EqualityComparisonContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_equalityComparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			comparison();
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXCL_EQ || _la==EQEQ) {
				{
				setState(247);
				equalityOperation();
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(248);
					match(NL);
					}
					}
					setState(253);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(254);
				comparison();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonContext extends ParserRuleContext {
		public List<InExpressionContext> inExpression() {
			return getRuleContexts(InExpressionContext.class);
		}
		public InExpressionContext inExpression(int i) {
			return getRuleContext(InExpressionContext.class,i);
		}
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(XmlDslParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(XmlDslParser.NL, i);
		}
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitComparison(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_comparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			inExpression();
			setState(268);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(259);
				comparisonOperator();
				setState(263);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(260);
					match(NL);
					}
					}
					setState(265);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(266);
				inExpression();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InExpressionContext extends ParserRuleContext {
		public List<RangeExpressionContext> rangeExpression() {
			return getRuleContexts(RangeExpressionContext.class);
		}
		public RangeExpressionContext rangeExpression(int i) {
			return getRuleContext(RangeExpressionContext.class,i);
		}
		public InOperatorContext inOperator() {
			return getRuleContext(InOperatorContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(XmlDslParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(XmlDslParser.NL, i);
		}
		public InExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterInExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitInExpression(this);
		}
	}

	public final InExpressionContext inExpression() throws RecognitionException {
		InExpressionContext _localctx = new InExpressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_inExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			rangeExpression();
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IN || _la==NOT_IN) {
				{
				setState(271);
				inOperator();
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(272);
					match(NL);
					}
					}
					setState(277);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(278);
				rangeExpression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RangeExpressionContext extends ParserRuleContext {
		public List<AdditiveExpressionContext> additiveExpression() {
			return getRuleContexts(AdditiveExpressionContext.class);
		}
		public AdditiveExpressionContext additiveExpression(int i) {
			return getRuleContext(AdditiveExpressionContext.class,i);
		}
		public TerminalNode RANGE() { return getToken(XmlDslParser.RANGE, 0); }
		public List<TerminalNode> NL() { return getTokens(XmlDslParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(XmlDslParser.NL, i);
		}
		public RangeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rangeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterRangeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitRangeExpression(this);
		}
	}

	public final RangeExpressionContext rangeExpression() throws RecognitionException {
		RangeExpressionContext _localctx = new RangeExpressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_rangeExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			additiveExpression();
			setState(291);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RANGE) {
				{
				setState(283);
				match(RANGE);
				setState(287);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(284);
					match(NL);
					}
					}
					setState(289);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(290);
				additiveExpression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveExpressionContext extends ParserRuleContext {
		public List<MultiplicativeExpressionContext> multiplicativeExpression() {
			return getRuleContexts(MultiplicativeExpressionContext.class);
		}
		public MultiplicativeExpressionContext multiplicativeExpression(int i) {
			return getRuleContext(MultiplicativeExpressionContext.class,i);
		}
		public List<AdditiveOperatorContext> additiveOperator() {
			return getRuleContexts(AdditiveOperatorContext.class);
		}
		public AdditiveOperatorContext additiveOperator(int i) {
			return getRuleContext(AdditiveOperatorContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(XmlDslParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(XmlDslParser.NL, i);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitAdditiveExpression(this);
		}
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_additiveExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			multiplicativeExpression();
			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==SUB) {
				{
				{
				setState(294);
				additiveOperator();
				setState(298);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(295);
					match(NL);
					}
					}
					setState(300);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(301);
				multiplicativeExpression();
				}
				}
				setState(307);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public List<PrefixUnaryExpressionContext> prefixUnaryExpression() {
			return getRuleContexts(PrefixUnaryExpressionContext.class);
		}
		public PrefixUnaryExpressionContext prefixUnaryExpression(int i) {
			return getRuleContext(PrefixUnaryExpressionContext.class,i);
		}
		public List<MultiplicativeOperationContext> multiplicativeOperation() {
			return getRuleContexts(MultiplicativeOperationContext.class);
		}
		public MultiplicativeOperationContext multiplicativeOperation(int i) {
			return getRuleContext(MultiplicativeOperationContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(XmlDslParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(XmlDslParser.NL, i);
		}
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterMultiplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitMultiplicativeExpression(this);
		}
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_multiplicativeExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			prefixUnaryExpression();
			setState(320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 57344L) != 0)) {
				{
				{
				setState(309);
				multiplicativeOperation();
				setState(313);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(310);
					match(NL);
					}
					}
					setState(315);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(316);
				prefixUnaryExpression();
				}
				}
				setState(322);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrefixUnaryExpressionContext extends ParserRuleContext {
		public PostfixUnaryExpressionContext postfixUnaryExpression() {
			return getRuleContext(PostfixUnaryExpressionContext.class,0);
		}
		public List<PrefixUnaryOperationContext> prefixUnaryOperation() {
			return getRuleContexts(PrefixUnaryOperationContext.class);
		}
		public PrefixUnaryOperationContext prefixUnaryOperation(int i) {
			return getRuleContext(PrefixUnaryOperationContext.class,i);
		}
		public PrefixUnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixUnaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterPrefixUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitPrefixUnaryExpression(this);
		}
	}

	public final PrefixUnaryExpressionContext prefixUnaryExpression() throws RecognitionException {
		PrefixUnaryExpressionContext _localctx = new PrefixUnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_prefixUnaryExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1245184L) != 0)) {
				{
				{
				setState(323);
				prefixUnaryOperation();
				}
				}
				setState(328);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(329);
			postfixUnaryExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrefixUnaryOperationContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(XmlDslParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(XmlDslParser.SUB, 0); }
		public TerminalNode EXCL() { return getToken(XmlDslParser.EXCL, 0); }
		public PrefixUnaryOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixUnaryOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterPrefixUnaryOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitPrefixUnaryOperation(this);
		}
	}

	public final PrefixUnaryOperationContext prefixUnaryOperation() throws RecognitionException {
		PrefixUnaryOperationContext _localctx = new PrefixUnaryOperationContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_prefixUnaryOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1245184L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PostfixUnaryExpressionContext extends ParserRuleContext {
		public AtomicExpressionContext atomicExpression() {
			return getRuleContext(AtomicExpressionContext.class,0);
		}
		public PostfixUnaryOperationContext postfixUnaryOperation() {
			return getRuleContext(PostfixUnaryOperationContext.class,0);
		}
		public PostfixUnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixUnaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterPostfixUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitPostfixUnaryExpression(this);
		}
	}

	public final PostfixUnaryExpressionContext postfixUnaryExpression() throws RecognitionException {
		PostfixUnaryExpressionContext _localctx = new PostfixUnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_postfixUnaryExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			atomicExpression();
			setState(335);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN || _la==LSQUARE) {
				{
				setState(334);
				postfixUnaryOperation();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtomicExpressionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ParenthesizedExpressionContext parenthesizedExpression() {
			return getRuleContext(ParenthesizedExpressionContext.class,0);
		}
		public LiteralConstantContext literalConstant() {
			return getRuleContext(LiteralConstantContext.class,0);
		}
		public ListLiteralContext listLiteral() {
			return getRuleContext(ListLiteralContext.class,0);
		}
		public DictLiteralContext dictLiteral() {
			return getRuleContext(DictLiteralContext.class,0);
		}
		public SetLiteralContext setLiteral() {
			return getRuleContext(SetLiteralContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public AtomicExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomicExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterAtomicExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitAtomicExpression(this);
		}
	}

	public final AtomicExpressionContext atomicExpression() throws RecognitionException {
		AtomicExpressionContext _localctx = new AtomicExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_atomicExpression);
		try {
			setState(344);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
			case FullIdentifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(337);
				identifier();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(338);
				parenthesizedExpression();
				}
				break;
			case SINGLE_QUOTE_OPEN:
			case DOUBLE_QUOTE_OPEN:
			case EMPTY:
			case NumberLiteral:
			case BooleanLiteral:
			case NullLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(339);
				literalConstant();
				}
				break;
			case LSQUARE:
				enterOuterAlt(_localctx, 4);
				{
				setState(340);
				listLiteral();
				}
				break;
			case LCURL:
				enterOuterAlt(_localctx, 5);
				{
				setState(341);
				dictLiteral();
				}
				break;
			case LANGLE:
				enterOuterAlt(_localctx, 6);
				{
				setState(342);
				setLiteral();
				}
				break;
			case ANY:
			case NUMBER:
			case STRING:
			case BOOLEAN:
			case LIST:
			case ELEMENT:
			case FUNCTION:
			case TYPE:
			case SET:
			case DICT:
			case PAIR:
				enterOuterAlt(_localctx, 7);
				{
				setState(343);
				type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesizedExpressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(XmlDslParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(XmlDslParser.RPAREN, 0); }
		public ParenthesizedExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenthesizedExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterParenthesizedExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitParenthesizedExpression(this);
		}
	}

	public final ParenthesizedExpressionContext parenthesizedExpression() throws RecognitionException {
		ParenthesizedExpressionContext _localctx = new ParenthesizedExpressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_parenthesizedExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			match(LPAREN);
			setState(347);
			expression();
			setState(348);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralConstantContext extends ParserRuleContext {
		public TerminalNode BooleanLiteral() { return getToken(XmlDslParser.BooleanLiteral, 0); }
		public TerminalNode NumberLiteral() { return getToken(XmlDslParser.NumberLiteral, 0); }
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public TerminalNode NullLiteral() { return getToken(XmlDslParser.NullLiteral, 0); }
		public TerminalNode EMPTY() { return getToken(XmlDslParser.EMPTY, 0); }
		public LiteralConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterLiteralConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitLiteralConstant(this);
		}
	}

	public final LiteralConstantContext literalConstant() throws RecognitionException {
		LiteralConstantContext _localctx = new LiteralConstantContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_literalConstant);
		try {
			setState(355);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BooleanLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(350);
				match(BooleanLiteral);
				}
				break;
			case NumberLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(351);
				match(NumberLiteral);
				}
				break;
			case SINGLE_QUOTE_OPEN:
			case DOUBLE_QUOTE_OPEN:
				enterOuterAlt(_localctx, 3);
				{
				setState(352);
				stringLiteral();
				}
				break;
			case NullLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(353);
				match(NullLiteral);
				}
				break;
			case EMPTY:
				enterOuterAlt(_localctx, 5);
				{
				setState(354);
				match(EMPTY);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StringLiteralContext extends ParserRuleContext {
		public TerminalNode SINGLE_QUOTE_OPEN() { return getToken(XmlDslParser.SINGLE_QUOTE_OPEN, 0); }
		public TerminalNode SINGLE_QUOTE_CLOSE() { return getToken(XmlDslParser.SINGLE_QUOTE_CLOSE, 0); }
		public List<StringContentContext> stringContent() {
			return getRuleContexts(StringContentContext.class);
		}
		public StringContentContext stringContent(int i) {
			return getRuleContext(StringContentContext.class,i);
		}
		public TerminalNode DOUBLE_QUOTE_OPEN() { return getToken(XmlDslParser.DOUBLE_QUOTE_OPEN, 0); }
		public TerminalNode DOUBLE_QUOTE_CLOSE() { return getToken(XmlDslParser.DOUBLE_QUOTE_CLOSE, 0); }
		public StringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitStringLiteral(this);
		}
	}

	public final StringLiteralContext stringLiteral() throws RecognitionException {
		StringLiteralContext _localctx = new StringLiteralContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_stringLiteral);
		int _la;
		try {
			setState(373);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_QUOTE_OPEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(357);
				match(SINGLE_QUOTE_OPEN);
				setState(361);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & 15L) != 0)) {
					{
					{
					setState(358);
					stringContent();
					}
					}
					setState(363);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(364);
				match(SINGLE_QUOTE_CLOSE);
				}
				break;
			case DOUBLE_QUOTE_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(365);
				match(DOUBLE_QUOTE_OPEN);
				setState(369);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & 15L) != 0)) {
					{
					{
					setState(366);
					stringContent();
					}
					}
					setState(371);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(372);
				match(DOUBLE_QUOTE_CLOSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StringContentContext extends ParserRuleContext {
		public TerminalNode StrText() { return getToken(XmlDslParser.StrText, 0); }
		public TerminalNode StrEscapedChar() { return getToken(XmlDslParser.StrEscapedChar, 0); }
		public TerminalNode StrRef() { return getToken(XmlDslParser.StrRef, 0); }
		public StringExpressionContext stringExpression() {
			return getRuleContext(StringExpressionContext.class,0);
		}
		public StringContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterStringContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitStringContent(this);
		}
	}

	public final StringContentContext stringContent() throws RecognitionException {
		StringContentContext _localctx = new StringContentContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_stringContent);
		try {
			setState(379);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case StrText:
				enterOuterAlt(_localctx, 1);
				{
				setState(375);
				match(StrText);
				}
				break;
			case StrEscapedChar:
				enterOuterAlt(_localctx, 2);
				{
				setState(376);
				match(StrEscapedChar);
				}
				break;
			case StrRef:
				enterOuterAlt(_localctx, 3);
				{
				setState(377);
				match(StrRef);
				}
				break;
			case StrExprStart:
				enterOuterAlt(_localctx, 4);
				{
				setState(378);
				stringExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StringExpressionContext extends ParserRuleContext {
		public TerminalNode StrExprStart() { return getToken(XmlDslParser.StrExprStart, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RCURL() { return getToken(XmlDslParser.RCURL, 0); }
		public StringExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterStringExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitStringExpression(this);
		}
	}

	public final StringExpressionContext stringExpression() throws RecognitionException {
		StringExpressionContext _localctx = new StringExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_stringExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			match(StrExprStart);
			setState(382);
			expression();
			setState(383);
			match(RCURL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfExpressionContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(XmlDslParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(XmlDslParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(XmlDslParser.NL, i);
		}
		public TerminalNode ELSE() { return getToken(XmlDslParser.ELSE, 0); }
		public IfExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterIfExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitIfExpression(this);
		}
	}

	public final IfExpressionContext ifExpression() throws RecognitionException {
		IfExpressionContext _localctx = new IfExpressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_ifExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			match(IF);
			setState(389);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(386);
				match(NL);
				}
				}
				setState(391);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(392);
			expression();
			setState(396);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(393);
				match(NL);
				}
				}
				setState(398);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(399);
			block();
			setState(414);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				{
				setState(403);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(400);
					match(NL);
					}
					}
					setState(405);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(406);
				match(ELSE);
				setState(410);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(407);
					match(NL);
					}
					}
					setState(412);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(413);
				block();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JumpExpressionContext extends ParserRuleContext {
		public TerminalNode CONTINUE() { return getToken(XmlDslParser.CONTINUE, 0); }
		public TerminalNode BREAK() { return getToken(XmlDslParser.BREAK, 0); }
		public TerminalNode RETURN() { return getToken(XmlDslParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public JumpExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterJumpExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitJumpExpression(this);
		}
	}

	public final JumpExpressionContext jumpExpression() throws RecognitionException {
		JumpExpressionContext _localctx = new JumpExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_jumpExpression);
		int _la;
		try {
			setState(422);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONTINUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(416);
				match(CONTINUE);
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 2);
				{
				setState(417);
				match(BREAK);
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 3);
				{
				setState(418);
				match(RETURN);
				setState(420);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8724066419406208L) != 0) || ((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & 31L) != 0)) {
					{
					setState(419);
					expression();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LoopExpressionContext extends ParserRuleContext {
		public ForExpressionContext forExpression() {
			return getRuleContext(ForExpressionContext.class,0);
		}
		public WhileExpressionContext whileExpression() {
			return getRuleContext(WhileExpressionContext.class,0);
		}
		public LoopExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterLoopExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitLoopExpression(this);
		}
	}

	public final LoopExpressionContext loopExpression() throws RecognitionException {
		LoopExpressionContext _localctx = new LoopExpressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_loopExpression);
		try {
			setState(426);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(424);
				forExpression();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(425);
				whileExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForExpressionContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(XmlDslParser.FOR, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode IN() { return getToken(XmlDslParser.IN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(XmlDslParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(XmlDslParser.NL, i);
		}
		public ForExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterForExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitForExpression(this);
		}
	}

	public final ForExpressionContext forExpression() throws RecognitionException {
		ForExpressionContext _localctx = new ForExpressionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_forExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			match(FOR);
			setState(432);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(429);
				match(NL);
				}
				}
				setState(434);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(435);
			identifier();
			setState(436);
			match(IN);
			setState(437);
			expression();
			setState(441);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(438);
				match(NL);
				}
				}
				setState(443);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(444);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileExpressionContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(XmlDslParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(XmlDslParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(XmlDslParser.NL, i);
		}
		public WhileExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterWhileExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitWhileExpression(this);
		}
	}

	public final WhileExpressionContext whileExpression() throws RecognitionException {
		WhileExpressionContext _localctx = new WhileExpressionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_whileExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446);
			match(WHILE);
			setState(450);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(447);
				match(NL);
				}
				}
				setState(452);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(453);
			expression();
			setState(457);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(454);
				match(NL);
				}
				}
				setState(459);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(460);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListLiteralContext extends ParserRuleContext {
		public TerminalNode LSQUARE() { return getToken(XmlDslParser.LSQUARE, 0); }
		public TerminalNode RSQUARE() { return getToken(XmlDslParser.RSQUARE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(XmlDslParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(XmlDslParser.COMMA, i);
		}
		public ListLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterListLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitListLiteral(this);
		}
	}

	public final ListLiteralContext listLiteral() throws RecognitionException {
		ListLiteralContext _localctx = new ListLiteralContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_listLiteral);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(462);
			match(LSQUARE);
			setState(464);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8724066419406208L) != 0) || ((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & 31L) != 0)) {
				{
				setState(463);
				expression();
				}
			}

			setState(470);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(466);
					match(COMMA);
					setState(467);
					expression();
					}
					} 
				}
				setState(472);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
			}
			setState(474);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(473);
				match(COMMA);
				}
			}

			setState(476);
			match(RSQUARE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DictLiteralContext extends ParserRuleContext {
		public TerminalNode LCURL() { return getToken(XmlDslParser.LCURL, 0); }
		public TerminalNode RCURL() { return getToken(XmlDslParser.RCURL, 0); }
		public List<DictEntryContext> dictEntry() {
			return getRuleContexts(DictEntryContext.class);
		}
		public DictEntryContext dictEntry(int i) {
			return getRuleContext(DictEntryContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(XmlDslParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(XmlDslParser.COMMA, i);
		}
		public DictLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dictLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterDictLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitDictLiteral(this);
		}
	}

	public final DictLiteralContext dictLiteral() throws RecognitionException {
		DictLiteralContext _localctx = new DictLiteralContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_dictLiteral);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			match(LCURL);
			setState(490);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8724066419406208L) != 0) || ((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & 31L) != 0)) {
				{
				setState(479);
				dictEntry();
				setState(484);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(480);
						match(COMMA);
						setState(481);
						dictEntry();
						}
						} 
					}
					setState(486);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
				}
				setState(488);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(487);
					match(COMMA);
					}
				}

				}
			}

			setState(492);
			match(RCURL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DictEntryContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COLON() { return getToken(XmlDslParser.COLON, 0); }
		public DictEntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dictEntry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterDictEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitDictEntry(this);
		}
	}

	public final DictEntryContext dictEntry() throws RecognitionException {
		DictEntryContext _localctx = new DictEntryContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_dictEntry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(494);
			expression();
			setState(495);
			match(COLON);
			setState(496);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SetLiteralContext extends ParserRuleContext {
		public TerminalNode LANGLE() { return getToken(XmlDslParser.LANGLE, 0); }
		public TerminalNode RANGLE() { return getToken(XmlDslParser.RANGLE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(XmlDslParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(XmlDslParser.COMMA, i);
		}
		public SetLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterSetLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitSetLiteral(this);
		}
	}

	public final SetLiteralContext setLiteral() throws RecognitionException {
		SetLiteralContext _localctx = new SetLiteralContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_setLiteral);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(498);
			match(LANGLE);
			setState(510);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8724066419406208L) != 0) || ((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & 31L) != 0)) {
				{
				setState(499);
				expression();
				setState(504);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(500);
						match(COMMA);
						setState(501);
						expression();
						}
						} 
					}
					setState(506);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
				}
				setState(508);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(507);
					match(COMMA);
					}
				}

				}
			}

			setState(512);
			match(RANGLE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PostfixUnaryOperationContext extends ParserRuleContext {
		public ContentAccessContext contentAccess() {
			return getRuleContext(ContentAccessContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public PostfixUnaryOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixUnaryOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterPostfixUnaryOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitPostfixUnaryOperation(this);
		}
	}

	public final PostfixUnaryOperationContext postfixUnaryOperation() throws RecognitionException {
		PostfixUnaryOperationContext _localctx = new PostfixUnaryOperationContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_postfixUnaryOperation);
		try {
			setState(516);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LSQUARE:
				enterOuterAlt(_localctx, 1);
				{
				setState(514);
				contentAccess();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(515);
				functionCall();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ContentAccessContext extends ParserRuleContext {
		public TerminalNode LSQUARE() { return getToken(XmlDslParser.LSQUARE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RSQUARE() { return getToken(XmlDslParser.RSQUARE, 0); }
		public ContentAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contentAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterContentAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitContentAccess(this);
		}
	}

	public final ContentAccessContext contentAccess() throws RecognitionException {
		ContentAccessContext _localctx = new ContentAccessContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_contentAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(518);
			match(LSQUARE);
			setState(519);
			expression();
			setState(520);
			match(RSQUARE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(XmlDslParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(XmlDslParser.RPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(XmlDslParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(XmlDslParser.COMMA, i);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_functionCall);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(522);
			match(LPAREN);
			setState(534);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8724066419406208L) != 0) || ((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & 31L) != 0)) {
				{
				setState(523);
				expression();
				setState(528);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(524);
						match(COMMA);
						setState(525);
						expression();
						}
						} 
					}
					setState(530);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
				}
				setState(532);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(531);
					match(COMMA);
					}
				}

				}
			}

			setState(536);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicativeOperationContext extends ParserRuleContext {
		public TerminalNode MULT() { return getToken(XmlDslParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(XmlDslParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(XmlDslParser.MOD, 0); }
		public MultiplicativeOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterMultiplicativeOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitMultiplicativeOperation(this);
		}
	}

	public final MultiplicativeOperationContext multiplicativeOperation() throws RecognitionException {
		MultiplicativeOperationContext _localctx = new MultiplicativeOperationContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_multiplicativeOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(538);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 57344L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveOperatorContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(XmlDslParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(XmlDslParser.SUB, 0); }
		public AdditiveOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterAdditiveOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitAdditiveOperator(this);
		}
	}

	public final AdditiveOperatorContext additiveOperator() throws RecognitionException {
		AdditiveOperatorContext _localctx = new AdditiveOperatorContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_additiveOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(540);
			_la = _input.LA(1);
			if ( !(_la==ADD || _la==SUB) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InOperatorContext extends ParserRuleContext {
		public TerminalNode IN() { return getToken(XmlDslParser.IN, 0); }
		public TerminalNode NOT_IN() { return getToken(XmlDslParser.NOT_IN, 0); }
		public InOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterInOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitInOperator(this);
		}
	}

	public final InOperatorContext inOperator() throws RecognitionException {
		InOperatorContext _localctx = new InOperatorContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_inOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(542);
			_la = _input.LA(1);
			if ( !(_la==IN || _la==NOT_IN) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonOperatorContext extends ParserRuleContext {
		public TerminalNode LANGLE() { return getToken(XmlDslParser.LANGLE, 0); }
		public TerminalNode RANGLE() { return getToken(XmlDslParser.RANGLE, 0); }
		public TerminalNode LE() { return getToken(XmlDslParser.LE, 0); }
		public TerminalNode GE() { return getToken(XmlDslParser.GE, 0); }
		public ComparisonOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterComparisonOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitComparisonOperator(this);
		}
	}

	public final ComparisonOperatorContext comparisonOperator() throws RecognitionException {
		ComparisonOperatorContext _localctx = new ComparisonOperatorContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_comparisonOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(544);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 128849018880L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EqualityOperationContext extends ParserRuleContext {
		public TerminalNode EXCL_EQ() { return getToken(XmlDslParser.EXCL_EQ, 0); }
		public TerminalNode EQEQ() { return getToken(XmlDslParser.EQEQ, 0); }
		public EqualityOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterEqualityOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitEqualityOperation(this);
		}
	}

	public final EqualityOperationContext equalityOperation() throws RecognitionException {
		EqualityOperationContext _localctx = new EqualityOperationContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_equalityOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(546);
			_la = _input.LA(1);
			if ( !(_la==EXCL_EQ || _la==EQEQ) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentOperatorContext extends ParserRuleContext {
		public TerminalNode ASSIGNMENT() { return getToken(XmlDslParser.ASSIGNMENT, 0); }
		public TerminalNode ADD_ASSIGNMENT() { return getToken(XmlDslParser.ADD_ASSIGNMENT, 0); }
		public TerminalNode SUB_ASSIGNMENT() { return getToken(XmlDslParser.SUB_ASSIGNMENT, 0); }
		public TerminalNode MULT_ASSIGNMENT() { return getToken(XmlDslParser.MULT_ASSIGNMENT, 0); }
		public TerminalNode DIV_ASSIGNMENT() { return getToken(XmlDslParser.DIV_ASSIGNMENT, 0); }
		public TerminalNode MOD_ASSIGNMENT() { return getToken(XmlDslParser.MOD_ASSIGNMENT, 0); }
		public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterAssignmentOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitAssignmentOperator(this);
		}
	}

	public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
		AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_assignmentOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(548);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 528482304L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclarationContext extends ParserRuleContext {
		public TerminalNode FUN() { return getToken(XmlDslParser.FUN, 0); }
		public FunctionParametersContext functionParameters() {
			return getRuleContext(FunctionParametersContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(XmlDslParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(XmlDslParser.NL, i);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitFunctionDeclaration(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			match(FUN);
			setState(558);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				{
				setState(554);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(551);
					match(NL);
					}
					}
					setState(556);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(557);
				identifier();
				}
				break;
			}
			setState(563);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(560);
				match(NL);
				}
				}
				setState(565);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(566);
			functionParameters();
			setState(570);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(567);
				match(NL);
				}
				}
				setState(572);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(573);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionParametersContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(XmlDslParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(XmlDslParser.RPAREN, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(XmlDslParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(XmlDslParser.COMMA, i);
		}
		public FunctionParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterFunctionParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitFunctionParameters(this);
		}
	}

	public final FunctionParametersContext functionParameters() throws RecognitionException {
		FunctionParametersContext _localctx = new FunctionParametersContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_functionParameters);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(575);
			match(LPAREN);
			setState(587);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier || _la==FullIdentifier) {
				{
				setState(576);
				identifier();
				setState(581);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(577);
						match(COMMA);
						setState(578);
						identifier();
						}
						} 
					}
					setState(583);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
				}
				setState(585);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(584);
					match(COMMA);
					}
				}

				}
			}

			setState(589);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode ANY() { return getToken(XmlDslParser.ANY, 0); }
		public TerminalNode NUMBER() { return getToken(XmlDslParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(XmlDslParser.STRING, 0); }
		public TerminalNode BOOLEAN() { return getToken(XmlDslParser.BOOLEAN, 0); }
		public TerminalNode LIST() { return getToken(XmlDslParser.LIST, 0); }
		public TerminalNode ELEMENT() { return getToken(XmlDslParser.ELEMENT, 0); }
		public TerminalNode FUNCTION() { return getToken(XmlDslParser.FUNCTION, 0); }
		public TerminalNode TYPE() { return getToken(XmlDslParser.TYPE, 0); }
		public TerminalNode SET() { return getToken(XmlDslParser.SET, 0); }
		public TerminalNode DICT() { return getToken(XmlDslParser.DICT, 0); }
		public TerminalNode PAIR() { return getToken(XmlDslParser.PAIR, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlDslParserListener ) ((XmlDslParserListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(591);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & -9007199254740992L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001]\u0252\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0005\u0002n\b\u0002\n\u0002\f\u0002q\t\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0005\u0005|\b\u0005\n\u0005\f\u0005\u007f"+
		"\t\u0005\u0001\u0005\u0001\u0005\u0004\u0005\u0083\b\u0005\u000b\u0005"+
		"\f\u0005\u0084\u0001\u0005\u0003\u0005\u0088\b\u0005\u0005\u0005\u008a"+
		"\b\u0005\n\u0005\f\u0005\u008d\t\u0005\u0003\u0005\u008f\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u0095\b\u0006\u0001"+
		"\u0007\u0001\u0007\u0003\u0007\u0099\b\u0007\u0001\b\u0001\b\u0005\b\u009d"+
		"\b\b\n\b\f\b\u00a0\t\b\u0001\b\u0001\b\u0001\b\u0005\b\u00a5\b\b\n\b\f"+
		"\b\u00a8\t\b\u0001\t\u0001\t\u0005\t\u00ac\b\t\n\t\f\t\u00af\t\t\u0001"+
		"\t\u0001\t\u0005\t\u00b3\b\t\n\t\f\t\u00b6\t\t\u0001\t\u0003\t\u00b9\b"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0003\n\u00c4\b\n\u0001\u000b\u0001\u000b\u0003\u000b\u00c8\b\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0003\f\u00cd\b\f\u0001\r\u0001\r\u0005\r\u00d1"+
		"\b\r\n\r\f\r\u00d4\t\r\u0001\r\u0001\r\u0005\r\u00d8\b\r\n\r\f\r\u00db"+
		"\t\r\u0001\r\u0005\r\u00de\b\r\n\r\f\r\u00e1\t\r\u0001\u000e\u0001\u000e"+
		"\u0005\u000e\u00e5\b\u000e\n\u000e\f\u000e\u00e8\t\u000e\u0001\u000e\u0001"+
		"\u000e\u0005\u000e\u00ec\b\u000e\n\u000e\f\u000e\u00ef\t\u000e\u0001\u000e"+
		"\u0005\u000e\u00f2\b\u000e\n\u000e\f\u000e\u00f5\t\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0005\u000f\u00fa\b\u000f\n\u000f\f\u000f\u00fd\t\u000f"+
		"\u0001\u000f\u0001\u000f\u0003\u000f\u0101\b\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0005\u0010\u0106\b\u0010\n\u0010\f\u0010\u0109\t\u0010\u0001"+
		"\u0010\u0001\u0010\u0003\u0010\u010d\b\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0005\u0011\u0112\b\u0011\n\u0011\f\u0011\u0115\t\u0011\u0001\u0011"+
		"\u0001\u0011\u0003\u0011\u0119\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0005\u0012\u011e\b\u0012\n\u0012\f\u0012\u0121\t\u0012\u0001\u0012\u0003"+
		"\u0012\u0124\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u0129"+
		"\b\u0013\n\u0013\f\u0013\u012c\t\u0013\u0001\u0013\u0001\u0013\u0005\u0013"+
		"\u0130\b\u0013\n\u0013\f\u0013\u0133\t\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0005\u0014\u0138\b\u0014\n\u0014\f\u0014\u013b\t\u0014\u0001\u0014"+
		"\u0001\u0014\u0005\u0014\u013f\b\u0014\n\u0014\f\u0014\u0142\t\u0014\u0001"+
		"\u0015\u0005\u0015\u0145\b\u0015\n\u0015\f\u0015\u0148\t\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0003\u0017"+
		"\u0150\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0003\u0018\u0159\b\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0003\u001a\u0164\b\u001a\u0001\u001b\u0001\u001b\u0005\u001b"+
		"\u0168\b\u001b\n\u001b\f\u001b\u016b\t\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0005\u001b\u0170\b\u001b\n\u001b\f\u001b\u0173\t\u001b\u0001\u001b"+
		"\u0003\u001b\u0176\b\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0003\u001c\u017c\b\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001e\u0001\u001e\u0005\u001e\u0184\b\u001e\n\u001e\f\u001e\u0187"+
		"\t\u001e\u0001\u001e\u0001\u001e\u0005\u001e\u018b\b\u001e\n\u001e\f\u001e"+
		"\u018e\t\u001e\u0001\u001e\u0001\u001e\u0005\u001e\u0192\b\u001e\n\u001e"+
		"\f\u001e\u0195\t\u001e\u0001\u001e\u0001\u001e\u0005\u001e\u0199\b\u001e"+
		"\n\u001e\f\u001e\u019c\t\u001e\u0001\u001e\u0003\u001e\u019f\b\u001e\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u01a5\b\u001f\u0003"+
		"\u001f\u01a7\b\u001f\u0001 \u0001 \u0003 \u01ab\b \u0001!\u0001!\u0005"+
		"!\u01af\b!\n!\f!\u01b2\t!\u0001!\u0001!\u0001!\u0001!\u0005!\u01b8\b!"+
		"\n!\f!\u01bb\t!\u0001!\u0001!\u0001\"\u0001\"\u0005\"\u01c1\b\"\n\"\f"+
		"\"\u01c4\t\"\u0001\"\u0001\"\u0005\"\u01c8\b\"\n\"\f\"\u01cb\t\"\u0001"+
		"\"\u0001\"\u0001#\u0001#\u0003#\u01d1\b#\u0001#\u0001#\u0005#\u01d5\b"+
		"#\n#\f#\u01d8\t#\u0001#\u0003#\u01db\b#\u0001#\u0001#\u0001$\u0001$\u0001"+
		"$\u0001$\u0005$\u01e3\b$\n$\f$\u01e6\t$\u0001$\u0003$\u01e9\b$\u0003$"+
		"\u01eb\b$\u0001$\u0001$\u0001%\u0001%\u0001%\u0001%\u0001&\u0001&\u0001"+
		"&\u0001&\u0005&\u01f7\b&\n&\f&\u01fa\t&\u0001&\u0003&\u01fd\b&\u0003&"+
		"\u01ff\b&\u0001&\u0001&\u0001\'\u0001\'\u0003\'\u0205\b\'\u0001(\u0001"+
		"(\u0001(\u0001(\u0001)\u0001)\u0001)\u0001)\u0005)\u020f\b)\n)\f)\u0212"+
		"\t)\u0001)\u0003)\u0215\b)\u0003)\u0217\b)\u0001)\u0001)\u0001*\u0001"+
		"*\u0001+\u0001+\u0001,\u0001,\u0001-\u0001-\u0001.\u0001.\u0001/\u0001"+
		"/\u00010\u00010\u00050\u0229\b0\n0\f0\u022c\t0\u00010\u00030\u022f\b0"+
		"\u00010\u00050\u0232\b0\n0\f0\u0235\t0\u00010\u00010\u00050\u0239\b0\n"+
		"0\f0\u023c\t0\u00010\u00010\u00011\u00011\u00011\u00011\u00051\u0244\b"+
		"1\n1\f1\u0247\t1\u00011\u00031\u024a\b1\u00031\u024c\b1\u00011\u00011"+
		"\u00012\u00012\u00012\u0000\u00003\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDF"+
		"HJLNPRTVXZ\\^`bd\u0000\u000b\u0002\u0000\u0004\u0004\u0016\u0016\u0001"+
		"\u0000NO\u0001\u0000)+\u0002\u0000\u0010\u0011\u0014\u0014\u0001\u0000"+
		"\r\u000f\u0001\u0000\u0010\u0011\u0001\u000034\u0001\u0000!$\u0001\u0000"+
		"%&\u0001\u0000\u0017\u001c\u0001\u00005?\u0276\u0000f\u0001\u0000\u0000"+
		"\u0000\u0002i\u0001\u0000\u0000\u0000\u0004k\u0001\u0000\u0000\u0000\u0006"+
		"t\u0001\u0000\u0000\u0000\bv\u0001\u0000\u0000\u0000\n}\u0001\u0000\u0000"+
		"\u0000\f\u0094\u0001\u0000\u0000\u0000\u000e\u0098\u0001\u0000\u0000\u0000"+
		"\u0010\u009a\u0001\u0000\u0000\u0000\u0012\u00a9\u0001\u0000\u0000\u0000"+
		"\u0014\u00c3\u0001\u0000\u0000\u0000\u0016\u00c7\u0001\u0000\u0000\u0000"+
		"\u0018\u00cc\u0001\u0000\u0000\u0000\u001a\u00ce\u0001\u0000\u0000\u0000"+
		"\u001c\u00e2\u0001\u0000\u0000\u0000\u001e\u00f6\u0001\u0000\u0000\u0000"+
		" \u0102\u0001\u0000\u0000\u0000\"\u010e\u0001\u0000\u0000\u0000$\u011a"+
		"\u0001\u0000\u0000\u0000&\u0125\u0001\u0000\u0000\u0000(\u0134\u0001\u0000"+
		"\u0000\u0000*\u0146\u0001\u0000\u0000\u0000,\u014b\u0001\u0000\u0000\u0000"+
		".\u014d\u0001\u0000\u0000\u00000\u0158\u0001\u0000\u0000\u00002\u015a"+
		"\u0001\u0000\u0000\u00004\u0163\u0001\u0000\u0000\u00006\u0175\u0001\u0000"+
		"\u0000\u00008\u017b\u0001\u0000\u0000\u0000:\u017d\u0001\u0000\u0000\u0000"+
		"<\u0181\u0001\u0000\u0000\u0000>\u01a6\u0001\u0000\u0000\u0000@\u01aa"+
		"\u0001\u0000\u0000\u0000B\u01ac\u0001\u0000\u0000\u0000D\u01be\u0001\u0000"+
		"\u0000\u0000F\u01ce\u0001\u0000\u0000\u0000H\u01de\u0001\u0000\u0000\u0000"+
		"J\u01ee\u0001\u0000\u0000\u0000L\u01f2\u0001\u0000\u0000\u0000N\u0204"+
		"\u0001\u0000\u0000\u0000P\u0206\u0001\u0000\u0000\u0000R\u020a\u0001\u0000"+
		"\u0000\u0000T\u021a\u0001\u0000\u0000\u0000V\u021c\u0001\u0000\u0000\u0000"+
		"X\u021e\u0001\u0000\u0000\u0000Z\u0220\u0001\u0000\u0000\u0000\\\u0222"+
		"\u0001\u0000\u0000\u0000^\u0224\u0001\u0000\u0000\u0000`\u0226\u0001\u0000"+
		"\u0000\u0000b\u023f\u0001\u0000\u0000\u0000d\u024f\u0001\u0000\u0000\u0000"+
		"fg\u0003\n\u0005\u0000gh\u0005\u0000\u0000\u0001h\u0001\u0001\u0000\u0000"+
		"\u0000ij\u0007\u0000\u0000\u0000j\u0003\u0001\u0000\u0000\u0000ko\u0003"+
		"\u0006\u0003\u0000ln\u0005\u0004\u0000\u0000ml\u0001\u0000\u0000\u0000"+
		"nq\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000op\u0001\u0000\u0000"+
		"\u0000pr\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000rs\u0003\b\u0004"+
		"\u0000s\u0005\u0001\u0000\u0000\u0000tu\u0007\u0001\u0000\u0000u\u0007"+
		"\u0001\u0000\u0000\u0000vw\u0005\u000b\u0000\u0000wx\u0003\n\u0005\u0000"+
		"xy\u0005\f\u0000\u0000y\t\u0001\u0000\u0000\u0000z|\u0003\u0002\u0001"+
		"\u0000{z\u0001\u0000\u0000\u0000|\u007f\u0001\u0000\u0000\u0000}{\u0001"+
		"\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u008e\u0001\u0000\u0000"+
		"\u0000\u007f}\u0001\u0000\u0000\u0000\u0080\u008b\u0003\f\u0006\u0000"+
		"\u0081\u0083\u0003\u0002\u0001\u0000\u0082\u0081\u0001\u0000\u0000\u0000"+
		"\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000"+
		"\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0087\u0001\u0000\u0000\u0000"+
		"\u0086\u0088\u0003\f\u0006\u0000\u0087\u0086\u0001\u0000\u0000\u0000\u0087"+
		"\u0088\u0001\u0000\u0000\u0000\u0088\u008a\u0001\u0000\u0000\u0000\u0089"+
		"\u0082\u0001\u0000\u0000\u0000\u008a\u008d\u0001\u0000\u0000\u0000\u008b"+
		"\u0089\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c"+
		"\u008f\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008e"+
		"\u0080\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f"+
		"\u000b\u0001\u0000\u0000\u0000\u0090\u0095\u0003\u000e\u0007\u0000\u0091"+
		"\u0095\u0003\u0014\n\u0000\u0092\u0095\u0003\u0016\u000b\u0000\u0093\u0095"+
		"\u0003\u0018\f\u0000\u0094\u0090\u0001\u0000\u0000\u0000\u0094\u0091\u0001"+
		"\u0000\u0000\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0094\u0093\u0001"+
		"\u0000\u0000\u0000\u0095\r\u0001\u0000\u0000\u0000\u0096\u0099\u0003\u0010"+
		"\b\u0000\u0097\u0099\u0003`0\u0000\u0098\u0096\u0001\u0000\u0000\u0000"+
		"\u0098\u0097\u0001\u0000\u0000\u0000\u0099\u000f\u0001\u0000\u0000\u0000"+
		"\u009a\u009e\u0007\u0002\u0000\u0000\u009b\u009d\u0005\u0004\u0000\u0000"+
		"\u009c\u009b\u0001\u0000\u0000\u0000\u009d\u00a0\u0001\u0000\u0000\u0000"+
		"\u009e\u009c\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000"+
		"\u009f\u00a1\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000\u0000\u0000"+
		"\u00a1\u00a6\u0003\u0012\t\u0000\u00a2\u00a3\u0005\u0006\u0000\u0000\u00a3"+
		"\u00a5\u0003\u0012\t\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a5\u00a8"+
		"\u0001\u0000\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a7"+
		"\u0001\u0000\u0000\u0000\u00a7\u0011\u0001\u0000\u0000\u0000\u00a8\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a9\u00b8\u0003\u0006\u0003\u0000\u00aa\u00ac"+
		"\u0005\u0004\u0000\u0000\u00ab\u00aa\u0001\u0000\u0000\u0000\u00ac\u00af"+
		"\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ae"+
		"\u0001\u0000\u0000\u0000\u00ae\u00b0\u0001\u0000\u0000\u0000\u00af\u00ad"+
		"\u0001\u0000\u0000\u0000\u00b0\u00b4\u0005\u0017\u0000\u0000\u00b1\u00b3"+
		"\u0005\u0004\u0000\u0000\u00b2\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b6"+
		"\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b5"+
		"\u0001\u0000\u0000\u0000\u00b5\u00b7\u0001\u0000\u0000\u0000\u00b6\u00b4"+
		"\u0001\u0000\u0000\u0000\u00b7\u00b9\u0003\u0016\u000b\u0000\u00b8\u00ad"+
		"\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9\u0013"+
		"\u0001\u0000\u0000\u0000\u00ba\u00bb\u0003\u0006\u0003\u0000\u00bb\u00bc"+
		"\u0003^/\u0000\u00bc\u00bd\u0003\u0016\u000b\u0000\u00bd\u00c4\u0001\u0000"+
		"\u0000\u0000\u00be\u00bf\u0003\u0006\u0003\u0000\u00bf\u00c0\u0003P(\u0000"+
		"\u00c0\u00c1\u0003^/\u0000\u00c1\u00c2\u0003\u0016\u000b\u0000\u00c2\u00c4"+
		"\u0001\u0000\u0000\u0000\u00c3\u00ba\u0001\u0000\u0000\u0000\u00c3\u00be"+
		"\u0001\u0000\u0000\u0000\u00c4\u0015\u0001\u0000\u0000\u0000\u00c5\u00c8"+
		"\u0003\u0004\u0002\u0000\u00c6\u00c8\u0003\u001a\r\u0000\u00c7\u00c5\u0001"+
		"\u0000\u0000\u0000\u00c7\u00c6\u0001\u0000\u0000\u0000\u00c8\u0017\u0001"+
		"\u0000\u0000\u0000\u00c9\u00cd\u0003<\u001e\u0000\u00ca\u00cd\u0003>\u001f"+
		"\u0000\u00cb\u00cd\u0003@ \u0000\u00cc\u00c9\u0001\u0000\u0000\u0000\u00cc"+
		"\u00ca\u0001\u0000\u0000\u0000\u00cc\u00cb\u0001\u0000\u0000\u0000\u00cd"+
		"\u0019\u0001\u0000\u0000\u0000\u00ce\u00df\u0003\u001c\u000e\u0000\u00cf"+
		"\u00d1\u0005\u0004\u0000\u0000\u00d0\u00cf\u0001\u0000\u0000\u0000\u00d1"+
		"\u00d4\u0001\u0000\u0000\u0000\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d2"+
		"\u00d3\u0001\u0000\u0000\u0000\u00d3\u00d5\u0001\u0000\u0000\u0000\u00d4"+
		"\u00d2\u0001\u0000\u0000\u0000\u00d5\u00d9\u0005\u0013\u0000\u0000\u00d6"+
		"\u00d8\u0005\u0004\u0000\u0000\u00d7\u00d6\u0001\u0000\u0000\u0000\u00d8"+
		"\u00db\u0001\u0000\u0000\u0000\u00d9\u00d7\u0001\u0000\u0000\u0000\u00d9"+
		"\u00da\u0001\u0000\u0000\u0000\u00da\u00dc\u0001\u0000\u0000\u0000\u00db"+
		"\u00d9\u0001\u0000\u0000\u0000\u00dc\u00de\u0003\u001c\u000e\u0000\u00dd"+
		"\u00d2\u0001\u0000\u0000\u0000\u00de\u00e1\u0001\u0000\u0000\u0000\u00df"+
		"\u00dd\u0001\u0000\u0000\u0000\u00df\u00e0\u0001\u0000\u0000\u0000\u00e0"+
		"\u001b\u0001\u0000\u0000\u0000\u00e1\u00df\u0001\u0000\u0000\u0000\u00e2"+
		"\u00f3\u0003\u001e\u000f\u0000\u00e3\u00e5\u0005\u0004\u0000\u0000\u00e4"+
		"\u00e3\u0001\u0000\u0000\u0000\u00e5\u00e8\u0001\u0000\u0000\u0000\u00e6"+
		"\u00e4\u0001\u0000\u0000\u0000\u00e6\u00e7\u0001\u0000\u0000\u0000\u00e7"+
		"\u00e9\u0001\u0000\u0000\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000\u00e9"+
		"\u00ed\u0005\u0012\u0000\u0000\u00ea\u00ec\u0005\u0004\u0000\u0000\u00eb"+
		"\u00ea\u0001\u0000\u0000\u0000\u00ec\u00ef\u0001\u0000\u0000\u0000\u00ed"+
		"\u00eb\u0001\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000\u00ee"+
		"\u00f0\u0001\u0000\u0000\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000\u00f0"+
		"\u00f2\u0003\u001e\u000f\u0000\u00f1\u00e6\u0001\u0000\u0000\u0000\u00f2"+
		"\u00f5\u0001\u0000\u0000\u0000\u00f3\u00f1\u0001\u0000\u0000\u0000\u00f3"+
		"\u00f4\u0001\u0000\u0000\u0000\u00f4\u001d\u0001\u0000\u0000\u0000\u00f5"+
		"\u00f3\u0001\u0000\u0000\u0000\u00f6\u0100\u0003 \u0010\u0000\u00f7\u00fb"+
		"\u0003\\.\u0000\u00f8\u00fa\u0005\u0004\u0000\u0000\u00f9\u00f8\u0001"+
		"\u0000\u0000\u0000\u00fa\u00fd\u0001\u0000\u0000\u0000\u00fb\u00f9\u0001"+
		"\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u00fe\u0001"+
		"\u0000\u0000\u0000\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fe\u00ff\u0003"+
		" \u0010\u0000\u00ff\u0101\u0001\u0000\u0000\u0000\u0100\u00f7\u0001\u0000"+
		"\u0000\u0000\u0100\u0101\u0001\u0000\u0000\u0000\u0101\u001f\u0001\u0000"+
		"\u0000\u0000\u0102\u010c\u0003\"\u0011\u0000\u0103\u0107\u0003Z-\u0000"+
		"\u0104\u0106\u0005\u0004\u0000\u0000\u0105\u0104\u0001\u0000\u0000\u0000"+
		"\u0106\u0109\u0001\u0000\u0000\u0000\u0107\u0105\u0001\u0000\u0000\u0000"+
		"\u0107\u0108\u0001\u0000\u0000\u0000\u0108\u010a\u0001\u0000\u0000\u0000"+
		"\u0109\u0107\u0001\u0000\u0000\u0000\u010a\u010b\u0003\"\u0011\u0000\u010b"+
		"\u010d\u0001\u0000\u0000\u0000\u010c\u0103\u0001\u0000\u0000\u0000\u010c"+
		"\u010d\u0001\u0000\u0000\u0000\u010d!\u0001\u0000\u0000\u0000\u010e\u0118"+
		"\u0003$\u0012\u0000\u010f\u0113\u0003X,\u0000\u0110\u0112\u0005\u0004"+
		"\u0000\u0000\u0111\u0110\u0001\u0000\u0000\u0000\u0112\u0115\u0001\u0000"+
		"\u0000\u0000\u0113\u0111\u0001\u0000\u0000\u0000\u0113\u0114\u0001\u0000"+
		"\u0000\u0000\u0114\u0116\u0001\u0000\u0000\u0000\u0115\u0113\u0001\u0000"+
		"\u0000\u0000\u0116\u0117\u0003$\u0012\u0000\u0117\u0119\u0001\u0000\u0000"+
		"\u0000\u0118\u010f\u0001\u0000\u0000\u0000\u0118\u0119\u0001\u0000\u0000"+
		"\u0000\u0119#\u0001\u0000\u0000\u0000\u011a\u0123\u0003&\u0013\u0000\u011b"+
		"\u011f\u0005\u001d\u0000\u0000\u011c\u011e\u0005\u0004\u0000\u0000\u011d"+
		"\u011c\u0001\u0000\u0000\u0000\u011e\u0121\u0001\u0000\u0000\u0000\u011f"+
		"\u011d\u0001\u0000\u0000\u0000\u011f\u0120\u0001\u0000\u0000\u0000\u0120"+
		"\u0122\u0001\u0000\u0000\u0000\u0121\u011f\u0001\u0000\u0000\u0000\u0122"+
		"\u0124\u0003&\u0013\u0000\u0123\u011b\u0001\u0000\u0000\u0000\u0123\u0124"+
		"\u0001\u0000\u0000\u0000\u0124%\u0001\u0000\u0000\u0000\u0125\u0131\u0003"+
		"(\u0014\u0000\u0126\u012a\u0003V+\u0000\u0127\u0129\u0005\u0004\u0000"+
		"\u0000\u0128\u0127\u0001\u0000\u0000\u0000\u0129\u012c\u0001\u0000\u0000"+
		"\u0000\u012a\u0128\u0001\u0000\u0000\u0000\u012a\u012b\u0001\u0000\u0000"+
		"\u0000\u012b\u012d\u0001\u0000\u0000\u0000\u012c\u012a\u0001\u0000\u0000"+
		"\u0000\u012d\u012e\u0003(\u0014\u0000\u012e\u0130\u0001\u0000\u0000\u0000"+
		"\u012f\u0126\u0001\u0000\u0000\u0000\u0130\u0133\u0001\u0000\u0000\u0000"+
		"\u0131\u012f\u0001\u0000\u0000\u0000\u0131\u0132\u0001\u0000\u0000\u0000"+
		"\u0132\'\u0001\u0000\u0000\u0000\u0133\u0131\u0001\u0000\u0000\u0000\u0134"+
		"\u0140\u0003*\u0015\u0000\u0135\u0139\u0003T*\u0000\u0136\u0138\u0005"+
		"\u0004\u0000\u0000\u0137\u0136\u0001\u0000\u0000\u0000\u0138\u013b\u0001"+
		"\u0000\u0000\u0000\u0139\u0137\u0001\u0000\u0000\u0000\u0139\u013a\u0001"+
		"\u0000\u0000\u0000\u013a\u013c\u0001\u0000\u0000\u0000\u013b\u0139\u0001"+
		"\u0000\u0000\u0000\u013c\u013d\u0003*\u0015\u0000\u013d\u013f\u0001\u0000"+
		"\u0000\u0000\u013e\u0135\u0001\u0000\u0000\u0000\u013f\u0142\u0001\u0000"+
		"\u0000\u0000\u0140\u013e\u0001\u0000\u0000\u0000\u0140\u0141\u0001\u0000"+
		"\u0000\u0000\u0141)\u0001\u0000\u0000\u0000\u0142\u0140\u0001\u0000\u0000"+
		"\u0000\u0143\u0145\u0003,\u0016\u0000\u0144\u0143\u0001\u0000\u0000\u0000"+
		"\u0145\u0148\u0001\u0000\u0000\u0000\u0146\u0144\u0001\u0000\u0000\u0000"+
		"\u0146\u0147\u0001\u0000\u0000\u0000\u0147\u0149\u0001\u0000\u0000\u0000"+
		"\u0148\u0146\u0001\u0000\u0000\u0000\u0149\u014a\u0003.\u0017\u0000\u014a"+
		"+\u0001\u0000\u0000\u0000\u014b\u014c\u0007\u0003\u0000\u0000\u014c-\u0001"+
		"\u0000\u0000\u0000\u014d\u014f\u00030\u0018\u0000\u014e\u0150\u0003N\'"+
		"\u0000\u014f\u014e\u0001\u0000\u0000\u0000\u014f\u0150\u0001\u0000\u0000"+
		"\u0000\u0150/\u0001\u0000\u0000\u0000\u0151\u0159\u0003\u0006\u0003\u0000"+
		"\u0152\u0159\u00032\u0019\u0000\u0153\u0159\u00034\u001a\u0000\u0154\u0159"+
		"\u0003F#\u0000\u0155\u0159\u0003H$\u0000\u0156\u0159\u0003L&\u0000\u0157"+
		"\u0159\u0003d2\u0000\u0158\u0151\u0001\u0000\u0000\u0000\u0158\u0152\u0001"+
		"\u0000\u0000\u0000\u0158\u0153\u0001\u0000\u0000\u0000\u0158\u0154\u0001"+
		"\u0000\u0000\u0000\u0158\u0155\u0001\u0000\u0000\u0000\u0158\u0156\u0001"+
		"\u0000\u0000\u0000\u0158\u0157\u0001\u0000\u0000\u0000\u01591\u0001\u0000"+
		"\u0000\u0000\u015a\u015b\u0005\u0007\u0000\u0000\u015b\u015c\u0003\u0016"+
		"\u000b\u0000\u015c\u015d\u0005\b\u0000\u0000\u015d3\u0001\u0000\u0000"+
		"\u0000\u015e\u0164\u0005L\u0000\u0000\u015f\u0164\u0005K\u0000\u0000\u0160"+
		"\u0164\u00036\u001b\u0000\u0161\u0164\u0005M\u0000\u0000\u0162\u0164\u0005"+
		"0\u0000\u0000\u0163\u015e\u0001\u0000\u0000\u0000\u0163\u015f\u0001\u0000"+
		"\u0000\u0000\u0163\u0160\u0001\u0000\u0000\u0000\u0163\u0161\u0001\u0000"+
		"\u0000\u0000\u0163\u0162\u0001\u0000\u0000\u0000\u01645\u0001\u0000\u0000"+
		"\u0000\u0165\u0169\u0005\'\u0000\u0000\u0166\u0168\u00038\u001c\u0000"+
		"\u0167\u0166\u0001\u0000\u0000\u0000\u0168\u016b\u0001\u0000\u0000\u0000"+
		"\u0169\u0167\u0001\u0000\u0000\u0000\u0169\u016a\u0001\u0000\u0000\u0000"+
		"\u016a\u016c\u0001\u0000\u0000\u0000\u016b\u0169\u0001\u0000\u0000\u0000"+
		"\u016c\u0176\u0005Y\u0000\u0000\u016d\u0171\u0005(\u0000\u0000\u016e\u0170"+
		"\u00038\u001c\u0000\u016f\u016e\u0001\u0000\u0000\u0000\u0170\u0173\u0001"+
		"\u0000\u0000\u0000\u0171\u016f\u0001\u0000\u0000\u0000\u0171\u0172\u0001"+
		"\u0000\u0000\u0000\u0172\u0174\u0001\u0000\u0000\u0000\u0173\u0171\u0001"+
		"\u0000\u0000\u0000\u0174\u0176\u0005S\u0000\u0000\u0175\u0165\u0001\u0000"+
		"\u0000\u0000\u0175\u016d\u0001\u0000\u0000\u0000\u01767\u0001\u0000\u0000"+
		"\u0000\u0177\u017c\u0005T\u0000\u0000\u0178\u017c\u0005U\u0000\u0000\u0179"+
		"\u017c\u0005V\u0000\u0000\u017a\u017c\u0003:\u001d\u0000\u017b\u0177\u0001"+
		"\u0000\u0000\u0000\u017b\u0178\u0001\u0000\u0000\u0000\u017b\u0179\u0001"+
		"\u0000\u0000\u0000\u017b\u017a\u0001\u0000\u0000\u0000\u017c9\u0001\u0000"+
		"\u0000\u0000\u017d\u017e\u0005W\u0000\u0000\u017e\u017f\u0003\u0016\u000b"+
		"\u0000\u017f\u0180\u0005\f\u0000\u0000\u0180;\u0001\u0000\u0000\u0000"+
		"\u0181\u0185\u0005,\u0000\u0000\u0182\u0184\u0005\u0004\u0000\u0000\u0183"+
		"\u0182\u0001\u0000\u0000\u0000\u0184\u0187\u0001\u0000\u0000\u0000\u0185"+
		"\u0183\u0001\u0000\u0000\u0000\u0185\u0186\u0001\u0000\u0000\u0000\u0186"+
		"\u0188\u0001\u0000\u0000\u0000\u0187\u0185\u0001\u0000\u0000\u0000\u0188"+
		"\u018c\u0003\u0016\u000b\u0000\u0189\u018b\u0005\u0004\u0000\u0000\u018a"+
		"\u0189\u0001\u0000\u0000\u0000\u018b\u018e\u0001\u0000\u0000\u0000\u018c"+
		"\u018a\u0001\u0000\u0000\u0000\u018c\u018d\u0001\u0000\u0000\u0000\u018d"+
		"\u018f\u0001\u0000\u0000\u0000\u018e\u018c\u0001\u0000\u0000\u0000\u018f"+
		"\u019e\u0003\b\u0004\u0000\u0190\u0192\u0005\u0004\u0000\u0000\u0191\u0190"+
		"\u0001\u0000\u0000\u0000\u0192\u0195\u0001\u0000\u0000\u0000\u0193\u0191"+
		"\u0001\u0000\u0000\u0000\u0193\u0194\u0001\u0000\u0000\u0000\u0194\u0196"+
		"\u0001\u0000\u0000\u0000\u0195\u0193\u0001\u0000\u0000\u0000\u0196\u019a"+
		"\u0005-\u0000\u0000\u0197\u0199\u0005\u0004\u0000\u0000\u0198\u0197\u0001"+
		"\u0000\u0000\u0000\u0199\u019c\u0001\u0000\u0000\u0000\u019a\u0198\u0001"+
		"\u0000\u0000\u0000\u019a\u019b\u0001\u0000\u0000\u0000\u019b\u019d\u0001"+
		"\u0000\u0000\u0000\u019c\u019a\u0001\u0000\u0000\u0000\u019d\u019f\u0003"+
		"\b\u0004\u0000\u019e\u0193\u0001\u0000\u0000\u0000\u019e\u019f\u0001\u0000"+
		"\u0000\u0000\u019f=\u0001\u0000\u0000\u0000\u01a0\u01a7\u00051\u0000\u0000"+
		"\u01a1\u01a7\u00052\u0000\u0000\u01a2\u01a4\u0005D\u0000\u0000\u01a3\u01a5"+
		"\u0003\u0016\u000b\u0000\u01a4\u01a3\u0001\u0000\u0000\u0000\u01a4\u01a5"+
		"\u0001\u0000\u0000\u0000\u01a5\u01a7\u0001\u0000\u0000\u0000\u01a6\u01a0"+
		"\u0001\u0000\u0000\u0000\u01a6\u01a1\u0001\u0000\u0000\u0000\u01a6\u01a2"+
		"\u0001\u0000\u0000\u0000\u01a7?\u0001\u0000\u0000\u0000\u01a8\u01ab\u0003"+
		"B!\u0000\u01a9\u01ab\u0003D\"\u0000\u01aa\u01a8\u0001\u0000\u0000\u0000"+
		"\u01aa\u01a9\u0001\u0000\u0000\u0000\u01abA\u0001\u0000\u0000\u0000\u01ac"+
		"\u01b0\u0005.\u0000\u0000\u01ad\u01af\u0005\u0004\u0000\u0000\u01ae\u01ad"+
		"\u0001\u0000\u0000\u0000\u01af\u01b2\u0001\u0000\u0000\u0000\u01b0\u01ae"+
		"\u0001\u0000\u0000\u0000\u01b0\u01b1\u0001\u0000\u0000\u0000\u01b1\u01b3"+
		"\u0001\u0000\u0000\u0000\u01b2\u01b0\u0001\u0000\u0000\u0000\u01b3\u01b4"+
		"\u0003\u0006\u0003\u0000\u01b4\u01b5\u00053\u0000\u0000\u01b5\u01b9\u0003"+
		"\u0016\u000b\u0000\u01b6\u01b8\u0005\u0004\u0000\u0000\u01b7\u01b6\u0001"+
		"\u0000\u0000\u0000\u01b8\u01bb\u0001\u0000\u0000\u0000\u01b9\u01b7\u0001"+
		"\u0000\u0000\u0000\u01b9\u01ba\u0001\u0000\u0000\u0000\u01ba\u01bc\u0001"+
		"\u0000\u0000\u0000\u01bb\u01b9\u0001\u0000\u0000\u0000\u01bc\u01bd\u0003"+
		"\b\u0004\u0000\u01bdC\u0001\u0000\u0000\u0000\u01be\u01c2\u0005/\u0000"+
		"\u0000\u01bf\u01c1\u0005\u0004\u0000\u0000\u01c0\u01bf\u0001\u0000\u0000"+
		"\u0000\u01c1\u01c4\u0001\u0000\u0000\u0000\u01c2\u01c0\u0001\u0000\u0000"+
		"\u0000\u01c2\u01c3\u0001\u0000\u0000\u0000\u01c3\u01c5\u0001\u0000\u0000"+
		"\u0000\u01c4\u01c2\u0001\u0000\u0000\u0000\u01c5\u01c9\u0003\u0016\u000b"+
		"\u0000\u01c6\u01c8\u0005\u0004\u0000\u0000\u01c7\u01c6\u0001\u0000\u0000"+
		"\u0000\u01c8\u01cb\u0001\u0000\u0000\u0000\u01c9\u01c7\u0001\u0000\u0000"+
		"\u0000\u01c9\u01ca\u0001\u0000\u0000\u0000\u01ca\u01cc\u0001\u0000\u0000"+
		"\u0000\u01cb\u01c9\u0001\u0000\u0000\u0000\u01cc\u01cd\u0003\b\u0004\u0000"+
		"\u01cdE\u0001\u0000\u0000\u0000\u01ce\u01d0\u0005\t\u0000\u0000\u01cf"+
		"\u01d1\u0003\u0016\u000b\u0000\u01d0\u01cf\u0001\u0000\u0000\u0000\u01d0"+
		"\u01d1\u0001\u0000\u0000\u0000\u01d1\u01d6\u0001\u0000\u0000\u0000\u01d2"+
		"\u01d3\u0005\u0006\u0000\u0000\u01d3\u01d5\u0003\u0016\u000b\u0000\u01d4"+
		"\u01d2\u0001\u0000\u0000\u0000\u01d5\u01d8\u0001\u0000\u0000\u0000\u01d6"+
		"\u01d4\u0001\u0000\u0000\u0000\u01d6\u01d7\u0001\u0000\u0000\u0000\u01d7"+
		"\u01da\u0001\u0000\u0000\u0000\u01d8\u01d6\u0001\u0000\u0000\u0000\u01d9"+
		"\u01db\u0005\u0006\u0000\u0000\u01da\u01d9\u0001\u0000\u0000\u0000\u01da"+
		"\u01db\u0001\u0000\u0000\u0000\u01db\u01dc\u0001\u0000\u0000\u0000\u01dc"+
		"\u01dd\u0005\n\u0000\u0000\u01ddG\u0001\u0000\u0000\u0000\u01de\u01ea"+
		"\u0005\u000b\u0000\u0000\u01df\u01e4\u0003J%\u0000\u01e0\u01e1\u0005\u0006"+
		"\u0000\u0000\u01e1\u01e3\u0003J%\u0000\u01e2\u01e0\u0001\u0000\u0000\u0000"+
		"\u01e3\u01e6\u0001\u0000\u0000\u0000\u01e4\u01e2\u0001\u0000\u0000\u0000"+
		"\u01e4\u01e5\u0001\u0000\u0000\u0000\u01e5\u01e8\u0001\u0000\u0000\u0000"+
		"\u01e6\u01e4\u0001\u0000\u0000\u0000\u01e7\u01e9\u0005\u0006\u0000\u0000"+
		"\u01e8\u01e7\u0001\u0000\u0000\u0000\u01e8\u01e9\u0001\u0000\u0000\u0000"+
		"\u01e9\u01eb\u0001\u0000\u0000\u0000\u01ea\u01df\u0001\u0000\u0000\u0000"+
		"\u01ea\u01eb\u0001\u0000\u0000\u0000\u01eb\u01ec\u0001\u0000\u0000\u0000"+
		"\u01ec\u01ed\u0005\f\u0000\u0000\u01edI\u0001\u0000\u0000\u0000\u01ee"+
		"\u01ef\u0003\u0016\u000b\u0000\u01ef\u01f0\u0005\u0015\u0000\u0000\u01f0"+
		"\u01f1\u0003\u0016\u000b\u0000\u01f1K\u0001\u0000\u0000\u0000\u01f2\u01fe"+
		"\u0005!\u0000\u0000\u01f3\u01f8\u0003\u0016\u000b\u0000\u01f4\u01f5\u0005"+
		"\u0006\u0000\u0000\u01f5\u01f7\u0003\u0016\u000b\u0000\u01f6\u01f4\u0001"+
		"\u0000\u0000\u0000\u01f7\u01fa\u0001\u0000\u0000\u0000\u01f8\u01f6\u0001"+
		"\u0000\u0000\u0000\u01f8\u01f9\u0001\u0000\u0000\u0000\u01f9\u01fc\u0001"+
		"\u0000\u0000\u0000\u01fa\u01f8\u0001\u0000\u0000\u0000\u01fb\u01fd\u0005"+
		"\u0006\u0000\u0000\u01fc\u01fb\u0001\u0000\u0000\u0000\u01fc\u01fd\u0001"+
		"\u0000\u0000\u0000\u01fd\u01ff\u0001\u0000\u0000\u0000\u01fe\u01f3\u0001"+
		"\u0000\u0000\u0000\u01fe\u01ff\u0001\u0000\u0000\u0000\u01ff\u0200\u0001"+
		"\u0000\u0000\u0000\u0200\u0201\u0005\"\u0000\u0000\u0201M\u0001\u0000"+
		"\u0000\u0000\u0202\u0205\u0003P(\u0000\u0203\u0205\u0003R)\u0000\u0204"+
		"\u0202\u0001\u0000\u0000\u0000\u0204\u0203\u0001\u0000\u0000\u0000\u0205"+
		"O\u0001\u0000\u0000\u0000\u0206\u0207\u0005\t\u0000\u0000\u0207\u0208"+
		"\u0003\u0016\u000b\u0000\u0208\u0209\u0005\n\u0000\u0000\u0209Q\u0001"+
		"\u0000\u0000\u0000\u020a\u0216\u0005\u0007\u0000\u0000\u020b\u0210\u0003"+
		"\u0016\u000b\u0000\u020c\u020d\u0005\u0006\u0000\u0000\u020d\u020f\u0003"+
		"\u0016\u000b\u0000\u020e\u020c\u0001\u0000\u0000\u0000\u020f\u0212\u0001"+
		"\u0000\u0000\u0000\u0210\u020e\u0001\u0000\u0000\u0000\u0210\u0211\u0001"+
		"\u0000\u0000\u0000\u0211\u0214\u0001\u0000\u0000\u0000\u0212\u0210\u0001"+
		"\u0000\u0000\u0000\u0213\u0215\u0005\u0006\u0000\u0000\u0214\u0213\u0001"+
		"\u0000\u0000\u0000\u0214\u0215\u0001\u0000\u0000\u0000\u0215\u0217\u0001"+
		"\u0000\u0000\u0000\u0216\u020b\u0001\u0000\u0000\u0000\u0216\u0217\u0001"+
		"\u0000\u0000\u0000\u0217\u0218\u0001\u0000\u0000\u0000\u0218\u0219\u0005"+
		"\b\u0000\u0000\u0219S\u0001\u0000\u0000\u0000\u021a\u021b\u0007\u0004"+
		"\u0000\u0000\u021bU\u0001\u0000\u0000\u0000\u021c\u021d\u0007\u0005\u0000"+
		"\u0000\u021dW\u0001\u0000\u0000\u0000\u021e\u021f\u0007\u0006\u0000\u0000"+
		"\u021fY\u0001\u0000\u0000\u0000\u0220\u0221\u0007\u0007\u0000\u0000\u0221"+
		"[\u0001\u0000\u0000\u0000\u0222\u0223\u0007\b\u0000\u0000\u0223]\u0001"+
		"\u0000\u0000\u0000\u0224\u0225\u0007\t\u0000\u0000\u0225_\u0001\u0000"+
		"\u0000\u0000\u0226\u022e\u0005C\u0000\u0000\u0227\u0229\u0005\u0004\u0000"+
		"\u0000\u0228\u0227\u0001\u0000\u0000\u0000\u0229\u022c\u0001\u0000\u0000"+
		"\u0000\u022a\u0228\u0001\u0000\u0000\u0000\u022a\u022b\u0001\u0000\u0000"+
		"\u0000\u022b\u022d\u0001\u0000\u0000\u0000\u022c\u022a\u0001\u0000\u0000"+
		"\u0000\u022d\u022f\u0003\u0006\u0003\u0000\u022e\u022a\u0001\u0000\u0000"+
		"\u0000\u022e\u022f\u0001\u0000\u0000\u0000\u022f\u0233\u0001\u0000\u0000"+
		"\u0000\u0230\u0232\u0005\u0004\u0000\u0000\u0231\u0230\u0001\u0000\u0000"+
		"\u0000\u0232\u0235\u0001\u0000\u0000\u0000\u0233\u0231\u0001\u0000\u0000"+
		"\u0000\u0233\u0234\u0001\u0000\u0000\u0000\u0234\u0236\u0001\u0000\u0000"+
		"\u0000\u0235\u0233\u0001\u0000\u0000\u0000\u0236\u023a\u0003b1\u0000\u0237"+
		"\u0239\u0005\u0004\u0000\u0000\u0238\u0237\u0001\u0000\u0000\u0000\u0239"+
		"\u023c\u0001\u0000\u0000\u0000\u023a\u0238\u0001\u0000\u0000\u0000\u023a"+
		"\u023b\u0001\u0000\u0000\u0000\u023b\u023d\u0001\u0000\u0000\u0000\u023c"+
		"\u023a\u0001\u0000\u0000\u0000\u023d\u023e\u0003\b\u0004\u0000\u023ea"+
		"\u0001\u0000\u0000\u0000\u023f\u024b\u0005\u0007\u0000\u0000\u0240\u0245"+
		"\u0003\u0006\u0003\u0000\u0241\u0242\u0005\u0006\u0000\u0000\u0242\u0244"+
		"\u0003\u0006\u0003\u0000\u0243\u0241\u0001\u0000\u0000\u0000\u0244\u0247"+
		"\u0001\u0000\u0000\u0000\u0245\u0243\u0001\u0000\u0000\u0000\u0245\u0246"+
		"\u0001\u0000\u0000\u0000\u0246\u0249\u0001\u0000\u0000\u0000\u0247\u0245"+
		"\u0001\u0000\u0000\u0000\u0248\u024a\u0005\u0006\u0000\u0000\u0249\u0248"+
		"\u0001\u0000\u0000\u0000\u0249\u024a\u0001\u0000\u0000\u0000\u024a\u024c"+
		"\u0001\u0000\u0000\u0000\u024b\u0240\u0001\u0000\u0000\u0000\u024b\u024c"+
		"\u0001\u0000\u0000\u0000\u024c\u024d\u0001\u0000\u0000\u0000\u024d\u024e"+
		"\u0005\b\u0000\u0000\u024ec\u0001\u0000\u0000\u0000\u024f\u0250\u0007"+
		"\n\u0000\u0000\u0250e\u0001\u0000\u0000\u0000Jo}\u0084\u0087\u008b\u008e"+
		"\u0094\u0098\u009e\u00a6\u00ad\u00b4\u00b8\u00c3\u00c7\u00cc\u00d2\u00d9"+
		"\u00df\u00e6\u00ed\u00f3\u00fb\u0100\u0107\u010c\u0113\u0118\u011f\u0123"+
		"\u012a\u0131\u0139\u0140\u0146\u014f\u0158\u0163\u0169\u0171\u0175\u017b"+
		"\u0185\u018c\u0193\u019a\u019e\u01a4\u01a6\u01aa\u01b0\u01b9\u01c2\u01c9"+
		"\u01d0\u01d6\u01da\u01e4\u01e8\u01ea\u01f8\u01fc\u01fe\u0204\u0210\u0214"+
		"\u0216\u022a\u022e\u0233\u023a\u0245\u0249\u024b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}