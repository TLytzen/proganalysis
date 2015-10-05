package ast.nodes;

import ast.Node;

public class WriteStatement extends Node {

    private ArithmeticExpression arithmeticExpression;

    public WriteStatement(ArithmeticExpression arithmeticExpression) {
        this.arithmeticExpression = arithmeticExpression;
        this.addChildNode(arithmeticExpression);
    }

    public ArithmeticExpression getArithmeticExpression() {
        return arithmeticExpression;
    }
}
