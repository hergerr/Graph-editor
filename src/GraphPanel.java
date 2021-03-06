import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JColorChooser;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/*
 *  Program: Edytor grafu
 *     Plik: GraphPanel.java
 *
 *		UWAGA: W celu uzyskania poprawnych znaków w dokumentacji pliki są kodowane w UTF-8		
 *
 *  Klasa GraphPanel implementuje podstawowe funkcjonalno�ci
 *  graficznego edytora grafu
 *  Klasa umożliwia:
 *     - rysowanie grafu w oknie,
 *     - obsługę zdarzeń generowanych przez myszk�,
 *     - tworzenie i obsługę menu kontekstowych
 *       umożliwiających wykonywanie operacji edycyjnych.
 *
 *    	Autor:  Tymoteusz Frankiewicz
 *     	Data:  listopad 2018 r.
 */

public class GraphPanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener{
	private static final long serialVersionUID = 1L;
	private Graph graph;
	private int mouseX, mouseY;
	@SuppressWarnings("unused")
	private boolean mouseButtonLeft, mouseButtonRight;
	private int mouseCursor = Cursor.DEFAULT_CURSOR;
	private Node nodeUnderCursor = null;
	private Line lineUnderCursor = null;
	private Node newLineNode = null;
	
	public GraphPanel() {
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
		this.setFocusable(true);
		this.requestFocus();
	}
	
	public Graph getGraph() {
		return graph;
	}
	
	public void setGraph(Graph graph) {
		this.graph = graph;
		repaint();
	}
	
	public Node findNode(int mx, int my) {
		for(Node node: graph.getNodes()) {
			if(node.isMouseOver(mx,my)) {
				return node;
			}
		}
		return null;
	}
	
	public Line findLine(int x1, int y1) {
		for(Line line: graph.getLines()) {
			if(line.isMouseOver(x1,y1)) {
				return line;
			}
		}
		return null;
	}
	
	public Node findNode(MouseEvent event) {
		return findNode(event.getX(), event.getY());
	}
	
	public Line findLine(MouseEvent event) {
		return findLine(event.getX(), event.getY());
	}
	
	public void setMouseCursor(MouseEvent event) {
		nodeUnderCursor = findNode(event);
		lineUnderCursor = findLine(event);
		if(nodeUnderCursor != null) mouseCursor = Cursor.HAND_CURSOR;
		else if(lineUnderCursor != null) mouseCursor = Cursor.CROSSHAIR_CURSOR;
		else if(mouseButtonLeft) mouseCursor = Cursor.MOVE_CURSOR;
		else if(newLineNode != null) mouseCursor = Cursor.WAIT_CURSOR;
		else mouseCursor = Cursor.DEFAULT_CURSOR;
		
		setCursor(Cursor.getPredefinedCursor(mouseCursor));
		mouseX = event.getX();
		mouseY = event.getY();
	}
	
	public void setMouseCursor() {
		nodeUnderCursor = findNode(mouseX, mouseY);
		if(nodeUnderCursor != null) mouseCursor = Cursor.HAND_CURSOR;
		else if(mouseButtonLeft) mouseCursor = Cursor.MOVE_CURSOR;
		else if(newLineNode != null) mouseCursor = Cursor.WAIT_CURSOR;
		else mouseCursor = Cursor.DEFAULT_CURSOR;
		
		setCursor(Cursor.getPredefinedCursor(mouseCursor));
	}
	
	private void moveNode(int dx, int dy, Node node) {
		node.setX(node.getX() + dx);
		node.setY(node.getY() + dy);
	}
	
	private void moveLine(int x, int y, Line line) {
		line.getNodeA().setX(line.getNodeA().getX() + x);
		line.getNodeA().setY(line.getNodeA().getY() + y);

		line.getNodeB().setX(line.getNodeB().getX() + x);
		line.getNodeB().setY(line.getNodeB().getY() + y);
	}
		
