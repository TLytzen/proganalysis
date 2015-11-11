package algorithms;


public interface Equation<T extends CompleteLattice> {

    T evaluate(T lattice);

    int getIndex();

     Set<Integer> influences();

}
