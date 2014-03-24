// assignment 5
// partner1-Colcord Austin
// partner1-acolcord
// partner2-Dorshimer Greg
// partner2-gddorsh

import tester.*;

// represents the examples for the lists
public class ExamplesDeque {
    Sentinel mts;
    Sentinel s1;
    Sentinel s2;
    Sentinel s3;
    
    Deque mtd;
    Deque d1;
    Deque d2;
    Deque d3;
    
    Node a;
    Node abc;
    Node bcd;
    Node cde;
    Node def;
    Node first;
    Node second;
    Node third;
    Node fourth;
    
    // reset to these states
    void reset() {
        
        mts = new Sentinel(null, null);
        s1 = new Sentinel(null, null);
        s2 = new Sentinel(null, null);
        s3 = new Sentinel(null, null);
    
        mtd = new Deque(this.mts);
        d1 = new Deque(this.s1);
        d2 = new Deque(this.s2);
        d3 = new Deque(this.s3);
    
        a = new Node("a", null, null);
        abc = new Node("abc", null, null);
        bcd = new Node("bcd", null, null);
        cde = new Node("cde", null, null);
        def = new Node("def", null, null);
        first = new Node("first", null, null);
        second = new Node("second", null, null);
        third = new Node("third", null, null);
        fourth = new Node("fourth", null, null);
        
        //representing an empty list
        this.mts.next = this.mts;
        this.mts.prev = this.mts;
        this.mtd = new Deque(this.mts);
        
        //representing a list with one item
        this.s1.next = this.a;
        this.s1.prev = this.a;
        this.a.next = this.s1;
        this.a.prev = this.s1;
        this.d1 = new Deque(this.s1);
        
        //representing the list with abc, bcd, cde, def
        this.s2.next = this.abc;
        this.s2.prev = this.def;
        this.abc.next = this.bcd;
        this.abc.prev = this.s2;
        this.bcd.next = this.cde;
        this.bcd.prev = this.abc;
        this.cde.next = this.def;
        this.cde.prev = this.bcd;
        this.def.next = this.s2;
        this.def.prev = this.cde;
        this.d2 = new Deque(this.s2);
        
        // representing another list with four other values
        this.s3.next = this.first;
        this.s3.prev = this.fourth;
        this.first.next = this.second;
        this.first.prev = this.s3;
        this.second.next = this.third;
        this.second.prev = this.first;
        this.third.next = this.fourth;
        this.third.prev = this.second;
        this.fourth.next = this.s3;
        this.fourth.prev = this.third;
        this.d3 = new Deque(this.s3);
    }
    
    // test the method isSentinel
    void testIsSentiel(Tester t) {
        reset();
        t.checkExpect(this.mts.isSentinel(), true);
        t.checkExpect(this.a.isSentinel(), false);
        t.checkExpect(this.abc.isSentinel(), false);
        t.checkExpect(this.s1.isSentinel(), true);
    }
    
    // test size
    void testSize(Tester t) {
        reset();
        t.checkExpect(this.mts.size(), 0);
        t.checkExpect(this.s1.size(), 1);
        t.checkExpect(this.s2.size(), 4);
        t.checkExpect(this.a.size(), 1);
        t.checkExpect(this.abc.size(), 4);
        t.checkExpect(this.mtd.size(), 0);
        t.checkExpect(this.d1.size(), 1);
        t.checkExpect(this.d2.size(), 4);
        t.checkExpect(this.d3.size(), 4);
    }
    
    
    // test addAtHead
    void testAddAtHead(Tester t) {
        reset();
        this.mts.addAtHead("a");
        t.checkExpect(this.mts.next.sameNodeData(this.a), true);
        t.checkExpect(this.mts.prev.sameNodeData(this.a), true);
        reset();
        this.mtd.addAtHead("a");
        t.checkExpect(this.mtd.node.next.sameNodeData(this.a), true);
        t.checkExpect(this.mtd.node.prev.sameNodeData(this.a), true);
        reset();
        this.d2.addAtHead("a");
        t.checkExpect(this.d2.node.next.sameNodeData(this.a), true);
        t.checkExpect(this.d2.node.next.prev.sameNodeData(this.mts), true);
        t.checkExpect(this.d2.node.next.next.sameNodeData(this.abc), true);
        t.checkExpect(this.d2.node.next.next.prev.sameNodeData(this.a), true);
        t.checkExpect(this.d2.node.next.sameNodeData(this.abc), false);
        t.checkExpect(this.d2.node.prev.sameNodeData(this.def), true);
    }      
    
    // test addAtTail
    void testAddAtTail(Tester t) {
        reset();
        this.mts.addAtTail("a");
        t.checkExpect(this.mts.prev.sameNodeData(this.a), true);
        t.checkExpect(this.mts.next.sameNodeData(this.a), true);
        reset();
        this.mtd.addAtTail("a");
        t.checkExpect(this.mtd.node.prev.sameNodeData(this.a), true);
        t.checkExpect(this.mtd.node.next.sameNodeData(this.a), true);
        reset();
        this.d2.addAtTail("a");
        t.checkExpect(this.d2.node.prev.sameNodeData(this.a), true);
        t.checkExpect(this.d2.node.prev.next.sameNodeData(this.mts), true);
        t.checkExpect(this.d2.node.prev.prev.sameNodeData(this.def), true);
        t.checkExpect(this.d2.node.prev.prev.next.sameNodeData(this.a), true);
        t.checkExpect(this.d2.node.next.sameNodeData(this.abc), true);
        t.checkExpect(this.d2.node.prev.sameNodeData(this.def), false);
    }
    
