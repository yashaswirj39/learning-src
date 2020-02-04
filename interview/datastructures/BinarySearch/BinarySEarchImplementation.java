package interview.datastructures.BinarySearch;

import java.util.ArrayList;
import java.util.Scanner;

public class BinarySEarchImplementation {
    protected static int binarySearch(ArrayList<Integer> A, int x) {
        int low = 0;
        int high = A.size() - 1;

        while (low <= high) {
            int mid = (low+high)/2;
            if (x == A.get(mid))
                return mid;
            else if (x < A.get(mid))
                high = mid - 1;
            else
                low = mid + 1;
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
        int eleement = sc.nextInt();
        System.out.println(binarySearch(al,eleement));
    }
}
