public class BankAccount {
	private double balance = 100;

	public BankAccount() {
	}
	
	public BankAccount(double money) {
		this.balance = money;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	public void loss(double amount) {
		this.balance -= amount;
	}
	
	public void casinoWinnings(double amount) {
		this.balance += amount;
	}
}