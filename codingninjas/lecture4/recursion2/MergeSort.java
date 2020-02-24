package codingninjas.lecture4.recursion2;

public class MergeSort {

    public void mergeSort(int[] array) {
        if (array.length < 2) {
            return;
        }

        int mid = array.length / 2;

        int fp[] = new int[mid];
        for (int i = 0; i <= mid - 1; i++) {
            fp[i] = array[i];
        }

        int sp[] = new int[array.length - mid];
        for (int i = mid; i < array.length; i++) {
            sp[i - mid] = array[i];
        }

        mergeSort(fp);
        mergeSort(sp);
        sort(fp, sp, array);
    }

    private void sort(int[] fp, int[] sp, int[] array) {
        int fpLength = fp.length;
        int spLength = sp.length;

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < fpLength && j < spLength) {
            if (fp[i] <= sp[i]) {
                array[k] = fp[i];
                i++;
                k++;
            } else {
                array[k] = sp[j];
                j++;
                k++;
            }
        }

        while (i < fp.length) {
            array[k] = fp[i];
            i++;
            k++;
        }

        while (j < sp.length) {
            array[k] = sp[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        MergeSort ms  = new MergeSort();
        int[] array = {5,4,3,2,1};
        ms.mergeSort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
