package leetcode.pickone;

public class PallindromeLinkedList {
    public static boolean isPallindrome(ListNode node) {
        if (node == null) return false;

        if (node.next == null) return true;

        boolean flag = false;
        LinkedListUtility llu = new LinkedListUtility();
        int size = llu.size(node);
        ListNode reversePointer = node;
        ListNode secondHead = null;
        int counter = 0;
        int count = size / 2;
        if (size % 2 != 0) {
            while (counter < count - 1) {
                reversePointer = reversePointer.next;
                counter++;
            }
            secondHead = reversePointer.next.next;
            reversePointer.next = null;
            ListNode firstHead = llu.reverse(node);
            while (firstHead != null && secondHead != null) {
                if (firstHead.val == secondHead.val) {
                    flag = true;
                    firstHead = firstHead.next;
                    secondHead = secondHead.next;
                } else {
                    flag = false;
                    break;
                }
            }
        } else {
            while (counter < count - 1) {
                reversePointer = reversePointer.next;
                counter++;
            }
            secondHead = reversePointer.next;
            reversePointer.next = null;
            ListNode firstHead = llu.reverse(node);
            while (firstHead != null && secondHead != null) {
                if (firstHead.val == secondHead.val) {
                    flag = true;
                    firstHead = firstHead.next;
                    secondHead = secondHead.next;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}
