package interview.datastructures.array.arraybucketing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 12
 * 1 1 10 10 15 10 15 10 10 15 10 15
 *
 * 7
 * 4 15 4 4 15 18 20
 */
public class MaximumUnsortedSubArray {
    private static ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.addAll(A);

        Collections.sort(temp);

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i <A.size() ; i++) {
            if (A.get(i) != temp.get(i)) {
                res.add(i);
            } else
                continue;
        }

        if (!res.isEmpty()) {
            int start = res.get(0);
            int end = res.get(res.size()-1);
            res.clear();
            res.add(start);
            res.add(end);
        } else {
            res.add(-1);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> al = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            al.add(sc.nextInt());
        }
        System.out.println(subUnsort(al));
    }
}
