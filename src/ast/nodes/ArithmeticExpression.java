package ast.nodes;


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
    public List<int[]> flow() {
        return null;
    }

    @Override
    public List<Node> blocks() {
        return null;
    }

    @Override
    public <T, S> T accept(Visitor<T, S> visitor, S data) {
        return visitor.visitArtihmeticExpression(this, data);
    }
}
