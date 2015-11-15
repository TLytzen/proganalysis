

import algorithms.Analysis;
import algorithms.CompleteLattice;
import algorithms.Worklist;
import algorithms.detectionOfSigns.DSAnalysis;
import algorithms.reachingDefinitions.RDAnalysis;
import algorithms.worklists.SetWorklist;
import antlr.TheLangLexer;
import antlr.TheLangParser;
import ast.AstBuilder;
import ast.Node;
import graph.FlowGraph;
import org.antlr.v4.runtime.*;
import print.Printer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String args[]) throws Exception {

        Input input = Input.parseInput(args);

        // Read Program and convert to AST
        Node rootNode = readProgram(input.getProgramFileName());

        // Construct Flow Graph
        FlowGraph graph = FlowGraph.constructGraph(rootNode);

        // Run the reaching definitions analysis
        CompleteLattice[] rdAnalysis = input.getAnalysis().analyse(graph, input.getWorklist());

        // Print the result
        Printer print = new Printer();
        print.printGraph(graph, rdAnalysis);
    }

    private static Node readProgram(String arg) throws IOException {
        Node rootNode;
        InputStream input = new FileInputStream(arg);
        CharStream cs = new ANTLRInputStream(input);
        TheLangLexer lex = new TheLangLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lex);
        TheLangParser parser = new TheLangParser(tokens);


        try {
            TheLangParser.ProgramContext parserResult = parser.program();
            AstBuilder builder = new AstBuilder();
            rootNode = builder.visit(parserResult);
        } catch (RecognitionException e) {
            e.printStackTrace();
            throw e;
        }

        return rootNode;
    }

}
