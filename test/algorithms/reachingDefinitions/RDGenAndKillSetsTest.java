package algorithms.reachingDefinitions;


import algorithms.AstNodeGenerator;
import ast.Node;
import ast.nodes.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import static org.junit.Assert.*;

public class RDGenAndKillSetsTest {

    private RDGenSetVisitor genSetVisitor;
    private RDKillSetVisitor killSetVisitor;
    private HashMap<String, Integer> variables;
    private HashMap<Integer, String> variableMapping = new HashMap<>();

    @Before public void setup(){
        this.genSetVisitor = new RDGenSetVisitor();
        this.killSetVisitor = new RDKillSetVisitor();
        this.variables = AstNodeGenerator.variablesWithEveryElement();

        for (String name : this.variables.keySet()){
            variableMapping.put(this.variables.get(name), name);
        }
    }

    @Test public void testIntDeclaration(){
        // [int x1]^0
        IntDeclaration intDeclaration = AstNodeGenerator.intDeclaration();

        List<BitVectorSet> genSets = this.getGenSetsForNode(intDeclaration);
        List<BitVectorSet> killSets = this.getKillSetsForNode(intDeclaration);

        assertSet(genSets, 0, "(x1,0)");
        assertSet(killSets, 0, "(x1,[Kill all set])");
    }

    @Test public void testArrayDeclaration(){
        // [int A1[4]]^0
        ArrayDeclaration arrayDeclaration = AstNodeGenerator.arrayDeclaration();

        List<BitVectorSet> genSets = this.getGenSetsForNode(arrayDeclaration);
        List<BitVectorSet> killSets = this.getKillSetsForNode(arrayDeclaration);

        assertSet(genSets, 0, "(A1[0],0)");
        assertSet(genSets, 1, "(A1[1],0)");
        assertSet(genSets, 2, "(A1[2],0)");
        assertSet(genSets, 3, "(A1[3],0)");
        assertSet(killSets, 0, "(A1[0],[Kill all set])");
        assertSet(killSets, 1, "(A1[1],[Kill all set])");
        assertSet(killSets, 2, "(A1[2],[Kill all set])");
        assertSet(killSets, 3, "(A1[3],[Kill all set])");
    }

    @Test public void testIntAssignment(){
        // [x1 := 3]^0
        IntAssignment intAssignment = AstNodeGenerator.intAssignment();

        List<BitVectorSet> genSets = this.getGenSetsForNode(intAssignment);
        List<BitVectorSet> killSets = this.getKillSetsForNode(intAssignment);

        assertSet(genSets, 0, "(x1,0)");
        assertSet(killSets, 0, "(x1,[Kill all set])");
    }

    @Test public void testArrayAssignmentConstantIndex(){
        // [int A1[3] := x1]^0
        ArrayAssignment arrayDeclaration = AstNodeGenerator.arrayAssignmentConstantIndex();

        List<BitVectorSet> genSets = this.getGenSetsForNode(arrayDeclaration);
        List<BitVectorSet> killSets = this.getKillSetsForNode(arrayDeclaration);

        assertSet(genSets, 0, "(A1[3],0)");
        assertSet(killSets, 0, "(A1[3],[Kill all set])");
    }

    @Test public void testArrayAssignmentVariableIndex(){
        // [int A1[x1] := x1]^0
        ArrayAssignment arrayDeclaration = AstNodeGenerator.arrayAssignmentVariableIndex();

        List<BitVectorSet> genSets = this.getGenSetsForNode(arrayDeclaration);
        List<BitVectorSet> killSets = this.getKillSetsForNode(arrayDeclaration);

        assertSet(genSets, 0, "(A1[0],0)");
        assertSet(genSets, 1, "(A1[1],0)");
        assertSet(genSets, 2, "(A1[2],0)");
        assertSet(genSets, 3, "(A1[3],0)");
        assertNull(killSets);
    }

    @Test public void testReadIntStatement(){
        // [read x1]^0
        ReadIntStatement readIntStatement = AstNodeGenerator.readIntStatement();

        List<BitVectorSet> genSets = this.getGenSetsForNode(readIntStatement);
        List<BitVectorSet> killSets = this.getKillSetsForNode(readIntStatement);

        assertSet(genSets, 0, "(x1,0)");
        assertSet(killSets, 0, "(x1,[Kill all set])");
    }

    @Test public void testReadArrayStatementConstant(){
        // [read A[3]]^0
        ReadArrayStatement readArrayStatement = AstNodeGenerator.readArrayStatementConstant();

        List<BitVectorSet> genSets = this.getGenSetsForNode(readArrayStatement);
        List<BitVectorSet> killSets = this.getKillSetsForNode(readArrayStatement);

        assertSet(genSets, 0, "(A1[3],0)");
        assertSet(killSets, 0, "(A1[3],[Kill all set])");
    }

    @Test public void testReadArrayStatementVariable(){
        // [read A[x1]]^0
        ReadArrayStatement readArrayStatement = AstNodeGenerator.readArrayStatementVariable();

        List<BitVectorSet> genSets = this.getGenSetsForNode(readArrayStatement);
        List<BitVectorSet> killSets = this.getKillSetsForNode(readArrayStatement);

        assertSet(genSets, 0, "(A1[0],0)");
        assertSet(genSets, 1, "(A1[1],0)");
        assertSet(genSets, 2, "(A1[2],0)");
        assertSet(genSets, 3, "(A1[3],0)");
        assertNull(killSets);
    }

    @Test public void testSkipStatement(){
        // [skip]^0
        SkipStatement skipStatement = AstNodeGenerator.skipStatement();

        List<BitVectorSet> genSets = this.getGenSetsForNode(skipStatement);
        List<BitVectorSet> killSets = this.getKillSetsForNode(skipStatement);

        assertNull(genSets);
        assertNull(killSets);
    }

    @Test public void testWriteStatement(){
        // [skip]^0
        WriteStatement writeStatement = AstNodeGenerator.writeStatementConstant();

        List<BitVectorSet> genSets = this.getGenSetsForNode(writeStatement);
        List<BitVectorSet> killSets = this.getKillSetsForNode(writeStatement);

        assertNull(genSets);
        assertNull(killSets);
    }

    /*
    * Helper functions
    * */

    private List<BitVectorSet> getGenSetsForNode(Node node){
        return genSetVisitor.visitNode(node, this.variables);
    }

    private List<BitVectorSet> getKillSetsForNode(Node node){
        return killSetVisitor.visitNode(node, this.variables);
    }

    private void assertSet(List<BitVectorSet> sets, int index, String value){
        assertTrue(sets.size() > index);

        BitVectorSet set = sets.get(index);
        String printedSet = BitVectorSet.print(set.getSet(), this.variableMapping.get(set.getVariable()));
        assertEquals(value, printedSet);
    }
}
