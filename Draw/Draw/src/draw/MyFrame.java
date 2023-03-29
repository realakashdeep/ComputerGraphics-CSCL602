package draw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyFrame extends JFrame implements ActionListener {

	MyCanvas canvas = new MyCanvas();
	
	public MyFrame() {
		//setSize(800,800);
		setExtendedState(MAXIMIZED_BOTH);
		Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}
	
	private void initComponents() {
		JPanel topPanel = new JPanel();
		JButton lineBtn = new JButton("Line");
		lineBtn.addActionListener(this);
		topPanel.add(lineBtn);
		add(topPanel,BorderLayout.NORTH);	
		add(canvas);	
	}

	public static void main(String[] args) {
		MyFrame f = new MyFrame();
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equalsIgnoreCase("line")) {
			String temp = JOptionPane.showInputDialog("Enter x1,x2");
			int x1 = Integer.parseInt(temp.split(",")[0]);
			int y1 = Integer.parseInt(temp.split(",")[1]);
			temp = JOptionPane.showInputDialog("Enter x1,x2");
			int x2 = Integer.parseInt(temp.split(",")[0]);
			int y2 = Integer.parseInt(temp.split(",")[1]);    
			canvas.drawLine(x1, y1, x2, y2);
		}

		
	}

}

