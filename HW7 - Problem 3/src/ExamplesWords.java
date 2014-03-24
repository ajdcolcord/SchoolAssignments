import java.util.*;

import tester.*;

/** Class to hold examples of data and tests 
 * @author CS2510
 * @version 11-09-2013
 */
public class ExamplesWords {

    /** Test Word Classes... 
     *
     * @param t the tester instance that runs the tests
     */
    public void testWords(Tester t) {        

        t.checkExpect(new Word("hey").equals(new Word("hey")), true);
        t.checkExpect(new Word("hey").equals(new Word("you")), false);

        WordCounter wc = new WordCounter();
        wc.countWords(new StringIterator(new StringBuffer("The Words Are")));
        t.checkExpect(wc.words(), 3);

        WordCounter macbeth = new WordCounter();
        macbeth.countWords(new StringIterator("Macbeth.txt"));
        macbeth.printWords(10);
    }

    /** data for the methods and tests */
    Word king;
    Word king2;
    Word m;
    Comparator<Word> comp;
    ArrayList<Word> wlist;
    ArrayList<Word> wlist2;

    WordCounter wc;
    WordCounter wc2;
    WordCounter wc3;


    /** reset the variables to these states */
    void reset() {
        king = new Word("king");
        king2 = new Word("king", 2); 
        m = new Word("macbeth");
        comp = new Word.ByFrequency();

        wlist = new ArrayList<Word>();
        wlist.add(this.m);
        wlist.add(this.king);
        wlist2 = new ArrayList<Word>();
        wlist2.add(this.m);
        wlist2.add(this.king2);

        wc = new WordCounter(wlist);
        wc2 = new WordCounter(wlist);
        wc3 = new WordCounter(wlist2);

    }
    // test equals()
    void testEquals(Tester t) {
        reset();
        t.checkExpect(this.m.equals(new Word("king")), false);
        t.checkExpect(this.m.equals("alkjdfal"), false);
        t.checkExpect(this.king.equals(new Word("king")), true);
        t.checkExpect(this.king.equals(new Word("KING")), true);
    }

    //test hashCode()
    void testHashCode(Tester t) {
        reset();
        t.checkExpect(king.hashCode(), king2.hashCode());
    }


    //test toString()
    void testToString(Tester t) {
        reset();
        t.checkExpect(this.king.toString(), "king, 1");
        t.checkExpect(this.m.toString(), "macbeth, 1");
    }

    //test increment
    void testIncrement(Tester t) {
        reset();
        this.king.increment();
        t.checkExpect(this.king, this.king2);
        this.king.increment();
        t.checkExpect(this.king, new Word("king", 3));
    }

    //test checkWord(Word w)
    void testCheckWord(Tester t) {
        reset();
        t.checkExpect(this.wc.checkWord(new Word("KING")), true);
        t.checkExpect(this.wc.checkWord(new Word("ham")), false);
    }

    //test addOne(Word w)
    void testAddOne(Tester t) {
        reset();
        this.wc.addOne(new Word("Queen"));
        t.checkExpect(this.wc, this.wc2);
        this.wc.addOne(this.king);
        t.checkExpect(this.wc, this.wc3);
    }


    /** Test Word Classes... 
     *
     * @param t the tester instance that runs the tests
     */
    public void testStringIter(Tester t) {
        StringIterator wrds = 
                new StringIterator(new StringBuffer("The Words Are"));

        int i = 0;
        for (Word w : wrds) {
            System.out.println(" Word[" + (i++) + "] : " + w);
        }
    }

    //test CountWords(Iterator<Word> it)
    void testCountWords(Tester t) {
        reset();
        StringIterator wrds = 
                new StringIterator(new StringBuffer("The Words Are"));
        wc.countWords(wrds);
        wlist.add(new Word("The"));
        wlist.add(new Word("Words"));
        wlist.add(new Word("Are"));
        wc2 = new WordCounter(wlist);
        t.checkExpect(wc, wc2);

        reset();
        StringIterator wrds2 = 
                new StringIterator(new StringBuffer("King Woo"));
        wc.countWords(wrds2);
        wlist2.add(new Word("woo"));
        wc2 = new WordCounter(wlist2);
        t.checkExpect(wc, wc2);
    }
    //test Words() in WordCounter class
    void testWords2(Tester t) {
        reset();
        t.checkExpect(wc.words(), 2);
        t.checkExpect(wc3.words(), 2);
        t.checkExpect(wc2.words(), 2);
    }

    //test findMost()
    void testFindMost(Tester t) {
        reset();
        t.checkExpect(this.wc3.findMost(), 1);
        t.checkExpect(this.wc.findMost(), 0);
        t.checkExpect(this.wc2.findMost(), 0);
    }

    //test inOrder()
    void testInOrder(Tester t) {
        reset();
        wlist = new ArrayList<Word>();
        wlist.add(king2);
        wlist.add(m);
        wc = new WordCounter(wlist);

        wc3.inOrder();
        t.checkExpect(wc3, wc);
    }

    //test toString(n1, n2) in WordCounter class
    void testToString2(Tester t) {
        reset();
        t.checkExpect(this.wc.toString(0, 2), "macbeth, 1,king, 1,");
        t.checkExpect(this.wc3.toString(1, 1), "king, 2,");
        t.checkExpect(this.wc2.toString(0, 1), "macbeth, 1,");
    }
}