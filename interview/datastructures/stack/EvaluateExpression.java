package interview.datastructures.stack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Reverse polish notation
 */
public class EvaluateExpression {
    public static int evalRPN(ArrayList<String> A) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i).equalsIgnoreCase("+")) {
                stack.push(performOpertion(stack, "+"));
            } else if (A.get(i).equalsIgnoreCase("*")) {
                stack.push(performOpertion(stack, "*"));
            } else if (A.get(i).equalsIgnoreCase("-")) {
                stack.push(performOpertion(stack, "-"));
            } else if (A.get(i).equalsIgnoreCase("/")) {
                stack.push(performOpertion(stack, "/"));
            } else {
                stack.push(Integer.valueOf(A.get(i)));
            }
        }
        return stack.peek();
    }

    public static int performOpertion(Stack<Integer> stack, String operator) {
        int result = 0;
        switch (operator) {
            case "+":
                int add1 = stack.pop();
                int add2 = stack.pop();
                result = add1 + add2;
                break;
            case "*":
                int mul1 = stack.pop();
                int mul2 = stack.pop();
                result = mul1 * mul2;
                break;
            case "-":
                int sub1 = stack.pop();
                int sub2 = stack.pop();
                result = sub2 - sub1;
                break;
            case "/":
                int div1 = Math.abs(stack.pop());
                int div2 = Math.abs(stack.pop());
                result = div2 / div1;
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(sc.next());
        }
        System.out.println(evalRPN(al));
    }
}
