package ast.nodes.arithmeticExpressions;

import ast.Visitor;
import ast.nodes.ArithmeticExpression;

public class ArrayExpression extends ArithmeticExpression {

    private String identifier;
    private ArithmeticExpression index;

    public ArrayExpression(String identifier, ArithmeticExpression index)
    {
        this.identifier = identifier;
        this.index = index;

        this.addChildNode(index);
    }

    public String getIdentifier() {
        return identifier;
    }

    public ArithmeticExpression getIndex() {
        return index;
    }

    @Override
    public String toString(){
        return this.identifier+"["+this.index+"]";
    }

    @Override
    public <T, S> T accept(Visitor<T, S> visitor, S data) {
        return visitor.visitArrayExpression(this, data);
    }
}
