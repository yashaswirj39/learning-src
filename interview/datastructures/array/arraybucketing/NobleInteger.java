package interview.datastructures.array.arraybucketing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NobleInteger {
    private static int solve(ArrayList<Integer> A) {

        if (A.isEmpty() || A == null || A.size() < 1) {
            return -1;
        }

        Collections.sort(A);

        for (int i = 0; i < A.size(); i++) {
            int num = A.get(i);
            int counter = 0;
            for (int j = i+1; j < A.size(); j++) {
                if (A.get(j) >= num && counter <= Math.abs(num)) {
                    counter++;
                } else {
                    break;
                }
            }
            if (counter == num && i == A.size() - 1) {
                return 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> al = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            al.add(sc.nextInt());
        }
        System.out.println(solve(al));
    }
}
