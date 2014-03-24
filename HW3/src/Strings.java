// assignment 3
// partner1-Colcord-Austin
// partner1-acolcord
// partner2-Su-Jun
// partner2-jacklyso

import tester.*;


/* Class Diagram

                  +------------------------+
                  |         ILoS           |
                  +------------------------+
                             ^
                             |
                             |
                             |
           +-----------------+-------------------+
           |                                     |
           v                                     v
+------------------------+           +------------------------+
|        MtLoS           |           |       ConsLoS          |
+------------------------+           +------------------------+
+------------------------+           |String         first    |
|String     combine()    |           |ILoS           rest     |
|boolean    compareAlph()|           +------------------------+
|String     firstList()  |           |String     combine()    |
|ILoS       restList()   |           |boolean    compareAlph()|
|boolean    isSorted()   |           |String     firstList()  |
|ILoS       merge()      |           |ILoS       restList()   |
+------------------------+           |boolean    isSorted()   |
                                     |ILoS       merge()      |
                                     +------------------------+


*/

//////////////////////////////////////////////////////////////////////////////
//ILoS
/* Template
Methods:
...this.combine()...                - String
...this.compareAlph(String that)... - boolean
...this.firstList()...              - String
...this.restList()...               - ILoS
...this.isSorted()...               - boolean
...this.merge(ILoS that)...         - ILoS
 */
// to represent a list of Strings
interface ILoS {
    // combine all Strings in this list into one
    String combine();
    
    //compares two items and returns true if this String
    //comes alphabetically before that
    boolean compareAlph(String that);
    
    //returns the first of the list
    String firstList();
    
    //return the rest of the list
    ILoS restList();
    
    // tell if the list is sorted in alphabetical order
    boolean isSorted();
    
    //merge two lists together in alphabetical order
    ILoS merge(ILoS that);
}


//////////////////////////////////////////////////////////////////////////////
//MtLoS
/* Template
Methods:
...this.combine()...                - String
...this.compareAlph(String that)... - boolean
...this.firstList()...              - String
...this.restList()...               - ILoS
...this.isSorted()...               - boolean
...this.merge(ILoS that)...         - ILoS
 */
// to represent an empty list of Strings
class MtLoS implements ILoS {
    MtLoS() { // no constructor since this is an empty list 
    }
    

    // combine all Strings in this list into one
    public String combine() {
        return "";
    }  
    
    // compares two items to see if they are in alphabetical order
    public boolean compareAlph(String that) {
        return true;
    }
    
    // return the first of the list
    public String firstList() {
        return "";
    }
    
    //return the rest of the list
    public ILoS restList() {
        return this;
    }
    // tells if the list is sorted
    public boolean isSorted() {
        return true;
    }
    
    //merge two list together in alphabetical order
    public ILoS merge(ILoS that) {
        return that;
    }
}


//////////////////////////////////////////////////////////////////////////////
//ConsLoS
/*
TEMPLATE
FIELDS:
...this.first...  - String
...this.rest...   - ILoS

METHODS
...this.combine()...                - String
...this.compareAlph(String that)... - boolean
...this.firstList()...              - String
...this.restList()...               - ILoS
...this.isSorted()...               - boolean
...this.merge(ILoS that)...         - ILoS

METHODS FOR FIELDS
...this.first.concat(String) ...       - String
...this.first.compareTo(String) ...    - int
...this.rest.combine() ...             - String
...this.first.toLowerCase()...         - String
...this.rest.isSorted()...             - boolean
...this.rest.firstList()...            - String
...this.rest.merge()...                - ILoS

   */
// to represent a nonempty list of Strings
class ConsLoS implements ILoS {
    String first;
    ILoS rest;

    ConsLoS(String first, ILoS rest) {
        this.first = first;
        this.rest = rest;  
    }

    // combine all Strings in this list into one
    public String combine() {
        return this.first.concat(this.rest.combine());
    }  
    
    // compares two items to see if they are in alphabetical order
    public boolean compareAlph(String that) {
        if (that.equals("")) {
            return true;
        }
        else {
            return (this.first.toLowerCase().compareTo(that.toLowerCase()) 
                    <= 0);
        }
    }
    
    // tells what the first of the list is
    public String firstList() {
        return this.first;
    }
    
    // tells what the rest of the list is
    public ILoS restList() {
        return this.rest;
    }
    
    // tells if the list is sorted
    public boolean isSorted() {
        if (this.compareAlph(this.rest.firstList())) {
            return (this.rest.isSorted());
        }
        else {
            return false;
        }
    }
    
    //merge two lists together in alphabetical order
    public ILoS merge(ILoS that) {
        if (this.compareAlph(that.firstList())) {
            return new ConsLoS(this.first, this.rest.merge(that));
        }
        else {
            return new ConsLoS(that.firstList(), this.merge(that.restList()));
        }
    }
}


//////////////////////////////////////////////////////////////////////////////
//EXAMPLES
// to represent examples for lists of strings
class ExamplesStrings {
    //ExamplesStrings() { }
    
    String bee = "bee";
    String cee = "cee";
    String empty = "";
    
    
    ILoS emptylist = new MtLoS();
    
    ILoS meow = new ConsLoS("meow!", this.emptylist);
    ILoS goes = new ConsLoS("goes ", this.meow);
    ILoS cat = new ConsLoS("Cat ", this.goes);
    
    ILoS lamb = new ConsLoS("lamb.", this.emptylist);
    ILoS little = new ConsLoS("little ", this.lamb);
    ILoS a = new ConsLoS("a ", this.little);
    ILoS had = new ConsLoS("had ", this.a);
    ILoS mary = new ConsLoS("Mary ", this.had);
    
    ILoS lista = new ConsLoS("Cat ",
            new ConsLoS("goes ", 
                    new ConsLoS("lamb.", 
                            new ConsLoS("meow!", this.emptylist))));
  
    //Combine Examples
    boolean testCombine(Tester t) {
        return t.checkExpect(this.mary.combine(), "Mary had a little lamb.") &&
               t.checkExpect(this.cat.combine(), "Cat goes meow!");
    }
    
    //CompareAlph Examples
    boolean testCompareAlph(Tester t) {
        return t.checkExpect(this.mary.compareAlph(this.bee), false) && 
               t.checkExpect(this.cat.compareAlph(this.cee), true) &&
               t.checkExpect(this.emptylist.compareAlph(""), true) &&
               t.checkExpect(this.meow.compareAlph(""), true);
    }
    
    //FirstList Examples
    boolean testFirstList(Tester t) {
        return t.checkExpect(this.cat.firstList(), "Cat ") &&
               t.checkExpect(this.emptylist.firstList(), "") &&
               t.checkExpect(this.meow.firstList(), "meow!");
    }
    
    //RestList Examples
    boolean testRestList(Tester t) {
        return t.checkExpect(this.emptylist.restList(), this.emptylist) &&
               t.checkExpect(this.lamb.restList(), this.emptylist) &&
               t.checkExpect(this.a.restList(), this.little);
    }
    
    //IsSorted Examples
    boolean testIsSorted(Tester t) {
        return  t.checkExpect(this.cat.isSorted(), true) &&
                t.checkExpect(this.little.isSorted(), false) &&
                t.checkExpect(this.mary.isSorted(), false) &&
                t.checkExpect(this.emptylist.isSorted(), true) &&
                t.checkExpect(this.meow.isSorted(), true);
    }
    
    //TestMerge Examples
    boolean testMerge(Tester t) {
        return t.checkExpect(this.cat.merge(this.emptylist), this.cat) &&
                t.checkExpect(this.cat.merge(this.lamb), this.lista);
    }
}