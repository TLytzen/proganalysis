package ast.nodes;


import ast.Node;
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


    public IntExpression getIntExpression() {
        return intExpression;
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
