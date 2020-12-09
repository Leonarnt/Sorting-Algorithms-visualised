import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.concurrent.ExecutionException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.RepaintManager;
import javax.management.MBeanAttributeInfo;
import javax.swing.Box.Filler;

public class Main extends JPanel {

	static int w = 20; 
	final static int SCREEN_WIDTH = 810;
	final static int SCREEN_HEIGHT = 800;
	final static int arraySize = 40;
	static int x[] = new int[SCREEN_HEIGHT];
	static	Random rand = new Random();
	static int n = 0;
	static int z = 0;



	public static void main(String[] args) {
		JFrame MyFrame = new JFrame();
		MyFrame.setTitle("Bubble short");
		MyFrame.setBackground(Color.white);
		MyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyFrame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		MyFrame.setResizable(false);
		MyFrame.setLocationRelativeTo(null);
		MyFrame.setVisible(true);
		MyPanel mp = new MyPanel();
		MyFrame.add(mp);
		mp.fillArray();
		mp.bubbleshort();
	
		
		
		 
		

	}
	
	public static class MyPanel extends JPanel{
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			draw(g);
		}
		
		public void draw(Graphics g) {
			for(int i=0; i<arraySize; i++) {
				if(i == n) {
					g.setColor(Color.RED);
				}
				else if(z == i) {
					g.setColor(Color.green);
				}
				else {
					g.setColor(Color.black);
				}
				
				g.fillRect(i*w, SCREEN_HEIGHT-x[i], 10, x[i]);
			}
			

		}
		
		public void fillArray() {
			for(int i=0; i<arraySize; i++) {
				x[i] = rand.nextInt(SCREEN_WIDTH-100);
			}
		}
		
		public void bubbleshort() {
			for(int i=0 ; i<arraySize; i++) {
				for(int j=0; j<arraySize-i-1; j++) {
					if(x[j] > x[j+1]) {
						int temp = x[j];
						x[j] = x[j+1];
						x[j+1] = temp;
						n = j+1;
						z=j;
					}
					try {Thread.sleep(40);} catch(Exception ex) {}
					this.repaint();
				}
			}
		}
		
	}

}
