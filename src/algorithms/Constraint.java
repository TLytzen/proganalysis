package algorithms;


import java.util.List;
import java.util.Set;

public interface Constraint<T extends CompleteLattice> {

    T evaluate(CompleteLattice[] analysis);

    int leftHandSideVariable();

     List<Integer> rightHandSideVariables();

}
