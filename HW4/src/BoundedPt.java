import tester.*;


//////////////////////////////////////////////////////////////////////////////
//POSN
/* Template
Fields:
...this.x... - int
...this.y... - int
 */
abstract class Posn {
    int x;
    int y;
    
    Posn(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


//////////////////////////////////////////////////////////////////////////////
//BOUNDEDPT
/* Template
Fields:
... this.width...  - int
... this.height... - int
 */
class BoundedPt extends Posn {
    int width = 600;   // the width of the canvas
    int height = 400;  // the height of the canvas

    BoundedPt(int x, int y) {
        super(x, y);
        if (x > width) {
            throw new RuntimeException(
                    "The given x coordinate was " + 
                    (x - width) + 
                    " points beyond the right edge");
        }
        else if (x < 0) {
            throw new RuntimeException(
                    "The given x coordinate was " +
                    (0 - x) +
                    " points beyond the left edge");
        }
        else if (y  > height) {
            throw new RuntimeException(
                    "The given y coordinate was " +
                    (y - height) +
                    " points beyond the top edge");
        }
        else if (y < 0) {
            throw new RuntimeException(
                    "The given y coordinate was " +
                    (0 - y) +
                    " points beyond the bottom edge");
        }
        else {
            return;
        }
    }
}


//////////////////////////////////////////////////////////////////////////////
//EXAMPLESPT
class ExamplesPt {
    Posn p1 = new BoundedPt(100, 100);
    public void testExceptions(Tester t) {
        t.checkConstructorException(
                "new BoundedPt(-10, 100) \n" +
                        "The test should fail:"
                        + " the coordinate is not in the bounds",
                        new RuntimeException(
                                "The given x coordinate was 10 points "
                                + "beyond the left edge"),
                        "BoundedPt",
                        -10, 100);
        t.checkConstructorException(
                "new BoundedPt(610, 100) \n" +
                        "The test should fail:"
                        + " the coordinate is not in the bounds",
                        new RuntimeException(
                                "The given x coordinate was 10 points "
                                + "beyond the right edge"),
                        "BoundedPt",
                        610, 100);
        t.checkConstructorException(
                "new BoundedPt(100, -10) \n" +
                        "The test should fail:"
                        + " the coordinate is not in the bounds",
                        new RuntimeException(
                                "The given y coordinate was 10 points "
                                + "beyond the bottom edge"),
                        "BoundedPt",
                        100, -10);
        t.checkConstructorException(
                "new BoundedPt(100, 410) \n" +
                        "The test should fail:"
                        + " the coordinate is not in the bounds",
                        new RuntimeException(
                                "The given y coordinate was 10 points "
                                + "beyond the top edge"),
                        "BoundedPt",
                        100, 410);
    } 
}