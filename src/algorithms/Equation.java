package algorithms;


import java.util.Set;

public interface Equation<T extends CompleteLattice> {

    T evaluate(T lattice);

    int getIndex();

     Set<Integer> influences();

}
