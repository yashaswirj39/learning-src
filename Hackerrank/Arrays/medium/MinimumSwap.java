package Hackerrank.Arrays.medium;

import java.util.*;

public class MinimumSwap {

    private static int minimumSwaps(int[] arr){

        int count = 0;
        for(int i =0; i<arr.length;i++){
            if(arr[i] != i+1){
                int temp = arr[i];
                arr[i] = arr[arr[i]-1];
                arr[temp -1] = temp;
                count++;
                i--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sizeOfArray = sc.nextInt();

        int[] array=new int[sizeOfArray];

        for (int i = 0; i < sizeOfArray; i++) {
            array[i] = sc.nextInt();
        }
        //long cur = System.currentTimeMillis();
        System.out.println(minimumSwaps(array));
        //System.out.println(System.currentTimeMillis() - cur);
    }
}
