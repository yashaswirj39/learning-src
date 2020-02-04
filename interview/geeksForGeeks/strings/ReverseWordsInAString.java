package interview.geeksForGeeks.strings;

import java.util.Scanner;

public class ReverseWordsInAString {
    private static String reverseWords(String str) {
        String[] res = str.split("\\.");
        String result = "";
        for (int i = res.length - 1; i >= 0 ; i--) {
            if (i != 0) {
                result += res[i];
                result += ".";
            } else {
                result += res[i];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            String s = sc.next();
            System.out.println(reverseWords(s));
        }
    }
}
