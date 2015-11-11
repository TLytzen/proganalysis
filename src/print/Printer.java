package print;

import algorithms.CompleteLattice;
import ast.Node;
import ast.Visitor;
import ast.nodes.*;
import graph.FlowGraph;
import graph.GraphWalker;

import java.util.List;

/**
 * Created by Thomas on 11-11-2015.
 */
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
        FlowVisitor flowVisitor = new FlowVisitor();
        public PrettyPrinter(CompleteLattice[] analysisResult){
            this.result = analysisResult;
        }

        @Override
        public String preOrder(Node node) {
            return this.flowVisitor.visitNode(node,this.result[node.getLabel()]);
        }

        @Override
        public String postOrder(Node node) {
            return null;
        }
    }

    private class FlowVisitor extends Visitor<String,CompleteLattice>{
        @Override
        public String visitArrayAssignment(ArrayAssignment arrayAssignment, CompleteLattice data) {
            return "["+arrayAssignment.toString()+"]"+"^"+arrayAssignment.getLabel()+" : "+ data.toString();
        }

        @Override
        public String visitArrayDeclaration(ArrayDeclaration arrayDeclaration, CompleteLattice data) {
            return "["+arrayDeclaration.toString()+"]"+"^"+arrayDeclaration.getLabel()+" : "+ data.toString();
        }

        @Override
        public String visitIntAssignment(IntAssignment intAssignment, CompleteLattice data) {
            return "["+intAssignment.toString()+"]"+"^"+intAssignment.getLabel()+" : "+ data.toString();
        }

        @Override
        public String visitIntDeclaration(IntDeclaration intDeclaration, CompleteLattice data){
            return "["+intDeclaration.toString()+"]"+"^"+intDeclaration.getLabel()+" : "+ data.toString();
        }

        @Override
        public String visitReadArrayStatement(ReadArrayStatement readArrayStatement, CompleteLattice data){
            return "["+ readArrayStatement.toString()+"]"+"^"+readArrayStatement.getLabel()+" : "+ data.toString();
        }

        @Override
        public String visitReadIntStatement(ReadIntStatement readIntStatement, CompleteLattice data){
            return "[" + readIntStatement.toString()+"]"+"^"+readIntStatement.getLabel()+" : "+ data.toString();
        }

        @Override
        public String visitSkipStatement(SkipStatement skipStatement, CompleteLattice data){
            return "[" + skipStatement.toString()+"]"+"^"+skipStatement.getLabel()+" : "+ data.toString();
        }
        @Override
        public String visitBooleanExpression(BooleanExpression booleanExpression, CompleteLattice data){
            return "["+booleanExpression.toString()+"]"+"^"+booleanExpression.getLabel()+" : "+ data.toString();
        }

        @Override
        public String visitWriteStatement(WriteStatement writeStatement, CompleteLattice data){
            return "["+writeStatement.toString()+"]"+"^"+writeStatement.getLabel()+" : "+ data.toString();
        }
    }
}
