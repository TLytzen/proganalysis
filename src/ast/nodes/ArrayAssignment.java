package ast.nodes;

import ast.Node;

public class ArrayAssignment extends Node {

    private String identifier;
    private ArithmeticExpression index;
    private ArithmeticExpression value;

    public ArrayAssignment(String identifier, ArithmeticExpression index, ArithmeticExpression value)
    {
        this.identifier = identifier;
        this.index = index;
        this.value = value;

        this.addChildNode(index);
        this.addChildNode(value);
    }

    public String getIdentifier() {
        return identifier;
    }

    public ArithmeticExpression getValue() {
        return this.value;
    }

    public ArithmeticExpression getIndex() {
        return this.index;
    }
}

