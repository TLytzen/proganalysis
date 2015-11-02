package algorithms;


public interface CompleteLattice {

    boolean leq(CompleteLattice lattice);

    CompleteLattice join(CompleteLattice lattice);
}
