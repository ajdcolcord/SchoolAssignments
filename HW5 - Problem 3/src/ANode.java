// assignment 5
// partner1-Colcord Austin
// partner1-acolcord
// partner2-Dorshimer Greg
// partner2-gddorsh

/*
CLASS DIAGRAM: 

    +------------------+
 +->|     ANode        |
 |  +------------------+      
 |  | String      data |
 +--| ANode       next |     
 +--| ANode       prev |    
    +------------------+     
             ^             
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
... this.data ... - String
... this.next ... - ANode
... this.prev ... - ANode
Methods:
... this.isSentinel() ...   - boolean
... this.size() ...         - int
... this.sameNodeData() ... - boolean
... this.find() ...         - ANode
... this.removeNode() ...   - void
*/

// represents the node that contains data, a previous, and a next
public abstract class ANode {
    String data;
    ANode next;
    ANode prev;
    
    ANode(String data, ANode next, ANode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
    
    // tell if this is a sentinel or not
    abstract boolean isSentinel();
    
    // calculate the size of the list
    abstract int size();
    
    // tell if the data in this node is the same as that
    public boolean sameNodeData(ANode that) {
        return (this.data.equals(that.data));
    }
    
    // find the node in this list that has that as it's data
    abstract ANode find(String that);
    
    //EFFECT: removes the given node from this list
    abstract void removeNode(ANode that);
    
}
