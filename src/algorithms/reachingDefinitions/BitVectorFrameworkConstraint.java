package algorithms.reachingDefinitions;


import algorithms.CompleteLattice;
import algorithms.Constraint;

import java.util.Collections;
import java.util.List;

public class BitVectorFrameworkConstraint implements Constraint<RDLattice> {

    private int leftHandSideVariable;
    private Integer rightHandSideVariable;

    private BitVectorSet genSet;

    private BitVectorSet killSet;

    public BitVectorFrameworkConstraint(int leftHandSideVariable, Integer rightHandSideVariable, BitVectorSet genSet, BitVectorSet killSet){
        this.leftHandSideVariable = leftHandSideVariable;
        this.rightHandSideVariable = rightHandSideVariable;
        this.genSet = genSet;
        this.killSet = killSet;
    }


    @Override
    public RDLattice evaluate(CompleteLattice[] analysis) {
        RDLattice result;
        if (this.rightHandSideVariable != null){
            result = new RDLattice((RDLattice)analysis[this.rightHandSideVariable]);
        }
        else{
            result = ((RDLattice)analysis[this.leftHandSideVariable]).bottom();
        }

        if (killSet != null){
            result.removeSet(this.killSet);
        }

        if (genSet != null)
        {
            result.addSet(this.genSet);
        }

        return result;
    }

    @Override
    public int leftHandSideVariable() {
        return this.leftHandSideVariable;
    }

    @Override
    public List<Integer> rightHandSideVariables() {
        if (this.rightHandSideVariable != null){
            return Collections.singletonList(this.rightHandSideVariable);
        }

        return Collections.EMPTY_LIST;
    }

    @Override
    public String toString(){
        StringBuilder rightHandSide = new StringBuilder();

        if (this.killSet != null) {
            rightHandSide.append('(');
        }

        if (this.rightHandSideVariable != null){
            rightHandSide.append(this.rightHandSideVariable.toString());
        }

        if (this.killSet != null)
        {
            rightHandSide.append(" \\ ");
            rightHandSide.append(this.killSet.toString());
            rightHandSide.append(')');
        }

        if (this.genSet != null){
            if (rightHandSide.length() > 0){
                rightHandSide.append(" U ");
            }

            rightHandSide.append(this.genSet.toString());
        }

        return this.leftHandSideVariable + " [= " + rightHandSide.toString();
    }
}
