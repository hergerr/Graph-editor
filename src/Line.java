import java.awt.Color;
import java.awt.Graphics;

public class Line {
	Color color;
	int x1,y1,x2,y2;
	
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public int getY1() {
		return y1;
	}
	public void setY1(int y1) {
		this.y1 = y1;
	}
	public int getX2() {
		return x2;
	}
	public void setX2(int x2) {
		this.x2 = x2;
	}
	public int getY2() {
		return y2;
	}
	public void setY2(int y2) {
		this.y2 = y2;
	}
	
	
	public Line(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	
	public void draw(Graphics g) {
		g.drawLine(x1, y1, x2, y2);
		g.setColor(Color.BLUE);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(x1);
		sb.append(", ");
		
		sb.append(y1);
		sb.append(")");
		sb.append(" -------->");
		
		sb.append("(");
		sb.append(x2);
		sb.append(", ");
		
		sb.append(y2);
		sb.append(")");
		
		return sb.toString();
	}
	
}