package codingninjas.lecture8.linkedlist2.assignment;

import codingninjas.lecture8.linkedlist2.assignment.node.LinkedListNode;

import java.util.Scanner;

public class DeleteEveryNNodes<T> {
    LinkedListNode<T> head;
    LinkedListNode<T> tail;

    public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int M, int N) {
        LinkedListNode<Integer> temp = head;
        while (temp != null) {
            int mcounter = M;
            int ncounter = N;

            while (temp != null && mcounter > 1) {
                temp = temp.next;
                mcounter--;
            }
            LinkedListNode<Integer> mtemp = temp;
            temp = temp.next;
            while (temp != null && ncounter > 1) {
                temp = temp.next;
                ncounter--;
            }
            LinkedListNode<Integer> ntemp = temp;
            if (ntemp != null) {
                mtemp.next = ntemp.next;
                temp = temp.next;
            } else {
                mtemp.next = null;
            }
        }
        return head;
    }

    public static LinkedListNode<Integer> skipM(LinkedListNode<Integer> M, int MSize) {
        while (M != null && MSize > 1) {
            M = M.next;
            MSize--;
        }
        return M;
    }

    public void add(T data) {
        LinkedListNode<T> node = new LinkedListNode<>(data);

        if (head == null) {
            head = node;
            tail = head;
        } else if (head.next == null) {
            head.next = node;
            tail = head.next;
        } else {
            tail.next = node;
            tail = tail.next;
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

        int m = sc.nextInt();
        int n = sc.nextInt();

        ll.print(ll.head);
        System.out.println("--------------------------");
        ll.print(skipMdeleteN(ll.head, m, n));
    }
}