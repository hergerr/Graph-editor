import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

/*
 *  Program: Edytor grafu
 *     Plik: GraphPanel.java
 *
 *  Klasa GraphPanel implementuje podstawowe funkcjonalnoœci
 *  graficznego edytora grafu
 *  Klasa umo¿liwia:
 *     - rysowanie grafu w oknie,
 *     - obs³ugê zdarzeñ generowanych przez myszkê,
 *     - tworzenie i obs³ugê menu kontekstowych
 *       umo¿liwiaj¹cych wykonywanie operacji edycyjnych.
 *
 *    Autor:  Tymoteusz Frankiewicz
 *     Data:  listopad 2018 r.
 */

public class GraphPanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener{

	private static final long serialVersionUID = 1L;

	private Graph graph;
	private int mouseX, mouseY;
	private boolean mouseButtonLeft, mouseButtonRight;
	private int mouseCursor = Cursor.DEFAULT_CURSOR;
	private Node nodeUnderCursor = null;
	
	public GraphPanel() {
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
		this.setFocusable(true);
		this.requestFocus();
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
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
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}