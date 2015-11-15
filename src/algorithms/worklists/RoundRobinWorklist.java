package algorithms.worklists;

import algorithms.Constraint;
import algorithms.Worklist;
import ast.Node;
import graph.FlowGraph;
import graph.GraphWalker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoundRobinWorklist  implements Worklist {

    private List<Integer> reversePostOrderSorting;
    private Map<Integer, Constraint> constraints;
    private boolean changed;
    private List<Constraint> current = new ArrayList<>();
    private List<Constraint> sorted = new ArrayList<>();

    public RoundRobinWorklist(FlowGraph graph){
        reversePostOrderSorting = new ArrayList<>();
        constraints = new HashMap<>();

        List<Integer> postOrderSorting = new PostOrderSorting().walk(graph);
        for (int index = postOrderSorting.size() - 1; index >= 0; index--){
            reversePostOrderSorting.add(postOrderSorting.get(index));
        }
    }

    private RoundRobinWorklist(List<Integer> reversePostOrderSorting, Map<Integer, Constraint> constraints, List<Constraint> sorted){
        this.reversePostOrderSorting = reversePostOrderSorting;
        this.constraints = constraints;
        this.sorted = sorted;
    }


    @Override
    public Worklist getEmpty(List<Constraint> constraints) {
        if (this.constraints.size() != this.reversePostOrderSorting.size()){
            for (Constraint constraint : constraints) {
                this.constraints.put(constraint.leftHandSideVariable(), constraint);
            }

            if (this.constraints.size() == this.reversePostOrderSorting.size()){
                for (int label : this.reversePostOrderSorting){
                    this.sorted.add(this.constraints.get(label));
                }
            }
        }

        return new RoundRobinWorklist(this.reversePostOrderSorting, this.constraints,this.sorted);
    }

    @Override
    public void insert(Constraint constraint) {
        changed = true;

    }

    @Override
    public Constraint extract() {
        if (current.isEmpty()){
            changed = false;
            this.current.addAll(this.sorted);
        }

        return current.remove(0);
    }

    @Override
    public boolean isEmpty() {
        return this.current.isEmpty() && !this.changed;
    }

    private class PostOrderSorting extends GraphWalker<Integer> {

        @Override
        public Integer preOrder(Node node) {
            return null;
        }

        @Override
        public Integer postOrder(Node node) {
            return node.getLabel();
        }
    }
}
