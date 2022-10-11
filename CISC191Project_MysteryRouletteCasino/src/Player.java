public class Player {
	private String name;
	private BankAccount account;
	private int bet;	
	private boolean inGame;
	
	
	
	//
	public String getName() {
		return this.name;
	}
	
	// identifying the player to organize the games winners and pay out will also keep players informed 
	public void setName(String player) {
		this.name = player;		
	}
	
	//
	public BankAccount getBankAccount() {
		return this.account;
	}
	
	// will set how much money each individual player will have in their account
	public void setBankAccount(double budget) {
		this.account = new BankAccount(budget);
	}
	
	//-------------V
	
	// will track what the player will bet on 
	public void setBet(int plyrBet) {
		bet = plyrBet;
	}
	public int getBet() {
		return bet;
	}
	
	public void setinGame(boolean isPlyrInGame) {
		inGame = isPlyrInGame;
	}
	
	public boolean inGame() {
		return inGame;
	}	
}
