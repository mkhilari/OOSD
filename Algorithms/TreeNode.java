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

        // inOrder 
        ArrayList<TreeNode<Integer>> nodesInOrder = new ArrayList<>();

        root.inOrder(nodesInOrder);

        System.out.println(nodesInOrder.toString());

        // preOrder 
        ArrayList<TreeNode<Integer>> nodesPreOrder = new ArrayList<>();

        root.preOrder(nodesPreOrder);

        System.out.println(nodesPreOrder.toString());

        // postOrder 
        ArrayList<TreeNode<Integer>> nodesPostOrder = new ArrayList<>();

        root.postOrder(nodesPostOrder);

        System.out.println(nodesPostOrder.toString());
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

    public String toString() {
        return this.getValue().toString();
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

    public void preOrder(ArrayList<TreeNode<T>> nodes) {

        // Visit curr first 
        nodes.add(this);

        if (this.getLeft() != null) {
            this.getLeft().preOrder(nodes);
        }

        if (this.getRight() != null) {
            this.getRight().preOrder(nodes);
        }
    }

    public void postOrder(ArrayList<TreeNode<T>> nodes) {

        if (this.getLeft() != null) {
            this.getLeft().postOrder(nodes);
        }

        if (this.getRight() != null) {
            this.getRight().postOrder(nodes);
        }

        // Visit curr last 
        nodes.add(this);
    }

}
