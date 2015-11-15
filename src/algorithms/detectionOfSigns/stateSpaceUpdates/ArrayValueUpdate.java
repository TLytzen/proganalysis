package algorithms.detectionOfSigns.stateSpaceUpdates;


import algorithms.detectionOfSigns.DSLattice;
import algorithms.detectionOfSigns.SignSet;
import ast.nodes.ArithmeticExpression;

public class ArrayValueUpdate implements StateSpaceUpdate {

    private int firstElement, restElement;
    private ArithmeticExpression indexExpression, valueExpression;
    private SignsOfArithmeticExpressions arithmeticExpressions;

    public ArrayValueUpdate(int firstElement, int restElement, ArithmeticExpression indexExpression, ArithmeticExpression valueExpression, SignsOfArithmeticExpressions arithmeticExpressions){
        this.firstElement = firstElement;
        this.restElement = restElement;
        this.indexExpression = indexExpression;
        this.valueExpression = valueExpression;
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
        if (indexResult.containsZero() && !indexResult.containsPlus()){
            // If the index only contains "0" then the first element is guaranteed to be updated
            firstIndexResult = this.arithmeticExpressions.visitNode(this.valueExpression, currentAbstractStateSpace);
        }
        else{
            for (DSLattice atom : currentAbstractStateSpace.atoms()){
                SignSet atomResult = this.arithmeticExpressions.visitNode(this.valueExpression, atom);

                if (indexResult.containsZero()){
                    firstIndexResult = firstIndexResult.union(atomResult);
                }

                if (indexResult.containsPlus()){
                    restIndexResult = restIndexResult.union(atomResult);
                }
            }
        }

        // Create the result lattice
        DSLattice result = currentAbstractStateSpace.setVariableSet(SignSet.getCopy(previousFirstIndex.getVariableName(), previousFirstIndex.getVariable(), firstIndexResult));
        result = result.setVariableSet(SignSet.getCopy(previousRestIndex.getVariableName(), previousRestIndex.getVariable(), restIndexResult));

        return result;
    }

    @Override
    public String print(Integer abstractStateSpace) {
        //return abstractStateSpace + "[" + this.variable + " |-> "+this.expression.toString() + "]";
        return "[array update ]";
    }
}
