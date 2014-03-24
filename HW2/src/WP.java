
import tester.*;
// assignment 1
// partner1-Colcord-Austin
// partner1-acolcord
// partner2-Su-Jun
// partner2-jacklyso

//////////////////////////////////////////////////////////////////////////////
//CLASS DIAGRAM
/*
                    +----------------------+
                    |          WP          |<-------------------+
                    +----------------------+                    |
                    | String      url      |                    |
                    | String      title    |                    |
                 +--| IloI        itmes    |<---------+         |
                 |  +----------------------+          |         |
                 |  | int      textlength()|          |         |
                 |  | int  totalImageSize()|          |         |
                 |  | String       images()|          |         |
                    | boolean     isimage()|          |         |
                 |  +----------------------+          |         |
                 |                                    |         |
                 v                                    |         |
           +---------------------+                    |         |
           |      ILOItem        |                    |         |
           +---------------------+                    |         |
           +---------------------+                    |         |
           |int  totalImageSize()|                    |         |
           |int      textLength()|                    |         |
           |String       images()|                    |         |
           |boolean  isMtLoItem()|                    |         |
           |boolean     isimage()|                    |         |
           +---------------------+                    |         |
                 |                                    |         |
                 +------------------+                 |         |
                 v                  v                 |         |
  +---------------------+    +---------------------+  |         |
  |      ConsLoI        |    |       MtLoI         |  |         |
  +---------------------+    +---------------------+  |         |
+-| Item    item        |    +---------------------+  |         |
| | IloI    iloi        |-+  | int     textlength()|  |         |
| +---------------------+ |  | int totalImageSize()|  |         |
| | int  textlength()   | |  | String      images()|  |         |
| | int totalImageSize()| |  | boolean    isimage()|  |         |
| | String   images()   | |  | boolean isMtLoItem()|  |         |
| | boolean isimage()   | |  +---------------------+  |         |
| | boolean isMtLoItem()| |                           |         |
| +---------------------+ |                           |         |
|                         +---------------------------+         |
+------------+                                                  |
             |                                                  |
             v                                                  |
  +-----------------------+                                     |
  |        Item           |                                     |
  +-----------------------+                                     |
  |-----------------------+                                     |
  |int    totalImageSize()|                                     |
  |int        textLength()|                                     |
  |String         images()|                                     |
  |boolean       isimage()|                                     |
  +-----------------------|                                     |
             |                                                  |
             |                                                  |
          +-+------------------+--------------------+            |
          v                    v                    v             |
+---------------------+ +------------------+ +------------------+ |
|       text          | |      image       | |       link       | |
+---------------------+ +------------------+ +------------------+ |
| String  contents    | | String  filename | | string  name     | |
+---------------------+ | int     size     | | WP      page     |-+
| int  textlength()   | | String  filetype | +------------------+
| int totalImageSize()| +------------------+ | int  textlength()|
| String   images()   | | int  textlength()| | int   imageSize()|
| boolean isimage()   | | int   imageSize()| | String   images()|
+---------------------+ | String   images()| | boolean isimage()|
                        | boolean isimage()| +------------------+
                        +------------------+
 */
//////////////////////////////////////////////////////////////////////////////
//WEBPAGE
//represent the definition for Web, which contains
// a url, title, and a list of items
/*
TEMPLATE
Fields:
... this.url...     - String
... this.title...   - String
... this.items...   - ILoItem

Methods:
...this.totalImageSize()...   - int
...this.textLength()...       - int
...this.images()...           - String
...this.isimage()...          - boolean
Methods for Fields
...this.items.totalImageSize()... - ILoItem
...this.items.textLength()...     - ILoItem
...this.items.images()...         - ILoItem
 */


class WP {
    String url;
    String title;
    ILoItem items;
    
    WP(String url, String title, ILoItem items) {
        this.url = url;
        this.title = title;
        this.items = items;
    }
    //textLength() computes the total length of all text
    // in this WP
    int textLength() {
        return  this.title.length() +
                this.items.textLength();
    }
    //totalImageSize() computes total size of all images
    //in this WP
    int totalImageSize() {
        return this.items.totalImageSize();
    }
    //images() makes a string of all of the names of all
    // of the images in the WP
    String images() {
        return this.items.images();
    }
    //isimage() tells if there are images in the WP
    boolean isimage() {
        return this.items.isimage();
    }
}


//////////////////////////////////////////////////////////////////////////////
//ITEM
interface Item { 
    int totalImageSize();
    int textLength();
    String images();
    boolean isimage();
}

