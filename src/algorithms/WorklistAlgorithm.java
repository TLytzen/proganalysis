package algorithms;


import java.util.ArrayList;
import java.util.List;

public class WorklistAlgorithm {

    public static CompleteLattice[] solve(List<Constraint> equations, int numberOfEquationVariables, Worklist worklistType, CompleteLattice latticeType){
        CompleteLattice[] analysis = new CompleteLattice[numberOfEquationVariables];
        List<Constraint>[] infl = new List[numberOfEquationVariables];

        Worklist worklist = worklistType.getEmpty();
        CompleteLattice bottom = latticeType.bottom();
        for (Constraint e : equations){
            worklist.insert(e);
            analysis[e.leftHandSideVariable()] = bottom;
            infl[e.leftHandSideVariable()] = new ArrayList<>();
        }

        for (Constraint e : equations) {
            List<Integer> influences = e.rightHandSideVariables();
            for (int xPrime : influences){
                infl[xPrime].add(e);
            }
        }

        while (!worklist.isEmpty()){
            Constraint equation = worklist.extract();
            CompleteLattice newLattice = equation.evaluate(analysis);

            if (!newLattice.leq(analysis[equation.leftHandSideVariable()])){
                analysis[equation.leftHandSideVariable()] = analysis[equation.leftHandSideVariable()].join(newLattice);
                for (Constraint e : infl[equation.leftHandSideVariable()]){
                    worklist.insert(e);
                }
            }
        }

        return analysis;
    }
}
