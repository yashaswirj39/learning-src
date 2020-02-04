package interview.hackerrank.stack;

import java.util.Arrays;
import java.util.Scanner;

public class LargestRectangle {
    private static long largestRectangle(int[] array) {

        Arrays.sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        int solidSquare = array[0];
        for (int i = 0; i < array.length; i++) {
            int data = array[i] * (array.length - i);
            System.out.println("i -> " + i + " data -> " + data);
            if (solidSquare < data) {
                solidSquare = data;
            }
        }
        return solidSquare;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(largestRectangle(array));
    }
}
