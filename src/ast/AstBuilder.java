package ast;

import antlr.TheLangBaseVisitor;
import antlr.TheLangParser;
import ast.nodes.*;
import ast.nodes.arithmeticExpressions.*;
import ast.nodes.BooleanExpression;
import ast.nodes.booleanExpressions.BooleanComparisonExpression;
import ast.nodes.booleanExpressions.BooleanConstantExpression;
import ast.nodes.booleanExpressions.BooleanOperatorExpression;
import ast.nodes.booleanExpressions.BooleanUnaryOperatorExpression;

import java.util.ArrayList;
import java.util.List;


public class AstBuilder extends TheLangBaseVisitor<Node> {

    @Override
    public Node visitProgram(TheLangParser.ProgramContext ctx) {
        List<Node> nodes = new ArrayList<>();

        for (TheLangParser.DeclContext decl : ctx.decl()) {
            nodes.add(visit(decl));
        }

        for (TheLangParser.StmtContext stmt : ctx.stmt()) {
            nodes.add(visit(stmt));
        }

        return new RootNode(nodes);
    }

    @Override
    public Node visitDecl(TheLangParser.DeclContext ctx) {

        if (ctx.INTEGER() != null) {
            return new ArrayDeclaration(ctx.IDENTIFIER().toString(), Integer.parseInt(ctx.INTEGER().toString()));
        }

        return new IntDeclaration(ctx.IDENTIFIER().toString());
    }

    @Override
    public Node visitAssignStmt(TheLangParser.AssignStmtContext ctx) {
        if (ctx.LBRACKET() != null) {
            return new ArrayAssignment(ctx.IDENTIFIER().toString(), (ArithmeticExpression) visit(ctx.aexpr(0)), (ArithmeticExpression) visit(ctx.aexpr(1)));
        }

        return new IntAssignment(ctx.IDENTIFIER().toString(), (ArithmeticExpression) visit(ctx.aexpr(0)));
    }

    @Override
    public Node visitAexpr(TheLangParser.AexprContext ctx) {
        List<TheLangParser.Aexpr1Context> expressions = ctx.aexpr1();

        ArithmeticExpression left = (ArithmeticExpression) visit(expressions.get(0));

        for (int index = 1; index < expressions.size(); index++) {
            ArithmeticExpression right = (ArithmeticExpression) visit(expressions.get(index));
            String operator;
            if (ctx.PLUS(index - 1) != null) {
                operator = "+";
            } else {
                operator = "-";
            }

            left = new ArithmeticOperatorExpression(left, operator, right);
        }

        return left;
    }

    @Override
    public Node visitAexpr1(TheLangParser.Aexpr1Context ctx) {
        List<TheLangParser.Aexpr2Context> expressions = ctx.aexpr2();

        ArithmeticExpression left = (ArithmeticExpression) visit(expressions.get(0));

        for (int index = 1; index < expressions.size(); index++) {
            ArithmeticExpression right = (ArithmeticExpression) visit(expressions.get(index));
            String operator;
            if (ctx.MUL(index - 1) != null) {
                operator = "*";
            } else {
                operator = "/";
            }

            left = new ArithmeticOperatorExpression(left, operator, right);
        }

        return left;
    }

    @Override
    public Node visitAexpr2(TheLangParser.Aexpr2Context ctx) {
        ArithmeticExpression expression = (ArithmeticExpression) visit(ctx.aexpr3());

        if (ctx.MINUS() != null) {
            expression = new ArithmeticUnaryOperatorExpression("-", expression);

        }

        return expression;
    }

    @Override
    public Node visitAexpr3(TheLangParser.Aexpr3Context ctx) {
        if (ctx.IDENTIFIER() != null) {
            String identifier = ctx.IDENTIFIER().toString();
            if (ctx.aexpr() != null) {
                return new ArrayExpression(identifier, (ArithmeticExpression) visit(ctx.aexpr()));
            }

            return new IntExpression(identifier);

        } else if (ctx.INTEGER() != null) {
            return new ArithmeticConstantExpression(Integer.parseInt(ctx.INTEGER().toString()));
        }

        return visit(ctx.aexpr());
    }

