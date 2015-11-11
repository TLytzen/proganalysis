package algorithms.worklists;

import algorithms.Equation;
import algorithms.Worklist;

import java.util.HashSet;

public class SetWorklist implements Worklist {

    private static SetWorklist EmptySet = new SetWorklist();

    private HashSet<Equation> equations = new HashSet<>();

    @Override
    public Worklist getEmpty() {
        return EmptySet;
    }

    @Override
    public void insert(Equation equation) {
        this.equations.add(equation);
    }

    @Override
    public Equation extract() {
        if (this.equations.size() == 0){
            return null;
        }

        Equation first = this.equations.iterator().next();
        this.equations.remove(first);
        return first;
    }
}
