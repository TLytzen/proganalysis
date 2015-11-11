package ast.nodes;

import ast.Node;
import ast.Visitor;
import ast.nodes.BooleanExpression;

import java.util.*;

public class IfStatement extends Node {

    private BooleanExpression condition;
    private List<Node> ifNodes;
    private List<Node> elseNodes;

    public IfStatement(BooleanExpression condition, List<Node> ifNodes, List<Node> elseNodes)
    {
        this.condition = condition;
        this.ifNodes = ifNodes;
        this.elseNodes = elseNodes;

        this.addChildNode(condition);
        this.addChildNodes(ifNodes);
        this.addChildNodes(elseNodes);
    }

    public BooleanExpression getCondition() {
        return condition;
    }

    public List<Node> getIfNodes() {
        return ifNodes;
    }

    public List<Node> getElseNodes() {
        return elseNodes;
    }


    @Override
    public Integer initialNode() {
        return this.getLabel();
    }

    @Override
    public Set<Integer> finalNodes() {
        HashSet<Integer> finalNodes = new HashSet<>();

        if (this.ifNodes.size() > 0)
        {
            finalNodes.addAll(this.ifNodes.get(this.ifNodes.size() - 1).finalNodes());
        }

        if (this.elseNodes.size() > 0)
        {
            finalNodes.addAll(this.elseNodes.get(this.elseNodes.size() - 1).finalNodes());
        }

        return finalNodes;
    }

    @Override
    public List<int[]> flow() {
        List<int[]> flow = new ArrayList<>();

        if (this.ifNodes.size() > 0) {
            flow.add(new int[]{this.condition.getLabel(), this.ifNodes.get(0).getLabel()});
        }

        if (this.elseNodes.size() > 0) {
            flow.add(new int[]{this.condition.getLabel(), this.elseNodes.get(0).getLabel()});
        }

        flow.addAll(Node.flowForStatementList(this.ifNodes));
        flow.addAll(Node.flowForStatementList(this.elseNodes));


        return flow;
    }

    @Override
    public List<Node> blocks() {
        ArrayList<Node> nodes = new ArrayList<>();

        for (int a = 0; a < this.children.size(); a++)
        {
            nodes.addAll(this.children.get(a).blocks());
        }

        return nodes;
    }

    @Override
    public <T, S> T accept(Visitor<T, S> visitor, S data) {
        return visitor.visitIfStatement(this, data);
    }

    @Override
    public String toString(){
        return "if" + this.condition;
    }
}
