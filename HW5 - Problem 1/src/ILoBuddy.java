// assignment 5
// partner1-Colcord Austin
// partner1-acolcord
// partner2-Dorshimer Greg
// partner2-gddorsh

/* CLASS DIAGRAM

        +-----------+
        |  ILoBuddy |
        +-----------+
              ^
              |
        +-----+-----+
        |           |
+-----------+   +--------------------+
| MTLoBuddy |   |     ConsLoBuddy    |
+-----------+   +--------------------+
                |  Person   first    |--+
                |  ILoBuddy rest     |  |
                +--------------------+  |
                                        |
                                        V
                                 +------------------+
                                 |   Person         |
                                 +------------------+
                                 | String  username |
                                 | ILoBuddy buddies |
                                 +------------------+


*/
// represents a list of Person's buddies
interface ILoBuddy {
    
    // determines if given person is in this list of buddies
    boolean inList(Person that);
    
    // isEmpty()
    // determines if this is empty
    boolean isEmpty();
    
    // returns a list of the buddies that
    // this list and given list have in common
    ILoBuddy overlap(ILoBuddy that);
    
    // returns length of this list
    int length();
    
    // append this list and given list
    ILoBuddy append(ILoBuddy that);
    
    // hasDistantBuddy
    boolean hasDistantBuddySub(Person that, ILoBuddy seen);
}

