package algorithms.detectionOfSigns;


import algorithms.*;
import algorithms.detectionOfSigns.stateSpaceUpdates.ExtremalValueAssignment;
import algorithms.detectionOfSigns.stateSpaceUpdates.StateSpaceUpdate;
import ast.Node;
import ast.nodes.ArrayDeclaration;
import ast.nodes.IntDeclaration;
import graph.FlowGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DSAnalysis extends Analysis {
    @Override
    public CompleteLattice[] analyse(FlowGraph graph, Worklist worklist, boolean measureTime) {
        // Map each variable name in the graph to a number
        HashMap<String, Integer> variables = getVariablesMap(graph);

        // Generate the constraints
        List<Constraint> equations = new ArrayList<>();
        for (String variableName : variables.keySet()) {
            int variable = variables.get(variableName);
            equations.add(ExtremalValueAssignment.getExtremalValueAssignment(graph.getInitialNode(), variableName, variable));
        }

        DSConstraintVisitor constraintVisitor = new DSConstraintVisitor();

        // Create the rest of the constraints
        for (int vertice = 0; vertice < graph.size(); vertice++) {

            Node node = graph.getVertice(vertice);
            StateSpaceUpdate stateSpaceUpdate = constraintVisitor.visitNode(node, variables);

            for (int destination : graph.getEdges(vertice)) {
                if (stateSpaceUpdate != null) {
                    equations.add(new AbstractStateSpaceConstraint(destination, vertice, stateSpaceUpdate, graph.isTrueBranch(vertice, destination)));
                } else {
                    equations.add(new AbstractStateSpaceConstraint(destination, vertice, null, graph.isTrueBranch(vertice, destination)));
                }
            }
        }

        // Solve the constraints using the worklist algorithm
        return WorklistAlgorithm.solve(equations, graph.size(), worklist, new DSLattice(variables), measureTime);
    }

    private static HashMap<String, Integer> getVariablesMap(FlowGraph graph) {
        HashMap<String, Integer> variables = new HashMap<>();

        int variableCount = 0;
        for (int vertice = 0; vertice < graph.size(); vertice++) {
            Node node = graph.getVertice(vertice);


            if (node instanceof IntDeclaration) {
                IntDeclaration intDeclaration = (IntDeclaration) node;
                if (!variables.containsKey(intDeclaration.getIdentifier())) {
                    variables.put(intDeclaration.getIdentifier(), variableCount++);
                }
            }

            if (node instanceof ArrayDeclaration) {
                ArrayDeclaration arrayDeclaration = (ArrayDeclaration) node;

                String firstIndex = ArrayDeclaration.getFirstElementIdentifier(arrayDeclaration.getIdentifier());
                String restIndex = ArrayDeclaration.getRestElementIdentifier(arrayDeclaration.getIdentifier());

                variables.put(firstIndex, variableCount++);
                variables.put(restIndex, variableCount++);
            }
        }
        return variables;
    }
}
