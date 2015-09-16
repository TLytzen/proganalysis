package ast.nodes;

import ast.Node;

public class ArrayDeclaration extends Node {
    private String identifier;
    private int length;

    public ArrayDeclaration(String identifier, int length) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public int getLength() {
        return this.length;
    }
}
