import java.util.Scanner;
import java.io.*;

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
 * Casino class 
 */

public class Casino {
	//---------- Fields ----------
	public Player[] player = new Player[4];
	public boolean[] ready2Play = new boolean[4];
	public boolean[] cashout = new boolean[4];
	public int numberOfPlayers = 0;
	
	//---------- Constructor ----------
	/**
	 * Purpose: No-parameter Constructor used to initialize class object with default values.
	 */
	public Casino() {}
	
	//---------- Methods ----------
	/**
	 * Purpose: A method with a prompt to get number of players and their info. 
	 * 			Continues gameplay method and Scanner.
	 * 			Only called once and at the beginning of game.
	 * @param Scanner keyboard
	 * @return boolean true
	 */
	public boolean playerPrompt(Scanner keyboard) {
		String userInput = "";
		int number;
		boolean ready = false;
		
		while(!ready) {
			if(userInput.isEmpty()) {
				System.out.println("How many players want to get added to the game? (Max: 4)");
				
				if(keyboard.hasNextInt()) {
					number = keyboard.nextInt();
					
					if(1 <= number && number <= 4) {
						userInput = keyboard.nextLine();
						for(int i = 0; i < number; i++){
							int playerNum = i + 1;
							this.numberOfPlayers++;
							System.out.println("");
							System.out.print("Player " + playerNum + " type your name: ");
							userInput = keyboard.nextLine();
							
							player[i] = new Player(userInput);
							ready2Play[i] = true;
							cashout[i] = false;
							System.out.println("");
							System.out.println(" P" + playerNum + ": " + player[i].getName() +" Ready: " + ready2Play[i]);
							System.out.println(" New Player! You get $100 to start playing, on the house!");
							System.out.println("");
						}
						System.out.println("Players are ready to Play!");
						System.out.println("");
						ready = true;
					}else{
						System.out.println("");
						System.out.println("Please enter a number between 1-4.");
						System.out.println("");
						userInput = keyboard.nextLine();
					}
				}else {
					userInput = keyboard.nextLine();
				}
			}else {
				if(userInput.equalsIgnoreCase("EndGame")) {
					System.out.println("Game has Ended!");
					keyboard.close();
					System.exit(0);
				}else {
					System.out.println("");
					System.out.println("Error: Please enter valid input!");
					System.out.println("(Press Enter/Return Key to continue!)");
					userInput = keyboard.nextLine();
				}
			}
			
			
		}
		
		return true;
		
	}
	
	/**
	 * Purpose: A method with a prompt to get the bet(s) from player(s).
	 * 			Continues gameplay method and Scanner.
	 * 			Repeats each time game starts.
	 * @param Scanner Keyboard
	 */
	public void betPrompt(Scanner keyboard) {
		String userInput = "";
		boolean ready = false;
		
		while(!ready) {
			for(int i = 0; i < this.numberOfPlayers; i++) {
				int playerNumber = i +1;
				if(ready2Play[i] && !cashout[i]) {
					System.out.println(" P" + playerNumber + ": " + player[i].getName() + " - How much money do you wish to bet?");
					System.out.print(" $");
					if(keyboard.hasNextInt()) {
						int bet = keyboard.nextInt();
						userInput = keyboard.nextLine();
						if(0 < bet && bet <= player[i].getBankAccount().getBalance()) {
							player[i].getBankAccount().loss(bet);
							player[i].setBet(bet);
							
							System.out.println("");
							System.out.println(" P" + playerNumber + " - Current Balance: $" +  player[i].getBankAccount().getBalance());
							System.out.println("");
							
							collectBets(keyboard, i);
							
						}else if(bet > player[i].getBankAccount().getBalance()) {
							System.out.println("");
							System.out.println(" P" + playerNumber + " - Failed to collect bet!");
							System.out.println(" Insufficient Funds!");
							System.out.println("");
						}else if(bet <= 0) {
							System.out.println("");
							System.out.println(" P" + playerNumber + " - Failed to collect bet!");
							System.out.println(" No Negative or Zero Bets!");
							System.out.println("");
						}
					}else{
						if(userInput.equalsIgnoreCase("EndGame")) {
							System.out.println("Game has Ended!");
							keyboard.close();
							System.exit(0);
						}else {
							userInput = keyboard.nextLine();
							System.out.println("");
							System.out.println(" P" + playerNumber + " - Failed to collect bet!");
							System.out.println(" " + userInput + " is an invalid input!");
							System.out.println("");
						}
					}
				}else if (cashout[i]){
					System.out.println(" P" + playerNumber + " - You are no longer playing!");
					System.out.println("");	
					//ready = true;
				}else if (!ready2Play[i]){
					System.out.println(" P" + playerNumber + " - You are not in this game!");
					System.out.println("");	
					//ready = true;
				}else {
					if(userInput.equalsIgnoreCase("EndGame")) {
						System.out.println("Game has Ended!");
						keyboard.close();
						System.exit(0);
					}else {
						System.out.println(" P" + playerNumber + " - Failed to collect bet!");
						System.out.println("");
					}
				}
			}
			ready = true;
		}
	}
	
