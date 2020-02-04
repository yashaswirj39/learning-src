package interview.datastructures.BinarySearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * pivot property - next and previous elements both are greater
 */
public class ArrayRotation {
    public static int findMin(final List<Integer> A) {
        int low = 0;
        int high = A.size() - 1;

        while (low <= high) {
            if (A.get(low) <= A.get(high))
                return low;
            int mid = (low + high) / 2;
            int next = (mid + 1) % A.size();
            int prev = (mid + A.size() - 1) % A.size();
            if (A.get(mid) <= A.get(next) && A.get(mid) <= A.get(prev))
                return mid;
            else if (A.get(mid) <= A.get(high)) high = mid - 1;
            else if (A.get(mid) >= A.get(low)) low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(sc.nextInt());
        }
        System.out.println(findMin(al));
    }
}
