package interview.datastructures.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AllFactors {
    private static ArrayList<Integer> allFactors(int A) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(A); i++) {
            if (A%i ==0) {
                al.add(i);
                if (i != Math.sqrt(A)) {
                    al.add(A/i);
                }
            }
        }
        Collections.sort(al);
        return al;
    }
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        int n = scanner.nextInt();
        System.out.println(allFactors(n));
    }
}
