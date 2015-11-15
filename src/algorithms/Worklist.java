package algorithms;

import java.util.List;

public interface Worklist {

    Worklist getEmpty(List<Constraint> equations);

    void insert(Constraint equation);

    Constraint extract();

    boolean isEmpty();
}
