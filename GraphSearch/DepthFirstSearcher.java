package GraphSearch;

import java.util.HashSet;

public class DepthFirstSearcher<T> {
    
    private Node<T> root;

    public DepthFirstSearcher(Node<T> root) {

        this.root = root;
    }

    public Node<T> getRoot() {
        return this.root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public Node<T> DFS(Node<T> target) {

        // Create stack 
        Stack<Node<T>> stack = new Stack<>();
        HashSet<Node<T>> visited = new HashSet<>();

        stack.push(this.getRoot());

        while (stack.size() > 0) {

            // Get current node 
            Node<T> curr = stack.pop();

            if (curr.equals(target)) {

                // Target found 
                return curr;
            }

            for (Node<T> next : curr.getNexts()) {

                // Get if visited 
                if (visited.contains(next)) {

                    continue;
                }

                stack.push(next);
                visited.add(next);
            }
        }

        // Target not found 
        return null;
    }
}
