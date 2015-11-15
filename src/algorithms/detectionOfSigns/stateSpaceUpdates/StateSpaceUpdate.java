package algorithms.detectionOfSigns.stateSpaceUpdates;

import algorithms.detectionOfSigns.DSLattice;


public interface StateSpaceUpdate {

    DSLattice update(DSLattice currentAbstractStateSpace, Boolean isTrueBranch);

    String print(Integer abstractStateSpace);
}
