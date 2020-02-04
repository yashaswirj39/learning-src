package interview.datastructures.array.arraymath;

import java.util.Scanner;

public class ArrayLeftRotation {
    private static int[] rotateElement(int arr[], int rotation) {
        while (rotation > 0) {
            for (int i = 0; i < arr.length-1; i++) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
            rotation--;
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int rotation = sc.nextInt();

        int arr[] = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        arr = rotateElement(arr, rotation);
        for (int i : arr)
            System.out.print(i + " ");
    }
}
