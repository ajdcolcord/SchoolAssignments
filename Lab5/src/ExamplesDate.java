import tester.*;
//ExamplesDate
public class ExamplesDate {
    Date d1 = new Date(2012, 3, 20);
    Date d2 = new Date(1999, 11, 29);
    Date d3 = new Date(2013, 10, 4);
    
    Date d4 = new Date(10, 4);
    Date d5 = new Date(9, 10);
    
    Date d6 = new Date("Apr", 5, 10);

    //validNumber test
    boolean testValidNumber(Tester t) {
        return t.checkExpect(this.d1.validNumber(100, 29, 191), true) &&
                t.checkExpect(this.d1.validNumber(100,  100,  100), true) &&
                t.checkExpect(this.d1.validNumber(80, 90, 101), false);
    }
    

boolean testConstructor(Tester t) {
    return t.checkConstructorException(
            // the expected exception
            new IllegalArgumentException("Invalid year: " + 53000),

            // the class whose constructor we invoke
            "Date",

            // the arguments for the constructor
            53000, 12, 30);
}}