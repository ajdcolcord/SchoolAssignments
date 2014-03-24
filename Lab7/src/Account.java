
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
    
    //EFFECT: withdraw the given amount
    // return the new balance
    abstract int withdraw(int amount);
    
    //EFFECT: deposit the given funds into this account
    //return the new balance
    abstract int deposit(int funds);
}