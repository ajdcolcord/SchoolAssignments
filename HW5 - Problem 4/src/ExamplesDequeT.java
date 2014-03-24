// assignment 5
// partner1-Colcord Austin
// partner1-acolcord
// partner2-Dorshimer Greg
// partner2-gddorsh


import tester.*;

// represents the examples for the lists
public class ExamplesDequeT {
    
    Person jake;
    Person alex;
    Person joe;
    Person mary;
    Person emily;
    
    SentinelT<String> mts;
    SentinelT<String> s1;
    SentinelT<String> s2;
    SentinelT<String> s3;
    
    DequeT<String> mtd;
    DequeT<String> d1;
    DequeT<String> d2;
    DequeT<String> d3;
    
    NodeT<String> a;
    NodeT<String> abc;
    NodeT<String> bcd;
    NodeT<String> cde;
    NodeT<String> def;
    NodeT<String> first;
    NodeT<String> second;
    NodeT<String> third;
    NodeT<String> fourth;
    
    
    SentinelT<Person> mtsp;
    SentinelT<Person> sp1;
    SentinelT<Person> sp2;
    
    NodeT<Person> jaken;
    NodeT<Person> alexn;
    NodeT<Person> joen;
    NodeT<Person> maryn;
    NodeT<Person> emilyn;
    
    DequeT<Person> mtdp;
    DequeT<Person> dp1;
    DequeT<Person> dp2;
    
    // reset to these states
    void reset() {
        
        //////////////////////////////////////////////////////
        //represent the examples of strings
        mts = new SentinelT<String>(null, null);
        s1 = new SentinelT<String>(null, null);
        s2 = new SentinelT<String>(null, null);
        s3 = new SentinelT<String>(null, null);
    
        mtd = new DequeT<String>(this.mts);
        d1 = new DequeT<String>(this.s1);
        d2 = new DequeT<String>(this.s2);
        d3 = new DequeT<String>(this.s3);
    
        a = new NodeT<String>("a", null, null);
        abc = new NodeT<String>("abc", null, null);
        bcd = new NodeT<String>("bcd", null, null);
        cde = new NodeT<String>("cde", null, null);
        def = new NodeT<String>("def", null, null);
        first = new NodeT<String>("first", null, null);
        second = new NodeT<String>("second", null, null);
        third = new NodeT<String>("third", null, null);
        fourth = new NodeT<String>("fourth", null, null);
        
        
        //representing an empty list of strings
        this.mts.next = this.mts;
        this.mts.prev = this.mts;
        this.mtd = new DequeT<String>(this.mts);
        
        //representing a list with one string in the list
        this.s1.next = this.a;
        this.s1.prev = this.a;
        this.a.next = this.s1;
        this.a.prev = this.s1;
        this.d1 = new DequeT<String>(this.s1);
        
        //representing the list with abc, bcd, cde, def (Strings)
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
        this.d2 = new DequeT<String>(this.s2);
        
        // representing another list with four other values (Strings)
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
        this.d3 = new DequeT<String>(this.s3);
        
        //////////////////////////////////////////////////////
        // represent the examples of people
        this.jake = new Person("Jake", 25);
        this.alex = new Person("Alex", 20);
        this.joe = new Person("Joe", 41);
        this.mary = new Person("Mary", 15);
        this.emily = new Person("Emily", 46);
        
        this.jaken = new NodeT<Person>(this.jake, null, null);
        this.alexn = new NodeT<Person>(this.alex, null, null);
        this.joen = new NodeT<Person>(this.joe, null, null);
        this.maryn = new NodeT<Person>(this.mary, null, null);
        this.emilyn = new NodeT<Person>(this.emily, null, null);
        
        this.mtsp = new SentinelT<Person>(null, null);
        this.sp1 = new SentinelT<Person>(null, null);
        this.sp2 = new SentinelT<Person>(null, null);
    
        this.mtdp = new DequeT<Person>(this.mtsp);
        this.dp1 = new DequeT<Person>(this.sp1);
        this.dp2 = new DequeT<Person>(this.sp2);
        
        //representing an empty list of strings
        //this.mtsp = new SentinelT(this.mtsp, this.mtsp);
        this.mtsp.next = this.mtsp;
        this.mtsp.prev = this.mtsp;
        this.mtdp = new DequeT<Person>(this.mtsp);
        
        //representing a list with one string in the list
        //this.sp1 = new SentinelT(this.jaken, this.jaken);
        this.sp1.next = this.jaken;
        this.sp1.prev = this.jaken;
        this.jaken.next = this.sp1;
        this.jaken.prev = this.sp1;
        this.dp1 = new DequeT<Person>(this.sp1);
        
        
        //representing the list with alex, joe, mary, emily (People)
        //this.sp2 = new SentinelT(this.alexn, this.emilyn);
        this.sp2.next = this.alexn;
        this.alexn.next = this.joen;
        this.joen.next = this.maryn;
        this.maryn.next = this.emilyn;
        this.emilyn.next = this.sp2;
        this.sp2.prev = this.emilyn;
        this.emilyn.prev = this.maryn;
        this.maryn.prev = this.joen;
        this.joen.prev = this.alexn;
        this.alexn.prev = this.sp2;
        this.dp2 = new DequeT<Person>(this.sp2);
    }
    
