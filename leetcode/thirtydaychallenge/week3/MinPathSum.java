package leetcode.thirtydaychallenge.week3;

/**
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3303/
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 * Reference:
 * https://www.youtube.com/watch?v=lBRtnuxg-gU
 */

public class MinPathSum {
    public static int minPathSum(int[][] grid) {

        if (grid.length == 0 || grid == null) {
            return 0;
        }

        if (grid[0].length == 1) {
            return grid[0][0];
        }

        if (grid.length == 1 && grid[0].length > 1) {
            int res = 0;
            for (int j = 1; j < grid[0].length; j++) {
                grid[0][j] = grid[0][j] + grid[0][j - 1];
                res = grid[0][j];
            }
            return res;
        }

        for (int j = 1; j < grid[0].length; j++) {
            grid[0][j] = grid[0][j] + grid[0][j - 1];
        }

        int res = 0;
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    int min = Math.min(grid[i][j - 1], grid[i - 1][j]);
                    grid[i][j] = min + grid[i][j];
                    res = grid[i][j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        /*int arr[][] = { {1,3,1},
                        {1,5,1},
                        {4,2,1}
                       };*/
        /*int arr[][] = { {1, 3, 5, 8},
                        {4, 2, 1, 7},
                        {4, 3, 2, 3}
        };*/
        //int arr[][] = {{1, 2}};
        int arr[][] = {{1, 2},
                {5, 6},
                {1, 1}};
        System.out.println(arr[0].length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(minPathSum(arr));
    }
}