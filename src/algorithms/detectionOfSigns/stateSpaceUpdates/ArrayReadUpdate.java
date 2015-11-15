package algorithms.detectionOfSigns.stateSpaceUpdates;

import algorithms.detectionOfSigns.DSLattice;
import algorithms.detectionOfSigns.SignSet;
import ast.nodes.ArithmeticExpression;


public class ArrayReadUpdate implements StateSpaceUpdate {

    private int firstElement, restElement;
    private ArithmeticExpression indexExpression;
    private SignsOfArithmeticExpressions arithmeticExpressions;

    public ArrayReadUpdate(int firstElement, int restElement, ArithmeticExpression indexExpression, SignsOfArithmeticExpressions arithmeticExpressions){
        this.firstElement = firstElement;
        this.restElement = restElement;
        this.indexExpression = indexExpression;
        this.arithmeticExpressions = arithmeticExpressions;
    }

    @Override
    public DSLattice update(DSLattice currentAbstractStateSpace, Boolean isTrueBranch) {

        // Read the existing values and assign the result initially to be unchanged
        SignSet previousFirstIndex = currentAbstractStateSpace.getVariableSet(this.firstElement);
        SignSet previousRestIndex = currentAbstractStateSpace.getVariableSet(this.restElement);
        SignSet firstIndexResult = previousFirstIndex;
        SignSet restIndexResult = previousRestIndex;

        SignSet indexResult = this.arithmeticExpressions.visitNode(this.indexExpression, currentAbstractStateSpace);

        if (indexResult.containsZero()){
            firstIndexResult = SignSet.getTop(previousFirstIndex.getVariableName(), previousFirstIndex.getVariable());
        }

        if (indexResult.containsPlus()){
            restIndexResult = SignSet.getTop(previousRestIndex.getVariableName(), previousRestIndex.getVariable());
        }

        // Create the result lattice
        DSLattice result = currentAbstractStateSpace.setVariableSet(firstIndexResult);
        result = result.setVariableSet(restIndexResult);

        return result;
    }

    @Override
    public String print(Integer abstractStateSpace) {
        return "[array read update]";
    }
}
