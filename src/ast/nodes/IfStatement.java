package ast.nodes;

import ast.Node;
import ast.nodes.BooleanExpression;

import java.util.List;
import java.util.Map;

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
}
