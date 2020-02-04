package interview.datastructures.linkedList;

import datastructures.linkedlist.Node;
import node.Listnode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ReorderList {
    ListNode head;
    ListNode tail;
    int size = 0;

    private static class ListNode {
        ListNode next;
        int data;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public void add(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            size++;
            return;
        } else if (head.next == null) {
            head.next = node;
            tail = head.next;
            size++;
            return;
        } else {
            tail.next = node;
            tail = tail.next;
            size++;
            return;
        }
    }

    /**
     * Linear way to reorder list
     *
     * @param A
     * @return
     */
    public ListNode reorder(ListNode A) {
        if (A.next == null || A.next.next == null) return A;
        ListNode original = A;
        ListNode temp = null;
        ListNode prev = null;
        try {
            while (A.next != null) {
                temp = A.next;
                A.next = fetchLastNode(original);
                A = A.next;
                if (temp.next != null)
                    A.next = temp;
                prev = A;
                A = A.next;
            }
            return original;
        } catch (Exception e) {
            if (prev.data != temp.data) {
                prev.next = temp;
            }
        }
        return original;
    }

    public ListNode reorderList(ListNode A) {
        Deque<Integer> dq = new ArrayDeque<>();
        ListNode temp = A;
        while (temp != null) {
            dq.addLast(temp.data);
            temp = temp.next;
        }
        temp = A;
        int i = 0;
        while (!dq.isEmpty()) {
            if (i % 2 == 0)
                temp.data = dq.removeFirst();
            else
                temp.data = dq.removeLast();
            i++;
            temp = temp.next;
        }
        return A;
    }

    public ListNode fetchLastNode(ListNode node) {
        ListNode prev = null;
        while (node.next != null) {
            prev = node;
            node = node.next;
        }
        prev.next = null;
        return node;
    }

    public void print(ListNode node) {
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ReorderList rl = new ReorderList();
        for (int i = 0; i < n; i++) {
            rl.add(sc.nextInt());
        }
        //rl.print(rl.reorder(rl.head));
        rl.print(rl.reorderList(rl.head));
    }
}