package codingninjas.lecture8.linkedlist2.assignment;

import codingninjas.lecture8.linkedlist2.assignment.node.LinkedListNode;

import java.util.Scanner;

public class LLContains<T> {
    LinkedListNode<T> head;
    LinkedListNode<T> tail;

    public static int indexOfNRec(LinkedListNode<Integer> head, int n) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */

        if (head == null) {
            return -1;
        } else {
            if (head.data.equals(n)) {
                head.next = null;
                return indexOfNRec(head.next, n) + 1;
            } else {
                return indexOfNRec(head.next, n) + 1;
            }
        }

        /*int counter = 0;
        while(head != null) {
            if(head.data.equals(n)) {
                break;
            } else {
                counter++;
            }
        }
        return counter;*/
    }

    public void add(T data) {
        LinkedListNode<T> node = new LinkedListNode<>(data);

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

    public void print(LinkedListNode<T> node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please provide the size of linked list: ");
        int size = sc.nextInt();

        LLContains<Integer> ll = new LLContains<>();
        for (int i = 0; i < size; i++) {
            ll.add(sc.nextInt());
        }

        ll.print(ll.head);
        System.out.println("\n" + indexOfNRec(ll.head, 5));
    }
}