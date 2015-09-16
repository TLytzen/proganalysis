package ast.nodes;

import ast.Node;

import java.util.List;

public class RootNode extends Node {

    public RootNode(List<Node> nodes) {

        this.addChildNodes(nodes);
    }

}
