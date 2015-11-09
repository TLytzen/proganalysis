package algorithms.reachingDefinitions;

public class BitVectorSet {

    private int variable;
    private long set;

    public BitVectorSet(int variable, long set){
        this.variable = variable;
        this.set = set;
    }

    public int getVariable() {
        return variable;
    }

    public long getSet() {
        return set;
    }
}
