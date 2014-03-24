
import java.text.*;  // to get DecimalFormat


/** Template City
Fields:
...this.zip... - String
...this.name... - String
...this.state... - String
...this.longitude... - double
...this.latitude... - double
Methods:
...this.toString()... - String
...this.equals()... - boolean
...this.hashCode()... - int
...this.isSouth()... - boolean
...this.sameState()... - boolean
Methods for Fields:
...this.state.equals()... - boolean
 */
/** Represents a City */
public class City {
    /** Decimal format to print leading zeros in zip code */
    static DecimalFormat zipFormat = new DecimalFormat("00000");

    int zip;
    String name;
    String state;
    double longitude;
    double latitude;


    /** The full constructor */
    public City(int zip, String name, String state, 
            double longitude, double latitude) {
        this.zip   = zip;
        this.name  = name;
        this.state = state;
        this.longitude = longitude;
        this.latitude  = latitude;
    }    

    /** Represent city data as a String for printed display
     * 
     * @return the string of the city data
     */
    public String toString() {
        return  ("new City(" + 
                City.zipFormat.format(this.zip) + ", " + 
                this.name  + ", " + this.state + ", " + 
                this.longitude + ", " + this.latitude + ")");
    }

    /** Tells if the two cities are the same 
     * 
     * @param obj an object that will be tested to see if it
     *            is equal to this city
     * @return a boolean that will be true if the object is equal, false if not
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        else if (!(obj instanceof City)) {
            return false;
        }
        else {
            City temp = (City)obj;
            return  
                    this.name.equals(temp.name) &&
                    this.state.equals(temp.state) &&
                    this.zip == temp.zip &&
                    this.latitude == temp.latitude &&
                    this.longitude == temp.longitude;
        }
    }

    /** initializes the hashCode for the City 
     * adds all of the hashCodes up from the data inside the city
     * to return the hashcode of this city
     * 
     * @return an int as the hashCode for this city
     */
    public int hashCode() {
        return  Integer.valueOf(this.zip).hashCode() +
                this.state.hashCode() +
                this.name.hashCode() +
                Double.valueOf(this.longitude).hashCode() +
                Double.valueOf(this.latitude).hashCode();
    }

    /** determines whether the city is south of the given latitude
     * 
     * @param that is the other latitude
     * @return returns a boolean, true if this latitude is less than that
     *                            false if this latitude is greater than that
     */
    public boolean isSouth(double that) {
        return this.latitude < that;
    }

    /** determines if this city is in the same state as the given city 
     * 
     * @param that a city that will be tested against this
     * @return boolean that will be true if this city's state is equal
     *                 to that city's state
     */
    public boolean sameState(City that) {
        return this.state.equals(that.state);
    }
}
