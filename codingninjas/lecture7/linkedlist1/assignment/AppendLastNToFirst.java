package codingninjas.lecture7.linkedlist1.assignment;

class LinkedListNode<T> {
    public T data;
    public LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.setData(data);
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}

public class AppendLastNToFirst {

    private static int findLength(LinkedListNode<Integer> root) {
        int counter = 0;
        while (root != null) {
            counter++;
            root = root.next;
        }
        return counter;
    }

    public static LinkedListNode<Integer> append(LinkedListNode<Integer> root, int n) {
        if (n==0) {
            return root;
        }

        int move = findLength(root) - n;

        LinkedListNode<Integer> head1 = root;
        while (root != null && move > 1) {
            root = root.next;
            move--;
        }

        LinkedListNode<Integer> head2 = root.next;
        LinkedListNode<Integer> root1 = root.next;
        root.next = null;
        while (root1.next != null) {
            root1 = root1.next;
        }
        root1.next = head1;
        return head2;
    }

    public static void print(LinkedListNode<Integer> node) {
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> ll1 = new LinkedListNode<>(1);
        LinkedListNode<Integer> ll2 = new LinkedListNode<>(2);
        ll1.next = ll2;
        LinkedListNode<Integer> ll3 = new LinkedListNode<>(3);
        ll2.next = ll3;
        LinkedListNode<Integer> ll4 = new LinkedListNode<>(4);
        ll3.next = ll4;
        LinkedListNode<Integer> ll5 = new LinkedListNode<>(5);
        ll4.next = ll5;
        LinkedListNode<Integer> ll6 = new LinkedListNode<>(6);
        ll5.next = ll6;

        print(ll1);
        print(append(ll1, 0));
    }
}
