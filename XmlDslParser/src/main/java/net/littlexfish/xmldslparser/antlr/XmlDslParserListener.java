// Generated from C:/LF/Development/IDEAProject/XmlDsl/antlr/XmlDslParser.g4 by ANTLR 4.13.1
package net.littlexfish.xmldslparser.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XmlDslParser}.
 */
public interface XmlDslParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#dslFile}.
	 * @param ctx the parse tree
	 */
	void enterDslFile(XmlDslParser.DslFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#dslFile}.
	 * @param ctx the parse tree
	 */
	void exitDslFile(XmlDslParser.DslFileContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#anysemi}.
	 * @param ctx the parse tree
	 */
	void enterAnysemi(XmlDslParser.AnysemiContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#anysemi}.
	 * @param ctx the parse tree
	 */
	void exitAnysemi(XmlDslParser.AnysemiContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#elementDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterElementDeclaration(XmlDslParser.ElementDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#elementDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitElementDeclaration(XmlDslParser.ElementDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(XmlDslParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(XmlDslParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(XmlDslParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(XmlDslParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(XmlDslParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(XmlDslParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(XmlDslParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(XmlDslParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(XmlDslParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(XmlDslParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#propertyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPropertyDeclaration(XmlDslParser.PropertyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#propertyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPropertyDeclaration(XmlDslParser.PropertyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(XmlDslParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(XmlDslParser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(XmlDslParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(XmlDslParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#flowExpression}.
	 * @param ctx the parse tree
	 */
	void enterFlowExpression(XmlDslParser.FlowExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#flowExpression}.
	 * @param ctx the parse tree
	 */
	void exitFlowExpression(XmlDslParser.FlowExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#disjunction}.
	 * @param ctx the parse tree
	 */
	void enterDisjunction(XmlDslParser.DisjunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#disjunction}.
	 * @param ctx the parse tree
	 */
	void exitDisjunction(XmlDslParser.DisjunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void enterConjunction(XmlDslParser.ConjunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void exitConjunction(XmlDslParser.ConjunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#equalityComparison}.
	 * @param ctx the parse tree
	 */
	void enterEqualityComparison(XmlDslParser.EqualityComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#equalityComparison}.
	 * @param ctx the parse tree
	 */
	void exitEqualityComparison(XmlDslParser.EqualityComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(XmlDslParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(XmlDslParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#inExpression}.
	 * @param ctx the parse tree
	 */
	void enterInExpression(XmlDslParser.InExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#inExpression}.
	 * @param ctx the parse tree
	 */
	void exitInExpression(XmlDslParser.InExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#rangeExpression}.
	 * @param ctx the parse tree
	 */
	void enterRangeExpression(XmlDslParser.RangeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#rangeExpression}.
	 * @param ctx the parse tree
	 */
	void exitRangeExpression(XmlDslParser.RangeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(XmlDslParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(XmlDslParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(XmlDslParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(XmlDslParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#prefixUnaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrefixUnaryExpression(XmlDslParser.PrefixUnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#prefixUnaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrefixUnaryExpression(XmlDslParser.PrefixUnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#prefixUnaryOperation}.
	 * @param ctx the parse tree
	 */
	void enterPrefixUnaryOperation(XmlDslParser.PrefixUnaryOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#prefixUnaryOperation}.
	 * @param ctx the parse tree
	 */
	void exitPrefixUnaryOperation(XmlDslParser.PrefixUnaryOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#postfixUnaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixUnaryExpression(XmlDslParser.PostfixUnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#postfixUnaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixUnaryExpression(XmlDslParser.PostfixUnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#atomicExpression}.
	 * @param ctx the parse tree
	 */
	void enterAtomicExpression(XmlDslParser.AtomicExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#atomicExpression}.
	 * @param ctx the parse tree
	 */
	void exitAtomicExpression(XmlDslParser.AtomicExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#parenthesizedExpression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedExpression(XmlDslParser.ParenthesizedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#parenthesizedExpression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedExpression(XmlDslParser.ParenthesizedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#literalConstant}.
	 * @param ctx the parse tree
	 */
	void enterLiteralConstant(XmlDslParser.LiteralConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#literalConstant}.
	 * @param ctx the parse tree
	 */
	void exitLiteralConstant(XmlDslParser.LiteralConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(XmlDslParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(XmlDslParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#stringContent}.
	 * @param ctx the parse tree
	 */
	void enterStringContent(XmlDslParser.StringContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#stringContent}.
	 * @param ctx the parse tree
	 */
	void exitStringContent(XmlDslParser.StringContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#stringExpression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpression(XmlDslParser.StringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#stringExpression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpression(XmlDslParser.StringExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#ifExpression}.
	 * @param ctx the parse tree
	 */
	void enterIfExpression(XmlDslParser.IfExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#ifExpression}.
	 * @param ctx the parse tree
	 */
	void exitIfExpression(XmlDslParser.IfExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#jumpExpression}.
	 * @param ctx the parse tree
	 */
	void enterJumpExpression(XmlDslParser.JumpExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#jumpExpression}.
	 * @param ctx the parse tree
	 */
	void exitJumpExpression(XmlDslParser.JumpExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#loopExpression}.
	 * @param ctx the parse tree
	 */
	void enterLoopExpression(XmlDslParser.LoopExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#loopExpression}.
	 * @param ctx the parse tree
	 */
	void exitLoopExpression(XmlDslParser.LoopExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#forExpression}.
	 * @param ctx the parse tree
	 */
	void enterForExpression(XmlDslParser.ForExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#forExpression}.
	 * @param ctx the parse tree
	 */
	void exitForExpression(XmlDslParser.ForExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#whileExpression}.
	 * @param ctx the parse tree
	 */
	void enterWhileExpression(XmlDslParser.WhileExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#whileExpression}.
	 * @param ctx the parse tree
	 */
	void exitWhileExpression(XmlDslParser.WhileExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#collectionLiteral}.
	 * @param ctx the parse tree
	 */
	void enterCollectionLiteral(XmlDslParser.CollectionLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#collectionLiteral}.
	 * @param ctx the parse tree
	 */
	void exitCollectionLiteral(XmlDslParser.CollectionLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#postfixUnaryOperation}.
	 * @param ctx the parse tree
	 */
	void enterPostfixUnaryOperation(XmlDslParser.PostfixUnaryOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#postfixUnaryOperation}.
	 * @param ctx the parse tree
	 */
	void exitPostfixUnaryOperation(XmlDslParser.PostfixUnaryOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#listAccess}.
	 * @param ctx the parse tree
	 */
	void enterListAccess(XmlDslParser.ListAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#listAccess}.
	 * @param ctx the parse tree
	 */
	void exitListAccess(XmlDslParser.ListAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(XmlDslParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(XmlDslParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#multiplicativeOperation}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeOperation(XmlDslParser.MultiplicativeOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#multiplicativeOperation}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeOperation(XmlDslParser.MultiplicativeOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#additiveOperator}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveOperator(XmlDslParser.AdditiveOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#additiveOperator}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveOperator(XmlDslParser.AdditiveOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#inOperator}.
	 * @param ctx the parse tree
	 */
	void enterInOperator(XmlDslParser.InOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#inOperator}.
	 * @param ctx the parse tree
	 */
	void exitInOperator(XmlDslParser.InOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOperator(XmlDslParser.ComparisonOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOperator(XmlDslParser.ComparisonOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#equalityOperation}.
	 * @param ctx the parse tree
	 */
	void enterEqualityOperation(XmlDslParser.EqualityOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#equalityOperation}.
	 * @param ctx the parse tree
	 */
	void exitEqualityOperation(XmlDslParser.EqualityOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOperator(XmlDslParser.AssignmentOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOperator(XmlDslParser.AssignmentOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(XmlDslParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(XmlDslParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlDslParser#functionParameters}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParameters(XmlDslParser.FunctionParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlDslParser#functionParameters}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParameters(XmlDslParser.FunctionParametersContext ctx);
}