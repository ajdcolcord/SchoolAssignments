import tester.Tester;

//assignment 1
//partner1-Colcord-Austin
//partner1-acolcord
//partner2-Su-Jun
//partner2-jacklyso

/*
//////////////////////////////////////////////////////////////////////////////
//CLASS DIAGRAM

           +--------------------+      
           |     ILoCell        |<-----------------------+
           +--------------------+                        |
           +--------------------+                        |
           |appendList() ILoCell|                        |
           |isInList()   boolean|                        |
           |reList()     ILoCell|                        |
           |countArgs()  int    |                        |
           +--------------------+                        |
                   |                                     |
          +------------------+                           |
          v                  v                           |
+---------------------+    +---------------------+       |
|      MtLoCell       |    |     ConsLoCell      |       |
+---------------------+    +---------------------+       |
+---------------------+  +-| IData         first |       |
| appendList() ILoCell|  | | ILoCell       rest  |-------+
| isInList()   boolean|  | +---------------------+   
| reList()     ILoCell|  | | appendList() ILoCell|
| countArgs()     int |  | | isInList()   boolean|
+---------------------+  | | countArgs()  int    | 
                         | +---------------------+      
                         |
                         |
                         V                                  
           +--------------------+      
           |       IData        |<----------------+
           +--------------------+                 |  
           +--------------------+                 |
           |value()          int|                 |
           |countArgs()      int|                 |
           |createList() ILoCell|                 |
           +--------------------+                 |
                    |                             |  
         +----------------------+                 |
         v                      v                 |
+---------------------+ +---------------------+   |
|       Number        | |      AFormula       |   |
+---------------------+ +---------------------+   |
| int         row     | | int        row      |   |
| String     column   | | String   column     |   |
| int          num    | | IData     cell1     |---+
+---------------------+ | IData     cell2     |---+
| value()      int    | +---------------------+ 
| countArgs()  int    | | countArgs() int     |
| createList() ILoCell| | createList() ILoCell|
+---------------------+ +---------------------+ 
                                  ^
                                  |                                
                                  |                                
            +-------------------+----------------------+           
            v                   v                      v           
+-------------------+ +------------------+ +------------------+    
|        Add        | |        Min       | |     Multiply     |   
+-------------------+ +------------------+ +------------------+   
+-------------------+ +------------------+ +------------------+   
| value()      int  | | value()    int   | | value()    int   |   
+-------------------+ +------------------+ +------------------+ 
                             
//////////////////////////////////////////////////////////////////////////////

|      A     |     B    |   C   |   D   |      E     |
--+------------+----------+-------+-------+------------+
1 |      8     |     3    |   4   |   6   |      2     |
--+------------+----------+-------+-------+------------+
2 | min(B1,E1) | +(A1,C1) |       |       |  *(B2,D1)  |
--+------------+----------+-------+-------+------------+
3 |  *(A1,A2)  | +(B2,E1) |       |       | min(A3,D1) |
--+------------+----------+-------+-------+------------+
4 |            | +(B3,B2) |       |       | min(B4,E3) |
--+------------+----------+-------+-------+------------+
5 |            | *(B4,B3) |       |       |  +(B5,E4)  |
--+------------+----------+-------+-------+------------+



|      A     |     B    |   C   |   D   |      E     |
--+------------+----------+-------+-------+------------+
1 |      8     |     3    |   4   |   6   |      2     |
--+------------+----------+-------+-------+------------+
2 |      2     |    12    |       |       |     72     |
--+------------+----------+-------+-------+------------+
3 |     16     |    14    |       |       |      6     |
--+------------+----------+-------+-------+------------+
4 |            |    26    |       |       |      6     |
--+------------+----------+-------+-------+------------+
5 |            |   364    |       |       |    370     |
--+------------+----------+-------+-------+------------+

*/


//////////////////////////////////////////////////////////////////////////////
//ILoCell
/* Template
Methods:
...this.appendList(ILoCell that)... - ILoCell
...this.isInList(IData that)... - boolean
...this.reList()... - ILoCell
...this.countArgs()... - int
 */
//Represents the list of cells
interface ILoCell { 
    ILoCell appendList(ILoCell that);
    boolean isInList(IData that);
    ILoCell reList();
    int countArgs();
}


//////////////////////////////////////////////////////////////////////////////
//MtLoCell
/* Template
Methods:
...this.appendList(ILoCell that)... ILoCell
...this.isInList(IData that)... boolean
...this.reList()... - ILoCell
...this.countArgs()... - int
*/
//Represents the empty list of cells
class MtLoCell implements ILoCell {
    MtLoCell() {
        //empty constructor, since this is an empty list class
    }
    
