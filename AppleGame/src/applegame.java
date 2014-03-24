import java.awt.Color;
import java.util.Random;

import tester.*;

import javalib.funworld.*;
import javalib.colors.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;


//APPLEGAME
class AppleGame extends World { 
    int width = 400;
    int height = 400;
    
    public WorldImage tree = new OverlayImages(new RectangleImage (new Posn(200, 200)) this.width, this.height, new Black())
    //
}

//////////////////////////////////////////////////////////////////////////////
//APPLE
class Apple {
    Posn posn;
    int speed;
    
    Apple(Posn posn, int speed) {
        this.posn = posn;
        this.speed = speed;
    }
    
    //makeImage() sets the image for the apple
    public WorldImage makeImage() {
        return new FromFileImage(this.posn, "red-apple.png");
    }
}

//Basket
class Basket {
    Posn posn;
    
    Basket(Posn posn) {
        this.posn = posn;
    }
    
    //makeImage() sets the image for the basket
    public WorldImage makeImage() {
        return new RectangleImage(this.posn, 60, 30, Color.lightGray);
    }
}

//