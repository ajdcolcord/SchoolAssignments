
import java.text.*;  // to get DecimalFormat

/** Represents a City */
class City {
    /** Decimal format to print leading zeros in zip code */
    DecimalFormat zipFormat = new DecimalFormat("00000");

    String zip;
    String name;
    String state;
    double longitude;
    double latitude;

    
    /** The full constructor */
    public City (String zip, String name, String state, double longitude, double latitude){
        this.zip   = zip;
        this.name  = name;
        this.state = state;
        this.longitude = longitude;
        this.latitude  = latitude;
    }    
    
    
    public boolean equals(Object obj) {
    	  if (obj == null)
    	    return false;
    	  City temp = (City)obj;
    	  return temp.zip.equals(this.zip) &&
    			  temp.name.equals(this.name) && 
    			  temp.state.equals(this.state) && 
    			  temp.longitude == this.longitude && 
    			  temp.latitude == new Double(this.latitude);
    	}
    
    
    public int hashCode() {
    	return this.zip.hashCode() +
    			this.name.hashCode() +
    			this.state.hashCode();
    }
    
    

    /** Represent  city data as a String for printed display */
    public String toString(){
        return ("new City(" + 
                this.zip + ", " + 
                this.name  + ", " + this.state + ", " + 
                this.longitude + ", " + this.latitude + ")");
    }
}
