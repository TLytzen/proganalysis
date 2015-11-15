package ast.nodes;

import ast.Edge;
import ast.Node;
import ast.Visitor;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ArrayDeclaration extends Node {
    private String identifier;
    private int length;

    public ArrayDeclaration(String identifier, int length) {

        this.identifier = identifier;
        this.length = length;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public int getLength() {
        return this.length;
    }


    @Override
    public Integer initialNode() {
        return this.getLabel();
    }

    @Override
    public Set<Integer> finalNodes() {
        return Collections.singleton(this.getLabel());
    }

    @Override
    public List<Edge> flow() {
        return Collections.emptyList();
    }

    @Override
    public List<Node> blocks() {
        return Collections.singletonList((Node) this);
    }

    @Override
    public <T, S> T accept(Visitor<T, S> visitor, S data) {
        return visitor.visitArrayDeclaration(this, data);
    }

    @Override
    public String toString(){
        return "int "+this.identifier+"["+this.length+"]";
    }


    public static String getElementIdentifier(String arrayIdentifier, int element){
        return getElementIdentifier(arrayIdentifier, "" + element);
    }

    public static String getFirstElementIdentifier(String arrayIdentifier){
        return getElementIdentifier(arrayIdentifier, "0");
    }

    public static String getRestElementIdentifier(String arrayIdentifier){
        return getElementIdentifier(arrayIdentifier, "rest");
    }

    public static String getElementIdentifier(String arrayIdentifier, String element){
        return arrayIdentifier+"["+element+"]";
    }

    public static boolean isRestElement(String identifier){
        return identifier != null && identifier.contains("[rest]");
    }
}
