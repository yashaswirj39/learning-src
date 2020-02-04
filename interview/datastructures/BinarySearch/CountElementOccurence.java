package interview.datastructures.BinarySearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountElementOccurence {
    private static int findCount(final List<Integer> A, int B) {
        if (A.contains(B)) {
            int firstIndex = findFirstOccurence(A, B);
            int lastIndex = findLastOccurence(A, B);
            return (lastIndex - firstIndex) + 1;
        } else
            return 0;
    }

    private static int findFirstOccurence(List<Integer> A, int x) {
        int low = 0;
        int high = A.size() - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (x == A.get(mid)) {
                result = mid;
                high = mid - 1; // Go on Searching towards left for finding first occurence.
            } else if (x < A.get(mid))
                high = mid - 1;
            else
                low = mid + 1;
        }
        return result;
    }

    private static int findLastOccurence(List<Integer> A, int x) {
        int low = 0;
        int high = A.size() - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (x == A.get(mid)) {
                result = mid;
                low = mid + 1; // Go on Searching toward's right for finding last occurence.
            } else if (x < A.get(mid))
                high = mid - 1;
            else
                low = mid + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(sc.nextInt());
        }
        System.out.println(findCount(al, sc.nextInt()));
    }
}
