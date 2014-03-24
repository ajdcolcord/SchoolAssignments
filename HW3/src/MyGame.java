// assignment 3
// partner1-Colcord-Austin
// partner1-acolcord
// partner2-Su-Jun
// partner2-jacklyso


//import java.awt.Color;
import java.util.Random;

import tester.*;
import javalib.funworld.*;
import javalib.colors.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;

// this method is never used by my game:
// import java.awt.Color;

//////////////////////////////////////////////////////////////////////////////
//CLASS DIAGRAM
/*

               +-------+
               | World |
               +-------+
                   ^
                   |
      +-------------------------+
      |       FieldWorld        |-------+
      +-------------------------+       |
 +----| Player           player |       |
 | +--| Ball             ball   |       |
 | |  | int              score  |       |
 | |  +-------------------------+       |
 | |  | WorldImage   makeImage()|       |
 | |  | boolean     caughtBall()|       |
 | |  | FieldWorld      onTick()|       |
 | |  | FieldWorld  onKeyEvent()|       |
 | |  | WorldEnd     worldEnds()|       |
 | |  +-------------------------+       |      +-------------------+
 | |                                    +----->|    FWConstants    |
 | |                                    |      +-------------------+
 | |                                    |
 | |  +---------------------------+     |
 | +->|           Ball            |-----+
 |    +---------------------------+     |
 |    | Posn                 posn |     |
 |    +---------------------------+     |
 |    | WorldImage    ballImage() |     |
 |    | Ball           moveDown() |     |
 |    | boolean     reachedGoal() |     |
 |    | Ball           moveBall() |     |
 |    +---------------------------+     |
 |                                      |
 |    +---------------------------+     |
 +--->|         Player            |-----+
      +---------------------------+
      | Posn                 posn |
      +---------------------------+
      | WorldImage  playerImage() |
      | Player       onKeyEvent() |
      +---------------------------+


*/


//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
//FIELDWORLD CONSTANTS
//represents all of the constants in the game
interface FWConstants {

    // width of the field
    public int width = 300;

    // height of the field
    public int height = 500;

    // color of the field
    public IColor fieldColor = new Green();

    // random number generator
    public Random rand = new Random();

    // background image of the field
    public WorldImage field = 
            new RectangleImage(
                    new Posn(width / 2, height / 2), width, height, fieldColor);
    
}

//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////




//////////////////////////////////////////////////////////////////////////////
//BALL
/* Template
Fields:
...this.posn... - Posn
Methods:
...this.ballImage()...   - WorldImage
...this.moveDown()...    - Ball
...this.reachedGoal()... - boolean
...this.moveBall()...    - Ball
*/
// represents the ball that will be caught by the player
class Ball implements FWConstants {
    Posn posn;
    
    Ball(Posn posn) {
        this.posn = posn;
    }
    
    /////////////////////////////////////////////////////////////////
    //BALL METHODS
    
    // produce the image for the ball
    public WorldImage ballImage() {
        return new DiskImage(this.posn, 5, new White());
    }
    
    // moveDown will move the ball down the screen
    public Ball moveDown() {
        return new Ball(new Posn(this.posn.x, this.posn.y + 5));
    }
   
    // reachedGoal will tell if the ball has reached the goal
    //  (the bottom of the screen)
    public boolean reachedGoal() {
        return this.posn.y >= FWConstants.height;
    }

    // moveBall will move the ball down the screen, unless it has
    // reached the goal, which will then start a new ball at the top
    public Ball moveBall() {
        if (this.reachedGoal()) {
            return new Ball(
                    new Posn(
                            new Random().nextInt(
                                    FWConstants.width - 20) + 20, -10));
        }
        else {
            return this.moveDown();
        }
    }
    
    /////////////////////////////////////////////////////////////////
}



//////////////////////////////////////////////////////////////////////////////
//Player
/* Template
Fields:
...this.posn... - Posn
Methods:
...this.playerImage()...         - WorldImage
...this.onKeyEvent(String ke)... - Player
*/
// represents the player that is controlled that will catch the balls
class Player {
    Posn posn;
    
    Player(Posn posn) {
        this.posn = posn;
    }
    

    /////////////////////////////////////////////////////////////////
    //PLAYER METHODS

    // produce the image for the player
    public WorldImage playerImage() {
        return new RectangleImage(this.posn, 30, 15, new Black());
    }

