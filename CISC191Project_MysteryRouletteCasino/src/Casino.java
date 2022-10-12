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
			
			System.out.println("Draw 3 Roulette Cards for Mystery Roulette! ");
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
			System.out.println("Now we spin the wheel!!!"); 
			System.out.println(""); 
			
			userInput = keyboard.nextLine();
			MysteryRoulette newGame = new MysteryRoulette();
			Roulette spinResult = newGame.spin(newGame.getWheel());
			
			userInput = keyboard.nextLine();
			newGame.playMysteryRoulette(newGame.getWheel(), spinResult);
		
	        userInput = keyboard.nextLine();    
		}
		
		// Kill Scanner
	    keyboard.close();
		
	}
	

	public static void main(String[] args) {
		
		System.out.println("Welcome to the Virtual Casino: Mystery Roulette!"); 
		System.out.println("(Press Enter Key to start!)");
		//System.out.println(""); 
		
		Casino virtualCasino = new Casino();
		virtualCasino.gameplay();
		
	}

}
