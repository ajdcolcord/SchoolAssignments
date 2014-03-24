import tester.*;
// represents the class that provides Examples 
// for the different trees and methods
public class ExamplesABST {
    Book b1 = new Book("The Beginning", "AJ", 100);
    Book b2 = new Book("The Middle", "DJ", 200);
    Book b3 = new Book("The End", "MJ", 400);
    Book b4 = new Book("A", "B", 200);
    
    Leaf leaf = new Leaf(new BooksByTitle());
    Leaf leaf2 = new Leaf(new BooksByAuthor());
    
    Node n0 = new Node(new BooksByTitle(), null, this.leaf, this.leaf);
    Node n1 = new Node(new BooksByTitle(), this.b1, this.leaf, this.leaf);
    Node n2 = new Node(new BooksByTitle(), this.b2, this.leaf, this.n1);
    Node n3 = new Node(new BooksByTitle(), this.b3, this.leaf, this.n2);
    Node n4 = new Node(new BooksByTitle(), this.b4, this.n3, this.n1);
    Node n5 = new Node(new BooksByTitle(), this.b4, this.n3, this.n1);
    Node n6 = new Node(new BooksByTitle(), 
                       this.b1, 
                       this.leaf,
                       new Node(new BooksByTitle(),
                               this.b2, this.leaf, this.leaf));
    
    Node n7 = new Node(new BooksByAuthor(), null, this.leaf, this.leaf);
    Node n8 = new Node(new BooksByAuthor(), this.b1, this.leaf, this.leaf);
    Node n9 = new Node(new BooksByAuthor(), this.b2, this.leaf, this.n1);
    Node n10 = new Node(new BooksByPrice(), null, this.leaf, this.leaf);
    Node n11 = new Node(new BooksByPrice(), this.b1, this.leaf, this.leaf);
    Node n12 = new Node(new BooksByPrice(), this.b2, this.leaf, this.n1);
    
    
   
    ILoB mtlob = new MtLoB();
    ILoB l1 = new ConsLoB(this.b1, this.mtlob);
    ILoB l2 = new ConsLoB(this.b2, this.l1);
    ILoB l3 = new ConsLoB(this.b3, this.l2);
    //ILoB l4 = new ConsLoB(this.b4, new ConsLoB(this.l3, this.l1));
    
    
    //////////////////////////////////////////////////////////////////////////
    // METHOD TESTS

    // test the method insert
    void testInsert(Tester t) {
        t.checkExpect(this.n1.insert(b2),
                new Node(this.n1.order,
                        this.b1,
                        this.leaf,
                        new Node(this.leaf.order,
                                this.b2,
                                this.leaf,
                                this.leaf)));
        t.checkExpect(this.n2.insert(b4),
                new Node(this.n2.order,
                        this.b2,
                        new Node(this.leaf.order,
                                this.b4,
                                this.leaf,
                                this.leaf),
                        new Node(this.n1.order,
                                this.b1,
                                this.leaf,
                                this.leaf)));
        
    }

    // test the method isLeaf
    void testIsLeaf(Tester t) {
        t.checkExpect(this.leaf.isLeaf(), true);
        t.checkExpect(this.n1.isLeaf(), false);
    }

    // test the method getFirst
    void testGetFirst(Tester t) {
        t.checkExpect(this.n1.getFirst(), this.b1);
        t.checkExpect(this.n2.getFirst(), this.b2);
        t.checkExpect(this.n3.getFirst(), this.b3);
        t.checkExpect(this.n4.getFirst(), this.b3);
        //t.checkException(this.leaf.getFirst(), new RuntimeException
        //("No first in an empty tree"));
    }
    
    // test the method getRest
    void testGetRest(Tester t) {
        t.checkExpect(this.n2.getRest(), this.n1);
        t.checkExpect(this.n1.getRest(), this.leaf);
        t.checkExpect(this.n3.getRest(), this.n2);
        t.checkExpect(this.n4.getRest(), 
                        new Node(this.n4.order,
                                this.n4.data,
                                this.leaf,
                                this.n1));
    }
    
    // test the method sameLeaf
    void testSameLeaf(Tester t) {
        t.checkExpect(this.leaf.sameLeaf(this.leaf), true);
        t.checkExpect(this.leaf2.sameLeaf(this.leaf), false);
    }
    
