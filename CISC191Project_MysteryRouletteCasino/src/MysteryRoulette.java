import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Lead Author(s):
 * @author Jordi Mejia
 * @author Jorge Arellano
 * 
 * References:
 * Tasha Frankie
 * <<add more references here>>
 *  
 * Version/date: 
 * 
 * Responsibilities of class:
 * MysteryRoulette class 
 */

public class MysteryRoulette {
	//---------- Field ----------
	private Roulette[] wheel = new Roulette[37];
	
	//---------- Constructor ----------
	/**
	 * Purpose: No-parameter Constructor used to initialize class object with default values.
	 */
	public MysteryRoulette() {
		// Zero (0)
		wheel[0] = new Roulette(0, "Green"); 
		
		// 1-12 set
		
		// 1st column
		wheel[1] = new Roulette(1, "Red"); 
		wheel[2] = new Roulette(2, "Black"); 
		wheel[3] = new Roulette(3, "Red"); 
		// 2nd column
		wheel[4] = new Roulette(4, "Black"); 
		wheel[5] = new Roulette(5, "Red"); 
		wheel[6] = new Roulette(6, "Black"); 
		// 3rd column
		wheel[7] = new Roulette(7, "Red"); 
		wheel[8] = new Roulette(8, "Black"); 
		wheel[9] = new Roulette(9, "Red"); 
		// 4th column
		wheel[10] = new Roulette(10, "Black"); 
		wheel[11] = new Roulette(11, "Black"); 
		wheel[12] = new Roulette(12, "Red"); 
		
		// 13-24 set
		
		// 5th column
		wheel[13] = new Roulette(13, "Black"); 
		wheel[14] = new Roulette(14, "Red"); 
		wheel[15] = new Roulette(15, "Black"); 
		// 6th column
		wheel[16] = new Roulette(16, "Red"); 
		wheel[17] = new Roulette(17, "Black"); 
		wheel[18] = new Roulette(18, "Red"); 
		// 7th column
		wheel[19] = new Roulette(19, "Red"); 
		wheel[20] = new Roulette(20, "Black"); 
		wheel[21] = new Roulette(21, "Red"); 
		// 8th column
		wheel[22] = new Roulette(22, "Black"); 
		wheel[23] = new Roulette(23, "Red"); 
		wheel[24] = new Roulette(24, "Black"); 
		
		//25-36 set
		
		// 9th column
		wheel[25] = new Roulette(25, "Red"); 
		wheel[26] = new Roulette(26, "Black"); 
		wheel[27] = new Roulette(27, "Red"); 
		// 10th column
		wheel[28] = new Roulette(28, "Black"); 
		wheel[29] = new Roulette(29, "Black"); 
		wheel[30] = new Roulette(30, "Red"); 
		// 11th column
		wheel[31] = new Roulette(31, "Black"); 
		wheel[32] = new Roulette(32, "Red"); 
		wheel[33] = new Roulette(33, "Black"); 
		// 12th column
		wheel[34] = new Roulette(34, "Red"); 
		wheel[35] = new Roulette(35, "Black"); 
		wheel[36] = new Roulette(36, "Red"); 
	}
	
	//---------- Methods ----------
	/**
	 * Purpose: Getter method for MysteryRoulette wheel.
	 * @return Roulette wheel
	 */
	public Roulette[] getWheel() {
		return this.wheel;
	}
	
