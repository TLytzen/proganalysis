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
        return Collections.singletonList(new BitVectorSet(variables.get(intDeclaration.getIdentifier()), BitVectorSet.getSetForLabel(intDeclaration.getLabel())));
    }

    @Override
    public List<BitVectorSet> visitArrayDeclaration(ArrayDeclaration arrayDeclarationNode, HashMap<String, Integer> variables) {
        List<BitVectorSet> arrayGenerations = new ArrayList<>();

        for (int n = 0; n < arrayDeclarationNode.getLength(); n++){
            arrayGenerations.add(new BitVectorSet(variables.get(RDAnalysis.getArrayElementIdentifier(arrayDeclarationNode.getIdentifier(), n)), BitVectorSet.getSetForLabel(arrayDeclarationNode.getLabel())));
        }

        return arrayGenerations;
    }

    @Override
    public List<BitVectorSet> visitIntAssignment(IntAssignment intAssignmentNode, HashMap<String, Integer> variables) {
        // x := ... where x is a int
        return Collections.singletonList(new BitVectorSet(variables.get(intAssignmentNode.getIdentifier()), BitVectorSet.getSetForLabel(intAssignmentNode.getLabel())));
    }

    @Override
    public List<BitVectorSet> visitArrayAssignment(ArrayAssignment arrayAssignmentNode, HashMap<String, Integer> variables) {
        if (arrayAssignmentNode.getIndex() instanceof ArithmeticConstantExpression) {
            // The case A[n] := .... where n is a constant
            String index = RDAnalysis.getArrayElementIdentifier(arrayAssignmentNode.getIdentifier(), ((ArithmeticConstantExpression) arrayAssignmentNode.getIndex()).getValue());
            if (variables.containsKey(index)) {
                return Collections.singletonList(new BitVectorSet(variables.get(index), BitVectorSet.getSetForLabel(arrayAssignmentNode.getLabel())));
            }

            return null;
        } else {
            // The case where A[a_1] := a_2 where a_1 is not a constant expression
            List<BitVectorSet> arrayGenerations = new ArrayList<>();
            for (int n = 0; n < variables.size(); n++) {
                String index = RDAnalysis.getArrayElementIdentifier(arrayAssignmentNode.getIdentifier(), n);
                if (!variables.containsKey(index)) {
                    break;
                }

                arrayGenerations.add(new BitVectorSet(variables.get(index), BitVectorSet.getSetForLabel(arrayAssignmentNode.getLabel())));
            }

            return arrayGenerations;
        }
    }

    @Override
    public List<BitVectorSet> visitReadIntStatement(ReadIntStatement readIntStatement, HashMap<String, Integer> variables) {
        return Collections.singletonList(new BitVectorSet(variables.get(readIntStatement.getIdentifier()), BitVectorSet.KillVariableSet));
    }

    @Override
    public List<BitVectorSet> visitReadArrayStatement(ReadArrayStatement readArrayStatement, HashMap<String, Integer> variables) {
        if (readArrayStatement.getArrayExpression().getIndex() instanceof ArithmeticConstantExpression) {
            // The case read A[n]; where n is a constant
            String index = RDAnalysis.getArrayElementIdentifier(readArrayStatement.getArrayExpression().getIdentifier(), ((ArithmeticConstantExpression) readArrayStatement.getArrayExpression().getIndex()).getValue());
            if (variables.containsKey(index)) {
                return Collections.singletonList(new BitVectorSet(variables.get(index), BitVectorSet.getSetForLabel(readArrayStatement.getLabel())));
            }

            return null;
        } else {
            // The case read A[a]; where a is not a constant expression
            List<BitVectorSet> arrayGenerations = new ArrayList<>();
            for (int n = 0; n < variables.size(); n++) {
                String index = RDAnalysis.getArrayElementIdentifier(readArrayStatement.getArrayExpression().getIdentifier(), n);
                if (!variables.containsKey(index)) {
                    break;
                }

                arrayGenerations.add(new BitVectorSet(variables.get(index), BitVectorSet.getSetForLabel(readArrayStatement.getLabel())));
            }

            return arrayGenerations;
        }
    }
}
