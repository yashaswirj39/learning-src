package interview.datastructures.stack;

import java.util.Scanner;

public class MinStack {
    class TreeNode {
        int val;
        int min;
        TreeNode next;

        public TreeNode(int val) {
            this.val = val;
            this.min = val;
        }
    }

    TreeNode top;

    public void push(int data) {
        if (top == null) {
            top = new TreeNode(data);
        } else {
            TreeNode temp = new TreeNode(data);
            temp.next = top;
            temp.min = Math.min(top.min, data);
            top = temp;
        }
    }

    public int getMin() {
        if (top == null) {
            System.out.println("Stack empty");
            return Integer.MAX_VALUE;
        }
        return top.min;
    }

    public void pop() {
        if (top == null) {
            System.out.println("Stack empty");
            return;
        }
        top = top.next;
    }

    public int top() {
        if (top == null) {
            System.out.println("Stack empty");
            return Integer.MAX_VALUE;
        }
        return top.val;
    }

    public void printStack(TreeNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MinStack stck = new MinStack();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            stck.push(sc.nextInt());
        }
        stck.printStack(stck.top);
        System.out.println(stck.getMin());
        stck.pop();
        System.out.println(stck.getMin());
        stck.pop();
        System.out.println(stck.getMin());
        stck.pop();
        System.out.println(stck.getMin());
        stck.pop();
    }
}