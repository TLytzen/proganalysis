package algorithms.detectionOfSigns.stateSpaceUpdates;

import algorithms.detectionOfSigns.BooleanSet;
import algorithms.detectionOfSigns.DSLattice;
import algorithms.detectionOfSigns.SignSet;
import ast.Visitor;
import ast.nodes.arithmeticExpressions.ArithmeticUnaryOperatorExpression;
import ast.nodes.booleanExpressions.BooleanComparisonExpression;
import ast.nodes.booleanExpressions.BooleanConstantExpression;
import ast.nodes.booleanExpressions.BooleanOperatorExpression;
import ast.nodes.booleanExpressions.BooleanUnaryOperatorExpression;


public class SignsOfBooleanExpressions extends Visitor<BooleanSet, DSLattice> {

    private SignsOfArithmeticExpressions signsOfArithmeticExpressions;

    public SignsOfBooleanExpressions(SignsOfArithmeticExpressions signsOfArithmeticExpressions) {
        this.signsOfArithmeticExpressions = signsOfArithmeticExpressions;
    }

    @Override
    public BooleanSet visitBooleanComparisonExpression(BooleanComparisonExpression booleanComparisonExpression, DSLattice data) {

        SignSet leftSet = this.signsOfArithmeticExpressions.visitNode(booleanComparisonExpression.getLeft(), data);
        SignSet rightSet = this.signsOfArithmeticExpressions.visitNode(booleanComparisonExpression.getRight(), data);

        BooleanSet[][] partialResult;


        SignSet temp;
        switch (booleanComparisonExpression.getOperator()) {
            case ">":
                // Swap the two sets to use the same definition as "<"
                temp = leftSet;
                leftSet = rightSet;
                rightSet = temp;

            case "<":
                partialResult = new BooleanSet[][]{{BooleanSet.getTop(), BooleanSet.getTrue(), BooleanSet.getTrue()},
                        {BooleanSet.getFalse(), BooleanSet.getFalse(), BooleanSet.getTrue()},
                        {BooleanSet.getFalse(), BooleanSet.getFalse(), BooleanSet.getTop()}};

                break;

            case ">=":
                // Swap the two sets to use the same definition as "<="
                temp = leftSet;
                leftSet = rightSet;
                rightSet = temp;

            case "<=":
                partialResult = new BooleanSet[][]{{BooleanSet.getTop(), BooleanSet.getTrue(), BooleanSet.getTrue()},
                        {BooleanSet.getFalse(), BooleanSet.getTrue(), BooleanSet.getTrue()},
                        {BooleanSet.getFalse(), BooleanSet.getFalse(), BooleanSet.getTop()}};
                break;

            case "==":
                partialResult = new BooleanSet[][]{{BooleanSet.getTop(), BooleanSet.getFalse(), BooleanSet.getFalse()},
                        {BooleanSet.getFalse(), BooleanSet.getTrue(), BooleanSet.getFalse()},
                        {BooleanSet.getFalse(), BooleanSet.getFalse(), BooleanSet.getTop()}};
                break;

            case "!=":
                partialResult = new BooleanSet[][]{{BooleanSet.getTop(), BooleanSet.getTrue(), BooleanSet.getTrue()},
                        {BooleanSet.getTrue(), BooleanSet.getFalse(), BooleanSet.getTrue()},
                        {BooleanSet.getTrue(), BooleanSet.getTrue(), BooleanSet.getTop()}};
                break;

            default:
                throw new IllegalArgumentException("Unknown comparison operator");
        }

        return SignSet.operator(leftSet, rightSet, partialResult, BooleanSet.getEmpty());
    }

    @Override
    public BooleanSet visitBooleanOperatorExpression(BooleanOperatorExpression booleanOperatorExpression, DSLattice data) {

        BooleanSet leftSet = this.visitNode(booleanOperatorExpression.getLeft(), data);
        BooleanSet rightSet = this.visitNode(booleanOperatorExpression.getRight(), data);

        BooleanSet[][] partialResult;

        SignSet temp;
        switch (booleanOperatorExpression.getOperator()) {
            case "AND":
                partialResult = new BooleanSet[][]{{BooleanSet.getTrue(), BooleanSet.getFalse()},
                        {BooleanSet.getFalse(), BooleanSet.getFalse()}};
                break;

            case "OR":
                partialResult = new BooleanSet[][]{{BooleanSet.getTrue(), BooleanSet.getTrue()},
                        {BooleanSet.getTrue(), BooleanSet.getFalse()}};

                break;

            default:
                throw new IllegalArgumentException("Unknown boolean operator");
        }

        return BooleanSet.operator(leftSet, rightSet, partialResult, BooleanSet.getEmpty());
    }

    @Override
    public BooleanSet visitBooleanConstantExpression(BooleanConstantExpression booleanConstantExpression, DSLattice data) {
        if (booleanConstantExpression.getValue()) {
            return BooleanSet.getTrue();
        } else {
            return BooleanSet.getFalse();
        }
    }

    @Override
    public BooleanSet visitBooleanUnaryOperatorExpression(BooleanUnaryOperatorExpression booleanOperatorExpression, DSLattice data) {
        if (booleanOperatorExpression.getOperator() == "NOT") {
            return this.visitNode(booleanOperatorExpression.getExpression(), data).negate();
        }

        throw new IllegalArgumentException("Unknown unary boolean operator: " + booleanOperatorExpression.getOperator());
    }
}
