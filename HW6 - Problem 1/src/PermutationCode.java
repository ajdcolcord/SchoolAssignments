
// assignment 6
// partner1-Colcord-Austin
// partner1-acolcord
// partner2-Su-Jun
// partner2-jacklyso



import java.util.*;

/*
+-------------------------------+
|      PermutationCode          |
+-------------------------------+
| ArrayList<Character> alphabet |
| ArrayList<Character> code     |
+-------------------------------+

*/


/*Template
Fields:
...this.alphabet... - ArrayList<Character>
...this.code... - ArrayList<Character>
Methods:
...this.get()... - ArrayList<Character>
...this.initEncoder()... - ArrayList<Character>
...this.encode()... - String
...this.decode()... - String
Methods for Fields:
...this.code.get()... - ArrayList<Character>
 */

/**
 * A class that defines a new permutation code, as well as methods for encoding
 * and decoding of the messages that use this code.
 */
public class PermutationCode {
    /** The original list of characters to be encoded */
    ArrayList<Character> alphabet = 
            new ArrayList<Character>(Arrays.asList(
                    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 
                    'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 
                    't', 'u', 'v', 'w', 'x', 'y', 'z'));

    ArrayList<Character> code = new ArrayList<Character>(26);

    /** A random number generator */
    Random rand = new Random();

    /**
     * Create a new instance of the encoder/decoder with a new permutation code 
     */
    PermutationCode() {
        this.code = this.initEncoder();
    }

    /**
     * Create a new instance of the encoder/decoder with the given code 
     */
    PermutationCode(ArrayList<Character> code) {
        this.code = code;
    }

    //get the ArrayList out from the PermutationCode
    ArrayList<Character> get() {
        return this.code;
    }

    /** Initialize the encoding permutation of the characters */
    ArrayList<Character> initEncoder() {
        ArrayList<Character> newArList = new ArrayList<Character>();
        ArrayList<Character> alph2 = new ArrayList<Character>(alphabet); 
        ArrayList<Character> alph3 = new ArrayList<Character>(alphabet);
        for (int i = 0; i < alph3.size(); i = i + 1) {
            int j = rand.nextInt(alph3.size() - i);
            char s = alph2.get(j);
            newArList.add(s); 
            alph2.remove(j);
        }
        return newArList;
    }

    /**
     * produce an encoded <code>String</code> from the given <code>String</code>
     * @param source the <code>String</code> to encode
     * @return the secretly encoded <String>
     */
    String encode(String source) {
        String newString = "";
        for (int i = 0; i < source.length(); i = i + 1 ) {
            char s = source.charAt(i);
            int aIndex = alphabet.indexOf(s);
            newString = newString + code.get(aIndex);
        }

        return newString;

    }

    /**
     * produce an decoded <code>String</code> from the given <code>String</code>
     * @param source the <code>String</code> to decode
     * @return the revealed <String>
     */
    String decode(String source) {
        String newString = "";
        for (int i = 0; i < source.length(); i = i + 1) {
            char s = source.charAt(i);
            newString = newString + alphabet.get(code.indexOf(s));
        }
        return newString;

    }
}