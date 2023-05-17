package balloon;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;

public class Arrow extends Thread implements VisibleObjects{
	
	Point location;
	int x,y = 0;
	int release = 0;
	Point Main;
	int delete = 0;
	
	public Arrow(int x,int y){
		this.x = x;
		this.y = y;
		this.location = new Point(x,y);
		this.Main = new Point(x-25,y);
		start();
	}

	@Override
	public void run() {
		while(location.x>-100) {
			System.out.print("");
			if(release == 1) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				location.x-=1;
				Main.x-=1;
			}
			
		}
		if(location.x>-100) {
			delete = 1;
		}
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
		int x[] = {location.x,location.x,location.x-17};
		int y[] = {location.y-10,location.y+10,location.y};
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(2));
		g.drawLine(x[0]-65, y[2], x[0], y[2]);
		g.drawLine(x[0]-65, y[2], x[0]-55, y[2]-10);
		g.drawLine(x[0]-65, y[2], x[0]-55, y[2]+10);
		

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
