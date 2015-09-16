

import antlr.TheLangLexer;
import antlr.TheLangParser;
import ast.AstBuilder;
import ast.Node;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class Main {

    public static void main(String args[]) throws Exception {
        InputStream input = new FileInputStream(args[0]);
        CharStream cs = new ANTLRInputStream(input);
        TheLangLexer lex = new TheLangLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lex);
        TheLangParser parser = new TheLangParser(tokens);

        Node rootNode;

        try {
            TheLangParser.ProgramContext parserResult = parser.program();
            AstBuilder builder = new AstBuilder();
            rootNode = builder.visit(parserResult);
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}
