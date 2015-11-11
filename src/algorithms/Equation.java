package algorithms;


import java.util.List;
import java.util.Set;

public interface Equation<T extends CompleteLattice> {

    T evaluate(CompleteLattice[] lattice);

    int getIndex();

     List<Integer> influences();

}
