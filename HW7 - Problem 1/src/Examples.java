import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import tester.IllegalUseOfTraversalException;
import tester.Tester;
import tester.Traversal;



/** Testing the method toString */
public class Examples {

    /** data for the methods and tests */
    HashMap<City, State> newEngland = new HashMap<City, State>();
    ArrayList<String> nhNeighbors = new ArrayList<String>();
    ArrayList<String> vtNeighbors = new ArrayList<String>();
    ArrayList<String> meNeighbors = new ArrayList<String>();
    ArrayList<String> ctNeighbors = new ArrayList<String>();
    ArrayList<String> riNeighbors = new ArrayList<String>();
    ArrayList<String> maNeighbors = new ArrayList<String>();

    City concord = new City(3301, "Concord", "NH", 71.527734, 43.218525);
    City montpellier = 
            new City(5602, "Montpelier", "VT", 72.576992, 44.264082);
    City augusta = new City(4330, "Augusta", "ME", 69.766548, 44.323228);
    City hartford = new City(6120, "Hartford", "CT", 72.675807, 41.78596);
    City providence =
            new City(2908, "Providence", "RI", 71.437684, 41.838294);
    City boston = new City(2115, "Boston", "MA", 71.092215, 42.342706);
    City boston2 = new City(2115, "Boston", "MA", 71.092215, 42.342706);

    State nh = new State("NH", concord, nhNeighbors);
    State vt = new State("VT", montpellier, vtNeighbors);
    State me = new State("ME", augusta, meNeighbors);
    State ma = new State("MA", boston, maNeighbors);
    State ri = new State("RI", providence, riNeighbors);
    State ct = new State("CT", hartford, ctNeighbors);


    /** Generate lists of neighboring states */
    public void makeNewEngland() {
        nhNeighbors.add("ME");
        nhNeighbors.add("MA");
        nhNeighbors.add("VT");

        vtNeighbors.add("NH");
        vtNeighbors.add("MA");

        meNeighbors.add("NH");

        maNeighbors.add("VT");
        maNeighbors.add("NH");
        maNeighbors.add("CT");
        maNeighbors.add("RI");

        ctNeighbors.add("MA");
        ctNeighbors.add("RI");

        riNeighbors.add("CT");
        riNeighbors.add("MA");
    }

    /** Generate New England states */
    public void makeStates() {
        newEngland.put(concord, nh);
        newEngland.put(montpellier, vt);
        newEngland.put(augusta, me);
        newEngland.put(hartford, ct);
        newEngland.put(providence, ri);
        newEngland.put(boston, ma);
    }

    ArrayList<City> cities = new ArrayList<City>();

    /** initialize cities with the data from a file */
    /*public void initCities() {
        Traversal<City> tr = new InFileCityTraversal();

        try {
            while (!tr.isEmpty()) {
                cities.add(tr.getFirst());
                tr = tr.getRest();
            }
        }
        catch (IllegalUseOfTraversalException e) {
            System.out.println(
                    "IllegalUseOfTraversalException: cannot happen" +
                            e.getMessage());
        } 
    } */

    /** Display the instances using toString... */
    /*public void testPrint(Tester t) {
        this.makeNewEngland();
        this.makeStates();

        System.out.println("After initialization:");
        System.out.println("Concord: " + newEngland.get(concord));
        System.out.println("Montpellier: " + newEngland.get(montpellier));
        System.out.println("Augusta: " + newEngland.get(augusta));
        System.out.println("Hartford: " + newEngland.get(hartford));
        System.out.println("Providence: " + newEngland.get(providence));
        System.out.println("Boston: " + newEngland.get(boston));

        initCities();
        for (City c: cities) {
            System.out.println(c.toString());
        }
    }*/

    /** Add the given HashMap the six new england states*/
    public void initMap() {
        newEngland.put(concord, nh);
        newEngland.put(montpellier, vt);
        newEngland.put(augusta, me);
        newEngland.put(providence, ri);
        newEngland.put(boston, ma);
        newEngland.put(hartford, ct);
    }

    /** test the toString() method */
    @Test
    public void testToString() {
        assertEquals("new City(02115, Boston, MA, 71.092215, 42.342706)", 
                this.boston.toString());
        assertEquals("new City(02908, Providence, RI, 71.437684, 41.838294)", 
                this.providence.toString());
        assertEquals("new City(04330, Augusta, ME, 69.766548, 44.323228)", 
                this.augusta.toString());
    }

    /** test the equals method for City */
    @Test
    public void testEquals() {
        initMap();
        assertFalse(this.boston.equals(this.providence));
        assertTrue(this.boston.equals(this.boston2));
        assertEquals(this.newEngland.size(), 6);
        assertFalse(this.providence.equals(this.concord));
        assertTrue(this.augusta.equals(this.augusta));
        assertFalse(this.augusta.equals(this.boston));
        assertFalse(this.augusta.equals("hello"));
        assertFalse(this.augusta.equals(null));
    }

    /** test the method hashCode for the cities */
    @Test
    public void testHashCode() {
        initMap();
        assertEquals(this.boston.hashCode(), -1695553915);
        assertEquals(this.concord.hashCode(), -1589615712);
        assertEquals(this.providence.hashCode(), 1042529220);
    }

    /** test initMap method for City */
    @Test
    public void testInitMap() {
        initMap();
        assertEquals(this.newEngland.size(), 6);
        assertTrue(this.newEngland.containsValue(ct));
        assertTrue(this.newEngland.containsValue(me));
        assertTrue(this.newEngland.containsValue(ma));
        assertTrue(this.newEngland.containsKey(concord));
        assertTrue(this.newEngland.containsKey(providence));
        assertTrue(this.newEngland.containsKey(hartford));
        newEngland.put(boston2, ma);
        assertEquals(this.newEngland.size(), 6);
        assertTrue(this.newEngland.containsValue(ma));
        assertTrue(this.newEngland.containsKey(boston2));
        assertTrue(this.newEngland.containsKey(boston));
    }

    /** test isSouth method for City */
    @Test
    public void testIsSouth() {
        initMap();
        assertFalse(this.boston.isSouth(10.5231));
        assertTrue(this.boston.isSouth(50.1234));
        assertFalse(this.boston.isSouth(this.boston2.latitude));
        assertFalse(this.concord.isSouth(this.boston.latitude));
        assertTrue(this.providence.isSouth(this.augusta.latitude));
    }

    /** test sameState method for City */
    @Test
    public void testSameState() {
        initMap();
        assertTrue(this.boston.sameState(this.boston2));
        assertFalse(this.concord.sameState(this.providence));
        assertTrue(this.augusta.sameState(this.augusta));
    }
}
