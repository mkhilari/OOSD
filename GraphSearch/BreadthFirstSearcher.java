package GraphSearch;

import java.util.HashSet;

public class BreadthFirstSearcher<T> {
    
    private Node<T> root;

    public BreadthFirstSearcher(Node<T> root) {

        this.root = root;
    }

    public Node<T> getRoot() {
        return this.root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public Node<T> BFS(Node<T> target) {

        // Create queue 
        Queue<Node<T>> queue = new Queue<>();
        HashSet<Node<T>> visited = new HashSet<>();

        queue.enqueue(this.getRoot());

        while (queue.size() > 0) {

            // Get current node 
            Node<T> curr = queue.dequeue();

            if (curr.equals(target)) {

                // Target found 
                return curr;
            }

            for (Node<T> next : curr.getNexts()) {

                // Get if visited 
                if (visited.contains(next)) {

                    continue;
                }

                queue.enqueue(next);
                visited.add(next);
            }
        }

        // Target not found 
        return null;
    }
}
