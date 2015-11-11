package ast.nodes;


import ast.Node;
import ast.Visitor;
import ast.nodes.arithmeticExpressions.ArrayExpression;
import ast.nodes.arithmeticExpressions.IntExpression;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ReadIntStatement extends Node{

    private IntExpression intExpression;

    public ReadIntStatement(IntExpression intExpression) {
        this.intExpression = intExpression;
        this.addChildNode(intExpression);
    }


    public String getIdentifier() {
        return intExpression.getIdentifier();
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
    public List<Node> blocks() {
        return Collections.singletonList((Node) this);
    }

    @Override
    public <T, S> T accept(Visitor<T, S> visitor, S data) {
        return visitor.visitReadIntStatement(this, data);
    }
}


