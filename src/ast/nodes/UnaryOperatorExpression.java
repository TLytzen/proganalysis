package ast.nodes;


public class UnaryOperatorExpression extends ArithmeticExpression {

    private String operator;
    private ArithmeticExpression expression;

    public UnaryOperatorExpression(String operator, ArithmeticExpression expression)
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
