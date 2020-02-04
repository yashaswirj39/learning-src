package interview.datastructures.math.DigitOp;

import java.util.Scanner;

public class PallindromicInteger {

    private static int isPalindrome(int A) {
        String str = String.valueOf(A);
        if (str.equalsIgnoreCase(reverse(str)))
            return 1;
        return 0;
    }

    private static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isPalindrome(n));
    }
}
