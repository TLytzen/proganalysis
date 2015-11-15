package algorithms;


import java.util.ArrayList;
import java.util.List;

public class WorklistAlgorithm {

    private final static int ITERATION_COUNT = 50000;

    public static CompleteLattice[] solve(List<Constraint> equations, int numberOfEquationVariables, Worklist worklistType, CompleteLattice latticeType, boolean measureTime) {
        CompleteLattice[] result = null;
        if (measureTime) {
            long start = System.currentTimeMillis();
            for (int iteration = 0; iteration < ITERATION_COUNT; iteration++){
                result = WorklistAlgorithm.solve(equations, numberOfEquationVariables, worklistType, latticeType);
            }

            long end = System.currentTimeMillis();
            System.out.println("Time spent over "+ITERATION_COUNT+" iterations: " + (end - start)+"ms");
        }
        else{
            result = WorklistAlgorithm.solve(equations, numberOfEquationVariables, worklistType, latticeType);
        }

        return result;
    }

    public static CompleteLattice[] solve(List<Constraint> constraints, int numberOfEquationVariables, Worklist worklistType, CompleteLattice latticeType){
        CompleteLattice[] analysis = new CompleteLattice[numberOfEquationVariables];
        List<Constraint>[] infl = new List[numberOfEquationVariables];

        Worklist worklist = worklistType.getEmpty(constraints);
        CompleteLattice bottom = latticeType.bottom();
        for (Constraint e : constraints){
            worklist.insert(e);
            analysis[e.leftHandSideVariable()] = bottom;
            infl[e.leftHandSideVariable()] = new ArrayList<>();
        }

        for (Constraint e : constraints) {
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
