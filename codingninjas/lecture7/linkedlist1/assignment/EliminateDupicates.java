package codingninjas.lecture7.linkedlist1.assignment;

public class EliminateDupicates {
    public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> temp = head;
        while (temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
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
        LinkedListNode<Integer> ll3 = new LinkedListNode<>(2);
        ll2.next = ll3;
        LinkedListNode<Integer> ll4 = new LinkedListNode<>(3);
        ll3.next = ll4;
        LinkedListNode<Integer> ll5 = new LinkedListNode<>(3);
        ll4.next = ll5;
        LinkedListNode<Integer> ll6 = new LinkedListNode<>(6);
        ll5.next = ll6;

        print(ll1);
        print(removeDuplicates(ll1));
    }
}
