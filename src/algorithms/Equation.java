package algorithms;


public interface Equation {

    CompleteLattice evaluate(CompleteLattice lattice);

    int getIndex();
}
