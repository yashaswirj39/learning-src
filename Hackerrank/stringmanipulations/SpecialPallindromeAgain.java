package Hackerrank.stringmanipulations;

import java.util.Scanner;

public class SpecialPallindromeAgain {

    private static int subStrCount(int n, String s) {

        int count = 0;
        count = s.length();
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.substring(i, j + 1).length() % 2 == 0) {
                    StringBuilder sb = new StringBuilder(s.substring(i, j + 1)).reverse();
                    if (s.substring(i, j + 1).equalsIgnoreCase(sb.toString())) {
                        count++;
                    }
                } else {
                    String substr = s.substring(i, j + 1);
                    int middle = s.substring(i, j + 1).length() / 2;
                    if (s.substring(i, j + 1).length() % 2 != 0 && substr.substring(0, middle).equalsIgnoreCase(substr.substring(middle+1))) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String s = scanner.next();

        System.out.println(subStrCount(n, s));
    }
}
