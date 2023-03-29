package circle;

import java.awt.Graphics;

public class Circle extends DrawingObject {
	int xc,yc;
	double r;
	
	public Circle(int x, int y, double r) {
		xc = x;
		yc = y;
		this.r = r;
	}


	@Override
	void draw(Graphics g) {
		//g.drawOval(x, y, (int)r, (int)r);
		
		int x,y;
		double pk;
		g.fillOval(0, (int)r, 1, 1);
		pk = 1.25-r;
		
		x=0;
		y=(int)r;
		
		while(x<y) {
			if(pk<0) {
				x=x+1;
				pk=pk+2*x;
				
			}
			else {
				x = x+1;
				y = y-1;
				pk=pk+2*x-2*y;
			}
			g.fillOval(x+xc, y+yc, 10, 10);
			g.fillOval(y+xc, x+yc, 10, 10);
			g.fillOval(x+xc, -y+yc, 10, 10);
			g.fillOval(y+xc, -x+yc, 10, 10);
			g.fillOval(-x+xc, -y+yc, 10, 10);
			g.fillOval(-y+xc, -x+yc, 10, 10);
			g.fillOval(-x+xc, y+yc, 10, 10);
			g.fillOval(-y+xc, x+yc, 10, 10);
			
			
		}

	}

}

