package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSorter2<T extends Comparable<T>> {
    
    private ArrayList<T> A = new ArrayList<>();

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 4, 2, 3, 7, 1, 2, 2, 0 , 3));

        MergeSorter2<Integer> mergeSorter = new MergeSorter2<>(A);

        System.out.println("A = " + A.toString());

        mergeSorter.mergeSort();

        System.out.println("A = " + A.toString());
    }

    public MergeSorter2(ArrayList<T> A) {

        this.A = A;
    }

    public ArrayList<T> getA() {
        return this.A;
    }

    public void setA(ArrayList<T> A) {
        this.A = A;
    }

    public void mergeSort() {

        this.mergeSort(this.getA(), 0, this.getA().size() - 1);
    }

    public void mergeSort(ArrayList<T> A, int left, int right) {

        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(A, left, mid);
        mergeSort(A, mid + 1, right);

        merge(A, left, mid, mid + 1, right);
    }

    public void merge(ArrayList<T> A, int left1, int right1, int left2, int right2) {

        // Get A1 
        ArrayList<T> A1 = new ArrayList<>();

        for (int i = left1; i <= right1; i++) {

            A1.add(A.get(i));
        }

        // Get A2 
        ArrayList<T> A2 = new ArrayList<>();

        for (int i = left2; i <= right2; i++) {

            A2.add(A.get(i));
        }

        // Merge A1 and A2 
        int iA = left1;
        int iA1 = 0;
        int iA2 = 0;

        while (iA1 < A1.size() && iA2 < A2.size()) {

            if (A1.get(iA1).compareTo(A2.get(iA2)) < 0) {

                // A1 smaller 
                A.set(iA, A1.get(iA1));
                iA += 1;
                iA1 += 1;
            } else {

                // A2 smaller 
                A.set(iA, A2.get(iA2));
                iA += 1;
                iA2 += 1;
            }
        }

        // Add rest of A1 
        while (iA1 < A1.size()) {

            A.set(iA, A1.get(iA1));
            iA += 1;
            iA1 += 1;
        }

        // Add rest of A2 
        while (iA2 < A2.size()) {

            A.set(iA, A2.get(iA2));
            iA += 1;
            iA2 += 1;
        }
    }
}
