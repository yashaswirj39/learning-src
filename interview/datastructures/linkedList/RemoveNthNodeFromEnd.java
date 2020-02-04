package interview.datastructures.linkedList;

import linkedlistimplementation.List;

import java.util.Scanner;

public class RemoveNthNodeFromEnd {
    ListNode head;
    ListNode tailNode;
    int size = 0;

    private static class ListNode {
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public void add(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            size++;
            return;
        }
        if (head.next == null) {
            head.next = node;
            tailNode = head.next;
            size++;
        } else {
            tailNode.next = node;
            tailNode = tailNode.next;
            size++;
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

    public ListNode removeNthFromEnd(ListNode A, int B) {
        /*if (A.next == null) return null;
        if (A.next == null && B == 1) return null;
        if (B < size) {
            int nodeNum = size - B - 1;
            int count = 0;
            ListNode original = A;
            while (A != null && count != nodeNum) {
                A = A.next;
                count++;
            }
            A.next = A.next.next;
            return original;
        } else if (B > size) {
            int nodeNum = (B%size) - 1;
            int count = 0;
            ListNode original = A;
            while (A != null && count != nodeNum) {
                A = A.next;
                count++;
            }
            A.next = A.next.next;
            return original;
        } else {
            ListNode original = A;
            while (A != null && B-- > 2) {
                A = A.next;
            }
            A.next = A.next.next;
            return original;
        }*/
        /**
         * if B is greater than list size then iterate first pointer to till end and
         * return the list.next node as result
         *
         * If B is smaller than list size move fast pointer to nth node.
         * After that start iterating slow pointer from head and fast pointer from the nth node
         * till fast pointer next node becomes null.
         * Once fast pointer next node is null, slow pointer will be at prev position of the nth node.
         * Then slow next pointer to slow.next.next pointer.
         */
        ListNode fast = A;
        if( B <= 0 ) return A;
        if( A == null ) return A;
        for( int i = 0; i < B; i++ ){
            if( fast.next == null ) return A.next;
            fast = fast.next;
        }
        ListNode slow = A;
        while( fast.next != null ){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return A;
    }

    public void print (ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RemoveNthNodeFromEnd rm = new RemoveNthNodeFromEnd();
        int n = sc.nextInt();
        int num = sc.nextInt();
        for (int i = 0; i < n; i++) {
            rm.add(sc.nextInt());
        }
        ListNode node = rm.removeNthFromEnd(rm.head, num);
        rm.print(node);
    }
}
