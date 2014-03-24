import java.util.*; 
import tester.*;


/** represents the examples of heaps */
public class ExamplesHeaps {
    ArrayList<Integer> heap1;
    ArrayList<Integer> heap2;
    ArrayList<Integer> heap3;

    PriorityQueue<Integer> pq1;
    PriorityQueue<Integer> pq2;
    PriorityQueue<Integer> pq3;


    /** initialize the heaps to these states when called */
    void initHeap() {
        this.heap1 = new ArrayList<Integer>();
        this.heap1.add(null); // the unused first item
        this.heap1.add(80);
        this.heap1.add(50);
        this.heap1.add(40);
        this.heap1.add(45);
        this.heap1.add(20);
        this.heap1.add(30);
        this.pq1 = new PriorityQueue<Integer>(heap1, new IntegerBefore());

        this.heap2 = new ArrayList<Integer>();
        this.heap2.add(null);
        this.heap2.add(50);
        this.heap2.add(45);
        this.heap2.add(40);
        this.heap2.add(30);
        this.heap2.add(20);
        this.pq2 = new PriorityQueue<Integer>(heap2, new IntegerBefore());

        this.heap3 = new ArrayList<Integer>();
        this.heap3.add(null);
        this.heap3.add(70);
        this.heap3.add(45);
        this.heap3.add(50);
        this.heap3.add(30);
        this.heap3.add(20);
        this.heap3.add(40);
        this.pq3 = new PriorityQueue<Integer>(heap3, new IntegerBefore());
    }

    /** test the isLeaf Method */
    void testIsLeaf(Tester t) {
        initHeap();
        t.checkExpect(this.pq1.isLeaf(1), false);
        t.checkExpect(this.pq1.isLeaf(67890), false);
        t.checkExpect(this.pq2.isLeaf(4), true);
        t.checkExpect(this.pq2.isLeaf(2), false);
        t.checkExpect(this.pq3.isLeaf(3), false);
        t.checkExpect(this.pq3.isLeaf(6), true);
    }

    /** test the higherPriorityChild method */
    void testHigherPriorityChild(Tester t) {
        initHeap();
        t.checkExpect(this.pq1.higherPriorityChild(1), 50);
        t.checkExpect(this.pq1.higherPriorityChild(3), 30);
        t.checkExpect(this.pq2.higherPriorityChild(2), 30);
        t.checkExpect(this.pq2.higherPriorityChild(1), 45);
        t.checkExpect(this.pq3.higherPriorityChild(1), 50);
        t.checkExpect(this.pq3.higherPriorityChild(3), 40);
        t.checkExpect(this.pq3.higherPriorityChild(2), 30);
    }

    /** test the insert method */
    void testInsert(Tester t) {
        initHeap();
        this.pq1.insert(100);
        t.checkExpect(this.pq1.tlist.indexOf(100), 1);
        t.checkExpect(this.pq1.tlist.indexOf(80), 3);
        t.checkExpect(this.pq1.tlist.indexOf(50), 2);
        t.checkExpect(this.pq1.tlist.indexOf(45), 4);


    }

    /** test the remove method */
    void testRemove(Tester t) {
        initHeap();
        this.pq1.remove();
        t.checkExpect(this.pq1.tlist.indexOf(50), 1);
        t.checkExpect(this.pq1.tlist.indexOf(40), 3);
        t.checkExpect(this.pq1.tlist.indexOf(45), 2);
        this.pq2.remove();
        t.checkExpect(this.pq2.tlist.indexOf(45), 1);
        t.checkExpect(this.pq2.tlist.indexOf(40), 3);
    }
}
