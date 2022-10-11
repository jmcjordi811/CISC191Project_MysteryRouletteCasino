import java.util.Random;
//import java.util.Scanner;


public class MysteryRoulette {
	
	private Roulette[] wheel = new Roulette[37];
	
	
	public MysteryRoulette() {
		
		// 0
		wheel[0] = new Roulette(0, "Green"); // 7
		
		// 1-12 set
		
		// 1st column
		wheel[1] = new Roulette(1, "Red"); // 5
		wheel[2] = new Roulette(2, "Black"); // 7
		wheel[3] = new Roulette(3, "Red"); // 5
		// 2nd column
		wheel[4] = new Roulette(4, "Black"); // 7
		wheel[5] = new Roulette(5, "Red"); // 5
		wheel[6] = new Roulette(6, "Black"); // 7
		// 3rd column
		wheel[7] = new Roulette(7, "Red"); // 5
		wheel[8] = new Roulette(8, "Black"); // 7
		wheel[9] = new Roulette(9, "Red"); // 5
		// 4th column
		wheel[10] = new Roulette(10, "Black"); // 8 
		wheel[11] = new Roulette(11, "Black"); // 8
		wheel[12] = new Roulette(12, "Red"); // 6
		
		// 13-24 set
		
		// 5th column
		wheel[13] = new Roulette(13, "Black"); // 8
		wheel[14] = new Roulette(14, "Red"); // 6
		wheel[15] = new Roulette(15, "Black"); // 8
		// 6th column
		wheel[16] = new Roulette(16, "Red"); // 6 
		wheel[17] = new Roulette(17, "Black"); // 8
		wheel[18] = new Roulette(18, "Red"); // 6
		// 7th column
		wheel[19] = new Roulette(19, "Red"); // 6
		wheel[20] = new Roulette(20, "Black"); // 8
		wheel[21] = new Roulette(21, "Red"); // 6
		// 8th column
		wheel[22] = new Roulette(22, "Black"); // 8
		wheel[23] = new Roulette(23, "Red"); // 6
		wheel[24] = new Roulette(24, "Black"); // 8
		
		//25-36 set
		
		// 9th column
		wheel[25] = new Roulette(25, "Red"); // 6
		wheel[26] = new Roulette(26, "Black"); // 8
		wheel[27] = new Roulette(27, "Red"); // 6
		// 10th column
		wheel[28] = new Roulette(28, "Black"); // 8
		wheel[29] = new Roulette(29, "Black"); // 8
		wheel[30] = new Roulette(30, "Red"); // 6
		// 11th column
		wheel[31] = new Roulette(31, "Black"); // 8
		wheel[32] = new Roulette(32, "Red"); // 6
		wheel[33] = new Roulette(33, "Black"); // 8
		// 12th column
		wheel[34] = new Roulette(34, "Red"); // 6
		wheel[35] = new Roulette(35, "Black"); // 8
		wheel[36] = new Roulette(36, "Red"); // 6

	}
	
	public Roulette[] getWheel() {
		return this.wheel;
	}
	