//////////////////////////////////////////////////////////////////////////////
//TEXT
/*
TEMPLATE
Fields:
... this.contents... - String
Methods:
...this.totalimageSize()...        - int
...this.textLength()...       - int
...this.images()...           - String
...this.isimage()...          - boolean
Methods for Fields
...this.contents.length()...     - Text
 */

//definition for Text, which contains its contents
class Text implements Item {
    String contents;
    
    Text(String contents) {
        this.contents = contents;
    }
  //totalImageSize() finds the total image size of the ILoItem
    public int totalImageSize() {
        return 0;
    }
    //textLength() finds the total length of the contents
    public int textLength() {
        return this.contents.length();
    }
    //images() finds the filename of the image
    public String images() {
        return "";
    }
    //isimage() tells that this is not an image
    public boolean isimage() {
        return false;
    }
}


//////////////////////////////////////////////////////////////////////////////
//IMAGE CLASS
/*
TEMPLATE
Fields:
... this.filename...   - String
... this.size...       - int
... this.filetype...   - String

Methods:
...this.totalImageSize()...   - int
...this.textLength()...  - int
...this.images()...      - String
...this.isimage()...     - boolean

Methods for Fields
...this.filename.length()...    - Image
...this.filetype.length()...    - Image
 */
//definition for Image, which contains a file-name,
// size, and file-type
class Image implements Item {
    String filename;
    int size;
    String filetype;
    
    Image(String filename, int size, String filetype) {
        this.filename = filename;
        this.size = size;
        this.filetype = filetype;
    }
    //totalImageSize() finds the total image size of the ILoItem
    public int totalImageSize() {
        return this.size;
    }
    //textLength() finds the total length 
    // of the filename and filetype
    public int textLength() {
        return this.filename.length() + this.filetype.length();
    }
    //images() finds the filename of the image
    public String images() {
        return this.filename + "." + this.filetype;
    }
  //isimage() tells that this is an image
    public boolean isimage() {
        return true;
    }
}


//////////////////////////////////////////////////////////////////////////////
//LINK CLASS
/*
Template Link
Fields:
... this.name...       - String
... this.page...       - WP

Methods:
...this.totalImageSize()...   - int
...this.textLength()...  - int
...this.images()...      - String
...this.isimage()...     - boolean

Methods for Fields
...this.page.totalImageSize()...  - WP
...this.page.images()...          - WP
...this.name.length()...          - String
 */

//definition for Link, which contains its name, and
// a WP that it directs to
class Link implements Item {
    String name;
    WP page;
    
    Link(String name, WP page) {
        this.name = name;
        this.page = page;
    }
    //totalImageSize() finds the total image size of the ILoItem
    public int totalImageSize() {
        return this.page.totalImageSize();
    }
    //textLength() finds the total length of the web page name
    public int textLength() {
        return this.name.length() + this.page.textLength();
    }
    //images() produces one String that contains names of all images
    // in contained in the page
    public String images() {
        return this.page.images();
    }
  //isimage() tells that this is not an image
    public boolean isimage() {
        return false;
    }
}


//////////////////////////////////////////////////////////////////////////////
//ILOITEM

interface ILoItem { 
    int totalImageSize();
    int textLength();
    String images();
    boolean isMtLoItem();
    boolean isimage();
}


//////////////////////////////////////////////////////////////////////////////
//MTLOITEM
/*
Template Image
Methods:
...this.totalImageSize()...   - int
...this.textLength()...  - int
...this.images()...      - String
...this.isMtLoItem()...  - boolean
...this.isimage()...     - boolean
 */
//define empty List of Items
class MtLoItem implements ILoItem {
    MtLoItem( ) {
        //since this is an empty list, there is no fields or constructor
    }
    //since there are no Items in an MtLoItem,
    // the size is 0
    public int totalImageSize() {
        return 0;
    }
    //since there are no Items in an MtLoItem, 
    // the size is 0
    public int textLength() {
        return 0;
    }
    //since there are no Items in an MtLoItem,
    // there is an empty string for images
    public String images() {
        return "";
    }
    //isMtLoItem() says that the rest of the list is empty
    public boolean isMtLoItem() {
        return true;
    }
    //isimage() tells that there are no images in this empty list
    public boolean isimage() {
        return false;
    }
}


