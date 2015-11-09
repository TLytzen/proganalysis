package ast.nodes;

import ast.Node;

import java.util.Collections;
import java.util.List;
import java.util.Set;

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


    @Override
    public Integer initialNode() {
        return this.getLabel();
    }

    @Override
    public Set<Integer> finalNodes() {
        return Collections.singleton(this.getLabel());
    }

    @Override
    public List<int[]> flow() {
        return Collections.emptyList();
    }

    @Override
    public Set<Node> blocks() {
        return Collections.singleton((Node) this);
    }



}
