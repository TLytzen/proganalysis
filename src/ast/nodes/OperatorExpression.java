package ast.nodes;


import ast.Node;
import sun.org.mozilla.javascript.internal.ast.AstNode;

public class OperatorExpression extends ArithmeticExpression {

    private ArithmeticExpression left;
    private String operator;
    private ArithmeticExpression right;

    public OperatorExpression(ArithmeticExpression left, String operator, ArithmeticExpression right) {
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
