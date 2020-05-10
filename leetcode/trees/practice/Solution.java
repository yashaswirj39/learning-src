package leetcode.trees.practice;

import java.util.LinkedList;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            sol.add(sc.nextInt());
        }
        printList(sol.head);
        System.out.println("======================");
        ConvertSortedArrayToBinarySearchTree.printTree(sortedListToBST(sol.head));
    }

    ListNode head;
    ListNode tail;

    public void add(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
            tail = head;
        } else {
            tail.next = node;
            tail = tail.next;
        }
    }

    public static LinkedList addInLL(ListNode node) {
        LinkedList<Integer> list = new LinkedList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return list;
    }

    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return new TreeNode(head.val);
        }

        LinkedList<Integer> list = addInLL(head);

        return sortedListToBSTHelper(list, 0, list.size() - 1);
    }

    public static TreeNode sortedListToBSTHelper(LinkedList<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode current = new TreeNode(list.get(mid));
        current.left = sortedListToBSTHelper(list, start, mid - 1);
        current.right = sortedListToBSTHelper(list, mid + 1, end);
        return current;
    }

    public static ListNode mid(ListNode node) {
        ListNode sp = node;
        ListNode fp = node;
        while (fp.next != null && fp.next.next != null) {
            sp = sp.next;
            fp = fp.next.next;
        }

        if (fp.next != null) {
            return sp;
        } else {
            return sp;
        }
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
