
// assignment 6
// partner1-Colcord-Austin
// partner1-acolcord
// partner2-Su-Jun
// partner2-jacklyso


import java.util.*;

/* Class Diagram
+--------------------+
|    Eliza           |
+--------------------+
| ArrayList<Reply>  r|
+--------------------+

*/

/*Template
Fields:
...this.r... - ArrayList<Reply>
Methods:
...this.findSpace()... - int
...this.firstWord()... - String
...this.answer()... - String
Methods for Fields:
...this.firstWord()... - String
...this.findSpace()... - int
 */


//represents the class Eliza, that contains a reply
public class Eliza {
    ArrayList<Reply> r;

    Eliza(ArrayList<Reply> r) {
        this.r = r;
    }

  
    //get the first word out of the given string
    String firstWord(String s) {
        String n = s.trim();
        if (n.indexOf(" ") == -1) {
            return s; 
        }
        else
            return s.substring(0, n.indexOf(" "));
    }

    //get the first word out and answer the question.
    String answer(String s) {
        String s2 = this.firstWord(s);
        String s3 = ("I do not know");
        for (int i = 0; i < this.r.size(); i = i + 1 ) {
            if (this.r.get(i).keyword.equalsIgnoreCase(s2)) {
                s3 = this.r.get(i).randomAnswer();

            }
        }
        return s3;
    }

}
