package algorithms.reachingDefinitions;


import algorithms.CompleteLattice;
import algorithms.Equation;

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
    public RDLattice evaluate(RDLattice lattice) {

        RDLattice result = new RDLattice(lattice);

        if (genSet != null)
        {
            result.addSet(this.genSet);
        }

        if (killSet != null){
            result.removeSet(this.killSet);
        }

        return null;
    }

    @Override
    public int getIndex() {
        return this.leftHandSideVariable;
    }
}
