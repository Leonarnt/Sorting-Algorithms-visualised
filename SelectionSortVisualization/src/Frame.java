import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static final int size = 26;
	private int[] x = new int[size];
	
	 
	
	
	
	public Frame() {
		Panel panel = new Panel();
		this.setContentPane(panel);
		this.setTitle("Selection Short");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(WIDTH, HEIGHT);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		panel.SelectionSort(x);
		
	}
	
	
	
	
	
	
	
	
	public class Panel extends JPanel{

		Random rand ;
		int	minIndex;
		
		
		
		
		public Panel() {
			rand = new Random();
			fillArray();
			
		}
		
		
		public void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			draw(g);
			System.out.println(getHeight());
		}
		
		public void draw(Graphics g) {
			for(int i=0; i<size; i++) {
				if(minIndex == i) {
					g.setColor(Color.GREEN);
				}
				else {
					g.setColor(Color.BLACK);					
				}
				
				if(i==0) {
					g.fillRect(5, 560, 20,HEIGHT-x[i]);
				}else {
						g.fillRect(i*30, 560, 20,HEIGHT-x[i]);
					}
			}
			
		}
		
		public void fillArray() {
			
			for(int i=0; i<size; i++) {
				x[i] = rand.nextInt(500);
			}
		}
		
		public  void SelectionSort(int[] arr) {
			int n = arr.length;
			for(int i=0; i<n-1;i++) {
				
				minIndex = i;
			
			for(int j=i+1; j<n; j++) {
				if(arr[j] < arr[minIndex]) {
					minIndex = j;
				}
				try {Thread.sleep(5);} catch(Exception ex) {}
				repaint();
				
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
			try {Thread.sleep(5);} catch(Exception ex) {}
			repaint();
				
			}
			
			
			
		}
		
		
	}
	
	
}
