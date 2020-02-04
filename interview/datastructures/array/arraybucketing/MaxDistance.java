package interview.datastructures.array.arraybucketing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MaxDistance {
    private static int maximumGap(ArrayList<Integer> A) {
        if (A.size() == 0 || A.isEmpty()) return 0;
        if (A.size() == 1) return 0;
        Collections.sort(A);
        int start = 0;
        int end = A.size()-1;
        int max = 0;

        while (start < end) {
            if (A.get(start) <= A.get(end)) {
                if (max <= (end-start)) {
                    max = end - start;
                }
                start++;
            } else {
                end--;
            }
        }
        return max - 2;
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
