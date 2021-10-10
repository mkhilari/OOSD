package Algorithms;

import java.util.ArrayList;

public class TreeNode<T> {
    
    private T value;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public static void main(String[] args) {

        // Create tree 
        TreeNode<Integer> root = new TreeNode<>(5);

        root.setLeft(new TreeNode<>(3));
        root.setRight(new TreeNode<>(7));
        root.getLeft().setRight(new TreeNode<>(4));

        ArrayList<TreeNode<Integer>> nodesInOrder = new ArrayList<>();

        root.inOrder(nodesInOrder);

        System.out.println(nodesInOrder.toString());
    }

    public TreeNode(T value) {

        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public TreeNode<T> getLeft() {
        return this.left;
    }

    public TreeNode<T> getRight() {
        return this.right;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public void inOrder(ArrayList<TreeNode<T>> nodes) {

        if (this.getLeft() != null) {
            this.left.inOrder(nodes);
        }

        // Visit curr 
        nodes.add(this);

        if (this.getRight() != null) {
            this.right.inOrder(nodes);
        }
    }

    public String toString() {
        return this.value.toString();
    }
}
