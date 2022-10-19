/**
 * Lead Author(s):
 * @author Jorge Arellano
 * @author Jordi Mejia
 * 
 * References:
 * Tasha Frankie
 * <<add more references here>>
 *  
 * Version/date: 
 * 
 * Responsibilities of class:
 * Player class 
 */

public class Player {
	//---------- Fields ----------
	private String name = null;
	private BankAccount account = null;
	private String bettingOn = null;
	private int bettingOnNumber = -1;
	private int bet = 0;
	
	//---------- Constructor ----------
	/**
	 * Purpose: No-parameter Constructor used to initialize class object with default values.
	 */
	public Player() {}
	
	/**
	 * Purpose: Constructor used to initialize class object with given parameter.
	 * @param String name
	 */
	public Player(String name) {	
		this.name = name;
		this.account = new BankAccount();
		this.bettingOn = "";
	}
	
	//---------- Methods ----------
	/**
	 * Purpose: Getter method for Player name.
	 * @return String name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Purpose: Setter method for Player name.
	 */
	public void setName(String player) {
		this.name = player;		
	}
	
	/**
	 * Purpose: Getter method for Player BankAccount account.
	 * @return BankAccount account
	 */
	public BankAccount getBankAccount() {
		return this.account;
	}
	
	/**
	 * Purpose: Setter method for Player BankAccount account. //not used
	 */
	public void setBankAccount(int budget) {
		this.account = new BankAccount(budget);
	}
	
	/**
	 * Purpose: Getter method for Player bet.
	 * @return int bet
	 */
	public int getBet() {
		return this.bet;
	}
	
	/**
	 * Purpose: Setter method for Player bet.
	 */
	public void setBet(int playerBet) {
		this.bet = playerBet;
	}
	
	/**
	 * Purpose: Getter method for Player bettingOn.
	 * @return String bettingOn
	 */
	public String getBettingOn() {
		return this.bettingOn;
	}
	
	/**
	 * Purpose: Setter method for Player bettingOn.
	 */
	public void setBettingOn(String bettingOn) {
		this.bettingOn = bettingOn;
	}
	
	/**
	 * Purpose: Getter method for Player bettingOnNumber.
	 * @return int bettingOnNumber
	 */
	public int getBettingOnNumber() {
		return this.bettingOnNumber;
	}
	
	/**
	 * Purpose: Setter method for Player bettingOnNumber.
	 */
	public void setBettingOnNumber(int bettingOnNumber) {
		this.bettingOnNumber = bettingOnNumber;
	}	
}
