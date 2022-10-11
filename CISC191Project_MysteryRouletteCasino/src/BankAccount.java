public class BankAccount {
	private double balance = 0;

	public BankAccount() {
	}
	
	public BankAccount(double money) {
		this.balance = money;
	}
	
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	public void loss(double amount) {
		this.balance -= amount;
	}
	
	public void winnings(double amount) {
		this.balance += amount;
	}
}