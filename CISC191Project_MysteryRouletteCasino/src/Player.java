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
	private BankAccount account = new BankAccount();
	private String bettingOn = null;
	private int bettingOnNumber = -1;
	private int bet = 0;
	
	
//  private static String[] possibleBets = {number0, ..., number36,
//											row1, row2, row3,
//											group1_12, group13_24, group25_36, group1_18, group19_36,
//											even, odd, red, black}
	private int[] betOnRoulette = new int[49];
	private int[] betOnMysteryRoulette = new int[49];
	
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
		this.account = new BankAccount(100);
		this.bettingOn = "";
	}
	
	/**
	 * Purpose: Constructor used to initialize class object with given parameter.
	 * @param int bettingMoney
	 */
	public Player(int bettingMoney) {	
		this.account = new BankAccount(bettingMoney);
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
	
	/**
	 * Purpose: Getter method for Player betOnRoulette array.
	 * @return int betOnRoulette
	 */
	public int[] getBetOnRoulette() {
		return this.betOnRoulette;
	}
	
	/**
	 * Purpose: Setter method for Player betOnRoulette.
	 */
	public void setBetOnRoulette(int index, int bet) {
		this.betOnRoulette[index] += bet;
	}
	
	/**
	 * Purpose: Refresh Player betOnRoulette array elements to 0.
	 */
	public void refreshBetOnRoulette() {
		this.betOnRoulette = new int [49];
	}
	
	/**
	 * Purpose: Getter method for Player betOnMysteryRoulette array.
	 * @return int betOnMysteryRoulette
	 */
	public int[] getBetOnMysteryRoulette() {
		return this.betOnMysteryRoulette;
	}
	
	/**
	 * Purpose: Setter method for Player betOnMysteryRoulette.
	 */
	public void setBetOnMysteryRoulette(int index, int bet) {
		this.betOnMysteryRoulette[index] += bet;
	}
	
	/**
	 * Purpose: Refresh Player betOnMysteryRoulette array elements to 0.
	 */
	public void refreshBetMysteryOnRoulette() {
		this.betOnMysteryRoulette = new int [49];
	}
}
