package ast.nodes.arithmeticExpressions;


import ast.Visitor;
import ast.nodes.ArithmeticExpression;

public class ArithmeticUnaryOperatorExpression extends ArithmeticExpression {

    private String operator;
    private ArithmeticExpression expression;

    public ArithmeticUnaryOperatorExpression(String operator, ArithmeticExpression expression)
    {
        this.operator = operator;
        this.expression = expression;

        this.addChildNode(expression);
    }

    public String getOperator() {
        return operator;
    }

    public ArithmeticExpression getExpression() {
        return expression;
    }

    @Override
    public String toString(){
        return this.operator + this.expression;
    }

    @Override
    public <T, S> T accept(Visitor<T, S> visitor, S data) {
        return visitor.visitArithmeticUnaryOperatorExpression(this, data);
    }
}
