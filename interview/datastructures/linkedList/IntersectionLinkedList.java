package interview.datastructures.linkedList;

import java.util.Scanner;

public class IntersectionLinkedList {
    Node head;
    static int size;

    private static class Node {
        int data;
        Node next;

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

    public int findLength(Node node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    public Node intersectList(Node a, Node b) {
        int lengthA = findLength(a);
        int lengthB = findLength(b);

        int diff = Math.abs(lengthA - lengthB);

        if (lengthA > lengthB) {
            while (diff-- > 0) {
                a = a.next;
            }
        }

        if (lengthA < lengthB) {
            while (diff-- > 0) {
                b = b.next;
            }
        }

        while (a != null && b != null) {
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }
}
