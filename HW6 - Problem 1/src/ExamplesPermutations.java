
// assignment 6
// partner1-Colcord-Austin
// partner1-acolcord
// partner2-Su-Jun
// partner2-jacklyso



import java.util.ArrayList;
import java.util.Arrays;

import tester.Tester;


// represents the examples of the permutations
public class ExamplesPermutations {
    
    PermutationCode permCode1;
    PermutationCode permCode2;
    ArrayList<Character> permCode1Init;
    
    void reset() {
        permCode1 = new PermutationCode(
                new ArrayList<Character>(Arrays.asList(
                        'a', 'd', 'g', 'j', 'm', 'p', 's', 'v', 'x', 'z', 
                        'b', 'e', 'h', 'k', 'n', 'q', 't', 'w', 'y', 
                        'c', 'f', 'i', 'l', 'o', 'r', 'u')));
        permCode2 = new PermutationCode();
    }
    
    // test encode
    void testEncode(Tester t) {
        reset();
        t.checkExpect(this.permCode1.encode("abc"), "adg");
        t.checkExpect(this.permCode1.encode("hello"), "vmeen");
        t.checkExpect(this.permCode1.encode(""), "");
    }
    
    // test decode
    void testDecode(Tester t) {
        reset();
        t.checkExpect(this.permCode1.decode("adg"), "abc");
        t.checkExpect(this.permCode1.decode("vmeen"), "hello");
        t.checkExpect(this.permCode1.decode(""), "");
    }
    
    // test initEncoder
    void testInitEncoder(Tester t) {
        reset();
        t.checkRange(permCode2.get().indexOf('a'), 0, 26);
        t.checkRange(permCode2.get().indexOf('b'), 0, 26);
        t.checkRange(permCode2.get().indexOf('c'), 0, 26);
        t.checkRange(permCode2.get().indexOf('d'), 0, 26);
        t.checkRange(permCode2.get().indexOf('e'), 0, 26);
        t.checkRange(permCode2.get().indexOf('f'), 0, 26);
        t.checkRange(permCode2.get().indexOf('g'), 0, 26);
        t.checkRange(permCode2.get().indexOf('h'), 0, 26);
        t.checkRange(permCode2.get().indexOf('i'), 0, 26);
        t.checkRange(permCode2.get().indexOf('j'), 0, 26);
        t.checkRange(permCode2.get().indexOf('k'), 0, 26);
        t.checkRange(permCode2.get().indexOf('l'), 0, 26);
        t.checkRange(permCode2.get().indexOf('m'), 0, 26);
        t.checkRange(permCode2.get().indexOf('n'), 0, 26);
        t.checkRange(permCode2.get().indexOf('o'), 0, 26);
        t.checkRange(permCode2.get().indexOf('p'), 0, 26);
        t.checkRange(permCode2.get().indexOf('q'), 0, 26);
        t.checkRange(permCode2.get().indexOf('r'), 0, 26);
        t.checkRange(permCode2.get().indexOf('s'), 0, 26);
        t.checkRange(permCode2.get().indexOf('t'), 0, 26);
        t.checkRange(permCode2.get().indexOf('u'), 0, 26);
        t.checkRange(permCode2.get().indexOf('v'), 0, 26);
        t.checkRange(permCode2.get().indexOf('w'), 0, 26);
        t.checkRange(permCode2.get().indexOf('x'), 0, 26);
        t.checkRange(permCode2.get().indexOf('y'), 0, 26);
        t.checkRange(permCode2.get().indexOf('z'), 0, 26);
    }

}
