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
	final static int SCREEN_WIDTH = 1000;
	final static int SCREEN_HEIGHT = 800;
	final static int arraySize = 50;
	static int x[] = new int[SCREEN_HEIGHT];
	static	Random rand = new Random();
	static int n = 0;
	static int z = 0;
	


	public static void main(String[] args) {
		JFrame MyFrame = new JFrame();
		MyFrame.setTitle("Quick short");
		MyFrame.setBackground(Color.white);
		MyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyFrame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		MyFrame.setResizable(true);
		MyFrame.setLocationRelativeTo(null);
		MyFrame.setVisible(true);
		MyPanel mp = new MyPanel();
		MyFrame.add(mp);
		mp.fillArray();
		//mp.bubbleshort();
		mp.quickshort(x, 0, x.length-1);
	
		
		
		 
		

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
				else if(i>n && i<z && i!=0) {
					g.setColor(Color.BLUE);
				}
				
				else {
					g.setColor(Color.black);
				}
				
				g.fillRect(i*w, SCREEN_HEIGHT-x[i]-40, 10, x[i]);
			}
			

		}
		
		public void fillArray() {
			for(int i=0; i<arraySize; i++) {
				x[i] = rand.nextInt(SCREEN_WIDTH-300);
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
					try {Thread.sleep(50);} catch(Exception ex) {}
					this.repaint();
				}
			}
		}
	
		public  void quickshort(int[] arr,int start,int end ) {
			n = start;
			z = end;
			if(start < end) {
				 {
					int index = partition(arr,start,end);
					
					try {Thread.sleep(5);} catch(Exception ex ) {}
					quickshort(arr, start, index-1);
					try {Thread.sleep(5);} catch(Exception ex ) {}
					quickshort(arr, index+1,end );
					
				}
		
			}
			
		}
		
		public  int partition(int[] arr,int start,int pivot) {
			int indexpiv=start;
			for(int i=start; i<pivot; i++) {
				
				if(arr[i] > arr[pivot]) {
					swap(arr,i,indexpiv);
					indexpiv++;
					
				}
			}
			
			swap(arr,pivot,indexpiv);
			return indexpiv;
		}
		
		public  void swap(int[] arr,int a,int b ) {
			int temp = arr[a];
			arr[a] = arr[b];
			arr[b] = temp;
			try {Thread.sleep(10);} catch(Exception ex ) {}
			this.repaint();
		}
		
		
	}

}
