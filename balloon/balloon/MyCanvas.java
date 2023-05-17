package balloon;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyCanvas extends JPanel{
	List<VisibleObjects> objects = new ArrayList<VisibleObjects>();
	Image cloud = null;
	int x, y;
	int height = 900;
	int width = 700;
	
	public MyCanvas() {
		x = 0;
		y = 0;
		//System.out.println("I am in Clouds");
		getImage();
		
	}
	public void getImage() {
		// TODO Auto-generated method stub
		cloud = new ImageIcon(getClass().getResource("/res/cloud.png")).getImage();
		
		}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(cloud,x,y,height,width,null);

		for(VisibleObjects o : objects)
			o.display(g);
	}
}
