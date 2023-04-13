package balloon;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class MyCanvas extends JPanel{
	List<VisibleObjects> objects = new ArrayList<VisibleObjects>();
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(VisibleObjects o : objects)
			o.display(g);
	}
}
