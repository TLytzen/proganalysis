package ast.nodes;

import ast.Node;

public class IntAssignment extends Node {

    private String identifier;
    private ArithmeticExpression value;

    public IntAssignment(String identifier, ArithmeticExpression value)
    {
        this.identifier = identifier;
        this.value = value;

        this.addChildNode(value);
    }

    public String getIdentifier() {
        return identifier;
    }

    public ArithmeticExpression getValue() {
        return value;
    }
}
