package algorithms;


public interface CompleteLattice<T extends CompleteLattice>  {

    boolean leq(T lattice);

    T join(T lattice);

    T bottom();


}
