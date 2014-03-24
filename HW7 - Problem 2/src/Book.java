
/** Represents a Book */
public class Book {
    String title;
    String author;
    int price;     // in dollars
    
    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    /** Template
     *   Fields
     *     ... this.title ...       -- String
     *     ... this.author ...      -- String
     *     ... this.price ...       -- int
     *
     *   Methods 
     *     ... this.value() ...       -- int
     *     ... this.makeString() ...  -- String
     *     ... authorName() ...       -- String
     */
    
    /** Compute the value of this Book, i.e., its price
     * 
     * @return int as this price
     */
    public int value() {
        return this.price;
    }
}