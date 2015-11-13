package algorithms.reachingDefinitions;


import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.generator.InRange;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import static  org.junit.Assert.*;

@RunWith(Theories.class)
public class BitVectorSetTest {

    @Theory public void SerializationDeserialization(@ForAll @InRange(min="0", max="63") int label){
        BitVectorSet set = new BitVectorSet(0, BitVectorSet.getSetForLabel(label));
        assertEquals("(0,"+label+")", set.toString());
    }

}
