package leetcode.dynamicprogramming.knapsackvariationproblems;

/**
 * In this question, Insted of OR just replace OR with plus(+) symbol
 */
public class CountOfSubsetSumWithGivenSum {

    private static int subsetSum(int[] array, int sum) {
        /**
         * Suppose "array" is weight array which is n, and "sum" is weight which is w.
         * First create a matrix of size N+1 , W+1
         */

        int N = array.length;
        int W = sum;

        int[][] T = new int[N + 1][W + 1];


        //intializing the array (base condition)
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                if (i == 0) {
                    T[i][j] = 0;
                }

                if (j == 0) {
                    T[i][j] = 1;
                }
            }
        }

        //Using Knapsack formula to calculate the result
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (array[i-1] <= j) {
                    T[i][j] = T[i][j - array[i - 1]] + T[i - 1][j];
                } else {
                    T[i][j] = T[i-1][j];
                }
            }
        }

        //Printing the result array and returning the result. T[N][sum] -> which is lower right corner.
        //W is sum here.

        /**
         * true	false	false	false	false	false	false	false	false	false	false	false
         * true	false	true	false	true	false	true	false	true	false	true	false
         * true	false	true	true	true	true	true	true	true	true	true	true
         * true	false	true	true	true	true	true	true	true	true	true	true
         * true	false	true	true	true	true	true	true	true	true	true	true
         * true	false	true	true	true	true	true	true	true	true	true	true
         */
        /*for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                System.out.print(T[i][j] + "\t");
            }
            System.out.println();
        }*/

        System.out.println(N + " -> " + W);
        return T[N][W];
    }

    public static void main(String[] args) {
        int array[] = {2, 3, 7, 8, 10};
        System.out.println(subsetSum(array, 11));
    }
}