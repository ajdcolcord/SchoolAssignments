/** to represent a function from the type T to the type S */
public interface T2S<T, S> {
    
    
    /** produce an integer value from the given one 
     * 
     * @param i the given T value
     * @return S
     */
    public S apply(T i);

}
