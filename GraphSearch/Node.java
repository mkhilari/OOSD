package GraphSearch;

import java.util.HashSet;

public class Node<T> {
    
    private T value;
    private HashSet<Node<T>> nexts;

    public Node(T value) {

        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public HashSet<Node<T>> getNexts() {
        return this.nexts;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNexts(HashSet<Node<T>> nexts) {
        this.nexts = nexts;
    }

    public boolean equals(Node<T> other) {
        
        return this.getValue().equals(other.getValue());
    }
}
