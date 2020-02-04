package geeksforgeeks;

import java.util.Scanner;

public class SumOfBitDifference {

    private static int getBitsDiff(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                sum+=(Integer.bitCount(arr[i]^arr[j]) * 2);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();
        int sizeOfArray = sc.nextInt();

        for (int i = 0; i < testCases; i++) {
            int[] arrObj = new int[sizeOfArray];
            for (int j = 0; j < arrObj.length; j++) {
                arrObj[j] = sc.nextInt();
            }
            System.out.println(getBitsDiff(arrObj));
        }
    }
}
