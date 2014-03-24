import java.util.*;
import tester.*;

/**
 * Examples of uses of loops and iterators
 * @author vkp
 * @since 10-30-2013
 */
class LoopAlgorithms {
     
    /**
     * find whether the given <code>ArrayList</code> contains 
     * the given <code>String</code>
     * @param slist the given <code>ArrayList</code>
     * @param s the given <code>String</code>
     * @return true if the <code>String</code> appears in the 
     * <code>ArrayList</code>
     */
    boolean containsWhile(ArrayList<String> slist, String s) {
        int index = 0;
        while(index < slist.size()) {
            if (s.equals(slist.get(index))) {
                return true;
            }
            index = index + 1;
        }
        return false;
    }
    
    /**
     * find whether the given <code>ArrayList</code> contains 
     * the given <code>String</code>
     * @param slist the given <code>ArrayList</code>
     * @param s the given <code>String</code>
     * @return true if the <code>String</code> appears in the 
     * <code>ArrayList</code>
     */
    boolean containsFor(ArrayList<String> slist, String s) {
        for (int index = 0; index < slist.size(); index = index + 1) {
            if (s.equals(slist.get(index))) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * find whether the given <code>ArrayList</code> contains 
     * the given <code>String</code>
     * @param slist the given <code>ArrayList</code>
     * @param s the given <code>String</code>
     * @return true if the <code>String</code> appears in the 
     * <code>ArrayList</code>
     */
    boolean containsForEach(ArrayList<String> slist, String s) {
        for (String sx : slist) {
            if (s.equals(sx)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * find whether the given <code>ArrayList</code> contains 
     * the given <code>String</code>
     * @param slist the given <code>ArrayList</code>
     * @param s the given <code>String</code>
     * @return true if the <code>String</code> appears in the 
     * <code>ArrayList</code>
     */
    boolean containsIterator(Iterable<String> slist, String s) {
        Iterator<String> iter = slist.iterator();
        while (iter.hasNext()) {
            if (s.equals(iter.next())) {
                return true;
            }
        }
        return false;
    } 
    
    
    ArrayList<String> replaceForEach(ArrayList<String> slist, String s1, String s2) {
        for (String s : slist) {
            if (s.equals(s1)) {
                s = s2;
            }
        }
        return slist;
    }
    
    ArrayList<String> replaceFor(ArrayList<String> slist, String s1, String s2) {
        for (int i = 0; i < slist.size(); i = i + 1) {
            if (slist.get(i).equals(s1)) {
                slist.set(i, s2);
            }
        }
        return slist;
    }
    
    ArrayList<String> replaceWhile(ArrayList<String> slist, String s1, String s2) {
        int i = 0; // initialize i
        while(i < slist.size()) {
            if (slist.get(i).equals(s1)) {
                slist.set(i, s2);
            }
            i = i + 1;
        }
        return slist;
    }
    
    ArrayList<String> reverseFor(ArrayList<String> slist) {
        ArrayList<String> slistNew = new ArrayList<String>();
        for (int i = slist.size() - 1; i > 0; i = i - 1) {
           slistNew.add(slist.get(i));
            
        }
        return slistNew;
    }
    
    ArrayList<String> referseWhile(ArrayList<String> slist) {
        ArrayList<String> slistNew = new ArrayList<String>();
        int i = slist.size() - 1;
        while(i > 0) {
            slistNew.add(slist.get(i));
            i = i - 1;
        }
        return slistNew;
    }
    
    ArrayList<String> removeSForEach(ArrayList<String> slist, String s) {
        for(String x : slist) {
            if (x.equals(s)) {
                slist.remove(x);
            }
        }
        return slist;
    }
    
    ArrayList<String> removeSFor(ArrayList<String> slist, String s) {
        for (int i = 0; i < slist.size(); i = i + 1) {
            if (slist.get(i).equals(s)) {
                slist.remove(s);
            }
        }
        return slist;
    }
    
    ArrayList<T> insert(ArrayList<T> tlist, int lower, Comparator<T> comp) {
        int i = lower - 1;
        T temp = tlist.get(lower);
        while (comp.compare(tlist.get(i), temp) > 0) {
            tlist.set(i + 1, tlist.get(i));
            i = i - 1;
        }
        tlist.set(i + 1, temp);
        return tlist;
    }
    
    
    void insertionSort(ArrayList<T> tlist, Comparator<T> comp) {
        insert(tlist, 0, comp);
    }
    
    ArrayList<T> merge(ArrayList<T> tlist1, ArrayList<T> tlist2, Comparator<T> comp) {
        ArrayList<T> newList = new ArrayList<T>();
        
        while (comp.compare(tlist1.get(0), tlist2.get(0)) < 0) {
            newList.add(tlist1.get(0));
            tlist1.remove(0);
        }
        while (comp.compare(tlist1.get(0), tlist2.get(0)) >= 0) {
            newList.add(tlist2.get(0));
            tlist2.remove(0);
        }
        return newList;
    }
}

/**
 * Class to compare two <code>String</code>s lexicographically
 * @author vkp
 * @version 10-30-2013
 */
class StringComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        return s1.compareTo(s2);
    }
    
    
}

/**
 * Examples and tests for the loop methods
 * @author vkp
 * @version 10-30-2013
 */
class ExamplesLoopVariants {
    
    ArrayList<String> slist1 = 
            new ArrayList<String>(Arrays.asList("ahoy", "bye", "ciao"));
    ArrayList<String> slist2 = 
            new ArrayList<String>(Arrays.asList("aloha", "hello", "hi"));
    ArrayList<String> slist3 = 
            new ArrayList<String>(Arrays.asList("sayonara", "servus"));

    ArrayList<String> slistR12 = 
            new ArrayList<String>(Arrays.asList("ahoy", "aloha", "bye", 
                                                "ciao", "hello", "hi"));
    ArrayList<String> slistR13 = 
            new ArrayList<String>(Arrays.asList("ahoy", "bye", "ciao", 
                                                "sayonara", "servus"));

    LoopAlgorithms la = new LoopAlgorithms();
    Comparator<String> scomp = new StringComparator();
    
    /**
     * Test the loop methods - at least two tests per method
     * @param t the Tester that runs the tests
     */
    void testContains(Tester t) {
        t.checkExpect(this.la.containsWhile(this.slist1, "ciao"), true);
        t.checkExpect(this.la.containsWhile(this.slist2, "ciao"), false);
        t.checkExpect(this.la.containsFor(this.slist1, "ciao"), true);
        t.checkExpect(this.la.containsFor(this.slist2, "ciao"), false);
        t.checkExpect(this.la.containsForEach(this.slist1, "ciao"), true);
        t.checkExpect(this.la.containsForEach(this.slist2, "ciao"), false);
        t.checkExpect(this.la.containsIterator(this.slist1, "ciao"), true);
        t.checkExpect(this.la.containsIterator(this.slist2, "ciao"), false);
    }
    
    /**
     * The main method that runs the program
     * @param argv ignored
     */  
    public static void main(String[] argv){
        ExamplesLoopVariants elv = new ExamplesLoopVariants();

        Tester.run(elv);
    }
}
