package draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class MyCanvas extends JPanel{
	
	public MyCanvas() {
		setBackground(Color.WHITE);
	}
	
	void drawPixel(Graphics g, double x1, double y1) {
		int x = (int) Math.round(x1);
		int y = (int) Math.round(y1);
		
		int h = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2.0);
		int w = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2.0);
		
		g.fillOval(x+w, y+h, 1, 1);
	}
	
	void drawLine(int x1, int y1, int x2, int y2) {
		Graphics g = getGraphics();
		//g.drawLine(x1, y1, x2, y2);
		
		/*
		
		for(double t=0; t<= 1 ; t+= 0.001) {
			int x = (int) Math.round((1 - t)*x1 + t*x2);
			int y = (int) Math.round((1 - t)*y1 + t*y2);
			
			drawPixel(g, x, y);
 		}
 		
 		*/
		
		/*
		int dx = x1 - x2;
		int dy = y1 - y2;
		int steps;
		
		if (Math.abs(dx) > Math.abs(dy)) {
			steps = Math.abs(dx);
		}
		else {
			steps = Math.abs(dy);
		}
		
		double x_incr = ((double)dx) / ((double)steps);
		double y_incr = ((double)dy) / ((double)steps);
		for(int i=0; i<= steps; i++) {
			drawPixel(g, x1+i*x_incr, y1+i*y_incr);
		}
		
		*/
		
		for(double t=0; t<=6*(Math.PI) ; t+= 0.00001) {
			int x = (int) ((int) t*(Math.cos(t)));
			int y = (int) ((int) t*(Math.sin(t)));
			
			drawPixel(g, x, y);
			
		}
	}
}

