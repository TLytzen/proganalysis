package algorithms.detectionOfSigns.stateSpaceUpdates;

import algorithms.detectionOfSigns.DSLattice;
import algorithms.detectionOfSigns.SignSet;
import ast.nodes.ArithmeticExpression;


public class SingleVariableValueUpdate implements StateSpaceUpdate {

    private int variable;
    private ArithmeticExpression expression;
    private SignsOfArithmeticExpressions arithmeticExpressions;

    public SingleVariableValueUpdate(int variable, ArithmeticExpression expression, SignsOfArithmeticExpressions arithmeticExpressions){
        this.variable = variable;
        this.expression = expression;
        this.arithmeticExpressions = arithmeticExpressions;
    }

    @Override
    public DSLattice update(DSLattice currentAbstractStateSpace, Boolean isTrueBranch) {
        SignSet previous = currentAbstractStateSpace.getVariableSet(this.variable);
        SignSet result = this.arithmeticExpressions.visitNode(this.expression, currentAbstractStateSpace);

        return currentAbstractStateSpace.setVariableSet(SignSet.getCopy(previous.getVariableName(), previous.getVariable(), result));
    }

    @Override
    public String print(Integer abstractStateSpace) {
        return abstractStateSpace + "[" + this.variable + " |-> "+this.expression.toString() + "]";
    }
}
