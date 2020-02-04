package datastructures.trees.arch;

import java.util.ArrayList;
import java.util.Scanner;

public class TreeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        BinarySearchTree<Integer> bst1 = new BinarySearchTree<>();

        int sizeOfTree = scanner.nextInt();

        for (int i = 0; i < sizeOfTree; i++) {
            bst.add(scanner.nextInt());
        }

        /*for (int i = 0; i < sizeOfTree; i++) {
            bst1.add(scanner.nextInt());
        }*/

        System.out.println("-------------PREORDER------------");
        System.out.println(bst.preOrder(bst.root));
        System.out.println("-------------PREORDER------------");
        System.out.println();
        System.out.println("-------------INORDER------------");
        System.out.println(bst.inOrder(bst.root));
        System.out.println("-------------INORDER------------");
        System.out.println();
        System.out.println("-------------POSTORDER------------");
        System.out.println(bst.postOrder(bst.root));
        System.out.println("-------------POSTORDER------------");
        System.out.println("-------------POSTORDER------------");
        System.out.println(bst.postOrder(bst.root));
        System.out.println("-------------POSTORDER------------");

        /*System.out.println(bst.searchInABST(bst.root,5) + " ====> " + bst.searchInABST(bst.root,5).data
                + " <left> " + bst.searchInABST(bst.root,5).left.data + "<right>"
                + bst.searchInABST(bst.root,5).right.data);*/

        /*System.out.println("leaf nodes as list --> "+bst.leafList(bst.root));
        System.out.println("leaf nodes as list --> "+bst1.leafList(bst1.root));*/

        /*ArrayList list1 = bst.leafList(bst.root);
        ArrayList list2 = bst1.leafList(bst1.root);
        System.out.println(list1);
        System.out.println(list2);
        System.out.println("results ----> "+BinarySearchTree.similarLeafTree(list1, list2));

        System.out.println(bst.checkLeafSimilarTree(bst.root, bst1.root));*/
    }
}
