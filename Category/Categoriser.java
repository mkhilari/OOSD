package Category;

public interface Categoriser<T1, T2> {
    
    public abstract T2 categorise(T1 input);
}
