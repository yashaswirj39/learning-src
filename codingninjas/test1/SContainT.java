package codingninjas.test1;

import java.util.Scanner;

public class SContainT {

    public static boolean checkSequence(String a, String b) {
        return isSequence(a, b, a.length(), b.length());
    }

    public static boolean isSequence(String str1, String str2, int m, int n) {
        int j = 0;
        for (int i = 0; i < n && j < m; i++) {
            if (str1.charAt(j) == str2.charAt(i))
                j++;
        }
        return (j == m);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println(checkSequence(s, t));
    }
}
