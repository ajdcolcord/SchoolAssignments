import tester.*;
import java.util.*;

/**
 * A class that illustrates the use of Java loop control
 * statements.
 * @author Viera K. Proulx
 * @since 23 October 2013
 *
 */
class MapAlgorithm {

    /** 
     * Produce a list of the first letters of all <code>String</code>s
     * from the given list of <code>String<.code>s.
     * @param slist the given list of <code>String<.code>s
     * @return a list of the first letters of all <code>String</code>
     */
    ArrayList<String> mapFirst(ArrayList<String> slist) {
        // initialize the accumulator with the base value
        ArrayList<String> result = new ArrayList<String>();
        
        // add the first letter of every element to the accumulator
        for (String s : slist) {
            result.add(s.substring(0, 1));
        }
        
        // return the accumulated result
        return result;
    }

    /** 
     * Produce a list of the lengths of all <code>String</code>s
     * from the given list of <code>String<.code>s.
     * @param slist the given list of <code>String<.code>s
     * @return a list of the lengths of all <code>String</code>
     */
    ArrayList<Integer> mapLength(ArrayList<String> slist) {
        // initialize the accumulator with the base value
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        // add the length of every element to the accumulator
        for (String s : slist) {
            result.add(s.length());
        }
        
        // return the accumulated result
        return result;
    }


    /** 
     * Produce a list by applying the given function to all 
     * <code>String</code>s from the given list of <code>String<.code>s.
     * @param slist the given list of <code>String<.code>s
     * @param update the function object that defines the update method
     * @return a list of the first letters of all <code>String</code>
     */
    <T> ArrayList<T> mapT(ArrayList<String> slist, String2T<T> update) {
        // initialize the accumulator with the base value
        ArrayList<T> result = new ArrayList<T>();

        // apply the update function to every element of the given list
        // add the result to the accumulator
        for (String s : slist) {
            result.add(update.apply(s));
        }

        // return the accumulated result
        return result;
    }
    
    /** 
     * Produce a list by applying the given function to all 
     * <code>String</code>s from the given list of <code>String<.code>s.
     * @param slist the given list of <code>String<.code>s
     * @param update the function object that defines the update method
     * @return a list of the first letters of all <code>String</code>
     */
    <T> ArrayList<T> mapFor(ArrayList<String> slist, String2T<T> update) {
        // initialize the accumulator with the base value
        ArrayList<T> result = new ArrayList<T>();

        // apply the update function to every element of the given list
        // add the result to the accumulator
        for (int index = 0; index < slist.size(); index = index + 1) {
            result.add(update.apply(slist.get(index)));
        }

        // return the accumulated result
        return result;
    }
    
    public <T> ArrayList<T> mapBookT(ArrayList<Book> blist, Book2T<T> update) {
        ArrayList<T> result = new ArrayList<T>();
        for (Book b : blist) {
            result.add(update.apply(b));
        }
        return result;
    }
    
    public <T> ArrayList<T> mapBookTfor(ArrayList<Book> blist, Book2T<T> update) {
        ArrayList<T> result = new ArrayList<T>();
        for (int index = 0; index < blist.size(); index = index + 1) {
            result.add(update.apply(blist.get(index)));
        }
        return result;
    }
    
    //mapBookTitle produces the titles of each book in the list of books
    public ArrayList<String> mapBookTitle(ArrayList<Book> blist) {
        ArrayList<String> result = new ArrayList<String>();
        for (Book b : blist) {
            result.add(b.title);
        }
        return result;
    }
    
    //mapbookauthor
    public ArrayList<String> mapBookAuthor(ArrayList<Book> blist) {
        ArrayList<String> result = new ArrayList<String>();
        for (Book b : blist) {
            result.add(b.author);
        }
        return result;
    }
    
