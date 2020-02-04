package interview.datastructures.array.arraymath;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralOrderTraversal {
    private void printSpiralOrder(int[][] array, int m, int n) {
        int T = 0; // Top
        int B = m-1; // Bottom
        int L = 0; // Left
        int R = n-1; // Right
        int dir = 0; // direction

        while (L <= R && T <= B) {
            if (dir == 0) {
                for (int K = L; K <= R; K++) {
                    System.out.println(array[T][K] + " ");
                }
                T++;
                System.out.println("--------------------");
            } else if (dir == 1) {
                for (int K = T; K <= B; K++) {
                    System.out.println(array[K][R] + " ");
                }
                R--;
                System.out.println("---------------------");
            } else if (dir == 2) {
                for (int K = R; K >= L ; K--) {
                    System.out.println(array[B][K] + " ");
                }
                B--;
                System.out.println("----------------------");
            } else if (dir == 3) {
                for (int K = B; K >= T ; K--) {
                    System.out.println(array[K][L] + " ");
                }
                L++;
                System.out.println("---------------------");
            }
            dir = (dir + 1) % 4;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] array = new int[m][n];

        List<ArrayList<Integer>> A = new ArrayList<>();

        /*int[][] array = new int[A.size()][];
        for (int i = 0; i < A.size(); i++) {
            ArrayList<Integer> row = A.get(i);
            array[i] = row.toArray(new Integer[row.size()]);
        }*/

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("calling spiral: ");
        SpiralOrderTraversal spot = new SpiralOrderTraversal();
        spot.printSpiralOrder(array, m, n);
    }
}
