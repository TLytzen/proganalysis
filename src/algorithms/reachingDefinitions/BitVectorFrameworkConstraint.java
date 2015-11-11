package algorithms.reachingDefinitions;


import algorithms.CompleteLattice;
import algorithms.Equation;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class BitVectorFrameworkConstraint implements Equation<RDLattice> {

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

        if (genSet != null)
        {
            result.addSet(this.genSet);
        }

        if (killSet != null){
            result.removeSet(this.killSet);
        }

        return result;
    }

    @Override
    public int getIndex() {
        return this.leftHandSideVariable;
    }

    @Override
    public List<Integer> influences() {
        if (this.rightHandSideVariable != null){
            return Collections.singletonList(this.rightHandSideVariable);
        }

        return Collections.EMPTY_LIST;
    }
}
