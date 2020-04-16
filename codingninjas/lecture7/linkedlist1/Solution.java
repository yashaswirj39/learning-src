package codingninjas.lecture7.linkedlist1;


 class LinkedListNode<T> {
 T data;
 LinkedListNode<T> next;

 public LinkedListNode(T data) {
 this.data = data;
 }
 }

public class Solution<T> {

    LinkedListNode<T> head;
    LinkedListNode<T> tail;
    public static LinkedListNode<Integer> mergeTwoList(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        Solution list = null;
        while(head1 != null && head2 != null) {
            if(head1.data < head2.data) {
                list.add(head1.data);
                head1 = head1.next;
            } else if(head1.data > head2.data) {
                list.add(head2.data);
                head2 = head2.next;
            } else if(head1.data < head2.data) {
                list.add(head1.data);
                list.add(head2.data);
                head1 = head1.next;
                head2 = head2.next;
            }
        }

        while(head1 != null) {
            list.add(head1.data);
            head1 = head1.next;
        }

        while(head2 != null) {
            list.add(head2.data);
            head2 = head2.next;
        }
        return list.head;
    }

    public void add(T data) {
        LinkedListNode<T> node = new LinkedListNode<>(data);
        if(head == null) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            tail = tail.next;
        }
    }
}