//////////////////////////////////////////////////////////////////////////////
//CONSLOITEM
/*
Template Image
Fields:
... this.item...   - Item
... this.iloi...   - ILoItem

Methods:
...this.totalImageSize()...   - int
...this.textLength()...  - int
...this.isMtLoItem()...  - boolean
...this.images()...      - String
...this.isimage()...     - boolean

Methods for Fields
...this.item.textlength()...  - Image
...this.item.totalImageSize()...   - Image
...this.iloi.textlength()...  - ILoItem
...this.iloi.totalImageSize()...   - ILoItem
...this.item.isMtLoItem()...  - ILoItem
 */
class ConsLoItem implements ILoItem {
    Item item;
    ILoItem iloi;
    
    ConsLoItem(Item item, ILoItem iloi) {
        this.item = item;
        this.iloi = iloi;
    }
    //totalImageSize() finds the total image size of the ILoItem
    public int totalImageSize() {
        return this.item.totalImageSize() + this.iloi.totalImageSize();
    }
    //textLength() finds the total length of all of the strings in
    // every item
    public int textLength() {
        return this.item.textLength() + this.iloi.textLength();
    }
    //images() creates a String out of the names of the images
    // in the ILoItem
    public String images() {
        if (this.iloi.isMtLoItem()) {
            return this.item.images();
        } 
        else if (!(this.item.isimage())) { 
            return this.iloi.images();
        }
        else {
            return this.item.images() + ", " + this.iloi.images();
        }
    }
    //isMtLoItem() tells if the rest of the list is empty
    public boolean isMtLoItem() {
        return false;
    }
    //isimage() tells if there are images in this list or not
    public boolean isimage() {
        return this.item.isimage() || this.iloi.isimage();
    }
}

//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
//EXAMPLES
class ExamplesWP {
    
    
    Item kevin = new Image("kevin", 400, "png");
    Item annie = new Image("annie", 230, "jpeg");
    Item jackie = new Image("jackie", 300, "png");
    
    Item text1 = new Text("This is Kevin");
    Item text2 = new Text("This is Annie");
    Item text3 = new Text("My friend Jackie");
    
  
    
    ILoItem listf = new ConsLoItem(jackie, new MtLoItem());
    ILoItem listg = new ConsLoItem(text3, listf);
    
    
    WP bobsfriends = new WP("bob-friends.org", "Bob's Friends", listg);
    
    Item link1 = new Link("Here are Bob's friends", bobsfriends);
    
    ILoItem lista = new ConsLoItem(link1, new MtLoItem());
    ILoItem listb = new ConsLoItem(kevin, lista);
    ILoItem listc = new ConsLoItem(text1, listb);
    ILoItem listd = new ConsLoItem(annie, listc);
    ILoItem liste = new ConsLoItem(text2, listd);
    ILoItem listempty = new MtLoItem();
    
    WP myWP = new WP("myfriends.org", "My Friends", liste);
    WP emptyWP = new WP("", "", listempty);
    
    
    //Tests for totalImageSize()
    boolean testTotalImageSize(Tester t) {
        return  t.checkExpect(this.bobsfriends.totalImageSize(), 300) &&
                t.checkExpect(this.emptyWP.totalImageSize(), 0) && 
                t.checkExpect(this.myWP.totalImageSize(), 930);
    }
    
    //Tests for textLength()
    boolean testTextLength(Tester t) {
        return  t.checkExpect(this.kevin.textLength(), 8) &&
                t.checkExpect(this.bobsfriends.textLength(), 38) &&
                t.checkExpect(this.listempty.textLength(), 0) &&
                t.checkExpect(this.link1.textLength(), 60) &&
                t.checkExpect(this.myWP.textLength(), 113) &&
                t.checkExpect(this.text1.textLength(), 13);
        
    }
    //Tests for images()
    boolean testImages(Tester t) {
        return  t.checkExpect(this.bobsfriends.images(), "jackie.png") &&
                t.checkExpect(this.listempty.images(), "") &&
                t.checkExpect(this.link1.images(), "jackie.png") &&
                t.checkExpect(this.myWP.images(),
                        "annie.jpeg, kevin.png, jackie.png") &&
                t.checkExpect(this.text1.images(), "");
    }
    
    //Tests for isimage()
    boolean testIsimage(Tester t) {
        return  t.checkExpect(this.jackie.isimage(), true) &&
                t.checkExpect(this.text1.isimage(), false) &&
                t.checkExpect(this.myWP.isimage(), true) &&
                t.checkExpect(this.link1.isimage(), false) &&
                t.checkExpect(this.liste.isimage(), true) &&
                t.checkExpect(this.lista.isimage(), false) &&
                t.checkExpect(this.listempty.isimage(), false);
    }
}
