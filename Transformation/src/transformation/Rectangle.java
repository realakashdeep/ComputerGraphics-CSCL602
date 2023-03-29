package transformation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;

public class Rectangle extends DrawingObject {
	double[][] tm;
	Point p0, p1, p2, p3;

	public Rectangle(int x0, int y0, int width, int height) {
		this.tm = new double[][]{{1.0, 0.0, 0.0}, {0.0, 1.0, 0.0}, {0.0, 0.0, 1.0}};
		
		this.p0 = new Point(x0, y0);
		this.p1 = new Point(x0 + width, y0);
		this.p2 = new Point(x0 + width, y0 + height);
		this.p3 = new Point(x0, y0 + height);
	}
	
	public void translate(int tx, int ty) {
		double tm_tr[][] = {{1.0, 0.0, tx}, {0.0, 1.0, ty}, {0.0, 0.0, 1.0}};
		this.tm = Matrix.mul(tm_tr, tm);
	}
	
	public void scale(double sx, double sy) {
		double xp = (p0.x + p2.x) / 2.0;
		double yp = (p0.y + p2.y) / 2.0;
		
		translate((int) -xp, (int) -yp);
		double tm_sc[][] = {{sx, 0.0, 0.0},
				            {0.0, sy, 0.0},
				            {0.0, 0.0, 1.0}};
		this.tm = Matrix.mul(tm_sc , tm);
		translate((int) -xp, (int) -yp);
	}
	
	public void rotate(double theta) {
		theta = theta * (Math.PI / 180.0);

		double xp = (p0.x + p2.x) / 2.0;
		double yp = (p0.y + p2.y) / 2.0;
		
		translate((int) -xp, (int) -yp);
		double tm_rot[][] = {{Math.cos(theta), -Math.sin(theta), 0.0},
				             {Math.sin(theta),  Math.cos(theta), 0.0},
				             {0.0, 0.0, 1.0}};
		this.tm = Matrix.mul(tm_rot, tm);
		translate((int) xp, (int) yp);
	}
	
	private void transform() {
		double[][] point0 = {{p0.x}, {p0.y}, {1.0}};
		double[][] point1 = {{p1.x}, {p1.y}, {1.0}};
		double[][] point2 = {{p2.x}, {p2.y}, {1.0}};
		double[][] point3 = {{p3.x}, {p3.y}, {1.0}};
		
		double[][] trans;
		
		trans = Matrix.mul(tm, point0);
		p0.x = (int) trans[0][0];
		p0.y = (int) trans[1][0];
		trans = Matrix.mul(tm, point1);
		p1.x = (int) trans[0][0];
		p1.y = (int) trans[1][0];
		trans = Matrix.mul(tm, point2);
		p2.x = (int) trans[0][0];
		p2.y = (int) trans[1][0];
		trans = Matrix.mul(tm, point3);
		p3.x = (int) trans[0][0];
		p3.y = (int) trans[1][0];
		
		tm = new double[][]{{1.0, 0.0, 0.0}, {0.0, 1.0, 0.0}, {0.0, 0.0, 1.0}};
	}
	
	@Override
	void draw(Graphics g) {
		g.setColor(Color.RED);
		
		transform();
		
		g.drawString("(" + p0.x + "," + p0.y + ")", p0.x - 50, p0.y);
		g.drawString("(" + p1.x + "," + p1.y + ")", p1.x, p1.y);
		g.drawString("(" + p2.x + "," + p2.y + ")", p2.x, p2.y);
		g.drawString("(" + p3.x + "," + p3.y + ")", p3.x - 50, p3.y);
		
		g.drawLine(p0.x, p0.y, p1.x, p1.y);
		g.drawLine(p1.x, p1.y, p2.x, p2.y);
		g.drawLine(p2.x, p2.y, p3.x, p3.y);
		g.drawLine(p3.x, p3.y, p0.x, p0.y);
	}

}

