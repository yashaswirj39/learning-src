package codingninjas.lecture4.recursion2;

public class QuickSort {
    public static void quickSort(int[] input) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * No need to print or return the output.
         * Taking input and printing output is handled automatically.
         */
        sort(input, 0, input.length - 1);
    }

    static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int pIndex = partitioning(arr, start, end);
            sort(arr, start, pIndex - 1);
            sort(arr, pIndex + 1, end);
        }
    }

    static int partitioning(int[] arr, int start, int end) {
        int pivot = arr[end];

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
        quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
