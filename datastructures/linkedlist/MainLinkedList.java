package datastructures.linkedlist;

import java.util.ArrayList;
import java.util.Scanner;

public class MainLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> l = new LinkedList<>();
        LinkedList<Integer> l1 = new LinkedList<>();
        //LinkedList<String> l = new LinkedList<>();
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            //l.add(scanner.next());
            l.add(scanner.nextInt());
        }
        System.out.println(l.data(l.head));
        System.out.println(l.size);
        //System.out.println(l.get(5));
        //l.remove(3);
        //l.removeAtPosition(5);
        //System.out.println(l.data(l.head));
        //System.out.println(l.deleteList());
        //System.out.println("recur size: "+l.recursiveSizeCal(l.head));
        //System.out.println("iter size: "+l.iterativeSizeCal(l.head));
        //System.out.println("recur search: "+l.recursiveContains(l.head, 8));
        //System.out.println("iter search: "+l.iterativeContains(l.head, 8));
        //System.out.println("get Nth node: "+l.recurGetNthNode(l.head, 0));
        //System.out.println("get Nth node: "+l.iterGetNthNode(l.head, 3));
        //System.out.println("get Nth node: "+l.iterGetNthNodeFromLast(l.head, 1));
        //System.out.println("get middle node: "+l.getMiddleNode(l.head));
        //Sint counter = 0;ystem.out.println("get middle node: "+l.getMiddleNodeUsingTwoPointer(l.head));
        //System.out.println("get int ouccurence : "+l.intOccuranceCount(l.head, 1));
/*        *//**
         * The next 4 lines are to test loop existance and loop length in a list.
         *//*
        LoopTest loopTest = new LoopTest();
        loopTest.createLoop(l.head);
        System.out.println(l.detectLoop(l.head));
        System.out.println(l.lengthOfLoop(l.head));

        *//**
         * The next 4 lines are to test mo loop existance and no loop length in a list.
         *//*
        LoopTest test = new LoopTest();
        test.createLoop(l.head);
        System.out.println(l.detectLoop(l.head));
        System.out.println(l.lengthOfLoop(l.head));*/
        //System.out.println(l.isPallindrome(l.head));
        /*Node node = l.removeDuplicatesFromSortedList(l.head);
        System.out.println(l.data(node));*/
        /*Node node  = l.removeDuplicateFromUnsortedList(l.head);
        System.out.println(l.data(node));*/

        /**
         * Test cases for swaping nodes.
         */
        /*l.swapNodeNotData(l.head, 12, 20);
        System.out.println(l.data(l.head));
        l.swapNodeNotData(l.head, 10, 20);
        System.out.println(l.data(l.head));
        l.swapNodeNotData(l.head, 12, 13);
        System.out.println(l.data(l.head));*/
        //System.out.println(l.data(l.pairWiseSwapElements(l.head)));
        //System.out.println(l.data(l.movelastElementToFront(l.head)));
        /*
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            //l.add(scanner.next());
            l.add(scanner.nextInt());
        }

        int n1 = scanner.nextInt();
        for (int i = 0; i < n1; i++) {
            //l.add(scanner.next());
            l1.add(scanner.nextInt());
        }

        System.out.println(l.data(l.head));
        System.out.println(l.size);
        System.out.println(l.data(l1.head));
        System.out.println(l1.size);
        */
        //System.out.println(l.data(l.intersectionOfTwoSortedList(l, l1)));
        //System.out.println(l.data(l.segregateEvenOddNodes(l.head)));
        //System.out.println(l.data(l.iterativeReverseList(l.head)));
        //System.out.println(l.data(l.recursiveReverse(l.head, l.head)));

        /**
         * This method is used to test mergeTwoSortedListDisplayInRevOrder.
         * TestCases:
         * 3
         * 2 3 20
         * 4
         * 5 10 15 40
         */
        /*int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            //l.add(scanner.next());
            l.add(scanner.nextInt());
        }

        int n1 = scanner.nextInt();
        for (int i = 0; i < n1; i++) {
            //l.add(scanner.next());
            l1.add(scanner.nextInt());
        }

        System.out.println(l.data(l.head));
        System.out.println(l.size);
        System.out.println(l.data(l1.head));
        System.out.println(l1.size);
        System.out.println(l.data(l.mergeTwoSortedListDisplayInRevOrder(l, l1)));*/

        //System.out.println(l.data(l.reverseLLInGroupOfGivenSize(l.head, 3)));
        //System.out.println(l.data(l.reverseLLInGroupOfGivenSize(l.head, 5)));
        /*System.out.println(l.data(l.reverseAlternateKNodes(l.head, 3)));*/
        //System.out.println(l.data(l.alternateEvenAndOddNodes(l.head)));
        //System.out.println(l.data(l.deleteAlternateNodes(l.head)));
        /*ArrayList<Node> list = l.alternatingSplit(l.head);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("----------------------------------");
            System.out.println(l.data(list.get(i)));
            System.out.println("----------------------------------");
        }*/

        /*int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            //l.add(scanner.next());
            l1.add(scanner.nextInt());
        }
        System.out.println(l.data(l1.head));
        System.out.println(l1.size);
        System.out.println(l.checkListIdencity(l, l1));*/

        //System.out.println(l.data(l.deleteNodeUnderProvidedConstraints(l.head, l.head.next.next)));
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            l1.add(scanner.nextInt());
        }
        System.out.println(l.data(l.addTwoNumbersRepresentedByLL(l.head, l1.head, l.size, l1.size)));
    }
}