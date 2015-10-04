package ast.nodes;


public class ConstantExpression extends ArithmeticExpression {

    private int value;

    public ConstantExpression(int value)
    {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
