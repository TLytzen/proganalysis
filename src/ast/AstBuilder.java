package ast;

import antlr.TheLangBaseVisitor;
import antlr.TheLangParser;
import ast.nodes.*;


import java.nio.channels.InterruptibleChannel;
import java.util.ArrayList;
import java.util.List;


public class AstBuilder extends TheLangBaseVisitor<Node> {

    @Override
    public Node visitProgram(TheLangParser.ProgramContext ctx) {
        List<Node> nodes = new ArrayList<>();

        for (TheLangParser.DeclContext decl : ctx.decl())
        {
            nodes.add(visit(decl));
        }

        for (TheLangParser.StmtContext stmt : ctx.stmt())
        {
            nodes.add(visit(stmt));
        }

        return new RootNode(nodes);
    }

    @Override
    public Node visitDecl(TheLangParser.DeclContext ctx) {

        if (ctx.INTEGER() != null)
        {
            return new ArrayDeclaration(ctx.IDENTIFIER().toString(), Integer.parseInt(ctx.INTEGER().toString()));
        }

        return new IntDeclaration(ctx.IDENTIFIER().toString());
    }
}
