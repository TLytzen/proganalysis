package algorithms.reachingDefinitions;

import algorithms.CompleteLattice;
import algorithms.Equation;
import algorithms.Worklist;
import algorithms.WorklistAlgorithm;
import algorithms.worklists.SetWorklist;
import ast.Node;
import ast.nodes.ArrayAssignment;
import ast.nodes.ArrayDeclaration;
import ast.nodes.IntAssignment;
import ast.nodes.IntDeclaration;
import ast.nodes.arithmeticExpressions.ArithmeticConstantExpression;
import graph.FlowGraph;

import java.util.*;

public class RDAnalysis {


    public static CompleteLattice[] analyse(FlowGraph graph)
    {
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

        List<Equation> equations = new ArrayList<>();

        // Create the constraints for the initial values
        for (int variable = 0; variable < variableCount; variable++){
            equations.add(new BitVectorFrameworkConstraint(graph.getInitialNode(), null, new BitVectorSet(variable, BitVectorSet.QuestionMarkSet), null));
        }

        RDGenSetVisitor genSetVisitor = new RDGenSetVisitor();
        RDKillSetVisitor killSetVisitor = new RDKillSetVisitor();

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

        // ADD the equations to the worklist algorithm
        return WorklistAlgorithm.solve(equations, graph.size(), new SetWorklist(), new RDLattice(variables));
    }



}
