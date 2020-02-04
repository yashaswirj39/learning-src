package datastructures.linkedlist;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;

public class LinkedList<T> implements LinkedListImpl {
    Node head;
    int size = 0;
    int itercounter = 1;
    int reverseAlternateCounter = 0;

    /**
     * Creating new node and adding data to it.
     *
     * @param data
     * @return
     */
    public boolean add(Object data) {
        return addNode((T) data);
    }

    private boolean addNode(T data) {
        boolean flag = false;
        Node node = new Node(data);
        if (head == null) {
            head = new Node(data);
            flag = true;
            size++;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
            flag = true;
            size++;
        }
        return flag;
    }

    public Node getHead() {
        return head;
    }

    /**
     * displays the list content in generic way
     *
     * @param node
     * @return
     */
    public String data(Node node) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (node != null) {
            sb.append(node.data).append(",").append(" ");
            node = node.next;
        }
        sb.append("]");
        return sb.toString().replaceAll(", ]", "]");
    }

    /**
     * Displays data from list based on given index.
     *
     * @param index
     * @return
     */
    public T get(int index) {
        if (head == null) {
            return null;
        }
        Node n = head;
        while (--index > 0 && n != null) {
            n = n.next;
        }
        return (T) n.data;
    }

    /**
     * This method delete node based on given value if present
     *
     * @param key
     */
    @Override
    public void remove(Object key) {
        if (head == null) throw new NullPointerException("List is Empty");

        Node node = head;
        Node prev = null;

        if (node.data == key && node.next == null) {
            node = null;
            return;
        }

        if (head.data == key && head.next != null) {
            head = head.next;
            return;
        }

        while (node != null && node.data != key) {
            prev = node;
            node = node.next;
        }

        if (node == null) return;

        prev.next = node.next;
    }

    /**
     * This method deletes the node for given position
     *
     * @param pos
     */
    @Override
    public void removeAtPosition(Object pos) {
        if (head == null) throw new NullPointerException("list doesnot exists");

        if ((int) pos >= size)
            throw new RuntimeException("pos greater than size of lists");

        if (head.next == null && (int) pos > 0) throw new RuntimeException("Pos" + pos + "is greater than size " +
                "of the list");

        Node node = head;
        Node prev = null;

        if ((int) pos == 0) {
            if (head.next == null) {
                head = null;
                return;
            } else if (head.next != null) {
                head = head.next;
                return;
            } else {
                return;
            }
        }

        if ((int) pos > 0) {
            int count = 0;
            while (count != (int) pos) {
                count++;
                prev = node;
                node = node.next;
            }
        }

        if (node == null) return;

        prev.next = node.next;
    }

    /**
     * deleteing list permanantly
     *
     * @return
     */
    @Override
    public boolean deleteList() {
        boolean flag = false;

        if (head == null) throw new NullPointerException("List does not exists");

        if (head != null) {
            head = null;
            flag = true;
        }
        return flag;
    }

    /**
     * calculates the size of list recursively
     *
     * @param node
     * @return
     */
    @Override
    public int recursiveSizeCal(Node node) {
        if (node == null) return 0;

        if (node.next != null) {
            ++itercounter;
            recursiveSizeCal(node.next);
        }
        return itercounter;
    }

    /**
     * calculates the size of list iteratively
     *
     * @param node
     * @return
     */
    @Override
    public int iterativeSizeCal(Node node) {
        int counter = 0;

        if (node == null) return counter;

        while (node != null) {
            counter++;
            node = node.next;
        }
        return counter;
    }

    /**
     * recursively checks element presence inside the list.
     *
     * @param node
     * @param elem
     * @return true/false
     */
    @Override
    public boolean recursiveContains(Node node, Object elem) {
        boolean flag = false;

        if (node == null) return flag;

        if (node != null) {
            if (node.data == elem) {
                flag = true;
                return flag;
            }
            return recursiveContains(node.next, elem);
        }
        return flag;
    }

    /**
     * iteratively checks element presence inside the list.
     *
     * @param node
     * @param elem
     * @return true/false
     */
    @Override
    public boolean iterativeContains(Node node, Object elem) {
        boolean flag = false;

        if (node == null) return flag;

        while (node != null) {
            if (node.data == elem) {
                flag = true;
            }
            node = node.next;
        }
        return flag;
    }

    /**
     * recursively calculate nth node value from beginning.
     *
     * @param node
     * @param index
     * @return node.data
     */
    @Override
    public int recurGetNthNode(Node node, Object index) {
        if (node == null) return 0;

        if ((int) index > size) throw new IndexOutOfBoundsException("index is greater than size of the list");

        if (node.next == null && (int) index == 0) return (int) node.data;

        if ((int) index > 0) {
            return recurGetNthNode(node.next, (int) index - 1);
        }
        return (int) node.data;
    }

    /**
     * iteratively calculate nth node value from beginning.
     *
     * @param node
     * @param index
     * @return node.data
     */
    @Override
    public int iterGetNthNode(Node node, Object index) {
        if (node == null) return 0;

        int ind = (int) index;
        if (ind > size) throw new IndexOutOfBoundsException("index is greater than size of the list");

        if (node.next == null && (int) ind == 0) {
            return (int) node.data;
        }

        while (ind > 0) {
            ind--;
            node = node.next;
        }
        return (int) node.data;
    }

    /**
     * This function returns nth node from last using size - index formula
     *
     * @param node
     * @param index
     * @return
     */
    @Override
    public int iterGetNthNodeFromLast(Node node, Object index) {
        if (node == null) return 0;

        int ind = (int) index;

        if (ind > size) throw new IndexOutOfBoundsException("index is greater than size of the list");

        if (ind - size == 0) {
            return (int) node.data;
        }

        int length = size - ind;

        while (length-- > 0) {
            node = node.next;
        }

        return (int) node.data;
    }

    /**
     * This method returns middle of the list by calaculaing size first
     * and then re traversing the half of the list
     * ---- this can also be solved using two pointers.
     *
     * @param node
     * @return
     */
    @Override
    public int getMiddleNode(Node node) {
        if (node == null) return 0;

        if (node.next == null) return (int) node.data;

        if (size % 2 != 0) {
            int length = size / 2;
            while (length-- > 0) {
                node = node.next;
            }
            return (int) node.data;
        } else {
            int length = size / 2;
            while (length-- > 0) {
                node = node.next;
            }
            return (int) node.data;
        }
    }

    /**
     * This method retunns middle node using two pointers
     *
     * @param node
     * @return
     */
    @Override
    public int getMiddleNodeUsingTwoPointer(Node node) {
        if (node == null) return 0;

        if (node.next == null) return (int) node.data;

        int count = 0;
        Node sp = node;
        Node fp = node;

        while (fp != null) {
            fp = fp.next;
            count++;
            if (count % 2 == 0) {
                sp = sp.next;
            }
        }

        return (int) sp.data;
    }

    /**
     * This method returns number of time a given element ocurred/repeated in a list.
     *
     * @param node
     * @param elem
     * @return
     */
    @Override
    public int intOccuranceCount(Node node, Object elem) {
        if (node == null) return 0;

        if (node.next == null && node.data != elem) {
            return 0;
        }

        if (node.next == null && node.data == elem) {
            return 1;
        }
        int count = 0;

        while (node != null) {
            if (node.data == elem) {
                count++;
            }
            node = node.next;
        }
        return count;
    }

    /**
     * This method is used to find loop in the list using two pointers(Floyd’s Cycle-Finding Algorithm).
     * We can also use hashtable to find the loop.
     *
     * @param node
     * @return
     */

    @Override
    public boolean detectLoop(Node node) {
        if (node == null) return false;

        Node sp = node;
        Node fp = node;
        boolean flag = false;

        while (fp != null && fp.next != null) {
            fp = fp.next.next;
            sp = sp.next;
            if (fp == sp) {
                flag = true;
                break;
            } else {
                flag = false;
            }
        }
        return flag;
    }

    /**
     * This method will count the length of loop if exists inside a list.
     * This method can also have the logic using hashing technique.
     *
     * @param node
     * @return
     */
    @Override
    public int lengthOfLoop(Node node) {
        if (node == null) return 0;

        int counter = 0;
        if (detectLoop(node)) {
            Node sp = node;
            Node fp = node;

            while (fp != null && fp.next != null) {
                fp = fp.next.next;
                sp = sp.next;
                counter++;
                if (fp == sp) {
                    break;
                }
            }
        }
        return counter;
    }

    /**
     * This method is used to check whether a list is pallindrome or not.
     *
     * @param node
     * @return
     */

    @Override
    public boolean isPallindrome(Node node) {

        if (node == null) return false;

        if (node.next == null) return false;

        Stack<T> stack = new Stack<>();
        Node fp = node;
        Node sp = node;
        Node secondList = null;
        boolean flag = false;

        while (true) {
            stack.push((T) sp.data);
            fp = fp.next.next;

            if (fp == null) {
                secondList = sp.next;
                break;
            }

            if (fp.next == null) {
                secondList = sp.next.next;
                break;
            }
            sp = sp.next;
        }
        System.out.println("stack data: " + stack);

        while (!stack.isEmpty()) {
            if (stack.pop() == secondList.data) {
                flag = true;
            } else {
                flag = false;
            }
            secondList = secondList.next;
        }
        return flag;
    }

    /**
     * Assuming the list passed as an argument to this method is already sorted.
     * This method will execute a logic to remove all duplicate entries in provided list.
     *
     * @param node
     * @return
     */

    @Override
    public Node removeDuplicatesFromSortedList(Node node) {
        Node original = node;

        if (node == null) return null;

        if (node.next == null) return node;

        while (node != null && node.next != null) {
            if (node.data instanceof Integer) {
                if ((int) node.data > (int) node.next.data) {
                    throw new RuntimeException("List is not Sorted. This functionality only works on sorted list");
                }
            } else if (node.data instanceof String) {
                if ((int) ((String) node.data).charAt(0) > (int) ((String) node.next.data).charAt(0)) {
                    throw new RuntimeException("List is not Sorted. This functionality only works on sorted list");
                }
            } else if (node.data instanceof Character) {
                if ((int) node.data > (int) node.next.data) {
                    throw new RuntimeException("List is not Sorted. This functionality only works on sorted list");
                }
            }

            if (node.data == node.next.data) {
                node.next = node.next.next;
                continue;
            }
            node = node.next;
        }

        return original;
    }

    /**
     * Assuming the list is unsorted.
     * This method will execute a logic to remove all duplicate entries in provided unsorted list.
     * There are two different way to do this:
     * 1. using Merge Sort technique.
     * 2. using Hashset ds by comparing the value.
     *
     * @param node
     * @return
     */
    @Override
    public Node removeDuplicateFromUnsortedList(Node node) {

        if (node == null) return null;

        if (node.next == null) return node;

        Node original = node;
        Node prev = null;
        while (node != null && node.next != null) {
            Node seconfHalf = node.next;
            while (seconfHalf != null) {
                if (node.data == seconfHalf.data && prev != null) {
                    prev.next = seconfHalf.next;
                    //continue;
                } else if (node.data == seconfHalf.data && prev == null) {
                    node.next = seconfHalf.next;
                } else {
                    prev = seconfHalf;
                }
                seconfHalf = seconfHalf.next;
            }
            if (node == null) {
                break;
            }
            node = node.next;
        }
        return original;
    }

    @Override
    public void swapNodeNotData(Node node, Object x, Object y) {
        if (node == null) return;

        /*Node original = node;
        Node fp = node;
        Node sp = node;
        Node spPrev = null;
        Node fpPrev = null;

        while (sp != null && sp.data != x) {
            spPrev = sp;
            sp = sp.next;
        }
        while (fp != null && fp.data != y) {
            fpPrev = fp;
            fp = fp.next;
        }

        Node temp = sp.next;
        System.out.println("temp--> " + temp.data);
        sp.next = fp.next;
        System.out.println("sp--> " + sp.data);
        fp.next = temp;
        System.out.println("fp--> " + fp.data);*/

        // Nothing to do if x and y are same
        if (x == y) return;

        // Search for x (keep track of prevX and CurrX)
        Node prevX = null, currX = head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        // Search for y (keep track of prevY and currY)
        Node prevY = null, currY = head;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        // If either x or y is not present, nothing to do
        if (currX == null || currY == null)
            return;

        // If x is not head of linked list
        if (prevX != null)
            prevX.next = currY;
        else //make y the new head
            head = currY;

        // If y is not head of linked list
        if (prevY != null)
            prevY.next = currX;
        else // make x the new head
            head = currX;

        // Swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

    /**
     * logic pending...
     *
     * @param node
     * @return
     */

    @Override
    public Node pairWiseSwapElements(Node node) {
        Node ori = node;
        Node sp = node;
        Node fp = node.next;
        Node prev = null;
        int count = 0;

        while (node != null && node.next != null) {
            T data = (T) node.data;
            node.data = node.next.data;
            node.next.data = data;
            node = node.next.next;
        }
        return ori;
    }

    @Override
    public Node movelastElementToFront(Node node) {

        if (node == null) return null;

        if (node.next == null) return node;

        Node original = node;
        while (node.next.next != null) {
            node = node.next;
        }

        Node prev = node;
        Node newTemp = node.next;
        prev.next = null;
        Node temp = original;
        newTemp.next = temp;
        return newTemp;
    }

    @Override
    public Node intersectionOfTwoSortedList(LinkedList list1, LinkedList list2) {

        if (list1 == null && list2 == null) return null;

        if (list1 == null) return list1.head;

        if (list2 == null) return list2.head;

        Node node1 = list1.head;
        Node node2 = list2.head;


        LinkedList list = new LinkedList();

        if (node1.data instanceof Integer) {
            if (list1.size < list2.size) {
                while (node1 != null && node2 != null) {
                    if (node1.data == node2.data) {
                        list.add(node1.data);
                        node1 = node1.next;
                        node2 = node2.next;
                    } else if ((int) node1.data < (int) node2.data) {
                        node1 = node1.next;
                    } else {
                        node2 = node2.next;
                    }
                }
            } else {
                while (node2 != null && node1 != null) {
                    if (node2.data == node1.data) {
                        list.add(node2.data);
                        node1 = node1.next;
                        node2 = node2.next;
                    } else if ((int) node2.data < (int) node1.data) {
                        node2 = node2.next;
                    } else {
                        node1 = node1.next;
                    }
                }
            }
        } else if (node1.data instanceof String) {
            int result = ((String) node2.data).compareTo(String.valueOf(node1.data));
            if (list1.size < list2.size) {
                while (node1 != null && node2 != null) {
                    if (node1.data == node2.data) {
                        list.add(node1.data);
                        node1 = node1.next;
                        node2 = node2.next;
                    } else if (result > 0) {
                        node1 = node1.next;
                    } else {
                        node2 = node2.next;
                    }
                }
            } else {
                while (node2 != null && node1 != null) {
                    if (node2.data == node1.data) {
                        list.add(node2.data);
                        node1 = node1.next;
                        node2 = node2.next;
                    } else if (result < 0) {
                        node2 = node2.next;
                    } else {
                        node1 = node1.next;
                    }
                }
            }
        }
        return list.head;
    }

    @Override
    public Node intersectionPointOfTwoList(LinkedList list1, LinkedList list2) {
        Hashtable<Node, T> ht = new Hashtable<>();
        Node node1 = list1.head;
        Node node2 = list2.head;
        Node resultNode = null;

        if (list1.size < list2.size) {
            while (node1 != null) {
                if (!ht.containsKey(node1)) {
                    ht.put(node1, (T) node1.data);
                } else {
                    continue;
                }
            }

            while (node2 != null) {
                if (ht.containsKey(node2)) {
                    break;
                }
                node2 = node2.next;
            }
            return node2;
        } else {
            while (node2 != null) {
                if (!ht.containsKey(node2)) {
                    ht.put(node1, (T) node2.data);
                } else {
                    continue;
                }
            }

            while (node1 != null) {
                if (ht.containsKey(node1)) {
                    break;
                }
                node1 = node1.next;
            }
            return node1;
        }
    }

    /**
     * Input: 17->15->8->12->10->5->4->1->7->6->NULL
     * Output: 8->12->10->4->6->17->15->5->1->7->NULL
     * <p>
     * Input: 8->12->10->5->4->1->6->NULL
     * Output: 8->12->10->4->6->5->1->NULL
     * <p>
     * // If all numbers are even then do not change the list
     * Input: 8->12->10->NULL
     * Output: 8->12->10->NULL
     * <p>
     * // If all numbers are odd then do not change the list
     * Input: 1->3->5->7->NULL
     * Output: 1->3->5->7->NULL
     *
     * @param node
     * @return
     */
    @Override
    public Node segregateEvenOddNodes(Node node) {
        //TODO - Logic to print list if all nodes are odd.
        if (node == null) return null;

        if (node.next == null) return node;
        /**
         * input: 17->15->8->12->10->5->4->1->7->6->NULL
         */
        Node temp = null;
        Node after = null;
        Node start = node;
        Node end = null;
        Node result = null;

        while (node.next != null) {
            node = node.next;
        }

        end = node;
        int counter = 0;
        int c = 0;

        while (start != null && counter++ < this.size) {
            if (temp != null && (int) start.data % 2 != 0) {
                after = start.next;
                temp.next = after;
                start.next = null;
                end.next = start;
                start = after;
                //start = start.next;
                end = end.next;
            } else if (temp == null && (int) start.data % 2 != 0) {
                after = start.next;
                start.next = null;
                end.next = start;
                start = after;
                //start = start.next;
                end = end.next;
            } else {
                temp = start;
                if (c == 0) {
                    result = temp;
                }
                c++;
                start = start.next;
            }
        }
        return result;
    }

    /**
     * Reversing a list.
     *
     * @param node
     * @return
     */
    @Override
    public Node iterativeReverseList(Node node) {
        if (node == null) return null;
        if (node.next == null) return node;
        /**
         * 1->2->3->4->NULL
         */
        Node nextNode = null;
        Node prev = null;
        Node curr = node;
        while (curr != null) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    Node nextNode = null;
    Node prev = null;

    @Override
    public Node recursiveReverse(Node node, Node curr) {
        if (curr != null) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            recursiveReverse(node, curr);
        }
        return prev;
    }

    /**
     * Req: Merge two sorted linked lists such that merged list is in reverse order.
     * The below commented method is one way and the current working logic will also work.
     *
     * @param list1
     * @param list2
     * @return
     */
    @Override
    public Node mergeTwoSortedListDisplayInRevOrder(LinkedList list1, LinkedList list2) {

        if (list1 == null || list1.isEmpty(list1)) {
            return iterativeReverseList(list2.head);
        }

        if (list2 == null || list2.isEmpty(list2)) {
            return iterativeReverseList(list1.head);
        }
        /*
        LinkedList list = new LinkedList();
        while (node1 != null && node2 != null) {
            if ((int) node1.data < (int) node2.data) {
                list.add(node1.data);
                node1 = node1.next;
            } else {
                list.add(node2.data);
                node2 = node2.next;
            }
        }

        while (node1 == null && node2 != null) {
            list.add(node2.data);
            node2 = node2.next;
        }

        while (node1 != null && node2 == null) {
            list.add(node1.data);
            node1 = node1.next;
        }
        return iterativeReverseList(list.head);
        */

        Node original = null;
        Node node1 = list1.head;
        Node node2 = list2.head;
        Node prev1 = null;
        Node prev2 = null;
        int counter = 0;

        while (node1 != null && node2 != null) {
            counter++;
            if ((int) node1.data <= (int) node2.data) {
                if (prev2 != null) {
                    prev2.next = node1;
                    prev2 = null;
                }
                prev1 = node1;
                if (counter == 1) {
                    original = node1;
                }
                node1 = node1.next;
            } else {
                if (prev1 != null) {
                    prev1.next = node2;
                    prev1 = null;
                }
                prev2 = node2;
                if (counter == 1) {
                    original = node2;
                }
                node2 = node2.next;
            }
        }

        if (node1 != null && node2 == null) {
            prev2.next = node1;
        } else {
            prev1.next = node2;
        }

        return iterativeReverseList(original);
    }

    /**
     * Reverses the list in group of size k. so if k = 3 then it will rverse 3 nodes each
     * till the entire list is traverse.
     *
     * @param node
     * @param k
     * @return
     */
    @Override
    public Node reverseLLInGroupOfGivenSize(Node node, Object k) {
        Node current = node;
        Node next = null;
        Node prev = null;
        int count = 0;

        while (count < (int) k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (next != null) {
            node.next = reverseLLInGroupOfGivenSize(next, k);
        }
        return prev;
    }


    @Override
    public boolean isEmpty(LinkedList list) {
        if (list.head == null)
            return true;
        else
            return false;
    }

    @Override
    public Node reverseAlternateKNodes(Node node, Object k) {
        reverseAlternateCounter++;
        Node current = node;
        Node next = null;
        Node prev = null;
        int count = 0;

        if (reverseAlternateCounter % 2 != 0) {
            while (count < (int) k && current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                count++;
            }
        } else {
            while (count < (int) k && current != null) {
                current = current.next;
                count++;
            }
        }

        if (next != null) {
            node.next = reverseAlternateKNodes(next, k);
        }
        return prev;
    }

    /**
     * Logic change is required
     *
     * @param node
     * @return
     */
    @Override
    public Node alternateEvenAndOddNodes(Node node) {
        //TODO Logic needs to be changed.

        LinkedList oddList = new LinkedList();
        LinkedList evenList = new LinkedList();


        if (node == null) return node;

        if (node.next == null) return node;

        while (node != null) {
            if ((int) node.data % 2 != 0) {
                oddList.add(node);
                node = node.next;
            } else {
                evenList.add(node);
                node = node.next;
            }
        }
        Node odd = oddList.head;
        Node even = evenList.head;

        while (odd != null || even != null) {
            Node pointerNode = odd.next;
            Node prevEven = even;
            even = even.next;
            odd.next = prevEven;
            odd.next.next = pointerNode;
            /*even = even.next;*/
            odd = odd.next.next;
        }
        return odd;
    }

    @Override
    public Node addAtGivenPosition(Object data, Object position) {
        return null;
    }

    /**
     * 33) Delete alternate nodes of a Linked List
     *
     * @param node
     * @return
     */
    @Override
    public Node deleteAlternateNodes(Node node) {
        if (node == null) return null;

        if (node.next == null) return node;

        Node original = node;

        while (node.next != null && node.next.next != null) {
            Node fp = node.next.next;
            node.next = fp;
            node = node.next;
        }

        if (node.next != null) {
            node.next = null;
        }

        return original;
    }

    /**
     * 34) Alternating split of a given Singly Linked List
     *
     * @param node
     * @return
     */
    @Override
    public ArrayList<Node> alternatingSplit(Node node) {
        if (node == null) return null;

        ArrayList<Node> arraylist = new ArrayList<>();

        boolean flag = false;
        Node original = node;
        Node alternate = null;
        Node second = null;
        while (node.next != null && node.next.next != null) {
            Node temp = node.next.next;
            if (alternate == null) {
                alternate = node.next;
                second = alternate;
            } else {
                alternate.next = node.next;
                alternate = alternate.next;
            }
            node.next = temp;
            node = node.next;
        }

        if (node.next != null) {
            alternate.next = node.next;
            node.next = null;
            flag = true;
        }

        if (!flag) {
            alternate.next = null;
        }

        arraylist.add(original);
        arraylist.add(second);
        return arraylist;
    }

    /**
     * 35) Identical Linked Lists.
     *
     * @param list1
     * @param list2
     * @return
     */
    @Override
    public boolean checkListIdencity(LinkedList list1, LinkedList list2) {

        Node node1 = list1.head;
        Node node2 = list2.head;

        if (list1.size > list2.size || list1.size < list2.size) return false;

        if (node1 == null && node2 == null) return false;

        if (node1 == null) return false;

        if (node2 == null) return false;

        boolean flag = false;

        while (node1 != null && node2 != null) {
            if (node1.data == node2.data) {
                node1 = node1.next;
                node2 = node2.next;
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * 36. Delete nodes which have a greater value on right side
     * Test case - 1:
     * 8
     * 12
     * 15
     * 10
     * 11
     * 5
     * 6
     * 2
     * 3
     * Test case - 2:
     * 6
     * 60
     * 50
     * 40
     * 30
     * 20
     * 10
     *
     * @param node
     * @return
     */
    @Override
    public Node deleteNodesGreaterOnRight(Node node) {
        if (node == null) return node;

        if (node.next == null) return node;

        Node prev = null;
        Node original = node;

        while (node.next != null && node != null) {
            if ((int) node.data < (int) node.next.data) {
                Node temp = node.next;
                if (prev == null) {
                    node.next = null;
                    node = temp;
                    original = node;
                } else {
                    prev.next = node.next;
                    prev = node.next;
                    node = node.next;
                }
            } else {
                prev = node;
                node = node.next;
            }
        }
        return original;
    }

    /**
     * Test Case: 1
     * 3
     * 5
     * 6
     * 3
     * 3
     * 8
     * 4
     * 2
     * Test Case: 2
     * 5
     * 7
     * 5
     * 9
     * 4
     * 6
     * 2
     * 8
     * 4
     * 37. Add two numbers represented by linked lists | Set 1
     * @param node1
     * @param node2
     * @param size1
     * @param size2
     * @return
     */
    @Override
    public Node addTwoNumbersRepresentedByLL(Node node1, Node node2, int size1, int size2) {
        //TODO - testing is required
        if (node1 == null && node2 == null) return null;

        if (node1 == null && node2 != null) return node2;

        if (node1 != null && node2 == null) return node1;

        int remainder = 0;
        int quotient = 0;
        int sum = 0;

        /*int size1 = size(node1);
        int size2 = size(node2);*/

        Node original1 = node1;
        Node original2 = node2;
        while (node1 != null && node2 != null) {
            sum = (int) node1.data + (int) node2.data;
            if (sum > 9) {
                sum = sum + quotient;
                remainder = sum % 10;
                quotient = sum / 10;
                if (size1 > size2)
                    node1.data = remainder;
                else
                    node2.data = remainder;
            } else {
                sum = sum + quotient;
                quotient = 0;
                if (sum > 9) {
                    sum = sum + quotient;
                    remainder = sum % 10;
                    quotient = sum / 10;
                    if (size1 > size2)
                        node1.data = sum;
                    else
                        node2.data = sum;
                }
                if (size1 > size2)
                    node1.data = sum;
                else
                    node2.data = sum;
            }
            node1 = node1.next;
            node2 = node2.next;
        }

        while (node1 != null && node2 == null) {
            sum = (int) node1.data + quotient;
            quotient = 0;
            if (sum > 9) {
                sum = sum + quotient;
                remainder = sum % 10;
                quotient = sum / 10;
                node1.data = remainder;
            }
            node1.data = sum;
            node1 = node1.next;
        }

        while (node1 == null && node2 != null) {
            sum = (int) node2.data + quotient;
            quotient = 0;
            if (sum > 9) {
                sum = sum + quotient;
                remainder = sum % 10;
                quotient = sum / 10;
                node2.data = remainder;
            }
            node2.data = sum;
            node2 = node2.next;
        }
        if (size1 > size2)
            return original1;
        else
            return original2;
    }

    public int size(Node node) {
        int counter = 0;
        while (node != null) {
            counter++;
            node = node.next;
        }
        return counter;
    }

    /**Test case: 1
     * 3
     * 1
     * 2
     * 3
     * Test case: 2
     * 6
     * 1
     * 2
     * 3
     * 4
     * 5
     * 6
     * 38. Delete a given node in Linked List under given constraints
     * @param node
     * @return
     */
    @Override
    public Node deleteNodeUnderProvidedConstraints(Node node, Node n) {
        //TODO - testing is required
        if (node == null) return node;

        if (node == n) {
            Node temp = node.next;
            node = temp;
            return node;
        }

        Node prev = null;
        Node original = node;
        while (node != null && node.next != null) {
            if (node == n) {
                prev.next = node.next;
                break;
            } else {
                prev = node;
                node = node.next;
            }
        }
        if (node == n && node.next == null)
            prev.next = null;

        return original;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}