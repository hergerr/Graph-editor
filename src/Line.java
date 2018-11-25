import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;

/**
 * Klasa reprezentująca krawędz grafu.
 * Klasa odpowiada za:.
 * <ol>
 * <li>Przechowywanie atrybutow: dwóch węzłów (NodeA, NodeB) z których wychodzi krawędz i jej koloru</li>
 * <li>Udostępnienie metody <code>draw()</code>, która odpowiedzialna jest za rysowanie krawedzi</li>
 * <li>Udostępnienie metody pozwalającej na detekcje czy kursor znajduje się w obszarze krawedzi (<code>isMouseOver()</code>)</li>
 * </ol>
 * 
 * @author Tymoteusz Frankiewicz
 * @version 25 listopada 2018
 */
public class Line implements Serializable{
	/**
	 * Zmienna odpowiedzialna za serializacje
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Zmienna odpowiedzialna za kolor krawedzi
	 */
	private Color color;
	
	/**
	 * Pierwszy z wierzchołkow z ktorych wychodzi krawedz
	 */
	private Node nodeA;
	
	/**
	 * Drugi z wierzcholkow z ktorych wychodzi krawedz
	 */
	private Node nodeB;
	
	
	/**
	 * Metoda odpowiedzialna za wyrysowanie pojedynczej krawedzi
	 * @param g Referencja do grafiki
	 */
	public void draw(Graphics g) {
		Graphics2D g2= (Graphics2D)g;
		g2.setColor(color);
		g2.setStroke(new BasicStroke(3));
		g2.drawLine(nodeA.getX(), nodeA.getY(), nodeB.getX(), nodeB.getY());
	}
	
	/**
	 * Metoda sprawdzająca czy kursor znajduje sie w obrębie krawedzi
	 * @param mx Pozycja x kursora
	 * @param my Pozycja y kursora
	 * @return Czy kursor jest w obrebie krawedzi
	 */
	public boolean isMouseOver(int mx, int my) {
		return ((my-nodeA.getY())*(nodeB.getX()-nodeA.getX()) - (nodeB.getY()-nodeA.getY())*(mx-nodeA.getX())) == 0;
	}
	
	/**
	 * Przeciążona metoda toString, odpowiedzialna za wypisanie na ekranie właściwosci krawedzi
	 * <p><b>Uwaga:</b> Metoda moze byc wywoływana niejawnie, jeśli zachodzi potrzeba
	 * przedstawienia krawedzi w formie tekstowej.
	 * @return String z właściwościami wierzchołka
	 */
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

	/**
	 * Metoda zwracająca kolor krawedzi
	 * @return Kolor krawedzi
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Metoda ustawiająca zadany kolor krawedzi
	 * @param color Kolor krawedzi
	 */
	public void setColor(Color color) {
		this.color = color;
		System.out.println(color);
	}

	/**
	 * Metoda zwracający pierwszy z wierzchołków
	 * @return Pierwszy z wierzchołków
	 */
	public Node getNodeA() {
		return nodeA;
	}

	/**
	 * Metoda ustawiająca pierwszy z wierzchołków
	 * @param nodeA Pierwszy z wierzchołków
	 */
	public void setNodeA(Node nodeA) {
		this.nodeA = nodeA;
	}

	/**
	 * Metoda zwracający drugi z wierzchołków
	 * @return Drugi z wierzchołków
	 */
	public Node getNodeB() {
		return nodeB;
	}

	/**
	 * Metoda ustawiająca drugi z wierzchołków
	 * @param nodeB Drugi z wierzchołków
	 */
	public void setNodeB(Node nodeB) {
		this.nodeB = nodeB;
	}

	/**
	 * Konstruktor przyjmujący jako argumenty węzły
	 * <p>Domyslnie ustawia kolor krawedzi na różowy
	 * @param nodeA Pierwszy z wierzchołków
	 * @param nodeB Drugi z wierzchołków
	 */
	public Line(Node nodeA, Node nodeB) {
		this.nodeA = nodeA;
		this.nodeB = nodeB;
		color = Color.PINK;
	}
	
	/**
	 * Konkrtuktor przyjmujący jako argumenty węzły i kolor
	 * @param nodeA Pierwszy z wierzchołków
	 * @param nodeB Drugi z wierzchołków
	 * @param color Kolor wierzchołka
	 */
	public Line(Node nodeA, Node nodeB, Color color) {
		this.nodeA = nodeA;
		this.nodeB = nodeB;
		this.color = color;
	}
	
	
	
}