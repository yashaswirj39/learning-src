package interview.datastructures.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 7
 * 98
 * 23
 * 54
 * 12
 * 20
 * 7
 * 27
 */

public class NextGreaterElements {

    private static void push(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty() || arr[i] < stack.peek()) {
                stack.push(arr[i]);
            } else {
                while (arr[i] > stack.peek()) {
                    int topElem = stack.pop();
                    System.out.println("Next greater element for " + topElem + " is " + arr[i]);
                }
                stack.push(arr[i]);
            }
        }
        while (!stack.isEmpty()) {
            System.out.println("Next greater element for " + stack.pop() + " is null");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        push(arr);
    }
}
