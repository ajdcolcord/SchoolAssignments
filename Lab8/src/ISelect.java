
/**
 * Represents a predicate for the chosen data type
 * @author Viera K. Proulx
 */
interface ISelect<T>{
    /**
     * a predicate that determines whether the given item
     * has the desired property 
     * @param t the given item
     * @return true if the given item has the desired property 
     */
    public boolean select(T t);
}