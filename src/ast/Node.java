package ast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Represents a node in a syntax tree structure
 */
public abstract class Node {



    public abstract Integer initialNode();

    public abstract Set<Integer> finalNodes();

    public abstract List<int[]> flow();

    public abstract Set<Node> blocks();

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
     * The children of this ASTNode
     */
    protected ArrayList<Node> children = new ArrayList<>();

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
