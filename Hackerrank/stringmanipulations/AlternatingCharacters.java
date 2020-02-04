package Hackerrank.stringmanipulations;

import java.util.Scanner;

public class AlternatingCharacters {

    private static int alternatingChar(String s) {
        char[] c = s.toCharArray();
        StringBuffer sb = new StringBuffer(s);
        int count = 0;
        for (int i = 0; i < c.length; i++) {
            if (i < c.length - 1) {
                if (c[i] == c[i + 1]) {
                    sb.setCharAt(i, '#');
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();

        for (int i = 0; i < length; i++) {
            System.out.println(alternatingChar(scanner.next()));
        }
    }
}
