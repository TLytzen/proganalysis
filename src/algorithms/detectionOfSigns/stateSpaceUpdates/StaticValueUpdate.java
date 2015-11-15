package algorithms.detectionOfSigns.stateSpaceUpdates;


import algorithms.detectionOfSigns.DSLattice;
import algorithms.detectionOfSigns.SignSet;

import java.util.Collections;
import java.util.List;


public class StaticValueUpdate implements StateSpaceUpdate {

    private List<SignSet> newValues;

    public StaticValueUpdate(List<SignSet> newValues){
        this.newValues = newValues;
    }

    public StaticValueUpdate(SignSet newValue){
        this(Collections.singletonList(newValue));
    }

    @Override
    public DSLattice update(DSLattice currentAbstractStateSpace, Boolean isTrueBranch) {
        DSLattice result = currentAbstractStateSpace;
        for (SignSet newValue : newValues){
            result = result.setVariableSet(newValue);
        }

        return result;
    }

    @Override
    public String print(Integer abstractStateSpace) {
        StringBuilder result = new StringBuilder();
        for (SignSet newValue : newValues){
            if (result.length() > 0){
                result.append(", ");
            }

            result.append(newValue.toString());
        }

        return result.toString();
    }
}
