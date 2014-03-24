/* Template
Fields:
...this.data...  - Book
...this.left...  - ABST
...this.right... - ABST
Methods:
...this.insert()...   - ABST
...this.isLeaf()...   - boolean
...this.getFirst()... - Book
...this.getRest()...  - ABST
...this.sameLeaf()... - boolean
...this.sameNode()... - boolean
...this.sameTree()... - boolean
...this.containsBook()... - boolean
Methods for Fields:
...this.left.insert()...   - ABST
...this.right.insert()...  - ABST
...this.left.getFirst()... - Book
 */

// represents the node of the tree that contains data, a left and a right
public class Node extends ABST {
    Book data;
    ABST left;
    ABST right;
    
    Node(IBookComparator order, Book data, ABST left, ABST right) {
        super(order);
        this.data = data;
        this.left = left;
        this.right = right;
    }
    //////////////////////////////////////////////////////////////////////////
    //NODE METHODS

    // to create a new ABST which contains the new book.
    public ABST insert(Book b) {
        if (this.order.compare(b, this.data)) {
            return new Node(order, this.data, this.left.insert(b), this.right);
        }
        else {
            return new Node(order, this.data, this.left, this.right.insert(b));
        }
    }
    
    // to say that this is not a leaf
    public boolean isLeaf() {
        return false;
    }
    
    // to get the first book from the tree
    public Book getFirst() {
        if (this.left.isLeaf()) {
            return this.data;           
        }
        else {
            return this.left.getFirst();    
        }
    }
    
    // to get the rest of the tree, without the first book of the tree
    public ABST getRest() {
        if (this.left.isLeaf() && this.right.isLeaf()) {
            return new Leaf(this.order);
        }
        else if (this.left.isLeaf()) {
            return this.right;
        }
        else {
            return new Node(
                    this.order, this.data, new Leaf(this.order), this.right);
        }
    }
    
    // tell that this is not the same leaf as that
    public boolean sameLeaf(Leaf that) {
        return false;
    }
    
    // tell if this node is the same as that
    public boolean sameNode(Node that) {
        return (this.order == that.order &&
                this.data == that.data &&
                this.left.sameTree(that.left) &&
                this.right.sameTree(that.right));
    }
    // tell if this tree is the same as that
    public boolean sameTree(ABST that) {
        return that.sameNode(this);
    }
    
    // is the given book in this node
    public boolean bookInThis(Book book) {
        if (this.data.sameBook(book)) {
            return true;
        }
        else {
            return (this.left.bookInThis(book) ||
                    this.right.bookInThis(book));
        }
    }
    
    // return the book of this node
    public Book thisBook() {
        return this.data;
    }
    
    // tell if this has the same books as that
    public boolean thisInThat(ABST that) {
        if (that.bookInThis(this.data)) {
            return (this.left.thisInThat(that) &&
                    this.right.thisInThat(that));
        }
         
        else {
            return false;
        }

    }

    // build the list from node
    public ILoB buildList() {
        return new ConsLoB(this.getFirst(), this.getRest().buildList());
    }
    
    
    // sort the tree
  //  public ABST sort(ABST acc) {
  //      ABST list = acc.insert(this.data);
  //      list = this.left.sort(acc);
  //      list = this.right.sort(acc);
  //      return list;
  //  }
    

}
