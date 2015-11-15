package ast;

public class Edge {

    private int from;
    private int to;
    private Boolean isTrueBranch;

    public Edge(int from, int to, Boolean isTrueBranch){
        this.from = from;
        this.to = to;
        this.isTrueBranch = isTrueBranch;
    }

    public int from() {
        return from;
    }

    public int to() {
        return to;
    }

    public Boolean isTrueBranch() {
        return isTrueBranch;
    }
}
