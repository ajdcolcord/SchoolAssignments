
// represents a Person with a user name and a list of buddies
class Person {

    String username;
    ILoBuddy buddies;

    Person(String username) {
        this.username = username;
        this.buddies = new MTLoBuddy();
    }


    // EFFECT:
    // Change this person's buddy list so that it includes the given person
    void addBuddy(Person buddy) {
        this.buddies = new ConsLoBuddy(buddy, this.buddies);
    }

    // returns true if this Person has that as a direct buddy
    boolean hasDirectBuddy(Person that) {
        if (this.buddies.first().username.equals(that.username)) {
            return true;
        }
        else {
            return (this.buddies.rest().first().hasDirectBuddy(that));
        }
    }

    // returns the number of people who will show up at the party 
    // given by this person
    int partyCount(){
        return 1;
    }

    // returns the number of people that are direct buddies 
    // of both this and that person
    int countCommonBuddies(Person that) {
        return 1;
    }

    // will the given person be invited to a party 
    // organized by this person?
    boolean hasDistantBuddy(Person that) {
        return true;
    }

}
