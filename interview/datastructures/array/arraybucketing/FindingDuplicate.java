package interview.datastructures.array.arraybucketing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FindingDuplicate {

    public static int repeatedNumber(final List<Integer> A) {
        if (A.isEmpty() || A == null || A.size() < 1) {
            return -1;
        }

        Collections.sort(A);
        for (int i = 0; i < A.size() - 1; i++) {
            if (A.get(i).equals(A.get(i+1))) {
                return A.get(i);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> al = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            al.add(scanner.nextInt());
        }
        System.out.println(repeatedNumber(al));
    }
}
