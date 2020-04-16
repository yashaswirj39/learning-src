package codingninjas.lecture9.stackandqueues;

import java.util.Arrays;

public class StackUsingArray {
    private int data[];
    private int top;

    public StackUsingArray() {
        this.data = new int[10];
        this.top = -1;
    }

    public StackUsingArray(int capacity) {
        this.data = new int[capacity];
        this.top = -1;
    }

    private void doubleCapacity() {
        int[] temp = this.data;
        this.data = new int[this.data.length * 2];
        for (int i = 0; i <= this.top; i++) {
            this.data[i] = temp[i];
        }
    }

    public void push(int elem) {
        if (this.size() == data.length) {
            doubleCapacity();
        }
        top++;
        this.data[top] = elem;
    }

    public int pop() {
        if (this.top != -1) {
            int data = this.data[this.top];
            this.data[this.top] = 0;
            top--;
            return data;
        } else throw new
                RuntimeException("Stack underflow");
    }

    public boolean isEmpty() {
        return (this.top == -1);
    }

    public int size() {
        return this.top + 1;
    }

    public int peek() {
        if (this.top != -1)
            return this.data[this.top];
        else throw new RuntimeException("stack is Empty");
    }

    @Override
    public String toString() {
        return "StackUsingArray{" +
                "data=" + Arrays.toString(data) +
                ", top=" + top +
                '}';
    }
}
