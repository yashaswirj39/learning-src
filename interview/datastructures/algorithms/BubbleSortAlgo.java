package interview.datastructures.algorithms;

/**
 * This sorting is inplace. so space complexity is O(1).
 * Time Complexity
 * Best Case: O(n)
 * Average Case: O(n2(n-square))
 * Worst Case: O(n2(n-square))
 */
public class BubbleSortAlgo {

    static void bubbleSort(int[] arr) {
        /**
         * first loop is for all the possible passes to perform for sorting
         */
        for (int i = 0; i < arr.length-1; i++) {

            int flag = 0;

            /**
             * This loop is to swap element at current index(if greater) with element at curr + 1 index(if smaller)
             * flag is set to 1 if swap occurs otherwise flag is set to 0 for breaking out of loop
             * to ignore the extra looping
             */

            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = 1;
                }
            }
            if (flag == 0)
                break;
        }
    }

    public static void main(String[] args) {
        /**
         * test cases.
         */
        /*int arr[] = {8,7,6,5,4,3,2,1};*/
        int arr[] = {4,1,7,3,2,5};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}