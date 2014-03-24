import tester.*;
/*
           +---------------------+
           |                     |
           v                     |
      +---------+                |
      | ILoAddr |                |
      +---------+                |
          / \                    |
          ---                    |
           |                     |
    --------------------         |
    |                  |         |
+----------+   +---------------+ |
| MtLoAddr |   | ConsLoAddr    | |
+----------+   +---------------+ |
+----------+ +-| Address first | |
             | | ILoAddr rest  |-+
             | +---------------+
             v
      +--------------+
      | Address      |
      +--------------+
      | String city  |
      | String state |
      +--------------+
*/

//////////////////////////////////////////////////////////////////////////////
//ILOADDR
interface ILoAddr { 
    public int countInState(String st); 
}



//////////////////////////////////////////////////////////////////////////////
//MTLOADDR
class MtLoAddr implements ILoAddr {
    MtLoAddr() { }
    public int countInState(String st) {
        return 0;
    }
}


//////////////////////////////////////////////////////////////////////////////
//CONSLOADDR
class ConsLoAddr implements ILoAddr {
    Address first;
    ILoAddr rest;
    
    ConsLoAddr(Address first, ILoAddr rest) {
        this.first = first;
        this.rest = rest;
    }
    
    //countInState(String st) tells how many of the 
    // cities in the list are in the given state
    public int countInState(String st) {
        return this.first.countInState(st) 
                + this.rest.countInState(st);
    }
}


//////////////////////////////////////////////////////////////////////////////
//ADDRESS
class Address {
    String city;
    String state;
    
    Address(String city, String state) {
        this.city = city;
        this.state = state;
    }
    
    //countInState(String st) tells if this city is in the given state
    public int countInState(String st) {
        if (st.equals(this.state)) {
            return 1;
        }
        else {
            return 0;
        }
    }
}


//////////////////////////////////////////////////////////////////////////////
//EXAMPLES
class ExamplesAddresses {
    Address address1 = new Address("Boston", "MA");
    Address address2 = new Address("Springfield", "MA");
    Address address3 = new Address("Los Angeles", "CA");
    Address address4 = new Address("Seattle", "WA");
    
    ILoAddr listempty = new MtLoAddr();
    ILoAddr list1 = new ConsLoAddr(address1, listempty);
    ILoAddr list2 = new ConsLoAddr(address2, list1);
    ILoAddr list3 = new ConsLoAddr(address3, list2);
    ILoAddr list4 = new ConsLoAddr(address4, list3);
    
    //TESTS
    boolean testCountInState(Tester t) {
        return t.checkExpect(this.list4.countInState("MA"), 2) &&
               t.checkExpect(this.listempty.countInState("ME"), 0) &&
               t.checkExpect(this.list1.countInState("WA"), 0);
    }
}