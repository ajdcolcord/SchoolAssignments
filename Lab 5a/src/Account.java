
// Represents a bank account
public abstract class Account {

    int accountNum;  // Must be unique
    int balance;     // Must remain above zero (others Accts have more restrictions)
    String name;     // Name on the account

    public Account(int accountNum, int balance, String name){
        this.accountNum = accountNum;
        this.balance = balance;
        this.name = name;
    }
    
    // produce the amount available for withdrawal from this account
    public abstract int amtAvailable();
    
    // is this account the same as that account
    public boolean same(Account that) {
        return this.accountNum == that.accountNum &&
                this.balance == that.balance &&
                this.name == that.name;
    }

    // Convert this Account into a Checking
    abstract Checking toChecking();

    // Convert this Account into a Savings
    abstract Savings toSavings();
    
    abstract boolean isChecking();
    
    abstract boolean isSavings();
}
