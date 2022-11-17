import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

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

	private static JPanel mainPanel;
	private static JLabel wheel;
	private static JLabel betTable;
	private static JLabel ball;
	private static JButton startButton;
	
	private JTextField newText;
	private JCheckBox newBox;
	
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
		
		
		ImageIcon img1 = new ImageIcon("/Users/jordi.j.mejiacruz/Desktop/CISC191/Project_MysteryRouletteCasino/CISC191Project_MysteryRouletteCasino/src/Roulette_Imgs/Roulette.png");
		ImageIcon img2 = new ImageIcon("/Users/jordi.j.mejiacruz/Desktop/CISC191/Project_MysteryRouletteCasino/CISC191Project_MysteryRouletteCasino/src/Roulette_Imgs/BettingTable.png");
		ImageIcon img3 = new ImageIcon("/Users/jordi.j.mejiacruz/Desktop/CISC191/Project_MysteryRouletteCasino/CISC191Project_MysteryRouletteCasino/src/Roulette_Imgs/Ball.png");
		
		
		wheel = new JLabel(img1);
		betTable = new JLabel(img2);
		ball = new JLabel(img3);
		
		wheel.setBounds(100, 100, 350, 350);
		betTable.setBounds(500, 100, 700, 340);
		ball.setBounds(265, 265, 20, 20); // Center *
		
		
		//ball.setBounds(265, 265, 20, 20); // Center *
		
		//ball.setBounds(265, 140, 20, 20); // 0 *
		//ball.setBounds(286, 142, 20, 20); // 32 *
		//ball.setBounds(307, 147, 20, 20); // 15 *
		//ball.setBounds(327, 155, 20, 20); // 19 *
		//ball.setBounds(344, 168, 20, 20); // 4 *
		//ball.setBounds(359, 183, 20, 20); // 21 *
		//ball.setBounds(372, 199, 20, 20); // 2 *
		//ball.setBounds(381, 219, 20, 20); // 25 *
		//ball.setBounds(388, 239, 20, 20); // 17 *
		//ball.setBounds(390, 260, 20, 20); // 34 *
		//ball.setBounds(389, 281, 20, 20); // 6 *
		//ball.setBounds(385, 302, 20, 20); // 27 *
		//ball.setBounds(377, 322, 20, 20); // 13 *
		//ball.setBounds(365, 340, 20, 20); // 36 *
		//ball.setBounds(351, 356, 20, 20); // 11 *
		//ball.setBounds(334, 369, 20, 20); // 30 *
		//ball.setBounds(316, 380, 20, 20); // 8 *
		//ball.setBounds(296, 387, 20, 20); // 23 *
		//ball.setBounds(275, 391, 20, 20); // 10 *
		//ball.setBounds(254, 390, 20, 20); // 5 *	
		//ball.setBounds(233, 386, 20, 20); // 24 *
		//ball.setBounds(213, 379, 20, 20); // 16 *
		//ball.setBounds(195, 369, 20, 20); // 33 *
		//ball.setBounds(178, 356, 20, 20); // 1 *
		//ball.setBounds(164, 340, 20, 20); // 20 *
		//ball.setBounds(154, 321, 20, 20); // 14 *
		//ball.setBounds(145, 302, 20, 20); // 31 *
		//ball.setBounds(141, 281, 20, 20); // 9 *
		//ball.setBounds(140, 260, 20, 20); // 22 *
		//ball.setBounds(143, 239, 20, 20); // 18 *
		//ball.setBounds(149, 218, 20, 20); // 29 *
		//ball.setBounds(159, 199, 20, 20); // 7 *
		//ball.setBounds(171, 182, 20, 20); // 28 *
		//ball.setBounds(187, 168, 20, 20); // 12 *
		//ball.setBounds(204, 156, 20, 20); // 35 *
		//ball.setBounds(224, 148, 20, 20); // 3 *
		//ball.setBounds(244, 142, 20, 20); // 26 *
		
		mainPanel.setLayout(null);
		mainPanel.add(ball);
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
				boolean start = false;
					
				TimeUnit.SECONDS.sleep(1);
				ball.setLocation(265, 140); // 0 *
				System.out.println("Ball at position: 0");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setLocation(286, 142); // 32 *
				System.out.println("Ball at position: 32");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setLocation(307, 147); // 15 *
				System.out.println("Ball at position: 15");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(327, 155, 20, 20); // 19 *
				System.out.println("Ball at position: 19");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(344, 168, 20, 20); // 4 *
				System.out.println("Ball at position: 4");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(359, 183, 20, 20); // 21 *
				System.out.println("Ball at position: 21");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(372, 199, 20, 20); // 2 *
				System.out.println("Ball at position: 2");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(381, 219, 20, 20); // 25 *
				System.out.println("Ball at position: 25");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(388, 239, 20, 20); // 17 *
				System.out.println("Ball at position: 17");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(390, 260, 20, 20); // 34 *
				System.out.println("Ball at position: 34");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(389, 281, 20, 20); // 6 *
				System.out.println("Ball at position: 6");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(385, 302, 20, 20); // 27 *
				System.out.println("Ball at position: 27");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(377, 322, 20, 20); // 13 *
				System.out.println("Ball at position: 13");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(365, 340, 20, 20); // 36 *
				System.out.println("Ball at position: 36");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(351, 356, 20, 20); // 11 *
				System.out.println("Ball at position: 11");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(334, 369, 20, 20); // 30 *
				System.out.println("Ball at position: 30");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(316, 380, 20, 20); // 8 *
				System.out.println("Ball at position: 8");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(296, 387, 20, 20); // 23 *
				System.out.println("Ball at position: 23");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(275, 391, 20, 20); // 10 *
				System.out.println("Ball at position: 10");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(254, 390, 20, 20); // 5 *
				System.out.println("Ball at position: 5");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(233, 386, 20, 20); // 24 *
				System.out.println("Ball at position: 24");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(213, 379, 20, 20); // 16 *
				System.out.println("Ball at position: 16");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(195, 369, 20, 20); // 33 *
				System.out.println("Ball at position: 33");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(178, 356, 20, 20); // 1 *
				System.out.println("Ball at position: 1");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(164, 340, 20, 20); // 20 *
				System.out.println("Ball at position: 20");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(154, 321, 20, 20); // 14 *
				System.out.println("Ball at position: 14");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(145, 302, 20, 20); // 31 *
				System.out.println("Ball at position: 31");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(141, 281, 20, 20); // 9 *
				System.out.println("Ball at position: 9");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(140, 260, 20, 20); // 22 *
				System.out.println("Ball at position: 22");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(143, 239, 20, 20); // 18 *
				System.out.println("Ball at position: 18");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(149, 218, 20, 20); // 29 *
				System.out.println("Ball at position: 29");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(159, 199, 20, 20); // 7 *
				System.out.println("Ball at position: 7");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(171, 182, 20, 20); // 28 *
				System.out.println("Ball at position: 28");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(187, 168, 20, 20); // 12 *
				System.out.println("Ball at position: 12");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(204, 156, 20, 20); // 35 *
				System.out.println("Ball at position: 35");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(224, 148, 20, 20); // 3 *
				System.out.println("Ball at position: 3");
				
				TimeUnit.SECONDS.sleep(1);
				ball.setBounds(244, 142, 20, 20); // 26 *
				System.out.println("Ball at position: 26");
					
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
