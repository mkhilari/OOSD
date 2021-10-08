package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class Quicksorter2<T extends Comparable<T>> {
    
    private ArrayList<T> A = new ArrayList<>();

    public static void main(String[] args) {

        // Create A 
        ArrayList<Integer> A = 
        new ArrayList<>(Arrays.asList(1, 3, 2, 4, 7, 2, 4, 4, 0, 1));
        
        System.out.println("A = " + A.toString());

        // Sort A 
        Quicksorter2<Integer> quicksorter = new Quicksorter2<>(A);

        quicksorter.quicksort();

        System.out.println("A = " + A.toString());
        System.out.println("quicksorter.getA() = " 
        + quicksorter.getA().toString());
    }

    public Quicksorter2(ArrayList<T> A) {

        this.A = A;
    }

    public ArrayList<T> getA() {
        return this.A;
    }

    public void setA(ArrayList<T> A) {
        this.A = A;
    }

    public void quicksort() {

        quicksort(this.getA(), 0, this.getA().size() - 1);
    }

    public void quicksort(ArrayList<T> A, int left, int right) {

        if (left >= right) {
            return;
        }

        int split = split(A, left, right);

        quicksort(A, left, split - 1);
        quicksort(A, split + 1, right);
    }

    public int split(ArrayList<T> A, int left, int right) {

        // Select pivot A[right] 

        int finalIndex = left;

        for (int i = left; i <= right; i++) {

            if (A.get(i).compareTo(A.get(right)) < 0) {

                // Move A[i] to left 
                swap(A, i, finalIndex);

                finalIndex += 1;
            }
        }

        // Move pivot to finalIndex 
        swap(A, right, finalIndex);

        return finalIndex;
    }

    public void swap(ArrayList<T> A, int i, int j) {

        T swap = A.get(i);
        A.set(i, A.get(j));
        A.set(j, swap);
    }
}
