
/** An interface for classes that can compute their value */
interface IValue {
    
    /** Compute the value of this instance 
     * 
     * @return int the value of the element
     * */
    public int value();
}

/** An interface for classes that can represent their values as a String */
interface MakeString {
    
    /** produce a String that represents this object 
     * 
     * @return String the fields set into a string
     * */
    public String makeString();
}


/** Represents a list of items of type T */
interface ILo<T> {

    /** Compute the total size (length) of this list 
     * 
     * @return int the size of the list
     * */
    public int size();

    /** Compute the total value of the items in this list 
     * 
     * @return int the total value of the list
     * */
    public int totalValue();



    /** accept the visitor that produces the result of the type R 
     * 
     * @return R the value that is returned by the visitor method
     * */
    public <R> R accept(ILoVisitor<R, T> ilov);
}                                


/** Represents an empty list of items of type T */
class MtLo<T> implements ILo<T> {
    MtLo() { }
    
    /** Template
     * Methods:
     * ...this.size()... - int
     * ...this.totalValue()... - int
     * ...this.accept()... - R
     */

    /** Compute the total size (length) of this empty list 
     * 
     * @return int the size of the list
     * */
    public int size() {
        return 0;
    }

    /** Compute the total value of this empty list 
     * 
     * @return int the total value of the list
     * */
    public int totalValue() {
        return 0;
    }

    /** accept the visitor that produces the result of the type R 
     * 
     * @return R the element that is returned by the visitor
     * */
    public <R> R accept(ILoVisitor<R, T> ilov) {
        return ilov.forMt();
    }
}                                              

/** Represents a nonempty list of items of type T */
class ConsLo<T> implements ILo<T> {
    T first;
    ILo<T> rest;

    ConsLo(T first, ILo<T> rest) {
        this.first = first;
        this.rest = rest;
    }

    /** Template:
     *   Fields:
     *     ... this.first ...    -- T
     *     ... this.rest ...     -- ILo<T>
     *
     *   Methods:
     *     ... this.size() ...            -- int
     *     ... this.totalValue() ...      -- int
     *     ... this.accept()...           -- R
     *
     *   Methods for Fields:
     *     ... this.rest.size() ...       -- int
     *     ... this.rest.totalValue() ... -- int
     */

    /** Compute the total size (length) of this nonempty list 
     * 
     * @return int the size of the list
     * */
    public int size() {
        return 1 + this.rest.size();
    }

    /** Compute the total value of this nonempty list 
     * 
     * @return int the total value of the list
     * */
    public int totalValue() {
        return ((IValue)this.first).value() + this.rest.totalValue();
    }

    /** accept the visitor that produces the result of the type R 
     * 
     * @return R the element that is returned after the visitor is used
     * */
    public <R> R accept(ILoVisitor<R, T> ilov) {
        return ilov.forCons(this.first, this.rest);
    }
}                                                    
