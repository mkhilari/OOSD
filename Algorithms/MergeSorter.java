package Algorithms;

import java.util.ArrayList;

public class MergeSorter {

    private ArrayList<Integer> A;

    public MergeSorter(ArrayList<Integer> A) {
        this.A = A;

        System.out.println(this.A.toString());
    }

    public void mergeSort(int left, int right) {

        if (left >= right) {

            // A has length 1 
            return;
        }

        int mid = (left + right) / 2;

        this.mergeSort(left, mid);
        this.mergeSort(mid + 1, right);

        this.merge(left, mid, mid + 1, right);
    }

    public void merge(int left1, int right1, int left2, int right2) {

        int nALeft = right1 - left1 + 1;
        ArrayList<Integer> ALeft = new ArrayList<>();

        int nARight = right2 - left2 + 1;
        ArrayList<Integer> ARight = new ArrayList<>();

        // Get ALeft 
        for (int i = 0; i < nALeft; i++) {
            ALeft.add(i, this.A.get(left1 + i));
        }

        // Get ARight 
        for (int i = 0; i < nARight; i++) {
            ARight.add(i, this.A.get(left2 + i));
        }

        // Merge sorted ALeft and ARight into A 
        int iA = left1;
        int iALeft = 0;
        int iARight = 0;

        while (iALeft < nALeft && iARight < nARight) {
            
            // Add smaller element 
            if (ALeft.get(iALeft) < ARight.get(iARight)) {

                this.A.set(iA, ALeft.get(iALeft));
                iALeft += 1;
            } else {

                this.A.set(iA, ARight.get(iARight));
                iARight += 1;
            }

            iA += 1;
        }

        // Add rest of ALeft 
        while (iALeft < nALeft) {

            this.A.set(iA, ALeft.get(iALeft));
            iALeft += 1;
            iA += 1;
        }

        // Add rest of ARight 
        while (iARight < nARight) {

            this.A.set(iA, ARight.get(iARight));
            iARight += 1;
            iA += 1;
        }
    }

    
}
