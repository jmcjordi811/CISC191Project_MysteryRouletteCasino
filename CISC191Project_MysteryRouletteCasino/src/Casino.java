import java.util.Scanner;

public class Casino {
	
	public Player[] player = new Player[3];
	public boolean[] ready2Play = new boolean[3];
	public int numberOfPlayers = 0;
	
	public Casino() {}
	
	public boolean playerPrompt(Scanner keyboard) {
		String userInput = "";
		boolean ready = false;
		
		while(ready == false) {
			userInput = keyboard.nextLine();
			
			if(userInput.isEmpty()) {
				System.out.println("How many players want to get added to the game? (Max: 3)");
				
				
				if(keyboard.hasNextInt()) {
					int number = keyboard.nextInt();
					if(1 <= number && number <= 3) {
						userInput = keyboard.nextLine();
						for(int i = 0; i < number; i++){
							int playerNum = i + 1;
							this.numberOfPlayers++;
							System.out.println("");
							System.out.println("Player " + playerNum + " type your name:");
							userInput = keyboard.nextLine();
							player[i] = new Player(userInput);
							ready2Play[i]= true;
							
							System.out.println("");
							System.out.println(" P" + playerNum + ": " + player[i].getName() +" Ready:" + ready2Play[i]);
							System.out.println("");
						}
						System.out.println("Players are ready to Play!");
						System.out.println("");
						ready = true;
					}else{
						System.out.println("");
						System.out.println("Please enter a number between 1-3.");
						System.out.println("");
					}
				}
			}else {
				if(userInput.equals("EndGame")) {
					System.out.println("Game has Ended!");
					keyboard.close();
					System.exit(0);
				}else {
					System.out.println("");
					System.out.println("Error: Please enter valid input!");
					System.out.println("(Press Enter/Return Key to continue!)");
				}
			}
		}
		
		return true;
		
	}
	
