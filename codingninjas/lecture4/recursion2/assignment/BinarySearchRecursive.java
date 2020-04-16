package codingninjas.lecture4.recursion2.assignment;

import java.util.Scanner;

public class BinarySearchRecursive {

    private static int binarySearch(int[] input, int element) {
        return helper(input, element, 0, input.length - 1);
    }

    private static int helper(int[] input, int element, int start, int end) {
        if (input.length == 0)
            return -1;

        if (input.length % 2 == 0) {
            int mid = ((start + end) / 2) - 1;
            if (input[mid] == element) {
                return mid;
            } else {
                if (input[mid] < element) {
                    return helper(input, element, mid + 1, input.length - 1);
                } else {
                    return helper(input, element, 0, mid);
                }
            }
        } else {
            int mid = ((start + end) / 2);
            if (input[mid] == element) {
                return mid;
            } else {
                if (input[mid] < element) {
                    return helper(input, element, mid + 1, input.length - 1);
                } else {
                    return helper(input, element, 0, mid);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int element = sc.nextInt();
        System.out.println(binarySearch(arr, element));
    }
}
