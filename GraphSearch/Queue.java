package GraphSearch;

import java.util.ArrayList;

public class Queue<T> {
    
    private ArrayList<T> elements = new ArrayList<>();

    public Queue() {

    }

    public Queue(ArrayList<T> elements) {

        this.elements = elements;
    }

    public ArrayList<T> getElements() {
        return this.elements;
    }

    public void enqueue(T element) {

        this.getElements().add(element);
    }

    public T dequeue() {

        return this.getElements()
        .remove(this.getElements().size() - 1);
    }

    public int size() {
        
        return this.getElements().size();
    }
}
