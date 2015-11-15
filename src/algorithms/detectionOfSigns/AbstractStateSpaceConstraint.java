package algorithms.detectionOfSigns;

import algorithms.CompleteLattice;
import algorithms.Constraint;
import algorithms.detectionOfSigns.stateSpaceUpdates.StateSpaceUpdate;

import java.util.Collections;
import java.util.List;


public class AbstractStateSpaceConstraint implements Constraint<DSLattice> {

    private int leftHandSide;
    private Integer rightHandSide;
    private StateSpaceUpdate updateFunction;
    private Boolean isTrueBranch;

    public AbstractStateSpaceConstraint(int leftHandSide, Integer rightHandSide, StateSpaceUpdate updateFunction, Boolean isTrueBranch) {
        this.leftHandSide = leftHandSide;
        this.rightHandSide = rightHandSide;
        this.updateFunction = updateFunction;
        this.isTrueBranch = isTrueBranch;
    }

    @Override
    public DSLattice evaluate(CompleteLattice[] analysis) {
        DSLattice lattice;
        if (this.rightHandSide != null) {
            lattice = (DSLattice) analysis[this.rightHandSide];

            // This bottom preservation deviates from the analysis in the report
            if (lattice.equals(lattice.bottom())){
                return lattice;
            }

        } else {
            lattice = ((DSLattice) analysis[this.leftHandSide]).bottom();
        }

        if (this.updateFunction != null) {
            lattice = this.updateFunction.update(lattice, this.isTrueBranch);
        }

        return lattice;
    }

    @Override
    public int leftHandSideVariable() {
        return this.leftHandSide;
    }

    @Override
    public List<Integer> rightHandSideVariables() {
        if (this.rightHandSide != null) {
            return Collections.singletonList(this.rightHandSide);
        }

        return Collections.EMPTY_LIST;
    }

    @Override
    public String toString() {
        String equation = this.leftHandSide + " [= ";

        if (this.updateFunction != null) {
            equation += this.updateFunction.print(this.rightHandSide);
        }

        return equation;
    }
}
