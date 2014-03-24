// assignment 5
// partner1-Colcord Austin
// partner1-acolcord
// partner2-Dorshimer Greg
// partner2-gddorsh

import java.util.ArrayList;
import tester.*;

//import Tester.*;


public class ExamplesAlgorithms {
    // test functions objects for comparing two integers or two strings
    void testComparator(Tester t) {
        t.checkExpect(new IntegerBefore().compare(4, 8), -4);
        t.checkExpect(new IntegerBefore().compare(5, 5), 0);
        t.checkExpect(new IntegerBefore().compare(6, 3), 3);
        t.checkExpect(new StringBefore().compare("aaa", "bbb"), -1);
        t.checkExpect(new StringBefore().compare("bbb", "aaa"), 1);
        t.checkExpect(new StringBefore().compare("aaa",  "aaa"), 0);
    }
    void testBinarySearch(Tester t) {
        ArrayList<String> slist = new ArrayList<String>();
        slist.add("a");
        slist.add("b");
        slist.add("c");
        slist.add("d");
        slist.add("e");
        slist.add("f");
        slist.add("g");
        slist.add("h");
        slist.add("i");
        slist.add("j");
        slist.add("k");
        slist.add("l");
        slist.add("m");
        t.checkExpect(slist.contains("a"), true);
        t.checkExpect(!slist.contains("a"), false);
        t.checkExpect(slist.contains("z"), false);
        t.checkExpect(!slist.contains("z"), true);
        t.checkExpect(new Algorithms<String>().binarySearch(
                0, slist.size(), slist, new StringBefore(), "b"), 1);
        t.checkExpect(new Algorithms<String>().binarySearch(
                0, slist.size(), slist, new StringBefore(), "z"), -1);
        t.checkExpect(new Algorithms<String>().binarySearch(
                0, slist.size(), slist, new StringBefore(), "a"), 0);
        t.checkExpect(new Algorithms<String>().binarySearch(
                0, slist.size(), slist, new StringBefore(), "m"), 12);
        ArrayList<Integer> ilist = new ArrayList<Integer>();
        ilist.add(1);
        ilist.add(3);
        ilist.add(4);
        ilist.add(5);
        ilist.add(7);
        ilist.add(8);
        ilist.add(9);
        ilist.add(13);
        ilist.add(13);
        ilist.add(15);
        t.checkExpect(ilist.contains(3), true);
        t.checkExpect(!ilist.contains(3), false);
        t.checkExpect(ilist.contains(100), false);
        t.checkExpect(!ilist.contains(100), true);
        t.checkExpect(new Algorithms<Integer>().binarySearch(
                0, ilist.size(), ilist, new IntegerBefore(), 1), 0);
        t.checkExpect(new Algorithms<Integer>().binarySearch(
                0, ilist.size(), ilist, new IntegerBefore(), 8), 5);
        t.checkExpect(new Algorithms<Integer>().binarySearch(
                0, ilist.size(), ilist, new IntegerBefore(), 15), 9);
        t.checkExpect(new Algorithms<Integer>().binarySearch(
                0, ilist.size(), ilist, new IntegerBefore(), 100), -1);
    }
}