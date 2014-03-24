// assignment 5
// partner1-Colcord Austin
// partner1-acolcord
// partner2-Dorshimer Greg
// partner2-gddorsh

/*
Template
Methods:
... this.directBuddy() ...   - boolean
... this.isEmpty() ...       - boolean
... this.isInList() ...      - boolean
... this.commonBuddies() ... - int
... this.isInNetwork() ...   - boolean
... this.buddyCount() ...    - int
 */

// represents an empty list of Person's buddies
class MtLoBuddy implements ILoBuddy {
    //constructor
    MtLoBuddy() {
        // empty constructor
    }

    // inList
    public boolean inList(Person that) {
        return false;
    }
    // isEmpty
    public boolean isEmpty() {
        return true;
    }

    // overlap
    public ILoBuddy overlap(ILoBuddy that) {
        return this;
    }

    // length()
    public int length() {
        return 0;
    }

    // append(ILoBuddy)
    public ILoBuddy append(ILoBuddy that) {
        return that;
    }

    // hasDistantBuddy(Person, ILoBuddy)
    public boolean hasDistantBuddySub(Person that, ILoBuddy seen) {
        return false;
    }
}

