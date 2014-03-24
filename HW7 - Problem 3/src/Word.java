import java.util.*;

/** <code>Word</code> represents a word and its number of occurrences
 * @author CS2510
 * @version 11-09-2013 
 */
public class Word {
    String w;
    int counter;
    
    public Word(String w) {
        this.w = w;
        this.counter = 1;
    }
    
    /** Template
     * Fields:
     * ...this.w... - String
     * ...this.counter... - int
     * Methods:
     * ... this.equals... - boolean
     * ... this.hashCode... - int
     * ... this.toString... - String
     * ... this.increment... - void
     */
    
    //another constructor for testing needed
    public Word(String w, int counter) {
        this.w = w;
        this.counter = counter;
    }

    /** sorts words by frequency */
    public static class ByFrequency implements Comparator<Word> {
        public int compare(Word a, Word b) {
            return a.counter - b.counter;
        }
    }    

/** Is this Word equal to the given Object 
 *
 * @param obj the given object
 * @return .. FILL IN ...
 */
    public boolean equals(Object obj) {
        if (!(obj instanceof Word)) {
            return false;
        }
        else {
            Word temp = (Word) obj;
            return temp.w.equalsIgnoreCase(this.w);
        }
    }

/** Produce this Word's hashCode 
 * @return .. FILL IN ...
 */
    public int hashCode() {
        return this.w.hashCode();
    }

/** Produce a String representation of this Word 
 * @return a String representation of this Word
 */
    public String toString() {
        return (this.w + ", " + this.counter);
    }
    
    
    /** increase frequency by 1 */
    public void increment() {
        this.counter = this.counter + 1; 
    }
}
