package codingninjas.lecture3.recursionbasics.arrayrecursion;

import java.util.Scanner;

public class CheckPallindrome {
    private static boolean checkPallindrome(String input) {
        if (input.length() == 1) {
            return true;
        }
        return check(input, 0, input.length() - 1);
    }

    private static boolean check(String input, int startIndex, int lastIndex) {
        if(startIndex >= input.length()/2 && lastIndex <= input.length()/2) {
            return true;
        }
        if (input.charAt(startIndex) == input.charAt(lastIndex)) {
            return check(input, startIndex+1, lastIndex-1);
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(checkPallindrome(s));
    }
}
