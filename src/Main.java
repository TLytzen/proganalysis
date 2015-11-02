

import antlr.TheLangLexer;
import antlr.TheLangParser;
import ast.AstBuilder;
import ast.Node;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String args[]) throws Exception {

        // Read Program and convert to AST
        Node rootNode = readProgram(args[0]);

        // Construct Flow Graph
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
