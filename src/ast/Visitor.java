package ast;

import ast.nodes.*;
import ast.nodes.arithmeticExpressions.*;
import ast.nodes.booleanExpressions.BooleanComparisonExpression;
import ast.nodes.booleanExpressions.BooleanConstantExpression;
import ast.nodes.booleanExpressions.BooleanOperatorExpression;
import ast.nodes.booleanExpressions.BooleanUnaryOperatorExpression;

import java.util.List;

public class Visitor<T, S> {

    /**
     * Visits a single node. The visitor is responsible for visiting children.
     *
     * @param node the node to visit
     * @param data the data object
     * @return the result of visiting the node
     */
    public T visitNode(Node node, S data){
        return node.accept(this, data);
    }

    /**
     * Applies the given visitor to children of the given node
     *
     * @param node the parent node
     * @param data the data object to send to the visit of each child
     * @return the aggregated result of visiting the children
     */
    public T visitChildren(Node node, S data){
        return visitNodeList(node.getChildren(), data);
    }

    /**
     * Applies the given visitor to a list of nodes
     *
     * @param nodes the list of nodes to visit
     * @param data the data object to send to the visit of each child
     * @return the aggregated result of visiting the nodes
     */
    public T visitNodeList(List<Node> nodes, S data){
        T result = defaultValue();
        for(Node node : nodes){
            result = aggregateResult(result, node.accept(this, data));
        }

        return result;
    }


    public T visitArrayAssignment(ArrayAssignment arrayAssignment, S data) {
        return visitChildren(arrayAssignment, data);
    }

    public T visitArrayDeclaration(ArrayDeclaration arrayDeclaration, S data) {
        return visitChildren(arrayDeclaration, data);
    }

    public T visitIfStatement(IfStatement ifStatement, S data) {
        return visitChildren(ifStatement, data);
    }

    public T visitIntAssignment(IntAssignment intAssignment, S data) {
        return visitChildren(intAssignment, data);
    }

    public T visitIntDeclaration(IntDeclaration intDeclaration, S data) {
        return visitChildren(intDeclaration, data);
    }

    public T visitReadArrayStatement(ReadArrayStatement readArrayStatement, S data) {
        return visitChildren(readArrayStatement, data);
    }

    public T visitReadIntStatement(ReadIntStatement readIntStatement, S data) {
        return visitChildren(readIntStatement, data);
    }

    public T visitRootNode(RootNode rootNode, S data) {
        return visitChildren(rootNode, data);
    }

    public T visitSkipStatement(SkipStatement skipStatement, S data) {
        return visitChildren(skipStatement, data);
    }

    public T visitWhileStatement(WhileStatement whileStatement, S data) {
        return visitChildren(whileStatement, data);
    }

    public T visitWriteStatement(WriteStatement writeStatement, S data) {
        return visitChildren(writeStatement, data);
    }

    public T visitArithmeticConstantExpression(ArithmeticConstantExpression arithmeticConstantExpression, S data){
        return visitChildren(arithmeticConstantExpression, data);
    }

    public T visitArithmeticOperatorExpression(ArithmeticOperatorExpression arithmeticOperatorExpression, S data){
        return visitChildren(arithmeticOperatorExpression, data);
    }

    public T visitArithmeticUnaryOperatorExpression(ArithmeticUnaryOperatorExpression arithmeticUnaryOperatorExpression, S data){
        return visitChildren(arithmeticUnaryOperatorExpression, data);
    }

    public T visitArrayExpression(ArrayExpression arrayExpression, S data){
        return visitChildren(arrayExpression, data);
    }

    public T visitIntExpression(IntExpression intExpression, S data){
        return visitChildren(intExpression, data);
    }

    public T visitBooleanComparisonExpression(BooleanComparisonExpression booleanComparisonExpression, S data){
        return visitChildren(booleanComparisonExpression, data);
    }

    public T visitBooleanConstantExpression(BooleanConstantExpression booleanConstantExpression, S data){
        return visitChildren(booleanConstantExpression, data);
    }

    public T visitBooleanOperatorExpression(BooleanOperatorExpression booleanOperatorExpression, S data){
        return visitChildren(booleanOperatorExpression, data);
    }

    public T visitBooleanUnaryOperatorExpression(BooleanUnaryOperatorExpression booleanOperatorExpression, S data){
        return visitChildren(booleanOperatorExpression, data);
    }


    /**
     * Aggregates the results from the children.
     * Default implementation will return the latest result only.
     *
     * @param result the result previously obtained
     * @param next the next result
     * @return the combined result
     */
    protected T aggregateResult(T result, T next){
        return next;
    }

    /**
     * Returns the default return value
     *
     * @return the default return value
     */
    protected T defaultValue(){
        return null;
    }
}
