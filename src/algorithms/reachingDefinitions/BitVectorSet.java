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

    public static String print(long set, String variableName){

        if (set == KillVariableSet)
        {
            return "("+variableName+",[Kill all set])";
        }

        StringBuilder builder = new StringBuilder();
        if ((set & QuestionMarkSet) > 0){
            builder.append("(");
            builder.append(variableName);
            builder.append(",?)");
        }
        int label = 0;
        for (long workingSet = set >> 1; workingSet > 0; workingSet = workingSet >> 1, label++){
            if ((workingSet & 1) > 0){
                if (builder.length() > 0){
                    builder.append(", ");
                }

                builder.append("(");
                builder.append(variableName);
                builder.append(",");
                builder.append(label);
                builder.append(")");
            }
        }

        return builder.toString();
    }

    public static long getSetForLabel(int labelNum){
        return 1 << (1 + labelNum);
    }

    @Override
    public String toString() {


        return BitVectorSet.print(this.set, ""+this.variable);
    }
}
