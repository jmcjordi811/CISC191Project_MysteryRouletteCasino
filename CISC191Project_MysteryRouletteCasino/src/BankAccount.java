public class BankAccount {
	private int balance = 100;

	public BankAccount() {
	}
	
	public BankAccount(int money) {
		this.balance = money;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void deposit(int amount) {
		this.balance += amount;
	}
	
	public void loss(int amount) {
		this.balance -= amount;
	}
	
	public void casinoWinnings(int amount) {
		this.balance += amount;
	}
}