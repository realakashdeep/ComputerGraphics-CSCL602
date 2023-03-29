package circle;

import java.awt.Graphics;

public class Line extends DrawingObject {

	int x1,y1,x2,y2;
	
	
	public Line(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	@Override
	public String toString() {
		
		return "Line[("+x1+","+y1+"),("+x2+","+y2+")]";
	}

	@Override
	void draw(Graphics g) {
		//g.drawLine(x1, y1, x2, y2);
		
		int dx = x2 - x1;
		int dy = x2 - x1;
		
		int x=x1;
		int y=y1;
		
		int p = 2*dy - dx;
		while(x < x2) {
			g.drawOval(x, y, 1, 1);
			if(p<0) {
				p += 2*dy;
				
			}else {
				y++;
				p += 2*dy - 2*dx;
			}
			x++;
		}
	}

}


