package Algorithms;

import java.util.ArrayList;

public class Quicksorter {

    private ArrayList<Integer> A; 

    public Quicksorter(ArrayList<Integer> A) {
        this.A = A;

        System.out.println(this.A.toString());
    }

    public void quicksort(int left, int right) {

        if (left >= right) {
            
            // A has length 1 
            return;
        }

        int split = this.split(left, right);

        System.out.println(this.A.toString());

        this.quicksort(left, split - 1);
        this.quicksort(split + 1, right);
    }

    public int split(int left, int right) {
        // Select A[right] as pivot 

        int finalIndex = left;

        for (int i = left; i < right; i++) {
            if (this.A.get(i) < this.A.get(right)) {
                // Swap A[finalIndex] and A[i] 
                Integer swap = this.A.get(finalIndex);
                this.A.set(finalIndex, this.A.get(i));
                this.A.set(i, swap);

                finalIndex++;
            }
        }

        // Swap A[finalIndex] and A[right]
        Integer swap = this.A.get(finalIndex);
        this.A.set(finalIndex, this.A.get(right));
        this.A.set(right, swap);

        return finalIndex;
    }
}
