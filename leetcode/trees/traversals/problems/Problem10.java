package leetcode.trees.traversals.problems;

import java.util.LinkedList;
import java.util.Scanner;


/**
 * Find n-th node of inorder traversal
 * https://www.geeksforgeeks.org/find-n-th-node-inorder-traversal/
 */

public class Problem10 {
    LinkedList<Integer> list = new LinkedList<>();
    int counter = 0;

    public static void main(String[] args) {
        TreeNode root = BinaryTreeUtility.put();
        Scanner sc = new Scanner(System.in);
        System.out.println("Counter value:");
        int N = sc.nextInt();
        Problem10 prob = new Problem10();
        /**
         * Efficient approach
         */
        prob.inorderEfficient(root, N);

        /**
         * using array extra O(N) space compleity
         */
        /*prob.inorder(root);
        System.out.println(prob.res(N));*/
    }

    int res(int N) {
        return list.get(N - 1);
    }

    void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            list.add(root.data);
            inorder(root.right);
        }
    }

    void inorderEfficient(TreeNode root, int N) {
        if (root == null)
            return;

        inorderEfficient(root.left, N);
        counter++;
        if (counter == N)
            System.out.println(root.data);
        inorderEfficient(root.right, N);
    }
}
