
// Represents a savings account
public class Savings extends Account{

    double interest; // The interest rate

    public Savings(int accountNum, int balance, String name, double interest){
        super(accountNum, balance, name);
        this.interest = interest;
    }
    
    public int withdraw(int amount) {
    	if (amount > this.balance) {
    		throw new RuntimeException(amount + " is not available");
    	}
    	else {
    		this.balance = this.balance - amount;
    		return this.balance;
    	}
    }
    
    public int deposit(int funds) {
    	this.balance = this.balance + funds;
    	return this.balance;
    }
}
