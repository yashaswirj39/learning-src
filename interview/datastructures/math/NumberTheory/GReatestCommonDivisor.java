package interview.datastructures.math.NumberTheory;

import java.util.Scanner;

public class GReatestCommonDivisor {
    private static int gcd (int m, int n) {
        if (m==0) return n;
        if (n==0) return m;
        if (m==n) return m;
        if (m > n) return gcd(m-n, n);
        return gcd(m,n-m);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(gcd(m,n));
    }
}
