
//Problem 1

/*
 
 
 +--------------+ 
 | IPC          |<---------------------------------+
 +--------------+                                  |
 |              |----+------------------+          |
 +--------------+    |                  |          |
                     v                  v          |
              +--------------+  +---------------+  |
              |    Empty     |  |    Link       |  |
              +--------------+  +---------------+  |
              |              |  | Player  player|  |
              |              |  | IPC     right |--+
                                  IPC     left  |--+
              +--------------+  +---------------+
 */

interface IPC { }

//define class Empty
class Empty implements IPC {
    Empty() {  
    }
}

//define link
class Link implements IPC{
    Player pc;
    IPC left;
    IPC right;
    
    Link(Player pc, IPC left, IPC right) {
        this.pc = pc;
        this.left = left;
        this.right = right;
    }
}

//define class Player
class Player implements IPC {
    String name;
    int num;
    
    Player(String name, int num) {
    this.name = name;
    this.num = num;
    }
}

//EXAMPLES
class ExamplePC{
    Player jen = new Player("Jen", 1);
    Player may = new Player("May", 2);
    Player bea = new Player("Bea", 3);
    Player kim = new Player("Kim", 4);
    Player pat = new Player("Pat", 5);
    
    IPC empty = new Empty();
    
    IPC link3 = new Link(bea, empty, empty);
    IPC link4 = new Link(kim, empty, empty);
    IPC link5 = new Link(pat, empty, empty);
    IPC link2 = new Link(may, link4, link5);
    IPC link1 = new Link(jen, link2, link3);
}