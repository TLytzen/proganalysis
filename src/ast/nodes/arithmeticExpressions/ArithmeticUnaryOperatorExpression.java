package ast.nodes.arithmeticExpressions;


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
}
