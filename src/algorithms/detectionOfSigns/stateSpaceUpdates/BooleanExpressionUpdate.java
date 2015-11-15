package algorithms.detectionOfSigns.stateSpaceUpdates;

import algorithms.detectionOfSigns.BooleanSet;
import algorithms.detectionOfSigns.DSLattice;
import ast.nodes.BooleanExpression;

public class BooleanExpressionUpdate implements StateSpaceUpdate {

    private SignsOfBooleanExpressions signsOfBooleanExpressions;
    private BooleanExpression expression;

    public BooleanExpressionUpdate(BooleanExpression expression, SignsOfBooleanExpressions signsOfBooleanExpressions){
        this.expression = expression;
        this.signsOfBooleanExpressions = signsOfBooleanExpressions;
    }

    @Override
    public DSLattice update(DSLattice currentAbstractStateSpace, Boolean isTrueBranch) {
        DSLattice result = currentAbstractStateSpace.bottom();

        for (DSLattice atom : currentAbstractStateSpace.atoms()){

            if (this.signsOfBooleanExpressions.visitNode(expression, atom).containsValue(isTrueBranch)){
                result = result.join(atom);
            }
        }

        return result;
    }

    @Override
    public String print(Integer abstractStateSpace) {
        return null;
    }
}
