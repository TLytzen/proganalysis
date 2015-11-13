package algorithms.reachingDefinitions;

import algorithms.CompleteLattice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class RDLattice implements CompleteLattice<RDLattice> {

    private BitVectorSet[] variables;

    public RDLattice( HashMap<String, Integer> variableNames)
    {
        this.variables = new BitVectorSet[variableNames.size()];
        for(String variableName : variableNames.keySet()){
            int index = variableNames.get(variableName);
            this.variables[index] = BitVectorSet.getEmptySet(variableName, index);
        }
    }

    public RDLattice(RDLattice baseLattice)
    {
        this.variables = new BitVectorSet[baseLattice.variables.length];

        for (int variable = 0; variable < this.variables.length; variable++){
            this.variables[variable] = baseLattice.variables[variable];
        }
    }

    private RDLattice(BitVectorSet[] variables){
        this.variables = variables;
    }

    @Override
    public boolean leq(RDLattice lattice) {
        for (int a = 0; a < this.variables.length; a++){
            if (!this.variables[a].isSubsetOf(lattice.variables[a])){
                return false;
            }
        }

        return true;
    }

    @Override
    public RDLattice join(RDLattice lattice) {
        BitVectorSet[] variables = new BitVectorSet[this.variables.length];

        for (int a = 0; a < this.variables.length; a++){
            variables[a] = this.variables[a].union(lattice.variables[a]);
        }

        return new RDLattice(variables);
    }

    public void removeSet(BitVectorSet set)
    {
        this.variables[set.getVariable()] = this.variables[set.getVariable()].setMinus(set);
    }

    public void addSet(BitVectorSet set)
    {
        this.variables[set.getVariable()] = this.variables[set.getVariable()].union(set);
    }

    @Override
    public RDLattice bottom() {
        BitVectorSet[] variables = new BitVectorSet[this.variables.length];

        for (int a = 0; a < this.variables.length; a++){
            variables[a] = BitVectorSet.getEmptySet(this.variables[a].getVariableName(), this.variables[a].getVariable());
        }

        return new RDLattice(variables);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('{');
        for (int a = 0; a < this.variables.length; a++){
            if (builder.length() > 1){
                builder.append(", ");
            }

            builder.append(this.variables[a]);
        }

        builder.append('}');
        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        RDLattice other;
        if (!(obj instanceof RDLattice)){
            return false;
        }
        other = (RDLattice)obj;

        for (int variable = 0; variable < this.variables.length; variable++){
            if (!(this.variables[variable].equals(other.variables[variable]))){
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.variables);
    }


}
