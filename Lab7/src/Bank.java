
// Represents a Bank with list of accounts
public class Bank {
    
    String name;
    ILoA accounts;
    
    public Bank(String name, ILoA accounts){
        this.name = name;

        // Each bank starts with no accounts
        this.accounts = new MtLoA();
    }
    
    // EFFECT: add a new account to his bank
    void add(Account acct) {
    	this.accounts = new ConsLoA(acct, this.accounts);
    }
    
    // EFFECT: deposits given amount into account with given number
    void deposit(int acctNum, int amount) {
    	if (acctNum == this.accounts.first.accountNum)
    }

}
