package graph;

import ast.Node;
import ast.nodes.RootNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FlowGraph {

    private List<Node> nodes;
    private Set<Edge> edges;

    private Set<Integer> finalSet;
    private int initialNode;

    private FlowGraph()
    {
        this.nodes = new ArrayList<>();
        this.edges = new HashSet<>();
    }

    public static FlowGraph constructGraph(Node node){
        FlowGraph graph = new FlowGraph();

        for (Node n : node.blocks())
        {
            int label = graph.addNode(n);
            n.setLabel(label);
        }

        for (int[] edgeInfo : node.flow())
        {
            graph.addEdge(edgeInfo[0], edgeInfo[1]);
        }

        graph.initialNode = node.initialNode();
        graph.finalSet = node.finalNodes();

        return graph;
    }

    private int addNode(Node node)
    {
        this.nodes.add(node);
        return this.nodes.size() - 1;
    }

    private void addEdge(int from, int to)
    {
        this.edges.add(new Edge(from, to));
    }

    public class Edge
    {
        private int from, to;

        public Edge(int from, int to)
        {
            this.from = from;
            this.to = to;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }

        @Override
        public int hashCode() {
            return from * to;
        }

        @Override
        public boolean equals(Object o) {
            Edge other = (Edge)o;
            if (other == null)
            {
                return false;
            }

            return this.from == other.from && this.to == other.to;
        }

        @Override
        public String toString() {
            return "("+this.from+","+this.to+")";
        }
    }


}
