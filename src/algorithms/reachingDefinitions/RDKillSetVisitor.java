package algorithms.reachingDefinitions;


import ast.Visitor;
import ast.nodes.*;
import ast.nodes.arithmeticExpressions.ArithmeticConstantExpression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class RDKillSetVisitor extends Visitor<List<BitVectorSet>, HashMap<String, Integer>> {


    @Override
    public List<BitVectorSet> visitIntDeclaration(IntDeclaration intDeclarationNode, HashMap<String, Integer> variables) {
        String index = intDeclarationNode.getIdentifier();
        return Collections.singletonList(BitVectorSet.generateKillVariableSet(index, variables));
    }

    @Override
    public List<BitVectorSet> visitArrayDeclaration(ArrayDeclaration arrayDeclarationNode, HashMap<String, Integer> variables) {
        List<BitVectorSet> arrayGenerations = new ArrayList<>();

        for (int n = 0; n < arrayDeclarationNode.getLength(); n++){
            String index = ArrayDeclaration.getElementIdentifier(arrayDeclarationNode.getIdentifier(), n);
            arrayGenerations.add(BitVectorSet.generateKillVariableSet(index, variables));
        }

        return arrayGenerations;
    }

    /*
    * Kill set for the nodes of the form [x := a;] where x is an integer
    * */
    @Override
    public List<BitVectorSet> visitIntAssignment(IntAssignment intAssignmentNode, HashMap<String, Integer> variables) {
        String index = intAssignmentNode.getIdentifier();
        return Collections.singletonList(BitVectorSet.generateKillVariableSet(index, variables));
    }

    /*
    * Kill set for the nodes of the form [A[a_1] := a_2;] where A[a_1] is an array.
    *
    * This kill set is empty, unless a_1 is a constant integer.
    * */
    @Override
    public List<BitVectorSet> visitArrayAssignment(ArrayAssignment arrayAssignmentNode, HashMap<String, Integer> variables) {

        if(arrayAssignmentNode.getIndex() instanceof ArithmeticConstantExpression)
        {
            // The case  A[n] := ....; where n is constant
            String index = ArrayDeclaration.getElementIdentifier(arrayAssignmentNode.getIdentifier(), ((ArithmeticConstantExpression) arrayAssignmentNode.getIndex()).getValue());
            if (variables.containsKey(index)){
                return Collections.singletonList(BitVectorSet.generateKillVariableSet(index, variables));
            }
        }

        // Otherwise - nothing is killed
        return null;
    }

    @Override
    public List<BitVectorSet> visitReadIntStatement(ReadIntStatement readIntStatement, HashMap<String, Integer> variables) {
        String index = readIntStatement.getIdentifier();
        return Collections.singletonList(BitVectorSet.generateKillVariableSet(index, variables));
    }

    @Override
    public List<BitVectorSet> visitReadArrayStatement(ReadArrayStatement readArrayStatement, HashMap<String, Integer> variables) {

        if(readArrayStatement.getArrayExpression().getIndex() instanceof ArithmeticConstantExpression) {
            // The case read A[n] where  n is a constant
            String index = ArrayDeclaration.getElementIdentifier(readArrayStatement.getArrayExpression().getIdentifier(), ((ArithmeticConstantExpression) readArrayStatement.getArrayExpression().getIndex()).getValue());
            if (variables.containsKey(index)){
                return Collections.singletonList(BitVectorSet.generateKillVariableSet(index, variables));
            }
        }

        // Otherwise - nothing is killed
        return null;
    }
}
