package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class quicksorter {
    private ArrayList<Integer> A; 

    public quicksorter(ArrayList<Integer> L) {
        this.A = L;

        System.out.println(this.A.toString());
    }

    public static void main(String[] args) {
        ArrayList<Integer> L = new ArrayList<>(Arrays.asList(1, 3, 7, 4, 2, 3, 11)); 

        quicksorter Q = new quicksorter(L);

        Q.quicksort(0, L.size() - 1);
    }

    public void quicksort(int left, int right) {
        if (left >= right) {
            return;
        }

        int split = split(left, right);

        System.out.println(this.A.toString());

        quicksort(left, split - 1);
        quicksort(split + 1, right);
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
