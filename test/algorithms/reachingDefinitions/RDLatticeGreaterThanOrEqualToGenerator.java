package algorithms.reachingDefinitions;
import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import java.lang.annotation.Annotation;
import java.util.HashMap;

public class RDLatticeGreaterThanOrEqualToGenerator  extends Generator<RDLattice[]> {

    private int size;
    private RDLatticeGenerator generator;

    public RDLatticeGreaterThanOrEqualToGenerator(){
        super(RDLattice[].class);
        this.generator = new RDLatticeGenerator();
        this.size = 3;
    }

    //TODO this is not working - incorrect version of the QuickCheck library???
    public void configure(LatticeCount latticeCount) {
        this.size = latticeCount.count();
    }

    @Override
    public RDLattice[] generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
        RDLattice[] result = new RDLattice[size];
        this.generator.setPrevious(null);
        for(int lattice = 0; lattice < this.size; lattice++){
            result[lattice] = this.generator.generate(sourceOfRandomness, generationStatus);
            this.generator.setPrevious(result[lattice]);
        }

        return result;
    }
}
