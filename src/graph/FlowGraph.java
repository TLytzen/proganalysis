package graph;

import ast.Node;
import ast.nodes.RootNode;

import java.util.*;

public class FlowGraph {

    private List<Node> nodes;
    private List<List<Integer>> edges;

    private Set<Integer> finalSet;
    private int initialNode;

    private FlowGraph()
    {
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public int size(){
        return this.nodes.size();
    }

    public Node getVertice(int v){
        return this.nodes.get(v);
    }

    public int getInitialNode(){
        return this.initialNode;
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
        this.edges.add(new ArrayList<Integer>());
        return this.nodes.size() - 1;
    }

    private void addEdge(int from, int to)
    {
        this.edges.get(from).add(to);
    }

    public List<Integer> getEdges(int vertice) {
        return Collections.unmodifiableList(this.edges.get(vertice));
    }
/*
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
    }*/


}
