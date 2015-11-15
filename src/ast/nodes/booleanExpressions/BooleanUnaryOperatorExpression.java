package ast.nodes.booleanExpressions;

import ast.Visitor;
import ast.nodes.BooleanExpression;

public class BooleanUnaryOperatorExpression extends BooleanExpression {
    private String operator;
    private BooleanExpression expression;

    public BooleanUnaryOperatorExpression(String operator, BooleanExpression expression) {
        this.operator = operator;
        this.expression = expression;

        this.addChildNode(expression);
    }


    public String getOperator() {
        return operator;
    }

    public BooleanExpression getExpression() {
        return expression;
    }

    @Override
    public String toString(){
        return this.operator+this.expression.toString();
    }

    @Override
    public <T, S> T accept(Visitor<T, S> visitor, S data) {
        return visitor.visitBooleanUnaryOperatorExpression(this, data);
    }
}
