package codingninjas.lecture7.linkedlist1;

public class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        next = null;
    }
}
