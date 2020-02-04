package interview.datastructures.BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MAtrixMedian {
    public static int findMedian(ArrayList<ArrayList<Integer>> A) {
        int length = 0;
        for (int i = 0; i < A.size(); i++) {
            length+=A.get(i).size();
        }

        int i =0;
        int j = 0;
        while (length-- >= 0) {

        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                list.add(sc.nextInt());
            }
            al.add(list);
        }
    }
}
