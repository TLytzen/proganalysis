package print;

import algorithms.CompleteLattice;
import ast.Node;
import ast.Visitor;
import ast.nodes.*;
import ast.nodes.booleanExpressions.BooleanComparisonExpression;
import ast.nodes.booleanExpressions.BooleanConstantExpression;
import ast.nodes.booleanExpressions.BooleanOperatorExpression;
import ast.nodes.booleanExpressions.BooleanUnaryOperatorExpression;
import graph.FlowGraph;
import graph.GraphWalker;

import java.util.List;

public class Printer {

    public void printGraph(FlowGraph flowgraph, CompleteLattice[] analysisResult){
            PrettyPrinter prettyprint = new PrettyPrinter(analysisResult);
            List<String> flowString = prettyprint.walk(flowgraph);

        for (String line:flowString) {
            System.out.println(line);

        }
    }

    private class PrettyPrinter extends GraphWalker<String>{
        CompleteLattice[] result;
        public PrettyPrinter(CompleteLattice[] analysisResult){
            this.result = analysisResult;
        }

        @Override
        public String preOrder(Node node) {
            return this.printNode(node, this.result[node.getLabel()]);
        }

        @Override
        public String postOrder(Node node) {
            return null;
        }

        private String printNode(Node node, CompleteLattice data){
            return "Entry(["+node.toString()+"]"+"^"+node.getLabel()+"): "+data.toString();
        }
    }
}
