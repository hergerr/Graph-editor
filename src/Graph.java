import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
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
	
	//lista krawedzi grafu
	private List<Line> lines;
	
	public Graph() {
		this.nodes = new ArrayList<Node>();
		this.lines = new ArrayList<Line>();
	}
	
	public void addLine(Line line) {
		lines.add(line);
	}
	
	public void removeLine(Line line) {
		lines.remove(line);
	}
	
	public Line[] getLines() {
		Line[] array = new Line[0];
		return lines.toArray(array);
	}
	
	
	public void addNode(Node node) {
		nodes.add(node);
	}
	
	public void removeNode(Node node) {
		Iterator<Line> iterator = lines.iterator();
		
		while(iterator.hasNext()) {
			Line line = iterator.next();
			
			if(line.getNodeA() == node || line.getNodeB() == node) {
				iterator.remove();
			}
			
		}
		nodes.remove(node);
	}
	
	public Node[] getNodes() {
		//jak to dzia³a
		Node[] array = new Node[0];
		return nodes.toArray(array);	
	}
	
	public void draw(Graphics g) {
		for(Line line:lines) {
			line.draw(g);
		}
		
		for(Node node: nodes) {
			node.draw(g);
		}
	}
	

}