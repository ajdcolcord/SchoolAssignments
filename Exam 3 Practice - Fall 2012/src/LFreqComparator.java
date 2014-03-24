import java.util.Comparator;

/** the function object that will compare two LFreq objects
 * returning a negative if the first is less than the second,
 * else positive (comparing frequencies, ignoring strings)
 * @author Austin
 */
public class LFreqComparator implements Comparator<LFreq> {

    @Override
    public int compare(LFreq lf1, LFreq lf2) {
        // TODO Auto-generated method stub
        return lf1.freq - lf2.freq;
    }

}
