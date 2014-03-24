/* Template
Fields:
...this.title...  - String
...this.author... - String
...this.price...  - int
Methods:
...this.sameBook...        - boolean
 */
// represents the class Book that contains a title, author, and price

public class Book {
    String title;
    String author;
    int price;
    
    Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    

    //////////////////////////////////////////////////////////////////////////
    //BOOK METHODS

    // is this book same as the given book?
    public boolean sameBook(Book that) {
        return (this.title.equals(that.title)) &&
                (this.author.equals(that.author)) &&
                (this.price == that.price);
    }


}
