// function object that compares books by their price
public class BooksByPrice implements IBookComparator {
    public boolean compare(Book b1, Book b2) {
        return (b1.price <= b2.price);
    }
}
