// assignment 1
// pair xxx
// partner1-colcord-austin
// partner1-ajdcolcord
// partner2-su-jun
// partner2-jacklyso

// Problem 1

import tester.*;

//define Person
//each person has a name, yob, state, citizenship
class Person {
    String name;
    int yob;
    String state;
    boolean citizen;
    //constructor
    Person(String name, int yob, String state, boolean citizen) {
        this.name = name;
        this.yob = yob;
        this.state = state;
        this.citizen = citizen;
    }
}

//----------------------------------------------------------------------------
//Examples
class ExamplesPerson {
    Person alex = new Person("Alex", 1990, "CA", true);
    Person mary = new Person("Mary", 1972, "Arizona", false);
    Person joe = new Person("Joe", 1999, "Vermont", true);

    boolean testPeople(Tester t) {
        return t.checkExpect(
                this.alex, new Person("Alex", 1990, "CA", true)) &&
               t.checkExpect(
                this.mary, new Person("Mary", 1972, "Arizona", false)) &&
               t.checkExpect(
                this.joe, new Person("Joe", 1999, "Vermont", true));
    }
}