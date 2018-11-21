import java.awt.Color;
import java.awt.Graphics;

/*
 * 
 * 
 * 
 * Program - Edytor grafu
 *	Plik: Node.java
 *	
 * Klasa Node reprezentuje w�z�y grafu na p�aszczyznie
 *
 * Autor: Tymoteusz Frankiewicz
 * Data: listopad 2018
 *
 * 
 *
 * 
 */

public class Node{
	private int x,y,r;
	private Color color;

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
	
}