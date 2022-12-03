

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.*;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CasinoGUI extends JFrame{
	private static final long serialVersionUID = 1L;
	
	//A few constants for the size of the window
	final static int WINDOW_WIDTH = 1500;
	final static int WINDOW_HEIGHT = 1000;
	
	private static ImageIcon img1 = new ImageIcon("/Users/jordi.j.mejiacruz/Desktop/CISC191/Project_MysteryRouletteCasino/CISC191Project_MysteryRouletteCasino/src/Roulette_Imgs/Roulette.png");
	private static ImageIcon img2 = new ImageIcon("/Users/jordi.j.mejiacruz/Desktop/CISC191/Project_MysteryRouletteCasino/CISC191Project_MysteryRouletteCasino/src/Roulette_Imgs/BettingTable.png");
//	private static ImageIcon img3 = new ImageIcon("Ball.png");

	private Roulette rouletteGame = new Roulette();
	private MysteryRoulette mysteryrouletteGame = new MysteryRoulette();
	private Roulette win = new MysteryRoulette();

	private static JPanel mainPanel;
	private static JLabel wheel;
	private static JLabel betTable;
	private static JButton startButton;
	
	private Ball[] ball = new Ball[37];
	
//	private static JLabel b;
	
	//private JTextField newText;
	//private JCheckBox newBox;
	
	private int position[] = new int[37];
	
	
	
	public CasinoGUI() {
		//CasinoGUI newWindow = new CasinoGUI();
		
		//Call superclass constructor and title the window
		super("Casino");

		//Set the size
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		//Set the program to end when the window is closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Make a JPanel and add it to the frame
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(0, 49, 14));
		
		wheel = new JLabel(img1);
		betTable = new JLabel(img2);
//		b = new JLabel(img3);
		
		position[0] = 0;
		
		position[1] = 32;  position[13] = 36; position[25] = 14;
		position[2] = 15;  position[14] = 11; position[26] = 31;
		position[3] = 19;  position[15] = 30; position[27] = 9;
		position[4] = 4;   position[16] = 8;  position[28] = 22;
		position[5] = 21;  position[17] = 23; position[29] = 18;
		position[6] = 2;   position[18] = 10; position[30] = 29;
		position[7] = 25;  position[19] = 5;  position[31] = 7;
		position[8] = 17;  position[20] = 24; position[32] = 28;
		position[9] = 34;  position[21] = 16; position[33] = 12;
		position[10] = 6;  position[22] = 33; position[34] = 35;
		position[11] = 27; position[23] = 1;  position[35] = 3;
		position[12] = 13; position[24] = 20; position[36] = 26;
			
		ball[position[0]]= new Ball(0, 265, 140);
		
		ball[position[1]]= new Ball(32, 286, 142);  ball[position[13]]= new Ball(36, 365, 340); ball[position[25]]= new Ball(14, 154, 321);
		ball[position[2]]= new Ball(15, 307, 147);  ball[position[14]]= new Ball(11, 351, 356); ball[position[26]]= new Ball(31, 145, 302);
		ball[position[3]]= new Ball(19, 327, 155);  ball[position[15]]= new Ball(30, 334, 369); ball[position[27]]= new Ball(9, 141, 281);
		ball[position[4]]= new Ball(4, 344, 168);   ball[position[16]]= new Ball(8, 316, 380);  ball[position[28]]= new Ball(22, 140, 260);
		ball[position[5]]= new Ball(21, 359, 183);  ball[position[17]]= new Ball(23, 296, 387); ball[position[29]]= new Ball(18, 143, 239);
		ball[position[6]]= new Ball(2, 372, 199);   ball[position[18]]= new Ball(10, 275, 391); ball[position[30]]= new Ball(29, 149, 218);
		ball[position[7]]= new Ball(25, 381, 219);  ball[position[19]]= new Ball(5, 254, 390);  ball[position[31]]= new Ball(7, 159, 199);
		ball[position[8]]= new Ball(17, 388, 239);  ball[position[20]]= new Ball(24, 233, 386); ball[position[32]]= new Ball(28, 171, 182);
		ball[position[9]]= new Ball(34, 390, 260);  ball[position[21]]= new Ball(16, 213, 379); ball[position[33]]= new Ball(12, 187, 168);
		ball[position[10]]= new Ball(6, 389, 281);  ball[position[22]]= new Ball(33, 195, 369); ball[position[34]]= new Ball(35, 204, 156);
		ball[position[11]]= new Ball(27, 385, 302); ball[position[23]]= new Ball(1, 178, 356);  ball[position[35]]= new Ball(3, 224, 148);
		ball[position[12]]= new Ball(13, 377, 322); ball[position[24]]= new Ball(20, 164, 340); ball[position[36]]= new Ball(26, 244, 142);
		
		
		wheel.setBounds(100, 100, 350, 350);
		betTable.setBounds(500, 100, 700, 340);
		
//		b.setBounds(265, 265, 20, 20); // Center *
//		b.setVisible(true);
		
		mainPanel.setLayout(null);
//		mainPanel.add(b);
		
		try {
			for(int i = 0; i < 37; i++) {
				mainPanel.add(ball[position[i]].getBall());
				System.out.println(ball[position[i]].getNumber());
				TimeUnit.SECONDS.sleep(1);
				mainPanel.remove(ball[position[i]].getBall());
			}
		}catch(InterruptedException err) {
			System.out.println(err);
		}
		
		
		
		mainPanel.add(wheel);
		mainPanel.add(betTable);
		add(mainPanel);
		
		
		createPanel();
		
		//Display the window
		setVisible(true);
	}
	
	
	
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				
				TimeUnit.SECONDS.sleep(3);
				
				
				
