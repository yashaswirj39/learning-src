package leetcode.doublylinkedlist;

import java.util.Scanner;

public class Insert {
    ListNode head;
    ListNode tail;

    public void add(int data) {
        ListNode node = new ListNode(data);

        if (head == null) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            tail.next.prev = tail;
            tail = tail.next;
        }
    }

    public void printForward(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public void printBackWard(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Insert insert = new Insert();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            insert.add(sc.nextInt());
        }
        insert.printForward(insert.head);
        insert.printBackWard(insert.tail);
    }
}