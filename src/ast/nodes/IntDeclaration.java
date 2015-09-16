package ast.nodes;

import ast.Node;

public class IntDeclaration extends Node {

    private String identifier;

    public IntDeclaration(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return this.identifier;
    }
}
