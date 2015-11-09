package algorithms;


import java.util.Set;

public interface Equation {

    CompleteLattice evaluate(CompleteLattice lattice);

    int getIndex();

     Set<Integer> influences();

}
