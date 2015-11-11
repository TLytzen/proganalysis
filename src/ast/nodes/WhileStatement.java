package ast.nodes;

import ast.Node;
import ast.Visitor;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class WhileStatement extends Node {

    private BooleanExpression condition;
    private List<Node> nodes;

    public WhileStatement(BooleanExpression condition, List<Node> nodes){
        this.condition = condition;
        this.nodes = nodes;

        this.addChildNode(condition);
        this.addChildNodes(nodes);
    }

    public BooleanExpression getCondition() {
        return condition;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    @Override
    public Integer initialNode() {
        return this.condition.getLabel();
    }

    @Override
    public Set<Integer> finalNodes() {
        return Collections.singleton(this.condition.getLabel());
    }

    @Override
    public List<int[]> flow() {
        List<int[]> flow = new ArrayList<>();

        flow.addAll(Node.flowForStatementList(this.nodes));

        flow.add(new int[]{ this.condition.getLabel(), this.nodes.get(0).getLabel() });

        for (int lPrime : this.nodes.get(this.nodes.size() - 1).finalNodes()) {
            flow.add(new int[]{ lPrime, this.condition.getLabel() });
        }

        return flow;
    }

    @Override
    public List<Node> blocks() {
        ArrayList<Node> blocks = new ArrayList<>();
        blocks.add(this.condition);
        for (int a = 0; a < this.nodes.size(); a++) {
            blocks.addAll(this.nodes.get(a).blocks());
        }

        return blocks;
    }


    @Override
    public <T, S> T accept(Visitor<T, S> visitor, S data) {
        return visitor.visitWhileStatement(this, data);
    }

    @Override
    public String toString(){
        return "while " + condition + " do";
    }
}
