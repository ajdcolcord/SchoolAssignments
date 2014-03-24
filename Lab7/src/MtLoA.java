
// Represents the empty List of Accounts
public class MtLoA implements ILoA{
    
    MtLoA() { }
    
    
    public Account getFirst() {
    	throw new RuntimeException("no acconts");
    }
    
    public ILoA getRest() {
    	return this;
    }
}

