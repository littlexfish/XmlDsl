lexer grammar XmlDslLexer;

DelimitedComment: '/*' ( DelimitedComment | .)*? '*/' -> channel(HIDDEN);

LineComment: '//' ~[\u000A\u000D]* -> channel(HIDDEN);

WS: [\u0020\u0009\u000C] -> skip;

NL: '\u000A' | '\u000D' '\u000A';

// Separators & Operators

DOT               : '.';
COMMA             : ',';
LPAREN            : '(' -> pushMode(Inside);
RPAREN            : ')';
LSQUARE           : '[' -> pushMode(Inside);
RSQUARE           : ']';
LCURL             : '{';
RCURL             : '}';
MULT              : '*';
MOD               : '%';
DIV               : '/';
ADD               : '+';
SUB               : '-';
CONJ              : '&&';
DISJ              : '||';
EXCL              : '!';
COLON             : ':';
SEMICOLON         : ';';
ASSIGNMENT        : '=';
ADD_ASSIGNMENT    : '+=';
SUB_ASSIGNMENT    : '-=';
MULT_ASSIGNMENT   : '*=';
DIV_ASSIGNMENT    : '/=';
MOD_ASSIGNMENT    : '%=';
RANGE             : '..';
HASH              : '#';
AT                : '@';
QUEST             : '?';
LANGLE            : '<';
RANGLE            : '>';
LE                : '<=';
GE                : '>=';
EXCL_EQ           : '!=';
EQEQ              : '==';
SINGLE_QUOTE_OPEN : '\'' -> pushMode(SingleQuoteStrig);
DOUBLE_QUOTE_OPEN : '"'   -> pushMode(DoubleQuoteStrig);

// KEYWORDS
VAL         : 'val';
VAR         : 'var';
ATTR        : 'attr';
IF          : 'if';
ELSE        : 'else';
FOR         : 'for';
WHILE       : 'while';
EMPTY       : 'empty';
CONTINUE    : 'continue';
BREAK       : 'break';
IN          : 'in';
NOT_IN      : '!in' (WS | NL)+;

/* Keep */
// Separators & Operators
ELLIPSIS    : '...';
// Keywords
IMPORT      : 'import';
INCLUDE     : 'include';
FUN         : 'fun';
RETURN      : 'return';
EXPORT      : 'export';
// Type
TYPEOF      : 'typeof';
AS          : 'as';
AS_SAFE     : 'as?';
IS          : 'is';
NOT_IS      : '!is' (WS | NL)+;
VOID        : 'void';
ANY         : 'any';
NUMBER      : 'number';
STRING      : 'string';
BOOLEAN     : 'boolean';
LIST        : 'list';
ELEMENT     : 'element';

// LITERALS
NumberLiteral: '-'? (Int | Hex | Bin | Oct | Real);

fragment Real: (
    Int '.' Int
);

fragment Int: (
    '0'
    | DecDigitNoZero DecDigit*
    | DecDigitNoZero (DecDigit | '_')+ DecDigit
);

fragment Hex: (
    '0' [xX] HexDigit ((HexDigit | '_')* HexDigit)?
);

fragment Bin: (
    '0' [bB] BinDigit ((BinDigit | '_')* BinDigit)?
);

fragment Oct: (
    '0' [oO] OctDigit ((OctDigit | '_')* OctDigit)?
);

fragment DecDigit: [0-9];
fragment DecDigitNoZero: [1-9];
fragment HexDigit: [0-9a-fA-F];
fragment OctDigit: [0-7];
fragment BinDigit: [01];

BooleanLiteral: 'true' | 'false';
NullLiteral: 'null';
Identifier: (Letter | '_') (Letter | [_\-.] | DecDigit)*;

fragment EscapeSeq: UniCharacterLiteral | EscapedIdentifier;
fragment UniCharacterLiteral: '\\' 'u' HexDigit HexDigit HexDigit HexDigit;
fragment EscapedIdentifier: '\\' ('t' | 'b' | 'r' | 'n' | '\'' | '"' | '\\' | '$');

fragment Letter: [a-zA-Z];

mode Inside;

Inside_RPAREN  : ')' -> popMode, type(RPAREN);
Inside_RSQUARE : ']' -> popMode, type(RSQUARE);

