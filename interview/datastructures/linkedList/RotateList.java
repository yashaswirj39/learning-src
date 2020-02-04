package interview.datastructures.linkedList;

import java.util.Scanner;

public class RotateList {
    ListNode head;
    ListNode tail;

    private static class ListNode {
        ListNode next;
        int val;

        public ListNode(int data) {
            this.val = data;
        }
    }

    public void add(int data) {
        ListNode node = new ListNode(data);

        if (head == null) {
            head = node;
            return;
        } else if(head.next == null) {
            head.next = node;
            tail = head.next;
            return;
        } else {
            tail.next = node;
            tail = tail.next;
        }
    }

    public void printList(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public int size(ListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    public ListNode rotateList(ListNode A, int B) {
        if (A.next == null) return A;
        if (B < size(A)) {
            ListNode fast = A;
            for (int i = 0; i < B; i++) {
                fast = fast.next;
            }
            ListNode slow = A;
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = A;
            A = slow.next;
            slow.next = null;
            return A;
        } else if (B > size(A)) {
            int num = B % size(A);
            ListNode fast = A;
            for (int i = 0; i < num; i++) {
                fast = fast.next;
            }
            ListNode slow = A;
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = A;
            A = slow.next;
            slow.next = null;
            return A;
        } else {
            return A;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = sc.nextInt();
        RotateList rl = new RotateList();
        for (int i = 0; i < n; i++) {
            rl.add(sc.nextInt());
        }
        ListNode temp = rl.rotateList(rl.head, num);
        rl.printList(temp);
    }
}