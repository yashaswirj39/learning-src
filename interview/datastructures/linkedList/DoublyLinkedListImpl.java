package interview.datastructures.linkedList;

import java.util.Scanner;

public class DoublyLinkedListImpl {
    Node head;

    private static class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node getNewNode(int x) {
        Node node = new Node(x);
        node.prev = null;
        node.next = null;
        return node;
    }

    public void insertAtHead(int x) {
        Node node = getNewNode(x);
        if (head == null) {
            head = node;
            return;
        }
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        n.next = node;
        node.prev = n;
    }

    public void printForward(Node node) {
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public void printReverse(Node node) {
        while (node.next != null) {
            node = node.next;
        }
        while (node != null) {
            System.out.println(node.data);
            node = node.prev;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedListImpl dbl = new DoublyLinkedListImpl();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            dbl.insertAtHead(sc.nextInt());
        }
        System.out.println("print forward....");
        dbl.printForward(dbl.head);
        System.out.println("print reverse....");
        dbl.printReverse(dbl.head);
    }
}
