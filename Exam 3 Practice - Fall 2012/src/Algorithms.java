import java.util.*;

/** the algorithms for these problems */
public class Algorithms {
    
    /** computeHisto computes the histogram for the given text
     * 
     * @param ArrayList<String> of length 1
     * @return ArrayList<LFreq> 
     */
    public HashMap<String, Integer> computeHisto(ArrayList<String> slist) {
        HashMap<String, Integer> newList = new HashMap<String, Integer>();
        for (String s : slist) {
            if (!newList.containsValue(s)) {
                newList.put(1, s);
            }
            else if (!(newList.containsValue(s))) {
                newList.add(new LFreq(1, s));
            }
        }
        return newList;
    }
}
