package ast.nodes;

public class ArrayExpression extends  ArithmeticExpression{

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
}
