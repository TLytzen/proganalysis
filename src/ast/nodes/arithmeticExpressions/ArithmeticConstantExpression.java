package ast.nodes.arithmeticExpressions;


import ast.nodes.ArithmeticExpression;

public class ArithmeticConstantExpression extends ArithmeticExpression {

    private int value;

    public ArithmeticConstantExpression(int value)
    {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


}