    //appendList() will return that list, since this list is empty
    public ILoCell appendList(ILoCell that) {
        return that;
    }
    
    //isInList(IData that) will return false, since this is an empty list
    public boolean isInList(IData that) {
        return false;
    }
    
    //reList() will return this, since there are no duplicates
    public ILoCell reList() {
        return this;
    }
    
    //countArgs() will return 0, since there are no items in the list
    public int countArgs() {
        return 0;
    }
}


//////////////////////////////////////////////////////////////////////////////
//ConsLoCell
/* Template
Fields:
...this.first... - IData
...this.rest... - ILoCell
Methods:
...this.appendList(ILoCell that)... - ILoCell
...this.isInList(IData that)... - boolean
...this.reList()... - ILoCell
...this.countArgs()... - int
Methods for Fields:
...this.first.appendList(ILoCell that)... - ILoCell
...this.rest.appendList(ILoCell that)... - ILoCell
...this.first.isInList(IData that)... - boolean
...this.rest.isInList(IData that)... - boolean
...this.first.reList()... - ILoCell
...this.rest.reList()... - ILoCell
...this.first.countArgs()... - int
...this.rest.countArgs()... - int
*/
//Represents the list of cells
class ConsLoCell implements ILoCell {
    IData first;
    ILoCell rest;

    ConsLoCell(IData first, ILoCell rest) {
        this.first = first;
        this.rest = rest;
    }

    //appendList() will combine this list with that list
    public ILoCell appendList(ILoCell that) {
        if (this.rest.appendList(that) == new MtLoCell()) {
            return new ConsLoCell(this.first, that);
        }
        else {
            return this.rest.appendList(new ConsLoCell(this.first, that));
        }
    }
    
    //isInList(IData that) will check to see if that is in this list
    public boolean isInList(IData that) {
        return this.first.equals(that) || this.rest.isInList(that);
    }
    
    //reList() will remake the list without any duplicates
    public ILoCell reList() {
        if (this.rest.isInList(this.first)) {
            return this.rest.reList();
        }
        else {
            return new ConsLoCell(this.first, this.rest.reList());
        }
    }
    
    //countArgs() will count how many numbers there are in this list
    public int countArgs() {
        return 1 + this.rest.countArgs();
    }
}


//////////////////////////////////////////////////////////////////////////////
//IData
/* Template
Methods:
...this.value()... - int
...this.countArgs()... - int
...this.createList()... ILoCell
*/
//Represents the Data in the cell
interface IData {
    int value();
    int countArgs();
    ILoCell createList();
}


//////////////////////////////////////////////////////////////////////////////
//Number
/* Template
Fields:
...this.row... - int
...this.column... - String
...this.num... - int
Methods:
...this.value()... - int
...this.countArgs()... - int
...this.createList()... - ILoCell
Methods for Fields:
...this.num.value()... - int
...this.num.countArgs()... - int
...this.num.createList()... - ILoCell
*/
//Represents a cell in a row and column, that contains a number
class Number implements IData {
    int row;
    String column;
    int num;
    
    Number(int row, String column, int num) {
        this.row = row;
        this.column = column;
        this.num = num;
    }
    
    //value() will return this.num, since it is the value of the cell
    public int value() {
        return this.num;
    }
    
    //countArgs() will return 1, since this is a number
    public int countArgs() {
        return 1;
    }
    
    //createList() will create a list using this number
    public ILoCell createList() {
        return new ConsLoCell(this, new MtLoCell());
    }
}


//////////////////////////////////////////////////////////////////////////////
//AFormula
/* Template
Fields:
...this.row... - int
...this.column... - String
...this.cell1... - IData
...this.cell2... - IData
Methods:
...this.countArgs()... - int
...this.createList()... - ILoCell
Methods for Fields:
...this.cell1.createList()... - ILoCell
...this.cell2.createList()... - ILoCell
*/
//Represents a function cell with a row and column, containing two other cells
abstract class AFormula implements IData {
    int row;
    String column;
    IData cell1;
    IData cell2;
    
    AFormula(int row, String column, IData cell1, IData cell2) {
        this.row = row;
        this.column = column;
        this.cell1 = cell1;
        this.cell2 = cell2;
    }
    //createList() will create a list of all of the cells that contain numbers
    public ILoCell createList() {
        return this.cell1.createList().appendList(this.cell2.createList());
    }
    //countArgs() will count the number of cells that contain numbers
    public int countArgs() {
        return this.createList().reList().countArgs();
    }
}


