import java.util.Scanner;

public class Casino {
	
	public Player[] player = new Player[3];
	public int numberOfPlayers = 0;
	
	public Casino() {
	}
	
	public void playerPrompt(Scanner keyboard) {
		String userInput = "";
		
		boolean ready = false;
		
		while(ready == false) {
			userInput = keyboard.nextLine();
			System.out.println("How many players want to get added to the game? (Max: 3)");
			if(keyboard.hasNextInt()) {
				int number = keyboard.nextInt();
				if(1 <= number && number <= 3) {
					userInput = keyboard.nextLine();
					for(int i = 0; i < number; i++){
						int playerNum = i + 1;
						this.numberOfPlayers++;
						System.out.println("Player " + playerNum + " type your name:");
						userInput = keyboard.nextLine();
						player[i] = new Player(userInput);
						
						System.out.println("P" + playerNum + ": " + player[i].getName() +" Ready:" + player[i].getInGame());
						System.out.println("");
					}
					System.out.println("Players are ready to Play!");
					System.out.println("(Press Enter/Return Key to continue!)");
					ready = true;
				}else {
					userInput = keyboard.nextLine();
					if(userInput.isEmpty()) {
						System.out.println("");
						System.out.println("Please enter a number between 1-3.");
						System.out.println("");
					}else if(!userInput.isEmpty()){
						System.out.println("");
						System.out.println("Please press Enter/Return key.");
						System.out.println("");
					}
				}
			}else {
				userInput = keyboard.nextLine();
				if(userInput.isEmpty()) {
					System.out.println("");
					System.out.println("Please enter a valid number.");
					System.out.println("");
				}else if(!userInput.isEmpty()){
					System.out.println("");
					System.out.println("Please press Enter/Return key.");
					System.out.println("");
				}
			}
		}
		
	}
	
	public void betPrompt(Scanner keyboard) {
		String userInput = "";
		
		boolean ready = false;
		
		while(ready == false) {
			for(int i = 0; i < this.numberOfPlayers; i++) {
				int playerNumber = i +1;
				if(player[i].getInGame() == true) {
					System.out.println("");
					System.out.println("P" + playerNumber + ": " + player[i].getName() + " How much do you wish to bet?");
					if(keyboard.hasNextInt()) {
						int bet = keyboard.nextInt();
						if(bet <= player[i].getBankAccount().getBalance()) {
							player[i].getBankAccount().loss(bet);
							player[i].setBet(bet);
							
							System.out.println("");
							System.out.println("P" + playerNumber + " Current Balance: " +  player[i].getBankAccount().getBalance());
							System.out.println("");
							
							collectBets(keyboard, i);
							
							
						}else {
							userInput = keyboard.nextLine();
							if(userInput.isEmpty()) {
								System.out.println("");
								System.out.println("Insufficient funds!");
								System.out.println("");
							}else if(!userInput.isEmpty()){
								System.out.println("");
								System.out.println("Please press Enter/Return key.");
								System.out.println("");
							}
						}
					}else {
						userInput = keyboard.nextLine();
						if(userInput.isEmpty()) {
							System.out.println("");
							System.out.println("Please enter a positive ammount to bet.");
							System.out.println("");
						}else if(!userInput.isEmpty()){
							System.out.println("");
							System.out.println("Please press Enter/Return key.");
							System.out.println("");
						}
					}
				}else {
					userInput = keyboard.nextLine();
					if(userInput.isEmpty()) {
						System.out.println("");
						System.out.println("P" + playerNumber + ": " + " you are not in this game!");
						System.out.println("");
					}else if(!userInput.isEmpty()){
						System.out.println("");
						System.out.println("Please press Enter/Return key.");
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
				
				System.out.println("");
				System.out.println("What do you which to bet on?");
				System.out.println("");
				System.out.println("Possible Bet Options:");
				System.out.println("Red or Black");
				System.out.println("Zero, Odd, Even");
				System.out.println("");
				System.out.println("Please type your bet:");
				
			}else if(betOn.equals("Zero")) {
				player[i].setBettingOn(betOn);
				System.out.println("");
				System.out.println("You bet on Zero!");
				System.out.println("");
				ready = true;
			}else if(betOn.equals("Odd")) {
				player[i].setBettingOn(betOn);
				System.out.println("");
				System.out.println("You bet on Odd!");
				System.out.println("");
				ready = true;
			}else if(betOn.equals("Even")) {
				player[i].setBettingOn(betOn);
				System.out.println("");
				System.out.println("You bet on Even!");
				System.out.println("");
				ready = true;
			}else if(betOn.equals("Red")) {
				player[i].setBettingOn(betOn);
				System.out.println("");
				System.out.println("You bet on Red!");
				System.out.println("");
				ready = true;
			}else if(betOn.equals("Black")) {
				player[i].setBettingOn(betOn);
				System.out.println("");
				System.out.println("You bet on Black!");
				System.out.println("");
				ready = true;
			}else {
				if(betOn.isEmpty()) {
					System.out.println("");
					System.out.println("P" + playerNumber + ": " + " place your bet.!");
					System.out.println("");
				}else if(!betOn.isEmpty()){
					System.out.println("");
					System.out.println("Please press Enter/Return key.");
					System.out.println("");
				}
			}
		};
	}
	
	public void gameplay() {
		Scanner keyboard = new Scanner(System.in);
		String userInput = "";
		
		MysteryRoulette newGame = new MysteryRoulette();
		Roulette win = new Roulette();
		
		playerPrompt(keyboard);
		
		while(!userInput.equals("EndGame")) {
			userInput = keyboard.nextLine();
			
			if(userInput.isEmpty()) {
				System.out.println("Would you like to play Roulette or Mystery Roulette!");
				System.out.println("(Type R for Roulette or MR for Mystery Roulette)");
				
			}else if(userInput.equals("R")) {
				System.out.println("Time for players to place bets!");
				System.out.println("(Press Enter/Return Key to continue!)");
				betPrompt(keyboard);
				
				System.out.println("You picked Roulette!");
				win = newGame.spin(newGame.getWheel());
				System.out.println("");
				System.out.println("The Lucky Number is " + win.getNumber() + " " + win.getColor() + "!!!");
				System.out.println("");
			}else if(userInput.equals("MR")) {
				System.out.println("Time for players to place bets!");
				System.out.println("(Press Enter/Return Key to continue!)");
				betPrompt(keyboard);
				
				System.out.println("You picked Mystery Roulette!");
				win = newGame.playMysteryRoulette(newGame.getWheel());
			}else {
				if(userInput.equals("EndGame")) {
					System.out.println("Game has Ended!");
				}else {
					System.out.println("1 Error: Please enter valid keyboard!");
					System.out.println("");
				}
			}
			
			
		}
		System.out.println("Game has Ended!");
		
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
