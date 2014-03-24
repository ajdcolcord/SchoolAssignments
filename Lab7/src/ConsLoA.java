
// Represents a non-empty List of Accounts...
public class ConsLoA implements ILoA{

    Account first;
    ILoA rest;

    public ConsLoA(Account first, ILoA rest){
        this.first = first;
        this.rest = rest;
    }
    
    /* Template
     *  Fields:
     *    ... this.first ...         --- Account
     *    ... this.rest ...          --- ILoA
     *
     *  Methods:
     *
     *  Methods for Fields:
     *
     */
    
    
    public Account getFirst() {
    	return this.first;
    }
    
    public ILoA getRest() {
    	return this.rest;
    }
    
}