	/**
	 * Purpose: A method with a prompt to get what the player(s) wish to bet on.
	 * 			Continues gameplay method and Scanner.
	 * 			Repeats each time game starts.
	 * @param Scanner Keyboard
	 */
	public void collectBets(Scanner keyboard, int i) {
		String betOn = "";
		int numberBet = -1;
		int playerNumber = i + 1;
		boolean ready = false;
		
		while(!ready) {
		
			if(betOn.isEmpty()) {
				System.out.println("What do you wish to bet on?");
				System.out.println("");
				System.out.println(" Possible Bet Options:");
				System.out.println("");
				System.out.println(" Red or Black (x2)");
				System.out.println(" Odd, Even (x2)");
				System.out.println(" Zero (x37)");
				System.out.println(" Number 1-36 (x37)");
				System.out.println("");
				System.out.println("Please type your bet:");
				if(keyboard.hasNextInt()) {
					numberBet = keyboard.nextInt();
					betOn = keyboard.nextLine();
				}else {
					betOn = keyboard.nextLine();
				}
				
				if(numberBet != -1 && 1 <= numberBet && numberBet <= 36) {
					player[i].setBettingOnNumber(numberBet);
					System.out.println("");
					System.out.println(" P" + playerNumber + ": Bet on " + numberBet + "!");
					System.out.println("");
					ready = true;
				}else if(betOn.equalsIgnoreCase("Zero")) {
					player[i].setBettingOn(betOn);
					System.out.println("");
					System.out.println(" P" + playerNumber + ": Bet on Zero!");
					System.out.println("");
					ready = true;
				}else if(betOn.equalsIgnoreCase("Odd")) {
					player[i].setBettingOn(betOn);
					System.out.println("");
					System.out.println(" P" + playerNumber + ": Bet on Odd!");
					System.out.println("");
					ready = true;
				}else if(betOn.equalsIgnoreCase("Even")) {
					player[i].setBettingOn(betOn);
					System.out.println("");
					System.out.println(" P" + playerNumber + ": Bet on Even!");
					System.out.println("");
					ready = true;
				}else if(betOn.equalsIgnoreCase("Red")) {
					player[i].setBettingOn(betOn);
					System.out.println("");
					System.out.println(" P" + playerNumber + ": Bet on Red!");
					System.out.println("");
					ready = true;
				}else if(betOn.equalsIgnoreCase("Black")) {
					player[i].setBettingOn(betOn);
					System.out.println("");
					System.out.println(" P" + playerNumber + ": Bet on Black!");
					System.out.println("");
					ready = true;
				}else {
					System.out.println("Error: Please enter valid input!");
					System.out.println("(Press Enter/Return Key to continue!)");
					System.out.println("");
					betOn = keyboard.nextLine();
				}
				
			}else if(betOn.equalsIgnoreCase("EndGame")) {
				System.out.println("Game has Ended!");
				keyboard.close();
				System.exit(0);
			}
			
		}
	}
	
