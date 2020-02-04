package interview.datastructures.algorithms;

/**
 * The sorting is inplace.
 * @TimeComplexity - O(n2)
 */
public class SelectionSort {
    protected static int[] selectionSort(int array[]) {

        for (int i = 0; i < array.length - 1; i++) {
            int iMin = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[iMin]) {
                    iMin = j;
                }
            }
            int temp = array[i];
            array[i] = array[iMin];
            array[iMin] = temp;
        }
        return array;
    }
    public static void main(String[] args) {
        int array[] = {2,7,4,1,5,3};
        array = selectionSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
