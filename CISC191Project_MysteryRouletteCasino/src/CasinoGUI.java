import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
//import java.util.LinkedList;
//import java.util.Queue;

public class CasinoGUI extends JFrame{
	private static final long serialVersionUID = 1L;
	
	//Constants for the size of the window
	private final static int WINDOW_WIDTH = 1800;
	private final static int WINDOW_HEIGHT = 1200;
    

    
	// ---------- Roulette Wheel ----------
	
	// ---------- Position to move Ball ----------
//  private int[] x = {265, 265,
//  286, 307, 327, 344, 359, 372, 381, 388, 390, 389, 385, 377,
//  365, 351, 334, 316, 296, 275, 254, 233, 213, 195, 178, 164, 
//  154, 145, 141, 140, 143, 149, 159, 171, 187, 204, 224, 244};
//
//
//
//private int[] y = {265, 140,
//  142, 147, 155, 168, 183, 199, 219, 239, 260, 281, 302, 322,
//  340, 356, 369, 380, 387, 391, 390, 386, 379, 369, 356, 340,
//  321, 302, 281, 260, 239, 218, 199, 182, 168, 156, 148, 142};
	
    private int[] moveXTo = { 21, 21, 20, 17, 15, 13, 9, 7, 2, -1, -4, -8,
                        -12, -14, -17, -18, -20, -21, -21, -21, -20, -18, -17, -14, 
                        -10, -9, -4, -1, 3, 6, 10, 12, 16, 17, 20, 20,  21};


    private int[] moveYTo= { 2, 5, 8, 13, 15, 16, 20, 20, 21, 21, 21, 20,
                        18, 16, 13, 11, 7, 4, -1, -4, -7, -10, -13, -16,
                        -19, -19, -21, -21, -21, -21, -19, -17, -14, -12, -8, -6, -2};
    
    
    // ---------- Number at Ball Position ----------
    private int position[] = {0,
    							32, 15, 19, 4, 21, 2, 25, 17, 34, 6, 27, 13,
    							36, 11, 30, 8, 23, 10, 5, 24, 16, 33, 1, 20,
    							14, 31, 9, 22, 18, 29, 7, 28, 12, 35, 3, 26};
    
    // ---------- Used for Ball Animation ----------
    private int index = 0;
    private int rotation = 0;
    
    // ---------- Ball Start Position ----------
    private int positionX = 265;
    private int positionY = 240;
    
    // ---------- Mystery Roulette Card to Flip ----------
    private int card = 0;
    
    // ---------- Images for Casino ----------
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

    
    // ---------- Roulette and Mystery Roulette Game ----------
    private MysteryRoulette newGame = new MysteryRoulette();
    private Roulette rouletteWin;
    private Roulette mysteryRouletteWin;
    
    // ---------- Panels ----------
    private CasinoPanel casinoPanel = new CasinoPanel();
    private AnnouncementPanel roulettePanel = new AnnouncementPanel();
    private AnnouncementPanel mysteryRoulettePanel = new AnnouncementPanel();
//    private PreviousPanel previousPanel = new PreviousPanel();
    private PlayerPanel player1Panel = new PlayerPanel();
    private PlayerPanel player2Panel = new PlayerPanel();
    private PlayerPanel player3Panel = new PlayerPanel();
    private PlayerPanel player4Panel = new PlayerPanel();
    private JPanel bettingTablePanel = new JPanel();
    
    // ---------- ActionListeners ----------
    private ButtonListener buttonListener = new ButtonListener();
    private TextFieldListener textFieldListener = new TextFieldListener();
    
    
    // ---------- Casino Panel ----------
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
    
    private static JLabel bet;
    private static JButton bet1;
    private static JButton bet5;
    private static JButton bet10;
    private static JButton bet25;
    private static JButton bet100;
    private static JButton bet500;
    
    private static JLabel mrWin;
    private static JLabel rWin;
    
    private static JButton gameMode;
    
    private Timer timer = new Timer(100, null);
    
    
    // ---------- Player Panel(s) ----------
    private static JButton player1;
    private static JButton player2;
    private static JButton player3;
    private static JButton player4;
    
    private static JLabel questionP1;
    private static JLabel questionP2;
    private static JLabel questionP3;
    private static JLabel questionP4;
    
    private static JTextField answerP1;
    private static JTextField answerP2;
    private static JTextField answerP3;
    private static JTextField answerP4;
    
    private static JLabel responseP1;
    private static JLabel responseP2;
    private static JLabel responseP3;
    private static JLabel responseP4;
    
    private static JLabel bettingP1;
    private static JLabel bettingP2;
    private static JLabel bettingP3;
    private static JLabel bettingP4;
    
    private static JLabel balanceP1;
    private static JLabel balanceP2;
    private static JLabel balanceP3;
    private static JLabel balanceP4;
    
    
    // ---------- Betting Table Panel ----------
    private JButton number0 = new JButton();
    private JButton number1 = new JButton();
    private JButton number2 = new JButton();
    private JButton number3 = new JButton();
    private JButton number4 = new JButton();
    private JButton number5 = new JButton();
    private JButton number6 = new JButton();
    private JButton number7 = new JButton();
    private JButton number8 = new JButton();
    private JButton number9 = new JButton();
    private JButton number10 = new JButton();
    private JButton number11 = new JButton();
    private JButton number12 = new JButton();
    private JButton number13 = new JButton();
    private JButton number14 = new JButton();
    private JButton number15 = new JButton();
    private JButton number16 = new JButton();
    private JButton number17 = new JButton();
    private JButton number18 = new JButton();
    private JButton number19 = new JButton();
    private JButton number20 = new JButton();
    private JButton number21 = new JButton();
    private JButton number22 = new JButton();
    private JButton number23 = new JButton();
    private JButton number24 = new JButton();
    private JButton number25 = new JButton();
    private JButton number26 = new JButton();
    private JButton number27 = new JButton();
    private JButton number28 = new JButton();
    private JButton number29 = new JButton();
    private JButton number30 = new JButton();
    private JButton number31 = new JButton();
    private JButton number32 = new JButton();
    private JButton number33 = new JButton();
    private JButton number34 = new JButton();
    private JButton number35 = new JButton();
    private JButton number36 = new JButton();
    
   
    private JButton row1 = new JButton();
    private JButton row2 = new JButton();
    private JButton row3 = new JButton();
    
    private JButton group1_12 = new JButton();
    private JButton group13_24 = new JButton();
    private JButton group25_36 = new JButton();
    
    private JButton group1_18 = new JButton();
    private JButton group19_36 = new JButton();
    
    private JButton even = new JButton();
    private JButton odd = new JButton();
    
    private JButton red = new JButton();
    private JButton black = new JButton();
    
    
    private static int totalBet1 = 0;
    private static int totalBet2 = 0;
    private static int totalBet3 = 0;
    private static int totalBet4 = 0;
    private static int addChip = 0;
    private static int playerPlaying = -1;
    private static Player[] p = new Player[4];
    
