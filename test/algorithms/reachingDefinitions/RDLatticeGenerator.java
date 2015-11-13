package algorithms.reachingDefinitions;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import java.util.HashMap;


public class RDLatticeGenerator extends Generator<RDLattice> {

    private RDLattice previous;

    public RDLatticeGenerator()
    {
        super(RDLattice.class);
    }


    public void setPrevious(RDLattice previous) {
        this.previous = previous;
    }

    @Override
    public RDLattice generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
        final int LABEL_COUNT = 10;
        HashMap<String, Integer> variables = new HashMap<>();
        variables.put("X1", 0);
        variables.put("X2", 1);
        variables.put("X3", 2);

        RDLattice lattice = previous == null ? new RDLattice(variables) : new RDLattice(previous);

        for(String variableName : variables.keySet()) {
            int variable = variables.get(variableName);
            int numberOfLabels = sourceOfRandomness.nextInt(3,6);
            for (int label = 0; label < numberOfLabels; label++) {
                lattice.addSet(BitVectorSet.getSetForLabel(variableName, variable, sourceOfRandomness.nextInt(0, LABEL_COUNT - 1)));
            }
        }

        return lattice;
    }
}
