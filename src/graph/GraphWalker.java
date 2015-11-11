package graph;


import ast.Node;

import java.util.ArrayList;
import java.util.List;

public abstract class GraphWalker<T> {

    private boolean[] visited;

    public List<T> walk(FlowGraph graph)
    {
        this.visited =  new boolean[graph.size()];
        List<T> result = new ArrayList<>();
        this.visit(graph, graph.getInitialNode(), result);
        return result;
    }

    private void visit(FlowGraph graph, int index, List<T> result)
    {
        this.visited[index] = true;
        Node node = graph.getVertice(index);
        T pre = this.preOrder(node);
        if (pre != null){
            result.add(pre);
        }

        for (int childIndex : graph.getEdges(index)){
            if (!visited[childIndex]){
                this.visit(graph, childIndex, result);
            }
        }

        T post = this.postOrder(node);

        if (post != null){
            result.add(post);
        }
    }


    public abstract T preOrder(Node node);

    public abstract T postOrder(Node node);
}
