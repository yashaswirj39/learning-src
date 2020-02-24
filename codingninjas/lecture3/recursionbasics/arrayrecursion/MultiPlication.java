package codingninjas.lecture3.recursionbasics.arrayrecursion;

import java.util.Scanner;

public class MultiPlication {
    public static int multiplyTwoIntegers(int m, int n) {
        if (n <= 0){
            return 0;
        }
        return multiplyTwoIntegers(m, n-1) + m;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(multiplyTwoIntegers(3, 1));
    }
}
