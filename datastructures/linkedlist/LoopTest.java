package datastructures.linkedlist;

public class LoopTest<T> {

    public void createLoop(Node node) {
        Node head = node;
        while (node.next != null) {
            node = node.next;
        }
        System.out.println(node.data);
        node.next = head.next;
    }
}