Inside_LPAREN  : LPAREN  -> pushMode(Inside), type(LPAREN);
Inside_LSQUARE : LSQUARE -> pushMode(Inside), type(LSQUARE);
Inside_LCURL            : LCURL             -> type(LCURL);
Inside_RCURL            : RCURL             -> type(RCURL);
Inside_DOT              : DOT               -> type(DOT);
Inside_COMMA            : COMMA             -> type(COMMA);
Inside_MULT             : MULT              -> type(MULT);
Inside_MOD              : MOD               -> type(MOD);
Inside_DIV              : DIV               -> type(DIV);
Inside_ADD              : ADD               -> type(ADD);
Inside_SUB              : SUB               -> type(SUB);
Inside_CONJ             : CONJ              -> type(CONJ);
Inside_DISJ             : DISJ              -> type(DISJ);
Inside_EXCL             : EXCL              -> type(EXCL);
Inside_COLON            : COLON             -> type(COLON);
Inside_SEMICOLON        : SEMICOLON         -> type(SEMICOLON);
Inside_ASSIGNMENT       : ASSIGNMENT        -> type(ASSIGNMENT);
Inside_ADD_ASSIGNMENT   : ADD_ASSIGNMENT    -> type(ADD_ASSIGNMENT);
Inside_SUB_ASSIGNMENT   : SUB_ASSIGNMENT    -> type(SUB_ASSIGNMENT);
Inside_MULT_ASSIGNMENT  : MULT_ASSIGNMENT   -> type(MULT_ASSIGNMENT);
Inside_DIV_ASSIGNMENT   : DIV_ASSIGNMENT    -> type(DIV_ASSIGNMENT);
Inside_MOD_ASSIGNMENT   : MOD_ASSIGNMENT    -> type(MOD_ASSIGNMENT);
Inside_RANGE            : RANGE            -> type(RANGE);
Inside_HASH             : HASH              -> type(HASH);
Inside_AT               : AT                -> type(AT);
Inside_QUEST            : QUEST             -> type(QUEST);
Inside_LANGLE           : LANGLE            -> type(LANGLE);
Inside_RANGLE           : RANGLE            -> type(RANGLE);
Inside_LE               : LE                -> type(LE);
Inside_GE               : GE                -> type(GE);
Inside_EXCL_EQ          : EXCL_EQ           -> type(EXCL_EQ);
Inside_NOT_IN           : NOT_IN            -> type(NOT_IN);
Inside_EQEQ             : EQEQ              -> type(EQEQ);
Inside_SINGLE_QUOTE     : SINGLE_QUOTE_OPEN -> pushMode(SingleQuoteStrig), type(SINGLE_QUOTE_OPEN);
Inside_QUOTE_OPEN       : DOUBLE_QUOTE_OPEN-> pushMode(DoubleQuoteStrig), type(DOUBLE_QUOTE_OPEN);

Inside_VAL         : VAL         -> type(VAL);
Inside_VAR         : VAR         -> type(VAR);
Inside_IN          : IN          -> type(IN);
Inside_CONTINUE    : CONTINUE    -> type(CONTINUE);
Inside_BREAK       : BREAK       -> type(BREAK);
Inside_IF          : IF          -> type(IF);
Inside_ELSE        : ELSE        -> type(ELSE);
Inside_FOR         : FOR         -> type(FOR);
Inside_WHILE       : WHILE       -> type(WHILE);
Inside_EMPTY       : EMPTY       -> type(EMPTY);

Inside_BooleanLiteral   : BooleanLiteral   -> type(BooleanLiteral);
Inside_IntegerLiteral   : NumberLiteral   -> type(NumberLiteral);
Inside_NullLiteral      : NullLiteral      -> type(NullLiteral);

Inside_Identifier      : Identifier                       -> type(Identifier);
Inside_Comment         : (LineComment | DelimitedComment) -> channel(HIDDEN);
Inside_WS              : WS                               -> skip;
Inside_NL              : NL                               -> skip;

/* Keep */
// Separators & Operators
Inside_ELLIPSIS    : ELLIPSIS -> type(ELLIPSIS);
// Keywords
Inside_IMPORT      : IMPORT -> type(IMPORT);
Inside_INCLUDE     : INCLUDE -> type(INCLUDE);
Inside_FUN         : FUN -> type(FUN);
Inside_RETURN      : RETURN -> type(RETURN);
Inside_EXPORT      : EXPORT -> type(EXPORT);
// Type
Inside_TYPEOF      : TYPEOF -> type(TYPEOF);
Inside_AS          : AS -> type(AS);
Inside_AS_SAFE     : AS_SAFE -> type(AS_SAFE);
Inside_IS          : IS -> type(IS);
Inside_NOT_IS      : NOT_IS -> type(NOT_IS);
Inside_VOID        : VOID -> type(VOID);
Inside_ANY         : ANY -> type(ANY);
Inside_NUMBER      : NUMBER -> type(NUMBER);
Inside_STRING      : STRING -> type(STRING);
Inside_BOOLEAN     : BOOLEAN -> type(BOOLEAN);
Inside_LIST        : LIST -> type(LIST);
Inside_ELEMENT     : ELEMENT -> type(ELEMENT);

