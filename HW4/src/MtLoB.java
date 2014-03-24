/* Template
Methods:
...this.isEmpty... - boolean
...this.compareList... - boolean
...this.buildTree... -  ABST
 */
// represents the empty list of books
public class MtLoB implements ILoB {
    MtLoB() { 
        //this is an empty constructor, since it has no fields
    }

    // tells that this list is empty
    public boolean isEmpty() {
        return true;
    }

    // tell if this list is the same as that
    public boolean compareList(ABST tree) {
        return (tree.isLeaf());
    }
    
  

    // create a list out of the tree
    public ABST buildTree(ABST tree) {
        return new Leaf(tree.order);
    }
}
