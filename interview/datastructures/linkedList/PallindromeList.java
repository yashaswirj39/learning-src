package interview.datastructures.linkedList;

import java.util.Scanner;

public class PallindromeList {
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

    public int getSize (Node A) {
        int count = 0;
        while (A!=null) {
            count++;
            A=A.next;
        }
        return count;
    }

    public int lPalin(Node A) {
        if (getSize(A) == 2) {
            if (A.data == A.next.data)
                return 1;
            else return 0;
        }

        if (getSize(A) == 3) {
            if (A.data == A.next.next.data) {
                return 1;
            } else return 0;
        }
        int i =0;
        int size = getSize(A);
        if (size % 2 != 0) {
            Node original = A;
            int mid = size / 2;
            while (A != null && mid-- > 0) {
                A = A.next;
            }
            Node temp = reverseList(A.next);
            while (temp != null && original != null) {
                if (temp.data == original.data) {
                    i = 1;
                } else {
                    i = 0;
                    break;
                }
                temp = temp.next;
                original = original.next;
            }
        } else {
            Node original = A;
            int mid = size / 2;
            while (A != null && mid-- > 0) {
                A = A.next;
            }
            Node temp = reverseList(A);
            while (temp != null && original != null) {
                if (temp.data == original.data) {
                    i = 1;
                } else {
                    i = 0;
                    break;
                }
                temp = temp.next;
                original = original.next;
            }
        }
        return i;
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

    public void print(Node node) {
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PallindromeList pl = new PallindromeList();
        for (int i = 0; i < n; i++) {
            pl.add(sc.nextInt());
        }
        System.out.println(pl.lPalin(pl.head));
    }
}