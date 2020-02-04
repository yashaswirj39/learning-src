package interview.datastructures.linkedList;


import java.util.HashSet;
import java.util.Scanner;

public class ListCycle {
    ListNode head;

    private static class ListNode {
        ListNode next;
        int val;

        public ListNode(int data) {
            this.val = data;
        }
    }

    private void add(int data) {
        ListNode node = new ListNode(data);
        if (head == null){
            head = node;
            return;
        }
        ListNode n = head;
        while (n.next != null) {
            n = n.next;
        }
        n.next = node;
    }

    private void createCycle(ListNode node) {
        while (node.next != null) {
            node = node.next;
        }
        System.out.println("cycle created at: " + node.val);
        node.next = head.next;
    }

    /**
     * using two pointer floyd's formula.
     * @param a
     * @return
     */
    private ListNode detectCycle(ListNode a) {
        if (a == null) return null;
        ListNode sp = a;
        ListNode fp = a;
        while (sp != null && fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
            if (sp == fp) {
                return sp;
            }
        }
        return null;
    }

    private ListNode detectCycleUsingHs(ListNode a) {
        HashSet<ListNode> hs = new HashSet<>();
        while (a != null) {
            if (!hs.contains(a)) {
                hs.add(a);
            } else {
                return a;
            }
            a = a.next;
        }
        return null;
    }

    private void print(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListCycle lc = new ListCycle();
        for (int i = 0; i < n; i++) {
            lc.add(sc.nextInt());
        }
        lc.print(lc.head);
        lc.createCycle(lc.head);
        System.out.println(lc.detectCycle(lc.head).val);
    }
}