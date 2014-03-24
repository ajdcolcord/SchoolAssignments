import java.util.*;
import tester.*;


public class Examples {
    
    ArrayList<String> slistmt;
    ArrayList<String> slist1;
    ArrayList<String> slist2;
    ArrayList<String> slist3;
    
    ArrayList<LFreq> lfreqlist;
    
    LFreq lf1;
    LFreq lf2;
    LFreq lf3;
    LFreq lf4;
    LFreq lf5;
    LFreq lf6;
    LFreq lf7;
    LFreq lf8;
    LFreq lf9;
    LFreq lf10;
    LFreq lf11;
    LFreq lf12;
    
    
    
    /** reset the values to these states */
    public void reset() {
        slistmt = new ArrayList<String>();
        slist1 = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
        slist2 = new ArrayList<String>(Arrays.asList(
                "all", "baths", "cow", "dog"));
        slist3 = new ArrayList<String>(Arrays.asList("a", "a", "a", "b"));

        lf1 = new LFreq(5, " ");
        lf2 = new LFreq(3, "g");
        lf2 = new LFreq(3, "o");
        lf2 = new LFreq(3, "n");
        lf2 = new LFreq(2, "a");
        lf2 = new LFreq(2, "d");
        lf2 = new LFreq(1, "r");
        lf2 = new LFreq(1, "e");
        lf2 = new LFreq(2, "t");
        lf2 = new LFreq(1, "h");
        lf2 = new LFreq(1, "i");
        lf2 = new LFreq(1, "s");

        lfreqlist = new ArrayList<LFreq>(Arrays.asList(
                lf1, lf2, lf3, lf4, lf5, lf6, lf7, lf8, lf9, lf10, lf11, lf12));


    }
    
    
    /** allSingles consumes an ArrayList<String> and mutates it so that
     * each item is a String of length 1
     * If the item was null, replace it by a string that represents
     * one blank space.
     * If the item is longer than one, it will be replaced by a string 
     * with the first letter of the original string
     * 
     * @param ArrayList<String>
     */
    public void allSingles(ArrayList<String> slist) {
        for (String s : slist) {
            if (s == null) {
                slist.set(slist.indexOf(s), " ");
            }
            else if (s.length() > 1) {
                slist.set(slist.indexOf(s), s.substring(0, 1));
            }
        }
    }
    
    // test allSingles
    void testAllSingles(Tester t) {
        reset();
        this.allSingles(this.slist1);
        t.checkExpect(this.slist1, 
                new ArrayList<String>(Arrays.asList("a", "b", "c", "d")));
        this.allSingles(this.slist2);
        t.checkExpect(this.slist2, 
                new ArrayList<String>(Arrays.asList("a", "b", "c", "d")));
    }
    
    
    // test equals 
    void testEquals(Tester t) {
        reset();
        t.checkExpect(this.lf1.equals(new LFreq(9, " ")), true);
        //t.checkExpect(this.lf2.equals(new LFreq(4, "g")), true);
    }
    
    
    // test computeHisto
    /*void testComputeHisto(Tester t) {
        reset();
        Algorithms algo = new Algorithms();
        ArrayList<LFreq> testlfreq1 = algo.computeHisto(slist1);
        t.checkExpect(testlfreq1.get(1), new LFreq(1, "b"));
        
        Algorithms algo2 = new Algorithms();
        ArrayList<LFreq> testlfreq2 = algo2.computeHisto(slist3);
        //t.checkExpect(testlfreq2.get(1), new LFreq(3, "a"));
    } */
    
    
}
