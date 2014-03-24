// assignment 5
// partner1-Colcord Austin
// partner1-acolcord
// partner2-Dorshimer Greg
// partner2-gddorsh

/* Template
Fields:
... this.node ... - Sentinel
Methods:
... this.size() ...           - int
... this.addAtHead() ...      - void
... this.addAtTail() ...      - void
... this.removeFromHead() ... - void
... this.removeFromTail() ... - void
... this.find() ...           - ANode
... this.removeNode() ...     - void
Methods for Fields:
... this.node.size() ...            - int
... this.node.addAtHead() ...       - void
... this.node.addAtTail() ...       - void
... this.node.removeFromHead() ...  - void
... this.node.removeFromTail() ...  - void
... this.node.find() ...            - ANode
... this.node.removeNode() ...      - void
*/

// contains the sentinel for this list
public class Deque {
    Sentinel node;
    
    Deque(Sentinel node) {
        this.node = node;
    }
    
    // count the size of the list in this deque
    public int size() {
        return this.node.size();
    }
    
    //EFFECT: add a new head for the list
    // add a new string/node to the head of the list 
    void addAtHead(String that) {
        this.node.addAtHead(that);
    }
    
    //EFFECT: add a new tail for the list
    // add a new string/node to the tail of the list 
    void addAtTail(String that) {
        this.node.addAtTail(that);
    }
    
    //EFFECT: remove the first node in the list
    // removes the first node in the lsit
    void removeFromHead() {
        this.node.removeFromHead();
    }
    
    //EFFECT: remove the last node in the list
    // removes the last node in the lsit
    void removeFromTail() {
        this.node.removeFromTail();
    }
    
    // find the given node in the list with the given string
    public ANode find(String that) {
        return this.node.find(that);
    }
    
    //EFFECT: remove the given node from this list
    void removeNode(ANode that) {
        this.node.removeNode(that);
    }
}
