package algorithms.detectionOfSigns;

import algorithms.CompleteLattice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DSLattice implements CompleteLattice<DSLattice> {
    private SignSet[] variables;


    public DSLattice(HashMap<String, Integer> variableNames) {
        this.variables = new SignSet[variableNames.size()];
        for (String variableName : variableNames.keySet()) {
            int index = variableNames.get(variableName);
            this.variables[index] = SignSet.getEmpty(variableName, index);
        }
    }

    public DSLattice(DSLattice baseLattice) {
        this.variables = new SignSet[baseLattice.variables.length];

        for (int variable = 0; variable < this.variables.length; variable++) {
            this.variables[variable] = baseLattice.variables[variable];
        }
    }

    private DSLattice(SignSet[] variables) {
        this.variables = variables;
    }


    public SignSet getVariableSet(int variable){
        return this.variables[variable];
    }

    public DSLattice setVariableSet(SignSet set){
        DSLattice result = new DSLattice(this);
        result.variables[set.getVariable()] = set;
        return result;
    }

    @Override
    public boolean leq(DSLattice lattice) {
        for (int variable = 0; variable < this.variables.length; variable++) {
            if (!this.variables[variable].isSubsetOf(lattice.variables[variable])) {
                return false;
            }
        }

        return true;
    }

    @Override
    public DSLattice join(DSLattice lattice) {
        SignSet[] variables = new SignSet[this.variables.length];

        for (int a = 0; a < this.variables.length; a++) {
            variables[a] = this.variables[a].union(lattice.variables[a]);
        }

        return new DSLattice(variables);
    }

    @Override
    public DSLattice bottom() {
        SignSet[] variables = new SignSet[this.variables.length];

        for (int a = 0; a < this.variables.length; a++) {
            variables[a] = SignSet.getEmpty(this.variables[a].getVariableName(), this.variables[a].getVariable());
        }

        return new DSLattice(variables);
    }

    public List<DSLattice> atoms(){
        List<DSLattice> atoms = new ArrayList<>();

        SignSet[][] atomSets = buildAtoms(0);
        for (int index = 0; index < atomSets.length; index++){
            atoms.add(new DSLattice(atomSets[index]));
        }

        return atoms;
    }

    private SignSet[][] buildAtoms(int variable){
        if (variable >= this.variables.length){
            SignSet[][] emptySets = new SignSet[1][this.variables.length];
            for (int variableIndex = 0; variableIndex < this.variables.length; variableIndex++){
                emptySets[0][variableIndex] = SignSet.getEmpty();
            }

            return emptySets;
        }

        SignSet[][] childAtoms = this.buildAtoms(variable + 1);
        List<SignSet> setValues = this.variables[variable].atomicValues();
        if (setValues.isEmpty()){
            return childAtoms;
        }
        else {
            SignSet[][] atoms =  new SignSet[childAtoms.length * setValues.size()][this.variables.length];
            int start = 0;
            for (SignSet setValue : setValues) {
                for (int index = 0; index < childAtoms.length; index++){
                    for (int variableIndex = 0; variableIndex < childAtoms[index].length; variableIndex++) {

                        if (variableIndex == variable) {
                            atoms[start + index][variableIndex] = setValue;
                        }
                        else{
                            atoms[start + index][variableIndex] = childAtoms[index][variableIndex];
                        }
                    }
                }

                start += childAtoms.length;
            }
            return atoms;
        }
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
        DSLattice other;
        if (!(obj instanceof DSLattice)){
            return false;
        }
        other = (DSLattice)obj;

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
