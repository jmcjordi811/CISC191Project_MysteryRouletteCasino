import java.lang.String;
import java.awt.Color;

public class Roulette {
	
	private int number = 0;
	private String color = "";
	
	public Roulette(int number, String color) {
		this.number = number;
		this.color = color;
		//System.out.println(number + " " + color);
	}
	
	public Roulette(Roulette original) {
		this.number = original.getNumber();
		this.color = original.getColor();
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public String determineOddOrEven(int value) {
		String oddOrEven = "";
		if (value % 2 == 0) {
			oddOrEven = "Is even!";
		} else {
			oddOrEven = "Is odd!";
		}
		
		return oddOrEven;
	}
	
	public String toString() {
		return this.number + " " + this.color;
	}
	

}
