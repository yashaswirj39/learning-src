package recursion.linkedlist;

import java.util.Scanner;

public class ReverseList {
    Node head;
    Node tail;

    Node headNew;
    Node tailNew;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
    }

    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public Node reverse(Node head) {
        if (head == null || head.next == null)
            return head;

        /* reverse the rest list and put
        the first element at the end */
        Node rest = reverse(head.next);
        System.out.println("==================================");
        System.out.println("<Returned head from stack>");
        printList(head);
        System.out.println("\n==================================");

        head.next.next = head;

        /* tricky step -- see the diagram */
        head.next = null;

        /* fix the head pointer */
        return rest;
    }

    public Node delete(Node head, int val) {
        if (head != null && head.next != null && head.next.data == val) {
            head.next = head.next.next;
            return head;
        }

        delete(head.next, val);
        System.out.println("------------------------");
        printList(head);
        System.out.println("\n------------------------");
        return head;
    }

    public int length(Node node) {
        if (node.next == null) {
            return 1;
        }
        return 1 + length(node.next);
    }

    public static void main(String[] args) {
        ReverseList rl = new ReverseList();
        Scanner s = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            rl.add(s.nextInt());
        }

        rl.printList(rl.head);
        Node rev = rl.reverse(rl.head);
        rl.printList(rev);
        /*System.out.println("===========");
        Node deleted = rl.delete(rl.head, 5);
        rl.printList(deleted);*/
        /*int len = rl.length(rl.head);
        System.out.println(len);*/
    }
}