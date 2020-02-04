package interview.datastructures.algorithms;

public class MergeSort {

    public static void mergeSort(int array[]) {
        if (array.length < 2)
            return;

        int mid = array.length / 2;
        int left[] = new int[mid];
        int right[] = new int[array.length - mid];

        for (int i = 0; i <= mid-1; i++)
            left[i] = array[i];
        for (int i = mid; i < array.length; i++) {
            right[i-mid] = array[i];
        }

        mergeSort(left);
        mergeSort(right);
        merge(left, right, array);
    }

    public static void merge(int[] left, int right[], int array[]) {
        int nL = left.length;
        int rL = right.length;

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < nL && j < rL) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
                k++;
            } else {
                array[k] = right[j];
                j++;
                k++;
            }
        }
        while (i < nL) {
            array[k] = left[i];
            i++;
            k++;
        }
        while (j < rL) {
            array[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int arr[] = {2,4,1,6,8,5,3,7};
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
