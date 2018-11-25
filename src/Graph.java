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



/**
 * Klasa odpowiedzialna za reprezentacje grafu
 * <p> Pozwala na przechowywanie wierzchołków i krawędzi,
 * a także zarządania nimi (dodawanie, usuwanie)
 * 
 * @author Tymoteusz Frankiewicz
 * @version 25 listopada 2018
 */
public class Graph implements Serializable{
	/**
	 * Zmienna odpowiedzialna za serializacje
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Lista węzłów grafu
	 */
	private List<Node> nodes;
	
	/**
	 * lista krawedzi grafu
	 */
	private List<Line> lines;
	
	/**
	 * Kontruktor inicjalizujący nowy graf
	 */
	public Graph() {
		this.nodes = new ArrayList<Node>();
		this.lines = new ArrayList<Line>();
	}
	
	/**
	 * Dodaje nową krawędz do listy krawędzi w grafie
	 * @param Krawędz do dodania
	 */
	public void addLine(Line line) {
		lines.add(line);
	}
	
	/**
	 * Usuwa krawędz z listy krawedzi w grafie
	 * @param Krawedz do usuniecia
	 */
	public void removeLine(Line line) {
		lines.remove(line);
	}
	
	/**
	 * Zwraca tablice z krawędziami grafu
	 * @return Tablica krawędzi
	 */
	public Line[] getLines() {
		Line[] array = new Line[0];
		return lines.toArray(array);
	}
	
	/**
	 * Dodaje nowy wierzchołek do listy węzłów w grafie
	 * @param Wierzchołek do dodanie
	 */
	public void addNode(Node node) {
		nodes.add(node);
	}
	
	/**
	 * Usuwa wierzchołek z listy wierzchołków w grafie
	 * <p><b>Uwaga: Nalezy wtedy tez usunac wychodzace z niego krawedzie</b>
	 * @param Wierzchołek do usuniecia
	 */
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
	
	/**
	 * Zwraca tablice z wierzchołkami grafu
	 * @return Tablica wierzchołków
	 */
	public Node[] getNodes() {
		Node[] array = new Node[0];
		return nodes.toArray(array);	
	}
	
	/**
	 * Rysuje cały graf, czyli wierachołki i krawędzie w taki sposób, aby krawędzie znajdowały się pod wierzchołkami
	 * @param Grafika
	 */
	public void draw(Graphics g) {
		for(Line line:lines) {
			line.draw(g);
		}
		
		for(Node node: nodes) {
			node.draw(g);
		}
	}
	

}