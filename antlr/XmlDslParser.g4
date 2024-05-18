parser grammar XmlDslParser;

options {
    tokenVocab = XmlDslLexer;
}

dslFile
    : statements EOF
    ;

anysemi
    : NL
    | SEMICOLON
    ;

elementDeclaration
    : identifier NL* block
    ;

identifier
    : Identifier
    ;

block
    : LCURL statements RCURL
    ;

statements
    : anysemi* (statement (anysemi+ statement?)*)?
    ;

statement
    : declaration
    | assignmentExpression
    | expression
    | flowExpression
    ;

declaration
    : propertyDeclaration
//    | functionDeclaration // keep for future use
    ;

propertyDeclaration
    : (VAL | VAR | ATTR) NL* identifier (NL* ASSIGNMENT NL* expression)?
    ;

assignmentExpression
    : identifier assignmentOperator expression
    | identifier listAccess assignmentOperator expression
    ;

expression
    : elementDeclaration
    | disjunction
    ;

flowExpression
    : ifExpression
    | jumpExpression
    | loopExpression
    ;

disjunction
    : conjunction (NL* DISJ NL* conjunction)*
    ;

conjunction
    : equalityComparison (NL* CONJ NL* equalityComparison)*
    ;

equalityComparison
    : comparison (equalityOperation NL* comparison)?
    ;

comparison
    : inExpression (comparisonOperator NL* inExpression)?
    ;

inExpression
    : rangeExpression (inOperator NL* rangeExpression)?
    ;

rangeExpression
    : additiveExpression (RANGE NL* additiveExpression)?
    ;

additiveExpression
    : multiplicativeExpression (additiveOperator NL* multiplicativeExpression)*
    ;

multiplicativeExpression
    : prefixUnaryExpression (multiplicativeOperation NL* prefixUnaryExpression)*
    ;

prefixUnaryExpression
    : prefixUnaryOperation* postfixUnaryExpression
    ;

prefixUnaryOperation
    : ADD
    | SUB
    | EXCL
    ;

postfixUnaryExpression
    : atomicExpression postfixUnaryOperation?
    ;

atomicExpression
    : identifier
    | parenthesizedExpression
    | literalConstant
    | collectionLiteral
//    | functionCall // keep for future use
    ;

parenthesizedExpression
    : LPAREN expression RPAREN
    ;

literalConstant
    : BooleanLiteral
    | NumberLiteral
    | stringLiteral
    | NullLiteral
    | EMPTY
    ;

stringLiteral
    : SINGLE_QUOTE_OPEN (stringContent)* SINGLE_QUOTE_CLOSE
    | DOUBLE_QUOTE_OPEN (stringContent)* DOUBLE_QUOTE_CLOSE
    ;

stringContent
    : StrText
    | StrEscapedChar
    | StrRef
    | stringExpression
    ;

stringExpression
    : StrExprStart expression RCURL
    ;

ifExpression
    : IF NL* expression NL* block (
        NL* ELSE NL* block
    )?
    ;

jumpExpression
    : CONTINUE
    | BREAK
//    | RETURN expression? // keep for future use
    ;

loopExpression
    : forExpression
    | whileExpression
    ;

forExpression
    : FOR NL* identifier IN expression NL* block
    ;

whileExpression
    : WHILE NL* expression NL* block
    ;

collectionLiteral
    : LSQUARE expression? (COMMA expression)* COMMA? RSQUARE
    ;

functionCall
    : identifier LPAREN functionCallParameters RPAREN
    ;

functionCallParameters
    : identifier (COMMA identifier)* COMMA?
    ;

postfixUnaryOperation
    : listAccess
//    | NL* DOT postfixUnaryExpression
    ;

listAccess
    : LSQUARE expression RSQUARE
    ;

multiplicativeOperation
    : MULT
    | DIV
    | MOD
    ;

additiveOperator
    : ADD
    | SUB
    ;

inOperator
    : IN
    | NOT_IN
    ;

comparisonOperator
    : LANGLE
    | RANGLE
    | LE
    | GE
    ;

equalityOperation
    : EXCL_EQ
    | EQEQ
    ;

assignmentOperator
    : ASSIGNMENT
    | ADD_ASSIGNMENT
    | SUB_ASSIGNMENT
    | MULT_ASSIGNMENT
    | DIV_ASSIGNMENT
    | MOD_ASSIGNMENT
    ;

//functionDeclaration
//    : FUN (NL* simpleIdentifier)? NL*
//    functionValueParameters (NL* COLON NL* type)?
//     (NL* functionBody)?
//    ; // keep for future use





























































































































































