    public CasinoGUI() {
    	// ---------- Frame Size ----------
        super("Casino");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        
        
        // ---------- Initialize Players ----------
        p[0] = new Player();
        p[1] = new Player();
        p[2] = new Player();
        p[3] = new Player();
        
        // ---------- Panel Layout ----------
        casinoPanel.setLayout(null);
        roulettePanel.setLayout(null);
        mysteryRoulettePanel.setLayout(null);
        player1Panel.setLayout(null);
        player2Panel.setLayout(null);
        player3Panel.setLayout(null);
        player4Panel.setLayout(null);
        bettingTablePanel.setLayout(null);

    	
    	// ---------- Labels, Buttons and TextFields ----------
        casinoNeonSign = new JLabel(header);
        jordinoNeonSign = new JLabel(author);
        gameMode = new JButton("Roulette!");
        wheel = new JLabel(img1);
        betTable = new JLabel(img2);
        rWin = new JLabel();
        mrWin = new JLabel();
        
        player1 = new JButton(p1Icon);
        player2 = new JButton(p2Icon);
        player3 = new JButton(p3Icon);
        player4 = new JButton(p4Icon);
        
        questionP1 = new JLabel("P1 - Enter Money!");
        questionP2 = new JLabel("P2 - Enter Money!");
        questionP3 = new JLabel("P3 - Enter Money!");
        questionP4 = new JLabel("P4 - Enter Money!");
        answerP1 = new JTextField();
        answerP2 = new JTextField();
        answerP3 = new JTextField();
        answerP4 = new JTextField();
        responseP1 = new JLabel("P1: You entered ");
        responseP2 = new JLabel("P2: You entered ");
        responseP3 = new JLabel("P3: You entered ");
        responseP4 = new JLabel("P4: You entered ");
        bettingP1 = new JLabel("Betting: ");
        bettingP2 = new JLabel("Betting: ");
        bettingP3 = new JLabel("Betting: ");
        bettingP4 = new JLabel("Betting: ");
        balanceP1 = new JLabel("Balance: 0");
        balanceP2 = new JLabel("Balance: 0");
        balanceP3 = new JLabel("Balance: 0");
        balanceP4 = new JLabel("Balance: 0");
        
        
        sign1 = new JLabel();
        sign2 = new JLabel();
        sign3 = new JLabel();
        c1 = new JLabel(chip1);
        c5 = new JLabel(chip5);
        c10 = new JLabel(chip10);
        c25 = new JLabel(chip25);
        c100 = new JLabel(chip100);
        c500 = new JLabel(chip500);
        
        
        bet = new JLabel("Betting Chip: 0");
        bet1 = new JButton("Bet $1");
        bet5 = new JButton("Bet $5");
        bet10 = new JButton("Bet $10");
        bet25 = new JButton("Bet $25");
        bet100 = new JButton("Bet $100");
        bet500 = new JButton("Bet $500");
        
        
     // ---------- Backgrounds and Opaques ----------
        casinoPanel.setBackground(new Color(0, 0, 0));
        roulettePanel.setOpaque(false);
        mysteryRoulettePanel.setOpaque(false);
        bettingTablePanel.setOpaque(false);
//        player1Panel.setBackground(Color.BLUE);
//        player2Panel.setBackground(Color.RED);
//        player3Panel.setBackground(Color.BLUE);
//        player4Panel.setBackground(Color.RED);
        player1Panel.setOpaque(false);
        player2Panel.setOpaque(false);
        player3Panel.setOpaque(false);
        player4Panel.setOpaque(false);
	    player1.setOpaque(false);
	    player2.setOpaque(false);
	    player3.setOpaque(false);
	    player4.setOpaque(false);
	    player1.setContentAreaFilled(false);
	    player2.setContentAreaFilled(false);
	    player3.setContentAreaFilled(false);
	    player4.setContentAreaFilled(false);
	    player1.setBorder(null);
	    player2.setBorder(null);
	    player3.setBorder(null);
	    player4.setBorder(null);
	    
        
        number0.setOpaque(false);
    	number1.setOpaque(false);
    	number2.setOpaque(false);
    	number3.setOpaque(false);
    	number4.setOpaque(false);
    	number5.setOpaque(false);
    	number6.setOpaque(false);
    	number7.setOpaque(false);
    	number8.setOpaque(false);
    	number9.setOpaque(false);
    	number10.setOpaque(false);
    	number11.setOpaque(false);
    	number12.setOpaque(false);
    	number13.setOpaque(false);
    	number14.setOpaque(false);
    	number15.setOpaque(false);
    	number16.setOpaque(false);
    	number17.setOpaque(false);
    	number18.setOpaque(false);
    	number19.setOpaque(false);
    	number20.setOpaque(false);
    	number21.setOpaque(false);
    	number22.setOpaque(false);
    	number23.setOpaque(false);
    	number24.setOpaque(false);
    	number25.setOpaque(false);
    	number26.setOpaque(false);
    	number27.setOpaque(false);
    	number28.setOpaque(false);
    	number29.setOpaque(false);
    	number30.setOpaque(false);
    	number31.setOpaque(false);
    	number32.setOpaque(false);
    	number33.setOpaque(false);
    	number34.setOpaque(false);
    	number35.setOpaque(false);
    	number36.setOpaque(false);
    	
    	row1.setOpaque(false);
    	row2.setOpaque(false);
    	row3.setOpaque(false);
    	
    	group1_12.setOpaque(false);
    	group13_24.setOpaque(false);
    	group25_36.setOpaque(false);
    	
    	group1_18.setOpaque(false);
    	group19_36.setOpaque(false);
    	
    	even.setOpaque(false);
    	odd.setOpaque(false);
    	
    	red.setOpaque(false);
    	black.setOpaque(false);
    	
    	number0.setContentAreaFilled(false);
    	number1.setContentAreaFilled(false);
    	number2.setContentAreaFilled(false);
    	number3.setContentAreaFilled(false);
    	number4.setContentAreaFilled(false);
    	number5.setContentAreaFilled(false);
    	number6.setContentAreaFilled(false);
    	number7.setContentAreaFilled(false);
    	number8.setContentAreaFilled(false);
    	number9.setContentAreaFilled(false);
    	number10.setContentAreaFilled(false);
    	number11.setContentAreaFilled(false);
    	number12.setContentAreaFilled(false);
    	number13.setContentAreaFilled(false);
    	number14.setContentAreaFilled(false);
    	number15.setContentAreaFilled(false);
    	number16.setContentAreaFilled(false);
    	number17.setContentAreaFilled(false);
    	number18.setContentAreaFilled(false);
    	number19.setContentAreaFilled(false);
    	number20.setContentAreaFilled(false);
    	number21.setContentAreaFilled(false);
    	number22.setContentAreaFilled(false);
    	number23.setContentAreaFilled(false);
    	number24.setContentAreaFilled(false);
    	number25.setContentAreaFilled(false);
    	number26.setContentAreaFilled(false);
    	number27.setContentAreaFilled(false);
    	number28.setContentAreaFilled(false);
    	number29.setContentAreaFilled(false);
    	number30.setContentAreaFilled(false);
    	number31.setContentAreaFilled(false);
    	number32.setContentAreaFilled(false);
    	number33.setContentAreaFilled(false);
    	number34.setContentAreaFilled(false);
    	number35.setContentAreaFilled(false);
    	number36.setContentAreaFilled(false);
    	
    	row1.setContentAreaFilled(false);
    	row2.setContentAreaFilled(false);
    	row3.setContentAreaFilled(false);
    	
    	group1_12.setContentAreaFilled(false);
    	group13_24.setContentAreaFilled(false);
    	group25_36.setContentAreaFilled(false);
    	
    	group1_18.setContentAreaFilled(false);
    	group19_36.setContentAreaFilled(false);
    	
    	even.setContentAreaFilled(false);
    	odd.setContentAreaFilled(false);
    	
    	red.setContentAreaFilled(false);
    	black.setContentAreaFilled(false);
        
    	number0.setBorderPainted(false);
    	number1.setBorderPainted(false);
    	number2.setBorderPainted(false);
    	number3.setBorderPainted(false);
    	number4.setBorderPainted(false);
    	number5.setBorderPainted(false);
    	number6.setBorderPainted(false);
    	number7.setBorderPainted(false);
    	number8.setBorderPainted(false);
    	number9.setBorderPainted(false);
    	number10.setBorderPainted(false);
    	number11.setBorderPainted(false);
    	number12.setBorderPainted(false);
    	number13.setBorderPainted(false);
    	number14.setBorderPainted(false);
    	number15.setBorderPainted(false);
    	number16.setBorderPainted(false);
    	number17.setBorderPainted(false);
    	number18.setBorderPainted(false);
    	number19.setBorderPainted(false);
    	number20.setBorderPainted(false);
    	number21.setBorderPainted(false);
    	number22.setBorderPainted(false);
    	number23.setBorderPainted(false);
    	number24.setBorderPainted(false);
    	number25.setBorderPainted(false);
    	number26.setBorderPainted(false);
    	number27.setBorderPainted(false);
    	number28.setBorderPainted(false);
    	number29.setBorderPainted(false);
    	number30.setBorderPainted(false);
    	number31.setBorderPainted(false);
    	number32.setBorderPainted(false);
    	number33.setBorderPainted(false);
    	number34.setBorderPainted(false);
    	number35.setBorderPainted(false);
    	number36.setBorderPainted(false);
    	
    	row1.setBorderPainted(false);
    	row2.setBorderPainted(false);
    	row3.setBorderPainted(false);
    	
    	group1_12.setBorderPainted(false);
    	group13_24.setBorderPainted(false);
    	group25_36.setBorderPainted(false);
    	
    	group1_18.setBorderPainted(false);
    	group19_36.setBorderPainted(false);
    	
    	even.setBorderPainted(false);
    	odd.setBorderPainted(false);
    	
    	red.setBorderPainted(false);
    	black.setBorderPainted(false);

        
        // ---------- Text Fonts and Foregrounds ----------
        sign1.setText("0<=SPIN<=12");
        sign1.setForeground(new Color(206, 194, 144)); 
        sign2.setText("13<=SPIN<=24");
        sign2.setForeground(new Color(206, 194, 144)); 
        sign3.setText("25<=SPIN<=36");
        sign3.setForeground(new Color(206, 194, 144)); 
        
        bet.setForeground(new Color(206, 194, 144)); 
        
        questionP1.setForeground(new Color(206, 194, 144));
        questionP2.setForeground(new Color(206, 194, 144));
        questionP3.setForeground(new Color(206, 194, 144));
        questionP4.setForeground(new Color(206, 194, 144));
        responseP1.setForeground(new Color(206, 194, 144));
        responseP2.setForeground(new Color(206, 194, 144));
        responseP3.setForeground(new Color(206, 194, 144));
        responseP4.setForeground(new Color(206, 194, 144));
        bettingP1.setForeground(new Color(206, 194, 144));
        bettingP2.setForeground(new Color(206, 194, 144));
        bettingP3.setForeground(new Color(206, 194, 144));
        bettingP4.setForeground(new Color(206, 194, 144));
        balanceP1.setForeground(new Color(206, 194, 144));
        balanceP2.setForeground(new Color(206, 194, 144));
        balanceP3.setForeground(new Color(206, 194, 144));
        balanceP4.setForeground(new Color(206, 194, 144));
        
        // ---------- Bounds ----------
        roulettePanel.setBounds(100, 25, 650, 100);
        mysteryRoulettePanel.setBounds(1050, 25, 650, 100);
//        previousPanel.setBounds(850, 200, 100, 400);
        
        player1Panel.setBounds(100, 700, 400, 300);
        player2Panel.setBounds(500, 700, 400, 300);
        player3Panel.setBounds(900, 700, 400, 300);
        player4Panel.setBounds(1300, 700, 400, 300);
        
        bettingTablePanel.setBounds(1040, 150, 630, 296);
        
        casinoNeonSign.setBounds(750, 0, 300, 150);
        jordinoNeonSign.setBounds(835, 150, 131, 25);
        gameMode.setBounds(800, 300, 200, 25);
        wheel.setBounds(100, 200, 350, 350);
        betTable.setBounds(0, 0, 630, 296);
        
        player1.setBounds(100, 700, 75, 75);
        player2.setBounds(500, 700, 75, 75);
        player3.setBounds(900, 700, 75, 75);
        player4.setBounds(1300, 700, 75, 82);
        questionP1.setBounds(75, 5, 300, 20);
        questionP2.setBounds(75, 5, 300, 20);
        questionP3.setBounds(75, 5, 300, 20);
        questionP4.setBounds(75, 5, 300, 20);
        answerP1.setBounds(75, 25, 300, 20);
        answerP2.setBounds(75, 25, 300, 20);
        answerP3.setBounds(75, 25, 300, 20);
        answerP4.setBounds(75, 25, 300, 20);
        responseP1.setBounds(75, 45, 300, 20);
        responseP2.setBounds(75, 45, 300, 20);
        responseP3.setBounds(75, 45, 300, 20);
        responseP4.setBounds(75, 45, 300, 20);
        bettingP1.setBounds(0, 90, 400, 20);
        bettingP2.setBounds(0, 90, 400, 20);
        bettingP3.setBounds(0, 90, 400, 20);
        bettingP4.setBounds(0, 90, 400, 20);
        balanceP1.setBounds(0, 110, 400, 20);
        balanceP2.setBounds(0, 110, 400, 20);
        balanceP3.setBounds(0, 110, 400, 20);
        balanceP4.setBounds(0, 110, 400, 20);
        
        sign1.setBounds(620, 222, 100, 10);
        sign2.setBounds(620, 375, 100, 10);
        sign3.setBounds(620, 528, 100, 10);
        c1.setBounds(1018, 500, 112, 80);
        c5.setBounds(1130, 500, 112, 80);
        c10.setBounds(1242, 500, 112, 80);
        c25.setBounds(1354, 500, 112, 80);
        c100.setBounds(1466, 500, 112, 80);
        c500.setBounds(1580, 500, 112, 80);
        
        bet.setBounds(1288, 600, 110, 20);
        bet1.setBounds(1024, 580, 100, 20);
        bet5.setBounds(1136, 580, 100, 20);
        bet10.setBounds(1248, 580, 100, 20);
        bet25.setBounds(1360, 580, 100, 20);
        bet100.setBounds(1472, 580, 100, 20);
        bet500.setBounds(1586, 580, 100, 20);
        
        number0.setBounds(2, 3, 43, 200);
    	number1.setBounds(47, 139, 42, 63);
    	number2.setBounds(47, 71, 42, 63);
    	number3.setBounds(47, 4, 42, 63);
    	number4.setBounds(91, 139, 43, 63);
    	number5.setBounds(91, 71, 43, 63);
    	number6.setBounds(91, 4, 43, 63);
    	number7.setBounds(137, 139, 42, 63);
    	number8.setBounds(137, 71, 42, 63);
    	number9.setBounds(137, 4, 42, 63);
    	number10.setBounds(181, 139, 43, 63);
    	number11.setBounds(181, 71, 43, 63);
    	number12.setBounds(181, 4, 43, 63);
    	number13.setBounds(226, 139, 42, 63);
    	number14.setBounds(226, 71, 42, 63);
    	number15.setBounds(226, 4, 42, 63);
    	number16.setBounds(271, 139, 42, 63);
    	number17.setBounds(271, 71, 42, 63);
    	number18.setBounds(271, 4, 42, 63);
    	number19.setBounds(316, 139, 42, 63);
    	number20.setBounds(316, 71, 42, 63);
    	number21.setBounds(316, 4, 42, 63);
    	number22.setBounds(361, 139, 42, 63);
    	number23.setBounds(361, 71, 42, 63);
    	number24.setBounds(361, 4, 42, 63);
    	number25.setBounds(405, 139, 42, 63);
    	number26.setBounds(405, 71, 42, 63);
    	number27.setBounds(405, 4, 42, 63);
    	number28.setBounds(451, 139, 41, 63);
    	number29.setBounds(451, 71, 41, 63);
    	number30.setBounds(451, 4, 41, 63);
    	number31.setBounds(495, 139, 42, 63);
    	number32.setBounds(495, 71, 42, 63);
    	number33.setBounds(495, 4, 42, 63);
    	number34.setBounds(540, 139, 42, 63);
    	number35.setBounds(540, 71, 42, 63);
    	number36.setBounds(540, 4, 42, 63);
    	
    	row1.setBounds(585, 139, 42, 63);
    	row2.setBounds(585, 71, 42, 63);
    	row3.setBounds(585, 4, 42, 63);
    	
    	group1_12.setBounds(47, 206, 177, 43);
    	group13_24.setBounds(226, 206, 177, 43);
    	group25_36.setBounds(405, 206, 177, 43);
    	
    	group1_18.setBounds(47, 252, 87, 42);
    	group19_36.setBounds(495, 252, 87, 42);
    	
    	even.setBounds(137, 252, 87, 42);
    	odd.setBounds(405, 252, 87, 42);
    	
    	red.setBounds(226, 252, 87, 42);
    	black.setBounds(316, 252, 87, 42);
        
        
    	// ---------- Roulette and Mystery Roulette Game ----------
		gameGUI();
		
        
		// ---------- Add to designated Panels ----------
		casinoPanel.add(casinoNeonSign);
		casinoPanel.add(jordinoNeonSign);
		casinoPanel.add(gameMode);
		casinoPanel.add(roulettePanel);
		casinoPanel.add(mysteryRoulettePanel);
		
//		casinoPanel.add(previousPanel);
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
        casinoPanel.add(bet);
        casinoPanel.add(bet1);
        casinoPanel.add(bet5);
        casinoPanel.add(bet10);
        casinoPanel.add(bet25);
        casinoPanel.add(bet100);
        casinoPanel.add(bet500);
        
        player1Panel.add(questionP1);
        player2Panel.add(questionP2);
        player3Panel.add(questionP3);
        player4Panel.add(questionP4);
        player1Panel.add(answerP1);
        player2Panel.add(answerP2);
        player3Panel.add(answerP3);
        player4Panel.add(answerP4);
        player1Panel.add(responseP1);
        player2Panel.add(responseP2);
        player3Panel.add(responseP3);
        player4Panel.add(responseP4);
        player1Panel.add(bettingP1);
        player2Panel.add(bettingP2);
        player3Panel.add(bettingP3);
        player4Panel.add(bettingP4);
        player1Panel.add(balanceP1);
        player2Panel.add(balanceP2);
        player3Panel.add(balanceP3);
        player4Panel.add(balanceP4);
        
        casinoPanel.add(player1Panel);
        casinoPanel.add(player2Panel);
        casinoPanel.add(player3Panel);
        casinoPanel.add(player4Panel);
        
        bettingTablePanel.add(number0);
        bettingTablePanel.add(number1);
        bettingTablePanel.add(number2);
        bettingTablePanel.add(number3);
        bettingTablePanel.add(number4);
        bettingTablePanel.add(number5);
        bettingTablePanel.add(number6);
        bettingTablePanel.add(number7);
        bettingTablePanel.add(number8);
        bettingTablePanel.add(number9);
        bettingTablePanel.add(number10);
        bettingTablePanel.add(number11);
        bettingTablePanel.add(number12);
        bettingTablePanel.add(number13);
        bettingTablePanel.add(number14);
        bettingTablePanel.add(number15);
        bettingTablePanel.add(number16);
        bettingTablePanel.add(number17);
    	bettingTablePanel.add(number18);
    	bettingTablePanel.add(number19);
    	bettingTablePanel.add(number20);
    	bettingTablePanel.add(number21);
    	bettingTablePanel.add(number22);
    	bettingTablePanel.add(number23);
    	bettingTablePanel.add(number24);
    	bettingTablePanel.add(number25);
    	bettingTablePanel.add(number26);
    	bettingTablePanel.add(number27);
    	bettingTablePanel.add(number28);
    	bettingTablePanel.add(number29);
    	bettingTablePanel.add(number30);
    	bettingTablePanel.add(number31);
    	bettingTablePanel.add(number32);
    	bettingTablePanel.add(number33);
    	bettingTablePanel.add(number34);
    	bettingTablePanel.add(number35);
    	bettingTablePanel.add(number36);
    	
    	bettingTablePanel.add(row1);
    	bettingTablePanel.add(row2);
    	bettingTablePanel.add(row3);
    	
    	bettingTablePanel.add(group1_12);
    	bettingTablePanel.add(group13_24);
    	bettingTablePanel.add(group25_36);
    	
    	bettingTablePanel.add(group1_18);
    	bettingTablePanel.add(group19_36);
    	
    	bettingTablePanel.add(even);
    	bettingTablePanel.add(odd);
    	
    	bettingTablePanel.add(red);
    	bettingTablePanel.add(black);
    	
        bettingTablePanel.add(betTable);
        casinoPanel.add(bettingTablePanel);
        
        // ---------- Add main Panel to main Frame ----------
        add(casinoPanel);
        
        // ---------- Add ActionListeners ----------
        gameMode.addActionListener(buttonListener);
        
        bet1.addActionListener(buttonListener);
        bet5.addActionListener(buttonListener);
        bet10.addActionListener(buttonListener);
        bet25.addActionListener(buttonListener);
        bet100.addActionListener(buttonListener);
        bet500.addActionListener(buttonListener);
        
        answerP1.addActionListener(textFieldListener);
        answerP2.addActionListener(textFieldListener);
        answerP3.addActionListener(textFieldListener);
        answerP4.addActionListener(textFieldListener);
        
        player1.addActionListener(buttonListener);
        player2.addActionListener(buttonListener);
        player3.addActionListener(buttonListener);
        player4.addActionListener(buttonListener);
        
        number0.addActionListener(buttonListener);
        number1.addActionListener(buttonListener);
        number2.addActionListener(buttonListener);
        number3.addActionListener(buttonListener);
        number4.addActionListener(buttonListener);
        number5.addActionListener(buttonListener);
        number6.addActionListener(buttonListener);
        number7.addActionListener(buttonListener);
        number8.addActionListener(buttonListener);
        number9.addActionListener(buttonListener);
        number10.addActionListener(buttonListener);
        number11.addActionListener(buttonListener);
        number12.addActionListener(buttonListener);
        number13.addActionListener(buttonListener);
        number14.addActionListener(buttonListener);
        number15.addActionListener(buttonListener);
        number16.addActionListener(buttonListener);
        number17.addActionListener(buttonListener);
        number18.addActionListener(buttonListener);
        number19.addActionListener(buttonListener);
        number20.addActionListener(buttonListener);
        number21.addActionListener(buttonListener);
        number22.addActionListener(buttonListener);
        number23.addActionListener(buttonListener);
        number24.addActionListener(buttonListener);
        number25.addActionListener(buttonListener);
        number26.addActionListener(buttonListener);
        number27.addActionListener(buttonListener);
        number28.addActionListener(buttonListener);
        number29.addActionListener(buttonListener);
        number30.addActionListener(buttonListener);
        number31.addActionListener(buttonListener);
        number32.addActionListener(buttonListener);
        number33.addActionListener(buttonListener);
        number34.addActionListener(buttonListener);
        number35.addActionListener(buttonListener);
        number36.addActionListener(buttonListener);
        
        row1.addActionListener(buttonListener);
    	row2.addActionListener(buttonListener);
    	row3.addActionListener(buttonListener);
    	
    	group1_12.addActionListener(buttonListener);
    	group13_24.addActionListener(buttonListener);
    	group25_36.addActionListener(buttonListener);
    	
    	group1_18.addActionListener(buttonListener);
    	group19_36.addActionListener(buttonListener);
    	
    	even.addActionListener(buttonListener);
    	odd.addActionListener(buttonListener);
    	
    	red.addActionListener(buttonListener);
    	black.addActionListener(buttonListener);
    	
    	
        // ---------- Frame functions ----------
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
    	
    	
    	rouletteWin = newGame.spin();
    	if(0 <= rouletteWin.getNumber() && rouletteWin.getNumber() <= 12){
			mysteryRouletteWin = newGame.playMysteryRoulette(rouletteWin)[0]; // Card 1
			card = 1;
		}else if(13 <= rouletteWin.getNumber() && rouletteWin.getNumber() <= 24){
			mysteryRouletteWin = newGame.playMysteryRoulette(rouletteWin)[1]; // Card 2
			card = 2;
		}else if(25 <= rouletteWin.getNumber() && rouletteWin.getNumber() <= 36){
			mysteryRouletteWin = newGame.playMysteryRoulette(rouletteWin)[2]; // Card 3
			card = 3;
		}
        
        ActionListener listener = new AbstractAction() {
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e) {
			try {
				if(rotation == 15 && position[index] == rouletteWin.getNumber()){
					System.out.println("Roulette Wheel!");
					System.out.println("Winning Number: " + rouletteWin.getNumber() + " " + rouletteWin.getColor());
					System.out.println();
					System.out.println("Mystery Roulette Card!");
					System.out.println("Winning Number: " + mysteryRouletteWin.getNumber() + " " + mysteryRouletteWin.getColor());
					System.out.println();
					roulettePanel.rouletteAnnouncement(rouletteWin);
			    	mysteryRoulettePanel.mysteryRouletteAnnouncement(mysteryRouletteWin);
			    	
					timer.stop();
					
					card1.setIcon(img3);
					card2.setIcon(img3);
					card3.setIcon(img3);
					
					ImageIcon img4 = new ImageIcon("/Users/jordi.j.mejiacruz/git/repository/CISC191Project_MysteryRouletteCasino/src/Roulette_Imgs/MysteryRouletteCards/FrontCard_" + mysteryRouletteWin.getNumber() + ".png");
					
					if(card == 1){
						timer.restart();
						card1.setIcon(img4);
						
						
						TimeUnit.SECONDS.sleep(5);
						
						rotation = 0;
						rouletteWin = newGame.spin();
				    	if(0 <= rouletteWin.getNumber() && rouletteWin.getNumber() <= 12){
				    		mysteryRouletteWin = newGame.playMysteryRoulette(rouletteWin)[0]; // Card 1
							card = 1;
						}else if(13 <= rouletteWin.getNumber() && rouletteWin.getNumber() <= 24){
							mysteryRouletteWin = newGame.playMysteryRoulette(rouletteWin)[1]; // Card 2
							card = 2;
						}else if(25 <= rouletteWin.getNumber() && rouletteWin.getNumber() <= 36){
							mysteryRouletteWin = newGame.playMysteryRoulette(rouletteWin)[2]; // Card 3
							card = 3;
						}
				    	
				    	distributeWins(rouletteWin, mysteryRouletteWin);
				    	
				    	
				    	p[0].refreshBetOnRoulette();
				    	p[1].refreshBetOnRoulette();
				    	p[2].refreshBetOnRoulette();
				    	p[3].refreshBetOnRoulette();
						
				    	totalBet1 = 0; 
				    	totalBet2 = 0;
				    	totalBet3 = 0;
				    	totalBet4 = 0;
				    	
				    	bettingP1.setText("Betting: " + totalBet1);
				    	bettingP2.setText("Betting: " + totalBet2);
				    	bettingP3.setText("Betting: " + totalBet3);
				    	bettingP4.setText("Betting: " + totalBet4);
					}else if(card == 2){
						timer.restart();
						card2.setIcon(img4);
						
						TimeUnit.SECONDS.sleep(5);
						
						
						rotation = 0;
						
						rouletteWin = newGame.spin();
				    	if(0 <= rouletteWin.getNumber() && rouletteWin.getNumber() <= 12){
				    		mysteryRouletteWin = newGame.playMysteryRoulette(rouletteWin)[0]; // Card 1
							card = 1;
						}else if(13 <= rouletteWin.getNumber() && rouletteWin.getNumber() <= 24){
							mysteryRouletteWin = newGame.playMysteryRoulette(rouletteWin)[1]; // Card 2
							card = 2;
						}else if(25 <= rouletteWin.getNumber() && rouletteWin.getNumber() <= 36){
							mysteryRouletteWin = newGame.playMysteryRoulette(rouletteWin)[2]; // Card 3
							card = 3;
						}
				    	
				    	distributeWins(rouletteWin, mysteryRouletteWin);
				    	
				    	p[0].refreshBetOnRoulette();
				    	p[1].refreshBetOnRoulette();
				    	p[2].refreshBetOnRoulette();
				    	p[3].refreshBetOnRoulette();
				    	
				    	totalBet1 = 0;
				    	totalBet2 = 0;
				    	totalBet3 = 0;
				    	totalBet4 = 0;
				    	
				    	bettingP1.setText("Betting: " + totalBet1);
				    	bettingP2.setText("Betting: " + totalBet2);
				    	bettingP3.setText("Betting: " + totalBet3);
				    	bettingP4.setText("Betting: " + totalBet4);
					}else if(card == 3){
						timer.restart();
						card3.setIcon(img4);
						
						TimeUnit.SECONDS.sleep(5);
						
						
						rotation = 0;
						
						rouletteWin = newGame.spin();
				    	if(0 <= rouletteWin.getNumber() && rouletteWin.getNumber() <= 12){
				    		mysteryRouletteWin = newGame.playMysteryRoulette(rouletteWin)[0]; // Card 1
							card = 1;
						}else if(13 <= rouletteWin.getNumber() && rouletteWin.getNumber() <= 24){
							mysteryRouletteWin = newGame.playMysteryRoulette(rouletteWin)[1]; // Card 2
							card = 2;
						}else if(25 <= rouletteWin.getNumber() && rouletteWin.getNumber() <= 36){
							mysteryRouletteWin = newGame.playMysteryRoulette(rouletteWin)[2]; // Card 3
							card = 3;
						}
						
				    	distributeWins(rouletteWin, mysteryRouletteWin);
				    	
				    	p[0].refreshBetOnRoulette();
				    	p[1].refreshBetOnRoulette();
				    	p[2].refreshBetOnRoulette();
				    	p[3].refreshBetOnRoulette();
				    	
				    	totalBet1 = 0;
				    	totalBet2 = 0;
				    	totalBet3 = 0;
				    	totalBet4 = 0;
				    	
				    	bettingP1.setText("Betting: " + totalBet1);
				    	bettingP2.setText("Betting: " + totalBet2);
				    	bettingP3.setText("Betting: " + totalBet3);
				    	bettingP4.setText("Betting: " + totalBet4);
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
        
        public PlayerPanel() {}
    }
    
    private class AnnouncementPanel extends JPanel {
        private static final long serialVersionUID = 1L;
        
        private Font font= new Font("Monospaced", Font.ITALIC, 30); 
        
        public void rouletteAnnouncement(Roulette rouletteWin) {
        	if(rouletteWin != null) {
        		JLabel announcement = new JLabel("Roulette Wheel Win!", SwingConstants.CENTER);
                announcement.setForeground(new Color(206, 194, 144));
                announcement.setFont(font);
                announcement.setBounds(70, 35, 560, 30);
            	ImageIcon win = new ImageIcon("/Users/jordi.j.mejiacruz/git/repository/CISC191Project_MysteryRouletteCasino/src/Roulette_Imgs/PreviousRouletteIcons/Square_" + rouletteWin.getNumber() + ".png");
            	
            	rWin.setIcon(win);
            	rWin.setBounds(0, 25, 50, 50);
            	
            	add(announcement);
            	add(rWin);
        	}
        }
        
        public void mysteryRouletteAnnouncement(Roulette mysteryRouletteWin) {
        	if(mysteryRouletteWin != null) {
        		JLabel announcement = new JLabel("Mystery Roulette Card Win!", SwingConstants.CENTER);
                announcement.setForeground(new Color(206, 194, 144));
                announcement.setFont(font);
                announcement.setBounds(20, 35, 560, 30);
            	ImageIcon win = new ImageIcon("/Users/jordi.j.mejiacruz/git/repository/CISC191Project_MysteryRouletteCasino/src/Roulette_Imgs/PreviousRouletteIcons/Square_" + mysteryRouletteWin.getNumber() + ".png");
            	
            	mrWin.setIcon(win);
            	mrWin.setBounds(600, 25, 50, 50);
            	
            	add(announcement);
            	add(mrWin);
        	}
        }
    }

    
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	if(e.getSource() == gameMode) {
        		if(gameMode.getText().equals("Roulette!")) {
        			gameMode.setText("Mystery Roulette!");
        		}else if (gameMode.getText().equals("Mystery Roulette!")) {
        			gameMode.setText("Roulette!");
        		}
        	}
        	
        	if(e.getSource() == player1) {
        		playerPlaying = 0;
        		player1.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        		player2.setBorder(null);
        		player3.setBorder(null);
        		player4.setBorder(null);
        	}else if(e.getSource() == player2) {
        		playerPlaying = 1;
        		player1.setBorder(null);
        		player2.setBorder(BorderFactory.createLineBorder(Color.RED));
        		player3.setBorder(null);
        		player4.setBorder(null);
        	}else if(e.getSource() == player3) {
        		playerPlaying = 2;
        		player1.setBorder(null);
        		player2.setBorder(null);
        		player3.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        		player4.setBorder(null);
        	}else if(e.getSource() == player4) {
        		playerPlaying = 3;
        		player1.setBorder(null);
        		player2.setBorder(null);
        		player3.setBorder(null);
        		player4.setBorder(BorderFactory.createLineBorder(Color.RED));
        	}
        	
        	if(e.getSource() == bet1) {
        		addChip = 1;
        		bet.setText("Betting Chip: 1");
        	}else if(e.getSource() == bet5) {
            	addChip = 5;
            	bet.setText("Betting Chip: 5");
            }else if(e.getSource() == bet10) {
            	addChip = 10;
            	bet.setText("Betting Chip: 10");
            }else if(e.getSource() == bet25) {
            	addChip = 25;
            	bet.setText("Betting Chip: 25");
            }else if(e.getSource() == bet100) {
            	addChip = 100;
            	bet.setText("Betting Chip: 100");
            }else if(e.getSource() == bet500) {
            	addChip = 500;
            	bet.setText("Betting Chip: 500");
            }
        	
        	if(e.getSource() == number0) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(0, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(0, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(0, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(0, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(0, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(0, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(0, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(0, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        				p[3].setBetOnMysteryRoulette(0, addChip);
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number1) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(1, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(1, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(1, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(1, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(1, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(1, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(1, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(1, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number2) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(2, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(2, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(2, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(2, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(2, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(2, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(2, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(2, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number3) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(3, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(3, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(3, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(3, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(3, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(3, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(3, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(3, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number4) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(4, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(4, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(4, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(4, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(4, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(4, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(4, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(4, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number5) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(5, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(5, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(5, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(5, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(5, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(5, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(5, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(5, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number6) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(6, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(6, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(6, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(6, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(6, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(6, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(6, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(6, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number7) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(7, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(7, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(7, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(7, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(7, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(7, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(7, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(7, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number8) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(8, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(8, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(8, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(8, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(8, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(8, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(8, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(8, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number9) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(9, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(9, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(9, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(9, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(9, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(9, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(9, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(9, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number10) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(10, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(10, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(10, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(10, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(10, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(10, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(10, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(10, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number11) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(11, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(11, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(11, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(11, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(11, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(11, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(11, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(11, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number12) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(12, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(12, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(12, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(12, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(12, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(12, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(12, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(12, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number13) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(13, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(13, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(13, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(13, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(13, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(13, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(13, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(13, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number14) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(14, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(14, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(14, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(14, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(14, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(14, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(14, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(14, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number15) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(15, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(15, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(15, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(15, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(15, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(15, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(15, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(15, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number16) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(16, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(16, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(16, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(16, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(16, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(16, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(16, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(16, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number17) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(17, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(17, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(17, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(17, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(17, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(17, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(17, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(17, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number18) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(18, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(18, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(18, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(18, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(18, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(18, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(18, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(18, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number19) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(19, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(19, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(19, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(19, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(19, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(19, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(19, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(19, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number20) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(20, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(20, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(20, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(20, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(20, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(20, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(20, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(20, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number21) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(21, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(21, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(21, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(21, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(21, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(21, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(21, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(21, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number22) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(22, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(22, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(22, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(22, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(22, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(22, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(22, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(22, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number23) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(23, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(23, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(23, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(23, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(23, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(23, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(23, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(23, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number24) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(24, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(24, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(24, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(24, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(24, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(24, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(24, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(24, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number25) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(25, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(25, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(25, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(25, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(25, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(25, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(25, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(25, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number26) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(26, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(26, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(26, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(26, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(26, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(26, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(26, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(26, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number27) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(27, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(27, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(27, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(27, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(27, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(27, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(27, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(27, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number28) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(28, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(28, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(28, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(28, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(28, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(28, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(28, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(28, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number29) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(29, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(29, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(29, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(29, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(29, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(29, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(29, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(29, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number30) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(30, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(30, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(30, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(30, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(30, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(30, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(30, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(30, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number31) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(31, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(31, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(31, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(31, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(31, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(31, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(31, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(31, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number32) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(32, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(32, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(32, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(32, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(32, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(32, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(32, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(32, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number33) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(33, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(33, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(33, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(33, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(33, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(33, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(33, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(33, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number34) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(34, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(34, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(34, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(34, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(34, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(34, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(34, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(34, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number35) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(35, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(35, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(35, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(35, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(35, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(35, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(35, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(35, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == number36) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(36, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(36, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(36, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(36, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(36, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(36, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(36, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(36, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == row1) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(37, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(37, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(37, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(37, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(37, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(37, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(37, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(37, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == row2) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(38, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(38, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(38, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(38, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(38, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(38, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(38, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(38, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == row3) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(39, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(39, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(39, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(39, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(39, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(39, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(39, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(39, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == group1_12) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(40, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(40, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(40, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(40, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(40, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(40, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(40, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(40, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == group13_24) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(41, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(41, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(41, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(41, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(41, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(41, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(41, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(41, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == group25_36) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(42, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(42, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(42, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(42, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(42, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(42, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(42, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(42, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == group1_18) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(43, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(43, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(43, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(43, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(43, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(43, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(43, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(43, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == group19_36) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(44, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(44, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(44, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(44, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(44, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(44, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(44, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(44, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == even) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(45, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(45, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(45, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(45, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(45, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(45, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(45, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(45, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == odd) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(46, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(46, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(46, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(46, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(46, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(46, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(46, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(46, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == red) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(47, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(47, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(47, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(47, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(47, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(47, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(47, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(47, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}else if(e.getSource() == black) {
        		if(playerPlaying == -1) {
        			bettingP1.setText("Select Player Icon to Bet");
        			bettingP2.setText("Select Player Icon to Bet");
        			bettingP3.setText("Select Player Icon to Bet");
        			bettingP4.setText("Select Player Icon to Bet");
        		}else if(playerPlaying == 0) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnRoulette(48, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[0].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[0].setBetOnMysteryRoulette(48, addChip);
        					p[0].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet1 += addChip;
        			bettingP1.setText("Betting: " + totalBet1);
        		}else if(playerPlaying == 1) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnRoulette(48, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[1].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[1].setBetOnMysteryRoulette(48, addChip);
        					p[1].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet2 += addChip;
        			bettingP2.setText("Betting: " + totalBet2);
        		}else if(playerPlaying == 2) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnRoulette(48, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[2].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[2].setBetOnMysteryRoulette(48, addChip);
        					p[2].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet3 += addChip;
        			bettingP3.setText("Betting: " + totalBet3);
        		}else if(playerPlaying == 3) {
        			if(gameMode.getText().equals("Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnRoulette(48, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}else if(gameMode.getText().equals("Mystery Roulette!")) {
        				if(addChip > p[3].getBankAccount().getBalance()) {
        					bettingP1.setText("Insufficient Funds");
        				}else {
        					p[3].setBetOnMysteryRoulette(48, addChip);
        					p[3].getBankAccount().loss(addChip);
        				}
        			}
        			
        			totalBet4 += addChip;
        			bettingP4.setText("Betting: " + totalBet4);
        		}
        	}
        }
    }
    
    private class TextFieldListener implements ActionListener {
        private String textInput1;
        private String textInput2;
        private String textInput3;
        private String textInput4;
        private int numberInput1;
        private int numberInput2;
        private int numberInput3;
        private int numberInput4;
    	
        @Override
        public void actionPerformed(ActionEvent e) {
        	if(e.getSource() == answerP1) {
        		if(questionP1.getText().equals("P1 - Enter Money!")) {
        			textInput1 = answerP1.getText();
        			if(isInteger(textInput1)) {
                		numberInput1 = Integer.parseInt(textInput1);
                		responseP1.setText("Betting Money: " + numberInput1);
                		p[0].getBankAccount().setBalance(numberInput1);
                		questionP1.setText("Add Betting Money!");
        			}else {
        				responseP1.setText("Please input Positive Integer!");
        			}
        		}else if(questionP1.getText().equals("Add Betting Money!")) {
        			textInput1 = answerP1.getText();
        			if(isInteger(textInput1)) {
                		numberInput1 = Integer.parseInt(textInput1);
                		p[0].getBankAccount().deposit(numberInput1);
                		responseP1.setText("Betting Money: " + p[0].getBankAccount().getBalance());
        			}else {
        				responseP1.setText("Please input Positive Integer!");
        			}
        		}
        	}else if(e.getSource() == answerP2) {
        		if(questionP2.getText().equals("P2 - Enter Money!")) {
        			textInput2 = answerP2.getText();
        			if(isInteger(textInput2)) {
        				numberInput2 = Integer.parseInt(textInput2);
                		responseP2.setText("Betting Money: " + numberInput2);
                		p[1].getBankAccount().setBalance(numberInput2);
                		questionP2.setText("Add Betting Money!");
        			}else {
        				responseP2.setText("Please input Positive Integer!");
        			}
        		}else if(questionP2.getText().equals("Add Betting Money!")) {
        			textInput2 = answerP2.getText();
        			if(isInteger(textInput2)) {
                		numberInput2 = Integer.parseInt(textInput2);
                		p[1].getBankAccount().deposit(numberInput2);
                		responseP2.setText("Betting Money: " + p[1].getBankAccount().getBalance());
        			}else {
        				responseP2.setText("Please input Positive Integer!");
        			}
        		}
        	}else if(e.getSource() == answerP3) {
        		if(questionP3.getText().equals("P3 - Enter Money!")) {
        			textInput3 = answerP3.getText();
        			if(isInteger(textInput3)) {
        				numberInput3 = Integer.parseInt(textInput3);
                		responseP3.setText("Betting Money: " + numberInput3);
                		p[2].getBankAccount().setBalance(numberInput3);
                		questionP3.setText("Add Betting Money!");
        			}else {
        				responseP3.setText("Please input Positive Integer!");
        			}
        		}else if(questionP3.getText().equals("Add Betting Money!")) {
        			textInput3 = answerP3.getText();
        			if(isInteger(textInput3)) {
                		numberInput3 = Integer.parseInt(textInput3);
                		p[2].getBankAccount().deposit(numberInput3);
                		responseP3.setText("Betting Money: " + p[2].getBankAccount().getBalance());
        			}else {
        				responseP3.setText("Please input Positive Integer!");
        			}
        		}
        	}else if(e.getSource() == answerP4) {
        		if(questionP4.getText().equals("P4 - Enter Money!")) {
        			textInput4 = answerP4.getText();
        			if(isInteger(textInput4)) {
        				numberInput4 = Integer.parseInt(textInput4);
                		responseP4.setText("Betting Money: " + numberInput4);
                		p[3].getBankAccount().setBalance(numberInput4);
                		questionP4.setText("Add Betting Money!");
        			}else {
        				responseP4.setText("Please input Positive Integer!");
        			}
        		}else if(questionP4.getText().equals("Add Betting Money!")) {
        			textInput4 = answerP4.getText();
        			if(isInteger(textInput4)) {
                		numberInput4 = Integer.parseInt(textInput4);
                		p[3].getBankAccount().deposit(numberInput4);
                		responseP4.setText("Betting Money: " + p[3].getBankAccount().getBalance());
        			}else {
        				responseP4.setText("Please input Positive Integer!");
        			}
        		}
        	}
        }
    }
    
    public static boolean inRow(int row, int winNumber) {
    	int[] r1 = {1,4,7,10,13,16,19,22,25,28,31,34};
	    int[] r2 = {2,5,8,11,14,17,20,23,26,29,32,35};
	    int[] r3 = {3,6,9,12,15,18,21,24,27,30,33,36};
    	
    	
    	if(row == 1) {
    		for(int i = 0; i < 12; i++) {
        		if(winNumber == r1[i]) {
        			return true;
        		}
        	}
    	}else if(row == 2) {
    		for(int i = 0; i < 12; i++) {
        		if(winNumber == r2[i]) {
        			return true;
        		}
        	}
    	}else if(row == 3) {
    		for(int i = 0; i < 12; i++) {
        		if(winNumber == r3[i]) {
        			return true;
        		}
        	}
    	}
    	
    	return false;
    }
    
    public static boolean isInteger(String input) {
    	if(input.isEmpty()) {
    		return false;
    	}else {
    		for(int i = 0; i < input.length(); i++) {
    			if (!Character.isDigit(input.charAt(i))) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    public static void distributeWins(Roulette rouletteWin, Roulette mysteryRouletteWin) {
    	if(rouletteWin.getNumber() == 0) {
    		p[0].getBetOnRoulette()[0] *= 36;
    		p[1].getBetOnRoulette()[0] *= 36;
    		p[2].getBetOnRoulette()[0] *= 36;
    		p[3].getBetOnRoulette()[0] *= 36;
    	}else if(rouletteWin.getNumber() != 0) {
    		p[0].getBetOnRoulette()[0] = 0;
    		p[1].getBetOnRoulette()[0] = 0;
    		p[2].getBetOnRoulette()[0] = 0;
    		p[3].getBetOnRoulette()[0] = 0;
    	}else if(rouletteWin.getNumber() == 1) {
    		p[0].getBetOnRoulette()[1] *= 36;
    		p[1].getBetOnRoulette()[1] *= 36;
    		p[2].getBetOnRoulette()[1] *= 36;
    		p[3].getBetOnRoulette()[1] *= 36;
    	}else if(rouletteWin.getNumber() != 1) {
    		p[0].getBetOnRoulette()[1] = 0;
    		p[1].getBetOnRoulette()[1] = 0;
    		p[2].getBetOnRoulette()[1] = 0;
    		p[3].getBetOnRoulette()[1] = 0;
    	}else if(rouletteWin.getNumber() == 2) {
    		p[0].getBetOnRoulette()[2] *= 36;
    		p[1].getBetOnRoulette()[2] *= 36;
    		p[2].getBetOnRoulette()[2] *= 36;
    		p[3].getBetOnRoulette()[2] *= 36;
    	}else if(rouletteWin.getNumber() != 2) {
    		p[0].getBetOnRoulette()[2] = 0;
    		p[1].getBetOnRoulette()[2] = 0;
    		p[2].getBetOnRoulette()[2] = 0;
    		p[3].getBetOnRoulette()[2] = 0;
    	}else if(rouletteWin.getNumber() == 3) {
    		p[0].getBetOnRoulette()[3] *= 36;
    		p[1].getBetOnRoulette()[3] *= 36;
    		p[2].getBetOnRoulette()[3] *= 36;
    		p[3].getBetOnRoulette()[3] *= 36;
    	}else if(rouletteWin.getNumber() != 3) {
    		p[0].getBetOnRoulette()[3] = 0;
    		p[1].getBetOnRoulette()[3] = 0;
    		p[2].getBetOnRoulette()[3] = 0;
    		p[3].getBetOnRoulette()[3] = 0;
    	}else if(rouletteWin.getNumber() == 4) {
    		p[0].getBetOnRoulette()[4] *= 36;
    		p[1].getBetOnRoulette()[4] *= 36;
    		p[2].getBetOnRoulette()[4] *= 36;
    		p[3].getBetOnRoulette()[4] *= 36;
    	}else if(rouletteWin.getNumber() != 4) {
    		p[0].getBetOnRoulette()[4] = 0;
    		p[1].getBetOnRoulette()[4] = 0;
    		p[2].getBetOnRoulette()[4] = 0;
    		p[3].getBetOnRoulette()[4] = 0;
    	}else if(rouletteWin.getNumber() == 5) {
    		p[0].getBetOnRoulette()[5] *= 36;
    		p[1].getBetOnRoulette()[5] *= 36;
    		p[2].getBetOnRoulette()[5] *= 36;
    		p[3].getBetOnRoulette()[5] *= 36;
    	}else if(rouletteWin.getNumber() != 5) {
    		p[0].getBetOnRoulette()[5] = 0;
    		p[1].getBetOnRoulette()[5] = 0;
    		p[2].getBetOnRoulette()[5] = 0;
    		p[3].getBetOnRoulette()[5] = 0;
    	}else if(rouletteWin.getNumber() == 6) {
    		p[0].getBetOnRoulette()[6] *= 36;
    		p[1].getBetOnRoulette()[6] *= 36;
    		p[2].getBetOnRoulette()[6] *= 36;
    		p[3].getBetOnRoulette()[6] *= 36;
    	}else if(rouletteWin.getNumber() != 6) {
    		p[0].getBetOnRoulette()[6] = 0;
    		p[1].getBetOnRoulette()[6] = 0;
    		p[2].getBetOnRoulette()[6] = 0;
    		p[3].getBetOnRoulette()[6] = 0;
    	}else if(rouletteWin.getNumber() == 7) {
    		p[0].getBetOnRoulette()[7] *= 36;
    		p[1].getBetOnRoulette()[7] *= 36;
    		p[2].getBetOnRoulette()[7] *= 36;
    		p[3].getBetOnRoulette()[7] *= 36;
    	}else if(rouletteWin.getNumber() != 7) {
    		p[0].getBetOnRoulette()[7] = 0;
    		p[1].getBetOnRoulette()[7] = 0;
    		p[2].getBetOnRoulette()[7] = 0;
    		p[3].getBetOnRoulette()[7] = 0;
    	}else if(rouletteWin.getNumber() == 8) {
    		p[0].getBetOnRoulette()[8] *= 36;
    		p[1].getBetOnRoulette()[8] *= 36;
    		p[2].getBetOnRoulette()[8] *= 36;
    		p[3].getBetOnRoulette()[8] *= 36;
    	}else if(rouletteWin.getNumber() != 8) {
    		p[0].getBetOnRoulette()[8] = 0;
    		p[1].getBetOnRoulette()[8] = 0;
    		p[2].getBetOnRoulette()[8] = 0;
    		p[3].getBetOnRoulette()[8] = 0;
    	}else if(rouletteWin.getNumber() == 9) {
    		p[0].getBetOnRoulette()[9] *= 36;
    		p[1].getBetOnRoulette()[9] *= 36;
    		p[2].getBetOnRoulette()[9] *= 36;
    		p[3].getBetOnRoulette()[9] *= 36;
    	}else if(rouletteWin.getNumber() != 9) {
    		p[0].getBetOnRoulette()[9] = 0;
    		p[1].getBetOnRoulette()[9] = 0;
    		p[2].getBetOnRoulette()[9] = 0;
    		p[3].getBetOnRoulette()[9] = 0;
    	}else if(rouletteWin.getNumber() == 10) {
    		p[0].getBetOnRoulette()[10] *= 36;
    		p[1].getBetOnRoulette()[10] *= 36;
    		p[2].getBetOnRoulette()[10] *= 36;
    		p[3].getBetOnRoulette()[10] *= 36;
    	}else if(rouletteWin.getNumber() != 10) {
    		p[0].getBetOnRoulette()[10] = 0;
    		p[1].getBetOnRoulette()[10] = 0;
    		p[2].getBetOnRoulette()[10] = 0;
    		p[3].getBetOnRoulette()[10] = 0;
    	}else if(rouletteWin.getNumber() == 11) {
    		p[0].getBetOnRoulette()[11] *= 36;
    		p[1].getBetOnRoulette()[11] *= 36;
    		p[2].getBetOnRoulette()[11] *= 36;
    		p[3].getBetOnRoulette()[11] *= 36;
    	}else if(rouletteWin.getNumber() != 11) {
    		p[0].getBetOnRoulette()[11] = 0;
    		p[1].getBetOnRoulette()[11] = 0;
    		p[2].getBetOnRoulette()[11] = 0;
    		p[3].getBetOnRoulette()[11] = 0;
    	}else if(rouletteWin.getNumber() == 12) {
    		p[0].getBetOnRoulette()[12] *= 36;
    		p[1].getBetOnRoulette()[12] *= 36;
    		p[2].getBetOnRoulette()[12] *= 36;
    		p[3].getBetOnRoulette()[12] *= 36;
    	}else if(rouletteWin.getNumber() != 12) {
    		p[0].getBetOnRoulette()[12] = 0;
    		p[1].getBetOnRoulette()[12] = 0;
    		p[2].getBetOnRoulette()[12] = 0;
    		p[3].getBetOnRoulette()[12] = 0;
    	}else if(rouletteWin.getNumber() == 13) {
    		p[0].getBetOnRoulette()[13] *= 36;
    		p[1].getBetOnRoulette()[13] *= 36;
    		p[2].getBetOnRoulette()[13] *= 36;
    		p[3].getBetOnRoulette()[13] *= 36;
    	}else if(rouletteWin.getNumber() != 13) {
    		p[0].getBetOnRoulette()[13] = 0;
    		p[1].getBetOnRoulette()[13] = 0;
    		p[2].getBetOnRoulette()[13] = 0;
    		p[3].getBetOnRoulette()[13] = 0;
    	}else if(rouletteWin.getNumber() == 14) {
    		p[0].getBetOnRoulette()[14] *= 36;
    		p[1].getBetOnRoulette()[14] *= 36;
    		p[2].getBetOnRoulette()[14] *= 36;
    		p[3].getBetOnRoulette()[14] *= 36;
    	}else if(rouletteWin.getNumber() != 14) {
    		p[0].getBetOnRoulette()[14] = 0;
    		p[1].getBetOnRoulette()[14] = 0;
    		p[2].getBetOnRoulette()[14] = 0;
    		p[3].getBetOnRoulette()[14] = 0;
    	}else if(rouletteWin.getNumber() == 15) {
    		p[0].getBetOnRoulette()[15] *= 36;
    		p[1].getBetOnRoulette()[15] *= 36;
    		p[2].getBetOnRoulette()[15] *= 36;
    		p[3].getBetOnRoulette()[15] *= 36;
    	}else if(rouletteWin.getNumber() != 15) {
    		p[0].getBetOnRoulette()[15] = 0;
    		p[1].getBetOnRoulette()[15] = 0;
    		p[2].getBetOnRoulette()[15] = 0;
    		p[3].getBetOnRoulette()[15] = 0;
    	}else if(rouletteWin.getNumber() == 16) {
    		p[0].getBetOnRoulette()[16] *= 36;
    		p[1].getBetOnRoulette()[16] *= 36;
    		p[2].getBetOnRoulette()[16] *= 36;
    		p[3].getBetOnRoulette()[16] *= 36;
    	}else if(rouletteWin.getNumber() != 16) {
    		p[0].getBetOnRoulette()[16] = 0;
    		p[1].getBetOnRoulette()[16] = 0;
    		p[2].getBetOnRoulette()[16] = 0;
    		p[3].getBetOnRoulette()[16] = 0;
    	}else if(rouletteWin.getNumber() == 17) {
    		p[0].getBetOnRoulette()[17] *= 36;
    		p[1].getBetOnRoulette()[17] *= 36;
    		p[2].getBetOnRoulette()[17] *= 36;
    		p[3].getBetOnRoulette()[17] *= 36;
    	}else if(rouletteWin.getNumber() != 17) {
    		p[0].getBetOnRoulette()[17] = 0;
    		p[1].getBetOnRoulette()[17] = 0;
    		p[2].getBetOnRoulette()[17] = 0;
    		p[3].getBetOnRoulette()[17] = 0;
    	}else if(rouletteWin.getNumber() == 18) {
    		p[0].getBetOnRoulette()[18] *= 36;
    		p[1].getBetOnRoulette()[18] *= 36;
    		p[2].getBetOnRoulette()[18] *= 36;
    		p[3].getBetOnRoulette()[18] *= 36;
    	}else if(rouletteWin.getNumber() != 18) {
    		p[0].getBetOnRoulette()[18] = 0;
    		p[1].getBetOnRoulette()[18] = 0;
    		p[2].getBetOnRoulette()[18] = 0;
    		p[3].getBetOnRoulette()[18] = 0;
    	}else if(rouletteWin.getNumber() == 19) {
    		p[0].getBetOnRoulette()[19] *= 36;
    		p[1].getBetOnRoulette()[19] *= 36;
    		p[2].getBetOnRoulette()[19] *= 36;
    		p[3].getBetOnRoulette()[19] *= 36;
    	}else if(rouletteWin.getNumber() != 19) {
    		p[0].getBetOnRoulette()[19] = 0;
    		p[1].getBetOnRoulette()[19] = 0;
    		p[2].getBetOnRoulette()[19] = 0;
    		p[3].getBetOnRoulette()[19] = 0;
    	}else if(rouletteWin.getNumber() == 20) {
    		p[0].getBetOnRoulette()[20] *= 36;
    		p[1].getBetOnRoulette()[20] *= 36;
    		p[2].getBetOnRoulette()[20] *= 36;
    		p[3].getBetOnRoulette()[20] *= 36;
    	}else if(rouletteWin.getNumber() != 20) {
    		p[0].getBetOnRoulette()[20] = 0;
    		p[1].getBetOnRoulette()[20] = 0;
    		p[2].getBetOnRoulette()[20] = 0;
    		p[3].getBetOnRoulette()[20] = 0;
    	}else if(rouletteWin.getNumber() == 21) {
    		p[0].getBetOnRoulette()[21] *= 36;
    		p[1].getBetOnRoulette()[21] *= 36;
    		p[2].getBetOnRoulette()[21] *= 36;
    		p[3].getBetOnRoulette()[21] *= 36;
    	}else if(rouletteWin.getNumber() != 21) {
    		p[0].getBetOnRoulette()[21] = 0;
    		p[1].getBetOnRoulette()[21] = 0;
    		p[2].getBetOnRoulette()[21] = 0;
    		p[3].getBetOnRoulette()[21] = 0;
    	}else if(rouletteWin.getNumber() == 22) {
    		p[0].getBetOnRoulette()[22] *= 36;
    		p[1].getBetOnRoulette()[22] *= 36;
    		p[2].getBetOnRoulette()[22] *= 36;
    		p[3].getBetOnRoulette()[22] *= 36;
    	}else if(rouletteWin.getNumber() != 22) {
    		p[0].getBetOnRoulette()[22] = 0;
    		p[1].getBetOnRoulette()[22] = 0;
    		p[2].getBetOnRoulette()[22] = 0;
    		p[3].getBetOnRoulette()[22] = 0;
    	}else if(rouletteWin.getNumber() == 23) {
    		p[0].getBetOnRoulette()[23] *= 36;
    		p[1].getBetOnRoulette()[23] *= 36;
    		p[2].getBetOnRoulette()[23] *= 36;
    		p[3].getBetOnRoulette()[23] *= 36;
    	}else if(rouletteWin.getNumber() != 23) {
    		p[0].getBetOnRoulette()[23] = 0;
    		p[1].getBetOnRoulette()[23] = 0;
    		p[2].getBetOnRoulette()[23] = 0;
    		p[3].getBetOnRoulette()[23] = 0;
    	}else if(rouletteWin.getNumber() == 24) {
    		p[0].getBetOnRoulette()[24] *= 36;
    		p[1].getBetOnRoulette()[24] *= 36;
    		p[2].getBetOnRoulette()[24] *= 36;
    		p[3].getBetOnRoulette()[24] *= 36;
    	}else if(rouletteWin.getNumber() != 24) {
    		p[0].getBetOnRoulette()[24] = 0;
    		p[1].getBetOnRoulette()[24] = 0;
    		p[2].getBetOnRoulette()[24] = 0;
    		p[3].getBetOnRoulette()[24] = 0;
    	}else if(rouletteWin.getNumber() == 25) {
    		p[0].getBetOnRoulette()[25] *= 36;
    		p[1].getBetOnRoulette()[25] *= 36;
    		p[2].getBetOnRoulette()[25] *= 36;
    		p[3].getBetOnRoulette()[25] *= 36;
    	}else if(rouletteWin.getNumber() != 25) {
    		p[0].getBetOnRoulette()[25] = 0;
    		p[1].getBetOnRoulette()[25] = 0;
    		p[2].getBetOnRoulette()[25] = 0;
    		p[3].getBetOnRoulette()[25] = 0;
    	}else if(rouletteWin.getNumber() == 26) {
    		p[0].getBetOnRoulette()[26] *= 36;
    		p[1].getBetOnRoulette()[26] *= 36;
    		p[2].getBetOnRoulette()[26] *= 36;
    		p[3].getBetOnRoulette()[26] *= 36;
    	}else if(rouletteWin.getNumber() != 26) {
    		p[0].getBetOnRoulette()[26] = 0;
    		p[1].getBetOnRoulette()[26] = 0;
    		p[2].getBetOnRoulette()[26] = 0;
    		p[3].getBetOnRoulette()[26] = 0;
    	}else if(rouletteWin.getNumber() == 27) {
    		p[0].getBetOnRoulette()[27] *= 36;
    		p[1].getBetOnRoulette()[27] *= 36;
    		p[2].getBetOnRoulette()[27] *= 36;
    		p[3].getBetOnRoulette()[27] *= 36;
    	}else if(rouletteWin.getNumber() != 27) {
    		p[0].getBetOnRoulette()[27] = 0;
    		p[1].getBetOnRoulette()[27] = 0;
    		p[2].getBetOnRoulette()[27] = 0;
    		p[3].getBetOnRoulette()[27] = 0;
    	}else if(rouletteWin.getNumber() == 28) {
    		p[0].getBetOnRoulette()[28] *= 36;
    		p[1].getBetOnRoulette()[28] *= 36;
    		p[2].getBetOnRoulette()[28] *= 36;
    		p[3].getBetOnRoulette()[28] *= 36;
    	}else if(rouletteWin.getNumber() != 28) {
    		p[0].getBetOnRoulette()[28] = 0;
    		p[1].getBetOnRoulette()[28] = 0;
    		p[2].getBetOnRoulette()[28] = 0;
    		p[3].getBetOnRoulette()[28] = 0;
    	}else if(rouletteWin.getNumber() == 29) {
    		p[0].getBetOnRoulette()[29] *= 36;
    		p[1].getBetOnRoulette()[29] *= 36;
    		p[2].getBetOnRoulette()[29] *= 36;
    		p[3].getBetOnRoulette()[29] *= 36;
    	}else if(rouletteWin.getNumber() != 29) {
    		p[0].getBetOnRoulette()[29] = 0;
    		p[1].getBetOnRoulette()[29] = 0;
    		p[2].getBetOnRoulette()[29] = 0;
    		p[3].getBetOnRoulette()[29] = 0;
    	}else if(rouletteWin.getNumber() == 30) {
    		p[0].getBetOnRoulette()[30] *= 36;
    		p[1].getBetOnRoulette()[30] *= 36;
    		p[2].getBetOnRoulette()[30] *= 36;
    		p[3].getBetOnRoulette()[30] *= 36;
    	}else if(rouletteWin.getNumber() != 30) {
    		p[0].getBetOnRoulette()[30] = 0;
    		p[1].getBetOnRoulette()[30] = 0;
    		p[2].getBetOnRoulette()[30] = 0;
    		p[3].getBetOnRoulette()[30] = 0;
    	}else if(rouletteWin.getNumber() == 31) {
    		p[0].getBetOnRoulette()[31] *= 36;
    		p[1].getBetOnRoulette()[31] *= 36;
    		p[2].getBetOnRoulette()[31] *= 36;
    		p[3].getBetOnRoulette()[31] *= 36;
    	}else if(rouletteWin.getNumber() != 31) {
    		p[0].getBetOnRoulette()[31] = 0;
    		p[1].getBetOnRoulette()[31] = 0;
    		p[2].getBetOnRoulette()[31] = 0;
    		p[3].getBetOnRoulette()[31] = 0;
    	}else if(rouletteWin.getNumber() == 32) {
    		p[0].getBetOnRoulette()[32] *= 36;
    		p[1].getBetOnRoulette()[32] *= 36;
    		p[2].getBetOnRoulette()[32] *= 36;
    		p[3].getBetOnRoulette()[32] *= 36;
    	}else if(rouletteWin.getNumber() != 32) {
    		p[0].getBetOnRoulette()[32] = 0;
    		p[1].getBetOnRoulette()[32] = 0;
    		p[2].getBetOnRoulette()[32] = 0;
    		p[3].getBetOnRoulette()[32] = 0;
    	}else if(rouletteWin.getNumber() == 33) {
    		p[0].getBetOnRoulette()[33] *= 36;
    		p[1].getBetOnRoulette()[33] *= 36;
    		p[2].getBetOnRoulette()[33] *= 36;
    		p[3].getBetOnRoulette()[33] *= 36;
    	}else if(rouletteWin.getNumber() != 33) {
    		p[0].getBetOnRoulette()[33] = 0;
    		p[1].getBetOnRoulette()[33] = 0;
    		p[2].getBetOnRoulette()[33] = 0;
    		p[3].getBetOnRoulette()[33] = 0;
    	}else if(rouletteWin.getNumber() == 34) {
    		p[0].getBetOnRoulette()[34] *= 36;
    		p[1].getBetOnRoulette()[34] *= 36;
    		p[2].getBetOnRoulette()[34] *= 36;
    		p[3].getBetOnRoulette()[34] *= 36;
    	}else if(rouletteWin.getNumber() != 34) {
    		p[0].getBetOnRoulette()[34] = 0;
    		p[1].getBetOnRoulette()[34] = 0;
    		p[2].getBetOnRoulette()[34] = 0;
    		p[3].getBetOnRoulette()[34] = 0;
    	}else if(rouletteWin.getNumber() == 35) {
    		p[0].getBetOnRoulette()[35] *= 36;
    		p[1].getBetOnRoulette()[35] *= 36;
    		p[2].getBetOnRoulette()[35] *= 36;
    		p[3].getBetOnRoulette()[35] *= 36;
    	}else if(rouletteWin.getNumber() != 35) {
    		p[0].getBetOnRoulette()[35] = 0;
    		p[1].getBetOnRoulette()[35] = 0;
    		p[2].getBetOnRoulette()[35] = 0;
    		p[3].getBetOnRoulette()[35] = 0;
    	}else if(rouletteWin.getNumber() == 36) {
    		p[0].getBetOnRoulette()[36] *= 36;
    		p[1].getBetOnRoulette()[36] *= 36;
    		p[2].getBetOnRoulette()[36] *= 36;
    		p[3].getBetOnRoulette()[36] *= 36;
    	}else if(rouletteWin.getNumber() != 36) {
    		p[0].getBetOnRoulette()[36] = 0;
    		p[1].getBetOnRoulette()[36] = 0;
    		p[2].getBetOnRoulette()[36] = 0;
    		p[3].getBetOnRoulette()[36] = 0;
    	}else if(inRow(1, rouletteWin.getNumber())) {
    		p[0].getBetOnRoulette()[37] *= 2;
    		p[1].getBetOnRoulette()[37] *= 2;
    		p[2].getBetOnRoulette()[37] *= 2;
    		p[3].getBetOnRoulette()[37] *= 2;
    	}else if(!inRow(1, rouletteWin.getNumber())) {
    		p[0].getBetOnRoulette()[37] = 0;
    		p[1].getBetOnRoulette()[37] = 0;
    		p[2].getBetOnRoulette()[37] = 0;
    		p[3].getBetOnRoulette()[37] = 0;
    	}else if(inRow(2, rouletteWin.getNumber())) {
    		p[0].getBetOnRoulette()[38] *= 2;
    		p[1].getBetOnRoulette()[38] *= 2;
    		p[2].getBetOnRoulette()[38] *= 2;
    		p[3].getBetOnRoulette()[38] *= 2;
    	}else if(!inRow(2, rouletteWin.getNumber())) {
    		p[0].getBetOnRoulette()[38] = 0;
    		p[1].getBetOnRoulette()[38] = 0;
    		p[2].getBetOnRoulette()[38] = 0;
    		p[3].getBetOnRoulette()[38] = 0;
    	}else if(inRow(3, rouletteWin.getNumber())) {
    		p[0].getBetOnRoulette()[39] *= 2;
    		p[1].getBetOnRoulette()[39] *= 2;
    		p[2].getBetOnRoulette()[39] *= 2;
    		p[3].getBetOnRoulette()[39] *= 2;
    	}else if(!inRow(3, rouletteWin.getNumber())) {
    		p[0].getBetOnRoulette()[39] = 0;
    		p[1].getBetOnRoulette()[39] = 0;
    		p[2].getBetOnRoulette()[39] = 0;
    		p[3].getBetOnRoulette()[39] = 0;
    	}else if(1 <= rouletteWin.getNumber() && rouletteWin.getNumber() <= 12) {
    		p[0].getBetOnRoulette()[40] *= 2;
    		p[1].getBetOnRoulette()[40] *= 2;
    		p[2].getBetOnRoulette()[40] *= 2;
    		p[3].getBetOnRoulette()[40] *= 2;
    	}else if((13 <= rouletteWin.getNumber() && rouletteWin.getNumber() <= 36) || rouletteWin.getNumber() == 0) {
    		p[0].getBetOnRoulette()[40] = 0;
    		p[1].getBetOnRoulette()[40] = 0;
    		p[2].getBetOnRoulette()[40] = 0;
    		p[3].getBetOnRoulette()[40] = 0;
    	}else if(13 <= rouletteWin.getNumber() && rouletteWin.getNumber() <= 24) {
    		p[0].getBetOnRoulette()[41] *= 2;
    		p[1].getBetOnRoulette()[41] *= 2;
    		p[2].getBetOnRoulette()[41] *= 2;
    		p[3].getBetOnRoulette()[41] *= 2;
    	}else if((0 <= rouletteWin.getNumber() && rouletteWin.getNumber() <= 12) || (25 <= rouletteWin.getNumber() && rouletteWin.getNumber() <= 36)) {
    		p[0].getBetOnRoulette()[41] = 0;
    		p[1].getBetOnRoulette()[41] = 0;
    		p[2].getBetOnRoulette()[41] = 0;
    		p[3].getBetOnRoulette()[41] = 0;
    	}else if(25 <= rouletteWin.getNumber() && rouletteWin.getNumber() <= 36) {
    		p[0].getBetOnRoulette()[42] *= 2;
    		p[1].getBetOnRoulette()[42] *= 2;
    		p[2].getBetOnRoulette()[42] *= 2;
    		p[3].getBetOnRoulette()[42] *= 2;
    	}else if(0 <= rouletteWin.getNumber() && rouletteWin.getNumber() <= 24) {
    		p[0].getBetOnRoulette()[42] = 0;
    		p[1].getBetOnRoulette()[42] = 0;
    		p[2].getBetOnRoulette()[42] = 0;
    		p[3].getBetOnRoulette()[42] = 0;
    	}else if(1 <= rouletteWin.getNumber() && rouletteWin.getNumber() <= 18) {
    		p[0].getBetOnRoulette()[43] *= 2;
    		p[1].getBetOnRoulette()[43] *= 2;
    		p[2].getBetOnRoulette()[43] *= 2;
    		p[3].getBetOnRoulette()[43] *= 2;
    	}else if(rouletteWin.getNumber() == 0 || (19 <= rouletteWin.getNumber() && rouletteWin.getNumber() <= 36)) {
    		p[0].getBetOnRoulette()[43] = 0;
    		p[1].getBetOnRoulette()[43] = 0;
    		p[2].getBetOnRoulette()[43] = 0;
    		p[3].getBetOnRoulette()[43] = 0;
    	}else if(19 <= rouletteWin.getNumber() && rouletteWin.getNumber() <= 36) {
    		p[0].getBetOnRoulette()[44] *= 2;
    		p[1].getBetOnRoulette()[44] *= 2;
    		p[2].getBetOnRoulette()[44] *= 2;
    		p[3].getBetOnRoulette()[44] *= 2;
    	}else if(0 <= rouletteWin.getNumber() && rouletteWin.getNumber() <= 18) {
    		p[0].getBetOnRoulette()[44] = 0;
    		p[1].getBetOnRoulette()[44] = 0;
    		p[2].getBetOnRoulette()[44] = 0;
    		p[3].getBetOnRoulette()[44] = 0;
    	}else if(rouletteWin.determineOddOrEven().equals("Even")) {
    		p[0].getBetOnRoulette()[45] *= 2;
    		p[1].getBetOnRoulette()[45] *= 2;
    		p[2].getBetOnRoulette()[45] *= 2;
    		p[3].getBetOnRoulette()[45] *= 2;
    	}else if(!rouletteWin.determineOddOrEven().equals("Even")) {
    		p[0].getBetOnRoulette()[45] = 0;
    		p[1].getBetOnRoulette()[45] = 0;
    		p[2].getBetOnRoulette()[45] = 0;
    		p[3].getBetOnRoulette()[45] = 0;
    	}else if(rouletteWin.determineOddOrEven().equals("Odd")) {
    		p[0].getBetOnRoulette()[46] *= 2;
    		p[1].getBetOnRoulette()[46] *= 2;
    		p[2].getBetOnRoulette()[46] *= 2;
    		p[3].getBetOnRoulette()[46] *= 2;
    	}else if(!rouletteWin.determineOddOrEven().equals("Odd")) {
    		p[0].getBetOnRoulette()[46] = 0;
    		p[1].getBetOnRoulette()[46] = 0;
    		p[2].getBetOnRoulette()[46] = 0;
    		p[3].getBetOnRoulette()[46] = 0;
    	}else if(rouletteWin.getColor().equals("Red")) {
    		p[0].getBetOnRoulette()[47] *= 2;
    		p[1].getBetOnRoulette()[47] *= 2;
    		p[2].getBetOnRoulette()[47] *= 2;
    		p[3].getBetOnRoulette()[47] *= 2;
    	}else if(!rouletteWin.getColor().equals("Red")) {
    		p[0].getBetOnRoulette()[47] = 0;
    		p[1].getBetOnRoulette()[47] = 0;
    		p[2].getBetOnRoulette()[47] = 0;
    		p[3].getBetOnRoulette()[47] = 0;
    	}else if(rouletteWin.getColor().equals("Black")) {
    		p[0].getBetOnRoulette()[48] *= 2;
    		p[1].getBetOnRoulette()[48] *= 2;
    		p[2].getBetOnRoulette()[48] *= 2;
    		p[3].getBetOnRoulette()[48] *= 2;
    	}else if(!rouletteWin.getColor().equals("Black")) {
    		p[0].getBetOnRoulette()[48] = 0;
    		p[1].getBetOnRoulette()[48] = 0;
    		p[2].getBetOnRoulette()[48] = 0;
    		p[3].getBetOnRoulette()[48] = 0;
    	}
    	
    	for(int i = 0; i < 49; i++) {
    		p[0].getBankAccount().deposit(p[0].getBetOnRoulette()[i]);
    		p[1].getBankAccount().deposit(p[1].getBetOnRoulette()[i]);
    		p[2].getBankAccount().deposit(p[2].getBetOnRoulette()[i]);
    		p[3].getBankAccount().deposit(p[3].getBetOnRoulette()[i]);
    	}
    	
    	if(mysteryRouletteWin.getNumber() == 0) {
    		p[0].getBetOnMysteryRoulette()[0] *= 36;
    		p[1].getBetOnMysteryRoulette()[0] *= 36;
    		p[2].getBetOnMysteryRoulette()[0] *= 36;
    		p[3].getBetOnMysteryRoulette()[0] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 0) {
    		p[0].getBetOnMysteryRoulette()[0] = 0;
    		p[1].getBetOnMysteryRoulette()[0] = 0;
    		p[2].getBetOnMysteryRoulette()[0] = 0;
    		p[3].getBetOnMysteryRoulette()[0] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 1) {
    		p[0].getBetOnMysteryRoulette()[1] *= 36;
    		p[1].getBetOnMysteryRoulette()[1] *= 36;
    		p[2].getBetOnMysteryRoulette()[1] *= 36;
    		p[3].getBetOnMysteryRoulette()[1] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 1) {
    		p[0].getBetOnMysteryRoulette()[1] = 0;
    		p[1].getBetOnMysteryRoulette()[1] = 0;
    		p[2].getBetOnMysteryRoulette()[1] = 0;
    		p[3].getBetOnMysteryRoulette()[1] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 2) {
    		p[0].getBetOnMysteryRoulette()[2] *= 36;
    		p[1].getBetOnMysteryRoulette()[2] *= 36;
    		p[2].getBetOnMysteryRoulette()[2] *= 36;
    		p[3].getBetOnMysteryRoulette()[2] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 2) {
    		p[0].getBetOnMysteryRoulette()[2] = 0;
    		p[1].getBetOnMysteryRoulette()[2] = 0;
    		p[2].getBetOnMysteryRoulette()[2] = 0;
    		p[3].getBetOnMysteryRoulette()[2] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 3) {
    		p[0].getBetOnMysteryRoulette()[3] *= 36;
    		p[1].getBetOnMysteryRoulette()[3] *= 36;
    		p[2].getBetOnMysteryRoulette()[3] *= 36;
    		p[3].getBetOnMysteryRoulette()[3] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 3) {
    		p[0].getBetOnMysteryRoulette()[3] = 0;
    		p[1].getBetOnMysteryRoulette()[3] = 0;
    		p[2].getBetOnMysteryRoulette()[3] = 0;
    		p[3].getBetOnMysteryRoulette()[3] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 4) {
    		p[0].getBetOnMysteryRoulette()[4] *= 36;
    		p[1].getBetOnMysteryRoulette()[4] *= 36;
    		p[2].getBetOnMysteryRoulette()[4] *= 36;
    		p[3].getBetOnMysteryRoulette()[4] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 4) {
    		p[0].getBetOnMysteryRoulette()[4] = 0;
    		p[1].getBetOnMysteryRoulette()[4] = 0;
    		p[2].getBetOnMysteryRoulette()[4] = 0;
    		p[3].getBetOnMysteryRoulette()[4] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 5) {
    		p[0].getBetOnMysteryRoulette()[5] *= 36;
    		p[1].getBetOnMysteryRoulette()[5] *= 36;
    		p[2].getBetOnMysteryRoulette()[5] *= 36;
    		p[3].getBetOnMysteryRoulette()[5] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 5) {
    		p[0].getBetOnMysteryRoulette()[5] = 0;
    		p[1].getBetOnMysteryRoulette()[5] = 0;
    		p[2].getBetOnMysteryRoulette()[5] = 0;
    		p[3].getBetOnMysteryRoulette()[5] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 6) {
    		p[0].getBetOnMysteryRoulette()[6] *= 36;
    		p[1].getBetOnMysteryRoulette()[6] *= 36;
    		p[2].getBetOnMysteryRoulette()[6] *= 36;
    		p[3].getBetOnMysteryRoulette()[6] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 6) {
    		p[0].getBetOnMysteryRoulette()[6] = 0;
    		p[1].getBetOnMysteryRoulette()[6] = 0;
    		p[2].getBetOnMysteryRoulette()[6] = 0;
    		p[3].getBetOnMysteryRoulette()[6] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 7) {
    		p[0].getBetOnMysteryRoulette()[7] *= 36;
    		p[1].getBetOnMysteryRoulette()[7] *= 36;
    		p[2].getBetOnMysteryRoulette()[7] *= 36;
    		p[3].getBetOnMysteryRoulette()[7] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 7) {
    		p[0].getBetOnMysteryRoulette()[7] = 0;
    		p[1].getBetOnMysteryRoulette()[7] = 0;
    		p[2].getBetOnMysteryRoulette()[7] = 0;
    		p[3].getBetOnMysteryRoulette()[7] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 8) {
    		p[0].getBetOnMysteryRoulette()[8] *= 36;
    		p[1].getBetOnMysteryRoulette()[8] *= 36;
    		p[2].getBetOnMysteryRoulette()[8] *= 36;
    		p[3].getBetOnMysteryRoulette()[8] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 8) {
    		p[0].getBetOnMysteryRoulette()[8] = 0;
    		p[1].getBetOnMysteryRoulette()[8] = 0;
    		p[2].getBetOnMysteryRoulette()[8] = 0;
    		p[3].getBetOnMysteryRoulette()[8] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 9) {
    		p[0].getBetOnMysteryRoulette()[9] *= 36;
    		p[1].getBetOnMysteryRoulette()[9] *= 36;
    		p[2].getBetOnMysteryRoulette()[9] *= 36;
    		p[3].getBetOnMysteryRoulette()[9] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 9) {
    		p[0].getBetOnMysteryRoulette()[9] = 0;
    		p[1].getBetOnMysteryRoulette()[9] = 0;
    		p[2].getBetOnMysteryRoulette()[9] = 0;
    		p[3].getBetOnMysteryRoulette()[9] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 10) {
    		p[0].getBetOnMysteryRoulette()[10] *= 36;
    		p[1].getBetOnMysteryRoulette()[10] *= 36;
    		p[2].getBetOnMysteryRoulette()[10] *= 36;
    		p[3].getBetOnMysteryRoulette()[10] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 10) {
    		p[0].getBetOnMysteryRoulette()[10] = 0;
    		p[1].getBetOnMysteryRoulette()[10] = 0;
    		p[2].getBetOnMysteryRoulette()[10] = 0;
    		p[3].getBetOnMysteryRoulette()[10] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 11) {
    		p[0].getBetOnMysteryRoulette()[11] *= 36;
    		p[1].getBetOnMysteryRoulette()[11] *= 36;
    		p[2].getBetOnMysteryRoulette()[11] *= 36;
    		p[3].getBetOnMysteryRoulette()[11] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 11) {
    		p[0].getBetOnMysteryRoulette()[11] = 0;
    		p[1].getBetOnMysteryRoulette()[11] = 0;
    		p[2].getBetOnMysteryRoulette()[11] = 0;
    		p[3].getBetOnMysteryRoulette()[11] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 12) {
    		p[0].getBetOnMysteryRoulette()[12] *= 36;
    		p[1].getBetOnMysteryRoulette()[12] *= 36;
    		p[2].getBetOnMysteryRoulette()[12] *= 36;
    		p[3].getBetOnMysteryRoulette()[12] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 12) {
    		p[0].getBetOnMysteryRoulette()[12] = 0;
    		p[1].getBetOnMysteryRoulette()[12] = 0;
    		p[2].getBetOnMysteryRoulette()[12] = 0;
    		p[3].getBetOnMysteryRoulette()[12] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 13) {
    		p[0].getBetOnMysteryRoulette()[13] *= 36;
    		p[1].getBetOnMysteryRoulette()[13] *= 36;
    		p[2].getBetOnMysteryRoulette()[13] *= 36;
    		p[3].getBetOnMysteryRoulette()[13] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 13) {
    		p[0].getBetOnMysteryRoulette()[13] = 0;
    		p[1].getBetOnMysteryRoulette()[13] = 0;
    		p[2].getBetOnMysteryRoulette()[13] = 0;
    		p[3].getBetOnMysteryRoulette()[13] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 14) {
    		p[0].getBetOnMysteryRoulette()[14] *= 36;
    		p[1].getBetOnMysteryRoulette()[14] *= 36;
    		p[2].getBetOnMysteryRoulette()[14] *= 36;
    		p[3].getBetOnMysteryRoulette()[14] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 14) {
    		p[0].getBetOnMysteryRoulette()[14] = 0;
    		p[1].getBetOnMysteryRoulette()[14] = 0;
    		p[2].getBetOnMysteryRoulette()[14] = 0;
    		p[3].getBetOnMysteryRoulette()[14] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 15) {
    		p[0].getBetOnMysteryRoulette()[15] *= 36;
    		p[1].getBetOnMysteryRoulette()[15] *= 36;
    		p[2].getBetOnMysteryRoulette()[15] *= 36;
    		p[3].getBetOnMysteryRoulette()[15] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 15) {
    		p[0].getBetOnMysteryRoulette()[15] = 0;
    		p[1].getBetOnMysteryRoulette()[15] = 0;
    		p[2].getBetOnMysteryRoulette()[15] = 0;
    		p[3].getBetOnMysteryRoulette()[15] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 16) {
    		p[0].getBetOnMysteryRoulette()[16] *= 36;
    		p[1].getBetOnMysteryRoulette()[16] *= 36;
    		p[2].getBetOnMysteryRoulette()[16] *= 36;
    		p[3].getBetOnMysteryRoulette()[16] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 16) {
    		p[0].getBetOnMysteryRoulette()[16] = 0;
    		p[1].getBetOnMysteryRoulette()[16] = 0;
    		p[2].getBetOnMysteryRoulette()[16] = 0;
    		p[3].getBetOnMysteryRoulette()[16] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 17) {
    		p[0].getBetOnMysteryRoulette()[17] *= 36;
    		p[1].getBetOnMysteryRoulette()[17] *= 36;
    		p[2].getBetOnMysteryRoulette()[17] *= 36;
    		p[3].getBetOnMysteryRoulette()[17] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 17) {
    		p[0].getBetOnMysteryRoulette()[17] = 0;
    		p[1].getBetOnMysteryRoulette()[17] = 0;
    		p[2].getBetOnMysteryRoulette()[17] = 0;
    		p[3].getBetOnMysteryRoulette()[17] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 18) {
    		p[0].getBetOnMysteryRoulette()[18] *= 36;
    		p[1].getBetOnMysteryRoulette()[18] *= 36;
    		p[2].getBetOnMysteryRoulette()[18] *= 36;
    		p[3].getBetOnMysteryRoulette()[18] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 18) {
    		p[0].getBetOnMysteryRoulette()[18] = 0;
    		p[1].getBetOnMysteryRoulette()[18] = 0;
    		p[2].getBetOnMysteryRoulette()[18] = 0;
    		p[3].getBetOnMysteryRoulette()[18] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 19) {
    		p[0].getBetOnMysteryRoulette()[19] *= 36;
    		p[1].getBetOnMysteryRoulette()[19] *= 36;
    		p[2].getBetOnMysteryRoulette()[19] *= 36;
    		p[3].getBetOnMysteryRoulette()[19] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 19) {
    		p[0].getBetOnMysteryRoulette()[19] = 0;
    		p[1].getBetOnMysteryRoulette()[19] = 0;
    		p[2].getBetOnMysteryRoulette()[19] = 0;
    		p[3].getBetOnMysteryRoulette()[19] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 20) {
    		p[0].getBetOnMysteryRoulette()[20] *= 36;
    		p[1].getBetOnMysteryRoulette()[20] *= 36;
    		p[2].getBetOnMysteryRoulette()[20] *= 36;
    		p[3].getBetOnMysteryRoulette()[20] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 20) {
    		p[0].getBetOnMysteryRoulette()[20] = 0;
    		p[1].getBetOnMysteryRoulette()[20] = 0;
    		p[2].getBetOnMysteryRoulette()[20] = 0;
    		p[3].getBetOnMysteryRoulette()[20] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 21) {
    		p[0].getBetOnMysteryRoulette()[21] *= 36;
    		p[1].getBetOnMysteryRoulette()[21] *= 36;
    		p[2].getBetOnMysteryRoulette()[21] *= 36;
    		p[3].getBetOnMysteryRoulette()[21] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 21) {
    		p[0].getBetOnMysteryRoulette()[21] = 0;
    		p[1].getBetOnMysteryRoulette()[21] = 0;
    		p[2].getBetOnMysteryRoulette()[21] = 0;
    		p[3].getBetOnMysteryRoulette()[21] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 22) {
    		p[0].getBetOnMysteryRoulette()[22] *= 36;
    		p[1].getBetOnMysteryRoulette()[22] *= 36;
    		p[2].getBetOnMysteryRoulette()[22] *= 36;
    		p[3].getBetOnMysteryRoulette()[22] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 22) {
    		p[0].getBetOnMysteryRoulette()[22] = 0;
    		p[1].getBetOnMysteryRoulette()[22] = 0;
    		p[2].getBetOnMysteryRoulette()[22] = 0;
    		p[3].getBetOnMysteryRoulette()[22] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 23) {
    		p[0].getBetOnMysteryRoulette()[23] *= 36;
    		p[1].getBetOnMysteryRoulette()[23] *= 36;
    		p[2].getBetOnMysteryRoulette()[23] *= 36;
    		p[3].getBetOnMysteryRoulette()[23] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 23) {
    		p[0].getBetOnMysteryRoulette()[23] = 0;
    		p[1].getBetOnMysteryRoulette()[23] = 0;
    		p[2].getBetOnMysteryRoulette()[23] = 0;
    		p[3].getBetOnMysteryRoulette()[23] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 24) {
    		p[0].getBetOnMysteryRoulette()[24] *= 36;
    		p[1].getBetOnMysteryRoulette()[24] *= 36;
    		p[2].getBetOnMysteryRoulette()[24] *= 36;
    		p[3].getBetOnMysteryRoulette()[24] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 24) {
    		p[0].getBetOnMysteryRoulette()[24] = 0;
    		p[1].getBetOnMysteryRoulette()[24] = 0;
    		p[2].getBetOnMysteryRoulette()[24] = 0;
    		p[3].getBetOnMysteryRoulette()[24] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 25) {
    		p[0].getBetOnMysteryRoulette()[25] *= 36;
    		p[1].getBetOnMysteryRoulette()[25] *= 36;
    		p[2].getBetOnMysteryRoulette()[25] *= 36;
    		p[3].getBetOnMysteryRoulette()[25] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 25) {
    		p[0].getBetOnMysteryRoulette()[25] = 0;
    		p[1].getBetOnMysteryRoulette()[25] = 0;
    		p[2].getBetOnMysteryRoulette()[25] = 0;
    		p[3].getBetOnMysteryRoulette()[25] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 26) {
    		p[0].getBetOnMysteryRoulette()[26] *= 36;
    		p[1].getBetOnMysteryRoulette()[26] *= 36;
    		p[2].getBetOnMysteryRoulette()[26] *= 36;
    		p[3].getBetOnMysteryRoulette()[26] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 26) {
    		p[0].getBetOnMysteryRoulette()[26] = 0;
    		p[1].getBetOnMysteryRoulette()[26] = 0;
    		p[2].getBetOnMysteryRoulette()[26] = 0;
    		p[3].getBetOnMysteryRoulette()[26] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 27) {
    		p[0].getBetOnMysteryRoulette()[27] *= 36;
    		p[1].getBetOnMysteryRoulette()[27] *= 36;
    		p[2].getBetOnMysteryRoulette()[27] *= 36;
    		p[3].getBetOnMysteryRoulette()[27] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 27) {
    		p[0].getBetOnMysteryRoulette()[27] = 0;
    		p[1].getBetOnMysteryRoulette()[27] = 0;
    		p[2].getBetOnMysteryRoulette()[27] = 0;
    		p[3].getBetOnMysteryRoulette()[27] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 28) {
    		p[0].getBetOnMysteryRoulette()[28] *= 36;
    		p[1].getBetOnMysteryRoulette()[28] *= 36;
    		p[2].getBetOnMysteryRoulette()[28] *= 36;
    		p[3].getBetOnMysteryRoulette()[28] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 28) {
    		p[0].getBetOnMysteryRoulette()[28] = 0;
    		p[1].getBetOnMysteryRoulette()[28] = 0;
    		p[2].getBetOnMysteryRoulette()[28] = 0;
    		p[3].getBetOnMysteryRoulette()[28] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 29) {
    		p[0].getBetOnMysteryRoulette()[29] *= 36;
    		p[1].getBetOnMysteryRoulette()[29] *= 36;
    		p[2].getBetOnMysteryRoulette()[29] *= 36;
    		p[3].getBetOnMysteryRoulette()[29] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 29) {
    		p[0].getBetOnMysteryRoulette()[29] = 0;
    		p[1].getBetOnMysteryRoulette()[29] = 0;
    		p[2].getBetOnMysteryRoulette()[29] = 0;
    		p[3].getBetOnMysteryRoulette()[29] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 30) {
    		p[0].getBetOnMysteryRoulette()[30] *= 36;
    		p[1].getBetOnMysteryRoulette()[30] *= 36;
    		p[2].getBetOnMysteryRoulette()[30] *= 36;
    		p[3].getBetOnMysteryRoulette()[30] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 30) {
    		p[0].getBetOnMysteryRoulette()[30] = 0;
    		p[1].getBetOnMysteryRoulette()[30] = 0;
    		p[2].getBetOnMysteryRoulette()[30] = 0;
    		p[3].getBetOnMysteryRoulette()[30] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 31) {
    		p[0].getBetOnMysteryRoulette()[31] *= 36;
    		p[1].getBetOnMysteryRoulette()[31] *= 36;
    		p[2].getBetOnMysteryRoulette()[31] *= 36;
    		p[3].getBetOnMysteryRoulette()[31] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 31) {
    		p[0].getBetOnMysteryRoulette()[31] = 0;
    		p[1].getBetOnMysteryRoulette()[31] = 0;
    		p[2].getBetOnMysteryRoulette()[31] = 0;
    		p[3].getBetOnMysteryRoulette()[31] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 32) {
    		p[0].getBetOnMysteryRoulette()[32] *= 36;
    		p[1].getBetOnMysteryRoulette()[32] *= 36;
    		p[2].getBetOnMysteryRoulette()[32] *= 36;
    		p[3].getBetOnMysteryRoulette()[32] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 32) {
    		p[0].getBetOnMysteryRoulette()[32] = 0;
    		p[1].getBetOnMysteryRoulette()[32] = 0;
    		p[2].getBetOnMysteryRoulette()[32] = 0;
    		p[3].getBetOnMysteryRoulette()[32] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 33) {
    		p[0].getBetOnMysteryRoulette()[33] *= 36;
    		p[1].getBetOnMysteryRoulette()[33] *= 36;
    		p[2].getBetOnMysteryRoulette()[33] *= 36;
    		p[3].getBetOnMysteryRoulette()[33] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 33) {
    		p[0].getBetOnMysteryRoulette()[33] = 0;
    		p[1].getBetOnMysteryRoulette()[33] = 0;
    		p[2].getBetOnMysteryRoulette()[33] = 0;
    		p[3].getBetOnMysteryRoulette()[33] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 34) {
    		p[0].getBetOnMysteryRoulette()[34] *= 36;
    		p[1].getBetOnMysteryRoulette()[34] *= 36;
    		p[2].getBetOnMysteryRoulette()[34] *= 36;
    		p[3].getBetOnMysteryRoulette()[34] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 34) {
    		p[0].getBetOnMysteryRoulette()[34] = 0;
    		p[1].getBetOnMysteryRoulette()[34] = 0;
    		p[2].getBetOnMysteryRoulette()[34] = 0;
    		p[3].getBetOnMysteryRoulette()[34] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 35) {
    		p[0].getBetOnMysteryRoulette()[35] *= 36;
    		p[1].getBetOnMysteryRoulette()[35] *= 36;
    		p[2].getBetOnMysteryRoulette()[35] *= 36;
    		p[3].getBetOnMysteryRoulette()[35] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 35) {
    		p[0].getBetOnMysteryRoulette()[35] = 0;
    		p[1].getBetOnMysteryRoulette()[35] = 0;
    		p[2].getBetOnMysteryRoulette()[35] = 0;
    		p[3].getBetOnMysteryRoulette()[35] = 0;
    	}else if(mysteryRouletteWin.getNumber() == 36) {
    		p[0].getBetOnMysteryRoulette()[36] *= 36;
    		p[1].getBetOnMysteryRoulette()[36] *= 36;
    		p[2].getBetOnMysteryRoulette()[36] *= 36;
    		p[3].getBetOnMysteryRoulette()[36] *= 36;
    	}else if(mysteryRouletteWin.getNumber() != 36) {
    		p[0].getBetOnMysteryRoulette()[36] = 0;
    		p[1].getBetOnMysteryRoulette()[36] = 0;
    		p[2].getBetOnMysteryRoulette()[36] = 0;
    		p[3].getBetOnMysteryRoulette()[36] = 0;
    	}else if(inRow(1, mysteryRouletteWin.getNumber())) {
    		p[0].getBetOnMysteryRoulette()[37] *= 2;
    		p[1].getBetOnMysteryRoulette()[37] *= 2;
    		p[2].getBetOnMysteryRoulette()[37] *= 2;
    		p[3].getBetOnMysteryRoulette()[37] *= 2;
    	}else if(!inRow(1, mysteryRouletteWin.getNumber())) {
    		p[0].getBetOnMysteryRoulette()[37] = 0;
    		p[1].getBetOnMysteryRoulette()[37] = 0;
    		p[2].getBetOnMysteryRoulette()[37] = 0;
    		p[3].getBetOnMysteryRoulette()[37] = 0;
    	}else if(inRow(2, mysteryRouletteWin.getNumber())) {
    		p[0].getBetOnMysteryRoulette()[38] *= 2;
    		p[1].getBetOnMysteryRoulette()[38] *= 2;
    		p[2].getBetOnMysteryRoulette()[38] *= 2;
    		p[3].getBetOnMysteryRoulette()[38] *= 2;
    	}else if(!inRow(2, mysteryRouletteWin.getNumber())) {
    		p[0].getBetOnMysteryRoulette()[38] = 0;
    		p[1].getBetOnMysteryRoulette()[38] = 0;
    		p[2].getBetOnMysteryRoulette()[38] = 0;
    		p[3].getBetOnMysteryRoulette()[38] = 0;
    	}else if(inRow(3, mysteryRouletteWin.getNumber())) {
    		p[0].getBetOnMysteryRoulette()[39] *= 2;
    		p[1].getBetOnMysteryRoulette()[39] *= 2;
    		p[2].getBetOnMysteryRoulette()[39] *= 2;
    		p[3].getBetOnMysteryRoulette()[39] *= 2;
    	}else if(!inRow(3, mysteryRouletteWin.getNumber())) {
    		p[0].getBetOnMysteryRoulette()[39] = 0;
    		p[1].getBetOnMysteryRoulette()[39] = 0;
    		p[2].getBetOnMysteryRoulette()[39] = 0;
    		p[3].getBetOnMysteryRoulette()[39] = 0;
    	}else if(1 <= mysteryRouletteWin.getNumber() && mysteryRouletteWin.getNumber() <= 12) {
    		p[0].getBetOnMysteryRoulette()[40] *= 2;
    		p[1].getBetOnMysteryRoulette()[40] *= 2;
    		p[2].getBetOnMysteryRoulette()[40] *= 2;
    		p[3].getBetOnMysteryRoulette()[40] *= 2;
    	}else if((13 <= mysteryRouletteWin.getNumber() && mysteryRouletteWin.getNumber() <= 36) || mysteryRouletteWin.getNumber() == 0) {
    		p[0].getBetOnMysteryRoulette()[40] = 0;
    		p[1].getBetOnMysteryRoulette()[40] = 0;
    		p[2].getBetOnMysteryRoulette()[40] = 0;
    		p[3].getBetOnMysteryRoulette()[40] = 0;
    	}else if(13 <= mysteryRouletteWin.getNumber() && mysteryRouletteWin.getNumber() <= 24) {
    		p[0].getBetOnMysteryRoulette()[41] *= 2;
    		p[1].getBetOnMysteryRoulette()[41] *= 2;
    		p[2].getBetOnMysteryRoulette()[41] *= 2;
    		p[3].getBetOnMysteryRoulette()[41] *= 2;
    	}else if((0 <= mysteryRouletteWin.getNumber() && mysteryRouletteWin.getNumber() <= 12) || (25 <= mysteryRouletteWin.getNumber() && mysteryRouletteWin.getNumber() <= 36)) {
    		p[0].getBetOnMysteryRoulette()[41] = 0;
    		p[1].getBetOnMysteryRoulette()[41] = 0;
    		p[2].getBetOnMysteryRoulette()[41] = 0;
    		p[3].getBetOnMysteryRoulette()[41] = 0;
    	}else if(25 <= mysteryRouletteWin.getNumber() && mysteryRouletteWin.getNumber() <= 36) {
    		p[0].getBetOnMysteryRoulette()[42] *= 2;
    		p[1].getBetOnMysteryRoulette()[42] *= 2;
    		p[2].getBetOnMysteryRoulette()[42] *= 2;
    		p[3].getBetOnMysteryRoulette()[42] *= 2;
    	}else if(0 <= mysteryRouletteWin.getNumber() && mysteryRouletteWin.getNumber() <= 24) {
    		p[0].getBetOnMysteryRoulette()[42] = 0;
    		p[1].getBetOnMysteryRoulette()[42] = 0;
    		p[2].getBetOnMysteryRoulette()[42] = 0;
    		p[3].getBetOnMysteryRoulette()[42] = 0;
    	}else if(1 <= mysteryRouletteWin.getNumber() && mysteryRouletteWin.getNumber() <= 18) {
    		p[0].getBetOnMysteryRoulette()[43] *= 2;
    		p[1].getBetOnMysteryRoulette()[43] *= 2;
    		p[2].getBetOnMysteryRoulette()[43] *= 2;
    		p[3].getBetOnMysteryRoulette()[43] *= 2;
    	}else if(mysteryRouletteWin.getNumber() == 0 || (19 <= mysteryRouletteWin.getNumber() && mysteryRouletteWin.getNumber() <= 36)) {
    		p[0].getBetOnMysteryRoulette()[43] = 0;
    		p[1].getBetOnMysteryRoulette()[43] = 0;
    		p[2].getBetOnMysteryRoulette()[43] = 0;
    		p[3].getBetOnMysteryRoulette()[43] = 0;
    	}else if(19 <= mysteryRouletteWin.getNumber() && mysteryRouletteWin.getNumber() <= 36) {
    		p[0].getBetOnMysteryRoulette()[44] *= 2;
    		p[1].getBetOnMysteryRoulette()[44] *= 2;
    		p[2].getBetOnMysteryRoulette()[44] *= 2;
    		p[3].getBetOnMysteryRoulette()[44] *= 2;
    	}else if(0 <= mysteryRouletteWin.getNumber() && mysteryRouletteWin.getNumber() <= 18) {
    		p[0].getBetOnMysteryRoulette()[44] = 0;
    		p[1].getBetOnMysteryRoulette()[44] = 0;
    		p[2].getBetOnMysteryRoulette()[44] = 0;
    		p[3].getBetOnMysteryRoulette()[44] = 0;
    	}else if(mysteryRouletteWin.determineOddOrEven().equals("Even")) {
    		p[0].getBetOnMysteryRoulette()[45] *= 2;
    		p[1].getBetOnMysteryRoulette()[45] *= 2;
    		p[2].getBetOnMysteryRoulette()[45] *= 2;
    		p[3].getBetOnMysteryRoulette()[45] *= 2;
    	}else if(!mysteryRouletteWin.determineOddOrEven().equals("Even")) {
    		p[0].getBetOnMysteryRoulette()[45] = 0;
    		p[1].getBetOnMysteryRoulette()[45] = 0;
    		p[2].getBetOnMysteryRoulette()[45] = 0;
    		p[3].getBetOnMysteryRoulette()[45] = 0;
    	}else if(mysteryRouletteWin.determineOddOrEven().equals("Odd")) {
    		p[0].getBetOnMysteryRoulette()[46] *= 2;
    		p[1].getBetOnMysteryRoulette()[46] *= 2;
    		p[2].getBetOnMysteryRoulette()[46] *= 2;
    		p[3].getBetOnMysteryRoulette()[46] *= 2;
    	}else if(!mysteryRouletteWin.determineOddOrEven().equals("Odd")) {
    		p[0].getBetOnMysteryRoulette()[46] = 0;
    		p[1].getBetOnMysteryRoulette()[46] = 0;
    		p[2].getBetOnMysteryRoulette()[46] = 0;
    		p[3].getBetOnMysteryRoulette()[46] = 0;
    	}else if(mysteryRouletteWin.getColor().equals("Red")) {
    		p[0].getBetOnMysteryRoulette()[47] *= 2;
    		p[1].getBetOnMysteryRoulette()[47] *= 2;
    		p[2].getBetOnMysteryRoulette()[47] *= 2;
    		p[3].getBetOnMysteryRoulette()[47] *= 2;
    	}else if(!mysteryRouletteWin.getColor().equals("Red")) {
    		p[0].getBetOnMysteryRoulette()[47] = 0;
    		p[1].getBetOnMysteryRoulette()[47] = 0;
    		p[2].getBetOnMysteryRoulette()[47] = 0;
    		p[3].getBetOnMysteryRoulette()[47] = 0;
    	}else if(mysteryRouletteWin.getColor().equals("Black")) {
    		p[0].getBetOnMysteryRoulette()[48] *= 2;
    		p[1].getBetOnMysteryRoulette()[48] *= 2;
    		p[2].getBetOnMysteryRoulette()[48] *= 2;
    		p[3].getBetOnMysteryRoulette()[48] *= 2;
    	}else if(!mysteryRouletteWin.getColor().equals("Black")) {
    		p[0].getBetOnMysteryRoulette()[48] = 0;
    		p[1].getBetOnMysteryRoulette()[48] = 0;
    		p[2].getBetOnMysteryRoulette()[48] = 0;
    		p[3].getBetOnMysteryRoulette()[48] = 0;
    	}
    	
    	for(int i = 0; i < 49; i++) {
    		p[0].getBankAccount().deposit(p[0].getBetOnMysteryRoulette()[i]);
    		p[1].getBankAccount().deposit(p[1].getBetOnMysteryRoulette()[i]);
    		p[2].getBankAccount().deposit(p[2].getBetOnMysteryRoulette()[i]);
    		p[3].getBankAccount().deposit(p[3].getBetOnMysteryRoulette()[i]);
    	}

    	balanceP1.setText("Current Balance: " + p[0].getBankAccount().getBalance());
    	balanceP2.setText("Current Balance: " + p[1].getBankAccount().getBalance());
    	balanceP3.setText("Current Balance: " + p[2].getBankAccount().getBalance());
    	balanceP4.setText("Current Balance: " + p[3].getBankAccount().getBalance());
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CasinoGUI();
            }
        });
    }
}