	/**
	 * Purpose: A method with a prompt to distribute wins or report losses at the end of a game.
	 * 			Takes Roulette win as parameter in order to compare with player bet(s).
	 * 			Continues gameplay method.
	 * 			Repeats each time game ends.
	 * @param Roulette win
	 */
	public void distributeWins(Roulette win) {
		boolean ready = false;
		
		while(!ready) {
			for(int i = 0; i < this.numberOfPlayers; i++) {
				int playerNumber = i + 1;
				if(player[i].getBettingOnNumber() == -1 && player[i].getBettingOn() == null) {
					System.out.println("");
					System.out.println(" P" + playerNumber + ": You did not bet on this game!");
					System.out.println(" Current Balance: $" + player[i].getBankAccount().getBalance());
					System.out.println("");
				}else if(player[i].getBettingOnNumber() != -1 && win.getNumber() == player[i].getBettingOnNumber()) {
					player[i].getBankAccount().deposit(player[i].getBet()*37);
					System.out.println("");
					System.out.println(" P" + playerNumber + ": You Won! +" + player[i].getBet()*37);
					System.out.println(" Current Balance: $" + player[i].getBankAccount().getBalance());
					System.out.println("");
					player[i].setBet(0);
					player[i].setBettingOnNumber(-1);
				}else if(player[i].getBettingOn().equalsIgnoreCase("Zero") && win.getNumber() == 0) {
					player[i].getBankAccount().deposit(player[i].getBet()*37);
					System.out.println("");
					System.out.println(" P" + playerNumber + ": You Won! +" + player[i].getBet()*37);
					System.out.println(" Current Balance: $" + player[i].getBankAccount().getBalance());
					System.out.println("");
					player[i].setBet(0);
					player[i].setBettingOn(null);
				}else if(player[i].getBettingOn().equalsIgnoreCase("Red") && win.getColor().equalsIgnoreCase("Red")) {
					player[i].getBankAccount().deposit(player[i].getBet()*2);
					System.out.println("");
					System.out.println(" P" + playerNumber + ": You Won! +" + player[i].getBet()*2);
					System.out.println(" Current Balance: $" + player[i].getBankAccount().getBalance());
					System.out.println("");
					player[i].setBet(0);
					player[i].setBettingOn(null);
				}else if(player[i].getBettingOn().equalsIgnoreCase("Black") && win.getColor().equalsIgnoreCase("Black")) {
					player[i].getBankAccount().deposit(player[i].getBet()*2);
					System.out.println("");
					System.out.println(" P" + playerNumber + ": You Won! +" + player[i].getBet()*2);
					System.out.println(" Current Balance: $" + player[i].getBankAccount().getBalance());
					System.out.println("");
					player[i].setBet(0);
					player[i].setBettingOn(null);
				}else if(player[i].getBettingOn().equalsIgnoreCase("Odd") && win.determineOddOrEven().equalsIgnoreCase("Odd")) {
					player[i].getBankAccount().deposit(player[i].getBet()*2);
					System.out.println("");
					System.out.println(" P" + playerNumber + ": You Won! +" + player[i].getBet()*2);
					System.out.println(" Current Balance: $" + player[i].getBankAccount().getBalance());
					System.out.println("");
					player[i].setBet(0);
					player[i].setBettingOn(null);
				}else if(player[i].getBettingOn().equalsIgnoreCase("Even") &&  win.determineOddOrEven().equalsIgnoreCase("Even")) {
					player[i].getBankAccount().deposit(player[i].getBet()*2);
					System.out.println("");
					System.out.println(" P" + playerNumber + ": You Won! +" + player[i].getBet()*2);
					System.out.println(" Current Balance: $" + player[i].getBankAccount().getBalance());
					System.out.println("");
					player[i].setBet(0);
					player[i].setBettingOn(null);
				}else {
					System.out.println("");
					System.out.println(" P" + playerNumber + ": Better Luck Next Time! -" + player[i].getBet());
					System.out.println(" Current Balance: $" + player[i].getBankAccount().getBalance());
					System.out.println("");
					player[i].setBet(0);
					player[i].setBettingOn(null);
				}
			}
			ready = true;
		}
	}
	
