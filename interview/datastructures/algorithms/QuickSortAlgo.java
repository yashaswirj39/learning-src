package interview.datastructures.algorithms;

/**
 * This sorting is inplace. so space complexity is O(1).
 * Time Complexity
 * Best Case:
 * Average Case:
 * Worst Case:
 */
public class QuickSortAlgo {

    /**
     * Recursive call for partitioning of array.
     * @param arr
     * @param start
     * @param end
     */
    static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pIndex = partitioning(arr, start, end);
            quickSort(arr, start, pIndex - 1);
            quickSort(arr, pIndex + 1, end);
        }
    }

    /**
     * returning the partioned index each time the method call happens
     * @param arr
     * @param start
     * @param end
     * @return
     */
    static int partitioning(int[] arr, int start, int end) {
        int pivot = arr[end];

        /**
         * partitioning index
         */
        int pIndex = start;

        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex] = temp;
                pIndex++;
            }
        }
        int temp = arr[end];
        arr[end] = arr[pIndex];
        arr[pIndex] = temp;
        return pIndex;
    }

    public static void main(String[] args) {
        int arr[] = {8,7,6,5,4,3,2,1};
        quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
