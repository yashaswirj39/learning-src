package interview.datastructures.stack;

import java.util.Scanner;
import java.util.Stack;

public class ReverseString {
    private static String reverse(String A) {
        if (A.isEmpty() || A.length() < 1) return A;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            stack.push(A.charAt(i));
        }
        A = "";
        while (!stack.isEmpty()) {
            A += stack.pop();
        }
        return A;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(reverse(str));
    }
}
