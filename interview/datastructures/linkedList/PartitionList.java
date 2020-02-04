package interview.datastructures.linkedList;

import java.util.Scanner;

public class PartitionList {
    ListNode head;
    ListNode tail;

    private static class ListNode {
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
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

    public ListNode partition(ListNode A, int B) {
        ListNode hello= new ListNode(-1);
        ListNode first= hello;
        ListNode hi= new ListNode(-1);
        ListNode second= hi;
        ListNode temp= A;
        while(temp!=null){
            if(temp.val<B){
                first.next= temp;
                first=first.next;
            }
            else{
                second.next= temp;
                second=second.next;
            }
            temp=temp.next;
        }
        second.next=null;
        first.next= hi.next;
        return hello.next;
    }

    private void printList(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        PartitionList pl = new PartitionList();
        for (int i = 0; i < n; i++) {
            pl.add(sc.nextInt());
        }
        //System.out.println(pl.findPrevNode(pl.head, 3).val);
        pl.printList(pl.partition(pl.head, m));
    }
}
