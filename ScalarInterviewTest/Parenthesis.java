package ScalarInterviewTest;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Parenthesis {
    private static ArrayList<Integer> balanced(String A) {
        if (A == "") {
            new ArrayList<>();
        }

        int start = 0;
        int end  = 0;

        ArrayList<Integer> al = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '(')
                stack.push('(');
            else if (A.charAt(i) == ')') {
                if (stack.isEmpty()){
                    start++;
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.size() == 1 && stack.pop() == '(') {
            end++;
        }
        al.add(start);
        al.add(end);
        return al;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(balanced(s));
    }
}
