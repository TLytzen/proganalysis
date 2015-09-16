package ast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a node in a syntax tree structure
 */
public abstract class Node {

	/**
	 * The children of this ASTNode 
	 */
	private ArrayList<Node> children = new ArrayList<>();
	
	/**
	 * Gets a list of all child nodes for this AST Node
	 * 
	 * @return the child list as an unmodifiable list
	 */
	public final List<Node> getChildren(){
		return Collections.unmodifiableList(this.children);
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
	
	/**
	 * Gets a string representation for the node with the given child objects
	 * 
	 * @param nodeName the name of the current node
	 * @param nodeArguments the list of arguments (may be nodes also)
	 * @return a string representation of the node with arguments 
	 */
	public static String stringOfList(String nodeName, List<?> nodeArguments){
		StringBuilder sb = new StringBuilder();
		sb.append(nodeName);
		sb.append('(');
		
		boolean first = true;
		for(Object node : nodeArguments){
			if(!first){
				sb.append(',');
			}
			sb.append(node);
			first = false;
		}
		
		sb.append(')');
		return sb.toString();
	}
	
	public static String concatenateListItems(List<?> nodeArguments){
		return concatenateListItems(nodeArguments, '\n');
	}
	
	public static String concatenateListItems(List<?> nodeArguments, char separator){
		StringBuilder sb = new StringBuilder();
		
		boolean first = true;
		for(Object node : nodeArguments){
			if(!first){
				sb.append(separator);
			}
			sb.append(node);
			first = false;
		}
		
		return sb.toString();
	}
}
