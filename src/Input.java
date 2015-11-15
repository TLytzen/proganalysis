import algorithms.Analysis;
import algorithms.Worklist;
import algorithms.detectionOfSigns.DSAnalysis;
import algorithms.reachingDefinitions.RDAnalysis;
import algorithms.worklists.SetWorklist;


public class Input {

    private String programFileName;
    private Analysis analysis;
    private Worklist worklist;

    private Input(String programFileName, Analysis analysis, Worklist worklist){
        this.programFileName = programFileName;
        this.analysis = analysis;
        this.worklist = worklist;
    }

    public Analysis getAnalysis() {
        return analysis;
    }

    public String getProgramFileName() {
        return programFileName;
    }

    public Worklist getWorklist() {
        return worklist;
    }

    public static Input parseInput(String[] args) {
        Analysis analysis = null;
        Worklist worklist = null;
        String filename = null;

        if (args != null) {
            for (String argument : args) {
                if (argument.equals("--RD")) {
                    analysis = new RDAnalysis();
                } else if (argument.equals("--DS")) {
                    analysis = new DSAnalysis();
                } else if (argument.equals("--SET")) {
                    worklist = new SetWorklist();
                } else {
                    filename = argument;
                }
            }
        }

        if (filename == null || analysis == null){
            System.out.println("Usage: ALGORITHM [WORKLIST] FILE");
            System.out.println("Where:");
            System.out.println("[ALGORITHM] is either: '--RD' or '--DS' for Reaching definitions or Detection of Signs");
            System.out.println("[WORKLIST] is either: '--SET' or '...' for Worklist set or .... Default is SET");
            System.out.println("and FILE is the path to the program file");
            System.exit(-1);
        }

        if (worklist == null){
            System.out.println("Using default worklist: SET");
            worklist = new SetWorklist();
        }

        return new Input(filename, analysis, worklist);
    }
}
