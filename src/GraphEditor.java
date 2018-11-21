import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/*
 *  Program: Edytor grafu
 *     Plik: GraphEditor.java
 *
 *  Implementacja wygl¹du okna
 *
 *    Autor: Tymoteusz Frankiewicz
 *     Data:  listopad 2018 r.
 */

public class GraphEditor extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private static final String APP_AUTHOR = "Tymoteusz Frankiewicz\n Data: listopad 2018";
	private static final String APP_TITLE = "Edytor grafow";
	
	private static final String APP_INSTRUCTION =
			"                  O P I S   P R O G R A M U \n\n" +
					"Aktywna klawisze:\n" +
					"   strza³ki ==> przesuwanie wszystkich kó³\n" +
					"   SHIFT + strza³ki ==> szybkie przesuwanie wszystkich kó³\n\n" +
					"ponadto gdy kursor wskazuje ko³o:\n" +
					"   DEL   ==> kasowanie ko³a\n" +
					"   +, -   ==> powiêkszanie, pomniejszanie ko³a\n" +
					"   r,g,b ==> zmiana koloru ko³a\n\n" +
					"Operacje myszka:\n" +
					"   przeci¹ganie ==> przesuwanie wszystkich kó³\n" +
					"   PPM ==> tworzenie nowego ko³a w niejscu kursora\n" +
					"ponadto gdy kursor wskazuje ko³o:\n" +
					"   przeci¹ganie ==> przesuwanie ko³a\n" +
					"   PPM ==> zmiana koloru ko³a\n" +
					"                   lub usuwanie ko³a\n";
	
	public static void main(String[] args) {
		new GraphEditor();
	}
	
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuGraph = new JMenu("Graf");
	private JMenu menuHelp = new JMenu("Pomoc");
	private JMenuItem menuNew = new JMenuItem("Nowy");
	private JMenuItem menuShowExample = new JMenuItem("Przyklad");
	private JMenuItem menuExit = new JMenuItem("Zakoncz");
	private JMenuItem menuListOfNodes = new JMenuItem("Lista wezlow");
	private JMenuItem menuAuthor = new JMenuItem("Autor");
	private JMenuItem menuInstruction = new JMenuItem("Instrukcja");
	
	private GraphPanel graphPanel = new GraphPanel();

	
	public GraphEditor() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400,400);
		this.setTitle(APP_TITLE);
		this.setLocationRelativeTo(null);
		
		menuNew.addActionListener(this);
		menuShowExample.addActionListener(this);
		menuExit.addActionListener(this);
		menuListOfNodes.addActionListener(this);
		menuAuthor.addActionListener(this);
		menuInstruction.addActionListener(this);

		menuGraph.setMnemonic(KeyEvent.VK_G);
		menuGraph.add(menuNew);
		menuGraph.add(menuShowExample);
		menuGraph.addSeparator();
		menuGraph.add(menuListOfNodes);
		menuGraph.addSeparator();
		menuGraph.add(menuExit);

		menuHelp.setMnemonic(KeyEvent.VK_H);
		menuHelp.add(menuInstruction);
		menuHelp.add(menuAuthor);

		menuBar.add(menuGraph);
		menuBar.add(menuHelp);
		setJMenuBar(menuBar);
		
		showExampleGraph();
		this.setContentPane(graphPanel);
		this.setVisible(true);
	}
	
	private void showListOfNodes(Graph graph) {
		Node array[] = graph.getNodes();
		int i = 0;
		StringBuilder message = new StringBuilder("Liczba wêz³ów " + array.length + "\n");
		for(Node node: array) {
			message.append(node + "   ");
			if(i % 5 == 0) {
				message.append("\n");
			}
			JOptionPane.showMessageDialog(this, message, APP_TITLE + " - Lista wêz³ów", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	private void showExampleGraph() {
		Graph graph = new Graph();

		Node n1 = new Node(100, 100);
		Node n2 = new Node(100, 200);
		n2.setColor(Color.CYAN);
		Node n3 = new Node(200, 100);
		n3.setR(20);
		Node n4 = new Node(200, 250);
		n4.setColor(Color.GREEN);
		n4.setR(30);

		graph.addNode(n1);
		graph.addNode(n2);
		graph.addNode(n3);
		graph.addNode(n4);
		graphPanel.setGraph(graph);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == menuNew) {
			//nowy graf
		}
		if(e.getSource() == menuShowExample) {
			showExampleGraph();
		}
		if(e.getSource() == menuListOfNodes) {
			showListOfNodes(graphPanel.getGraph());
		}
		if(e.getSource() == menuAuthor) {
			JOptionPane.showMessageDialog(this, APP_AUTHOR, APP_TITLE, JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource() == menuInstruction) {
			JOptionPane.showMessageDialog(this, APP_INSTRUCTION, APP_TITLE, JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource() == menuExit) {
			System.exit(0);
		}
	}
	
}