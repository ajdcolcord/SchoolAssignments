
// assignment 6
// partner1-Colcord-Austin
// partner1-acolcord
// partner2-Su-Jun
// partner2-jacklyso


import java.util.ArrayList;
import java.util.Arrays;
import tester.*;


// represents the examples of the Eliza interactions
public class ExamplesEliza {

    Reply why = new Reply("Why", 
            new ArrayList<String>(Arrays.asList("Because I said so...",
                    "The reason is...", 
                    "I dont think you will figure that out...")));
    Reply who = new Reply("Who",
            new ArrayList<String>(Arrays.asList("A doctor...",
                    "Me...", 
                    "It is you...")));
    Reply how = new Reply("How", 
            new ArrayList<String>(Arrays.asList("You should ask...",
                    "It is gonna be...", 
                    "You will be fine...")));
    Reply where = new Reply("Where",
            new ArrayList<String>(Arrays.asList("Right here...",
                    "10 miles away...", 
                    "Some where you know...")));
    Reply when = new Reply("When",
            new ArrayList<String>(Arrays.asList("In 10 years...",
                    "Today...", 
                    "Never...")));
    Reply what = new Reply("What",
            new ArrayList<String>(Arrays.asList("Nothing...",
                    "It doesn't matter...", 
                    "I don't care...")));

    Eliza e;
    ArrayList<Reply> eList;

    //reset to this state
    void reset() {
        eList = new ArrayList<Reply>();
        eList.add(why);
        eList.add(who);
        eList.add(where);
        eList.add(when);
        eList.add(how);
        eList.add(what);
        e = new Eliza(eList);


    }


    //test firstWord
    void testFirstWord(Tester t) {
        reset();
        t.checkExpect(this.e.firstWord("Hi, dude."), "Hi,");
        t.checkExpect(this.e.firstWord("What happened?"), "What");
        t.checkExpect(this.e.firstWord("Yo!"), "Yo!");
    }
    //test answer
    void testAnswer(Tester t) {
        reset();
        String s1 = this.e.answer("What happened?");
        t.checkOneOf("Success: randomAnswer",
                s1,  "Nothing...",
                "It doesn't matter...", 
                "I don't care...");
        reset();
        String s2 = this.e.answer("Why did this happen?");
        t.checkOneOf("Success: randomAnswer",
                s2,  "Because I said so...",
                "The reason is...", 
                "I dont think you will figure that out...");
        reset();
        String s3 = this.e.answer("When did this happen?");
        t.checkOneOf("Success: randomAnswer",
                s3, "In 10 years...",
                "Today...", 
                "Never...");
        reset();
        String s4 = this.e.answer("How did this happen?");
        t.checkOneOf("Success: randomAnswer",
                s4, "You should ask...",
                "It is gonna be...", 
                "You will be fine...");
        reset();
        String s5 = this.e.answer("Who made this happen?");
        t.checkOneOf("Success: randomAnswer",
                s5, "A doctor...",
                "Me...", 
                "It is you...");
        reset();
        String s6 = this.e.answer("Where did this happen?");
        t.checkOneOf("Success: randomAnswer",
                s6, "Right here...",
                "10 miles away...", 
                "Some where you know...");
    }
}
