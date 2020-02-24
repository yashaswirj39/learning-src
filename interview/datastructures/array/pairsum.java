package interview.datastructures.array;

import java.util.Arrays;
import java.util.Scanner;

public class pairsum {
    public static void findPairSum(int[] array, int sum) {
        Arrays.sort(array);

        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            if (array[start] + array[end] == sum) {
                System.out.println(array[start] + " + " + array[end] + " = " + sum);
                start++;
                end--;
            } else if (array[start] + array[end] < sum) {
                start++;
            } else {
                end--;
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
        findPairSum(arr, 5);
    }
}
