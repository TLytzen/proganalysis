package algorithms.reachingDefinitions;

import algorithms.*;
import ast.Node;
import ast.nodes.ArrayDeclaration;
import ast.nodes.IntDeclaration;
import graph.FlowGraph;

import java.util.*;

public class RDAnalysis extends Analysis {

    @Override
    public CompleteLattice[] analyse(FlowGraph graph, Worklist worklist)
    {
        // Map each variable name in the graph to a number
        HashMap<String, Integer> variables = getVariablesMap(graph);

        // Generate the constraints
        List<Constraint> equations = new ArrayList<>();
        RDGenSetVisitor genSetVisitor = new RDGenSetVisitor();
        RDKillSetVisitor killSetVisitor = new RDKillSetVisitor();

        // Create the constraints for the initial values
        for (String variableName : variables.keySet()){
            int variable = variables.get(variableName);
            equations.add(new BitVectorFrameworkConstraint(graph.getInitialNode(), null, BitVectorSet.generateQuestionMarkSet (variableName, variable), null));
        }

        // Create the rest of the constraints
        for (int vertice = 0; vertice < graph.size(); vertice++){

            Node node = graph.getVertice(vertice);
            List<BitVectorSet> genSets = genSetVisitor.visitNode(node, variables);
            List<BitVectorSet> killSets = killSetVisitor.visitNode(node, variables);

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

        // Solve the constraints using the worklist algorithm
        return WorklistAlgorithm.solve(equations, graph.size(), worklist, new RDLattice(variables));
    }

    private static HashMap<String, Integer> getVariablesMap(FlowGraph graph) {
        HashMap<String, Integer> variables = new HashMap<>();

        int variableCount = 0;
        for (int vertice = 0; vertice < graph.size(); vertice++){
            Node node = graph.getVertice(vertice);


            if (node instanceof IntDeclaration){
                IntDeclaration intDeclaration = (IntDeclaration)node;
                if (!variables.containsKey(intDeclaration.getIdentifier())){
                    variables.put(intDeclaration.getIdentifier(), variableCount++);
                }
            }

            if (node instanceof ArrayDeclaration){
                ArrayDeclaration arrayDeclaration = (ArrayDeclaration)node;
                for (int n = 0; n < arrayDeclaration.getLength(); n++){
                    String index = ArrayDeclaration.getElementIdentifier(arrayDeclaration.getIdentifier(), n);
                    if (!variables.containsKey(index)){
                        variables.put(index, variableCount++);
                    }
                }
            }
        }
        return variables;
    }


}
