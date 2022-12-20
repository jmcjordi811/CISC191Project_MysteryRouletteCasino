import java.util.Random;
//import java.util.concurrent.TimeUnit;

/**
 * Lead Author(s):
 * @author Jordi Mejia
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

public class MysteryRoulette extends Roulette{
	private Roulette card1;
	private Roulette card2; 
	private Roulette card3;
	
	Roulette wheelLandsOn;

	
	//---------- Constructor ----------
	/**
	 * Purpose: No-parameter Constructor used to initialize class object with default values.
	 */
	public MysteryRoulette() {}
	
	//---------- Methods ----------
	
	public Roulette getWheelLandsOn() {
		return this.wheelLandsOn;
	}
	
	/**
	 * Purpose: A method when Mystery Roulette game is chosen. (Variant Game)
	 * @return Roulette card1, card2, or card3 (depends on spin result)
	 */
	public Roulette[] playMysteryRoulette(Roulette spin) {
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
		card1 = new Roulette(this.getWheel()[randomIntForCard1]);
		card2 = new Roulette(this.getWheel()[randomIntForCard2]);
		card3 = new Roulette(this.getWheel()[randomIntForCard3]);
		
		//Initializes win integer
		//int win = -1;
		
		//Calls spin method for Original Roulette game
		wheelLandsOn = spin;
		
		//toString(wheelLandsOn, card1, card2, card3);
		
		Roulette[] cards = {card1, card2, card3};
		
		
		return cards;
	}
	
	/**
	 * Purpose: A method when Mystery Roulette game is chosen with toString console animation. (Variant Game)
	 * @return Roulette card1, card2, or card3 (depends on spin result)
	 */
	public Roulette[] playMysteryRouletteWithtoString(Roulette spin) {
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
		card1 = new Roulette(this.getWheel()[randomIntForCard1]);
		card2 = new Roulette(this.getWheel()[randomIntForCard2]);
		card3 = new Roulette(this.getWheel()[randomIntForCard3]);
		
		//Initializes win integer
		//int win = -1;
		
		//Calls spin method for Original Roulette game
		wheelLandsOn = spin;
		
		toString(wheelLandsOn, card1, card2, card3);
		
		Roulette[] cards = {card1, card2, card3};
		
		
		return cards;
	}
	
	public String toString(Roulette wheelLandsOn, Roulette card1, Roulette card2, Roulette card3) {
		//Starts MysteryRoulette game
//		try{
			//Explains how MysteryRoulette game works
			//Card display
//			TimeUnit.SECONDS.sleep(3);
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
			System.out.println("");
			
//			TimeUnit.SECONDS.sleep(3);
			//Initializes win integer
			int win = -1;
			
			
			//Reminds player(s) that this is not the win, the Roulette card we flip is the win
//			System.out.println("Remember this is not the win..."); 
//			System.out.println("");
			
			//Drawn card display with discarded cards
			if(0 <= wheelLandsOn.getNumber() && wheelLandsOn.getNumber() <= 12){
				System.out.println("Since " + wheelLandsOn.getNumber() + " is in the range 0 - 12...");
				System.out.println("");
//				TimeUnit.SECONDS.sleep(5);
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
//				TimeUnit.SECONDS.sleep(5);
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
//				TimeUnit.SECONDS.sleep(5);
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
			
//		}catch(InterruptedException e) {
//			System.out.println(e);
//		}
			
			
			
			
		// Returns whichever card got drawn (win)
		if(win == 1) {
			return card1.getNumber() + card1.getColor();
		}else if(win == 2) {
			return card2.getNumber() + card2.getColor();
		}else if(win == 3) {
			return card3.getNumber() + card3.getColor();
		}	
		return "Error!";
	}
}