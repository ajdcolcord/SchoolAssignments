import tester.*;

// Bank Account Examples and Tests
public class ExamplesBanking {
	
    public ExamplesBanking(){}
    
    Account check1 = new Checking(1, 100, "First Checking Account", 20);
    Account check2 = new Checking(2, 700, "Long Term Checking Account", 40);
    Account check3 = new Checking(3, 20, "Emergency Checking", 5);
    Account check4 = new Checking(1, 100, "First Checking Account", 20);
    
    Account savings1 = new Savings(4, 200, "First Savings Account", 2.5);
    Account savings2 = new Savings(5, 1000, "Long Term Savings Account", 300);
    Account savings3 = new Savings(6, 300, "Emergency Savings", 5);
    Account savings4 = new Savings(6, 300, "Emergency Savings", 5);
    
    // Tests the exceptions we expect to be thrown when
    //   performing an "illegal" action.
    public boolean testAmtAvailable(Tester t){
    	  return
      t.checkExpect(this.check1.amtAvailable(), 80) &&
      t.checkExpect(this.savings1.amtAvailable(), 200) &&
      t.checkExpect(this.check2.amtAvailable(), 660) &&
      t.checkExpect(this.savings2.amtAvailable(), 1000);
    }
   
    // test the method 'same()'
    public boolean testSame(Tester t) {
        return
                t.checkExpect(this.check1.same(this.check2), false) &&
                t.checkExpect(this.check1.same(this.check1), true) &&
                t.checkExpect(this.check4.same(this.check1), true) &&
                t.checkExpect(this.check2.same(this.savings1), false) &&
                t.checkExpect(this.savings4.same(this.savings3), true);
    }
    
    
}
