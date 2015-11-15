package ast.nodes;

import ast.Edge;
import ast.Node;
import ast.Visitor;

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
    public List<Edge> flow() {
        return Collections.emptyList();
    }

    @Override
    public List<Node> blocks() {
        return Collections.singletonList((Node) this);
    }

    @Override
    public <T, S> T accept(Visitor<T, S> visitor, S data) {
        return visitor.visitIntAssignment(this, data);
    }

    @Override
    public String toString(){
        return this.identifier+":="+this.value;
    }
}
