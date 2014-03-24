import tester.*;
/*

             +---------+
             | IMobile |<---------------+
             +---------+                |
             +---------+                |
                 |                      |
                / \                     |
                ---                     |
                 |                      |
       ---------------------            |
       |                   |            |
+--------------+   +---------------+    |
| Simple       |   | Complex       |    |
+--------------+   +---------------+    |
| int length   |   | int length    |    |
| int weight   |   | int leftside  |    |
| String color |   | int rightside |    |
+--------------+   | IMobile left  |----+
                   | IMobile right |----+
                   +---------------+
*/


//////////////////////////////////////////////////////////////////////////////
interface IMobile { 
    int totalWeight();
    int totalHeight();
    boolean isBalanced();
}

//////////////////////////////////////////////////////////////////////////////
class Simple implements IMobile {
    int length;
    int weight;
    String color;
    
    Simple(int length, int weight, String color) {
        this.length = length;
        this.weight = weight;
        this.color = color;
    }
    
    //totalWeight() tells the weight of the mobile
    public int totalWeight() {
        return this.weight;
    }
    
    //totalHeight() tells the weight of the mobile
    public int totalHeight() {
        return this.weight + this.length;
    }
    
    //isBalanced() tells if the mobile is balanced
    public boolean isBalanced() {
        return true;
    }
}


//////////////////////////////////////////////////////////////////////////////
class Complex implements IMobile {
    int length;
    int leftside;
    int rightside;
    IMobile left;
    IMobile right;
    
    Complex(int length, int leftside, int rightside,
            IMobile left, IMobile right) {
        this.length = length;
        this.leftside = leftside;
        this.rightside = rightside;
        this.left = left;
        this.right = right;
    }
    
    //total Weight() tells the total weight of the mobile
    public int totalWeight() {
        return this.left.totalWeight() + this.right.totalWeight();
    }
    
    //totalHeight() tells the total height of the mobile
    public int totalHeight() {
        if (this.left.totalHeight() > this.right.totalHeight()) {
            return this.left.totalHeight() + this.length;
        }
        else {
            return this.right.totalHeight() + this.length;
        }
    }
    
    //isBalanced() determines if the mobile is balanced
    public boolean isBalanced() {
        if ((this.left.totalWeight() * this.rightside) ==
                  (this.right.totalWeight() * this.leftside)) {
            return true;
        }
        else {
            return false;
        }
    }
}

//////////////////////////////////////////////////////////////////////////////
//EXAMPLES
class ExamplesMobiles {
    IMobile simple1 = new Simple(1, 10, "red");
    IMobile simple2 = new Simple(2, 10, "blue");
    IMobile simple3 = new Simple(3, 40, "green");
    
    IMobile complex1 = new Complex(1, 6, 6, simple1, simple2);
    IMobile complex2 = new Complex(3, 12, 5, complex1, simple3);
    
    //totalWeight Examples
    boolean testTotalWeight(Tester t) {
        return t.checkExpect(this.simple1.totalWeight(), 10) &&
               t.checkExpect(this.complex2.totalWeight(), 60);
    }
    
    //totalHeight Examples
    boolean testTotalHeight(Tester t) {
        return  t.checkExpect(this.simple1.totalHeight(), 11) &&
                t.checkExpect(this.complex1.totalHeight(), 13) &&
                t.checkExpect(this.complex2.totalHeight(), 46);
    }
    //isBalanced Examples
    boolean testIsBalanced(Tester t) {
        return t.checkExpect(this.simple1.isBalanced(), true) &&
               t.checkExpect(this.complex2.isBalanced(), false);
    }
}