//				boolean number = false;
//				int index = 0;
//				
//				TimeUnit.SECONDS.sleep(3);
//				System.out.println("Spinning the wheel");
//				
//				
//				win = rouletteGame.spin(rouletteGame.getWheel());
//				index = 0;
//				
//				while (!number) {
//					TimeUnit.NANOSECONDS.sleep(50);
//					ball[position[index]].getBall().setVisible(true); 
//					System.out.println("Ball at position: " + position[index]);
//					
//					if(ball[position[index]].getNumber() == win.getNumber()) {
//						System.out.println("Winning Number: " + win.getNumber() + " " + win.getColor());
//						break;
//					}else {
//						TimeUnit.NANOSECONDS.sleep(50);
//						ball[position[index]].getBall().setVisible(false); 
//					}
//					
//					index++;
//				}
			}catch(InterruptedException err) {
				System.out.println(err);
			}
		}
		
	}
//	
//	private class TextFieldHandler implements ActionListener{
//		@Override
//		public void actionPerformed(ActionEvent e) {
//		}
//	
//	}
	
//	public class ImagePanel extends JPanel{
//
//	    private BufferedImage image;
//
//	    public ImagePanel() {
//	       try {                
//	          image = ImageIO.read(new File("image name and path"));
//	       } catch (IOException ex) {
//	            // handle exception...
//	       }
//	    }
//
//	    @Override
//	    protected void paintComponent(Graphics g) {
//	        super.paintComponent(g);
//	        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
//	    }
//
//	}
	
	private void createPanel() {
		startButton = new JButton("Start Roulette!");
		startButton.setBounds(1, 1, 100, 20);
		mainPanel.add(startButton);
		ButtonListener newListener = new ButtonListener();
		startButton.addActionListener(newListener);
//		
//		newText = new JTextField("");
//		mainPanel.add(newText);
//		TextFieldHandler newTextListener = new TextFieldHandler();
//		newText.addActionListener(newTextListener);
//		
//		newLabel = new JLabel("test1");
//		mainPanel.add(newLabel);
		
	}
	
	public static void main(String args[]) {
		CasinoGUI newWindow = new CasinoGUI();
	}

}
