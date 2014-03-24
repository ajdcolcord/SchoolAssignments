/* CLASS DIAGRAM

                 +-----------------------+
                 | abstract class ABST   |
                 +-----------------------+
      +----------| IBookComparator order |
      |          +-----------------------+
      |                 / \
      |                 ---
      |                  |
      |      -----------------
      |      |               |
      |   +------+   +------------+
      |   | Leaf |   | Node       |
      |   +------+   +------------+
      |              | Book data  |--------+
      |              | ABST left  |        |
      |              | ABST right |        |
      |              +------------+        |
      |                                    v
      v                            +---------------+
+-------------------------------+  | Book          |<------+
| IBookComparator               |  +---------------+       |
+-------------------------------+  | String title  |       |
| int compare(Book b1, Book b2) |  | String author |       |
+-------------------------------+  | int price     |       |
                                   +---------------+       |
                                                           |
                                                           |
           +--------------------+                          |
           |     ILoBook        |<-----------------------+ |
           +--------------------+                        | |
                   |                                     | |
          +------------------+                           | |
          v                  v                           | |
+---------------------+    +---------------------+       | |
|      MtLoBook       |    |     ConsLoBook      |       | | 
+---------------------+    +---------------------+       | |
+---------------------+  +-| Book          first |       | |
                         | | ILoBook       rest  |       | |
                         | +---------------------+         |
                         |                                 |
                         |                                 |
                         +---------------------------------+              

 */
/* Template
Fields: 
...this.order... - IBookCompaprator
Methods:
...this.insert... - ABST
...this.isLeaf... - boolean
...this.getFirst... - Book
...this.getRest... - ABST
...this.sameLeaf... - boolean
...this.sameNode... - boolean
...this.sameTree... - boolean
...this.thisBook... - Book
...this.bookInThis... - boolean
...this.thisInThat... - boolean
...this.sameData... - boolean
...this.buildList... - ILoB
...this.sameAsList... - boolean
 */
// represents an abstract binary search tree
public abstract class ABST {
    IBookComparator order;
    
    public ABST(IBookComparator order) {
        this.order = order;
    }
    
    //////////////////////////////////////////////////////////////////////////
    //ABST METHODS

    // to create a new ABST which contains the new book.
    abstract ABST insert(Book b);
    
    // to tell if the ABST is a leaf
    abstract boolean isLeaf();

    // to get the first Book in the tree
    abstract Book getFirst();

    // to get the rest of the tree, without the first book in the tree
    abstract ABST getRest();

    // tell if that leaf is the same as this
    abstract boolean sameLeaf(Leaf that);


    // tell if that node is the same as this
    abstract boolean sameNode(Node that);


    // tell if that tree is the same as this
    abstract boolean sameTree(ABST that);
    
    // return this book
    abstract Book thisBook();
    
    // is the given book in this tree
    abstract boolean bookInThis(Book book);

    // tell if that tree has the same data as this
    abstract boolean thisInThat(ABST that);
    
    // tell if these two trees have the same books as each other
    public boolean sameData(ABST that) {
        return (this.thisInThat(that) && that.thisInThat(this));
    }
    
    //turn ABST to list of book
    abstract ILoB buildList();

    // tell if this list is the same as that
    public boolean sameAsList(ILoB list) {
        return list.compareList(this);
    }
    
    // sort sorts the tree
   // abstract ABST sort(ABST acc);
}
