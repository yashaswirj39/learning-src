package codingninjas.assignment_recursion1;

import java.util.Scanner;

public class PairStar {
    public static String addStars(String s) {
        // Write your code here
        if (s.length() > 0) {
            return add(s, 0);
        }
        return s;
    }

    private static String add(String s, int index) {
        if (index <= s.length() - 2) {
            if (s.charAt(index) == s.charAt(index + 1)) {
                String newString = s.charAt(index) + "" + s.charAt(index + 1);
                int newIndex = 0;
                return add(s.replaceAll(newString, newString.charAt(newIndex) + "*" + newString.charAt(newIndex + 1)), index + 1);
            } else {
                return add(s, index + 1);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(addStars(str));
    }
}
