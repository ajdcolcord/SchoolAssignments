import java.util.*;
/** represents the class that implements T2S and it's methods
 * using the rules that if the value is <= low it returns 0
 * if the value >= high it returns size
 * else compute the value for the given element i by applying
 * the formula result=size*(i-low)/(high-low)
 * @author Austin
 *
 */
public class T2SFunction implements T2S<Integer, Integer> {
    
    int LOW = 0;
    int HIGH = 255;
    int SIZE = 12;
    int low;
    int high;
    int size;
    
    T2SFunction(int low, int high, int size) {
        this.low = low;
        this.high = high;
        this.size = size;
    }
    
    
    /** the method that follows the rules given for the class 
     * 
     * @param Integer
     * @return Integer
     * */
    public Integer apply(Integer i) {
        if (i <= LOW) {
            return 0;
        }
        else if (i >= HIGH) {
            return SIZE;
        }
        else {
            return SIZE * ((i - LOW) / (HIGH - LOW));
        }
    }
    
    
}
