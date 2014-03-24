// assignment 5
// partner1-Colcord Austin
// partner1-acolcord
// partner2-Dorshimer Greg
// partner2-gddorsh

import tester.*;

// runs tests for the buddies problem
public class ExamplesBuddies {

    Person ann;
    Person bob;
    Person cole;
    Person dan;
    Person ed;
    Person fay;
    Person gabi;
    Person hank;
    Person jan;
    Person kim;
    Person len;
    
    ILoBuddy mt;
    ILoBuddy l1;
    ILoBuddy l2;
    ILoBuddy l3;

    // reset: sets all data to the following case
    void initBuddies() {
        
        this.ann = new Person("Ann");
        this.bob = new Person("Bob");
        this.cole = new Person("Cole");
        this.dan = new Person("Dan");
        this.ed = new Person("Ed");
        this.fay = new Person("Fay");
        this.gabi = new Person("Gabi");
        this.hank = new Person("Hank");
        this.jan = new Person("Jan");
        this.kim = new Person("Kim");
        this.len = new Person("Len");
        

        // adding the proper buddies
        this.ann.addBuddy(this.bob);
        this.ann.addBuddy(this.cole);
        this.bob.addBuddy(this.ann);
        this.bob.addBuddy(this.ed);
        this.bob.addBuddy(this.hank);
        this.cole.addBuddy(this.dan);
        this.dan.addBuddy(this.cole);
        this.ed.addBuddy(this.fay);
        this.fay.addBuddy(this.ed);
        this.fay.addBuddy(this.gabi);
        this.gabi.addBuddy(this.ed);
        this.gabi.addBuddy(this.fay);
        this.jan.addBuddy(this.kim);
        this.jan.addBuddy(this.len);
        this.kim.addBuddy(this.jan);
        this.kim.addBuddy(this.len);
        this.len.addBuddy(this.jan);
        this.len.addBuddy(this.kim);

        // lists of buddies
        this.mt = new MtLoBuddy();
        this.l1 = new ConsLoBuddy(this.ann, this.mt);
        this.l2 = new ConsLoBuddy(this.bob,
                new ConsLoBuddy(this.dan, this.mt));
        this.l3 = new ConsLoBuddy(this.ann, new ConsLoBuddy(this.bob,
                new ConsLoBuddy(this.dan, this.mt)));
    }
    

    // test isEmpty()
    void testIsEmpty(Tester t) {
        initBuddies();
        t.checkExpect(this.mt.isEmpty(), true);
        t.checkExpect(this.l1.isEmpty(), false);
        t.checkExpect(this.l2.isEmpty(), false);
        t.checkExpect(this.l3.isEmpty(), false);
    }

    // test append(ILoBuddy)
    void testAppend(Tester t) {
        initBuddies();
        t.checkExpect(this.mt.append(this.l1), this.l1);
        t.checkExpect(this.l1.append(this.l2), this.l3);
        t.checkExpect(this.mt.append(this.mt), this.mt);
        t.checkExpect(this.l1.append(this.mt), this.l1);
    }

    // test overlap(ILoBuddy)
    void testOverlap(Tester t) {
        initBuddies();
        t.checkExpect(this.l1.overlap(this.mt), this.mt);
        t.checkExpect(this.l2.overlap(this.l1), this.mt);
        t.checkExpect(this.l3.overlap(this.l1), this.l1);
        t.checkExpect(this.l3.overlap(this.l2), this.l2);
        t.checkExpect(this.l2.overlap(this.l3), this.l2);
    }

    // test hasDirectBuddy
    void testHasDirectBuddy(Tester t) {
        initBuddies();
        t.checkExpect(this.ann.hasDirectBuddy(this.bob), true);
        t.checkExpect(this.bob.hasDirectBuddy(this.ed), true);
        t.checkExpect(this.kim.hasDirectBuddy(this.ann), false);
        t.checkExpect(this.hank.hasDirectBuddy(this.ann), false);
    }

    // test countCommonBuddies
    void testCountCommonBuddies(Tester t) {
        initBuddies();
        t.checkExpect(this.ann.countCommonBuddies(this.dan), 1);
        t.checkExpect(this.jan.countCommonBuddies(this.len), 1);
        t.checkExpect(this.ann.countCommonBuddies(this.jan), 0);
        t.checkExpect(this.ann.countCommonBuddies(this.ann), 2);
    }

    // test hasDistantBuddy
    void testHasDistantBuddy(Tester t) {
        initBuddies();
        t.checkExpect(this.ann.hasDistantBuddy(this.gabi), true);
        t.checkExpect(this.ann.hasDistantBuddy(this.kim), false);
        t.checkExpect(this.hank.hasDistantBuddy(this.kim), false);
        t.checkExpect(this.cole.hasDistantBuddy(this.hank), false);
    }
    
    // test hasBeenSeen
    void testHasBeenSeen(Tester t) {
        initBuddies();
        t.checkExpect(this.hank.hasBeenSeen(this.cole.buddies), 
                new ConsLoBuddy(this.hank, this.cole.buddies));
        t.checkExpect(this.ann.hasBeenSeen(this.bob.buddies), 
                this.bob.buddies);
    }
    
    // test countHasBeenSeen
    void testCountHasBeenSeen(Tester t) {
        initBuddies();
        t.checkExpect(this.hank.countHasBeenSeen(this.l1), 2);
        t.checkExpect(this.ann.countHasBeenSeen(this.l1), 1);
        t.checkExpect(this.gabi.countHasBeenSeen(this.l2), 3);
        
        
    }
    
    // test partyCount
    void testPartyCount(Tester t) {
        initBuddies();
        t.checkExpect(this.hank.partyCount(), 1);
        t.checkExpect(this.len.partyCount(), 1);
        t.checkExpect(this.jan.partyCount(), 3);
        t.checkExpect(this.gabi.partyCount(), 3);
        t.checkExpect(this.ann.partyCount(), 8);
    }
}