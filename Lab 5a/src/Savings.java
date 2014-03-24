
// Represents a savings account
public class Savings extends Account{

    double interest; // The interest rate

    public Savings(int accountNum, int balance, String name, 
    		           double interest){
        super(accountNum, balance, name);
        this.interest = interest;
    }

    /* TEMPLATE:
     Fields:
     ... this.accountNum ...     -- int
     ... this.balance ...        -- int
     ... this.name ...           -- String
     ... this.interest ...       -- double
     
     Methods:
     ... this.amtAvailable() ...  -- int
     
     */
    
    // produce the amount available for withdrawal from this account
    public int amtAvailable(){
    	  return this.balance;
    }
    
    // tell if this account is the same as that
    public boolean sameSavings(Savings that) {
        return this.accountNum == that.accountNum &&
                this.balance == that.balance &&
                this.name == that.name &&
                this.interest == that.interest;
    }
    
    //tell that this account is a savings
    public boolean isSavings() {
        return true;
    }

    //tell if this account is not a checking
    public boolean isChecking() {
        return false;
    }

    // Produce a checking account from this account
    Savings toSavings() {
        return this;
    }

    // Produce a checking account from this account
    Checking toChecking() {
        throw new RuntimeException(
                "This Cannot Be a Checking Account: " + this.name);
    }
    

    // Is the given Account the same as this?
    public boolean same(Account that){
        if(that.isSavings()){
            return this.sameSavings(that.toSavings());
        } 
        else {
            return false;
        }
    }
}