    // test the method sameNode
    void testSameNode(Tester t) {
        t.checkExpect(this.n1.sameNode(this.n1), true);
        t.checkExpect(this.n4.sameNode(this.n3), false);
    }

    // test the method sameTree
    void testSameTree(Tester t) {
        t.checkExpect(this.leaf.sameTree(this.leaf), true);
        t.checkExpect(this.leaf2.sameTree(this.leaf), false);
        t.checkExpect(this.n1.sameTree(this.n2), false);
        t.checkExpect(this.n1.sameTree(this.n1), true);
        t.checkExpect(this.n4.sameTree(this.n4), true);
    }

    //sameBook
    void testSameBook(Tester t) {
        t.checkExpect(this.b1.sameBook(this.b1), true);
        t.checkExpect(this.b2.sameBook(this.b1), false);
    }
    
    // test thisBook
    void testThisBook(Tester t) {
        t.checkExpect(this.n1.thisBook(), this.b1);
        t.checkExpect(this.n3.thisBook(), this.b3);
        t.checkExpect(this.n4.thisBook(), this.b4);
        t.checkExpect(this.leaf.thisBook(), null);
    }
    
    // test bookInThis
    void testBookInThis(Tester t) {
        t.checkExpect(this.n1.bookInThis(b1), true);
        t.checkExpect(this.n4.bookInThis(b2), true);
        t.checkExpect(this.leaf.bookInThis(b2), false);
        t.checkExpect(this.n1.bookInThis(b2), false);
    }
  
    //test thisInThat
    void testThisInThat(Tester t) {
        t.checkExpect(this.n1.thisInThat(this.n1), true);
        t.checkExpect(this.n4.thisInThat(this.n4), true);
        t.checkExpect(this.n2.thisInThat(this.n3), true);
        t.checkExpect(this.leaf.thisInThat(this.leaf), true);
        t.checkExpect(this.leaf.thisInThat(this.leaf2), true);
        t.checkExpect(this.n1.thisInThat(this.leaf), false);
        t.checkExpect(this.n6.thisInThat(this.n2), true);
    }
    
    // test sameData
    void testSameData(Tester t) {
        t.checkExpect(this.n1.sameData(this.n1), true);
        t.checkExpect(this.n4.sameData(this.n4), true);
        t.checkExpect(this.n2.sameData(this.n3), false);
        t.checkExpect(this.leaf.sameData(this.leaf), true);
        t.checkExpect(this.leaf.sameData(this.leaf2), true);
        t.checkExpect(this.n1.sameData(this.leaf), false);
        t.checkExpect(this.n6.sameData(this.n2), true);
    }
    
    // test buildList
    void testBuildList(Tester t) {
        t.checkExpect(this.leaf.buildList(), this.mtlob);
        t.checkExpect(this.n1.buildList(), this.l1);
        t.checkExpect(this.n2.buildList(), this.l2);
        t.checkExpect(this.n3.buildList(), this.l3);
    }
    
    // test compareList
    void testCompareList(Tester t) {
        t.checkExpect(this.mtlob.compareList(this.leaf), true);
        t.checkExpect(this.mtlob.compareList(this.n1), false);
        t.checkExpect(this.l1.compareList(this.n1), true);
        t.checkExpect(this.l2.compareList(this.n1), false);
        t.checkExpect(this.l3.compareList(this.n3), true);
    }

    // test sameAsList
    void testSameAsList(Tester t) {
        t.checkExpect(this.n1.sameAsList(this.l1), true);
        t.checkExpect(this.n2.sameAsList(this.l1), false);
        t.checkExpect(this.n3.sameAsList(this.l3), true);
        t.checkExpect(this.leaf.sameAsList(this.mtlob), true);
    }

    // test isEmpty
    void testIsEmpty(Tester t) {
        t.checkExpect(this.mtlob.isEmpty(), true);
        t.checkExpect(this.l1.isEmpty(), false);
    }
    
    // test sort
    //void testSort(Tester t) {
    //    t.checkExpect(this.leaf.sort(this.n1), this.leaf);
    //    t.checkExpect(this.n1.sort(this.n2), this.n1);
   // }
    
    // test buildTree
    //void testBuildTree(Tester t) {
      //  t.checkExpect(this.mtlob.buildList(l1))
  //  }

}
