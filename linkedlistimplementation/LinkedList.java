package linkedlistimplementation;

import node.Listnode;

public class LinkedList implements List {
    public Listnode head;

    @java.lang.Override
    public void add(int data) {
        Listnode node = new Listnode(data);

        if (head == null) {
            head = node;
        } else {
            Listnode n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    @Override
    public Listnode listIntersection(Listnode l1, Listnode l2) {
        LinkedList linkedList = new LinkedList();
        while (l1 != null && l2 != null) {
            if (l1.var == l2.var) {
                linkedList.add(l1.var);
                l1 = l1.next;
                l2 = l2.next;
            }
            else if (l1.var < l2.var){
                l1 = l1.next;
            }
            else {
                l2 = l2.next;
            }
        }
        return linkedList.head;
    }

    @Override
    public void show(Listnode node) {
        String finalList = "[";
        while (node != null) {
            finalList += String.valueOf(node.var) + ",";
            node = node.next;
        }
        finalList+="]";
        //finalList = finalList.substring(0,finalList.lastIndexOf(",")) + "]";
        System.out.println(finalList);
    }

    @Override
    public boolean isPallindrome(Listnode l1) {

        Listnode fp = l1;
        Listnode sp = l1;

        while (fp != null && fp.next != null){
            fp = fp.next.next;
            sp = sp.next;
        }

        if (fp != null){
            sp = sp.next;
        }

        sp = reverse(sp);

        fp = l1;

        while (sp != null) {
            if (fp.var != sp.var) {
                return false;
            }
            fp = fp.next;
            sp = sp.next;
        }
        return true;
    }

    @Override
    public Listnode reverse(Listnode head) {
        Listnode prev = null;
        while (head != null) {
            Listnode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    @Override
    public Listnode sort(Listnode l1) {
        return mergeSort(l1);
    }

    public Listnode mergeSort(Listnode node){
        if (node == null || node.next == null)
            return node;

        Listnode middle = middle(node);
        Listnode nextOdMiddle = middle.next;

        middle.next = null;

        Listnode left = mergeSort(node);
        Listnode right = mergeSort(nextOdMiddle);

        Listnode sortedList = sortedMerge(left, right);

        return sortedList;
    }

    public Listnode sortedMerge(Listnode left, Listnode right){
        Listnode result = null;

        if (left == null){
            return right;
        }

        if (right == null){
            return left;
        }

        if (left.var <= right.var){
            result = left;
            result.next = sortedMerge(left.next, right);
        } else {
            result = right;
            result.next = sortedMerge(left, right.next);
        }
        return result;
    }

    @Override
    public Listnode middle(Listnode l1){
        if (l1 == null || l1.next == null)
            return l1;

        Listnode fastPointer = l1.next;
        Listnode slowPointer = l1;

        /*while (fastPointer != null && fastPointer.next != null && fastPointer.next.next != null){
            fastPointer = fastPointer.next.next.next;
            slowPointer = slowPointer.next;
        }*/

        while (fastPointer != null){
            fastPointer = fastPointer.next;
            if (fastPointer != null){
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next;
            }
        }
        return slowPointer;
    }
}
