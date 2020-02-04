package interview.datastructures.strings;

import java.util.Scanner;

/**
 * @testcase-1:
 * 8
 * m n o n o p o o
 * @testcase-2:
 * 5
 * a s a s d
 * @testcase-3:
 *
 */
public class SpecialStringAgain {
    private static int result(StringBuilder sb) {
        int sum = sb.length();

        for (int i = 0; i < sb.length() - 1; i++) {
            for (int j = i+1; j < sb.length(); j++) {
                StringBuilder temp = new StringBuilder();
                temp.append(sb.substring(i, j+1));
                int length = temp.length()/2;
                if (temp.substring(0, length).equalsIgnoreCase(temp.substring(length+1))) {
                    sum++;
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            sb.append(sc.next());
        }
        System.out.println(result(sb));
    }
}
