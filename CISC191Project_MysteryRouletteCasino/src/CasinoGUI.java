import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
//import java.util.Scanner;

public class CasinoGUI extends JFrame{
	private static final long serialVersionUID = 1L;
	
	//A few constants for the size of the window
	private final static int WINDOW_WIDTH = 1800;
	private final static int WINDOW_HEIGHT = 1200;
    
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
    private int positionY = 240;
    
    private int card = 0;
	
	
    private static ImageIcon img1 = new ImageIcon("/Users/jordi.j.mejiacruz/git/repository/CISC191Project_MysteryRouletteCasino/src/Roulette_Imgs/Roulette.png");
    private static ImageIcon img2 = new ImageIcon("/Users/jordi.j.mejiacruz/git/repository/CISC191Project_MysteryRouletteCasino/src/Roulette_Imgs/BettingTable.png");
    private static ImageIcon img3 = new ImageIcon("/Users/jordi.j.mejiacruz/git/repository/CISC191Project_MysteryRouletteCasino/src/Roulette_Imgs/MysteryRouletteCards/BackCardTemplate.png");

    private static ImageIcon header = new ImageIcon("/Users/jordi.j.mejiacruz/git/repository/CISC191Project_MysteryRouletteCasino/src/Roulette_Imgs/Signs/NeonCasinoRoulette.png");
    private static ImageIcon author = new ImageIcon("/Users/jordi.j.mejiacruz/git/repository/CISC191Project_MysteryRouletteCasino/src/Roulette_Imgs/Signs/Neon_Jordino.png");

    private static ImageIcon chip1 = new ImageIcon("/Users/jordi.j.mejiacruz/git/repository/CISC191Project_MysteryRouletteCasino/src/Roulette_Imgs/Signs/NeonChip1.png");
    private static ImageIcon chip5 = new ImageIcon("/Users/jordi.j.mejiacruz/git/repository/CISC191Project_MysteryRouletteCasino/src/Roulette_Imgs/Signs/NeonChip5.png");
    private static ImageIcon chip10 = new ImageIcon("/Users/jordi.j.mejiacruz/git/repository/CISC191Project_MysteryRouletteCasino/src/Roulette_Imgs/Signs/NeonChip10.png");
    private static ImageIcon chip25 = new ImageIcon("/Users/jordi.j.mejiacruz/git/repository/CISC191Project_MysteryRouletteCasino/src/Roulette_Imgs/Signs/NeonChip25.png");
    private static ImageIcon chip100 = new ImageIcon("/Users/jordi.j.mejiacruz/git/repository/CISC191Project_MysteryRouletteCasino/src/Roulette_Imgs/Signs/NeonChip100.png");
    private static ImageIcon chip500 = new ImageIcon("/Users/jordi.j.mejiacruz/git/repository/CISC191Project_MysteryRouletteCasino/src/Roulette_Imgs/Signs/NeonChip500.png");
    
    private static ImageIcon p1Icon = new ImageIcon("/Users/jordi.j.mejiacruz/git/repository/CISC191Project_MysteryRouletteCasino/src/Roulette_Imgs/Signs/NeonSpade.png");
    private static ImageIcon p2Icon = new ImageIcon("/Users/jordi.j.mejiacruz/git/repository/CISC191Project_MysteryRouletteCasino/src/Roulette_Imgs/Signs/NeonHeart.png");
    private static ImageIcon p3Icon = new ImageIcon("/Users/jordi.j.mejiacruz/git/repository/CISC191Project_MysteryRouletteCasino/src/Roulette_Imgs/Signs/NeonClub.png");
    private static ImageIcon p4Icon = new ImageIcon("/Users/jordi.j.mejiacruz/git/repository/CISC191Project_MysteryRouletteCasino/src/Roulette_Imgs/Signs/NeonDiamond.png");

    
    
    private MysteryRoulette newGame = new MysteryRoulette();
    private Roulette win = new MysteryRoulette();
    private Roulette wheelLandsOn;
    
   
    private CasinoPanel casinoPanel = new CasinoPanel();
    private AnnouncementPanel roulettePanel = new AnnouncementPanel();
    private AnnouncementPanel mysteryRoulettePanel = new AnnouncementPanel();
    private PreviousPanel previousPanel = new PreviousPanel();
    private PlayerPanel player1Panel = new PlayerPanel();
    private PlayerPanel player2Panel = new PlayerPanel();
    private PlayerPanel player3Panel = new PlayerPanel();
    private PlayerPanel player4Panel = new PlayerPanel();
    
    
    private ButtonListener newListener = new ButtonListener();
    
