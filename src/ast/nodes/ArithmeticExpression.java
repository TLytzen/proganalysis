package ast.nodes;


import ast.Edge;
import ast.Node;
import ast.Visitor;

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
    public List<Edge> flow() {
        return null;
    }

    @Override
    public List<Node> blocks() {
        return null;
    }
}
