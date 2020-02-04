package datastructures.linkedlist;

import java.util.ArrayList;

public interface LinkedListImpl <T> {
    boolean add(T data);
    void remove(T key);
    void removeAtPosition(T pos);
    boolean deleteList();
    int recursiveSizeCal(Node node);
    int iterativeSizeCal(Node node);
    boolean recursiveContains(Node node, T elem);
    boolean iterativeContains(Node node, T elem);
    int recurGetNthNode(Node node, T index);
    int iterGetNthNode(Node node, T index);
    int iterGetNthNodeFromLast(Node node, T index);
    int getMiddleNode(Node node);
    int getMiddleNodeUsingTwoPointer(Node node);
    int intOccuranceCount(Node node, T elem);
    boolean detectLoop(Node node);
    int lengthOfLoop(Node node);
    boolean isPallindrome(Node node);
    Node removeDuplicatesFromSortedList(Node node);
    Node removeDuplicateFromUnsortedList(Node node);
    void swapNodeNotData(Node node, T x, T y);
    Node pairWiseSwapElements(Node node);
    Node movelastElementToFront(Node node);
    Node intersectionOfTwoSortedList(LinkedList list1, LinkedList list2);
    Node intersectionPointOfTwoList(LinkedList list1, LinkedList list2);
    Node segregateEvenOddNodes(Node node);
    Node iterativeReverseList(Node node);
    Node recursiveReverse(Node node, Node curr);
    Node mergeTwoSortedListDisplayInRevOrder(LinkedList list1, LinkedList list2);
    Node reverseLLInGroupOfGivenSize(Node node, T k);
    boolean isEmpty(LinkedList list);
    Node reverseAlternateKNodes(Node node, T k);
    Node alternateEvenAndOddNodes(Node node);
    Node addAtGivenPosition(T data, T position);
    Node deleteAlternateNodes(Node node);
    ArrayList<Node> alternatingSplit(Node node);
    boolean checkListIdencity(LinkedList list1, LinkedList list2);
    Node deleteNodesGreaterOnRight(Node node);
    Node addTwoNumbersRepresentedByLL(Node node1, Node node2, int siz1, int size2);
    Node deleteNodeUnderProvidedConstraints(Node node, Node n);
}