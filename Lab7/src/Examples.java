import tester.*;

// Bank Account Examples and Tests
public class Examples {
	

    public Examples() { reset(); }
    
    Account check1;
    Account check2;
    Account check3;
    Account check4;
    Account savings1;
    Account savings2;
    Account savings3;
    Account savings4;
    Account credit1;
    Account credit2;
    Account credit3;
    ILoA mtloa;
    ILoA l1;
    ILoA l2;
    Bank bank1;
    Bank bank2;    
    
    
    // Initializes accounts to use for testing with effects.
    // We place inside reset() so we can "reuse" the accounts
    public void reset(){
        
        // Initialize the account examples
        check1 = new Checking(1, 100, "First Checking Account", 20);
        check2 = new Checking(2, 1000, "c2", 500);
        check3 = new Checking(3, 2000, "c3", 500);
        check4 = new Checking(4, 3000, "c4", 500);
    	savings1 = new Savings(4, 200, "First Savings Account", 2.5);
    	savings2 = new Savings(2, 8000, "s1", 0.1);
    	savings3 = new Savings(3, 8500, "s2", 0.15);
    	savings4 = new Savings(4, 8250, "s3", 0.2);
    	credit1 = new Credit(1, 1000, "cr1", 20000, 0.3);
    	credit2 = new Credit(2, 800, "cr2", 20000, 0.3);
    	credit3 = new Credit(3, 2500, "cr3", 20000, 0.3);
    	mtloa = new MtLoA();
    	l1 = new ConsLoA(this.check1, this.mtloa);
    	l2 = new ConsLoA(this.savings1, this.l1);
    	bank1 = new Bank("bank1", this.mtloa);
    	bank2 = new Bank("bank2", this.l1);
    }
    
    // Tests the exceptions we expect to be thrown when
    //   performing an "illegal" action.
    public void testExceptions(Tester t) {
        reset();
        t.checkException("Test for invalid Checking withdraw",
                         new RuntimeException("1000 is not available"),
                         this.check1,
                         "withdraw",
                         1000);
        t.checkException("Test for invalid Checking withdraw",
        		         new RuntimeException("5000 is not available"),
        		         this.check2,
        		         "withdraw",
        		         5000);
        reset();
    }
    
    
    // Test the deposit method(s)
    public void testWithdraw(Tester t) {
        reset();
        t.checkExpect(check1.withdraw(25), 75);
        t.checkExpect(check1.balance == 75);
        reset();
    }
    
    // test deposit
    public void testDeposit(Tester t) {
    	reset();
    	t.checkExpect(check1.deposit(100), 200);
    	t.checkExpect(check1.balance == 200);
    	t.checkExpect(savings1.deposit(100), 300);
    	t.checkExpect(savings1.balance == 300);
    	t.checkExpect(credit1.deposit(100), 900);
    	t.checkExpect(credit1.balance == 900);
    	reset();
    }
    
    // test Add
    public void testAdd(Tester t) {
    	reset();
    }
}
