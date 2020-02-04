package Hackerrank;

import java.util.Scanner;

public class AppendAndDelete {

    private static final int INDEX_NOT_FOUND = -1;

    private static String deleteAppend(String s1, String s2, int k) {

        System.out.println(indexOfDifference(s1, s2));

        if (((s1.length() - indexOfDifference(s1, s2)) + (s2.length() - indexOfDifference(s1, s2))) == k) {
            return "Yes";
        } else if (((s1.length() - indexOfDifference(s1, s2)) + (s2.length() - indexOfDifference(s1, s2))) < k) {
            return "Yes";
        } else if (INDEX_NOT_FOUND < 0 && (s1.length() + s2.length()) <= k) {
            return "Yes";
        } else if (((s1.length() - indexOfDifference(s1, s2)) + (s2.length() - indexOfDifference(s1, s2))) > k) {
            return "No";
        }
        return null;
    }

    private static int indexOfDifference(String s1, String s2) {
        if (s1 == s2) {
            return INDEX_NOT_FOUND;
        }

        if (s1 == null || s2 == null) {
            return 0;
        }

        int i;
        for (i = 0; i < s1.length() && i < s2.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
        }

        if (i < s1.length() || i < s2.length()) {
            return i;
        }
        return INDEX_NOT_FOUND;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        int k = sc.nextInt();
        System.out.println(deleteAppend(s1, s2, k));
    }
}
