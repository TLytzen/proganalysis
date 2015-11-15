package ast.nodes;

import ast.Edge;
import ast.Node;
import ast.Visitor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RootNode extends Node {

    public RootNode(List<Node> nodes) {

        // Guarantee isolated exits - and ensure that the entry to the last statement is actually the output of the analysis
        if (!(nodes.get(nodes.size() - 1) instanceof  SkipStatement)){
            nodes.add(new SkipStatement());
        }

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
    public List<Edge> flow() {
        return Node.flowForStatementList(this.children);
    }

    @Override
    public List<Node> blocks() {
        ArrayList<Node> blocks = new ArrayList<>();
        for (int a = 0; a < this.children.size(); a++) {
            blocks.addAll(this.children.get(a).blocks());
        }

        return blocks;
    }

    @Override
    public <T, S> T accept(Visitor<T, S> visitor, S data) {
        return visitor.visitRootNode(this, data);
    }
}
