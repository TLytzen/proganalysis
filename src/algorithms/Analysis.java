package algorithms;

import graph.FlowGraph;

/**
 * Created by rasmu_000 on 2015-11-15.
 */
public abstract class Analysis {

    //TODO: Implement the shared part of the analysis here
    public abstract CompleteLattice[] analyse(FlowGraph graph, Worklist worklist);
}