mode DoubleQuoteStrig;

DOUBLE_QUOTE_CLOSE: '"' -> popMode;
StrText: (StrTextFrag | '\'')+;
fragment StrTextFrag: ~('\\' | '$' | '"' | '\'')+;
StrEscapedChar: EscapeSeq;
StrRef: '$' Identifier;
StrExprStart: '${' -> pushMode(StringExpression);
StrLineNL: NL -> skip;

mode SingleQuoteStrig;

SINGLE_QUOTE_CLOSE: '\'' -> popMode;
Single_StrText: ('"' | StrTextFrag)+ -> type(StrText);
Single_StrEscapedChar: StrEscapedChar -> type(StrEscapedChar);
Single_StrRef: StrRef -> type(StrRef);
Single_StrExprStart: '${' -> pushMode(StringExpression), type(StrExprStart);
Single_StrLineNL: NL -> skip;

mode StringExpression;

StrExpr_RCURL: RCURL -> popMode, type(RCURL);

StrExpr_LPAREN  : LPAREN  -> pushMode(Inside), type(LPAREN);
StrExpr_LSQUARE : LSQUARE -> pushMode(Inside), type(LSQUARE);

StrExpr_RPAREN           : ')'              -> type(RPAREN);
StrExpr_RSQUARE          : ']'              -> type(RSQUARE);
StrExpr_LCURL            : LCURL            -> pushMode(StringExpression), type(LCURL);
StrExpr_DOT              : DOT              -> type(DOT);
StrExpr_COMMA            : COMMA            -> type(COMMA);
StrExpr_MULT             : MULT             -> type(MULT);
StrExpr_MOD              : MOD              -> type(MOD);
StrExpr_DIV              : DIV              -> type(DIV);
StrExpr_ADD              : ADD              -> type(ADD);
StrExpr_SUB              : SUB              -> type(SUB);
StrExpr_CONJ             : CONJ             -> type(CONJ);
StrExpr_DISJ             : DISJ             -> type(DISJ);
StrExpr_EXCL             : EXCL             -> type(EXCL);
StrExpr_COLON            : COLON            -> type(COLON);
StrExpr_SEMICOLON        : SEMICOLON        -> type(SEMICOLON);
StrExpr_ASSIGNMENT       : ASSIGNMENT       -> type(ASSIGNMENT);
StrExpr_ADD_ASSIGNMENT   : ADD_ASSIGNMENT   -> type(ADD_ASSIGNMENT);
StrExpr_SUB_ASSIGNMENT   : SUB_ASSIGNMENT   -> type(SUB_ASSIGNMENT);
StrExpr_MULT_ASSIGNMENT  : MULT_ASSIGNMENT  -> type(MULT_ASSIGNMENT);
StrExpr_DIV_ASSIGNMENT   : DIV_ASSIGNMENT   -> type(DIV_ASSIGNMENT);
StrExpr_MOD_ASSIGNMENT   : MOD_ASSIGNMENT   -> type(MOD_ASSIGNMENT);
StrExpr_RANGE            : RANGE            -> type(RANGE);
StrExpr_HASH             : HASH             -> type(HASH);
StrExpr_AT               : AT               -> type(AT);
StrExpr_QUEST            : QUEST            -> type(QUEST);
StrExpr_LANGLE           : LANGLE           -> type(LANGLE);
StrExpr_RANGLE           : RANGLE           -> type(RANGLE);
StrExpr_LE               : LE               -> type(LE);
StrExpr_GE               : GE               -> type(GE);
StrExpr_EXCL_EQ          : EXCL_EQ          -> type(EXCL_EQ);
StrExpr_IN               : IN               -> type(IN);
StrExpr_NOT_IN           : NOT_IN       -> type(NOT_IN);
StrExpr_EQEQ             : EQEQ         -> type(EQEQ);
StrExpr_SINGLE_QUOTE_OPEN: SINGLE_QUOTE_OPEN -> pushMode(SingleQuoteStrig), type(SINGLE_QUOTE_OPEN);
StrExpr_DOUBLE_QUOTE_OPEN: DOUBLE_QUOTE_OPEN -> pushMode(DoubleQuoteStrig), type(DOUBLE_QUOTE_OPEN);

StrExpr_BooleanLiteral   : BooleanLiteral   -> type(BooleanLiteral);
StrExpr_IntegerLiteral   : NumberLiteral    -> type(NumberLiteral);
StrExpr_NullLiteral      : NullLiteral      -> type(NullLiteral);

StrExpr_Identifier      : Identifier                       -> type(Identifier);
StrExpr_Comment         : (LineComment | DelimitedComment) -> channel(HIDDEN);
StrExpr_WS              : WS                               -> skip;
StrExpr_NL              : NL                               -> skip;
