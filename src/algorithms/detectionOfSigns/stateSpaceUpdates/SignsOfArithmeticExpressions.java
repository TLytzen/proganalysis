package algorithms.detectionOfSigns.stateSpaceUpdates;

import algorithms.detectionOfSigns.DSLattice;
import algorithms.detectionOfSigns.SignSet;
import ast.Visitor;
import ast.nodes.ArrayDeclaration;
import ast.nodes.arithmeticExpressions.*;

import java.util.HashMap;

public class SignsOfArithmeticExpressions extends Visitor<SignSet, DSLattice> {

    private HashMap<String, Integer> variables;

    public SignsOfArithmeticExpressions(HashMap<String, Integer> variables){
        this.variables = variables;
    }

    @Override
    public SignSet visitArithmeticConstantExpression(ArithmeticConstantExpression arithmeticConstantExpression, DSLattice data) {
        if (arithmeticConstantExpression.getValue() < 0){
            return SignSet.getMinus();
        }
        else if (arithmeticConstantExpression.getValue() == 0)
        {
            return SignSet.getZero();
        }
        else{
            return SignSet.getPlus();
        }
    }

    @Override
    public SignSet visitArithmeticOperatorExpression(ArithmeticOperatorExpression arithmeticOperatorExpression, DSLattice data) {

        SignSet leftSet = this.visitNode(arithmeticOperatorExpression.getLeft(), data);
        SignSet rightSet = this.visitNode(arithmeticOperatorExpression.getRight(), data);

        return this.operatorResult(leftSet, rightSet, arithmeticOperatorExpression.getOperator());
    }

    @Override
    public SignSet visitArithmeticUnaryOperatorExpression(ArithmeticUnaryOperatorExpression arithmeticUnaryOperatorExpression, DSLattice data) {
        if (arithmeticUnaryOperatorExpression.getOperator() == "-"){
            return this.operatorResult(SignSet.getZero(), this.visitNode(arithmeticUnaryOperatorExpression.getExpression(), data), "-");
        }

        return this.visitChildren(arithmeticUnaryOperatorExpression.getExpression(), data);
    }

    @Override
    public SignSet visitIntExpression(IntExpression intExpression, DSLattice data) {
        return data.getVariableSet(this.variables.get(intExpression.getIdentifier()));
    }

    @Override
    public SignSet visitArrayExpression(ArrayExpression arrayExpression, DSLattice data) {
        SignSet result = SignSet.getEmpty();

        String firstIndex = ArrayDeclaration.getFirstElementIdentifier(arrayExpression.getIdentifier());
        String restIndex = ArrayDeclaration.getRestElementIdentifier(arrayExpression.getIdentifier());
        int firstIndexVariable = this.variables.get(firstIndex);
        int restIndexVariable = this.variables.get(restIndex);

        for (DSLattice atom : data.atoms()){
            // Evaluate the index expression under the atom state
            SignSet atomResult = this.visitNode(arrayExpression.getIndex(), atom);

            // If the result contains {0}, take the least upper bound of the existing result and the value of the first element in the atom
            if (atomResult.containsZero()){
                result = result.union(atom.getVariableSet(firstIndexVariable));
            }

            // If the result contains {+}, take the least upper bound of the existing result and the value of the "rest" element in the atom
            if (atomResult.containsPlus()){
                result = result.union(atom.getVariableSet(restIndexVariable));
            }
        }

        return result;
    }


    private SignSet operatorResult(SignSet leftSet, SignSet rightSet, String operator){
        SignSet[][] partialResult;

        switch (operator){
            case "+":
                partialResult = new SignSet[][]{ { SignSet.getMinus(), SignSet.getMinus(), SignSet.getTop() },
                        { SignSet.getMinus(), SignSet.getZero(), SignSet.getPlus() },
                        { SignSet.getTop(), SignSet.getPlus(), SignSet.getPlus() }};

                break;

            case "-":
                partialResult = new SignSet[][]{ { SignSet.getTop(), SignSet.getMinus(), SignSet.getMinus() },
                        { SignSet.getPlus(), SignSet.getZero(), SignSet.getMinus() },
                        { SignSet.getPlus(), SignSet.getPlus(), SignSet.getTop() }};
                break;

            case "*":
                partialResult = new SignSet[][]{ { SignSet.getPlus(), SignSet.getZero(), SignSet.getMinus() },
                        { SignSet.getZero(), SignSet.getZero(), SignSet.getZero() },
                        { SignSet.getMinus(), SignSet.getZero(), SignSet.getPlus() }};
                break;

            case "/":
                partialResult = new SignSet[][]{ { SignSet.getPlus(), SignSet.getEmpty(), SignSet.getMinus() },
                        { SignSet.getZero(), SignSet.getEmpty(), SignSet.getZero() },
                        { SignSet.getMinus(), SignSet.getEmpty(), SignSet.getPlus() }};
                break;

            default:
                throw new IllegalArgumentException("Unknown arithmetic operator");
        }

        return SignSet.operator(leftSet, rightSet, partialResult, SignSet.getEmpty());
    }
}
