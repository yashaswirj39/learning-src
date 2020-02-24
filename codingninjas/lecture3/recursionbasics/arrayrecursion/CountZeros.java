package codingninjas.lecture3.recursionbasics.arrayrecursion;

import java.util.Scanner;

public class CountZeros {
    public static int countZerosRex(int input) {
        //if (input >= 1) {
        if (input > 0) {
            if (input % 10 == 0) {
                return countZerosRex(input / 10) + 1;
            } else {
                return countZerosRex(input / 10);
            }
        }
        return 0;
        //}
        //return countZerosRex(input/10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int[] input = {1,0,2,0,5,0};
        //int[] input = {0,0,2,0,5,0};
        //int[] input = {1,0,2,0,5};
        //int input = 102050;
        int input = 10205;
        System.out.println(countZerosRex(input));
        //System.out.println(10205%10);
    }
}
