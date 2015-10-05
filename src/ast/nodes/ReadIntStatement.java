package ast.nodes;


import ast.Node;
import ast.nodes.arithmeticExpressions.ArrayExpression;
import ast.nodes.arithmeticExpressions.IntExpression;

public class ReadIntStatement extends Node{

    private IntExpression intExpression;

    public ReadIntStatement(IntExpression intExpression) {
        this.intExpression = intExpression;
        this.addChildNode(intExpression);
    }


    public IntExpression getIntExpression() {
        return intExpression;
    }
}