	void moveAllNodes(int dx, int dy) {
		for(Node node: graph.getNodes()) {
			moveNode(dx,dy,node);
		}
	}
	
	

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(graph==null) return;
		graph.draw(g);
	}

	@Override
	public void keyPressed(KeyEvent event) {
		{  int dist;
		if (event.isShiftDown()) dist = 10;
		else dist = 1;
		switch (event.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				moveAllNodes(-dist, 0);
				break;
			case KeyEvent.VK_RIGHT:
				moveAllNodes(dist, 0);
				break;
			case KeyEvent.VK_UP:
				moveAllNodes(0, -dist);
				break;
			case KeyEvent.VK_DOWN:
				moveAllNodes(0, dist);
				break;
			case KeyEvent.VK_DELETE:
				if (nodeUnderCursor != null) {
					graph.removeNode(nodeUnderCursor);
					nodeUnderCursor = null;
				} else if (lineUnderCursor != null) {
					graph.removeLine(lineUnderCursor);
					lineUnderCursor = null;
				}
				break;
			case KeyEvent.VK_9:
				nodeUnderCursor.increaseRadius();
				System.out.println("PLUS");
				break;
			case KeyEvent.VK_MINUS:
				nodeUnderCursor.decreaseRadius();
				break;
		}
	}
	repaint();
	setMouseCursor();
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		if (mouseButtonLeft) {
			if (nodeUnderCursor != null) {
				moveNode(event.getX() - mouseX, event.getY() - mouseY, nodeUnderCursor);
			} else if (lineUnderCursor != null) {
				moveLine(event.getX() - mouseX, event.getY() - mouseY, lineUnderCursor);
			}
			else {
				moveAllNodes(event.getX() - mouseX, event.getY() - mouseY);
			}
		}
		mouseX = event.getX();
		mouseY = event.getY();
		repaint();
		
	}

	@Override
	public void mouseMoved(MouseEvent event) {
		setMouseCursor(event);
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent event) {
		if (event.getButton()==1) mouseButtonLeft = true;
		if (event.getButton()==3) mouseButtonRight = true;
		setMouseCursor(event);
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		if (event.getButton() == 1)
			mouseButtonLeft = false;
		if(event.getButton() == 1 && newLineNode != null) {
			graph.addLine(new Line(findNode(event), newLineNode));
			repaint();
			newLineNode = null;
		}
		if (event.getButton() == 3)
			mouseButtonRight = false;
		setMouseCursor(event);
		
		if (event.getButton() == 3) {
			if (nodeUnderCursor != null) {
				createPopupMenu(event, nodeUnderCursor);
			} else if(lineUnderCursor != null) {
				createPopupMenu(event, lineUnderCursor);
			} else {
				createPopupMenu(event);
			}
		}
		
	}

	private void createPopupMenu(MouseEvent event) {
		JMenuItem menuItem = new JMenuItem("Utwórz nowy węzeł");
		JPopupMenu popup = new JPopupMenu();
		menuItem.addActionListener((actionEvent)->{
			graph.addNode(new Node(event.getX(),event.getY()));
			repaint();
		});
		
		
		
		popup.add(menuItem);
		popup.show(event.getComponent(), event.getX(), event.getY());
		
	}
	
	private void createPopupMenu(MouseEvent event, Line line) {
		JMenuItem menuItem = new JMenuItem("Usuń krawędz");
		JPopupMenu popup = new JPopupMenu();
		menuItem.addActionListener(actionListener -> {
			graph.removeLine(line);
			repaint();
		});
		popup.add(menuItem);
		
		menuItem = new JMenuItem("Zmien kolor krawedzi");
		menuItem.addActionListener(actionListener ->{
			Color newColor = JColorChooser.showDialog(this, "Wybierz kolor", line.getColor());
			if(newColor != null) {
				line.setColor(newColor);
			}
			repaint();
		});
		popup.add(menuItem);
		
		popup.show(event.getComponent(), event.getX(), event.getY());
	}

	private void createPopupMenu(MouseEvent event, Node node) {
		JMenuItem menuItem = new JMenuItem("Zmień kolor węzła");
		JPopupMenu popup = new JPopupMenu();
		
		
		//opcja odpowiedzialna za wybor koloru
		menuItem.addActionListener(actionListener -> {
			Color newColor = JColorChooser.showDialog(this, "Wybierz kolor", node.getColor());
			if(newColor != null) {
				node.setColor(newColor);
			}
			repaint();
			
		});	
		popup.add(menuItem);
		
		//opcja odpowiedzialna za usuwanie wezlow
		menuItem = new JMenuItem("Usuń węzeł");
		menuItem.addActionListener((actionListener)->{
			graph.removeNode(node);
			repaint();
		});
		popup.add(menuItem);
		
		//opcja odpowiedzialna za utworzenie krawedzi
		menuItem = new JMenuItem("Utworz krawedz z węzła");
		menuItem.addActionListener(actionListener -> {
			newLineNode = node;
		});
		popup.add(menuItem);
		
		popup.show(event.getComponent(), event.getX(), event.getY());
	}
	
}