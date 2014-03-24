
// assignment 6
// partner1-Colcord-Austin
// partner1-acolcord
// partner2-Su-Jun
// partner2-jacklyso


import tester.*;

import java.util.*;


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





// represents the examples that contains different sorting methods
public class ExamplesInsertSort {
    ArrayList<Integer> emptyArrayNum;
    ArrayList<String> emptyArrayStr;

    ArrayList<Integer> arrayNum1;
    ArrayList<String> arrayStr1;

    ArrayList<Integer> arrayNum2;
    ArrayList<String> arrayStr2;

    ArrayList<Integer> arrayUnsortInt;
    ArrayList<String> arrayUnsortStr;

    //reset to these states
    void reset() {
        emptyArrayNum = new ArrayList<Integer>();
        emptyArrayStr = new ArrayList<String>();
        arrayNum1 = new ArrayList<Integer>(Arrays.asList(5));
        arrayStr1 = new ArrayList<String>(Arrays.asList("d"));

        arrayNum2 = new ArrayList<Integer>(Arrays.asList(
                1, 2, 4, 5, 7, 8, 9));
        arrayStr2 = new ArrayList<String>(Arrays.asList(
                "a", "m", "r", "t", "x"));

        arrayUnsortInt = new ArrayList<Integer>(Arrays.asList(
                8, 1, 3, 12, 5, 9));
        arrayUnsortStr = new ArrayList<String>(Arrays.asList(
                "a", "x", "m", "t", "b"));

    }




    // sortedInsert
    <T> void sortedInsert(T item, ArrayList<T> tlist, Comparator<T> comp) {
        if (tlist.isEmpty()) {
            tlist.add(item);
        }
        else if (comp.compare(tlist.get(tlist.size() - 1), item) < 0) {
            tlist.add(item);

        }
        else {
            for (int i = 0; i < tlist.size(); i = i + 1) {
                if (comp.compare(tlist.get(i), item) > 0) {
                    tlist.add(i, item);
                    break;
                }
            }
        }
    }

    // insertSort
    <T> ArrayList<T> insertSort(ArrayList<T> tlist, Comparator<T> comp) {
        ArrayList<T> newList = new ArrayList<T>();

        for (int i = 0; i < tlist.size(); i = i + 1) {
            sortedInsert(tlist.get(i), newList, comp);
        }
        return newList;


    }

    // insertionSort
    <T> void insertionSort(ArrayList<T> tlist, Comparator<T> comp) {
        for (int i = 1; i < tlist.size(); i = i + 1) {
            T newT = tlist.get(i);
            int x = i;

            while (x > 0 && comp.compare(tlist.get(x - 1), newT) > 0) {
                tlist.set(x, tlist.get(x - 1));
                x = x - 1;
            }
            tlist.set(x, newT);
        }


    }

    // test SortedInsert
    void testSortedInsert(Tester t) {
        reset();
        sortedInsert(3, this.emptyArrayNum, new IntegerBefore());
        t.checkExpect(this.emptyArrayNum, 
                new ArrayList<Integer>(Arrays.asList(3)));

        sortedInsert(6, this.arrayNum1, new IntegerBefore());
        sortedInsert(3, this.arrayNum1, new IntegerBefore());
        sortedInsert(5, this.arrayNum1, new IntegerBefore());
        t.checkExpect(this.arrayNum1, 
                new ArrayList<Integer>(Arrays.asList(3, 5, 5, 6)));

        sortedInsert(5, this.arrayNum2, new IntegerBefore());
        sortedInsert(6, this.arrayNum2, new IntegerBefore());
        sortedInsert(10, this.arrayNum2, new IntegerBefore());
        t.checkExpect(this.arrayNum2, 
                new ArrayList<Integer>(
                        Arrays.asList(1, 2, 4, 5, 5, 6, 7, 8, 9, 10)));


        reset();
        sortedInsert("x", this.emptyArrayStr, new StringBefore());
        t.checkExpect(this.emptyArrayStr,
                new ArrayList<String>(Arrays.asList("x")));

        sortedInsert("m", this.arrayStr1, new StringBefore());
        sortedInsert("d", this.arrayStr1, new StringBefore());
        sortedInsert("a", this.arrayStr1, new StringBefore());
        t.checkExpect(this.arrayStr1,
                new ArrayList<String>(Arrays.asList("a", "d", "d", "m")));

        sortedInsert("m", this.arrayStr2, new StringBefore());
        sortedInsert("d", this.arrayStr2, new StringBefore());
        sortedInsert("z", this.arrayStr2, new StringBefore());
        t.checkExpect(this.arrayStr2,
                new ArrayList<String>(Arrays.asList(
                        "a", "d", "m", "m", "r", "t", "x", "z")));

    } 

    // test insertSort
    void testInsertSort(Tester t) {
        reset();
        t.checkExpect(insertSort(this.arrayUnsortInt, new IntegerBefore()), 
                new ArrayList<Integer>(Arrays.asList(
                        1, 3, 5, 8, 9, 12)));
        t.checkExpect(insertSort(this.arrayUnsortStr, new StringBefore()),
                new ArrayList<String>(Arrays.asList(
                        "a", "b", "m", "t", "x")));
        t.checkExpect(insertSort(this.arrayNum1, new IntegerBefore()),
                new ArrayList<Integer>(Arrays.asList(5)));

    }



    // test insertionSort
    void testInsertionSort(Tester t) {
        reset();
        insertionSort(this.emptyArrayNum, new IntegerBefore());
        t.checkExpect(this.emptyArrayNum, new ArrayList<Integer>());

        insertionSort(this.arrayNum1, new IntegerBefore());
        t.checkExpect(this.arrayNum1, 
                new ArrayList<Integer>(Arrays.asList(5)));

        insertionSort(this.arrayUnsortInt, new IntegerBefore());
        t.checkExpect(this.arrayUnsortInt, 
                new ArrayList<Integer>(Arrays.asList(1, 3, 5, 8, 9, 12)));

        insertionSort(this.arrayUnsortStr, new StringBefore());
        t.checkExpect(this.arrayUnsortStr, 
                new ArrayList<String>(Arrays.asList(
                        "a", "b", "m", "t", "x")));
    }
}