    //mapbookprice
    public ArrayList<Integer> mapBookPrice(ArrayList<Book> blist) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (Book b : blist) {
            result.add(b.price);
        }
        return result;
    }
    
    public ArrayList<String> filterShort(ArrayList<String> slist) {
        ArrayList<String> result = new ArrayList<String>();
        for (String s: slist) {
            if (s.length() <= 3) {
                result.add(s);
            }
        }
        return result;
    }
    
    public ArrayList<String> filterAs(ArrayList<String> slist) {
        ArrayList<String> result = new ArrayList<String>();
        for (String s: slist) {
            if (s.substring(0,  1).equals("a") || s.substring(0, 1).equals("A")) {
                result.add(s);
            }
        }
        return result;
    }
    
    public <T> ArrayList<String> filterStrings(ArrayList<String> slist, ISelect<String> update) {
        ArrayList<String> result = new ArrayList<String>();
        for (String s: slist) {
            if (update.select(s)) {
                result.add(s);
            }
        }
        return result;
    }
    
    public int findMinLoc(ArrayList<String> slist) {
        int result = 0;
        for (int index = 0; (index + 1) < slist.size(); index = 1 + index) {
            if (slist.get(index).compareTo(slist.get(index + 1)) <= 0) {
                result = index;
            }     
        }
        return result;
    }
    
    public ArrayList<String> selectionSortLex(ArrayList<String> slist) {
        ArrayList<String> result = new ArrayList<String>();
        for (int index = 0; index < slist.size(); index = 1 + index) {
            result.add(slist.get(new MapAlgorithm().findMinLoc(slist)));
        }
        return slist.subList(index, slist.size());
    



// to represent a function that consumes a String 
// and produces a value of the type T
interface String2T<T> {
    public T apply(String s);
}

// to represent a function that produces the first character 
// of the given String
class StringFirst implements String2T<String> {
    public String apply(String s) {
        return s.substring(0, 1);
    }
}

//to represent a function that produces the length 
//of the given String
class StringLength implements String2T<Integer> {
    public Integer apply(String s) {
        return s.length();
    }
}

// book2t
interface Book2T<T> {
    public T apply(Book b);
}

class BookTitle implements Book2T<String> {
    public String apply(Book b) {
        return b.title;
    }
}

class BookAuthor implements Book2T<String> {
    public String apply(Book b) {
        return b.author;
    }
}

class BookPrice implements Book2T<Integer> {
    public Integer apply(Book b) {
        return b.price;
    }
}





/**
 * A class designed to explore loops that consume 
 * <code>ArrayList</code> data sets.
 * 
 * @since 23 October 2013
 */
class ExamplesArrayListLoops{
    ExamplesArrayListLoops() {}

    MapAlgorithm algo = new MapAlgorithm();
    
    /** A sample list of <code>String</code>s */
    ArrayList<String> strlist = new ArrayList<String>();

    /**
     * EFFECT:
     * Initialize the <code>ArrayList</code> of songs with four data items
     * sorted by the price
     */
    void initStringList(){
        this.strlist.clear();
        this.strlist.add("hello");
        this.strlist.add("aloha");
        this.strlist.add("bye");
        this.strlist.add("ciao");
    }    
    
    /** A sample list of first letters of the strlist */
    ArrayList<String> str1list = new ArrayList<String>();

    /**
     * EFFECT:
     * Initialize the <code>ArrayList</code> of songs with four data items
     * sorted by the price
     */
    void initString1List(){
        this.str1list.clear();
        this.str1list.add("h");
        this.str1list.add("a");
        this.str1list.add("b");
        this.str1list.add("c");
    }   
    
    /** A sample list of first letters of the strlist */
    ArrayList<Integer> lengthlist = new ArrayList<Integer>();

    /**
     * EFFECT:
     * Initialize the <code>ArrayList</code> of songs with four data items
     * sorted by the price
     */
    void initLengthsList(){
        this.lengthlist.clear();
        this.lengthlist.add(5);
        this.lengthlist.add(5);
        this.lengthlist.add(3);
        this.lengthlist.add(4);
    }
    
    /**
     * Test the methods mapFirst and mapLength
     * @param t the instance of Tester that runs the tests
     */
    void testMap(Tester t) {
        initStringList();
        initString1List();
        initLengthsList();
        t.checkExpect(this.algo.mapFirst(this.strlist), this.str1list);
        t.checkExpect(this.algo.mapLength(this.strlist), this.lengthlist);
    }

    String2T<String> firstUpdate = new StringFirst();
    String2T<Integer> lengthUpdate = new StringLength();
    
    /**
     * Test the method mapT 
     * @param t the instance of Tester that runs the tests
     */
    void testMapT(Tester t) {
        initStringList();
        initString1List();
        initLengthsList();
        t.checkExpect(this.algo.mapT(this.strlist, this.firstUpdate), 
                      this.str1list);
        t.checkExpect(this.algo.mapT(this.strlist, this.lengthUpdate), 
                      this.lengthlist);
    }
    
    /**
     * Test the method mapFor 
     * @param t the instance of Tester that runs the tests
     */
    void testMapFor(Tester t) {
        initStringList();
        initString1List();
        initLengthsList();
        t.checkExpect(this.algo.mapFor(this.strlist, this.firstUpdate), 
                      this.str1list);
        t.checkExpect(this.algo.mapFor(this.strlist, this.lengthUpdate), 
                      this.lengthlist);
    }    
    
    
}