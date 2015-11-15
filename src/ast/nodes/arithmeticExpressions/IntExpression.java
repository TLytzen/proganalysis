package ast.nodes.arithmeticExpressions;

import ast.Visitor;
import ast.nodes.ArithmeticExpression;

/**
 * Created by rasmu_000 on 2015-10-04.
 */
public class IntExpression extends ArithmeticExpression {

    private String identifier;

    public IntExpression(String identifier)
    {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String toString(){
        return this.identifier;
    }

    @Override
    public <T, S> T accept(Visitor<T, S> visitor, S data) {
        return visitor.visitIntExpression(this, data);
    }
}