    @Override
    public Node visitBexpr(TheLangParser.BexprContext ctx) {
        List<TheLangParser.Bexpr1Context> expressions = ctx.bexpr1();

        BooleanExpression left = (BooleanExpression) visit(expressions.get(0));

        for (int index = 1; index < expressions.size(); index++) {
            BooleanExpression right = (BooleanExpression) visit(expressions.get(index));

            left = new BooleanOperatorExpression(left, "OR", right);
        }

        return left;
    }

    @Override
    public Node visitBexpr1(TheLangParser.Bexpr1Context ctx) {
        List<TheLangParser.Bexpr2Context> expressions = ctx.bexpr2();

        BooleanExpression left = (BooleanExpression) visit(expressions.get(0));

        for (int index = 1; index < expressions.size(); index++) {
            BooleanExpression right = (BooleanExpression) visit(expressions.get(index));

            left = new BooleanOperatorExpression(left, "AND", right);
        }

        return left;
    }

    @Override
    public Node visitBexpr2(TheLangParser.Bexpr2Context ctx) {
        if (ctx.opr() != null) {
            return new BooleanComparisonExpression((ArithmeticExpression) visit(ctx.aexpr(0)), ctx.opr().getText(), (ArithmeticExpression) visit(ctx.aexpr(1)));
        } else if (ctx.NOT() != null) {
            return new BooleanUnaryOperatorExpression("NOT", (BooleanExpression) visit(ctx.bexpr()));
        } else if (ctx.TRUE() != null) {
            return new BooleanConstantExpression(true);
        } else if (ctx.FALSE() != null) {
            return new BooleanConstantExpression(false);
        }

        return visit(ctx.bexpr());
    }

    @Override
    public Node visitSkipStmt(TheLangParser.SkipStmtContext ctx) {
        return new SkipStatement();
    }

    @Override
    public Node visitReadStmt(TheLangParser.ReadStmtContext ctx) {
        if (ctx.LBRACKET() != null) {
            return new ReadArrayStatement(new ArrayExpression(ctx.IDENTIFIER().toString(), (ArithmeticExpression) visit(ctx.aexpr())));
        } else {
            return new ReadIntStatement(new IntExpression(ctx.IDENTIFIER().toString()));
        }
    }

    @Override
    public Node visitWriteStmt(TheLangParser.WriteStmtContext ctx) {
        return new WriteStatement((ArithmeticExpression) visit(ctx.aexpr()));
    }

    @Override
    public Node visitIfStmt(TheLangParser.IfStmtContext ctx) {
        BooleanExpression condition = (BooleanExpression) visit(ctx.bexpr());
        List<Node> ifNodes = new ArrayList<>();
        List<Node> elseNodes = new ArrayList<>();

        boolean inIfBlock = true;
        for (int a = 0; a < ctx.getChildCount(); a++) {
            if (ctx.children.get(a) instanceof TheLangParser.StmtContext) {
                Node statement = visit(ctx.children.get(a));
                if (inIfBlock) {
                    ifNodes.add(statement);
                } else {
                    elseNodes.add(statement);
                }
            } else if (ctx.children.get(a) == ctx.ELSE()) {
                inIfBlock = false;
            }
        }

        return new IfStatement(condition, ifNodes, elseNodes);
    }

    @Override
    public Node visitWhileStmt(TheLangParser.WhileStmtContext ctx) {
        BooleanExpression condition = (BooleanExpression) visit(ctx.bexpr());

        List<Node> nodes = new ArrayList<>();

        for (TheLangParser.StmtContext stmt : ctx.stmt()) {
            nodes.add(visit(stmt));
        }

        return new WhileStatement(condition, nodes);
    }
}
