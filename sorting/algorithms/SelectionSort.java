package sorting.algorithms;

import java.util.Scanner;

public class SelectionSort {

    protected static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            /**
             * assuming min_index is i everytime
             */
            int min_index = i;
            /**
             * the below loop will find the min value index and assign that index to min_index
             */
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min_index]) {
                    min_index = j;
                }
            }

            /**once the inner for loop executes everytime it gives me the min_index
             * that min_index value is swapped with current i index value
             */
            int temp = array[i];
            array[i] = array[min_index];
            array[min_index] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] array = selectionSort(arr);
        for (int element : array) {
            System.out.print(element + " ");
        }
    }
}
