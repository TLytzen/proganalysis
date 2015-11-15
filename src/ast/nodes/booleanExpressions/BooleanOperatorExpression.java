package ast.nodes.booleanExpressions;


import ast.Visitor;
import ast.nodes.BooleanExpression;

public class BooleanOperatorExpression extends BooleanExpression {
    private BooleanExpression left;
    private String operator;
    private BooleanExpression right;

    public BooleanOperatorExpression(BooleanExpression left, String operator, BooleanExpression right) {
        this.left = left;
        this.operator = operator;
        this.right = right;

        this.addChildNode(left);
        this.addChildNode(right);
    }

    public BooleanExpression getLeft() {
        return left;
    }

    public String getOperator() {
        return operator;
    }

    public BooleanExpression getRight() {
        return right;
    }

    @Override
    public String toString(){
        return this.left.toString()+this.operator+this.right.toString();
    }

    @Override
    public <T, S> T accept(Visitor<T, S> visitor, S data) {
        return visitor.visitBooleanOperatorExpression(this, data);
    }
}
