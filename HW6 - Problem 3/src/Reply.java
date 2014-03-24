
// assignment 6
// partner1-Colcord-Austin
// partner1-acolcord
// partner2-Su-Jun
// partner2-jacklyso


import java.util.*;

/*CLASS DIAGRAM

+---------------------------+
|    Reply                  |
+---------------------------+
| String  keyword           |
| ArrayList<String> answers |
+---------------------------+

 */

/* Template
Fields:
...this.keyword... - String
...this.answers... - ArrayList<String>
Methods:
...this.randomAnswer()... - String
Methods for Fields:

 */

// represents the class that holds the answers for the given keywords
public class Reply {
    String keyword;
    ArrayList<String> answers;

    Reply(String keyword, ArrayList<String> answers) {
        this.keyword = keyword;
        this.answers = answers;
    }

    /** A random number generator */
    Random rand = new Random();

    // produce one of the answer randomly from the ArrayList<String>
    String randomAnswer() {
        int a = rand.nextInt(this.answers.size());
        return answers.get(a);
    }
}
