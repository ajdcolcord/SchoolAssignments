// the function object that compares books by their title
public class BooksByTitle implements IBookComparator {
    public boolean compare(Book b1, Book b2) {
        return (b1.title.compareTo(b2.title) <= 0);
    }
}
