package ast.nodes.arithmeticExpressions;


import ast.nodes.ArithmeticExpression;

public class ArithmeticOperatorExpression extends ArithmeticExpression {

    private ArithmeticExpression left;
    private String operator;
    private ArithmeticExpression right;

    public ArithmeticOperatorExpression(ArithmeticExpression left, String operator, ArithmeticExpression right) {
        this.left = left;
        this.operator = operator;
        this.right = right;

        this.addChildNode(left);
        this.addChildNode(right);
    }

    public ArithmeticExpression getLeft() {
        return left;
    }

    public String getOperator() {
        return operator;
    }

    public ArithmeticExpression getRight() {
        return right;
    }
}