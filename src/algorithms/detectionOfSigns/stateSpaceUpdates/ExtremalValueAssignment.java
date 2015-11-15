package algorithms.detectionOfSigns.stateSpaceUpdates;

import algorithms.detectionOfSigns.AbstractStateSpaceConstraint;
import algorithms.detectionOfSigns.DSLattice;
import algorithms.detectionOfSigns.SignSet;


public class ExtremalValueAssignment implements StateSpaceUpdate {

    private SignSet extremalValue;

    public ExtremalValueAssignment(SignSet extremalValue){
        this.extremalValue = extremalValue;
    }

    @Override
    public DSLattice update(DSLattice currentAbstractStateSpace, Boolean isTrueBranch) {
        return currentAbstractStateSpace.setVariableSet(this.extremalValue);
    }

    public static AbstractStateSpaceConstraint getExtremalValueAssignment(int leftHandSide, String variableName, int variable){
        return new AbstractStateSpaceConstraint(leftHandSide, null, new ExtremalValueAssignment(SignSet.getTop(variableName, variable)), null);
    }

    @Override
    public String print(Integer abstractStateSpace) {
        return "{" + this.extremalValue.toString() + "}";
    }
}
