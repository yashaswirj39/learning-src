package interview.datastructures.array.arraymath;


import java.util.Scanner;

public class ReverseArray {
    public static int[] reverseArray(int[] array) {
        int[] reversearr = new int[array.length];
        int j = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            reversearr[j] = array[i];
            j++;
        }
        return reversearr;
    }

    public static int[] flipImage(int[] arry) {
        for (int i = 0; i < arry.length; i++) {
            if (arry[i] == 0) {
                arry[i] = 1;
            } else {
                arry[i] = 0;
            }
        }
        return arry;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] array = new int[row][col];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = reverseArray(array[i]);
            array[i] = flipImage(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "  ");
            }
            System.out.println();
        }
    }
}