// assignment 5
// partner1-Colcord Austin
// partner1-acolcord
// partner2-Dorshimer Greg
// partner2-gddorsh

import java.util.ArrayList;
import java.util.Comparator;

/*
CLASS DIAGRAM


+-----------------+
|  Algorithms<T>  |
+-----------------+


        +---------------------+
        |  Comparator<String> |
        +---------------------+
                  ^
                  |
        +---------+-------------+
        |                       |
+----------------+      +------------------+
| IntegerBefore  |      |   StringBefore   |
+----------------+      +------------------+

*/


/* Template
Methods:
... this.binarySearch() ... - int
*/
// represents the algorithms class that contains algorithm methods
class Algorithms<T> {    

    // binary searches given array list, returns index of item, or -1
    int binarySearch(
            int lower, 
            int upper,
            ArrayList<T> x, 
            Comparator<T> order, 
            T object) {
        
        if (!x.contains(object)) {
            return -1;
        }
        else if (order.compare(object, x.get((
                new Double(Math.ceil(
                        lower + ((upper - lower) / 2)))).intValue())) < 0) {
            return this.binarySearch(lower, new Double(Math.ceil(lower +
                    ((upper - lower) / 2))).intValue(), x, order, object);
        }        
        else if (order.compare(object, x.get((new Double(Math.ceil(lower +
                ((upper - lower) / 2)))).intValue())) > 0) {
            return this.binarySearch(new Double(Math.ceil(lower +
                    ((upper - lower) / 2))).intValue(),
                    upper, x, order, object);
        }        
        else {
            return new Double(Math.ceil(lower +
                ((upper - lower) / 2))).intValue();
        }
    }
}


/* Template
Methods:
... this.compare() ... - int
*/
// represents function object for comparing to integers
class IntegerBefore implements Comparator<Integer> {
    //constructor
    IntegerBefore() {
        //empty constructor
    }
    
    // compare for given integers
    public int compare(Integer i1, Integer i2) {
        return i1 - i2;
    }
}


/* Template
Methods: 
... this.compare() ... - int
*/
// represents function object for comparing two string
class StringBefore implements Comparator<String> {
    //constructor
    StringBefore() {
        // empty constructor
    }
    
    // compares given Strings lexicographically
    public int compare(String s1, String s2) {
        return s1.compareTo(s2);
    }
}


