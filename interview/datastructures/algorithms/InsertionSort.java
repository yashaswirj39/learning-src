package interview.datastructures.algorithms;

import java.util.Scanner;

/**
 * This sorting is inplace. so space complexity is O(1).
 * Time Complexity
 * Best Case: O(n)
 * Average Case: O(n2(n-square))
 * Worst Case: O(n2(n-square))
 */
public class InsertionSort {
    protected static void insertionSort(int[] A) {
        for (int i = 1; i <= A.length - 1; i++) {
            int value = A[i];
            int hole = i;
            while (hole > 0 && A[hole-1] > value) {
                A[hole] = A[hole-1];
                hole = hole - 1;
            }
            A[hole] = value;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        insertionSort(a);
        for (int elem : a) {
            System.out.print(elem + " ");
        }
    }
}