    private static JLabel casinoNeonSign;
    private static JLabel jordinoNeonSign;
    private static JLabel c1;
    private static JLabel c5;
    private static JLabel c10;
    private static JLabel c25;
    private static JLabel c100;
    private static JLabel c500;
    
    private static JLabel wheel;
    private static JLabel betTable;
    private static JLabel card1;
    private static JLabel card2;
    private static JLabel card3;
    
    private static JLabel sign1;
    private static JLabel sign2;
    private static JLabel sign3;
    
    private static JLabel player1;
    private static JLabel player2;
    private static JLabel player3;
    private static JLabel player4;
    
    private static JButton bet1;
    private static JButton bet5;
    private static JButton bet10;
    private static JButton bet25;
    private static JButton bet100;
    private static JButton bet500;
    
    private Timer timer = new Timer(100, null);
    
    public CasinoGUI() {
        super("Casino");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        casinoPanel.setLayout(null);
        
        
        casinoPanel.setLayout(null);
        casinoPanel.setBackground(new Color(0, 0, 0));
//        roulettePanel.setOpaque(false);
//        mysteryRoulettePanel.setOpaque(false);
        player1Panel.setBackground(Color.BLUE);
        player2Panel.setBackground(Color.RED);
        player3Panel.setBackground(Color.BLUE);
        player4Panel.setBackground(Color.RED);
        
        
        casinoNeonSign = new JLabel(header);
        jordinoNeonSign = new JLabel(author);
        wheel = new JLabel(img1);
        betTable = new JLabel(img2);
        player1 = new JLabel(p1Icon);
        player2 = new JLabel(p2Icon);
        player3 = new JLabel(p3Icon);
        player4 = new JLabel(p4Icon);
        sign1 = new JLabel();
        sign2 = new JLabel();
        sign3 = new JLabel();
        c1 = new JLabel(chip1);
        c5 = new JLabel(chip5);
        c10 = new JLabel(chip10);
        c25 = new JLabel(chip25);
        c100 = new JLabel(chip100);
        c500 = new JLabel(chip500);
        
        
        bet1 = new JButton("Bet $1");
        bet5 = new JButton("Bet $5");
        bet10 = new JButton("Bet $10");
        bet25 = new JButton("Bet $25");
        bet100 = new JButton("Bet $100");
        bet500 = new JButton("Bet $500");

        
        sign1.setText("0<=SPIN<=12");
        sign1.setForeground(new Color(206, 194, 144)); 
        sign2.setText("13<=SPIN<=24");
        sign2.setForeground(new Color(206, 194, 144)); 
        sign3.setText("25<=SPIN<=36");
        sign3.setForeground(new Color(206, 194, 144)); 
        
        
        casinoNeonSign.setBounds(750, 0, 300, 150);
        jordinoNeonSign.setBounds(835, 150, 131, 25);
        roulettePanel.setBounds(100, 25, 650, 100);
        mysteryRoulettePanel.setBounds(1050, 25, 650, 100);
        previousPanel.setBounds(850, 200, 100, 400);
        wheel.setBounds(100, 200, 350, 350);
        betTable.setBounds(1020, 150, 700, 340); 
        player1.setBounds(100, 700, 75, 75);
        player2.setBounds(500, 700, 75, 75);
        player3.setBounds(900, 700, 75, 75);
        player4.setBounds(1300, 700, 75, 82);
        sign1.setBounds(620, 222, 100, 10);
        sign2.setBounds(620, 375, 100, 10);
        sign3.setBounds(620, 528, 100, 10);
        c1.setBounds(1018, 500, 112, 80);
        c5.setBounds(1130, 500, 112, 80);
        c10.setBounds(1242, 500, 112, 80);
        c25.setBounds(1354, 500, 112, 80);
        c100.setBounds(1466, 500, 112, 80);
        c500.setBounds(1580, 500, 112, 80);
        
        bet1.setBounds(1024, 580, 100, 20);
        bet5.setBounds(1136, 580, 100, 20);
        bet10.setBounds(1248, 580, 100, 20);
        bet25.setBounds(1360, 580, 100, 20);
        bet100.setBounds(1472, 580, 100, 20);
        bet500.setBounds(1586, 580, 100, 20);
        
        player1Panel.setBounds(100, 700, 400, 300);
        player2Panel.setBounds(500, 700, 400, 300);
        player3Panel.setBounds(900, 700, 400, 300);
        player4Panel.setBounds(1300, 700, 400, 300);
        
        
		gameGUI();
		
        
		casinoPanel.add(casinoNeonSign);
		casinoPanel.add(jordinoNeonSign);
		casinoPanel.add(roulettePanel);
		casinoPanel.add(mysteryRoulettePanel);
		casinoPanel.add(previousPanel);
        casinoPanel.add(wheel);
        casinoPanel.add(betTable);
        casinoPanel.add(player1);
        casinoPanel.add(player2);
        casinoPanel.add(player3);
        casinoPanel.add(player4);
        casinoPanel.add(sign1);
        casinoPanel.add(sign2);
        casinoPanel.add(sign3);
        casinoPanel.add(c1);
        casinoPanel.add(c5);
        casinoPanel.add(c10);
        casinoPanel.add(c25);
        casinoPanel.add(c100);
        casinoPanel.add(c500);
        casinoPanel.add(bet1);
        casinoPanel.add(bet5);
        casinoPanel.add(bet10);
        casinoPanel.add(bet25);
        casinoPanel.add(bet100);
        casinoPanel.add(bet500);
        
        casinoPanel.add(player1Panel);
        casinoPanel.add(player2Panel);
        casinoPanel.add(player3Panel);
        casinoPanel.add(player4Panel);
        
        
        add(casinoPanel);
        

        bet1.addActionListener(newListener);
        bet5.addActionListener(newListener);
        bet10.addActionListener(newListener);
        bet25.addActionListener(newListener);
        bet100.addActionListener(newListener);
        bet500.addActionListener(newListener);
        
        
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void gameGUI() {
    	card1 = new JLabel(img3);
        card2 = new JLabel(img3);
        card3 = new JLabel(img3);
        
        card1.setBounds(500, 150, 100, 145);
        card2.setBounds(500, 303, 100, 145);
        card3.setBounds(500, 456, 100, 145);
        
        casinoPanel.add(card1);
        casinoPanel.add(card2);
        casinoPanel.add(card3);
    	
    	
    	wheelLandsOn = newGame.spin();
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
			try {
				if(rotation == 15 && position[index] == wheelLandsOn.getNumber()){
					System.out.println("Roulette Wheel!");
					System.out.println("Winning Number: " + wheelLandsOn.getNumber() + " " + wheelLandsOn.getColor());
					System.out.println();
					System.out.println("Mystery Roulette Card!");
					System.out.println("Winning Number: " + win.getNumber() + " " + win.getColor());
					System.out.println();
					timer.stop();
					
					card1.setIcon(img3);
					card2.setIcon(img3);
					card3.setIcon(img3);
					
					ImageIcon img4 = new ImageIcon("/Users/jordi.j.mejiacruz/git/repository/CISC191Project_MysteryRouletteCasino/src/Roulette_Imgs/MysteryRouletteCards/FrontCard_" + win.getNumber() + ".png");
					
					if(card == 1){
						timer.restart();
						card1.setIcon(img4);
						
						
						TimeUnit.SECONDS.sleep(2);
						
						rotation = 0;
						wheelLandsOn = newGame.spin();
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
						
						
					}else if(card == 2){
						timer.restart();
						card2.setIcon(img4);
						
						TimeUnit.SECONDS.sleep(2);
						
						
						rotation = 0;
						
						wheelLandsOn = newGame.spin();
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
						
						
					}else if(card == 3){
						timer.restart();
						card3.setIcon(img4);
						
						TimeUnit.SECONDS.sleep(2);
						
						
						rotation = 0;
						
						wheelLandsOn = newGame.spin();
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
						
						
					}
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
			}catch(InterruptedException error) {
				System.out.println(error);
			}
        }};
        
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
    
    private class PlayerPanel extends JPanel {
        private static final long serialVersionUID = 1L;
    }
    
    private class AnnouncementPanel extends JPanel {
        private static final long serialVersionUID = 1L;
    }
    
    private class PreviousPanel extends JPanel {
        private static final long serialVersionUID = 1L;
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

