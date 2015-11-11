package ast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Represents a node in a syntax tree structure
 */
public abstract class Node {

    /**
     * The children of this ASTNode
     */
    protected ArrayList<Node> children = new ArrayList<>();

    /**
     * Accepts the visitor and calls the correct "visitNode" function on the visitor
     *
     * @param visitor the visitor to be called
     * @see Visitor
     */
    public abstract <T,S> T accept(Visitor<T,S> visitor, S data);


    /**
     * Gets a list of all child nodes for this Node
     *
     * @return the child list as an unmodifiable list
     */
    public final List<Node> getChildren(){
        return Collections.unmodifiableList(this.children);
    }


    public abstract Integer initialNode();

    public abstract Set<Integer> finalNodes();

    public abstract List<int[]> flow();

    public abstract List<Node> blocks();

    private int label;

    public void setLabel(int label)
    {
        this.label = label;
    }

    public int getLabel(){
        return this.label;
    }

    protected static List<int[]> flowForStatementList(List<Node> statements)
    {
        List<int[]> flow = new ArrayList<>();

        for (int s2 = 1; s2 < statements.size(); s2++){
            int s1 = s2 - 1;
            for (int l : statements.get(s1).finalNodes())
            {
                flow.add(new int[]{ l, statements.get(s2).initialNode()});
            }
        }

        for (int a = 0; a < statements.size(); a++) {
            flow.addAll(statements.get(a).flow());
        }

        return flow;
    }


    /**
	 * Adds the given node to the child list if it is not null.
	 * 
	 * @param node the node to add
	 */
	protected void addChildNode(Node node){
		if(node != null){
			this.children.add(node);
		}
	}
	
	/**
	 * Adds all the nodes in the given list to the child list
	 * 
	 * @param nodes the child nodes to add
	 */
	protected void addChildNodes(List<Node> nodes){
		this.children.addAll(nodes);
	}
}
