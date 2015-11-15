package graph;

import ast.Edge;
import ast.Node;
import ast.nodes.RootNode;

import java.util.*;

public class FlowGraph {

    private List<Node> nodes;
    private List<List<Integer>> edges;
    private List<Map<Integer, Boolean>> isTrueBranches;

    private Set<Integer> finalSet;
    private int initialNode;

    private FlowGraph()
    {
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
        this.isTrueBranches = new ArrayList<>();
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


    public static FlowGraph constructGraph(Node rootNode){
        FlowGraph graph = new FlowGraph();

        for (Node n : rootNode.blocks())
        {
            int label = graph.addNode(n);
            n.setLabel(label);
        }

        for (Edge edgeInfo : rootNode.flow())
        {
            graph.addEdge(edgeInfo.from(), edgeInfo.to(), edgeInfo.isTrueBranch());
        }

        graph.initialNode = rootNode.initialNode();
        graph.finalSet = rootNode.finalNodes();

        return graph;
    }

    private int addNode(Node node)
    {
        this.nodes.add(node);
        this.edges.add(new ArrayList<Integer>());
        this.isTrueBranches.add(new HashMap<>());
        return this.nodes.size() - 1;
    }

    private void addEdge(int from, int to, Boolean isTrueBranch)
    {
        this.edges.get(from).add(to);
        if (isTrueBranch != null){
            this.isTrueBranches.get(from).put(to, isTrueBranch);
        }
    }

    public List<Integer> getEdges(int vertice) {
        return Collections.unmodifiableList(this.edges.get(vertice));
    }

    public Boolean isTrueBranch(int from, int to){
        Map<Integer, Boolean> trueBranches = isTrueBranches.get(from);
        return trueBranches.containsKey(to) ? trueBranches.get(to) : null;
    }

}
