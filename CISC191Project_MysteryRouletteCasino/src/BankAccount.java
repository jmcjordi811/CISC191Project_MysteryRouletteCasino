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
 * BankAccount class 
 */

public class BankAccount {
	//---------- Field ----------
	private int balance = 100;

	//---------- Constructor ----------
	/**
	 * Purpose: No-parameter Constructor used to initialize class object with default values.
	 */
	public BankAccount() {}
	
	/**
	 * Purpose: Constructor used to initialize class object with given parameter.
	 * @param int money
	 */
	public BankAccount(int money) {
		this.balance = money;
	}
	
	//---------- Methods ----------
	/**
	 * Purpose: Getter method for BankAccount balance.
	 * @return int balance
	 */
	public int getBalance() {
		return this.balance;
	}
	
	/**
	 * Purpose: A method to deposit money.
	 * @param int amount
	 */
	public void deposit(int amount) {
		this.balance += amount;
	}
	
	/**
	 * Purpose: A method to subtract money.
	 * @param int amount
	 */
	public void loss(int amount) {
		this.balance -= amount;
	}
}