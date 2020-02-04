package interview.datastructures.linkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    ListNode head;
    ListNode tail;

    private static class ListNode {
        ListNode next;
        int val;

        public ListNode(int data) {
            this.val = data;
        }
    }

    private void add(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            tail = head;
            return;
        } else if (head.next == null) {
            head.next = node;
            tail = head.next;
            return;
        } else {
            tail.next = node;
            tail = tail.next;
            return;
        }
    }

    private void printList(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    private ListNode partition(ListNode node, int nodeValue) {
        ListNode original = node;
        ListNode prev = findPrevNode(node, nodeValue);
        ListNode nextNode = prev.next;
        prev.next = null;
        ListNode smaller = getSmaller(nextNode);
        prev.next = smaller;
        ListNode rsl = sortList(original);
        ListNode ori = rsl;
        while (rsl.next != null) {
            rsl = rsl.next;
        }
        rsl.next = nextNode;
        return ori;
    }

    public ListNode getSmaller(ListNode node) {
        Solution pl = new Solution();
        int val = node.val;
        while (node.next != null) {
            if (node.next.val <= val) {
                pl.add(node.next.val);
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return pl.head;
    }

    private ListNode sortList(ListNode node) {
        ArrayList<Integer> al = new ArrayList<>();
        while (node != null) {
            al.add(node.val);
            node = node.next;
        }
        Collections.sort(al);
        Solution pl = new Solution();
        for (int i = 0; i < al.size(); i++) {
            pl.add(al.get(i));
        }
        return pl.head;
    }

    private ListNode findPrevNode(ListNode node, int value) {
        ListNode prev = null;
        while (node != null && node.val != value) {
            prev = node;
            node = node.next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Solution pl = new Solution();
        for (int i = 0; i < n; i++) {
            pl.add(sc.nextInt());
        }
        //System.out.println(pl.findPrevNode(pl.head, 3).val);
        pl.printList(pl.partition(pl.head, m));
    }
}