	/**
	 * Purpose: A method with a prompt to ask player(s) if they wish to continue playing.
	 * 			Continues gameplay method and Scanner.
	 * 			Repeats each time game ends.
	 * @param Scanner Keyboard
	 */
	public void askIfContinuing(Scanner keyboard) {
		String userInput = "";
		boolean ready = false;
		
		while(!ready) {
			
			if(userInput.isEmpty()) {
				System.out.println("Do you wish to continue playing?");
				System.out.println("(Type 'Yes' if you wish to continue playing)");
				System.out.println("(Type 'Skip' if you wish to skip game)");
				System.out.println("(Type 'Cashout' if you are done playing)");
				System.out.println("");
				for(int i = 0; i < this.numberOfPlayers; i++) {
					int playerNumber = i + 1;
					if(cashout[i]) {
						System.out.println(" P" + playerNumber + ": You are no longer playing!");
						System.out.println("");
					}else {
						System.out.print(" P" + playerNumber + "? ");
						userInput = keyboard.nextLine();
						
						if(userInput.equalsIgnoreCase("Yes")) {
							ready2Play[i] = true;
							System.out.println(" P" + playerNumber + ": In Game!");
							System.out.println("");
							
						}else if(userInput.equalsIgnoreCase("Skip")) {
							ready2Play[i] = false;
							System.out.println(" P" + playerNumber + ": Out of Game!");
							System.out.println("");
							
						}else if(userInput.equalsIgnoreCase("Cashout")) {
							ready2Play[i] = false;
							cashout[i] = true;
							System.out.println(" P" + playerNumber + ": Thank you for playing!");
							System.out.println("");
							try {
								File cashout = new File ("cashoutP" + playerNumber + ".txt");
							    FileWriter fileWriter = new FileWriter (cashout);
							    PrintWriter printWriter = new PrintWriter (fileWriter);
							    printWriter.println ("P" + playerNumber + ": " + player[i].getName());
							    printWriter.println ("Cashout: " + player[i].getBankAccount().getBalance());
							    printWriter.close();
							}catch (IOException e) {
								System.out.println(e);
							}
							
						}else {
							if(userInput.equalsIgnoreCase("EndGame")) {
								System.out.println("Game has Ended!");
								keyboard.close();
								System.exit(0);
							}else {
								System.out.println(" P" + playerNumber + ": Still In Game!");
								System.out.println("");
							}
						}
					}
				}
				System.out.println("(Press Enter/Return Key to continue to game!)");
				ready = true;
				
			}else {
				if(userInput.equalsIgnoreCase("EndGame")) {
					System.out.println("Game has Ended!");
					keyboard.close();
					System.exit(0);
				}else {
					System.out.println("Error: Please enter valid input!");
					System.out.println("(Press Enter/Return Key to continue!)");
					System.out.println("");
					userInput = keyboard.nextLine();
				}
			}
			
		}
	}
	
	/**
	 * Purpose: A method which runs the Roulette and MysteryRoulette game.
	 * 			Repeats until 'EndGame' kill switch is typed.
	 */
	public void gameplay() {
		Scanner keyboard = new Scanner(System.in);
		String userInput = keyboard.nextLine();
		
		MysteryRoulette newGame = new MysteryRoulette();
		Roulette win = new Roulette();
		boolean started = false;
		
		while(!userInput.equalsIgnoreCase("EndGame")) {
			
			if(userInput.isEmpty()) {
				if(!started) {
					started = playerPrompt(keyboard);
				}
				
				System.out.println("Would you like to play Roulette or Mystery Roulette!");
				System.out.println("(Type R for Roulette or MR for Mystery Roulette)");
				userInput = keyboard.nextLine();
				
				if(userInput.equalsIgnoreCase("R")) {
					System.out.println("");
					System.out.println("Time for players to place bets!");
					System.out.println("");
					betPrompt(keyboard);
					
					System.out.println("You picked Roulette!");
					win = newGame.spin(newGame.getWheel());
					System.out.println("");
					System.out.println("The Lucky Number is " + win.getNumber() + " " + win.getColor() + "!!!");
					
					distributeWins(win);
					askIfContinuing(keyboard);
					userInput = keyboard.nextLine();
				}else if(userInput.equalsIgnoreCase("MR")) {
					System.out.println("");
				System.out.println("Time for players to place bets!");
					System.out.println("");
					betPrompt(keyboard);
					
					System.out.println("You picked Mystery Roulette!");
					win = newGame.playMysteryRoulette(newGame.getWheel());
					System.out.println("");
					System.out.println("The Lucky Number is " + win.getNumber() + " " + win.getColor() + "!!!");
					
					distributeWins(win);
					askIfContinuing(keyboard);
					userInput = keyboard.nextLine();
				}
			}else {
				if(userInput.equalsIgnoreCase("EndGame")) {
					System.out.println("Game has Ended!");
					keyboard.close();
					System.exit(0);
				}else {
					System.out.println("");
					System.out.println("*Error: Please enter valid input!");
					System.out.println("(Press Enter/Return Key to continue!)");
					System.out.println("");
					userInput = keyboard.nextLine();
				}
			}	
			
			
		}
		
		keyboard.close();
		
	}
	
	/**
	 * Purpose: Main method which initializes Casino and starts gameplay.
	 */
	public static void main(String[] args) {
		
		System.out.println("Welcome to the Virtual Casino: Mystery Roulette!"); 
		System.out.println("(Press Enter/Return Key to continue!)"); 
		
		Casino virtualCasino = new Casino();
		virtualCasino.gameplay();
		
	}

}	
