package ast.nodes;


import ast.Edge;
import ast.Node;
import ast.Visitor;
import ast.nodes.arithmeticExpressions.ArrayExpression;
import ast.nodes.arithmeticExpressions.IntExpression;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ReadArrayStatement extends Node {

    private ArrayExpression arrayExpression;


    public ReadArrayStatement(ArrayExpression arrayExpression) {
        this.arrayExpression = arrayExpression;
        this.addChildNode(arrayExpression);
    }

    public ArrayExpression getArrayExpression() {
        return arrayExpression;
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
        return visitor.visitReadArrayStatement(this, data);
    }

    @Override
    public String toString(){
        return "read "+ this.arrayExpression.toString();
    }
}
