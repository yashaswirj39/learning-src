package leetcode.dynamicprogramming.knapsackvariationproblems;

public class PartitionEqualSubsetSum {

    public static boolean equalsumpartition(int[] array) {

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        if (sum % 2 != 0) {
            return false;
        } else {
            return subsetSum(array, sum/2);
        }
    }

    public static boolean subsetSum(int[] array, int sum) {

        int N = array.length;
        int W = sum;

        boolean[][] T = new boolean[N+1][W+1];

        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                if (i == 0)
                    T[i][j] = false;

                if (j == 0) {
                    T[i][j] = true;
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (array[i - 1] <= j) {
                    T[i][j] = (T[i-1][j - array[i-1]] || T[i-1][j]);
                } else {
                    T[i][j] = T[i-1][j];
                }
            }
        }

        return T[N][W];
    }

    public static void main(String[] args) {
        //int[] array = {1,5,11,5};//true
        //int[] array = {1,2,3,4}; // true
        int[] array = {1,2,3,4,1};
        System.out.println(equalsumpartition(array));
    }
}