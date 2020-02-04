package leetcode.trees.randomproblems;

import java.util.Scanner;

public class SortArrayByParity {
    private static int[] sortOddEven(int[] A){
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i]%2 == 0){
                int temp = A[count];
                A[count] = A[i];
                A[i] = temp;
                count++;
            }
        }
        for (int a:A){
            System.out.println(a+",");
        }
        return A;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sortOddEven(a);
    }
}
