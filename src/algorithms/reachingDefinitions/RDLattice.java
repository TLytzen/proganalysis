package algorithms.reachingDefinitions;

import algorithms.CompleteLattice;

public class RDLattice implements CompleteLattice<RDLattice> {

    private long[] variables;

    public RDLattice(int numberOfVariables)
    {
        this.variables = new long[numberOfVariables];
    }

    public RDLattice(RDLattice baseLattice)
    {
        this.variables = new long[baseLattice.variables.length];
        for (int variable = 0; variable < this.variables.length; variable++){
            this.variables[variable] = baseLattice.variables[variable];
        }
    }

    @Override
    public boolean leq(RDLattice lattice) {
        for (int a = 0; a < this.variables.length; a++){
            if (!isSubset(this.variables[a], lattice.variables[a])){
                return false;
            }
        }

        return true;
    }

    @Override
    public RDLattice join(RDLattice lattice) {
        RDLattice result = new RDLattice(this.variables.length);

        for (int a = 0; a < this.variables.length; a++){
            result.variables[a] = union(this.variables[a], lattice.variables[a]);
        }

        return result;
    }

    public void removeSet(BitVectorSet set)
    {
        this.variables[set.getVariable()] = setMinus(this.variables[set.getVariable()], set.getSet());
    }

    public void addSet(BitVectorSet set)
    {
        this.variables[set.getVariable()] = union(this.variables[set.getVariable()], set.getSet());
    }

    @Override
    public RDLattice bottom() {
        return new RDLattice(this.variables.length);
    }

    /*
        * Returns a value indicating whether s1 is a subset of s2
        * */
    private boolean isSubset(long s1, long s2)
    {
        return (s1 & (~s2)) == 0;
    }

    private long union(long s1, long s2){
        return s1 | s2;
    }

    private long setMinus(long s1, long s2)
    {
        return s1 & (~s2);
    }
}
