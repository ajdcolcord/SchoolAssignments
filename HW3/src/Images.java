// assignment 3
// partner1-Colcord-Austin
// partner1-acolcord
// partner2-Su-Jun
// partner2-jacklyso



// CS 2510 Fall 2013
// Assignment 3

import tester.*;

/* Class Diagram

                       +-------------------------+
                       |       AFile             |
                       +-------------------------+
                       | String      name        |
                       | String      owner       |
                       +-------------------------+
                       | int      downloadTime() |
                       | String      thisOwner() |
                       | boolean     sameOwner() |
                       +-------------------------+
                                   |
                                   |
        +--------------------------+-------------------------+
        v                          v                         v
 +--------------+         +-----------------+        +--------------+
 |  TextFile    |         |    ImageFile    |        |  AudioFile   |
 +--------------+         +-----------------+        +--------------+
 | int   length |         | int     width   |        | int    speed |
 +--------------+         | int     height  |        | int   length |
 | int   size() |         +-----------------+        +--------------+
 +--------------+         | int      size() |        | int   size() |
                          +-----------------+        +--------------+
 
*/



//////////////////////////////////////////////////////////////////////////////
//AFILE
/* Template
Fields:
...this.name...  - String
...this.owner... - String
Methods:
...this.size()...         - int
...this.downloadTime()... - int
...this.thisOwner()...    - String
...this.sameOwner()...    - boolean
 */
// to represent different files in a computer
abstract class AFile {
    String name;
    String owner;
    
    AFile(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    // size() computes the size of this file
    abstract int size();

    // downloadTime() computes the time (in seconds) 
    // to download this file at the given download rate
    int downloadTime(int rate) {
        return this.size() / rate;
    }

    // thisOwner() returns the owner of the IFile
    String thisOwner() {
        return this.owner;
    }

    // sameOwner() tells if the owner of this 
    // file the same as the owner of the given file?
    boolean sameOwner(AFile that) {
        return (this.owner.equals(that.thisOwner()));
    }
}

//////////////////////////////////////////////////////////////////////////////
//TEXTFILE
/* Template
Fields:
...this.length... - int
Methods:
...this.size()... - int
 */
// to represent a text file
class TextFile extends AFile {
    int length;   // in bytes

    TextFile(String name, String owner, int length) {
        super(name, owner);
        this.length = length;
    }

    // compute the size of this file
    public int size() {
        return this.length;
    }  
}


//////////////////////////////////////////////////////////////////////////////
//IMAGEFILE
/* Template
Fields:
...this.width...  - int
...this.height... - int
Methods:
...this.size()... - int
 */
//to represent an image file
class ImageFile extends AFile {
    int width;   // in pixels
    int height;  // in pixels

    ImageFile(String name, String owner, int width, int height) {
        super(name, owner);
        this.width = width;
        this.height = height;
    }

    // compute the size of this file
    public int size() {
        return this.width * this.height;
    }
}


//////////////////////////////////////////////////////////////////////////////
//AUDIOFILE
/* Template
Fields:
...this.speed...  - int
...this.length... - int
Methods:
...this.size()... - int
 */
//to represent an audio file
class AudioFile extends AFile {
    int speed;   // in bytes per second
    int length;  // in seconds of recording time

    AudioFile(String name, String owner, int speed, int length) {
        super(name, owner);
        this.speed = speed;
        this.length = length;
    }

    // compute the size of this file
    public int size() {
        return this.speed * this.length;
    }  
}


//////////////////////////////////////////////////////////////////////////////
//EXAMPLESFILES
class ExamplesFiles {

    AFile text1 = new TextFile("English paper", "Maria", 1234);
    AFile picture = new ImageFile("Beach", "Maria", 400, 200);
    AFile song = new AudioFile("Help", "Pat", 200, 120);
    
    AFile text2 = new TextFile("Homework 3", "Billy", 1555);
    AFile picture2 = new ImageFile("Ocean", "Robert", 1000, 800);
    AFile song2 = new AudioFile("Working", "Mark", 400, 100);

    // test the method size for the classes that represent files
    boolean testSize(Tester t) {
        return  t.checkExpect(this.text1.size(), 1234) &&
                t.checkExpect(this.picture.size(), 80000) &&
                t.checkExpect(this.song.size(), 24000) &&
                
                t.checkExpect(this.text2.size(), 1555) &&
                t.checkExpect(this.picture2.size(), 800000) &&
                t.checkExpect(this.song2.size(), 40000);
    }
    
    //test downloadTime
    boolean testDownloadTime(Tester t) {
        return t.checkExpect(this.text1.downloadTime(10), 123) &&
                t.checkExpect(this.picture.downloadTime(10), 8000) &&
                t.checkExpect(this.song.downloadTime(10), 2400);
    }
    
    //test thisOwner()
    boolean testThisOwner(Tester t) {
        return t.checkExpect(this.text2.thisOwner(), "Billy") &&
                t.checkExpect(this.picture2.thisOwner(), "Robert") &&
                t.checkExpect(this.song2.thisOwner(), "Mark");
    }
    
    //test sameOwner()
    boolean testSameOwner(Tester t) {
        return t.checkExpect(this.text1.sameOwner(this.picture), true) &&
                t.checkExpect(this.picture2.sameOwner(this.song2), false) &&
                t.checkExpect(this.song.sameOwner(this.song2), false);
    } 
}