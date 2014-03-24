// assignment 5
// partner1-Colcord Austin
// partner1-acolcord
// partner2-Dorshimer Greg
// partner2-gddorsh

/* Template
Methods:
... this.isSentinel() ...     - boolean
... this.size() ...           - int
... this.addAtHead() ...      - void
... this.addAtTail() ...      - void
... this.removeFromHead() ... - void
... this.removeFromTail() ... - void
... this.find() ...           - ANode<T>
... this.removeNode() ...     - void
Methods for Fields:
... this.next.isSentinel() ... - boolean
... this.next.size() ...       - int
... this.next.find() ...       - ANode<T>
... this.next.removeNode() ... - void
*/

// provides the link to the head of the list and to the tail of the list.
public class SentinelT<T> extends ANodeT<T> {
    
    SentinelT(ANodeT<T> next, ANodeT<T> previous) {
        super(null, next, previous);
    }
    
    
    // tell that this is a sentinel
    public boolean isSentinel() {
        return true;
    }
    
    // count how many nodes are in this list
    public int size() {
        if (this.next.isSentinel()) {
            return 0;
        }
        else {
            return this.next.size();
        }
    }
    
    //EFFECT: add a new head in the list
    // add a new node to the list at the head
    public void addAtHead(T that) {
        NodeT<T> firstNode = new NodeT<T>(that, this.next, this);
        this.next.prev = firstNode;
        this.next = firstNode;
    }
    
    //EFFECT: add a new tail in the list
    // add a new node to the list at the tail
    public void addAtTail(T that) {
        NodeT<T> lastNode = new NodeT<T>(that, this, this.prev);
        this.prev.next = lastNode;
        this.prev = lastNode;
    }
    
    //EFFECT: remove the first node in the list
    // removes the first node in the lsit
    public void removeFromHead() {
        if (this.next.isSentinel()) {
            throw new RuntimeException("No items in this list.");
        }
        else {
            this.next.next.prev = this;
            this.next = this.next.next;
        }
    }
    
    //EFFECT: remove the first node in the list
    // removes the first node in the lsit
    public void removeFromTail() {
        if (this.prev.isSentinel()) {
            throw new RuntimeException("No items in this list.");
        }
        else {
            this.prev.prev.next = this;
            this.prev = this.prev.prev;
        }
    }
    
    // find the node in this list with the same data as that
    public ANodeT<T> find(T that) {
        if (this.next.isSentinel()) {
            return this;
        }
        else {
            return this.next.find(that);
        }
    }
    
    //EFFECT: removes the given node from the list
    // remove the given node from the list
    public void removeNode(ANodeT<T> that) {
        if (this.next.equals(that)) {
            this.removeFromHead();
        }
        else {
            this.next.removeNode(that);
        }
    }
}
