package datastructures.trees;

import java.util.Scanner;

public class TreeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < n; i++) {
            bst.add(sc.nextInt());
        }
        System.out.println(bst.height());
        //System.out.println(bst.remove(23));
        System.out.println("------PREORDER------");
        System.out.println(bst.traverse(TreeTraversal.PRE_ORDER));
        System.out.println("------PREORDER------");
        System.out.println("------INORDER------");
        System.out.println(bst.traverse(TreeTraversal.IN_ORDER));
        System.out.println("------INORDER------");
        System.out.println("------POSTORDER------");
        System.out.println(bst.traverse(TreeTraversal.POST_ORDER));
        System.out.println("------POSTORDER------");
    }
}
