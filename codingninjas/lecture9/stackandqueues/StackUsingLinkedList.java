package codingninjas.lecture9.stackandqueues;

import java.util.Stack;

public class StackUsingLinkedList<T> {
    private Node<T> head;
    private int size;

    public void push(T elem) {
        Node<T> node = new Node<>(elem);

        node.next = head;
        head = node;
        size++;
        return;
    }

    public T pop() {
        T tempData = head.data;
        head = head.next;
        size--;
        return tempData;
    }

    public void print(Node<T> node) {
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public int size() {
        return size;
    }

    public T top() throws StackEmptyException {
        if (size == 0) {
            throw new StackEmptyException();
        }
        return head.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) throws StackEmptyException {
        /*StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        stack.print(stack.head);
        System.out.println("size " + stack.size());
        System.out.println("top " + stack.top());

        System.out.println("popping out the data");
        stack.pop();
        stack.pop();

        System.out.println("================================");
        stack.print(stack.head);
        System.out.println("size " + stack.size());
        System.out.println("top " + stack.top());*/
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        System.out.println("============");
        Stack<Integer> stack1 = new Stack<>();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            stack1.add(i, stack.pop());
        }
        System.out.println(stack1);
    }
}
