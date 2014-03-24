import tester.*;

class Room {
    String color;

    Room(String color) {
        this.color = color;
    }
    
    //change the color of a room
    void changeColor(String c) {
        this.color = c;
    }
}

class ExamplesRoom {
    Room r1;
    Room r2;
    
    void reset() {
        r1 = new Room("green");
        r2 = new Room("red");
    }
    
    //test changeColor
    void testChangeColor(Tester t) {
        reset();
        this.r1.changeColor("blue");
        t.checkExpect(this.r1.color == "blue");
        this.r2.changeColor("black");
        t.checkExpect(this.r2.color == "black");
        reset();
        t.checkExpect(this.r1.color == "green");
        t.checkExpect(this.r2.color == "red");
        
    }
}