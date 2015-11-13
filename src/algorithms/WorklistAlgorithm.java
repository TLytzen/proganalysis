package algorithms;


import java.util.ArrayList;
import java.util.List;

public class WorklistAlgorithm {

    public static CompleteLattice[] solve(List<Equation> equations, int numberOfEquationVariables, Worklist worklistType, CompleteLattice latticeType){
        CompleteLattice[] analysis = new CompleteLattice[numberOfEquationVariables];
        List<Equation>[] infl = new List[numberOfEquationVariables];

        Worklist worklist = worklistType.getEmpty();
        CompleteLattice bottom = latticeType.bottom();
        for (Equation e : equations){
            worklist.insert(e);
            analysis[e.getIndex()] = bottom;
            infl[e.getIndex()] = new ArrayList<>();
        }

        for (Equation e : equations) {
            List<Integer> influences = e.influences();
            for (int xPrime : influences){
                infl[xPrime].add(e);
            }
        }

        while (!worklist.isEmpty()){
            Equation equation = worklist.extract();
            CompleteLattice newLattice = equation.evaluate(analysis);

            if (!newLattice.leq(analysis[equation.getIndex()])){
                analysis[equation.getIndex()] = analysis[equation.getIndex()].join(newLattice);
                for (Equation e : infl[equation.getIndex()]){
                    worklist.insert(e);
                }
            }
        }

        return analysis;
    }
}
