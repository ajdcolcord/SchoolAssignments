import java.util.Comparator;


/** Template
Methods:
... this.compare() ... - int
*/
/** represents function object for comparing to integers */
class IntegerBefore implements Comparator<Integer> {
    //constructor
    IntegerBefore() {
        //empty constructor
    }
    
    /** compare for given integers 
     * 
     * @param i1 the first item to compare
     * @param i2 the second item to compare
     * @return int a negative int if i1 is larger than i2, else a positive int
     * */
    public int compare(Integer i1, Integer i2) {
        return i1 - i2;
    }
}