	/**
	 * Purpose: A method when Mystery Roulette game is chosen. (Variant Game)
	 * @return Roulette card1, card2, or card3 (depends on spin result)
	 */
	public Roulette playMysteryRoulette(Roulette [] roulette) {
		//Initializes Random 
		Random rand = new Random();
		
		//Initializes and sets up 3 random integers between 0-36 
		int randomIntForCard1 = rand.nextInt(37);
		int randomIntForCard2 = -1;
		int randomIntForCard3 = -1;
		while(randomIntForCard2 == -1 || randomIntForCard2 == randomIntForCard1) {
			randomIntForCard2 = rand.nextInt(37);
		}
		while(randomIntForCard3 == -1 || randomIntForCard3 == randomIntForCard1 || randomIntForCard3 == randomIntForCard2) {
			randomIntForCard3 = rand.nextInt(37);
		}
		
		//Initializes 3 Roulette objects (card(1-3))
		Roulette card1 = new Roulette(roulette[randomIntForCard1]);
		Roulette card2 = new Roulette(roulette[randomIntForCard2]);
		Roulette card3 = new Roulette(roulette[randomIntForCard3]);
		
		//Initializes win integer
		int win = -1;
		
		//Starts MysteryRoulette game
		try{
			//Explains how MysteryRoulette game works
			//Card display
			TimeUnit.SECONDS.sleep(3);
			System.out.println("");
			System.out.println("We start by drawing 3 Roulette Cards! ");
			System.out.println("  _______        _______        _______ ");
			System.out.println(" |  ___  |      |  ___  |      |  ___  |");
			System.out.println(" | |   | |      | |   | |      | |   | |");
			System.out.println(" | | 1 | |      | | 2 | |      | | 3 | |");
			System.out.println(" | |___| |      | |___| |      | |___| |");
			System.out.println(" |_______|      |_______|      |_______|");
			System.out.println("    FLIP           FLIP           FLIP");
			System.out.println("    THIS           THIS           THIS");
			System.out.println("    CARD           CARD           CARD");
			System.out.println("     IF             IF             IF");
			System.out.println(" 0<=SPIN<=12   13<=SPIN<=24   25<=SPIN<=36");
			
			TimeUnit.SECONDS.sleep(3);
			//Calls spin method for Original Roulette game
			Roulette wheelLandsOn = spin(roulette);
			
			//Reminds player(s) that this is not the win, the Roulette card we flip is the win
			System.out.println("Remember this is not the win..."); 
			System.out.println("");
			
			//Drawn card display with discarded cards
			if(0 <= wheelLandsOn.getNumber() && wheelLandsOn.getNumber() <= 12){
				System.out.println("Since " + wheelLandsOn.getNumber() + " is in the range 0 - 12...");
				System.out.println("");
				TimeUnit.SECONDS.sleep(5);
				System.out.println("First Card Wins!");
				System.out.println("  _______         \\    /         \\    /  ");
				System.out.println(" |  ___  |         \\  /           \\  /   ");
				System.out.println(" | |   | |          \\/             \\/    ");
				System.out.println(" | | 1 | |          /\\             /\\    ");
				System.out.println(" | |___| |         /  \\           /  \\   ");
				System.out.println(" |_______|        /    \\         /    \\  ");
				win = 1;
			}else if(13 <= wheelLandsOn.getNumber() && wheelLandsOn.getNumber() <= 24){
				System.out.println("Since " + wheelLandsOn.getNumber() + " is in the range 13 - 24...");
				System.out.println("");
				TimeUnit.SECONDS.sleep(5);
				System.out.println("Second Card Wins!");
				System.out.println("   \\    /        _______         \\    / ");
				System.out.println("    \\  /        |  ___  |         \\  /  ");
				System.out.println("     \\/         | |   | |          \\/   ");
				System.out.println("     /\\         | | 2 | |          /\\   ");
				System.out.println("    /  \\        | |___| |         /  \\  ");
				System.out.println("   /    \\       |_______|        /    \\ ");
				win = 2;
			}else if(25 <= wheelLandsOn.getNumber() && wheelLandsOn.getNumber() <= 36){
				System.out.println("Since " + wheelLandsOn.getNumber() + " is in the range 25 - 36...");
				System.out.println("");
				TimeUnit.SECONDS.sleep(5);
				System.out.println("Third Card Wins!");
				System.out.println("   \\    /         \\    /        _______ ");
				System.out.println("    \\  /           \\  /        |  ___  |");
				System.out.println("     \\/             \\/         | |   | |");
				System.out.println("     /\\             /\\         | | 3 | |");
				System.out.println("    /  \\           /  \\        | |___| |");
				System.out.println("   /    \\         /    \\       |_______|");
				win = 3;
			}
			
			//Card number display
			if(card1.getDigits() == 1) {
				if(card2.getDigits() == 1) {
					if(card3.getDigits() == 1) {
						System.out.println("     " + card1.getNumber() + "              " + card2.getNumber() + "              " + card3.getNumber() + "  ");
					}else {
						System.out.println("     " + card1.getNumber() + "              " + card2.getNumber() + "              " + card3.getNumber() + "  ");
					}
				}else {
					if(card3.getDigits() == 1) {
						System.out.println("     " + card1.getNumber() + "              " + card2.getNumber() + "             " + card3.getNumber() + "  ");
					}else {
						System.out.println("     " + card1.getNumber() + "              " + card2.getNumber() + "             " + card3.getNumber() + "  ");
					}
				}
			}else {
				if(card2.getDigits() == 1) {
					if(card3.getDigits() == 1) {
						System.out.println("     " + card1.getNumber() + "             " + card2.getNumber() + "              " + card3.getNumber() + "  ");
					}else {
						System.out.println("     " + card1.getNumber() + "             " + card2.getNumber() + "              " + card3.getNumber() + "  ");
					}
				}else {
					if(card3.getDigits() == 1) {
						System.out.println("     " + card1.getNumber() + "             " + card2.getNumber() + "             " + card3.getNumber() + "  ");
					}else {
						System.out.println("     " + card1.getNumber() + "             " + card2.getNumber() + "             " + card3.getNumber() + "  ");
					}
				}
			}
			
			//Card color display
			// Combinations with Green
			if(card1.getColor() == "Green" && card2.getColor() == "Red" && card3.getColor() == "Red") {
				System.out.println("   Green           Red            Red ");
			}else if(card1.getColor() == "Green" && card2.getColor() == "Black" && card3.getColor() == "Black") {
				System.out.println("   Green          Black          Black");
			}else if(card1.getColor() == "Green" && card2.getColor() == "Red" && card3.getColor() == "Black") {
				System.out.println("   Green           Red           Black");
			}else if(card1.getColor() == "Green" && card2.getColor() == "Black" && card3.getColor() == "Red") {
				System.out.println("   Green          Black           Red ");
			}
			
			else if(card1.getColor() == "Red" && card2.getColor() == "Green" && card3.getColor() == "Red") {
				System.out.println("    Red           Green           Red ");
			}else if(card1.getColor() == "Black" && card2.getColor() == "Green" && card3.getColor() == "Black") {
				System.out.println("   Black          Green          Black");
			}else if(card1.getColor() == "Red" && card2.getColor() == "Green" && card3.getColor() == "Black") {
				System.out.println("    Red           Green          Black");
			}else if(card1.getColor() == "Black" && card2.getColor() == "Green" && card3.getColor() == "Red") {
				System.out.println("   Black          Green           Red ");
			}
			
			else if(card1.getColor() == "Red" && card2.getColor() == "Red" && card3.getColor() == "Green") {
				System.out.println("    Red            Red           Green");
			}else if(card1.getColor() == "Black" && card2.getColor() == "Black" && card3.getColor() == "Green") {
				System.out.println("   Black          Black          Green");
			}else if(card1.getColor() == "Red" && card2.getColor() == "Black" && card3.getColor() == "Green") {
				System.out.println("    Red           Black          Green");
			}else if(card1.getColor() == "Black" && card2.getColor() == "Red" && card3.getColor() == "Green") {
				System.out.println("   Black           Red           Green");
			}
			
			// Red and Black only Combinations
			else if(card1.getColor() == "Red" && card2.getColor() == "Red" && card3.getColor() == "Red") {
				System.out.println("    Red            Red            Red ");
			}else if(card1.getColor() == "Black" && card2.getColor() == "Black" && card3.getColor() == "Black") {
				System.out.println("   Black          Black          Black");
			}else if (card1.getColor() == "Black" && card2.getColor() == "Red" && card3.getColor() == "Red") {
				System.out.println("   Black           Red            Red");
			}else if (card1.getColor() == "Red" && card2.getColor() == "Black" && card3.getColor() == "Red") {
				System.out.println("    Red           Black           Red");
			}else if (card1.getColor() == "Red" && card2.getColor() == "Red" && card3.getColor() == "Black") {
				System.out.println("    Red            Red           Black");
			}else if(card1.getColor() == "Red" && card2.getColor() == "Black" && card3.getColor() == "Black") {
				System.out.println("    Red           Black          Black");
			}else if(card1.getColor() == "Black" && card2.getColor() == "Red" && card3.getColor() == "Black") {
				System.out.println("   Black           Red           Black");
			}else if(card1.getColor() == "Black" && card2.getColor() == "Black" && card3.getColor() == "Red") {
				System.out.println("   Black          Black           Red ");
			}
			
		}catch(InterruptedException e) {
			System.out.println(e);
		}
		
		// Returns whichever card got drawn (win)
		if(win == 1) {
			return card1;
		}else if(win == 2) {;
			return card2;
		}else if(win == 3) {
			return card3;
		}
		
		return null;
	}
	