    // move the player on the key event (left or right)
    public Player onKeyEvent(String ke) {
        if (ke.equals("left")) {
            if (this.posn.x >= 15) {
                return new Player(
                        new Posn((this.posn.x - 10), this.posn.y));
            }
            else {
                return this;
            }
        }
        else if (ke.equals("right")) {
            if (this.posn.x <= (FWConstants.width - 15)) {
                return new Player(
                        new Posn((this.posn.x + 10), this.posn.y));
            }
            else {
                return this;
            }
        }
        else {
            return this;
        }
    }
}


//////////////////////////////////////////////////////////////////////////////
//FIELDWORLD
/* Template
Fields:
...this.player... - Player
...this.ball...   - Ball
...this.score... - int
Methods:
...this.makeImage()...           - WorldImage
...this.caughtBall()...          - boolean 
...this.onTick()...              - FieldWorld
...this.onKeyEvent(String ke)... - FieldWorld
...this.worldEnds()...           - WorldEnd
Methods for Fields:
...this.ball.ballImage()...      - WorldImage
...this.player.playerImage()...  - WorldImage
...this.ball.moveBall()...       - Ball
...this.player.onKeyEvent(ke)... - Player
*/
// represents the world that holds all of the players and balls
class FieldWorld extends World implements FWConstants {
    Player player;
    Ball ball;
    int score;
    
    FieldWorld(Player player, Ball ball, int score) {
        this.player = player;
        this.ball = ball;
        this.score = score;
    }
    
    /////////////////////////////////////////////////////////////////
    //FIELDWORLD METHODS
    
    // produce the images for the world
    public WorldImage makeImage() {
        return new OverlayImages(FWConstants.field, 
                new OverlayImages(this.ball.ballImage(), 
                        this.player.playerImage()));
    }   

    // caughtBall will tell if this ball has been caught by a player
    public boolean caughtBall() {
        return (((player.posn.x - 15) <= ball.posn.x) && 
                (ball.posn.x <= (player.posn.x + 15))) &&
                ((player.posn.y - 12.5) <= ball.posn.y) &&
                ((player.posn.y + 7.5) >= ball.posn.y);
    }
    
    // onTick will move the ball down every tick, and if
    // the ball is caught by the player, the score will increase by
    // 1 point, and a new ball will be set at the top again
    public FieldWorld onTick() {
        if (this.caughtBall()) {
            return new FieldWorld(
                    this.player, 
                    new Ball(new Posn(
                            new Random().nextInt(
                                    FWConstants.width - 20)
                                    + 20, -10)), this.score + 1);
        }
        else {
            return new FieldWorld(
                    this.player, this.ball.moveBall(), this.score);
        }
    }
    
    // onKeyEvent allows the player to move the player on the ground
    public FieldWorld onKeyEvent(String ke) {
        return new FieldWorld(
                this.player.onKeyEvent(ke), this.ball, this.score);
    }
    
    // produce the worldend 
    public WorldEnd worldEnds() {
        if (this.score >= 10) {
            return new WorldEnd(true, 
                    new TextImage(
                            new Posn(FWConstants.width / 2, 
                                    FWConstants.height / 2), 
                                    "Game Over!!!", 30, 3, new Red()));
        }
        else {
            return new WorldEnd(false, this.makeImage()); 
        }
    }

}


//////////////////////////////////////////////////////////////////////////////
//EXAMPLESFIELDS
// represents examples for the fields that contain the game
class ExamplesFields implements FWConstants {
    Player p1 = new Player(new Posn(150, 450));
    Player p2 = new Player(new Posn(20, 10));
    Player p3 = new Player(new Posn(5, 100));
    Player p4 = new Player(new Posn(295, 100));
    
    Ball b1 = new Ball(new Posn(20, 20));
    Ball b2 = new Ball(new Posn(50, 500));
    Ball b3 = new Ball(new Posn(150, 100));
    Ball b4 = new Ball(new Posn(20, 10));
    Ball b5 = new Ball(new Posn(20, 11));
    Ball b6 = new Ball(new Posn(20, 18));
    Ball b7 = new Ball(new Posn(40, 510));
    
    FieldWorld f1 = new FieldWorld(this.p1, this.b1, 0);
    FieldWorld f2 = new FieldWorld(this.p2, this.b3, 0);
    FieldWorld f3 = new FieldWorld(this.p2, this.b4, 0);
    FieldWorld f4 = new FieldWorld(this.p1, this.b2, 0);
    FieldWorld f5 = new FieldWorld(this.p1, this.b1, 10);
    FieldWorld f6 = new FieldWorld(this.p1, this.b1, 11);
    FieldWorld f7 = new FieldWorld(this.p1, this.b7, 0);
    
    
    /////////////////////////////////////////////////////////////////
    //METHODS EXAMPLES

