package sorting.algorithms;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class BubbleSort {

    /**
     * Buuble sort using two array;
     *
     * @param array
     * @return
     */
    private static int[] bubbleSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            boolean falg = false;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                    falg = true;
                }
            }
            if (!falg)
                break;
        }
        return array;
    }

    /**
     * recursive bubble sort
     *
     * @param array
     * @return
     */
    private static void recursiveBubbleSort(int[] array, int n) {

        for (int i = 0; i < array.length - 1; i++){
            if (array[i] > array[i + 1]) {
                int tmp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = tmp;
            }}
        /**
         * Largest element is  fixed now recurrse again.
         */

        recursiveBubbleSort(array, n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sizeOfArray = sc.nextInt();

        int[] array = new int[sizeOfArray];

        for (int i = 0; i < sizeOfArray; i++) {
            array[i] = sc.nextInt();
        }

        bubbleSort(array);
        for (int n : array)
            System.out.print(n + " ");

        /*recursiveBubbleSort(array, array.length-1);
        for (int n : array)
            System.out.print(n + " ");*/
    }
}
