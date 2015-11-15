package algorithms.worklists;

import algorithms.Constraint;
import algorithms.Worklist;

import java.util.HashSet;

public class SetWorklist implements Worklist {

    private static SetWorklist EmptySet = new SetWorklist();

    private HashSet<Constraint> equations = new HashSet<>();

    @Override
    public Worklist getEmpty() {
        return EmptySet;
    }

    @Override
    public void insert(Constraint equation) {
        this.equations.add(equation);
    }

    @Override
    public Constraint extract() {
        if (this.equations.size() == 0){
            return null;
        }

        Constraint first = this.equations.iterator().next();
        this.equations.remove(first);
        return first;
    }

    @Override
    public boolean isEmpty() {
        return this.equations.isEmpty();
    }
}
