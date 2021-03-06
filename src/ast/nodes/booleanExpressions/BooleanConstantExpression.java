package ast.nodes.booleanExpressions;


import ast.Visitor;
import ast.nodes.BooleanExpression;

public class BooleanConstantExpression extends BooleanExpression {

    private boolean value;
    public BooleanConstantExpression(boolean value)
    {
        this.value = value;
    }

    public boolean getValue()
    {
        return this.value;
    }

    @Override
    public String toString(){
        return value ? "true":"false";
    }

    @Override
    public <T, S> T accept(Visitor<T, S> visitor, S data) {
        return visitor.visitBooleanConstantExpression(this, data);
    }
}
