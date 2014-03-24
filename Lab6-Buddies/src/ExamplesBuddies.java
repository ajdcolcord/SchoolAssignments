import tester.*;


// runs tests for the buddies problem
public class ExamplesBuddies{
    Person ann = new Person("Ann");
    Person bob = new Person("Bob");
    Person cole = new Person("Cole");
    Person ed = new Person("Ed");
    Person hank = new Person("Hank");
    Person dan = new Person("Dan");
    Person fay = new Person("Fay");
    Person gabi = new Person("Gabi");
    Person jan = new Person("Jan");
    Person kim = new Person("Kim");
    Person len = new Person("Len");
    
    //addbuddy test
    void addBuddy() {
        this.ann.addBuddy(this.bob);
        this.ann.addBuddy(this.cole);
        this.bob.addBuddy(this.ann);
        this.bob.addBuddy(this.ed);
        this.bob.addBuddy(this.hank);
        this.cole.addBuddy(this.dan);
        this.dan.addBuddy(this.cole);
        this.ed.addBuddy(this.fay);
        this.fay.addBuddy(this.ed);
        this.fay.addBuddy(this.gabi);
        this.gabi.addBuddy(this.ed);
        this.gabi.addBuddy(this.fay);
        this.jan.addBuddy(this.kim);
        this.jan.addBuddy(this.len);
        this.kim.addBuddy(this.jan);
        this.kim.addBuddy(this.len);
        this.len.addBuddy(this.jan);
        this.len.addBuddy(this.kim);
    }
}