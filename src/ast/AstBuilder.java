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

    @Override
    public Node visitAssignStmt(TheLangParser.AssignStmtContext ctx) {
        if (ctx.LBRACKET() != null) {
            return new ArrayAssignment(ctx.IDENTIFIER().toString(), (ArithmeticExpression)visit(ctx.aexpr(0)), (ArithmeticExpression)visit(ctx.aexpr(1)));
        }

        return new IntAssignment(ctx.IDENTIFIER().toString(), (ArithmeticExpression)visit(ctx.aexpr(0)));
    }

    @Override
    public Node visitAexpr(TheLangParser.AexprContext ctx) {
        List<TheLangParser.Aexpr1Context> expressions = ctx.aexpr1();

        ArithmeticExpression left = (ArithmeticExpression)visit(expressions.get(0));

        for (int index = 1; index < expressions.size(); index++)
        {
            ArithmeticExpression right = (ArithmeticExpression)visit(expressions.get(index));
            String operator;
            if (ctx.PLUS(index - 1) != null)
            {
                operator = "+";
            }
            else{
                operator = "-";
            }

            left = new OperatorExpression(left, operator, right);
        }

        return left;
    }

    @Override
    public Node visitAexpr1(TheLangParser.Aexpr1Context ctx) {
        List<TheLangParser.Aexpr2Context> expressions = ctx.aexpr2();

        ArithmeticExpression left = (ArithmeticExpression)visit(expressions.get(0));

        for (int index = 1; index < expressions.size(); index++)
        {
            ArithmeticExpression right = (ArithmeticExpression)visit(expressions.get(index));
            String operator;
            if (ctx.MUL(index - 1) != null)
            {
                operator = "*";
            }
            else{
                operator = "/";
            }

            left = new OperatorExpression(left, operator, right);
        }

        return left;
    }

    @Override
    public Node visitAexpr2(TheLangParser.Aexpr2Context ctx) {
        ArithmeticExpression expression = (ArithmeticExpression)visit(ctx.aexpr3());

        if (ctx.MINUS() != null)
        {
            expression = new UnaryOperatorExpression("-",expression);

        }

        return expression;
    }

    @Override
    public Node visitAexpr3(TheLangParser.Aexpr3Context ctx) {
        if(ctx.IDENTIFIER() != null)
        {
            String identifier = ctx.IDENTIFIER().toString();
            if (ctx.aexpr() != null)
            {
                return new ArrayExpression(identifier, (ArithmeticExpression)visit(ctx.aexpr()));
            }

            return new IntExpression(identifier);

        }
        else if(ctx.INTEGER() != null)
        {
            return new ConstantExpression( Integer.parseInt(ctx.INTEGER().toString()));
        }

        return visit(ctx.aexpr());
    }

    @Override
    public Node visitBexpr(TheLangParser.BexprContext ctx) {
        return super.visitBexpr(ctx);
    }

    @Override
    public Node visitBexpr1(TheLangParser.Bexpr1Context ctx) {
        return super.visitBexpr1(ctx);
    }

    @Override
    public Node visitBexpr2(TheLangParser.Bexpr2Context ctx) {
        return super.visitBexpr2(ctx);
    }

    @Override
    public Node visitOpr(TheLangParser.OprContext ctx) {
        return super.visitOpr(ctx);
    }
}
