import java.lang.String;

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
	 * Purpose: toString method to print out Roulette number and color.
	 * @return String "'number' 'color'";
	 */
	public String toString() {
		return this.number + " " + this.color;
	}

}
