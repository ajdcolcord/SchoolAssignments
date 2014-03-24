/** the interface ISelect<T> that is used to select the T */
interface ISelect<T> {
    
    /** a predicate that determines the properties of the given item 
     * 
     * @return boolean
     * */
    public boolean select(T t);
}

/** select only the books that are cheaper than the given limit */
class CheapBook implements ISelect<Book> {
    int limit;

    CheapBook(int limit) {
        this.limit = limit;
    }
    
    /** Template
     * Fields:
     * ... this.limit ... - int
     * Methods:
     * ... this.select()... - boolean
     */

    /** the method that selects the book from this
     * 
     * @param b the book used to select
     * @return boolean if the book's price is less than this limit
     */
    public boolean select(Book b) {
        return b.price < this.limit;
    }
}
