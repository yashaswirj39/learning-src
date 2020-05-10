package leetcode.thirtydaychallenge.week3;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3301/
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
 *
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 * Example 1:
 * Input: "()"
 * Output: True
 * Example 2:
 * Input: "(*)"
 * Output: True
 * Example 3:
 * Input: "(*))"
 * Output: True
 */

public class ValidParenthesis {

    private static boolean isValid(String s) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack1.push(i);
            } else if (c == '*') {
                stack2.push(i);
            } else if (c == ')') {
                if (stack1.isEmpty() && stack2.isEmpty()) return false;
                else if (!stack1.isEmpty()){
                    stack1.pop();
                } else if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            }
        }

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int elem_one = stack1.pop();
            int elem_two = stack2.pop();
            if (elem_one < elem_two) {
                continue;
            } else {
                stack1.push(elem_one);
                stack2.push(elem_two);
                break;
            }
        }

        if (stack1.isEmpty() && stack2.isEmpty()) {
            return true;
        } else if (stack1.isEmpty() && !stack2.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(isValid(s));
    }
}