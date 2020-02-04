package leetcode.trees.randomproblems;

import java.util.Scanner;

public class FlippingAnImage {
    private static int[][] imageFlip(int[][] A){

        for (int i = A.length - 1; i >= 0; i--) {
            int l = A.length - 1;
            int r = 0;
            while (r<=l){
            }
        }
        return A;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int array[][] = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
    }
}
