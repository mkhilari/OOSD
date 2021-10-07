package GraphSearch;

import java.util.ArrayList;

public class Stack<T> {
    
    private ArrayList<T> elements = new ArrayList<>();

    public Stack() {

    }

    public Stack(ArrayList<T> elements) {

        this.elements = elements;
    }

    public ArrayList<T> getElements() {
        return this.elements;
    }

    public void push(T element) {

        this.getElements().add(element);
    }

    public T pop() {

        return this.getElements().remove(0);
    }

    public int size() {
        
        return this.getElements().size();
    }
}
