package algorithms.reachingDefinitions;

public class BitVectorSet {


    public static final long QuestionMarkSet = 1;

    public static final long KillVariableSet = Long.MAX_VALUE;

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

    public static long getSetForLabel(int labelNum){
        return 1 << (1 + labelNum);
    }
}
