package leetcode.pickone;

public class LinkedListUtility {
    ListNode head;
    ListNode tail;

    public void add(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
            tail = head;
        } else {
            tail.next = node;
            tail = tail.next;
        }
    }

    public ListNode mid(ListNode node) {
        ListNode sp = node;
        ListNode fp = node;

        while (fp.next != null && fp.next.next != null) {
            sp = sp.next;
            fp = fp.next.next;
        }

        if (fp.next == null)
            return sp;
        else return sp.next;
    }

    public int size(ListNode node) {
        int counter = 0;
        while (node != null) {
            counter++;
            node = node.next;
        }
        return counter;
    }

    @Override
    public String toString() {
        ListNode node = head;
        String str = "[";
        while (node.next != null) {
            str += node.val;
            str += ", ";
            node = node.next;
        }
        str += node.val + "]";
        return str;
    }

    public ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        ListNode temp = null;

        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
