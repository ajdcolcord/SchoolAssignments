
// Represents a checking account
public class Checking extends Account{

    int minimum; // The minimum account balance allowed

    public Checking(int accountNum, int balance, String name, int minimum){
        super(accountNum, balance, name);
        this.minimum = minimum;
    }
    
    public int withdraw(int amount) {
    	if ((this.balance - amount) < this.minimum) {
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
    
    //
}
