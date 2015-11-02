package ast.nodes;


import ast.Node;

import java.util.List;
import java.util.Set;

public abstract class ArithmeticExpression extends Node {
    @Override
    public Integer initialNode() {
        return null;
    }

    @Override
    public Set<Integer> finalNodes() {
        return null;
    }

    @Override
    public List<int[]> flow() {
        return null;
    }

    @Override
    public Set<Node> blocks() {
        return null;
    }
}
