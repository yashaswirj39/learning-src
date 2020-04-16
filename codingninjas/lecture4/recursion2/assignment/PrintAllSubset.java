package codingninjas.lecture4.recursion2.assignment;

import java.util.Scanner;
import java.util.Vector;

/**
 * https://www.geeksforgeeks.org/recursive-program-to-print-all-subsets-with-given-sum/
 */

public class PrintAllSubset {
    static void printAllSubsetsRec(int arr[], int n, Vector<Integer> v,
                                   int sum) {
        if (sum == 0) {
            for (int i = v.size() - 1; i >= 0; i--)
                System.out.print(v.get(i) + " ");
            System.out.println();
            return;
        }

        if (n == 0)
            return;

        printAllSubsetsRec(arr, n - 1, v, sum);
        Vector<Integer> v1 = new Vector<Integer>(v);
        v1.add(arr[n - 1]);
        printAllSubsetsRec(arr, n - 1, v1, sum - arr[n - 1]);
    }

    public static void printSubsetsSumTok(int input[], int k) {
        Vector<Integer> v = new Vector<Integer>();
        printAllSubsetsRec(input, input.length, v, k);
    }

    public static void main(String[] args) {
        /*int arr[] = { 2, 5, 8, 4, 6, 11 };
        int sum = 13;*/
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int sum = sc.nextInt();
        printSubsetsSumTok(array, sum);
    }
}
