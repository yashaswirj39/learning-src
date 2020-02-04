package interview.datastructures.array.arraymath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * problem link:
 * https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */

/**
 * Test cases:
 * 6
 * 6
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 2 4 4 0
 * 0 0 0 2 0 0
 * 0 0 1 2 4 0
 *
 *
 * 6
 * 6
 * -9 -9 -9  1 1 1
 *  0 -9  0  4 3 2
 * -9 -9 -9  1 2 3
 *  0  0  8  6 6 0
 *  0  0  0 -2 0 0
 *  0  0  1  2 4 0
 */
public class HourGlassProblem {
    private static int maxHourGlassSum(int arr[][]) {
        ArrayList<Integer> maxElem = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr[i].length - 2; j++) {
                int sum = 0;
                sum += (arr[i][j] + arr[i][j + 1] + arr[i][j + 2]);
                sum += (arr[i + 1][j + 1]);
                sum += (arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]);
                maxElem.add(sum);
            }
        }
        System.out.println("List elements are: " + maxElem);
        return Collections.max(maxElem);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();

        int arr[][] = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(maxHourGlassSum(arr));
    }
}
