package ast.nodes.arithmeticExpressions;


import ast.Visitor;
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

    @Override
    public String toString(){
        return ""+value;
    }

    @Override
    public <T, S> T accept(Visitor<T, S> visitor, S data) {
        return visitor.visitArithmeticConstantExpression(this, data);
    }
}
