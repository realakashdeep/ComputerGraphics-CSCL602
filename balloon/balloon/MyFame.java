
package balloon;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JFrame;
import javax.swing.Timer;

public class MyFame extends JFrame implements ActionListener, KeyListener {

	MyCanvas canvas = new MyCanvas();
	//Cloud cloud = new Cloud();
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	ArrayList<Baloon> baloons = new ArrayList<>();
	ArrayList<Arrow> arrows = new ArrayList<>();
	ArrayList<Bow> bows = new ArrayList<>();
	Bow bow = new Bow(860, 500);
	Arrow arrow = new Arrow(860, 500);
	Baloon baloon = new Baloon(new Point(700, 950));
	public MyFame() {
		
		System.out.println();
//		System.out.println("height : "+screenSize.getHeight()+" width : "+screenSize.getWidth());

		setTitle("Balloon and Arrow");
		setSize(900, 700);
		setResizable(false);
//		setSize(screenSize);
//		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addKeyListener(this);

		Timer timer = new Timer(10, this);
		timer.start();
		init();

	}


	public void init() {
		canvas.objects.add(baloon);
		canvas.objects.add(arrow);
		canvas.objects.add(bow);
		baloons.add(baloon);
		//add(cloud);
		add(canvas);
		
		StartBaloon();
		checkColision();
	}

	// maximum no of baloon is 2 at a time
	// creates and destroys baloons
	public void StartBaloon() {
		Timer timer2 = new Timer(250, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// creating the baloon
				for (int i = 0; i < ThreadLocalRandom.current().nextInt(0, 2); i++) {
					Baloon mybaloon = new Baloon(new Point(getRand(0, 7, 100), 900));
					canvas.objects.add(mybaloon);
					baloons.add(mybaloon);
				}
				// destroying the baloon whose y cord is less than 100
				int x = baloons.size() - 1;
				while (x >= 0) {
					if (baloons.get(x).location.y <-100) {
						Baloon b = baloons.get(x);
						canvas.objects.remove(b);
						baloons.remove(x);

					}
					x--;
				}
			}
		});
		
		timer2.start();
	}

	public void checkColision() {
		Timer timer3 = new Timer(1, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int i = arrows.size();
				int j = baloons.size();
				
					while (i != 0) {
						Arrow Atemp = arrows.get(i - 1);
						int ax = Atemp.getMain().x;
						int ay = Atemp.getMain().y;
						while (j != 0) {
							Baloon btemp = baloons.get(j - 1);
							int bx1 = btemp.getLeft().x;
							int bx2 = btemp.getRight().x;
							int by1 = btemp.getTop().y;
							int by2 = btemp.getBottom().y;
							if (ax > bx1 && ax < bx2) {
								if (ay > by1 && ay < by2) {
									canvas.objects.remove(btemp);
									baloons.remove(j - 1);
								}
							}
							j--;
						}
						i--;
					}
				
				
				

				// removing the arrow if x position < -100
				int x = arrows.size();
				while (x != 0) {
					Arrow temp = arrows.get(x - 1);
					if (temp.delete == 1) {
						canvas.objects.remove(temp);
						arrows.remove(x - 1);
					}
					x--;
				}
			}

		});
		timer3.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		canvas.repaint();
	}

	// gives a random coordinate to create a baloon in range(50,750) difference =
	// 100;
	// baloon is not created if the last two baloon is created on the given
	// coordinate
	public int getRand(int min, int max, int dim) {
		int val = 0;
		if (baloons.size() == 0) {
			int rand = ThreadLocalRandom.current().nextInt(min, max);
			val = rand * dim + 50;
			return val;
		}

		Baloon lastBall;
		Baloon secondLastBall;
		if (baloons.size() > 2) {
			lastBall = baloons.get(baloons.size() - 1);
			secondLastBall = baloons.get(baloons.size() - 2);
		} else if (baloons.size() == 2) {
			lastBall = baloons.get(1);
			secondLastBall = baloons.get(0);
		} else {
			lastBall = baloons.get(0);
			secondLastBall = baloons.get(0);
		}

		do {
			int rand = ThreadLocalRandom.current().nextInt(min, max);
			val = rand * dim + 50;
		} while (val == lastBall.getx() || val == secondLastBall.getx());
		return val;
	}

	public static void main(String[] args) {
		MyFame f = new MyFame();
		f.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_UP) {
			arrow.setY(arrow.getY() - 20);
			bow.setY(bow.getY() - 20);
		}

		if (keyCode == KeyEvent.VK_DOWN) {
			arrow.setY(arrow.getY() + 20);
			bow.setY(bow.getY() + 20);
		}

		if (keyCode == KeyEvent.VK_SPACE) {
			arrows.add(arrow);
			arrow.setR(1);
			arrow = new Arrow(arrow.getX(), arrow.getY());
			canvas.objects.add(arrow);
		}
	}

}
