import java.util.*;

/** A visitor for the ILo<T> classes that 
 *  and produces the result of the type R
 *
 * @param <R>
 * @param <T>
 */
interface ILoVisitor<R, T> {
    
    /** method for the empty list */
    public R forMt(); 

    /** method for the nonempty list
     * 
     * @param first the first of the list
     * @param rest the rest of the list
     * @return R the item produced for the method that will be passed
     *            into this method
     */
    public R forCons(T first, ILo<T> rest);
}

/** A visitor that computes the total download time for all files 
 * in the list of image files 
 */
class ILoImageDownloadTimeVisitor implements ILoVisitor<Integer, Image> {
    int speed;
    
    ILoImageDownloadTimeVisitor(int speed) {
        this.speed = speed;
    }

    /** method for the empty list */
    public Integer forMt() {
        return 0;
    }

    /** method for the nonempty list 
     * 
     * @param first the image given
     * @param rest the rest of the list of images given
     * @return Integer the number that is given 
     * */
    public Integer forCons(Image first, ILo<Image> rest) {
        return first.fileSize / speed + rest.accept(this);
    }
}

/** A visitor that produces an ArrayList<String> of all the titles of
 * songs in the list of songs 
 */
class ILoSongTitlesVisitor implements ILoVisitor<ArrayList<String>, Song> {
    ILoSongTitlesVisitor() {
    }

    /** method for the empty list 
     * 
     * @return ArrayList<String> the list that is empty, since this is empty
     */
    public ArrayList<String> forMt() {
        return new ArrayList<String>();
    }

    /** method for nonempty list
     * 
     * @param first the song given
     * @param rest the rest of the list given
     * @return ArrayList<String> the list given out by the visitor
     */
    public ArrayList<String> forCons(Song first, ILo<Song> rest) {
        ArrayList<String> newTitleList = new ArrayList<String>();
        newTitleList.add(first.title);
        newTitleList.addAll(rest.accept(this));
        return newTitleList;
    }
}

/** A visitor that produces a string that contains the titles of all
   books in the list, separating titles with "\n" */
class ILoBookTitlesVisitor implements ILoVisitor<String, Book> {
    ILoBookTitlesVisitor() { }

    /** method for the empty list 
     * 
     * @return String for the method for an empty list
     * */
    public String forMt() {
        return "";
    }

    /** method for nonempty list 
     * 
     * @param first the first book in the list
     * @param rest the rest of the books in the list
     * @return String for the method for a non-empty list
     * */
    public String forCons(Book first, ILo<Book> rest) {
        if (rest.size() == 0) {
            return first.title + ".";
        }
        else {  
            return first.title + "\n" + rest.accept(this);
        }
    }
}