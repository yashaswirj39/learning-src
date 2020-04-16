package codingninjas.lecture9.stackandqueues;

public class Node<T> {
    T data;
    codingninjas.lecture9.stackandqueues.Node<T> next;

    public Node(T data) {
        this.data = data;
        next = null;
    }
}
