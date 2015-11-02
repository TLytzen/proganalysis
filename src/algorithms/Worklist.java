package algorithms;

public interface Worklist {

    Worklist getEmpty();

    void insert(Equation equation);

    Equation extract();
}
