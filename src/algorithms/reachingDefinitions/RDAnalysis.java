package algorithms.reachingDefinitions;


import algorithms.Equation;
import ast.Node;
import ast.nodes.ArrayAssignment;
import ast.nodes.ArrayDeclaration;
import ast.nodes.IntAssignment;
import ast.nodes.IntDeclaration;
import ast.nodes.arithmeticExpressions.ArithmeticConstantExpression;
import graph.FlowGraph;

import java.util.*;

public class RDAnalysis {

    private HashMap<String, Integer> variables;

    public static final long QuestionMarkSet = 1;

    public static final long KillVariableSet = Long.MAX_VALUE;

    public RDAnalysis(FlowGraph graph)
    {
        this.variables = new HashMap<>();

        int variableCount = 0;
        for (int vertice = 0; vertice < graph.size(); vertice++){
            Node node = graph.getVertice(vertice);


            if (node instanceof IntDeclaration){
                IntDeclaration intDeclaration = (IntDeclaration)node;
                if (!this.variables.containsKey(intDeclaration.getIdentifier())){
                    this.variables.put(intDeclaration.getIdentifier(), ++variableCount);
                }
            }

            if (node instanceof ArrayDeclaration){
                ArrayDeclaration arrayDeclaration = (ArrayDeclaration)node;
                for (int n = 0; n < arrayDeclaration.getLength(); n++){
                    String index = getArrayElementIdentifier(arrayDeclaration.getIdentifier(), n);
                    if (!this.variables.containsKey(index)){
                        this.variables.put(index, ++variableCount);
                    }
                }
            }
        }

        HashSet<Equation> equations = new HashSet<>();

        // Create the constraints for the initial values
        for (int variable = 0; variable < variableCount; variable++){
            equations.add(new BitVectorFrameworkConstraint(graph.getInitialNode(), null, new BitVectorSet(variable, QuestionMarkSet), null));
        }

        // Create the rest of the constraints
        for (int vertice = 0; vertice < graph.size(); vertice++){

            List<BitVectorSet> genSets = this.getGenSet(graph.getVertice(vertice));
            List<BitVectorSet> killSets = this.getKillSet(graph.getVertice(vertice));

            for (int destination : graph.getEdges(vertice)){
                // Add one equation for each of the elements in killSets
                if (killSets != null) {
                    for (BitVectorSet killSet : killSets) {
                        equations.add(new BitVectorFrameworkConstraint(destination, vertice, null, killSet));
                    }
                }
                else{
                    // This is needed if genSets are empty - we should still have an equation for the forwarding of the information from the RD_out to the next RD_in
                    equations.add(new BitVectorFrameworkConstraint(destination, vertice, null, null));
                }

                // Add one equation for each of the genSets
                if (genSets != null){
                    for (BitVectorSet genSet : genSets) {
                        equations.add(new BitVectorFrameworkConstraint(destination, null, genSet, null));
                    }
                }
            }
        }

    // ADD the equations to the worklist algorithm
    }

    /// THIS should be implemented using a Visitor pattern instead of this instanceof business
    private List<BitVectorSet> getKillSet(Node vertice) {

        if (vertice instanceof IntDeclaration){
            IntDeclaration intDeclarationNode = (IntDeclaration)vertice;
            return Collections.singletonList(new BitVectorSet(this.variables.get(intDeclarationNode.getIdentifier()), KillVariableSet));
        }

        if (vertice instanceof ArrayDeclaration){
            ArrayDeclaration arrayDeclarationNode = (ArrayDeclaration)vertice;
            List<BitVectorSet> arrayGenerations = new ArrayList<>();

            for (int n = 0; n < arrayDeclarationNode.getLength(); n++){
                arrayGenerations.add(new BitVectorSet(this.variables.get(getArrayElementIdentifier(arrayDeclarationNode.getIdentifier(), n)), KillVariableSet));
            }

            return arrayGenerations;
        }

        if (vertice instanceof IntAssignment){
            IntAssignment intAssignmentNode = (IntAssignment)vertice;
            // x := ... where x is a int
            return Collections.singletonList(new BitVectorSet(this.variables.get(intAssignmentNode.getIdentifier()), KillVariableSet));
        }

        if (vertice instanceof ArrayAssignment) {
            ArrayAssignment arrayAssignmentNode = (ArrayAssignment)vertice;
            if(arrayAssignmentNode.getIndex() instanceof ArithmeticConstantExpression)
            {
                // The case where A[n] := ....
                String index = getArrayElementIdentifier(arrayAssignmentNode.getIdentifier(), ((ArithmeticConstantExpression)arrayAssignmentNode.getIndex()).getValue());
                if (this.variables.containsKey(index)){
                    return Collections.singletonList(new BitVectorSet(this.variables.get(index), KillVariableSet));
                }
            }
        }


        // Read statements are missing
        return null;
    }

    private List<BitVectorSet> getGenSet(Node vertice) {



        if (vertice instanceof IntDeclaration){
            IntDeclaration intDeclarationNode = (IntDeclaration)vertice;
            return Collections.singletonList(new BitVectorSet(this.variables.get(intDeclarationNode.getIdentifier()), getSetForLabel(intDeclarationNode.getLabel())));
        }

        if (vertice instanceof ArrayDeclaration){
            ArrayDeclaration arrayDeclarationNode = (ArrayDeclaration)vertice;
            List<BitVectorSet> arrayGenerations = new ArrayList<>();

            for (int n = 0; n < arrayDeclarationNode.getLength(); n++){
                arrayGenerations.add(new BitVectorSet(this.variables.get(getArrayElementIdentifier(arrayDeclarationNode.getIdentifier(), n)), getSetForLabel(arrayDeclarationNode.getLabel())));
            }

            return arrayGenerations;
        }

        if (vertice instanceof IntAssignment){
            IntAssignment intAssignmentNode = (IntAssignment)vertice;
            // x := ... where x is a int
            return Collections.singletonList(new BitVectorSet(this.variables.get(intAssignmentNode.getIdentifier()), getSetForLabel(intAssignmentNode.getLabel())));
        }

        if (vertice instanceof ArrayAssignment) {
            ArrayAssignment arrayAssignmentNode = (ArrayAssignment)vertice;
            if(arrayAssignmentNode.getIndex() instanceof ArithmeticConstantExpression)
            {
                // The case where A[n] := ....
                String index = getArrayElementIdentifier(arrayAssignmentNode.getIdentifier(), ((ArithmeticConstantExpression)arrayAssignmentNode.getIndex()).getValue());
                if (this.variables.containsKey(index)){
                    return Collections.singletonList(new BitVectorSet(this.variables.get(index), getSetForLabel(arrayAssignmentNode.getLabel())));
                }
            }
            else{
                // The case where A[a_1] := where a_1 is not a constant expression
                List<BitVectorSet> arrayGenerations = new ArrayList<>();
                for (int n = 0; n < this.variables.size(); n++){
                    String index = getArrayElementIdentifier(arrayAssignmentNode.getIdentifier(), n);
                    if (!this.variables.containsKey(index)){
                        break;
                    }

                    arrayGenerations.add(new BitVectorSet(this.variables.get(index), getSetForLabel(arrayAssignmentNode.getLabel())));
                }

                return arrayGenerations;
            }
        }

        // Read statements are missing

        return null;
    }

    private long getSetForLabel(int labelNum){
        return 1 << (1 + labelNum);
    }

    private  String getArrayElementIdentifier(String arrayIdentifier, int element){
        return arrayIdentifier+"["+element+"]";
    }
}
