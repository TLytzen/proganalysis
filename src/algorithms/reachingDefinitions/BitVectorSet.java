package algorithms.reachingDefinitions;

import java.util.HashMap;
import java.util.Objects;

public class BitVectorSet {


    private static final long QuestionMarkSet = 1;

    private static final long KillVariableSet = Long.MAX_VALUE;

    private int variable;
    private long set;
    private String variableName;

    private BitVectorSet(String variableName, int variable, long set) {
        this.variableName = variableName;
        this.variable = variable;
        this.set = set;
    }

    public int getVariable() {
        return variable;
    }

    public long getSet() {
        return set;
    }

    public String getVariableName() {
        return variableName;
    }

    /**
     * Returns a value indicating whether the given @see BitVectorSet is a subset of this one
     *
     * @param other The @see BitVectorSet to check
     * @return a value indicating whether the given @see BitVectorSet is a subset of this one
     */
    public boolean isSubsetOf(BitVectorSet other) {
        if (this.variable != other.variable) {
            throw new IllegalArgumentException("BitVectorSet is for a different variable");
        }

        return (this.set & (~other.set)) == 0;
    }

    /**
     * Returns the union of this a given @see BitVectorSet
     *
     * @param other The @see BitVectorSet to join with
     * @return the union of the two @see BitVectorSets
     */
    public BitVectorSet union(BitVectorSet other) {
        if (this.variable != other.variable) {
            throw new IllegalArgumentException("BitVectorSet is for a different variable");
        }

        return new BitVectorSet(this.variableName, this.variable, this.set | other.set);
    }

    /**
     * Returns the result of subtracting the given set from this one (the set difference)
     *
     * @param other The @see BitVectorSet to remove from this one
     * @return the resulting BitVector set
     */
    public BitVectorSet setMinus(BitVectorSet other) {
        return new BitVectorSet(this.variableName, this.variable, this.set & (~other.set));
    }

    public static BitVectorSet generateKillVariableSet(String variableName, int variable) {
        return new BitVectorSet(variableName, variable, KillVariableSet);
    }

    public static BitVectorSet generateQuestionMarkSet(String variableName, int variable) {
        return new BitVectorSet(variableName, variable, QuestionMarkSet);
    }

    public static BitVectorSet getSetForLabel(String variableName, int variable, int labelNum) {
        return new BitVectorSet(variableName, variable, 1L << (1L + labelNum));
    }

    public static BitVectorSet getEmptySet(String variableName, int variable) {
        return new BitVectorSet(variableName, variable, 0L);
    }

    public static BitVectorSet generateKillVariableSet(String variableName, HashMap<String, Integer> variables) {
        return generateKillVariableSet(variableName, variables.get(variableName));
    }

    public static BitVectorSet generateQuestionMarkSet(String variableName, HashMap<String, Integer> variables) {
        return generateQuestionMarkSet(variableName, variables.get(variableName));
    }

    public static BitVectorSet getSetForLabel(String variableName, HashMap<String, Integer> variables, int labelNum) {
        return getSetForLabel(variableName, variables.get(variableName), labelNum);
    }

    @Override
    public String toString() {
        if (this.set == KillVariableSet) {
            return "(" + variableName + ",[Kill all set])";
        }

        StringBuilder builder = new StringBuilder();
        if ((set & QuestionMarkSet) > 0) {
            builder.append("(");
            builder.append(variableName);
            builder.append(",?)");
        }
        int label = 0;
        for (long workingSet = set >> 1; workingSet > 0; workingSet = workingSet >> 1, label++) {
            if ((workingSet & 1) > 0) {
                if (builder.length() > 0) {
                    builder.append(", ");
                }

                builder.append("(");
                builder.append(this.variableName);
                builder.append(",");
                builder.append(label);
                builder.append(")");
            }
        }

        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.variableName, this.variable, this.set);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BitVectorSet)) {
            return false;
        }

        BitVectorSet other = (BitVectorSet)obj;

        return this.variableName.equals(other.variableName) && this.variable == other.variable && this.set == other.set;
    }
}