    // ballImage test
    boolean testBallImage(Tester t) {
        return t.checkExpect(this.b1.ballImage(),
                new DiskImage(this.b1.posn, 5, new White()));
    }

    // playerImage test
    boolean testPlayerImage(Tester t) {
        return t.checkExpect(this.p1.playerImage(),
                new RectangleImage(this.p1.posn, 30, 15, new Black()));
    }

    // makeImage test
    boolean testMakeImage(Tester t) {
        return t.checkExpect(this.f1.makeImage(), 
                new OverlayImages(FWConstants.field,
                        new OverlayImages(this.b1.ballImage(),
                                this.p1.playerImage())));
    }

    // moveDown test
    boolean testMoveDown(Tester t) {
        return  t.checkExpect(this.b1.moveDown(), new Ball(new Posn(20, 25))) &&
                t.checkExpect(this.b2.moveDown(), new Ball(new Posn(50, 505)));
    }
    
    // onKeyEvent test
    boolean testOnKeyEvent(Tester t) {
        return t.checkExpect(this.p1.onKeyEvent("left"),
                new Player(new Posn(140, 450))) &&
               t.checkExpect(this.p1.onKeyEvent("right"),
                new Player(new Posn(160, 450))) &&
               t.checkExpect(this.p3.onKeyEvent("left"), this.p3) &&
               t.checkExpect(this.p4.onKeyEvent("right"), this.p4) &&
               t.checkExpect(this.p3.onKeyEvent("up"), this.p3) &&
               t.checkExpect(this.f1.onKeyEvent("up"), this.f1) &&
               t.checkExpect(this.f1.onKeyEvent("left"),
                       new FieldWorld(
                               new Player(new Posn(140, 450)),
                               this.b1, 0));
    }
    
    // reachedGoal test
    boolean testReachedGoal(Tester t) {
        return  t.checkExpect(this.b1.reachedGoal(), false) &&
                t.checkExpect(this.b2.reachedGoal(), true) &&
                t.checkExpect(this.b7.reachedGoal(), true);
    }
    
    // moveBall test
    boolean testMoveBall(Tester t) {
        return  t.checkExpect(this.b1.moveBall(), 
                new Ball(new Posn(20, 25))) &&
                t.checkRange(this.b7.moveBall().posn.x, 0, 500) &&
                t.checkExpect(this.b7.moveBall().posn.y, -10);
        ////////////TEST FOR RANDOM POSN X////////////////
                
    }
    
    // caughtBall test
    boolean testCaughtBall(Tester t) {
        return  t.checkExpect(this.f3.caughtBall(), true) &&
                t.checkExpect(this.f1.caughtBall(), false) &&
                t.checkExpect(this.f2.caughtBall(), false) &&
                t.checkExpect(this.f4.caughtBall(), false);
    }
   
    //onTick test
    boolean testOnTick(Tester t) {
        return t.checkExpect(this.f1.onTick(),
                new FieldWorld(this.f1.player,
                        new Ball(new Posn(this.f1.ball.posn.x, 25)),
                        0)) &&
               t.checkRange(this.f7.onTick().ball.posn.x, 0, 500) &&
               t.checkExpect(this.f7.onTick().ball.posn.y, -10) &&
               t.checkExpect(this.f7.onTick().player, this.f7.player);
    }

    // worldEnds test
    boolean testWorldEnds(Tester t) {
        return t.checkExpect(this.f5.worldEnds(), 
                new WorldEnd(
                        true, new TextImage(
                                new Posn(
                                        FWConstants.width / 2, 
                                        FWConstants.height / 2), 
                                        "Game Over!!!", 30, 3, new Red()))) &&
               t.checkExpect(this.f1.worldEnds(),
                       new WorldEnd(false, this.f1.makeImage())) &&
               t.checkExpect(this.f6.worldEnds(),
                new WorldEnd(
                        true, new TextImage(
                                new Posn(
                                        FWConstants.width / 2, 
                                        FWConstants.height / 2), 
                                        "Game Over!!!", 30, 3, new Red())));

    }

    
    /////////////////////////////////////////////////////////////////
    //RUN ANIMATION
    boolean runAnimation = this.f1.bigBang(300, 500, 0.03);
}