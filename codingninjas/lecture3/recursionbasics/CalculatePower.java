package codingninjas.lecture3.recursionbasics;

import java.util.Scanner;

public class CalculatePower {
    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        x *= power(x, n-1);
        return x;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int pow = sc.nextInt();
        System.out.println(power(num, pow));
    }
}
