package codingninjas.lecture13.hashmaps;

import java.util.Arrays;

public class PrintIntersection {
    public static void intersection(int[] arr1, int[] arr2){
        /* Your class should be named Intersection
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Print output and don't return it.
         * Taking input is handled automatically.
         */

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int j = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == arr2[j]) {
                System.out.println(arr1[i]);
                j++;
            }
            if (arr1[i] < arr2[j]) {
                continue;
            }
            if (arr1[i] > arr2[j]) j++;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 6, 8, 2, 4, 3};
        int[] arr2 = {2, 3, 4, 7};

        intersection(arr1, arr2);
    }
}
