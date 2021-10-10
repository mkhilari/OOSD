package Algorithms;

import java.util.ArrayList;

public class Stack<T> {

    private ArrayList<T> values = new ArrayList<>();

    public Stack() {

    }

    public ArrayList<T> getValues() {
        return this.values;
    }

    public void setValues(ArrayList<T> values) {
        this.values = values;
    }

    public void push(T newValue) {
        this.getValues().add(newValue);
    }

    public T pop() {
        return this.getValues().remove(this.getValues().size() - 1);
    }
    
    public int size() {
        return this.getValues().size();
    }
}
