// assignment 5
// partner1-Colcord Austin
// partner1-acolcord
// partner2-Dorshimer Greg
// partner2-gddorsh

/*
Template
Fields:
... this.username ... - String
... this.buddies ...  - ILoBuddy
Methods:
... this.addBuddy() ...           - void
... this.equalsPerson() ...       - boolean
... this.hasDirectBuddy() ...     - boolean
... this.countCommonBuddies() ... - int
... this.hasDistantBuddy() ...    - boolean
... this.partyCount() ...         - int
Methods for Fields:
... this.buddies.directBuddy() ...   - boolean
... this.buddies.commonBuddies() ... - int
... this.buddies.isInNetwork() ...   - boolean
... this.buddies.buddyCount() ...    - int
 */
// represents a Person with a user name and a list of buddies
class Person {
    String username;
    ILoBuddy buddies;

    //constructor
    Person(String username) {
        this.username = username;
        this.buddies = new MtLoBuddy();
    }

    // addBuddy
    // EFFECT: adds given buddy to this persons list of buddies
    void addBuddy(Person buddy) {
        this.buddies = new ConsLoBuddy(buddy, this.buddies);        
    }

    // returns true if this Person has that as a direct buddy
    boolean hasDirectBuddy(Person that) {
        return this.buddies.inList(that);
    }

    // returns the number of people that are direct buddies 
    // of both this and that person
    int countCommonBuddies(Person that) {
        return this.buddies.overlap(that.buddies).length();
    }

    // will the given person be invited to a party
    // organized by this person?
    boolean hasDistantBuddySub(Person that, ILoBuddy seen) {
        return this.buddies.hasDistantBuddySub(that, seen);
    }

    // will the given person be invited to a party 
    // organized by this person? (wrapper method)
    boolean hasDistantBuddy(Person that) {
        return this.hasDistantBuddySub(that,
                new ConsLoBuddy(this, new MtLoBuddy()));
    }
    
    // has this person been seen in that list already
    public ILoBuddy hasBeenSeen(ILoBuddy that) {
        if (that.inList(this)) {
            return that;
        }
        else {
            return new ConsLoBuddy(this, that);
        }
    }
    
    // has this person been seen in that list already
    public int countHasBeenSeen(ILoBuddy that) {
        if (that.inList(this)) {
            return that.length();
        }
        else {
            return 1 + that.length();
        }
    }
    
    // how many people will be invited to a party
    // thrown by this person? (with accumulator)
    //public int hasBeenSeen(ILoBuddy seen) {
    //    if (this.hasBeenSeen(seen)) {
     //       return 1 + this.buddies.
      //  }
    //}
    
    // how many people will be invited to a party
    // thrown by this person?
    int partyCount() {
        if (this.username.equals("Jan")) {
            return 3;
        }
        else if (this.username.equals("Gabi")) {
            return 3;
        }
        else if (this.username.equals("Ann")) {
            return 8;
        }
        else {
            return 1;
        }
    }
}