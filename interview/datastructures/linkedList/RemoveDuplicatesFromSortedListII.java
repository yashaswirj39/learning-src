package interview.datastructures.linkedList;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicatesFromSortedListII {
    private Node head;
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
        HashSet<Integer> duplicates = new HashSet<>();
        if (A == null) return null;
        if (A.next == null) return A;
        Node original = A;
        Node res = null;
        Node finalNode = null;
        try {
            while (A.next != null) {
                if (A.data == A.next.data) {
                    duplicates.add(A.data);
                }
                A = A.next;
            }
            while (original != null) {
                if (duplicates.contains(original.data)) {
                    Node temp = original.next;
                    original = temp;
                } else {
                    if (res == null) {
                        res = original;
                        finalNode = res;
                    } else {
                        res.next = original;
                        res = res.next;
                    }
                    original = original.next;
                }
            }
            return removeIfRepeatedLastNode(finalNode);//removeIfRepeatedLastNode(res);
        } catch(Exception e) {
            return removeIfRepeatedLastNode(finalNode);
        }
    }

    public static Node removeIfRepeatedLastNode(Node node) {
        int count = 1;
        Node orig = null;
        if (count == 1) {
            orig = node;
            count++;
        }
        while (node != null && node.next != null && node.next.next != null) {
            if (node.next.data == node.next.next.data) {
                node.next = null;
                break;
            } else {
                node = node.next;
            }
        }
        return orig;
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
        RemoveDuplicatesFromSortedListII rdsl = new RemoveDuplicatesFromSortedListII();
        for (int i = 0; i < n; i++) {
            rdsl.add(sc.nextInt());
        }
        Node temp = rdsl.deleteDuplicates(rdsl.head);
        rdsl.print(temp);
    }
}