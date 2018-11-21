import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/*
 * 
 * 
 * Program: Edytor grafu
 * Plik: Graph.java
 * 
 * 
 * Klasa graph reprezentuje graf na plaszcyznie
 * 
 * 
 * Autor: Tymoteusz Frankiewicz
 * Data: listopad 2018
 * 
 * */



public class Graph implements Serializable{
	private static final long serialVersionUID = 1L;

	//lista wêz³ów grafu
	private List<Node> nodes;
	public Graph() {
		this.nodes = new ArrayList<Node>();
	}
	
	public void addNode(Node node) {
		nodes.add(node);
	}
	
	public void removeNode(Node node) {
		nodes.remove(node);
	}
	
	public Node[] getNodes() {
		//jak to dzia³a
		Node[] array = new Node[0];
		return nodes.toArray(array);	
	}
	
	public void draw(Graphics g) {
		for(Node node: nodes) {
			node.draw(g);
		}
	}
}