    // test the method isSentinel
    void testIsSentiel(Tester t) {
        reset();
        
        t.checkExpect(this.mts.isSentinel(), true);
        t.checkExpect(this.a.isSentinel(), false);
        t.checkExpect(this.abc.isSentinel(), false);
        t.checkExpect(this.s1.isSentinel(), true);
        
        
        t.checkExpect(this.mtsp.isSentinel(), true);
        t.checkExpect(this.sp1.isSentinel(), true);
        t.checkExpect(this.alexn.isSentinel(), false);
        t.checkExpect(this.sp2.isSentinel(), true);
        
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
        
        
        t.checkExpect(this.mtsp.size(), 0);
        t.checkExpect(this.sp2.size(), 4);
        t.checkExpect(this.sp1.size(), 1);
        t.checkExpect(this.dp1.size(), 1);
        t.checkExpect(this.dp2.size(), 4);
        
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
        t.checkExpect(this.d2.node.next.prev.isSentinel(), true);
        t.checkExpect(this.d2.node.next.next.sameNodeData(this.abc), true);
        t.checkExpect(this.d2.node.next.next.prev.sameNodeData(this.a), true);
        t.checkExpect(this.d2.node.next.sameNodeData(this.abc), false);
        t.checkExpect(this.d2.node.prev.sameNodeData(this.def), true);
        reset();
        
        
        this.mtdp.addAtHead(new Person("Jake", 25));
        
        
        t.checkExpect(this.mtdp.node.next.sameNodeData(this.maryn), false);
        t.checkExpect(this.mtdp.node.next.data.name.equals("Jake"), true);
        t.checkExpect(this.mtdp.node.next.data.age, 25);
        t.checkExpect(this.mtdp.node.prev.data.name.equals("Jake"), true);
        t.checkExpect(this.mtdp.node.prev.prev.isSentinel(), true);
        t.checkExpect(
                this.mtdp.node.next.next.next.data.name.equals("Jake"), true);
        reset(); 
        t.checkExpect(this.sp2.next, this.alexn);
        t.checkExpect(this.sp2.next.data, this.alex);
        t.checkExpect(this.sp2.prev.data, this.emily);
        this.dp2.addAtHead(this.jake);
        t.checkExpect(this.dp2.node.next.data.name.equals("Jake"), true);
        t.checkExpect(this.dp2.node.next.data.age, 25);
        t.checkExpect(this.dp2.node.next.next.data.name.equals("Alex"), true);
        t.checkExpect(this.dp2.node.next.next, this.alexn);
        t.checkExpect(this.dp2.node.next.prev.isSentinel(), true);
        t.checkExpect(this.dp2.node.prev.prev, this.maryn);
        t.checkExpect(this.dp2.node.next.next.isSentinel(), false);
        
        
        
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
        t.checkExpect(this.d2.node.prev.next.isSentinel(), true);
        t.checkExpect(this.d2.node.prev.prev.sameNodeData(this.def), true);
        t.checkExpect(this.d2.node.prev.prev.next.sameNodeData(this.a), true);
        t.checkExpect(this.d2.node.next.sameNodeData(this.abc), true);
        t.checkExpect(this.d2.node.prev.sameNodeData(this.def), false);
        reset();
        
        
        this.mtdp.addAtTail(this.jake);
        t.checkExpect(this.mtdp.node.prev.data, this.jake);
        t.checkExpect(this.mtdp.node.next.data, this.jake);
        t.checkExpect(this.mtdp.node.next.next.isSentinel(), true);
        t.checkExpect(this.mtdp.node.prev.prev.isSentinel(), true);
        reset();
        this.dp1.addAtTail(this.alex);
        t.checkExpect(this.dp1.node.next.data, this.jake);
        t.checkExpect(this.dp1.node.prev.data, this.alex);
        t.checkExpect(this.dp1.node.next.prev.isSentinel(), true);
        t.checkExpect(this.dp1.node.prev.prev.prev.isSentinel(), true);
        t.checkExpect(this.dp1.node.next, this.jaken);
        t.checkExpect(this.dp1.node.prev.prev.data, this.jake);
        reset();
        this.dp2.addAtTail(this.jake);
        t.checkExpect(this.dp2.node.prev.data, this.jake);
        t.checkExpect(this.dp2.node.prev.next.isSentinel(), true);
        t.checkExpect(this.dp2.node.prev.prev.data, this.emily);
       
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
        reset();
        
        
        this.dp1.removeFromHead();
        t.checkExpect(this.dp1.node.next.isSentinel(), true);
        t.checkExpect(this.dp1.node.prev.isSentinel(), true);
        reset();
        this.dp2.removeFromHead();
        t.checkExpect(this.dp2.node.next.data, this.joe);
        t.checkExpect(this.dp2.node.prev.data, this.emily);
        t.checkExpect(this.dp2.node.next.prev.isSentinel(), true);
        t.checkExpect(this.dp2.node.next.next.data, this.mary);
                
                
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
        reset();
        
        
        this.dp1.removeFromTail();
        t.checkExpect(this.dp1.node.prev.isSentinel(), true);
        t.checkExpect(this.dp1.node.next.isSentinel(), true);
        reset();
        this.dp2.removeFromTail();
        t.checkExpect(this.dp2.node.next.data, this.alex);
        t.checkExpect(this.dp2.node.prev.data, this.mary);
        t.checkExpect(this.dp2.node.next.next.data, this.joe);
        t.checkExpect(this.dp2.node.prev.next.isSentinel(), true);
        t.checkExpect(this.dp2.node.prev.prev.data, this.joe);
                
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
        
        
        
        t.checkExpect(this.mtdp.find(new Person("Jake", 25)), this.mtsp);
        t.checkExpect(this.mtdp.find(null), this.mtsp);
        t.checkExpect(this.dp1.find(this.alex), this.sp1);
        t.checkExpect(this.dp1.find(this.jake), this.jaken);
        
        t.checkExpect(this.dp2.find(this.jake), this.sp2);
        t.checkExpect(this.dp2.find(this.alex), this.alexn);
        t.checkExpect(this.dp2.find(this.mary), this.maryn);
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
        reset();
        
        
        this.dp1.removeNode(this.jaken);
        t.checkExpect(this.dp1.node.next.isSentinel(), true);
        t.checkExpect(this.dp1.node.prev.isSentinel(), true);
        t.checkExpect(this.dp1.node.next.next.isSentinel(), true);
        reset();
        this.dp2.removeNode(this.alexn);
        t.checkExpect(this.dp2.node.next, this.joen);
        t.checkExpect(this.dp2.node.next.prev.isSentinel(), true);
        t.checkExpect(this.dp2.node.prev.isSentinel(), false);
        this.dp2.removeNode(this.maryn);
        t.checkExpect(this.dp2.node.next, this.joen);
        t.checkExpect(this.dp2.node.next.next, this.emilyn);
        t.checkExpect(this.dp2.node.prev.next.isSentinel(), true);
        t.checkExpect(this.dp2.node.prev, this.emilyn);
        t.checkExpect(this.dp2.node.prev.prev, this.joen);
        
    } 
}
