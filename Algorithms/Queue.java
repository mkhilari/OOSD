package Algorithms;

import java.util.ArrayList;

public class Queue<T> {

    private ArrayList<T> values = new ArrayList<>();

    public Queue() {

    }

    public ArrayList<T> getValues() {
        return this.values;
    }

    public void setValues(ArrayList<T> values) {
        this.values = values;
    }

    public void enqueue(T newValue) {
        this.getValues().add(newValue);
    }

    public T dequeue() {
        return this.getValues().get(0);
    }

    public int size() {
        return this.getValues().size();
    }
}
