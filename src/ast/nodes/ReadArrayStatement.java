package ast.nodes;


import ast.Node;
import ast.nodes.arithmeticExpressions.ArrayExpression;
import ast.nodes.arithmeticExpressions.IntExpression;

public class ReadArrayStatement extends Node {

    private ArrayExpression arrayExpression;


    public ReadArrayStatement(ArrayExpression arrayExpression) {
        this.arrayExpression = arrayExpression;
        this.addChildNode(arrayExpression);
    }

    public ArrayExpression getArrayExpression() {
        return arrayExpression;
    }

}
