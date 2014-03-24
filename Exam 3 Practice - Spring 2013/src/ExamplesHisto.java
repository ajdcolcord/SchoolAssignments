import java.util.*;

import tester.*;

/** includes the examples and methods for testing */
public class ExamplesHisto {

    ArrayList<Integer> alistmt;
    ArrayList<Integer> alist1;
    ArrayList<Integer> alist2;
    ArrayList<Integer> alist3;
    ArrayList<Integer> alist4;

    HashMap<Integer, Integer> hash1;
    HashMap<Integer, Integer> hash2;
    HashMap<Integer, Integer> hash3;
    


    /** reset to these states */
    public void reset() {
        alistmt = new ArrayList<Integer>();
        alist1 = new ArrayList<Integer>(Arrays.asList(
                3, 3, 4, 5, 6, 4, 4, 2));
        alist2 = new ArrayList<Integer>(Arrays.asList(
                9, 1, 6, 6, 1, 9, 1, 6, 1, 1));
        alist3 = new ArrayList<Integer>(Arrays.asList(
                1, 2, 3, 2, 3, 3, 4, 5));
        alist4 = new ArrayList<Integer>(Arrays.asList(
                0, 0, 0, 2, 4, 5, 6, 0, 0, 0));

        hash1 = new HashMap<Integer, Integer>();
        hash1.put(2, 1);
        hash1.put(3, 2);
        hash1.put(4, 3);
        hash1.put(5, 1);
        hash1.put(6, 1);

        hash2 = new HashMap<Integer, Integer>();
        hash2.put(1, 5);
        hash2.put(6, 3);
        hash2.put(9, 2);

        hash3 = new HashMap<Integer, Integer>();
        hash3.put(1, 1);
        hash3.put(2, 2);
        hash3.put(3, 3);
        hash3.put(4, 1);
        hash3.put(5, 1);
        
        
    }


    /** buildHisto produces a hashmap of the frequency count
     * of values in the arrayList 
     *
     * @param ilist the given ArrayList<Integer> of values between [0, 256]
     * @return HashMap<Integer, Integer> the 
     *         hashmap pairs of values of frequencies
     *         -The first integer (key) is the value of an element in the ilist
     *         -The second integer (value) is the frequency in which this 
     *              element appears in the arrayList
     */
    public HashMap<Integer, Integer> buildHisto(ArrayList<Integer> that) {
        HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
        for (Integer i : that) {    // for every integer in the list
            if (result.get(i) == null) {  // if the item in the new list is null
                result.put(i, 1);    // put a value of 1 in the place of that item
            }
            else { // else add 1 to the value of the result at i
                result.put(i,  new Integer(result.get(i) + 1)); 
            }
        }
        return result; // return the result
    }

    // test the buildHisto method
    public void testBuildHisto(Tester t) {
        reset();
        t.checkExpect(this.buildHisto(this.alistmt),
                new HashMap<Integer, Integer>());
        t.checkExpect(this.buildHisto(this.alist1), this.hash1);
        t.checkExpect(this.buildHisto(this.alist2), this.hash2);
        t.checkExpect(this.buildHisto(this.alist3), this.hash3);
    }

    /** hash2list produces an ArrayList<Integer> where the value of
     * the item at index i is the frequency of that value
     * 
     * @param HashMap<Integer, Integer> the hashmap to use to produce the list
     * @return ArrayList<Integer> the list of frequencies for each index
     */
    public ArrayList<Integer> hash2list(HashMap<Integer, Integer> hmap) {
        ArrayList<Integer> newList = new ArrayList<Integer>();
        for (int i = 0; i < 256; i++) {
            if (hmap.get(i) == null) {
                newList.add(0);
            }
            else {
                newList.add(hmap.get(i));
            }
        }
        return newList;
    }

    // test the hash2list method
    void testHash2list(Tester t) {
        reset();
        ArrayList<Integer> answer = this.hash2list(hash1);
        t.checkExpect(answer.get(1), 0);
        t.checkExpect(answer.get(6), 1);
        ArrayList<Integer> answer2 = this.hash2list(hash2);
        t.checkExpect(answer2.get(6), 3);
        
    }


    /** findFirst determines the first index in the given ArrayList<Integer>
     * whose value is non-zero
     * 
     * @param ArrayList<Integer> the list to be tested
     * @return int the index in the ArrayList<Integer> with value non-zero
     */
    public int findFirst(ArrayList<Integer> ilist) {
        int result = 0;
        for (int i = 0; i < ilist.size(); i = i + 1) {
            if (!(ilist.get(i) == 0)) {
                result = i;
                break;
            }
        }
        return result;
    }


    // test findFirst
    public void testFindFirst(Tester t) {
        reset();
        t.checkExpect(this.findFirst(this.alistmt), 0);
        t.checkExpect(this.findFirst(this.alist1), 0);
        t.checkExpect(this.findFirst(this.alist4), 3);
    }


    /** findLast determines the last index in the given ArrayList<Integer>
     * whose value is non-zero
     * 
     * @param ArrayList<Integer> the list to be tested
     * @return int the index in the ArrayList<Integer> with value non-zero
     */
    public int findLast(ArrayList<Integer> ilist) {
        int result = 0;
        for (int i = 0; i < ilist.size(); i = i + 1) {
            if (!(ilist.get(i) == 0)) {
                result = i;
            }
        }
        return result;
    }


    // test findFirst
    public void testFindLast(Tester t) {
        reset();
        t.checkExpect(this.findLast(this.alistmt), 0);
        t.checkExpect(this.findLast(this.alist1), 7);
        t.checkExpect(this.findLast(this.alist4),6);
    }


    /** maxValue finds the maximum value in the ArrayList<Integer>
     * 
     * @param ArrayList<Integer> the list to be tested
     * @return int the largest value in the ArrayList<Integer>
     */
    public int maxValue(ArrayList<Integer> ilist) {
        int result = 0;
        for (int i = 0; i < ilist.size(); i++) {
            if (ilist.get(i) > ilist.get(result)) {
                result = i;
            }
        }
        return ilist.get(result);
        
    }
    
    // test maxValue
    public void testMaxValue(Tester t) {
        reset();
        t.checkExpect(this.maxValue(alist2), 9);
    }
    
    //TEST T2S FUNCTION
    public void testT2(Tester t) {
        reset();
        
    }

    
    /** map that consumes an ArrayList<T> and an instance of T2S<T, S>
     * produces an ArrayList<S> by invoking the apply method on every element
     * in the given ArrayList<S>
     * 
     * @param ArrayList<T>
     * @Param T2S<T, S>
     * @return ArrayList<T>
     */
    public <T, S> ArrayList<S> map(ArrayList<T> tlist, T2S<T, S> t2s) {
        ArrayList<S> result = new ArrayList<S>();
        for (T t : tlist) {
            result.add(t2s.apply(t));
        }
        return result;
    }


    // test map function
    public void testMap(Tester t) {
        reset();
        T2S<Integer, Integer> lin = new T2SFunction(
                this.findFirst(alist1), 
                this.findLast(this.alist1), 
                this.alist1.size());
        t.checkExpect(this.map(alist1, lin), new ArrayList(Arrays.asList(
                1, 2, 3)));
        
        for (int i = 0; i < 256; i++) {
            exlist.add(lin(ilist.get(i)));
        }
        
        t.checkExpect(map(ilist, lin), exlist);


    }
}


