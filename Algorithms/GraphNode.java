package Algorithms;

import java.util.ArrayList;
import java.util.HashSet;

public class GraphNode<T> {
    
    private T value;
    private ArrayList<GraphNode<T>> nexts = new ArrayList<>();

    public GraphNode(T value) {

        this.value = value;
    }

    public T getvalue() {
        return this.value;
    }

    public ArrayList<GraphNode<T>> getNexts() {
        return this.nexts;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNexts(ArrayList<GraphNode<T>> nexts) {
        this.nexts = nexts;
    }

    public String toString() {
        return this.getvalue().toString();
    }

    public void depthFirstSearch(ArrayList<GraphNode<T>> nodes) {

        // Create stack 
        Stack<GraphNode<T>> stack = new Stack<>();
        HashSet<GraphNode<T>> seen = new HashSet<>();

        stack.push(this);

        while (stack.size() > 0) {

            // Get curr 
            GraphNode<T> curr = stack.pop();

            nodes.add(curr);

            // Expand curr 
            for (GraphNode<T> next : curr.getNexts()) {

                // Check if next seen 
                if (!seen.contains(next)) {

                    seen.add(next);
                    stack.push(next);
                }
            }
        }
    }

    public void breadthFirstSearch(ArrayList<GraphNode<T>> nodes) {

        // Create queue 
        Queue<GraphNode<T>> queue = new Queue<>();
        HashSet<GraphNode<T>> seen = new HashSet<>();

        queue.enqueue(this);

        while (queue.size() > 0) {

            // Get curr 
            GraphNode<T> curr = queue.dequeue();

            // Expand curr 
            for (GraphNode<T> next : curr.getNexts()) {

                // Check if next seen 
                if (!seen.contains(next)) {

                    seen.add(next);
                    queue.enqueue(next);
                }
            }
        }
    }
}
