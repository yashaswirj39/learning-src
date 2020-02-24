package codingninjas.lecture3.recursionbasics.arrayrecursion;

import java.util.Scanner;

public class FindAllIndices {
    private static int[] allindices(int array[], int index, int x, int newArray[], int newIndex) {
        if(index >= array.length) {
            return newArray;
        }

        if(array[index] == x && index <= array.length - 1) {
            if(newIndex >= newArray.length) {
                int[] temp = newArray;
                newArray = new int[newIndex+1];
                for(int i = 0; i < temp.length; i++){
                    newArray[i] = temp[i];
                }
            }
            newArray[newIndex] = index;
            newIndex++;
        }

        return allindices(array, index + 1, x, newArray, newIndex);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int number = sc.nextInt();
        int[] arr = allindices(array, 0, number, new int[1], 0);
        for (int i: arr) {
            System.out.print(i+ " ");
        }
    }
}
