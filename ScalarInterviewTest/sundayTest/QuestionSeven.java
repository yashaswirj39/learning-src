package ScalarInterviewTest.sundayTest;

import java.math.BigInteger;
import java.util.Scanner;

public class QuestionSeven {
    private static  BigInteger solve(int A) {
        if (A == 1) {
            return BigInteger.valueOf(A % 10003);
        }

        if (A == 2) {
            return BigInteger.valueOf(3 % 10003);
        }

        if (A == 3) {
            return BigInteger.valueOf(4 % 10003);
        }

        if (A > 3) {
            BigInteger sum = BigInteger.valueOf(A);
            while (A != 0) {
                sum = sum.multiply(BigInteger.valueOf(A));
                A--;
            }
            System.out.println(sum);
            return sum.mod(BigInteger.valueOf(10003));
        }
        return BigInteger.valueOf(0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solve(n));
    }
}
