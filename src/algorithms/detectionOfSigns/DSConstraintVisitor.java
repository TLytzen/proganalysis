package algorithms.detectionOfSigns;

import algorithms.detectionOfSigns.stateSpaceUpdates.*;
import ast.Visitor;
import ast.nodes.*;
import ast.nodes.booleanExpressions.BooleanComparisonExpression;
import ast.nodes.booleanExpressions.BooleanConstantExpression;
import ast.nodes.booleanExpressions.BooleanOperatorExpression;
import ast.nodes.booleanExpressions.BooleanUnaryOperatorExpression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class DSConstraintVisitor extends Visitor<StateSpaceUpdate, HashMap<String, Integer>> {

    @Override
    public StateSpaceUpdate visitIntDeclaration(IntDeclaration intDeclarationNode, HashMap<String, Integer> data) {
        String index = intDeclarationNode.getIdentifier();
        return new StaticValueUpdate(SignSet.getZero(index, data.get(index)));
    }

    @Override
    public StateSpaceUpdate visitArrayDeclaration(ArrayDeclaration arrayDeclaration, HashMap<String, Integer> data) {
        String firstIndex = ArrayDeclaration.getFirstElementIdentifier(arrayDeclaration.getIdentifier());
        String restIndex = ArrayDeclaration.getRestElementIdentifier(arrayDeclaration.getIdentifier());

        List<SignSet> updates = new ArrayList<>(2);
        updates.add(SignSet.getZero(firstIndex, data.get(firstIndex)));
        updates.add(SignSet.getZero(restIndex, data.get(restIndex)));

        return new StaticValueUpdate(updates);
    }

    @Override
    public StateSpaceUpdate visitIntAssignment(IntAssignment intAssignment, HashMap<String, Integer> data) {
        SignsOfArithmeticExpressions arithmeticExpressions = new SignsOfArithmeticExpressions(data);

        return new SingleVariableValueUpdate(data.get(intAssignment.getIdentifier()), intAssignment.getValue(), arithmeticExpressions);
    }

    @Override
    public StateSpaceUpdate visitArrayAssignment(ArrayAssignment arrayAssignment, HashMap<String, Integer> data) {
        SignsOfArithmeticExpressions arithmeticExpressions = new SignsOfArithmeticExpressions(data);

        int firstIndex = data.get(ArrayDeclaration.getFirstElementIdentifier(arrayAssignment.getIdentifier()));
        int restIndex = data.get(ArrayDeclaration.getRestElementIdentifier(arrayAssignment.getIdentifier()));

        return  new ArrayValueUpdate(firstIndex, restIndex, arrayAssignment.getIndex(), arrayAssignment.getValue(), arithmeticExpressions);
    }

    @Override
    public StateSpaceUpdate visitReadIntStatement(ReadIntStatement readIntStatement, HashMap<String, Integer> data) {
        String index = readIntStatement.getIdentifier();
        return new StaticValueUpdate(SignSet.getTop(index, data.get(index)));
    }

    @Override
    public StateSpaceUpdate visitReadArrayStatement(ReadArrayStatement readArrayStatement, HashMap<String, Integer> data) {
        SignsOfArithmeticExpressions arithmeticExpressions = new SignsOfArithmeticExpressions(data);

        int firstIndex = data.get(ArrayDeclaration.getFirstElementIdentifier(readArrayStatement.getArrayExpression().getIdentifier()));
        int restIndex = data.get(ArrayDeclaration.getRestElementIdentifier(readArrayStatement.getArrayExpression().getIdentifier()));

        return  new ArrayReadUpdate(firstIndex, restIndex, readArrayStatement.getArrayExpression().getIndex(), arithmeticExpressions);
    }

    @Override
    public StateSpaceUpdate visitBooleanComparisonExpression(BooleanComparisonExpression booleanComparisonExpression, HashMap<String, Integer> data) {
        return visitBooleanExpression(booleanComparisonExpression, data);
    }

    @Override
    public StateSpaceUpdate visitBooleanConstantExpression(BooleanConstantExpression booleanConstantExpression, HashMap<String, Integer> data) {
        return visitBooleanExpression(booleanConstantExpression, data);
    }

    @Override
    public StateSpaceUpdate visitBooleanOperatorExpression(BooleanOperatorExpression booleanOperatorExpression, HashMap<String, Integer> data) {
        return visitBooleanExpression(booleanOperatorExpression, data);
    }

    @Override
    public StateSpaceUpdate visitBooleanUnaryOperatorExpression(BooleanUnaryOperatorExpression booleanOperatorExpression, HashMap<String, Integer> data) {
        return visitBooleanExpression(booleanOperatorExpression, data);
    }

    private StateSpaceUpdate visitBooleanExpression(BooleanExpression expression, HashMap<String, Integer> data){
        return new BooleanExpressionUpdate(expression, new SignsOfBooleanExpressions(new SignsOfArithmeticExpressions(data)));
    }
}
