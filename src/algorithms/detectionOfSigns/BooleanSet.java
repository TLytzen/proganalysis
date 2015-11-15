package algorithms.detectionOfSigns;


public class BooleanSet implements Set<BooleanSet> {

    private boolean hasFalse, hasTrue;


    private BooleanSet(boolean hasFalse, boolean hasTrue){

        this.hasFalse = hasFalse;
        this.hasTrue = hasTrue;
    }

    public static BooleanSet getFalse(){
        return new BooleanSet(true, false);
    }

    public static BooleanSet getTrue(){
        return new BooleanSet(false, true);
    }

    public static BooleanSet getTop(){
        return new BooleanSet(true, true);
    }

    public static BooleanSet getEmpty(){
        return new BooleanSet(false, false);
    }

    /**
     * Returns the union of this a given @see BooleanSet
     *
     * @param other The @see BooleanSet to join with
     * @return the union of the two @see BooleanSet
     */
    public BooleanSet union(BooleanSet other) {

        return new BooleanSet(this.hasFalse || other.hasFalse, this.hasTrue || other.hasTrue);
    }


    public BooleanSet negate(){
        return new BooleanSet(this.hasTrue, this.hasFalse);
    }

    public boolean containsValue(Boolean isTrueBranch) {
        return (isTrueBranch && this.hasTrue) || (!isTrueBranch && this.hasFalse);
    }

    public static <T extends Set> T operator(BooleanSet left, BooleanSet right,  T[][] partialResults, Set<T> emptySet){
        Set<T> result = emptySet;
        boolean[] leftInput = new boolean[]{ left.hasTrue, left.hasFalse};
        boolean[] rightInput = new boolean[]{ right.hasTrue, right.hasFalse };

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


}
