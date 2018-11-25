import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

/**
 * Klasa reprezentująca wierzchołek grafu.
 * Klasa odpowiada za:
 * <ol>
 * <li>Przechowywanie atrybutow: połozenia (x, y), promienia (r) i koloru (color)</li>
 * <li>Udostępnienie metody <code>draw()</code>, która odpowiedzialna jest za rysowanie wierzchołka</li>
 * <li>Udostępnienie metod do zwiększania (<code>increaseRadius()</code>) i zmniejszania (<code>decreasceRadius()</code>) promienia wierchołka</li>
 * <li>Udostępnienie metody pozwalającej na detekcje czy kursor znajduje się w obszrze wierzchołka (<code>isMouseOver()</code>)</li>
 * </ol>
 * 
 * @author Tymoteusz Frankiewicz
 * @version 25 listopada 2018
 */

public class Node implements Serializable{
	/**
	 * Zmienna odpowiedzialna za serializacje
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Położenie x wierzchołka
	 */
	private int x;
	/**
	 * Połozenie y wierzchołka
	 */
	private int y;
	/**
	 * Promien wierzchołka
	 */
	private int r;
	
	/**
	 * Kolor wierzchołka
	 */
	private Color color;
	

	/**
	 * Metoda zwracająca kolor wierzchołka
	 * @return Kolor wierzchołka
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Metoda ustawiająca dany kolor
	 * @param color Kolor wierzchołka
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Metoda zwraca pozycje x wierzchołka
	 * @return Pozycja x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Matoda ustawiająca daną pozycje x
	 * @param x Pozycja x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Metoda zwraca pozycje y wierzchołka
	 * @return Pozycja y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Matoda ustawiająca daną pozycje y
	 * @param y Pozcyja y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Metoda zwracająca promien wierzchołka
	 * @return Promień
	 */
	public int getR() {
		return r;
	}

	/**
	 * Metoda ustawiająca promień
	 * @param r Promień
	 */
	public void setR(int r) {
		this.r = r;
	}

	/**
	 * Konstruktor ustawiający wierzchołek na rządanych pozycjach (x,y)
	 * <p><b>Domyślnie ustawia promień na 5, a kolor na czarny</b>
	 * @param x Pozcyja x
	 * @param y Pozycja y
	 */
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
		this.r = 5;
		this.color = Color.BLACK;
	}
	
	/**
	 * Metoda odpowiedzialna za wyryzowanie wierzchołka
	 * @param g Referencja do grafiki
	 */
	void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x-r, y-r, 2*r, 2*r);
		g.setColor(Color.BLACK);
		g.drawOval(x-r, y-r, 2*r, 2*r);
	}
	
	/**
	 * Przeciążona metoda toString, odpowiedzialna za wypisanie na ekranie właściwosci wierzchołka
	 * <p><b>Uwaga:</b> Metoda moze byc wywoływana niejawnie, jeśli zachodzi potrzeba
	 * przedstawienia weirzchołka w formie tekstowej.
	 * @return String z właściwościami wierzchołka
	 */
	@Override
	public String toString(){
		return ("(" + x +", " + y + ", " + r + ")");
	}

	/**
	 * Metoda odpowiedzialna za sprawdzenie czy kursor jest w obrębie wierzchołka
	 * @param mx Pozycja x kursora
	 * @param my Pozycja y kursora
	 * @return Czy kursor jest w wierzchołku
	 */
	public boolean isMouseOver(int mx, int my) {
		return  (x-mx)*(x-mx)+(y-my)*(y-my) <= r*r;
	}
	
	/**
	 * Metoda odpowiedzialna za zwiększanie promienia wierzchołka
	 * @return Powiększony promień
	 */
	public int increaseRadius() {
		return ++r; 
	}
	
	/**
	 * Metoda odpowiedzialna za pomniejszenie promienia wierzchołka
	 * @return Pomniejszony promień
	 */
	public int decreaseRadius() {
		return --r;
	}
}