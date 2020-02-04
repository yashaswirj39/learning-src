package interview.datastructures.math.DigitOp;

import java.util.Scanner;

public class ReverseInteger {
    private static int reverseNumber(int A) {
        try {
            if (A > 0) {
                return Integer.parseInt(reverse(String.valueOf(A)));
            } else {
                A = - (A);
                int rev = Integer.parseInt(reverse(String.valueOf(A)));
                rev = - (rev);
                return rev;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    private static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(reverseNumber(n));
    }
}
