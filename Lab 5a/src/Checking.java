
// Represents a checking account
public class Checking extends Account{

    int minimum; // The minimum account balance allowed

    public Checking(int accountNum, int balance, String name, int minimum){
        super(accountNum, balance, name);
        this.minimum = minimum;
    }

    /* TEMPLATE:
     Fields:
     ... this.accountNum ...     -- int
     ... this.balance ...        -- int
     ... this.name ...           -- String
     ... this.minimum ...        -- int
     
     Methods:
     ... this.amtAvailable() ...  -- int
     
     */
    
    // produce the amount available for withdrawal from this account
    public int amtAvailable(){
    	  return this.balance - this.minimum;
    }
    
    // tell if this account is the same as that
    private boolean sameChecking(Checking that) {
        return this.accountNum == that.accountNum &&
                this.balance == that.balance &&
                this.name == that.name &&
                this.minimum == that.minimum;
    }
    // tell that this account is a checking
    public boolean isChecking() {
        return true;
    }
    //tell this account is not a savings
    public boolean isSavings() {
        return false;
    }
    // Produce a checking account from this account
    Checking toChecking() {
        return this;
    }
    
    // Produce a checking account from this account
    Savings toSavings() {
        throw new RuntimeException(
                "This Cannot Be a Savings Account: " + this.name);
    }

    // Is the given Account the same as this?
    public boolean same(Account that){
        if(that.isChecking()){
            return this.sameChecking(that.toChecking());
        } 
        else {
            return false;
        }
    }
}