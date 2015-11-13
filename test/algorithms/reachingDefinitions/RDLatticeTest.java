package algorithms.reachingDefinitions;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.generator.InRange;
import org.junit.contrib.theories.*;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.Assume.*;

@RunWith(Theories.class)
public class RDLatticeTest {


    @Theory public void testReflexivity(@ForAll @From(RDLatticeGenerator.class) RDLattice lattice)
    {
        assertTrue(lattice.leq(lattice));
    }

    @Theory public void testTransitivity(@ForAll   @LatticeCount(count=3)  RDLattice[] lattices)
    {
        RDLattice a = lattices[0];
        RDLattice b = lattices[1];
        RDLattice c = lattices[2];

        assumeThat(a.leq(b),is(true));
        assumeThat(b.leq(c),is(true));
        assertTrue(a.leq(b));
    }


    @Theory public void testStrictness(@ForAll @From(RDLatticeGenerator.class) RDLattice lattice) {
            //TODO
    }

    @Theory public void testInvariance(@ForAll  @LatticeCount(count=2)  RDLattice[] lattices) {
        RDLattice s = lattices[0];
        RDLattice sPrime = lattices[1];
        RDLattice sDoublePrime = new RDLattice(sPrime);

        assertTrue(sPrime.equals(sDoublePrime));
        assertTrue((s.join(sPrime)).equals(s.join(sDoublePrime)));
    }
}
