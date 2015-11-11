package ast.nodes;

import ast.Node;
import ast.Visitor;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class WriteStatement extends Node {

    private ArithmeticExpression arithmeticExpression;

    public WriteStatement(ArithmeticExpression arithmeticExpression) {
        this.arithmeticExpression = arithmeticExpression;
        this.addChildNode(arithmeticExpression);
    }

    public ArithmeticExpression getArithmeticExpression() {
        return arithmeticExpression;
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
        return visitor.visitWriteStatement(this, data);
    }
}
