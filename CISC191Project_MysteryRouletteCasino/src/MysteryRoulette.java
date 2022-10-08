import java.util.Random;
import java.util.Scanner;


public class MysteryRoulette {
	
	private Roulette[] wheel = new Roulette[37];
	private int spinCount = 0;
	
	
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
	
	public Roulette spin(Roulette [] wheel) {
		Random rand = new Random();
		int randomInt = rand.nextInt(37);
		
		Roulette win = new Roulette(wheel[randomInt]);
		
		//System.out.println(randomInt); // print randomInt
		//System.out.println(wheel[randomInt].toString()); //print roulette number and color
		int len = win.toString().length();
		//System.out.println(len);
		
		System.out.println("       ___________       ");
		System.out.println("     *             *     ");
		System.out.println("    *   Roulette    *    ");
		System.out.println("   *                 *   ");
		System.out.println(" |*|     Spin Is     |*| ");
		System.out.println(" |*|                 |*| ");
		
		if(win.getColor() == "Green"){
			System.out.println(" |*|     " + win.getNumber() + " " + win.getColor() + "     |*| "); 
		}else if(len == 5) {
			System.out.println(" |*|      " + win.getNumber() + " " + win.getColor() + "      |*| "); 
		}else if(len == 6) {
			System.out.println(" |*|     " + win.getNumber() + "  " + win.getColor() + "     |*| "); 
		}else if(len == 7) {
			System.out.println(" |*|     " + win.getNumber() + " " + win.getColor() + "     |*| "); 
		}else if(len == 8) {
			System.out.println(" |*|    " + win.getNumber() + "  " + win.getColor() + "    |*| "); 
		}

		
		System.out.println("   *                 *   ");
		System.out.println("    *      ...      *    ");
		System.out.println("     * ___________ *     ");
		
		System.out.println("But this is not the win!"); 
		System.out.println("Now we draw 3 Roulette Cards for Mystery Roulette! ");
		
		if(0 <= win.getNumber() && win.getNumber() <= 12){
			System.out.println("Since " + win.getNumber() + " is in the range 0 - 12...");
			System.out.println("First Card Wins!");
		}else if(13 <= win.getNumber() && win.getNumber() <= 24){
			System.out.println("Since " + win.getNumber() + " is in the range 13 - 24...");
			System.out.println("Second Card Wins!");
		}else if(25 <= win.getNumber() && win.getNumber() <= 36){
			System.out.println("Since " + win.getNumber() + " is in the range 25 - 36...");
			System.out.println("Third Card Wins!");
		}
		
		
		
		return win;
	}
	
}