	public void betPrompt(Scanner keyboard) {
		String userInput = "";
		boolean ready = false;
		
		while(ready == false) {
			for(int i = 0; i < this.numberOfPlayers; i++) {
				int playerNumber = i +1;
				if(ready2Play[i] == true) {
					System.out.println(" P" + playerNumber + ": " + player[i].getName() + " - How much money do you wish to bet?");
					System.out.print(" $");
					if(keyboard.hasNextInt()) {
						int bet = keyboard.nextInt();
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
						if(userInput.equals("EndGame")) {
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
				}else if (ready2Play[i] == false){
					System.out.println(" P" + playerNumber + " - You are not in this game!");
					System.out.println("");	
					ready = true;
				}else {
					if(userInput.equals("EndGame")) {
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
	
	public void collectBets(Scanner keyboard, int i) {
		String betOn = "";
		int playerNumber = i + 1;
		boolean ready = false;
		
		while(ready == false) {
			betOn = keyboard.nextLine();
			if(betOn.isEmpty()) {
				
				System.out.println("What do you which to bet on?");
				System.out.println("");
				System.out.println(" Possible Bet Options:");
				System.out.println(" Red or Black (x2)");
				System.out.println(" Odd, Even (x2)");
				System.out.println(" Zero (x37)");
				System.out.println("");
				System.out.println("Please type your bet:");
				
			}else if(betOn.equals("Zero")) {
				player[i].setBettingOn(betOn);
				System.out.println("");
				System.out.println(" P" + playerNumber + ": Bet on Zero!");
				System.out.println("");
				ready = true;
			}else if(betOn.equals("Odd")) {
				player[i].setBettingOn(betOn);
				System.out.println("");
				System.out.println(" P" + playerNumber + ": Bet on Odd!");
				System.out.println("");
				ready = true;
			}else if(betOn.equals("Even")) {
				player[i].setBettingOn(betOn);
				System.out.println("");
				System.out.println(" P" + playerNumber + ": Bet on Even!");
				System.out.println("");
				ready = true;
			}else if(betOn.equals("Red")) {
				player[i].setBettingOn(betOn);
				System.out.println("");
				System.out.println(" P" + playerNumber + ": Bet on Red!");
				System.out.println("");
				ready = true;
			}else if(betOn.equals("Black")) {
				player[i].setBettingOn(betOn);
				System.out.println("");
				System.out.println(" P" + playerNumber + ": Bet on Black!");
				System.out.println("");
				ready = true;
			}else {
				if(betOn.equals("EndGame")) {
					System.out.println("Game has Ended!");
					keyboard.close();
					System.exit(0);
				}else {
					System.out.println("");
					System.out.println("Please press Enter/Return key.");
					System.out.println("");
				}
			}
		};
	}
	
	public void distributeWins(Roulette win) {
		boolean ready = false;
		
		while(ready == false) {
			for(int i = 0; i < this.numberOfPlayers; i++) {
				int playerNumber = i + 1;
				if(player[i].getBettingOn().equals("Zero") && win.getDigit() == 0) {
					player[i].getBankAccount().deposit(player[i].getBet()*37);
					System.out.println("");
					System.out.println(" P" + playerNumber + ": You Won! +" + player[i].getBet()*37);
					System.out.println(" Current Balance: $" + player[i].getBankAccount().getBalance());
					System.out.println("");
					player[i].setBet(0);
				}else if(player[i].getBettingOn().equals("Red") && win.getColor().equals("Red")) {
					player[i].getBankAccount().deposit(player[i].getBet()*2);
					System.out.println("");
					System.out.println(" P" + playerNumber + ": You Won! +" + player[i].getBet()*2);
					System.out.println(" Current Balance: $" + player[i].getBankAccount().getBalance());
					System.out.println("");
					player[i].setBet(0);
				}else if(player[i].getBettingOn().equals("Black") && win.getColor().equals("Black")) {
					player[i].getBankAccount().deposit(player[i].getBet()*2);
					System.out.println("");
					System.out.println(" P" + playerNumber + ": You Won! +" + player[i].getBet()*2);
					System.out.println(" Current Balance: $" + player[i].getBankAccount().getBalance());
					System.out.println("");
					player[i].setBet(0);
				}else if(player[i].getBettingOn().equals("Odd") && win.determineOddOrEven().equals("Odd")) {
					player[i].getBankAccount().deposit(player[i].getBet()*2);
					System.out.println("");
					System.out.println(" P" + playerNumber + ": You Won! +" + player[i].getBet()*2);
					System.out.println(" Current Balance: $" + player[i].getBankAccount().getBalance());
					System.out.println("");
					player[i].setBet(0);
				}else if(player[i].getBettingOn().equals("Even") &&  win.determineOddOrEven().equals("Even")) {
					player[i].getBankAccount().deposit(player[i].getBet()*2);
					System.out.println("");
					System.out.println(" P" + playerNumber + ": You Won! +" + player[i].getBet()*2);
					System.out.println(" Current Balance: $" + player[i].getBankAccount().getBalance());
					System.out.println("");
					player[i].setBet(0);
				}else {
					System.out.println("");
					System.out.println(" P" + playerNumber + ": Better Luck Next Time! -" + player[i].getBet());
					System.out.println(" Current Balance: $" + player[i].getBankAccount().getBalance());
					System.out.println("");
					player[i].setBet(0);
				}
			}
			ready = true;
		}
	}
	
	public void askIfContinuing(Scanner keyboard) {
		String userInput = "";
		boolean ready = false;
		
		while(ready == false) {
			
			if(userInput.isEmpty()) {
				System.out.println("Do you wish to continue playing? (Type 'Yes' or 'No')");
				System.out.println("");
				for(int i = 0; i < this.numberOfPlayers; i++) {
					int playerNumber = i + 1;
					System.out.print(" P" + playerNumber + "? ");
					userInput = keyboard.nextLine();
					
					if(userInput.equals("Yes")) {
						ready2Play[i] = true;
						System.out.println(" P" + playerNumber + ": In Game!");
						System.out.println("");
						
					}else if(userInput.equals("No")) {
						ready2Play[i] = false;
						System.out.println(" P" + playerNumber + ": Out of Game!");
						System.out.println("");
						
					}else {
						if(userInput.equals("EndGame")) {
							System.out.println("Game has Ended!");
							keyboard.close();
							System.exit(0);
						}else {
							System.out.println(" P" + playerNumber + ": Still In Game!");
							System.out.println("");
						}
					}
				}
				System.out.println("(Press Enter/Return Key to continue to game!)");
				ready = true;
				
			}else {
				if(userInput.equals("EndGame")) {
					System.out.println("Game has Ended!");
					keyboard.close();
					System.exit(0);
				}else {
					System.out.println("Error: Please enter valid input!");
					System.out.println("(Press Enter/Return Key to continue!)");
					System.out.println("");
				}
			}
		}
	}
	
	public void gameplay() {
		Scanner keyboard = new Scanner(System.in);
		String userInput = "";
		
		MysteryRoulette newGame = new MysteryRoulette();
		Roulette win = new Roulette();
		boolean started = false;
		
		while(!userInput.equals("EndGame")) {
			
			if(started == false) {
				started = playerPrompt(keyboard);
			}else if(userInput.isEmpty()) {
				System.out.println("Would you like to play Roulette or Mystery Roulette!");
				System.out.println("(Type R for Roulette or MR for Mystery Roulette)");
				userInput = keyboard.nextLine();
			}else if(userInput.equals("R")) {
				System.out.println("");
				System.out.println("Time for players to place bets!");
				System.out.println("");
				betPrompt(keyboard);
				
				System.out.println("You picked Roulette!");
				win = newGame.spin(newGame.getWheel());
				System.out.println("");
				System.out.println("The Lucky Number is " + win.getNumber() + " " + win.getColor() + "!!!");
				//System.out.println("(Press Enter/Return Key to continue!)");
				
				distributeWins(win);
				askIfContinuing(keyboard);
				userInput = keyboard.nextLine();
			}else if(userInput.equals("MR")) {
				System.out.println("");
				System.out.println("Time for players to place bets!");
				System.out.println("");
				betPrompt(keyboard);
				
				System.out.println("You picked Mystery Roulette!");
				win = newGame.playMysteryRoulette(newGame.getWheel());
				System.out.println("");
				System.out.println("The Lucky Number is " + win.getNumber() + " " + win.getColor() + "!!!");
				//System.out.println("(Press Enter/Return Key to continue!)");
				
				distributeWins(win);
				askIfContinuing(keyboard);
				userInput = keyboard.nextLine();
			}else {
				if(userInput.equals("EndGame")) {
					System.out.println("Game has Ended!");
					keyboard.close();
					System.exit(0);
				}else {
					System.out.println("");
					System.out.println("Error: Please enter valid input!");
					System.out.println("(Press Enter/Return Key to continue!)");
					System.out.println("");
				}
			}	
		}
		
		keyboard.close();
		
	}
	

	public static void main(String[] args) {
		
		System.out.println("Welcome to the Virtual Casino: Mystery Roulette!"); 
		System.out.println("(Press Enter/Return Key to continue!)");
		//System.out.println(""); 
		
		Casino virtualCasino = new Casino();
		virtualCasino.gameplay();
		
	}

}
