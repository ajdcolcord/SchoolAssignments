// represents a list of Person's buddies
class ConsLoBuddy implements ILoBuddy {

    Person first;
    ILoBuddy rest;

    ConsLoBuddy(Person first, ILoBuddy rest) {
        this.first = first;
        this.rest = rest;
    }
    
    //return the first of the list
    public Person first() {
        return this.first;
    }
    
    //return the rest of the list
    public ILoBuddy rest() {
        return this.rest;
    }

}
