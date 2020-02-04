package interview.datastructures.math.adhoc;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeSum {
    private static boolean checkPrime(int n) {
        if (n <= 1) {
            return false;
        }

        boolean flag = false;

        for (int i = 2; i < n; i++) {
            if (n%i == 0)
                return false;
        }
        return true;
    }

    private static ArrayList<Integer> primeSum(int A) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            if (checkPrime(i) && checkPrime(A-i)) {
                al.add(i);
                al.add(A-i);
                break;
            }
        }
        return al;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(primeSum(n));
    }
}