//////////////////////////////////////////////////////////////////////////////
//Add
/* Template
Methods:
...this.value()... - int
Methods for Fields:
...this.cell1.value()... - int
...this.cell2.value()... - int
*/
//holds the class for the method to add two cells together
class Add extends AFormula {
    Add(int row, String column, IData cell1, IData cell2) {
        super(row, column, cell1, cell2);
    }
    
    //value() will add the two cells together
    public int value() {
        return this.cell1.value() + this.cell2.value();
    }
}


//////////////////////////////////////////////////////////////////////////////
//Min
/* Template
Methods:
...this.value()... - int
Methods for Fields:
...this.cell1.value()... - int
...this.cell2.value()... - int
 */
//holds the class for the method to take the minimum of two cells
class Min extends AFormula {
    Min(int row, String column, IData cell1, IData cell2) {
        super(row, column, cell1, cell2);
    }
    
    //value() will take the minimum of the two cells
    public int value() {
        return Math.min(this.cell1.value(), this.cell2.value());
    }
}


//////////////////////////////////////////////////////////////////////////////
//Multiply
/* Template
Methods:
...
*/
//holds the class for the method to multiply the two cells together
class Multiply extends AFormula {
    Multiply(int row, String column, IData cell1, IData cell2) {
        super(row, column, cell1, cell2);
    }
    
    //value() will multiply the value of the two cells together
    public int value() {
        return this.cell1.value() * this.cell2.value();
    }
}





//////////////////////////////////////////////////////////////////////////////

//Examples
class ExamplesCells {
    IData a1 = new Number(1, "A", 8);
    IData b1 = new Number(1, "B", 3);
    IData c1 = new Number(1, "C", 4);
    IData d1 = new Number(1, "D", 6);
    IData e1 = new Number(1, "E", 2);
    
    IData a2 = new Min(2, "A", b1, e1);
    IData b2 = new Add(2, "B", a1, c1);
    IData e2 = new Multiply(2, "E", b2, d1);
    
    IData a3 = new Multiply(3, "A", a1, a2);
    IData b3 = new Add(3, "B", b2, e1);
    IData e3 = new Min(3, "E", a3, d1);
    
    IData b4 = new Add(4, "B", b3, b2);
    IData e4 = new Min(4, "E", b4, e3);
    
    IData b5 = new Multiply(5, "B", b4, b3);
    IData e5 = new Add(5, "E", b5, e4);
    
    ILoCell mtlist = new MtLoCell();
    ILoCell list1 = new ConsLoCell(a1, mtlist);
    ILoCell list2 = new ConsLoCell(d1, list1);
    ILoCell list3 = new ConsLoCell(b4, mtlist);
    ILoCell list4 = new ConsLoCell(e5, list3);
    
    ILoCell list5 = new ConsLoCell(a1, new ConsLoCell(d1, list3));
    ILoCell list6 = new ConsLoCell(a1, list2);
    ILoCell list7 = new ConsLoCell(b1, new ConsLoCell(e1, mtlist));
    
    //value() tells the value of the cell
    boolean testValue(Tester t) {
        return t.checkExpect(this.a1.value(), 8) &&
               t.checkExpect(this.b2.value(), 12) &&
               t.checkExpect(this.e5.value(), 370);
    }
    
    //appendList() appends two lists of cells together
    boolean testAppendList(Tester t) {
        return t.checkExpect(this.list1.appendList(mtlist), list1) &&
                t.checkExpect(this.mtlist.appendList(mtlist), mtlist) &&
                t.checkExpect(this.list2.appendList(list3), list5);
    }
    
    //isInList() tells whether or not that is in this list
    boolean testIsInList(Tester t) {
        return t.checkExpect(this.list1.isInList(a1), true) &&
                t.checkExpect(this.list4.isInList(b4), true) &&
                t.checkExpect(this.mtlist.isInList(a1), false);
    }
    
    //reList() will remake a list without any duplicates
    boolean testReList(Tester t) {
        return t.checkExpect(this.mtlist.reList(), mtlist) &&
                t.checkExpect(this.list5.reList(), list5) &&
                t.checkExpect(this.list6.reList(), list2);
    }
    
    //createList() will create a list of cells
    boolean testCreateList(Tester t) {
        return t.checkExpect(this.a1.createList(), list1) &&
                t.checkExpect(this.a2.createList(), list7);
    }
    //countArgs() counts how many arguments (numbers) are used in calculating
    // each cells value
    boolean testCountArgs(Tester t) {
        return t.checkExpect(this.a1.countArgs(), 1) &&
                t.checkExpect(this.e2.countArgs(), 3) &&
                t.checkExpect(this.a2.countArgs(), 2);
    } 
}
