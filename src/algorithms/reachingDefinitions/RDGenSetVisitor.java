package algorithms.reachingDefinitions;

import ast.Visitor;
import ast.nodes.*;
import ast.nodes.arithmeticExpressions.ArithmeticConstantExpression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class RDGenSetVisitor extends Visitor<List<BitVectorSet>, HashMap<String, Integer>> {

    @Override
    public List<BitVectorSet> visitIntDeclaration(IntDeclaration intDeclaration, HashMap<String, Integer> variables) {
        String index = intDeclaration.getIdentifier();
        int label = intDeclaration.getLabel();
        return Collections.singletonList(BitVectorSet.getSetForLabel(index, variables, label));
    }

    @Override
    public List<BitVectorSet> visitArrayDeclaration(ArrayDeclaration arrayDeclarationNode, HashMap<String, Integer> variables) {
        List<BitVectorSet> arrayGenerations = new ArrayList<>();

        for (int n = 0; n < arrayDeclarationNode.getLength(); n++){
            String index = ArrayDeclaration.getElementIdentifier(arrayDeclarationNode.getIdentifier(), n);
            int label = arrayDeclarationNode.getLabel();

            arrayGenerations.add(BitVectorSet.getSetForLabel(index, variables, label));
        }

        return arrayGenerations;
    }

    @Override
    public List<BitVectorSet> visitIntAssignment(IntAssignment intAssignmentNode, HashMap<String, Integer> variables) {
        // x := ... where x is a int
        String index = intAssignmentNode.getIdentifier();
        int label = intAssignmentNode.getLabel();
        return Collections.singletonList(BitVectorSet.getSetForLabel(index, variables, label));
    }

    @Override
    public List<BitVectorSet> visitArrayAssignment(ArrayAssignment arrayAssignmentNode, HashMap<String, Integer> variables) {

        if (arrayAssignmentNode.getIndex() instanceof ArithmeticConstantExpression) {
            // The case A[n] := .... where n is a constant
            String index = ArrayDeclaration.getElementIdentifier(arrayAssignmentNode.getIdentifier(), ((ArithmeticConstantExpression) arrayAssignmentNode.getIndex()).getValue());

            if (variables.containsKey(index)) {
                int label = arrayAssignmentNode.getLabel();
                return Collections.singletonList(BitVectorSet.getSetForLabel(index, variables, label));
            }

            return null;
        } else {
            // The case where A[a_1] := a_2 where a_1 is not a constant expression
            List<BitVectorSet> arrayGenerations = new ArrayList<>();
            int label = arrayAssignmentNode.getLabel();

            for (int n = 0; n < variables.size(); n++) {
                String index = ArrayDeclaration.getElementIdentifier(arrayAssignmentNode.getIdentifier(), n);
                if (!variables.containsKey(index)) {
                    break;
                }

                arrayGenerations.add(BitVectorSet.getSetForLabel(index, variables, label));
            }

            return arrayGenerations;
        }
    }

    @Override
    public List<BitVectorSet> visitReadIntStatement(ReadIntStatement readIntStatement, HashMap<String, Integer> variables) {
        String index = readIntStatement.getIdentifier();
        int label = readIntStatement.getLabel();
        return Collections.singletonList(BitVectorSet.getSetForLabel(index, variables, label));
    }

    @Override
    public List<BitVectorSet> visitReadArrayStatement(ReadArrayStatement readArrayStatement, HashMap<String, Integer> variables) {
        if (readArrayStatement.getArrayExpression().getIndex() instanceof ArithmeticConstantExpression) {
            // The case read A[n]; where n is a constant
            String index = ArrayDeclaration.getElementIdentifier(readArrayStatement.getArrayExpression().getIdentifier(), ((ArithmeticConstantExpression) readArrayStatement.getArrayExpression().getIndex()).getValue());
            if (variables.containsKey(index)) {
                int label = readArrayStatement.getLabel();
                return Collections.singletonList(BitVectorSet.getSetForLabel(index, variables, label));
            }

            return null;
        } else {
            // The case read A[a]; where a is not a constant expression
            List<BitVectorSet> arrayGenerations = new ArrayList<>();
            int label = readArrayStatement.getLabel();

            for (int n = 0; n < variables.size(); n++) {
                String index = ArrayDeclaration.getElementIdentifier(readArrayStatement.getArrayExpression().getIdentifier(), n);
                if (!variables.containsKey(index)) {
                    break;
                }

                arrayGenerations.add(BitVectorSet.getSetForLabel(index, variables, label));
            }

            return arrayGenerations;
        }
    }
}
