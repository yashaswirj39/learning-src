package leetcode.thirtydaychallenge.week3;

import java.util.Scanner;

/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the
 * product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array
 * (including the whole array) fits in a 32 bit integer.
 *
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for
 * the purpose of space complexity analysis.)
 */

public class ProductOfArrayExceptItself {

    public static int[] product(int[] arr) {
        int len = arr.length;
        int[] res = new int[len];
        int j = 0;
        while (len-- > 0) {
            int prod = 1;
            for (int i = 0; i < arr.length; i++) {
                if (i != j) {
                    prod *= arr[i];
                }
            }
            res[j] = prod;
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        int[] arr = product(array);
        for (int elem : arr) {
            System.out.print(elem + " ");
        }
    }
}
