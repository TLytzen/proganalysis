package algorithms.detectionOfSigns;

import ast.nodes.ArrayDeclaration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SignSet implements Set<SignSet>{

    private boolean minus, zero, plus;

    private int variable;
    private String variableName;


    private SignSet(String variableName, int variable, boolean minus, boolean zero, boolean plus){
        this.variableName = variableName;
        this.variable = variable;
        this.minus = minus;
        this.zero = zero;
        this.plus = plus;
    }

    public String getVariableName() {
        return variableName;
    }

    public int getVariable() {
        return variable;
    }

    public boolean containsMinus() {
        return minus;
    }

    public boolean containsPlus() {
        return plus;
    }

    public boolean containsZero() {
        return zero;
    }

    public static SignSet getEmpty(String variableName, int variable)
    {
        return new SignSet(variableName, variable, false, false, false);
    }

    public static SignSet getMinus(String variableName, int variable)
    {
        return new SignSet(variableName, variable, true, false, false);
    }

    public static SignSet getZero(String variableName, int variable)
    {
        return new SignSet(variableName, variable, false, true, false);
    }

    public static SignSet getPlus(String variableName, int variable)
    {
        return new SignSet(variableName, variable, false, false, true);
    }

    public static SignSet getTop(String variableName, int variable)
    {
        return new SignSet(variableName, variable, true, true, true);
    }

    public static SignSet getCopy(String variableName, int variable, SignSet signSet)
    {
        return new SignSet(variableName, variable, signSet.minus, signSet.zero, signSet.plus);
    }

    public static SignSet getEmpty()
    {
        return new SignSet(null, Integer.MAX_VALUE, false, false, false);
    }

    public static SignSet getMinus()
    {
        return new SignSet(null, Integer.MAX_VALUE, true, false, false);
    }

    public static SignSet getZero()
    {
        return new SignSet(null, Integer.MAX_VALUE, false, true, false);
    }

    public static SignSet getPlus()
    {
        return new SignSet(null, Integer.MAX_VALUE, false, false, true);
    }

    public static SignSet getTop()
    {
        return new SignSet(null, Integer.MAX_VALUE, true, true, true);
    }

    public boolean isSubsetOf(SignSet other) {
        if (this.variable != other.variable && other.variableName != null) {
            throw new IllegalArgumentException("SignSet is for a different variable");
        }

        return (other.minus || !this.minus) && (other.zero || !this.zero) && (other.plus || !this.plus);
    }

    /**
     * Returns the union of this a given @see SignSet
     *
     * @param other The @see SignSet to join with
     * @return the union of the two @see SignSet
     */
    public SignSet union(SignSet other) {
        if (this.variable != other.variable && this.variableName != null && other.variableName != null) {
            throw new IllegalArgumentException("SignSet is for a different variable");
        }

        return new SignSet(this.variableName, this.variable, this.minus || other.minus, this.zero || other.zero, this.plus || other.plus);
    }

    public static <T extends Set> T operator(SignSet left, SignSet right,  T[][] partialResults, Set<T> emptySet){
        Set<T> result = emptySet;
        boolean[] leftInput = new boolean[]{ left.minus, left.zero, left.plus };
        boolean[] rightInput = new boolean[]{ right.minus, right.zero, right.plus };

        for (int leftIndex = 0; leftIndex < leftInput.length; leftIndex++){
            for (int rightIndex = 0; rightIndex < rightInput.length; rightIndex++){
                if (leftInput[leftIndex] && rightInput[rightIndex]) {
                    T partialResult = partialResults[leftIndex][rightIndex];
                    result = result.union(partialResult);
                }
            }
        }

        return (T)result;
    }

    public List<SignSet> atomicValues(){
        if (ArrayDeclaration.isRestElement(this.variableName)){
            return Collections.singletonList(this);
        }

        List<SignSet> sets = new ArrayList<>();
        if (this.minus){
            sets.add(SignSet.getMinus());
        }

        if (this.zero){
            sets.add(SignSet.getZero());
        }

        if (this.plus){
            sets.add(SignSet.getPlus());
        }

        return sets;
    }

    @Override
    public int hashCode() {
       return Objects.hash(variableName, variable, this.minus, this.zero, this.plus);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SignSet)){
            return false;
        }

        SignSet other = (SignSet)obj;
        return this.variable == other.variable && this.variableName.equals(other.variableName) && this.minus == other.minus && this.zero == other.zero && this.plus == other.plus;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();


        builder.append(this.variableName);
        builder.append("|-> {");
        boolean addSpacer = false;
        if (this.minus) {
            builder.append("-");
            addSpacer = true;
        }

        if (this.zero) {
            if (addSpacer){
                builder.append(',');
            }

            builder.append("0");
            addSpacer = true;
        }

        if (this.plus) {
            if (addSpacer){
                builder.append(',');
            }

            builder.append("+");
        }

        builder.append("}");


        return builder.toString();
    }
}
