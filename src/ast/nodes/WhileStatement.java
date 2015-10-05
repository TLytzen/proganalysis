package ast.nodes;

import ast.Node;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

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
}
