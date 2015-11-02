package ast.nodes;

import ast.Node;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class IntDeclaration extends Node {

    private String identifier;

    public IntDeclaration(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return this.identifier;
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
        return Collections.singleton((Node)this);
    }
}
