// assignment 5
// partner1-Colcord Austin
// partner1-acolcord
// partner2-Dorshimer Greg
// partner2-gddorsh

/* Template
Methods:
... this.isSentinel() ...   - boolean
... this.size() ...         - int
... this.find() ...         - ANode<T>
... this.removeNode() ...   - void
Methods for Fields:
... this.next.isSentinel() ... - boolean
... this.next.size() ...       - int
... this.next.find() ...       - ANode<T>
... this.next.removeNode() ... - void
*/

// represents a node
public class NodeT<T> extends ANodeT<T> {
    NodeT(T data, ANodeT<T> next, ANodeT<T> prev) {
        super(data, next, prev);
    }
    
    // tell if this is a sentinel
    public boolean isSentinel() {
        return false;
    }
    
    // calculate the size of the list
    public int size() {
        if (this.next.isSentinel()) {
            return 1;
        }
        else {
            return 1 + this.next.size();
        }
    }
    
    // find the node in this list that contains that data
    public ANodeT<T> find(T that) {
        if (this.data.equals(that)) {
            return this;
        }
        else if (this.next.isSentinel()) {
            return this.next;
        }
        else {
            return this.next.find(that);
        }
    }
    
    //EFFECT: removes the given node from this list
    public void removeNode(ANodeT<T> that) { 
        if (this.next.equals(that)) {
            this.next.next.prev = this;
            this.next = this.next.next;
        }
        else {
            this.next.removeNode(that);
        }
    }
    
}
