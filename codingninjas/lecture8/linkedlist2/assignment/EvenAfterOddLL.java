package codingninjas.lecture8.linkedlist2.assignment;

import codingninjas.lecture8.linkedlist2.assignment.node.LinkedListNode;

import java.util.Scanner;

public class EvenAfterOddLL<T> {

    LinkedListNode<T> head;
    LinkedListNode<T> tail;

    public static LinkedListNode<Integer> sortEvenOdd(LinkedListNode<Integer> head1) {
        EvenAfterOddLL<Integer> odd = new EvenAfterOddLL<>();
        EvenAfterOddLL<Integer> even = new EvenAfterOddLL<>();
        LinkedListNode<Integer> oddEnd = null;

        while(head1 != null) {
            if (head1.data % 2 == 0) {
                even.add(head1.data);
            } else {
                oddEnd = odd.add(head1.data);
            }
            head1 = head1.next;
        }

        if (oddEnd != null) {
            oddEnd.next = even.head;
            return odd.head;
        } else {
            return even.head;
        }
    }

    public LinkedListNode<T> add(T data) {
        LinkedListNode<T> node = new LinkedListNode<>(data);

        if (head == null) {
            head = node;
            tail = head;
            return tail;
        } else if (head.next == null) {
            head.next = node;
            tail = head.next;
            return tail;
        } else {
            tail.next = node;
            tail = tail.next;
            return tail;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = 5;

        LLContains<Integer> ll = new LLContains<>();
        for (int i = 0; i < size; i++) {
            ll.add(sc.nextInt());
        }

        ll.print(ll.head);
        System.out.println("after sorting");
        ll.print(sortEvenOdd(ll.head));
    }
}
