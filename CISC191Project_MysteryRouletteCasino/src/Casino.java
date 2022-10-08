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
		System.out.println("  _______        _______        _______ ");
		System.out.println(" |  ___  |      |  ___  |      |  ___  |");
		System.out.println(" | |   | |      | |   | |      | |   | |");
		System.out.println(" | | 1 | |      | | 2 | |      | | 2 | |");
		System.out.println(" | |___| |      | |___| |      | |___| |");
		System.out.println(" |_______|      |_______|      |_______|");
		System.out.println("    FLIP           FLIP           FLIP");
		System.out.println("    THIS           THIS           THIS");
		System.out.println("    CARD           CARD           CARD");
		System.out.println("     IF             IF             IF");
		System.out.println(" 0<=SPIN<=12   13<=SPIN<=24   25<=SPIN<=36");
		System.out.println(""); 
		System.out.println("(Press Enter Key to start!)");
		//System.out.println(""); 
		
		Casino virtualCasino = new Casino();
		virtualCasino.gameplay();
		
	}

}
