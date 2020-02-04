package interview.datastructures.treerevision;

import java.util.Scanner;

public class BSTRunner {
    public static void main(String[] args) {
        BST<Integer> bst = new BST();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            bst.add(sc.nextInt());
        }
        System.out.println(bst.preOrderIterative(bst.root));
    }
}
