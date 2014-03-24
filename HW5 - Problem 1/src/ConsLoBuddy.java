// assignment 5
// partner1-Colcord Austin
// partner1-acolcord
// partner2-Dorshimer Greg
// partner2-gddorsh

/*
Template
Fields:
... this.first ... - Person
... this.rest ...  - ILoBuddy
Methods:
... this.directBuddy() ...   - boolean
... this.isEmpty() ...       - boolean
... this.isInList() ...      - boolean
... this.commonBuddies() ... - int
... this.isInNetwork() ...   - boolean
... this.buddyCount() ...    - int
Methods for Fields:
... this.rest.directBuddy() ...         - boolean
... this.rest.isInList() ...            - boolean
... this.rest.commonBuddies() ...       - int
... this.first.buddies.isInList() ...   - boolean
... this.rest.isInList() ...            - boolean
... this.first.buddies.buddyCount() ... - int
... this.rest.buddyCount() ...          - int
 */
// runs tests for the buddies problem
public class ConsLoBuddy implements ILoBuddy {
    Person first;
    ILoBuddy rest;

    //constructor
    ConsLoBuddy(Person first, ILoBuddy rest) {
        this.first = first;
        this.rest = rest;
    }

    // inList
    public boolean inList(Person that) {
        return this.first.equals(that) ||
                this.rest.inList(that);
    }

    // isEmpty()
    public boolean isEmpty() {
        return false;
    }

    // overlap
    public ILoBuddy overlap(ILoBuddy that) {
        if (that.isEmpty()) {
            return that;
        }
        else if (that.inList(this.first)) {
            return new ConsLoBuddy(this.first, this.rest.overlap(that));
        }
        else {
            return this.rest.overlap(that);
        }
    }

    // length()
    public int length() {
        return 1 + this.rest.length();
    }

    // append(ILoBuddy)
    public ILoBuddy append(ILoBuddy that) {
        return new ConsLoBuddy(this.first, this.rest.append(that));
    }

    // hasDistantBuddySub(Person, ILoBuddy)
    public boolean hasDistantBuddySub(Person that, ILoBuddy seen) {
        if (seen.inList(this.first)) {
            return this.rest.hasDistantBuddySub(that, seen);
        }        
        if (this.first.equals(that)) {
            return true;
        }
        else {
            seen = new ConsLoBuddy(this.first, seen);
            return this.first.buddies.hasDistantBuddySub(that, seen) ||
                    this.rest.hasDistantBuddySub(that, seen);
        }
    }
}





