package interview.datastructures.math;

import java.util.Scanner;

/**
 * Sieve of Eratosthenes algorithm
 * Time Complexity - O(n.log(log.n))
 */
public class PrimeNumber {
    private static void isPrime(int n) {
        int arr[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = 1;
        }

        arr[0] = 0;
        arr[1] = 0;

        int num = (int) Math.sqrt(n);
        for (int i = 2; i <= num; i++) {
            if (arr[i] == 1) {
                for (int j = 2; i * j <= n; j++) {
                    arr[i * j] = 0;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0)
            System.out.println(i + " -------> " + arr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        isPrime(n);
    }
}
