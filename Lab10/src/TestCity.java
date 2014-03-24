import org.junit.Test;

import junit.framework.TestCase;


public class TestCity extends TestCase {
	//// assertEquals -> two arguments, test passes if the arguments match
	// assertTrue  -> one argument, test passes if the argument evaluates to true
	// assertFalse -> one argument, test passes if the argument evaluates to false
	@Test
    public void testCity(){
        assertEquals("title", new City("03301", "Concord", "NH", 71.527734, 43.218525).toString(),
                     "new City(03301, Concord, NH, 71.527734, 43.218525)");
        assertEquals(new City("04330", "Augusta", "ME", 69.766548, 44.323228).toString(),
                     "new City(04330, Augusta, ME, 69.766548, 44.323228)");
    }
	
	Examples e = new Examples();
	
	@Test
	public void testInitMap() {
    	e.makeNewEngland();
    	e.initMap();
    	assertEquals(e.newEngland.size(), 6);
    	assertTrue(e.newEngland.containsValue(e.NH));
    	assertTrue(e.newEngland.containsValue(e.VT));
    	assertTrue(e.newEngland.containsValue(e.ME));
    }
}