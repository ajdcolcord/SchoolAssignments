/* Template
Fields:
...this.first... - Book
...this.rest...  - ILoB
Methods:
...this.isEmpty... - boolean
...this.compareList... - boolean
...this.buildTree... - ABST
Methods for Fields:
...this.rest.compareList... - boolean
 */
public class ConsLoB implements ILoB {
    Book first;
    ILoB rest;
    
    ConsLoB(Book first, ILoB rest) {
        this.first = first;
        this.rest = rest;
    }

    //decide if the list is empty:
    public boolean isEmpty() {
        return false;
    }

    // compares the two lists to see if they are the same
    public boolean compareList(ABST that) {
        return (this.first.sameBook(that.getFirst()) &&
                this.rest.compareList(that.getRest()));
    }
    
    

   /* // create a list out of the tree
    public ABST buildTree(ABST tree) {
        if (this.isEmpty()) {
            return new Leaf(tree.order);
        }
        else if (this.rest.isEmpty()) {
            return new Node(tree.order,
                            this.first,
                            new Leaf(tree.order),
                            new Leaf(tree.order));
        }
        else {
            return new Node(tree.order,
                    this.first,
                    if (tree.order.compare(
                            this.rest.firstList(), this.first)) {
                        return new Node(tree.order,
                                this.rest.firstList(), 
                                new Leaf(tree.order),
                                new Leaf(tree.order)))
                    }
                    else {
                        return new Leaf(tree.order);
                    }
                    if (tree.)
            
        }

    } */
}