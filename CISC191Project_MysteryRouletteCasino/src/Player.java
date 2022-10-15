public class Player implements Membership{
	private String name = null;
	private BankAccount account = null;
	private String bettingOn = null;
	private int bet = 0;	
	private boolean inGame = false;
	
	public Player() {	
	}
	
	public Player(String name) {	
		this.name = name;
		this.inGame = true;
		this.account = new BankAccount();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String player) {
		this.name = player;		
	}
	
	public BankAccount getBankAccount() {
		return this.account;
	}
	
	//
	public void setBankAccount(int budget) {
		this.account = new BankAccount(budget);
	}
	
	public void setBet(int playerBet) {
		this.bet = playerBet;
	}
	public int getBet() {
		return this.bet;
	}
	
	public void setBettingOn(String bettingOn) {
		this.bettingOn = bettingOn;
	}
	public String getBettingOn() {
		return this.bettingOn;
	}
	
	public void setinGame(boolean isPlayerInGame) {
		this.inGame = isPlayerInGame;
	}
	
	public boolean getInGame() {
		return this.inGame;
	}

	@Override
	public void addPoints() {
		// TODO Auto-generated method stub
		
	}	
}