	/**
	 * Purpose: A method when Roulette game is chosen. (Original Game)
	 * @return Roulette wheelLandsOn
	 */
	public Roulette spin(Roulette [] roulette) {
		//Initializes Random 
		Random rand = new Random();
		
		//Initializes and sets up random integer between 0-36 
		int randomIntForWheelNumber = rand.nextInt(37);
		
		//Initializes Roulette object (wheelLandsOn)
		Roulette wheelLandsOn = new Roulette(roulette[randomIntForWheelNumber]);
		
		//Used for wheel display
		//Initializes ball array 
		//Sets up ball elements with a space value
		String[] ball = new String[37];
		for(int i = 0; i < 37; i++) {
			ball[i] = " ";
		}
		
		//Sets up ball element at randomIntForWheelNumber index with a '*'
		ball[wheelLandsOn.getNumber()] = "*";
		
		//Starts Roulette game
		try{
			//Wheel display
			System.out.println(""); 
			System.out.println("Now we spin the wheel!!!"); 
			System.out.println("");
			TimeUnit.SECONDS.sleep(3);
			System.out.println("        ____  _  _ _  _  ____        ");
			System.out.println("       /   _03_26_0_32_15_   \\      ");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("      /35/" + ball[35] + " " + ball[3] + "  " + ball[26] + "  " + ball[0] + "  " + ball[32] + "  " + ball[15] + " " + ball[19] + "\\19\\     ");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("     /12/" + ball[12] + "                 " + ball[4] + "\\04\\    ");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("    /28/" + ball[28] + "                   " + ball[21] + "\\21\\   ");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("   /07/" + ball[7] + "                     " + ball[2] + "\\02\\  ");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("  /29/" + ball[29] + "                       " + ball[25] + "\\25\\ ");
			TimeUnit.SECONDS.sleep(1);
			System.out.println(" |18|" + ball[18] + "       Roulette Spin     " + ball[17] + "|17| ");
			TimeUnit.SECONDS.sleep(1);
			System.out.println(" |22|" + ball[22] + "                         " + ball[34] + "|34| ");
			TimeUnit.SECONDS.sleep(1);
			
			if(wheelLandsOn.getDigits() == 1){
				System.out.println(" |09|" + ball[9] + "            " + wheelLandsOn.getNumber() + "!           " + ball[6] + "|06| "); 
			}else if(wheelLandsOn.getDigits() == 2) {
				System.out.println(" |09|" + ball[9] + "           " + wheelLandsOn.getNumber() + "!           " + ball[6] + "|06| "); 
			}
			
			TimeUnit.SECONDS.sleep(1);
			System.out.println(" |31|" + ball[31] + "                         " + ball[27] + "|27|  ");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("  \\14\\" + ball[14] + "                       " + ball[13] + "/13/   ");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("   \\20\\" + ball[20] + "                     " + ball[36] + "/36/    ");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("    \\01\\" + ball[1]+ "                   " + ball[11] + "/11/     ");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("     \\33\\" + ball[33] + "                 " + ball[30] + "/30/      ");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("      \\16\\" + ball[16] + "__" + ball[24] + " _" + ball[5] + " _ " + ball[10] + "_ " + ball[23] + "__" + ball[8] + "/08/       ");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("       \\_____24_05_10_23_____/      ");
			System.out.println("");
			
		}catch(InterruptedException e) {
			System.out.println(e);
		}
		
		//Returns where wheel landed on (win)
		return wheelLandsOn;
	}
	
}
