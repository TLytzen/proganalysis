package algorithms;

import graph.FlowGraph;

public abstract class Analysis {
    public abstract CompleteLattice[] analyse(FlowGraph graph, Worklist worklist, boolean measureTime);
}