	public void spin(Roulette [] roulette) {
		Random rand = new Random();
		int randomIntForCard1 = rand.nextInt(37);
		int randomIntForCard2 = -1;
		int randomIntForCard3 = -1;
		while(randomIntForCard2 == -1 || randomIntForCard2 == randomIntForCard1) {
			randomIntForCard2 = rand.nextInt(37);
		}
		while(randomIntForCard3 == -1 || randomIntForCard3 == randomIntForCard1 || randomIntForCard3 == randomIntForCard2) {
			randomIntForCard3 = rand.nextInt(37);
		}
		
		int randomIntForWheelNumber = rand.nextInt(37);
		
		//System.out.println(randomIntForCard1 + " " + randomIntForCard2 + " " + randomIntForCard3 + " " + randomIntForWheelNumber);
		
		Roulette card1 = new Roulette(roulette[randomIntForCard1]);
		Roulette card2 = new Roulette(roulette[randomIntForCard2]);
		Roulette card3 = new Roulette(roulette[randomIntForCard3]);
		
		Roulette wheel = new Roulette(roulette[randomIntForWheelNumber]);
		
		//System.out.println(randomInt); // print randomInt
		//System.out.println(wheel[randomInt].toString()); //print roulette number and color
		int len = wheel.toString().length();
		//System.out.println(len);
		
		System.out.println("       ___________       ");
		System.out.println("     *             *     ");
		System.out.println("    *   Roulette    *    ");
		System.out.println("   *                 *   ");
		System.out.println(" |*|     Spin Is     |*| ");
		System.out.println(" |*|                 |*| ");
		
		if(wheel.getColor() == "Green"){
			System.out.println(" |*|     " + wheel.getNumber() + " " + wheel.getColor() + "     |*| "); 
		}else if(len == 5) {
			System.out.println(" |*|      " + wheel.getNumber() + " " + wheel.getColor() + "      |*| "); 
		}else if(len == 6) {
			System.out.println(" |*|     " + wheel.getNumber() + "  " + wheel.getColor() + "     |*| "); 
		}else if(len == 7) {
			System.out.println(" |*|     " + wheel.getNumber() + " " + wheel.getColor() + "     |*| "); 
		}else if(len == 8) {
			System.out.println(" |*|    " + wheel.getNumber() + "  " + wheel.getColor() + "    |*| "); 
		}

		
		System.out.println("   *                 *   ");
		System.out.println("    *      ...      *    ");
		System.out.println("     * ___________ *     ");
		
		System.out.println("But this is not the win!"); 
		System.out.println("Now we draw 3 Roulette Cards for Mystery Roulette! ");
		
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
		
		if(0 <= wheel.getNumber() && wheel.getNumber() <= 12){
			System.out.println("Since " + wheel.getNumber() + " is in the range 0 - 12...");
			System.out.println("First Card Wins!");
			System.out.println("  _______         \\    /         \\    /  ");
			System.out.println(" |  ___  |         \\  /           \\  /   ");
			System.out.println(" | |   | |          \\/             \\/    ");
			System.out.println(" | | 1 | |          /\\             /\\    ");
			System.out.println(" | |___| |         /  \\           /  \\   ");
			System.out.println(" |_______|        /    \\         /    \\  ");
		}else if(13 <= wheel.getNumber() && wheel.getNumber() <= 24){
			System.out.println("Since " + wheel.getNumber() + " is in the range 13 - 24...");
			System.out.println("Second Card Wins!");
			System.out.println("   \\    /        _______         \\    / ");
			System.out.println("    \\  /        |  ___  |         \\  /  ");
			System.out.println("     \\/         | |   | |          \\/   ");
			System.out.println("     /\\         | | 2 | |          /\\   ");
			System.out.println("    /  \\        | |___| |         /  \\  ");
			System.out.println("   /    \\       |_______|        /    \\ ");
		}else if(25 <= wheel.getNumber() && wheel.getNumber() <= 36){
			System.out.println("Since " + wheel.getNumber() + " is in the range 25 - 36...");
			System.out.println("Third Card Wins!");
			System.out.println("   \\    /         \\    /        _______ ");
			System.out.println("    \\  /           \\  /        |  ___  |");
			System.out.println("     \\/             \\/         | |   | |");
			System.out.println("     /\\             /\\         | | 3 | |");
			System.out.println("    /  \\           /  \\        | |___| |");
			System.out.println("   /    \\         /    \\       |_______|");
		}
		
		if(card1.getDigit() == 1) {
			if(card2.getDigit() == 1) {
				if(card3.getDigit() == 1) {
					System.out.println("     " + card1.getNumber() + "              " + card2.getNumber() + "              " + card3.getNumber() + "  ");
				}else {
					System.out.println("     " + card1.getNumber() + "              " + card2.getNumber() + "              " + card3.getNumber() + "  ");
				}
			}else {
				if(card3.getDigit() == 1) {
					System.out.println("     " + card1.getNumber() + "              " + card2.getNumber() + "             " + card3.getNumber() + "  ");
				}else {
					System.out.println("     " + card1.getNumber() + "              " + card2.getNumber() + "             " + card3.getNumber() + "  ");
				}
			}
		}else {
			if(card2.getDigit() == 1) {
				if(card3.getDigit() == 1) {
					System.out.println("     " + card1.getNumber() + "             " + card2.getNumber() + "              " + card3.getNumber() + "  ");
				}else {
					System.out.println("     " + card1.getNumber() + "             " + card2.getNumber() + "              " + card3.getNumber() + "  ");
				}
			}else {
				if(card3.getDigit() == 1) {
					System.out.println("     " + card1.getNumber() + "             " + card2.getNumber() + "             " + card3.getNumber() + "  ");
				}else {
					System.out.println("     " + card1.getNumber() + "             " + card2.getNumber() + "             " + card3.getNumber() + "  ");
				}
			}
		}
		
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
		
		
	}
	
}
