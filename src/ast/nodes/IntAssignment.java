package ast.nodes;

import ast.Node;

import java.util.Collections;
import java.util.List;
import java.util.Set;

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
