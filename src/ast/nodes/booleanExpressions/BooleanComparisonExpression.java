package ast.nodes.booleanExpressions;

import ast.Visitor;
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
        return this.left.toString()+this.operator+this.right.toString();
    }


    @Override
    public <T, S> T accept(Visitor<T, S> visitor, S data) {
        return visitor.visitBooleanComparisonExpression(this, data);
    }

}
