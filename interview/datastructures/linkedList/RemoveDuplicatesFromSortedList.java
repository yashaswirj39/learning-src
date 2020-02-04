package interview.datastructures.linkedList;

import java.util.Scanner;

public class RemoveDuplicatesFromSortedList {
    Node head;
    static int size;

    private static class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    public void add(int x) {
        Node node = new Node(x);
        if (head == null) {
            head = node;
            size++;
            return;
        }
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        n.next = node;
        size++;
    }

    public Node deleteDuplicates(Node A) {
        if (A == null) return null;
        if (A.next == null) return A;

        Node result = A;
        while (A.next != null) {
            if (A.data == A.next.data) {
                A.next = A.next.next;
            } else {
                A = A.next;
            }
        }
        return result;
    }

    public void print(Node node) {
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        RemoveDuplicatesFromSortedList rdsl = new RemoveDuplicatesFromSortedList();
        for (int i = 0; i < n; i++) {
            rdsl.add(sc.nextInt());
        }
        Node temp = rdsl.deleteDuplicates(rdsl.head);
        rdsl.print(temp);
    }
}
