import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

/*
 * 
 * 
 * 
 * Program - Edytor grafu
 *	Plik: Node.java
 *	
 * Klasa Node reprezentuje wêz³y grafu na p³aszczyznie
 *
 * Autor: Tymoteusz Frankiewicz
 * Data: listopad 2018
 *
 * 
 *
 * 
 */

public class Node implements Serializable{
	private static final long serialVersionUID = 1L;
	//wspolrzedne i promien wezla
	private int x,y,r;
	private Color color;
	


	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
		this.r = 5;
		this.color = Color.BLACK;
	}
	
	void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x-r, y-r, 2*r, 2*r);
		g.setColor(Color.BLACK);
		g.drawOval(x-r, y-r, 2*r, 2*r);
	}
	
	@Override
	public String toString(){
		return ("(" + x +", " + y + ", " + r + ")");
	}

	public boolean isMouseOver(int mx, int my) {
		return  (x-mx)*(x-mx)+(y-my)*(y-my) <= r*r;
	}
	
	public int increaseRadius() {
		return ++r; 
	}
	
	public int decreaseRadius() {
		return --r;
	}
}