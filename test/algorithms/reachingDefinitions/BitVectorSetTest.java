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

    @Theory public void SerializationDeserialization(@ForAll @InRange(min="0", max="61") int label){
        BitVectorSet set = BitVectorSet.getSetForLabel("XYZ", 0, label);
        assertEquals("(XYZ,"+label+")", set.toString());
    }

}
