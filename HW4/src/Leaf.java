/* Template
Methods:
...this.insert()...   - ABST
...this.isLeaf()...   - boolean
...this.getFirst()... - Book
...this.getRest()...  - ABST
...this.sameLeaf()... - boolean
...this.sameNode()... - boolean
...this.sameTree()... - boolean
...this.thisBook()... - Book
...this.bookInThis()... - boolean
...this.thisInThat()... - boolean
...this.buildList()...  - ILoB
 */
// represents ends of the tree that doesn't have data
public class Leaf extends ABST {

    Leaf(IBookComparator order) {
        super(order);
    }
    
    
    
    //////////////////////////////////////////////////////////////////////////
    //LEAF METHODS
    //insert the given book into the proper place in the tree
    public ABST insert(Book b) {
        return new Node(order, b, new Leaf(order), new Leaf(order));
    }
    
    // returns true, since this is a leaf
    public boolean isLeaf() {
        return true;
    }
    
    // to get the first book from the tree
    public Book getFirst() {
        throw new RuntimeException("No first in an empty tree");
    }
    
    // to get the rest of the tree without the first book in the tree
    public ABST getRest() {
        throw new RuntimeException("No rest of an empty tree");
    }
    
    // tell if this leaf is the same as that
    public boolean sameLeaf(Leaf that) {
        return (this.order == that.order);
    }
    
    //tell that this is not the same node as that
    public boolean sameNode(Node that) {
        return false;
    }

    // tell if this tree is the same as that
    public boolean sameTree(ABST that) {
        return that.sameLeaf(this);
    }
    
    // return no book
    public Book thisBook() {
        return null;
    }
    
    // returns false, since this does not contain a book
    public boolean bookInThis(Book book) {
        return false;
    }

    // tell if the data in this tree is the same as that
    public boolean thisInThat(ABST that) {
        return true;
    }

    // return a empty list of book
    public ILoB buildList() {
        return new MtLoB();
    }

    // sort the tree
  //  public ABST sort(ABST acc) {
  //      return this;
  //  }
}
