package interview.datastructures.linkedList;

import java.util.Scanner;

public class MergeTwoSortedList {
    ListNode head;
    ListNode tailNode;
    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public void add(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            return;
        }
        if (head.next == null) {
            head.next = node;
            tailNode = head.next;
        } else {
            tailNode.next = node;
            tailNode = tailNode.next;
        }
    }
    public void printList(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        if (A == null) return B;
        if (B == null) return A;
        MergeTwoSortedList mtsl = new MergeTwoSortedList();

        while (A != null && B != null) {
            if (A.val < B.val) {
                mtsl.add(A.val);
                A= A.next;
            } else if (A.val > B.val) {
                mtsl.add(B.val);
                B = B.next;
            } else {
                mtsl.add(A.val);
                mtsl.add(B.val);
                A = A.next;
                B = B.next;
            }
        }

        while (A != null) {
            mtsl.add(A.val);
            A = A.next;
        }

        while (B != null) {
            mtsl.add(B.val);
            B = B.next;
        }
        return mtsl.head;
    }

    public void print(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        MergeTwoSortedList mtsl1 = new MergeTwoSortedList();
        MergeTwoSortedList mtsl2 = new MergeTwoSortedList();
        MergeTwoSortedList mtsl3 = new MergeTwoSortedList();

        for (int i = 0; i < n; i++) {
            mtsl1.add(sc.nextInt());
        }
        for (int i = 0; i < m; i++) {
            mtsl2.add(sc.nextInt());
        }
        /*mtsl1.print(mtsl1.head);
        mtsl2.print(mtsl2.head);*/
        ListNode temp = mtsl3.mergeTwoLists(mtsl1.head, mtsl2.head);
        mtsl1.print(temp);
    }
}
