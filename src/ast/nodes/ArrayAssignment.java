package ast.nodes;

import ast.Node;

import java.util.Collections;
import java.util.List;
import java.util.Set;

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

