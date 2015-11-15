package algorithms.detectionOfSigns;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import static org.junit.Assert.*;

public class DSLatticeTest {

    /*
    * Test that every combination is created in the atom set
    * */
    @Test public void testSimpleAtoms(){
        HashMap<String, Integer> variables = new HashMap<>();
        variables.put("X1", 0);
        variables.put("X2", 1);
        variables.put("X3", 2);

        DSLattice lattice = new DSLattice(variables);

        for (String key : variables.keySet()) {
            lattice = lattice.setVariableSet(SignSet.getTop(key, variables.get(key)));
        }

        List<DSLattice> atoms = lattice.atoms();

        assertEquals(27, atoms.size());
        for (DSLattice atom : atoms){
            for (int variable = 0; variable < variables.size(); variable++){
                assertEquals(1, atom.getVariableSet(variable).atomicValues().size());
            }
        }
    }

    /*
    * Test that the array "rest" elements are not split into atoms
    * */
    @Test public void testArrayAtoms(){
        HashMap<String, Integer> variables = new HashMap<>();
        variables.put("A[0]", 0);
        variables.put("A[rest]", 1);

        DSLattice lattice = new DSLattice(variables);

        for (String key : variables.keySet()) {
            lattice = lattice.setVariableSet(SignSet.getTop(key, variables.get(key)));
        }

        List<DSLattice> atoms = lattice.atoms();

        assertEquals(3, atoms.size());
        for (DSLattice atom : atoms){
            assertEquals(1, atom.getVariableSet(0).atomicValues().size());
            assertTrue(atom.getVariableSet(1).equals(SignSet.getTop("A[rest]", 1)));
        }
    }
}
