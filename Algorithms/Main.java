package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 3, 7, 4, 2, 3, 11)); 

        MergeSorter M = new MergeSorter(A);

        M.mergeSort(0, A.size() - 1);

        System.out.println(A.toString());
    }
}
