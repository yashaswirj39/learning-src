package interview.datastructures.linkedList;

import java.util.Scanner;

public class ReverseList {
    Node head;
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
            return;
        }
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        n.next = node;
    }

    public Node reverseList(Node A) {
        Node curr = A;
        Node prev = null;
        while (curr != null) {
            curr = A.next;
            A.next = prev;
            prev = A;
            A = curr;
        }
        return prev;
    }

    public void print(Node A) {
        while (A != null) {
            System.out.println(A.data);
            A = A.next;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ReverseList rl = new ReverseList();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            rl.add(sc.nextInt());
        }
        rl.print(rl.head);
        System.out.println("After reversing");
        Node node = rl.reverseList(rl.head);
        rl.print(node);
    }
}
