package Categoriser;

public interface Categoriser<C, V> {
    
    public C getCategory(V value);
}
