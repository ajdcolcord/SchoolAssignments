import java.util.*;

/** Template State
Fields:
...this.name... - String
...this.capital... - City
...this.neighbors... - ArrayList<String>
Methods:
...this.toString()... - String
 */

/** Class to represent one US State with its capital. */
public class State {
    
    String name;
    City capital;
    ArrayList<String> neighbors;

    /** Full constructor */
    State(String name, City capital, ArrayList<String> neighbors) {
        this.name = name;
        this.capital = capital; 
        this.neighbors = neighbors;
    }

    /** Print the State to a String 
     * 
     * @return String that will be a string of all of the state's data
    */
    public String toString() {
        return ("new State(" + 
                this.name  + ", " + 
                this.capital + ", " + 
                this.neighbors + ")\n");
    }
}