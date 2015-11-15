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

    @Theory public void Union(@ForAll @InRange(min="0", max="61") int label1, @ForAll @InRange(min="0", max="61") int label2){
        BitVectorSet set1 = BitVectorSet.getSetForLabel("XYZ", 0, label1);
        BitVectorSet set2 = BitVectorSet.getSetForLabel("XYZ", 0, label2);

        BitVectorSet unionSet = set1.union(set2);

        assertTrue(set1.isSubsetOf(unionSet));
        assertTrue(set2.isSubsetOf(unionSet));

        if (label1 < label2) {
            assertEquals("(XYZ," + label1 + "), (XYZ," + label2 + ")", set1.union(set2).toString());
        }
        else if (label1 > label2){
            assertEquals("(XYZ," + label2 + "), (XYZ," + label1 + ")", set1.union(set2).toString());
        }
        else{
            assertEquals("(XYZ," + label1 + ")", set1.union(set2).toString());
        }
    }
}
