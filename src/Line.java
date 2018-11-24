import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public class Line implements Serializable{
	private static final long serialVersionUID = 1L;
	Color color;
	Node nodeA, nodeB;
	
	
	public void draw(Graphics g) {
		g.drawLine(nodeA.getX(), nodeA.getY(), nodeB.getX(), nodeB.getY());
		g.setColor(Color.BLUE);
	}
	
	public boolean isMouseOver(int mx, int my) {
		return ((my-nodeA.getY())*(nodeB.getX()-nodeA.getX()) - (nodeB.getY()-nodeA.getY())*(mx-nodeA.getX())) == 0;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(nodeA.getX());
		sb.append(", ");
		
		sb.append(nodeA.getY());
		sb.append(")");
		sb.append(" --------> ");
		
		sb.append("(");
		sb.append(nodeB.getX());
		sb.append(", ");
		
		sb.append(nodeB.getY());
		sb.append(")");
		
		return sb.toString();
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Node getNodeA() {
		return nodeA;
	}

	public void setNodeA(Node nodeA) {
		this.nodeA = nodeA;
	}

	public Node getNodeB() {
		return nodeB;
	}

	public void setNodeB(Node nodeB) {
		this.nodeB = nodeB;
	}

	public Line(Node nodeA, Node nodeB) {
		this.nodeA = nodeA;
		this.nodeB = nodeB;
	}
	
	
	
}