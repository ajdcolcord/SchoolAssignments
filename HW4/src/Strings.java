import tester.*;

//STRINGSCOMPARE
interface StringsCompare {
    public boolean comesBefore(String s1, String s2);
}

//STRINGLEXCOMP
//represents a function object that compares strings lexicographically
class StringLexComp implements StringsCompare {
    public boolean comesBefore(String s1, String s2) {
        if (s2.equals("")) {
            return true;
        }
        else {
            return (s1.compareTo(s2) <= 0);
        }
    }
}


//STRINGLENGTHCOMP
class StringLengthComp implements StringsCompare {
    public boolean comesBefore(String s1, String s2) {
        return (s1.length() <= s2.length());
    }
}

/* Class Diagram

               +------------------------+
               |         ILoS           |<-----------------------+
               +------------------------+                        |
               +------------------------+                        |
               |String     combine()    |                        |
               |String     firstList()  |                        |
               |ILoS       restList()   |                        |
               |boolean    isSorted()   |                        |
               |ILoS       merge()      |                        |
               |ILoS       insert()     |                        |
               |ILoS       sort()       |                        |
               +------------------------+                        |
                          ^                                      |
                          |                                      |
                          |                                      |
                          |                                      |
        +-----------------+-------------------+                  |
        |                                     |                  |
        v                                     v                  |
+------------------------+           +------------------------+  |
|        MtLoS           |           |       ConsLoS          |  |
+------------------------+           +------------------------+  |
+------------------------+           |String         first    |  |
|String     combine()    |           |ILoS           rest     |--+
|String     firstList()  |           +------------------------+
|ILoS       restList()   |           |String     combine()    |
|boolean    isSorted()   |           |String     firstList()  |
|ILoS       merge()      |           |ILoS       restList()   |
|ILoS       insert()     |           |boolean    isSorted()   |
|ILoS       sort()       |           |ILoS       merge()      |
+------------------------+           |ILoS       insert()     |
                                     |ILoS       sort()       |
                                     +------------------------+



*/

//////////////////////////////////////////////////////////////////////////////
//ILOS

//to represent a list of Strings
interface ILoS {
    // combine all Strings in this list into one
    String combine();

    //returns the first of the list
    String firstList();

    //return the rest of the list
    ILoS restList();

    // tell if the list is sorted in order
    boolean isSorted();

    //merge two lists together in order
    ILoS merge(ILoS that);

    //insert the string into the proper place
    ILoS insert(StringsCompare function, String s);

    //sort the two strings into a list given with the desired order
    ILoS sort(StringsCompare function);
}


//////////////////////////////////////////////////////////////////////////////
//MTLOS

/*
TEMPLATE
METHODS:
... this.combine() ...     -- String
... this.firstList()...    -- String
... this.restList()...     -- String
... this.isSorted()...     -- boolean
... this.merge()...        -- ILoS
... this.insert()...       -- ILoS
... this.sort()...         -- ILoS
*/

//to represent an empty list of Strings
class MtLoS implements ILoS {
    MtLoS() {
        //this is an empty list
    }


    //////////////////////////////////////////////////////////////////////////
    //MTLOS METHODS
    // combine all Strings in this list into one
    public String combine() {
        return "";
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

    //insert the given string into the proper place
    public ILoS insert(StringsCompare function, String s) {
        return new ConsLoS(s, new MtLoS());
    }

    //sort the two strings into a list given with the desired order
    public ILoS sort(StringsCompare function) {
        return this;
    }
}

//////////////////////////////////////////////////////////////////////////////


//////////////////////////////////////////////////////////////////////////////
//CONSLOS
/*
TEMPLATE
FIELDS:
... this.first ...         -- String
... this.rest ...          -- ILoS

METHODS
... this.combine() ...     -- String
... this.firstList()...    -- String
... this.restList()...     -- String
... this.isSorted()...     -- boolean
... this.merge()...        -- ILoS
... this.insert()...       -- ILoS
... this.sort()...         -- ILoS

METHODS FOR FIELDS
... this.first.concat(String) ...        -- String
... this.first.compareTo(String) ...     -- int
... this.rest.combine() ...              -- String
... this.rest.firstList() ...            -- String
... this.rest.isSorted()...              -- boolean
... this.rest.merge() ...                -- ILoS
... this.rest.insert()...                -- ILoS

 */
//to represent a nonempty list of Strings
class ConsLoS implements ILoS {
    String first;
    ILoS rest;

    ConsLoS(String first, ILoS rest) {
        this.first = first;
        this.rest = rest;  
    }


    //////////////////////////////////////////////////////////////////////////
    //CONSLOS METHODS
    // combine all Strings in this list into one
    public String combine() {
        return this.first.concat(this.rest.combine());
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
        if ((new StringLexComp().comesBefore(
                this.first, this.rest.firstList())) ||
                (new StringLengthComp().comesBefore(
                        this.first, this.rest.firstList()))) {
            //this.compareAlph(this.rest.firstList())) {
            return (this.rest.isSorted());
        }
        else if (this.rest.equals("")) {
            return true;
        }
        else {
            return false;
        }
    }

