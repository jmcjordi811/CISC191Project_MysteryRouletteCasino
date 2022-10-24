import java.lang.String;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Lead Author(s):
 * @author Jordi Mejia
 * @author Jorge Arellano
 * 
 * References:
 * Tasha Frankie
 * 
 * <<add more references here>>
 *  
 * Version/date: 
 * 
 * Responsibilities of class:
 * Roulette class 
 */

public class Roulette {
	//---------- Fields ----------
	private int number = -1;
	private String color = null;
	private int digits = 0;
	
	//---------- Constructors ----------
	/**
	 * Purpose: No-parameter Constructor used to initialize class object with default values.
	 */
	public Roulette() {}
	
	/**
	 * Purpose: Constructor used to initialize class object with given parameters.
	 * @param int number
	 * @param String color
	 */
	public Roulette(int number, String color) {
		this.number = number;
		this.color = color;
		this.digits = Integer.toString(number).length();
	}
	
	/**
	 * Purpose: Copy Constructor used to initialize class object with given parameter.
	 * @param Roulette original
	 */
	public Roulette(Roulette original) {
		this.number = original.getNumber();
		this.color = original.getColor();
		this.digits = Integer.toString(original.getNumber()).length();
	}
	
	//---------- Methods ----------
	/**
	 * Purpose: Getter method for Roulette number.
	 * @return int number
	 */
	public int getNumber() {
		return this.number;
	}
	
	/**
	 * Purpose: Getter method for Roulette color.
	 * @return String color
	 */
	public String getColor() {
		return this.color;
	}
	
	/**
	 * Purpose: Getter method for Roulette digits (determines number's digits).
	 * @return int digits
	 */
	public int getDigits() {
		return this.digits;
	}
	
	/**
	 * Purpose: A method to determine if Roulette number is odd or even.
	 * @return String oddOrEven
	 */
	public String determineOddOrEven() {
		String oddOrEven = "";
		
		if (getNumber() % 2 == 0) {
			oddOrEven = "Even";
		} else {
			oddOrEven = "Odd";
		}
		
		return oddOrEven;
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
	
	/**
	 * Purpose: toString method to print out Roulette number and color.
	 * @return String "'number' 'color'";
	 */
	public String toString() {
		return this.number + " " + this.color;
	}

}
