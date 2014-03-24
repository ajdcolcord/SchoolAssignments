import java.awt.Color;
import tester.*;

/**
 * A sample of tests for the classes that handle user interactions
 * with the <code>Balloon</code> data.
 * 
 * @author Viera K. Proulx
 * @since 4 April 2010
 */
public class ExamplesBalloons{

    public ExamplesBalloons(){}
    Balloon b1;
    Balloon b2;


    public void reset() {
        /** sample Balloon instance */
        b1 = new Balloon(100, 200, 25, Color.red);

        /** another sample Balloon instance */
        b2 = new Balloon(200, 100, 25, Color.blue);
    }



  /**
   * The test suite for the class <code>Balloon</code>
   * @param t The instance of the <code>Tester</code> that manages the tests
   */
  public void tests(Tester t) {
      reset();
      // test the methods 'equal' in the class Balloon
      t.checkExpect(new Balloon(200, 100, 25, Color.blue), this.b2, "equal");

      // test the methods 'hashCode' in the class Balloon
      t.checkExpect((new Balloon(200, 100, 25, Color.blue)).hashCode(), 
              this.b2.hashCode(), "hashCode");	

      // test the methods 'getDiameter' in the class Balloon
      t.checkExpect(this.b2.getDiameter(), 50, "getDiameter");

      // test the methods 'moveBalloon' in the class Balloon
      t.checkExpect(this.b1.moveBalloon(50, -50), new Balloon(150, 150, 25, Color.red),
              "moveBalloon");

      // test the methods 'distanceFromTop' in the class Balloon
      t.checkExpect(this.b1.distanceFromTop(), 200 - 25, "distanceFromTop");

      // test the methods 'isHigherThan' in the class Balloon
      t.checkExpect(this.b1.isHigherThan(this.b2), false, "isHigherThan");

      /*
     t.checkExpect(b2.paintBalloon(window), b1.paintBalloon(window),
     "paintBalloon");
       */

  }
  public void testErase(Tester t) {
      reset();
     // b1.eraseBalloon();
     // t.checkExpect(this.b1.c.equals(Color.white));
  }
}