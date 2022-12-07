import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.*;

public class CasinoGUI extends JFrame{
	private static final long serialVersionUID = 1L;
	
	//A few constants for the size of the window
	private final static int WINDOW_WIDTH = 1500;
	private final static int WINDOW_HEIGHT = 1000;
    
//    private int[] x = {265, 265,
//                286, 307, 327, 344, 359, 372, 381, 388, 390, 389, 385, 377,
//                365, 351, 334, 316, 296, 275, 254, 233, 213, 195, 178, 164, 
//                154, 145, 141, 140, 143, 149, 159, 171, 187, 204, 224, 244};
//    
//    
//    
//    private int[] y = {265, 140,
//                142, 147, 155, 168, 183, 199, 219, 239, 260, 281, 302, 322,
//                340, 356, 369, 380, 387, 391, 390, 386, 379, 369, 356, 340,
//                321, 302, 281, 260, 239, 218, 199, 182, 168, 156, 148, 142};
    
    private int[] moveXTo = { 21, 21, 20, 17, 15, 13, 9, 7, 2, -1, -4, -8,
                        -12, -14, -17, -18, -20, -21, -21, -21, -20, -18, -17, -14, 
                        -10, -9, -4, -1, 3, 6, 10, 12, 16, 17, 20, 20,  21};


    private int[] moveYTo= { 2, 5, 8, 13, 15, 16, 20, 20, 21, 21, 21, 20,
                        18, 16, 13, 11, 7, 4, -1, -4, -7, -10, -13, -16,
                        -19, -19, -21, -21, -21, -21, -19, -17, -14, -12, -8, -6, -2};
    
    
    private int position[] = {0,
    							32, 15, 19, 4, 21, 2, 25, 17, 34, 6, 27, 13,
    							36, 11, 30, 8, 23, 10, 5, 24, 16, 33, 1, 20,
    							14, 31, 9, 22, 18, 29, 7, 28, 12, 35, 3, 26};
    
 
    private int index = 0;
    private int rotation = 0;
    
    private int positionX = 265;
    private int positionY = 165;
    
    private int card = 0;
    
    
    private CasinoPanel casinoPanel = new CasinoPanel();
	
	
    private static ImageIcon img1 = new ImageIcon("/Users/jordi.j.mejiacruz/Desktop/CISC191/Project_MysteryRouletteCasino/CISC191Project_MysteryRouletteCasino/src/Roulette_Imgs/Roulette.png");
    private static ImageIcon img2 = new ImageIcon("/Users/jordi.j.mejiacruz/Desktop/CISC191/Project_MysteryRouletteCasino/CISC191Project_MysteryRouletteCasino/src/Roulette_Imgs/BettingTable.png");
    private static ImageIcon img3 = new ImageIcon("/Users/jordi.j.mejiacruz/Desktop/CISC191/Project_MysteryRouletteCasino/CISC191Project_MysteryRouletteCasino/src/Roulette_Imgs/MysteryRouletteCards/BackCardTemplate.png");

    
    private MysteryRoulette newGame = new MysteryRoulette();
    private Roulette win = new MysteryRoulette();

   
    
    private static JLabel wheel;
    private static JLabel betTable;
    private static JLabel card1;
    private static JLabel card2;
    private static JLabel card3;
    private static JButton startButton;
    
    Timer timer = new Timer(100, null);
    
//  private static JLabel b;
    
    public CasinoGUI() {
        super("Casino");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        casinoPanel.setLayout(null);
        
       
        gameGUI();
        
        casinoPanel.setLayout(null);
        casinoPanel.setBackground(new Color(0, 0, 0));
        

        wheel = new JLabel(img1);
        betTable = new JLabel(img2);
        
        

        wheel.setBounds(100, 125, 350, 350);
        betTable.setBounds(100, 550, 700, 340);
        
        
        
        casinoPanel.add(wheel);
        casinoPanel.add(betTable);
        
        
        add(casinoPanel);
        
        
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void gameGUI() {
    	card1 = new JLabel(img3);
        card2 = new JLabel(img3);
        card3 = new JLabel(img3);
        
        card1.setBounds(500, 75, 100, 145);
        card2.setBounds(500, 228, 100, 145);
        card3.setBounds(500, 381, 100, 145);
        
        casinoPanel.add(card1);
        casinoPanel.add(card2);
        casinoPanel.add(card3);
    	
    	
    	Roulette wheelLandsOn = newGame.spin();
    	if(0 <= wheelLandsOn.getNumber() && wheelLandsOn.getNumber() <= 12){
			win = newGame.playMysteryRoulette(wheelLandsOn)[0]; // Card 1
			card = 1;
		}else if(13 <= wheelLandsOn.getNumber() && wheelLandsOn.getNumber() <= 24){
			win = newGame.playMysteryRoulette(wheelLandsOn)[1]; // Card 2
			card = 2;
		}else if(25 <= wheelLandsOn.getNumber() && wheelLandsOn.getNumber() <= 36){
			win = newGame.playMysteryRoulette(wheelLandsOn)[2]; // Card 3
			card = 3;
		}
        
        ActionListener listener = new AbstractAction() {
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e) {
				if(rotation == 5 && position[index] == wheelLandsOn.getNumber()){
					if(card == 1){
						ImageIcon img4 = new ImageIcon("/Users/jordi.j.mejiacruz/Desktop/CISC191/Project_MysteryRouletteCasino/CISC191Project_MysteryRouletteCasino/src/Roulette_Imgs/MysteryRouletteCards/FrontCard_" + win.getNumber() + ".png");
						card1.setIcon(img4);
						
					}else if(card == 2){
						ImageIcon img4 = new ImageIcon("/Users/jordi.j.mejiacruz/Desktop/CISC191/Project_MysteryRouletteCasino/CISC191Project_MysteryRouletteCasino/src/Roulette_Imgs/MysteryRouletteCards/FrontCard_" + win.getNumber() + ".png");
						card2.setIcon(img4);
						
						
					}else if(card == 3){
						ImageIcon img4 = new ImageIcon("/Users/jordi.j.mejiacruz/Desktop/CISC191/Project_MysteryRouletteCasino/CISC191Project_MysteryRouletteCasino/src/Roulette_Imgs/MysteryRouletteCards/FrontCard_" + win.getNumber() + ".png");
						card3.setIcon(img4);
						
						
					}
					System.out.println("Winning Number: " + win.getNumber() + " " + win.getColor());
					
					timer.stop();
				}else if (index == 36) {
                    positionX += moveXTo[index];
                    positionY += moveYTo[index]; 
                    //System.out.println("(" + positionX + ", " + positionY + ")");
                    casinoPanel.repaint();

                    rotation++;
                    //System.out.println("Rotation: " + rotation);
                    index = 0;
                } else {
            		positionX += moveXTo[index];
                    positionY += moveYTo[index]; 
                    //System.out.println("(" + positionX + ", " + positionY + ")");
                    casinoPanel.repaint();

                    index++;
                }
            }
        };
        
        timer.addActionListener(listener);
        timer.start();
    }

    private class CasinoPanel extends JPanel {
        private static final long serialVersionUID = 1L;

		protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.WHITE);
            g.fillOval(positionX, positionY, 20, 20); //
        }

        public Dimension getPreferredSize() {
            return new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);
        }
    }
    
    public void createPanel() {
        startButton = new JButton("Start Roulette!");
        startButton.setBounds(1, 1, 100, 20);
        add(startButton);
        ButtonListener newListener = new ButtonListener();

        startButton.addActionListener(newListener);
    }
    
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CasinoGUI();
            }
        });
    }
}

