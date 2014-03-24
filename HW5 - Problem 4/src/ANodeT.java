// assignment 5
// partner1-Colcord Austin
// partner1-acolcord
// partner2-Dorshimer Greg
// partner2-gddorsh

/*
CLASS DIAGRAM: 

    +------------------+
 +->|     ANode        |
 |  +------------------+      +-----------------+
 |  | T           data |----->|     Person      |
 +--| ANode<T>    next |      +-----------------+
 +--| ANode<T>    prev |      | String     name |
    +------------------+      | int        age  |
             ^                +-----------------+
             |
             |
             |
             +
   +--------------------+
   |                    |
   |                    |
   v                    v
+--------+          +-----------+
|  Node  |          |  Sentinel |
+--------+          +-----------+
                            ^
                            |
                            |
        +-------------+     |
        |    Deque    |     |
        +-------------+     |
        | ANode  node |-----+
        +-------------+  
                
*/

/* Template
Fields: 
... this.data ... - T
... this.next ... - ANode<T>
... this.prev ... - ANode<T>
Methods:
... this.isSentinel() ...   - boolean
... this.size() ...         - int
... this.sameNodeData() ... - boolean
... this.find() ...         - ANode<T>
... this.removeNode() ...   - void
*/

// represents the node that contains data, a previous, and a next
public abstract class ANodeT<T> {
    T data;
    ANodeT<T> next;
    ANodeT<T> prev;
    
    ANodeT(T data, ANodeT<T> next, ANodeT<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
    
    // tell if this is a sentinel or not
    abstract boolean isSentinel();
    
    // calculate the size of the list
    abstract int size();
    
    // tell if the data in this node is the same as that
    public boolean sameNodeData(ANodeT<T> that) {
        return (this.data.equals(that.data));
    }
    
    // find the node in this list that has that as it's data
    abstract ANodeT<T> find(T that);
    
    //EFFECT: removes the given node from this list
    abstract void removeNode(ANodeT<T> that); 
}
