package ast.nodes.booleanExpressions;

import ast.nodes.ArithmeticExpression;
import ast.nodes.BooleanExpression;


public class BooleanComparisonExpression extends BooleanExpression {

    private ArithmeticExpression left;
    private String operator;
    private ArithmeticExpression right;

    public BooleanComparisonExpression(ArithmeticExpression left, String operator, ArithmeticExpression right) {
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

    @Override
    public String toString(){
        return this.left+this.operator+this.right;
    }
}
