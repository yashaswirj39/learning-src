package leetcode.trees.randomproblems;

import java.util.*;

public class NRepeatedElements {
    HashSet<Integer> hs = new HashSet();
    int i = 0;

    private int repeatedElement(int[] A) {
        if (i < A.length) {
            if (!hs.contains(A[i])) {
                hs.add(A[i]);
                i++;
                repeatedElement(A);
            } else {
                return A[i];
            }
        }
        return A[i];
    }

    private int[] square(int[] A){
        for (int j = 0; j < A.length; j++) {
            A[j] = A[j] * A[j];
        }
        Arrays.sort(A);
        return A;
    }

    public static void main(String[] args) {

        NRepeatedElements nr = new NRepeatedElements();
        Scanner scanner = new Scanner(System.in);

        int r = scanner.nextInt();
        int array[] = new int[r];
        for (int i = 0; i < r; i++) {
            array[i] = scanner.nextInt();
        }
        for (int a : nr.square(array))
        System.out.println(a);
    }
}
