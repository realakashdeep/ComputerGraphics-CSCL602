package transformation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;

public class MyCanvas extends JPanel implements MouseListener, MouseMotionListener {

	DrawingObject currentDrawingObject = null;

	List<DrawingObject> objects = new Vector<DrawingObject>();

	public MyCanvas() {
		setBackground(Color.WHITE);
		addMouseListener(this);
		addMouseMotionListener(this);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		currentDrawingObject = new Rectangle((int) d.getWidth() / 2 + 200, (int) d.getHeight() / 2 - 200, 50, 50);
		objects.add(currentDrawingObject);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawGrid(g);
		for (DrawingObject ob : objects) {
			ob.draw(g);
		}
	}

	private void drawGrid(Graphics g) {
		// Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension d = getSize();
		g.drawLine((int) d.getWidth() / 2, 0, (int) d.getWidth() / 2, (int) d.getHeight());
		g.drawLine(0, (int) d.getHeight() / 2, (int) d.getWidth(), (int) d.getHeight() / 2);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}

