package ast.nodes;

import ast.Node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RootNode extends Node {

    public RootNode(List<Node> nodes) {

        this.addChildNodes(nodes);
    }

    @Override
    public Integer initialNode() {
        if (this.children.size() > 0)
        {
            return this.children.get(0).getLabel();
        }

        return null;
    }

    @Override
    public Set<Integer> finalNodes() {
        if (this.children.size() > 0) {
            return this.children.get(this.children.size() - 1).finalNodes();
        }
        return null;
    }

    @Override
    public List<int[]> flow() {
        return Node.flowForStatementList(this.children);
    }

    @Override
    public Set<Node> blocks() {
        Set<Node> blocks = new HashSet<>();
        for (int a = 0; a < this.children.size(); a++) {
            blocks.addAll(this.children.get(a).blocks());
        }

        return blocks;
    }
}
