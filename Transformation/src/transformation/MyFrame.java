package transformation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyFrame extends JFrame implements ActionListener {

	MyCanvas canvas = new MyCanvas();
	JButton translateBtn = new JButton("Translate"), scaleBtn = new JButton("Scale"), rotateBtn = new JButton("Rotate");

	public MyFrame() {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
		Timer timer = new Timer(100, this);
		timer.start();
	}

	private void initComponents() {
		JPanel topPanel = new JPanel();
		translateBtn.addActionListener(this);
		topPanel.add(translateBtn);
		scaleBtn.addActionListener(this);
		topPanel.add(scaleBtn);
		rotateBtn.addActionListener(this);
		topPanel.add(rotateBtn);
		add(topPanel, BorderLayout.NORTH);
		add(canvas);
	}

	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		canvas.repaint();
	}

	public static void main(String[] args) {
		MyFrame f = new MyFrame();
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof Timer) {
			canvas.repaint();
		} else {
			String cmd = e.getActionCommand();
			if (cmd.equalsIgnoreCase("Translate")) {
				String v = JOptionPane.showInputDialog("Enter (tx,ty):");
				int tx = Integer.parseInt(v.split(",")[0]);
				int ty = Integer.parseInt(v.split(",")[1]);
				((Rectangle) canvas.currentDrawingObject).translate(tx, ty);
			} else if (cmd.equalsIgnoreCase("Scale")) {
				String v = JOptionPane.showInputDialog("Enter (sx,sy):");
				double sx = Double.parseDouble(v.split(",")[0]);
				double sy = Double.parseDouble(v.split(",")[1]);
				((Rectangle) canvas.currentDrawingObject).scale(sx, sy);
			} else if (cmd.equalsIgnoreCase("Rotate")) {
				String v = JOptionPane.showInputDialog("Enter (theta):");
				double theta = Double.parseDouble(v);
				((Rectangle) canvas.currentDrawingObject).rotate(theta);
			}

		}

	}

}
