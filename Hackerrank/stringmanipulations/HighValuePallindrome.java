package Hackerrank.stringmanipulations;

import java.util.Scanner;

public class HighValuePallindrome {

    private static String hvp(String str, int n, int k) {
        if (str.length() == 1 && str.charAt(0) != '9'){
            return "9";
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        int l = str.length() - 1;
        int i = 0;
        while (k > 0 && i < (str.length() / 2)) {
            if (str.charAt(i) != str.charAt(l)) {
                if (str.charAt(i) == '9') {
                    stringBuilder.setCharAt(l, '9');
                    k--;
                } else if (str.charAt(i) == '9') {
                    stringBuilder.setCharAt(i, '9');
                    k--;
                } else {
                    stringBuilder.setCharAt(i, '9');
                    stringBuilder.setCharAt(l, '9');
                    k = k-2;
                }
            }
            i++;
            l--;
        }

        int j = 0;
        int len = str.length() - 1;

        while (k > 0 && j < (str.length() / 2)){
            if (str.charAt(j) == str.charAt(len) && str.charAt(j) != '9'){
                stringBuilder.setCharAt(j, '9');
                stringBuilder.setCharAt(len, '9');
                k-=2;
            }
            j++;
            len--;
        }
        System.out.println(stringBuilder.length());
        String longestPallindrome = stringBuilder.toString();
        //System.out.println("longest pallindrome --> "+longestPallindrome);
        String reverseString = stringBuilder.reverse().toString();
        //System.out.println("longest pallindrome --> "+reverseString);
        if (longestPallindrome.equalsIgnoreCase(reverseString)){
            return longestPallindrome;
        } else {
            return String.valueOf(-1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int times = scanner.nextInt();
        String str = scanner.next();
        System.out.println(hvp(str, n, times));
    }
}
