package interview.datastructures.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * @testcase - 1
 * )(
 * @testcase - 2
 * [(])
 * @testcase - 3
 * [()()]
 */
public class BalancedParenthesis {
    private static boolean checkBalancedParenthesis(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c: str.toCharArray()) {
            if (c == '{' || c == '[' || c == '(')
                stack.push(c);
            else if (c == '}' || c == ']' || c == ')')
                if (stack.isEmpty())
                    return false;
                else if (c == ')' && stack.peek() != '(' ||
                c == ']' && stack.peek() != '[' ||
                c == '}' && stack.peek() != '{')
                    return false;
                else
                    stack.pop();
        }
        return stack.isEmpty() ? true : false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(checkBalancedParenthesis(str));
    }
}
