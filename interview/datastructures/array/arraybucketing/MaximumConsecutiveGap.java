package interview.datastructures.array.arraybucketing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MaximumConsecutiveGap {
    private static int maximumGap(ArrayList<Integer> A) {
        Collections.sort(A);
        if (A.size() < 2) return 0;
        int max = 0;
        for (int i = A.size() - 1; i > 0; i--) {
            if (A.get(i-1) < A.get(i)) {
                if (max < (A.get(i) - A.get(i-1))) {
                    max = (A.get(i) - A.get(i-1));
                } else {
                    continue;
                }
            } else {
                continue;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> al = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            al.add(sc.nextInt());
        }
        System.out.println(maximumGap(al));
    }
}