    // test removeFromHead 
    void testRemoveFromHead(Tester t) {
        reset();
        t.checkException("removeFromHead", 
                new RuntimeException("No items in this list."), 
                this.mts, "removeFromHead");
        reset();
        this.d1.removeFromHead();
        t.checkExpect(this.d1.node.next.isSentinel(), true);
        t.checkExpect(this.d1.node.prev.isSentinel(), true);
        reset();
        this.d2.removeFromHead();
        t.checkExpect(this.d2.node.next.sameNodeData(this.bcd), true);
        t.checkExpect(this.d2.node.prev.sameNodeData(this.def), true);
        t.checkExpect(this.d2.node.next.prev.isSentinel(), true);
        t.checkExpect(this.d2.node.next.next.sameNodeData(this.cde), true);
        reset();
        this.d3.removeFromHead();
        t.checkExpect(this.d3.node.next.sameNodeData(this.first), false);
        t.checkExpect(this.d3.node.next.sameNodeData(this.second), true);
        t.checkExpect(this.d3.node.next.prev.isSentinel(), true);
        t.checkExpect(this.d3.node.next.next.sameNodeData(this.third), true);
    }
    
    // test removeFromTail
    void testRemoveFromTail(Tester t) {
        reset();
        t.checkException("removeFromTail", 
                new RuntimeException("No items in this list."), 
                this.mts, "removeFromTail");
        reset();
        this.d1.removeFromTail();
        t.checkExpect(this.d1.node.prev.isSentinel(), true);
        t.checkExpect(this.d1.node.next.isSentinel(), true);
        reset();
        this.d2.removeFromTail();
        t.checkExpect(this.d2.node.prev.sameNodeData(this.cde), true);
        t.checkExpect(this.d2.node.next.sameNodeData(this.abc), true);
        t.checkExpect(this.d2.node.prev.next.isSentinel(), true);
        t.checkExpect(this.d2.node.prev.prev.sameNodeData(this.bcd), true);
        reset();
        this.d3.removeFromTail();
        t.checkExpect(this.d3.node.prev.sameNodeData(this.fourth), false);
        t.checkExpect(this.d3.node.prev.sameNodeData(this.third), true);
        t.checkExpect(this.d3.node.prev.next.isSentinel(), true);
        t.checkExpect(this.d3.node.prev.prev.sameNodeData(this.second), true);
    }
    
    // test find
    void testFind(Tester t) {
        reset();
        t.checkExpect(this.mtd.find("a"), this.mts);
        t.checkExpect(this.mtd.find(""), this.mts);
        t.checkExpect(this.d1.find("a"), this.a);
        t.checkExpect(this.d1.find("b"), this.s1);
        t.checkExpect(this.d2.find("cde"), this.cde);
        t.checkExpect(this.d2.find("efg"), this.s2);
        t.checkExpect(this.d3.find("second"), this.second);
        t.checkExpect(this.d3.find("fifth"), this.s3);
    }
    
    // test removeNode
    void testRemoveNode(Tester t) {
        reset();
        this.d1.removeNode(this.a);
        t.checkExpect(this.d1.node.next.isSentinel(), true);
        t.checkExpect(this.d1.node.prev.isSentinel(), true);
        t.checkExpect(this.d1.node.next.next.isSentinel(), true);
        reset();
        this.d2.removeNode(this.abc);
        t.checkExpect(this.d2.node.next.sameNodeData(this.bcd), true);
        t.checkExpect(this.d2.node.prev.sameNodeData(this.def), true);
        t.checkExpect(this.d2.node.next.prev.isSentinel(), true);
        reset();
        this.d2.removeNode(this.cde);
        t.checkExpect(this.d2.node.next.sameNodeData(this.abc), true);
        t.checkExpect(
                this.d2.node.next.next.next.sameNodeData(this.def), true);
        t.checkExpect(this.d2.node.prev.sameNodeData(this.def), true);
        t.checkExpect(this.d2.node.prev.prev.sameNodeData(this.bcd), true);
        t.checkExpect(
                this.d2.node.next.next.next.prev.sameNodeData(this.bcd), true);
        this.d2.removeNode(this.abc);
        t.checkExpect(this.d2.node.next.sameNodeData(this.bcd), true);
        t.checkExpect(this.d2.node.next.next.sameNodeData(this.def), true);
        t.checkExpect(this.d2.node.prev.sameNodeData(this.def), true);
        this.d2.removeNode(this.s2);
        t.checkExpect(this.d2.node.next.sameNodeData(this.bcd), true);
        t.checkExpect(this.d2.node.next.next.sameNodeData(this.def), true);
        t.checkExpect(this.d2.node.prev.sameNodeData(this.def), true);
        this.d3.removeNode(this.fourth);
        this.d3.removeNode(this.third);
        this.d3.removeNode(this.first);
        t.checkExpect(this.d3.node.next.sameNodeData(this.second), true);
        t.checkExpect(this.d3.node.prev.sameNodeData(this.second), true);
    }
}
