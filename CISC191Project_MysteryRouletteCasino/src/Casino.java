import java.util.Scanner;

public class Casino {
	
	public Casino() {
		
	}
	
	public void gameplay() {
		Scanner keyboard = new Scanner(System.in);
		String userInput = keyboard.nextLine();
		
		while(userInput.isEmpty()) {
			
			if(userInput == "Q"){
	        	break;
	        }
			
			MysteryRoulette newGame = new MysteryRoulette();
			newGame.spin(newGame.getWheel());
	        
	        userInput = keyboard.nextLine();
		}
		
		// Kill Scanner
	    keyboard.close();
		
	}
	

	public static void main(String[] args) {
		
		System.out.println("Welcome to the Virtual Casino: Mystery Roulette!");
		//System.out.println("");
		
		Casino virtualCasino = new Casino();
		virtualCasino.gameplay();
		
	}

}
