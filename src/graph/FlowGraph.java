package graph;

import ast.Node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FlowGraph {

    private List<Node> nodes;
    private HashSet<Edge> edges;

    private HashSet<Node> finalSet;
    private Node initialNode;

    public FlowGraph()
    {
        this.nodes = new ArrayList<>();
        this.edges = new HashSet<>();
    }

    public int addNode(Node node)
    {
        this.nodes.add(node);
        return this.nodes.size();
    }

    public void addEdge(int from, int to)
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
