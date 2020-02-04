package interview.datastructures.stack;

import java.util.Scanner;

/**
 * 5
 * 4 5 2 10 8
 * 3
 * 3 2 1
 */

public class NearestSmallerElement {
    private int[] push(int[] arr) {
        int[] G = new int[arr.length];
        G[0] = -1;
        for (int i = 1; i < arr.length; i++) {
            G[i] = getSmallerElement(arr, i, arr[i]);
        }
        return G;
    }

    public int getSmallerElement(int[] arr, int index, int elementCom) {
        boolean flag = false;
        int min = elementCom;
        for (int i = index; i >= 0 ; i--) {
            if (min > arr[i]) {
                min = arr[i];
                flag = true;
                break;
            }
        }
        if (flag) {
            return min;
        } else return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NearestSmallerElement nse = new NearestSmallerElement();
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int a: nse.push(arr))
            System.out.println(a);
    }
}