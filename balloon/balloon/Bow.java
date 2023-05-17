package balloon;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;

public class Bow extends Thread implements VisibleObjects{
	
	Point location;
	int x,y = 0;
	int release = 0;
	Point Main;
	int delete = 0;
	
	public Bow(int x,int y){
		this.x = x;
		this.y = y;
		this.location = new Point(x,y);
		this.Main = new Point(x-25,y);
	}

	public Point getMain() {
		return Main;
	}

	public void setMain(Point main) {
		Main = main;
	}

	@Override
	public void display(Graphics g) {
		
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		g.setColor(Color.BLACK);
		g.drawArc(x-50, y-50, 100, 100, 90, 180);
		g.drawLine(x, y+50, x, y-50);
		g.setColor(Color.BLACK);
		

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.location.x = x;
		this.x=x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.location.y = y;
		this.Main.y = y;
		this.y = y;
	}
	public void setR(int r) {
		this.release = r;
	}
	

}
