import algorithms.Analysis;
import algorithms.Worklist;
import algorithms.detectionOfSigns.DSAnalysis;
import algorithms.reachingDefinitions.RDAnalysis;
import algorithms.worklists.RoundRobinWorklist;
import algorithms.worklists.SetWorklist;
import graph.FlowGraph;


public class Input {

    private String programFileName;
    private Analysis analysis;
    private String worklistType;

    private boolean measureTime;

    private Input(String programFileName, Analysis analysis, String worklistType, boolean measureTime){
        this.programFileName = programFileName;
        this.analysis = analysis;
        this.worklistType = worklistType;
        this.measureTime = measureTime;
    }

    public Analysis getAnalysis() {
        return analysis;
    }

    public String getProgramFileName() {
        return programFileName;
    }

    public Worklist getWorklist(FlowGraph graph) {
        switch (this.worklistType){
            case "SET":
                return new SetWorklist();

            case "ROUND_ROBIN":
                return new RoundRobinWorklist(graph);

            default:
                return null;
        }
    }

    public boolean measureTime() {
        return measureTime;
    }

    public static Input parseInput(String[] args) {
        Analysis analysis = null;
        String worklistType = null;
        String filename = null;
        boolean measureTime = false;

        if (args != null) {
            for (String argument : args) {
                if (argument.equals("--RD")) {
                    analysis = new RDAnalysis();
                } else if (argument.equals("--DS")) {
                    analysis = new DSAnalysis();
                } else if (argument.equals("--SET")) {
                    worklistType = "SET";
                } else if (argument.equals("--ROUND_ROBIN")) {
                    worklistType = "ROUND_ROBIN";
                }   else if (argument.equals("--TIME")) {
                    measureTime = true;
                }else {
                    filename = argument;
                }
            }
        }

        if (filename == null || analysis == null){
            System.out.println("Usage: ALGORITHM [WORKLIST] [--TIME] FILE");
            System.out.println("Where:");
            System.out.println("[ALGORITHM] is either: '--RD' or '--DS' for Reaching definitions or Detection of Signs");
            System.out.println("[WORKLIST] is either: '--SET' or '--ROUND_ROBIN' for Worklist set or the Round Robin Algorithm. Default is SET");
            System.out.println("[--TIME]: if this flag is given, the time to run solve the contraints are measured over a large number of iterations - to allow comparisons of set implementations");
            System.out.println("and FILE is the path to the program file");
            System.exit(-1);
        }

        if (worklistType == null){
            worklistType = "SET";
            System.out.println("Using default worklist: "+worklistType);
        }

        return new Input(filename, analysis, worklistType, measureTime);
    }
}
