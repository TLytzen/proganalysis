package algorithms;

public interface Worklist {

    Worklist getEmpty();

    void insert(Constraint equation);

    Constraint extract();

    boolean isEmpty();
}
