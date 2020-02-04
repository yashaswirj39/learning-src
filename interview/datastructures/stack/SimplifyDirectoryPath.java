package interview.datastructures.stack;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class SimplifyDirectoryPath {

    private static String simplifyPath(String A) {
        /*if (A.equalsIgnoreCase("/../")) {
            return "/";
        }*/
        if (checkValidstart(A)) {
            StringBuilder sb = new StringBuilder();
            Stack<String> stack = new Stack<>();
            String[] arr = A.split("/");
            for (int i = 1; i < arr.length; i++) {
                if (arr[i].matches("^[a-zA-Z]*$")) {
                    stack.push(arr[i]);
                } else if (arr[i].equalsIgnoreCase(".")) {
                    continue;
                } else if (arr[i].equalsIgnoreCase("..") && !stack.isEmpty()) {
                    stack.pop();
                }
            }
            Collections.reverse(stack);
            while (!stack.isEmpty()) {
                String str = stack.pop();
                if (!str.trim().equalsIgnoreCase("") || !str.isEmpty()) {
                    sb.append("/").append(str);
                }
            }
            return sb.toString();
        } else return "";
    }

    private static boolean checkValidstart(String str) {
        if (str.charAt(0) == '/')
            return true;
        else return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(simplifyPath(str));
    }
}
