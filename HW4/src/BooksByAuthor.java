// the function object that compares books by their author
public class BooksByAuthor implements IBookComparator {
    public boolean compare(Book b1, Book b2) {
        return (b1.author.compareTo(b2.author) <= 0);
    }
}
