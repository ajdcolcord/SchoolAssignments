import java.util.*;

/** represents a heap-based priority queue
 * that contains an arrayList<T> and comparator<T>
 * determines the ordering of priorities
 * 
 * Template
 * Fields: 
 * ...this.tlist... - ArrayList<T>
 * ...this.comp... - Comparator<T>
 */
public class PriorityQueue<T> {
    ArrayList<T> tlist;
    Comparator<T> comp;
    
    PriorityQueue(ArrayList<T> tlist, Comparator<T> comp) {
        this.tlist = tlist;
        this.comp = comp;
    }
    
    /** isLeaf determines if the node with the label of the given int
     * is a leaf (does not contain a child)
     */
    public boolean isLeaf(int label) {
        if (label > this.tlist.size() - 1) {
            return false;
        }
        else
            if ((label * 2) > this.tlist.size()) {
                return true;
            }
            else {
                return false;
            }
    }

    /** higherPriorityChild consumes the index of a node that
     * is not a leaf and produces the index of its child 
     * with the highest priority
     */
    public T higherPriorityChild(int index) {
        if (this.tlist.size() <= ((index * 2) + 1)) {
            return this.tlist.get(index * 2);
        }
        else if (this.comp.compare(this.tlist.get(index * 2), 
                this.tlist.get((index * 2) + 1)) < 0) {
            return this.tlist.get((index * 2) + 1);
        }
        else {
            return this.tlist.get(index * 2);
        }
    }
    
    /** insert inserts a new node into the heap
     * keeping the rule that the node at index 0 is
     * the largest in the heap, while every child to a node is
     * smaller than itself throughout the tree
     * 
     * @param heap is the item that will be inserted
     */
    public void insert(T heap) {
        this.tlist.add(heap);
        int k = this.tlist.indexOf(heap);
        while (k > 1) {
            while (this.comp.compare(this.tlist.get(k), 
                    this.tlist.get(k / 2)) >= 0) {
                this.tlist.set(k, this.tlist.set((k / 2), heap));
            }
            k = k / 2;
        }
    }
    
    /** remove removes the node with the highest 
     * priority from the heap
     */
    public void remove() {
        T temp = this.tlist.get(1);
        this.tlist.set(1, this.tlist.get(this.tlist.size() - 1));
        int k = 1;
        while (!this.isLeaf(k)) {
            int ck = 0;
            if (comp.compare(
                    this.tlist.get(k), this.higherPriorityChild(k)) < 0) {
                ck = this.tlist.indexOf(this.higherPriorityChild(k));
                this.tlist.set(ck, this.tlist.set(k, this.tlist.get(ck)));
                k = ck;
            }
            else {
                break;
            }
        }
    }
}