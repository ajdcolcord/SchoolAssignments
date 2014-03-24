/** represents Letter Frequency that contains a frequency and a letter */
public class LFreq {
    int freq;
    String s;
    
    LFreq(int freq, String s) {
        this.freq = freq;
        this.s = s;
    }
    
    
    
    /** equals method for LFreq that returns true if two
     * Strings match, even if the frequencies are different
     * 
     * @param LFreq the other LFreq to be compared to this
     * @return boolean if that string equals this string
     */
    @Override
    public boolean equals(Object that) {
        if (that == null) {
            return false;
        }
        else if (!(that instanceof LFreq)) {
            return false;
        }
        else {
            LFreq temp = (LFreq)that;
            return this.s.equals(temp.s);
        }
    }
    
    /** override the hashcode for the LFreq class
     * @return int the hashCode for the LFreq
     */
    @Override
    public int hashCode() {
        return Integer.valueOf(this.freq).hashCode() + 
                this.s.hashCode();
    }
}
