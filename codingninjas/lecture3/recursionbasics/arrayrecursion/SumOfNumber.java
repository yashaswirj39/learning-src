package codingninjas.lecture3.recursionbasics.arrayrecursion;

import java.util.Scanner;

public class SumOfNumber {
    private static int sum(int n) {
        if (n > 0) {
            //int num = (n%10) + sum(n/10);
            return (n%10) + sum(n/10);
        }
         return 0;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(sum(n));
    }
}
