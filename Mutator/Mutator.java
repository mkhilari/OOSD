package Mutator;

public interface Mutator<T> {

    public abstract T mutate(T input);
}