    //merge two lists together in the sorted order
    public ILoS merge(ILoS that) {
        if ((new StringLexComp().comesBefore(this.first, that.firstList())) ||
                (new StringLengthComp().comesBefore(
                        this.first, that.firstList()))) {
            return new ConsLoS(this.first, this.rest.merge(that));
        }
        else {
            return new ConsLoS(that.firstList(), this.merge(that.restList()));
        }
    }

    // insert the string in the proper place in this list
    public ILoS insert(StringsCompare function, String s) {
        if (function.comesBefore(this.first, s)) {
            return new ConsLoS(this.first, this.rest.insert(function, s));
        }
        else {
            return new ConsLoS(s, this);
        }
    }


    //sort the two strings into a list given with the desired order
    public ILoS sort(StringsCompare function) {
        return this.rest.sort(function).insert(function, this.first);
    }
}


//////////////////////////////////////////////////////////////////////////////
//EXAMPLESSTRINGS

//to represent examples for lists of strings
class ExamplesStrings {
    String bee = "bee";
    String cee = "cee";
    String empty = "";


    ILoS emptylist = new MtLoS();

    ILoS meow = new ConsLoS("meow!!", this.emptylist);
    ILoS goes = new ConsLoS("goes ", this.meow);
    ILoS cat = new ConsLoS("cat ", this.goes);

    ILoS lamb = new ConsLoS("lamb.", this.emptylist);
    ILoS little = new ConsLoS("little ", this.lamb);
    ILoS a = new ConsLoS("a ", this.little);
    ILoS had = new ConsLoS("had ", this.a);
    ILoS mary = new ConsLoS("Mary ", this.had);

    ILoS lista = new ConsLoS("cat ",
            new ConsLoS("goes ", 
                    new ConsLoS("lamb.", 
                            new ConsLoS("meow!!", this.emptylist))));

    //////////////////////////////////////////////////////////////////////////
    //METHODS TESTS
    //Combine Examples
    boolean testCombine(Tester t) {
        return t.checkExpect(this.mary.combine(), "Mary had a little lamb.") &&
                t.checkExpect(this.cat.combine(), "cat goes meow!!");
    }

    //FirstList Examples
    boolean testFirstList(Tester t) {
        return t.checkExpect(this.cat.firstList(), "cat ") &&
                t.checkExpect(this.emptylist.firstList(), "") &&
                t.checkExpect(this.meow.firstList(), "meow!!");
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

    //Merge Examples
    boolean testMerge(Tester t) {
        return t.checkExpect(this.cat.merge(this.emptylist), this.cat) &&
                t.checkExpect(this.cat.merge(this.lamb), this.lista);
    }

    //Insert Examples
    boolean testInsert(Tester t) {
        return t.checkExpect(this.cat.insert(new StringLengthComp(), "a"), 
                new ConsLoS("a",
                        new ConsLoS("cat ",
                                new ConsLoS("goes ",
                                        new ConsLoS("meow!!", 
                                                new MtLoS()))))) &&
               t.checkExpect(this.cat.insert(new StringLexComp(),  "a"), 
                new ConsLoS("a",
                        new ConsLoS("cat ",
                                new ConsLoS("goes ",
                                        new ConsLoS("meow!!", 
                                                new MtLoS()))))) &&
               t.checkExpect(this.emptylist.insert(
                new StringLengthComp(),  "a"),
                   new ConsLoS("a", this.emptylist)) &&
               t.checkExpect(this.emptylist.insert(
                new StringLexComp(),  "a"),
                   new ConsLoS("a", this.emptylist));
    }

    //Sort Examples
    boolean testSort(Tester t) {
        return t.checkExpect(this.emptylist.sort(new StringLengthComp()),
                this.emptylist) &&
               t.checkExpect(this.emptylist.sort(new StringLexComp()), 
                this.emptylist) &&
               t.checkExpect(this.lamb.sort(new StringLengthComp()),
                this.lamb) &&
               t.checkExpect(this.lamb.sort(new StringLexComp()),
                this.lamb) &&
               t.checkExpect(this.little.sort(new StringLengthComp()),
                new ConsLoS("lamb.", new ConsLoS("little ", 
                           this.emptylist))) &&
               t.checkExpect(this.little.sort(new StringLexComp()),
                new ConsLoS("lamb.", new ConsLoS("little ", 
                           this.emptylist))) &&
               t.checkExpect(this.cat.sort(new StringLengthComp()),
                this.cat) &&
               t.checkExpect(this.cat.sort(new StringLexComp()), 
                this.cat);
    }
}

