package codingninjas.lecture3.recursionbasics.arrayrecursion;

public class SumOfArray {
    public static int sum(int[] array) {
        if (array.length <= 1) {
            return array[0];
        }
        int arr[] = new int[array.length - 1];
        for (int i = 1; i < array.length; i++) {
            arr[i-1] = array[i];
        }
        if (arr.length >= 1) {
            int sum = sum(arr) + array[0];
            return sum;
        }
        return 0;
    }

    public static void main(String[] args) {
        //int[] input = {1, 2, 3, 4, 5};
        int[] input = {67, 2, 3, 4, 5};
        //int[] input = {9,8,9};
        System.out.println(sum(input));
    }
}
