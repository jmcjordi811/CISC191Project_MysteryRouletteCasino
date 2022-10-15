import java.lang.String;

public class Roulette {
	
	private int number = -1;
	private String color = null;
	private int digit = 0;
	
	public Roulette() {
		
	}
	
	public Roulette(int number, String color) {
		this.number = number;
		this.color = color;
		this.digit = Integer.toString(number).length();
		//System.out.println(number + " " + color);
	}
	
	public Roulette(Roulette original) {
		this.number = original.getNumber();
		this.color = original.getColor();
		this.digit = Integer.toString(original.getNumber()).length();
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public int getDigit() {
		return this.digit;
	}
	
	public String determineOddOrEven() {
		String oddOrEven = "";
		
		if (getNumber() % 2 == 0) {
			oddOrEven = "Even";
		} else {
			oddOrEven = "Odd";
		}
		
		return oddOrEven;
	}
	
	public String toString() {
		return this.number + " " + this.color;
	}

}
