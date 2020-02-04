package interview.datastructures.linkedList;

import java.util.Scanner;
import java.util.Stack;

public class ReverseLinkedListII {
    ListNode head;
    ListNode tail;
    int size = 0;

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

    private static class ListNode {
        ListNode next;
        int data;

        public ListNode(int data) {
            this.data = data;
        }
    }

    private ListNode reverse(ListNode A, int B, int C) {
        if (B == 1) {
            ListNode temp = A;
            ListNode end = null;
            while (A != null && B != C) {
                A = A.next;
                B++;
            }
            end = A.next;
            A.next = null;
            temp = reverseList(temp);
            ListNode ori = temp;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = end;
            return ori;
        } else {
            ListNode original = A;
            ListNode start = findStart(A, B);
            ListNode end = findEnd(A, C);
            ListNode revStart = start.next;
            start.next = null;
            ListNode finalEnd = end.next;
            end.next = null;
            ListNode reversed = reverseList(revStart);
            start.next = reversed;
            while (start.next != null) {
                start = start.next;
            }
            start.next = finalEnd;
            return original;
        }
    }

    public ListNode reverseList(ListNode A) {
        ListNode curr = A;
        ListNode prev = null;
        while (curr != null) {
            curr = A.next;
            A.next = prev;
            prev = A;
            A = curr;
        }
        return prev;
    }

    public ListNode findStart(ListNode node, int m) {
        int count = 1;
        while (node != null && count != m - 1) {
            count++;
            node = node.next;
        }
        return node;
    }

    public ListNode findEnd(ListNode node, int n) {
        int count = 1;
        while (node != null && count != n) {
            count++;
            node = node.next;
        }
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
        int size = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        ReverseLinkedListII rll = new ReverseLinkedListII();
        for (int i = 0; i < size; i++) {
            rll.add(sc.nextInt());
        }
        rll.print(rll.reverse(rll.head, n, m));
    }
}