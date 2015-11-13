package algorithms;


import ast.nodes.*;
import ast.nodes.arithmeticExpressions.ArithmeticConstantExpression;
import ast.nodes.arithmeticExpressions.ArrayExpression;
import ast.nodes.arithmeticExpressions.IntExpression;

import java.util.HashMap;

public class AstNodeGenerator {

    public static IntExpression intExpression(){
        return new IntExpression("x1");
    }

    public static ArrayExpression arrayExpressionConstant(){
        return new ArrayExpression("A1", arithmeticConstantExpression());
    }

    public static ArrayExpression arrayExpressionVariable(){
        return new ArrayExpression("A1", intExpression());
    }

    public static ArithmeticConstantExpression arithmeticConstantExpression(){
        return new ArithmeticConstantExpression(3);
    }

    public static IntDeclaration intDeclaration(){
        return new IntDeclaration("x1");
    }

    public static ArrayDeclaration arrayDeclaration(){
        return new ArrayDeclaration("A1", arithmeticConstantExpression().getValue() + 1);
    }

    public static IntAssignment intAssignment(){
        return new IntAssignment("x1", arithmeticConstantExpression());
    }

    public static ArrayAssignment arrayAssignmentConstantIndex(){
        return new ArrayAssignment("A1", arithmeticConstantExpression(), intExpression());
    }

    public static ArrayAssignment arrayAssignmentVariableIndex(){
        return new ArrayAssignment("A1", intExpression(), new ArithmeticConstantExpression(42));
    }

    public static ReadIntStatement readIntStatement(){
        return new ReadIntStatement(intExpression());
    }

    public static ReadArrayStatement readArrayStatementConstant(){
        return new ReadArrayStatement(arrayExpressionConstant());
    }

    public static ReadArrayStatement readArrayStatementVariable(){
        return new ReadArrayStatement(arrayExpressionVariable());
    }

    public static SkipStatement skipStatement(){
        return new SkipStatement();
    }

    public static  WriteStatement writeStatementConstant(){
        return new WriteStatement(arithmeticConstantExpression());
    }

    public static  WriteStatement writeStatementVariable(){
        return new WriteStatement(intExpression());
    }

    // TODO: boolean expressions

    public static HashMap<String, Integer> variablesWithEveryElement(){
        HashMap<String, Integer> variables = new HashMap<>();

        variables.put(intExpression().getIdentifier(), 0);
        ArrayDeclaration declaration = arrayDeclaration();
        for (int index = 0; index < declaration.getLength(); index++){
            variables.put(ArrayDeclaration.getElementIdentifier(declaration.getIdentifier(), index), index + 1);
        }

        return variables;
    }

}
