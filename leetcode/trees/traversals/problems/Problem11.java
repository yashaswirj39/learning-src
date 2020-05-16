package leetcode.trees.traversals.problems;

import java.util.Scanner;

/**
 * Find n-th node in Postorder traversal of a Binary Tree
 * https://www.geeksforgeeks.org/find-n-th-node-in-postorder-traversal-of-a-binary-tree/
 */
public class Problem11 {

    int count = 0;

    public static void main(String[] args) {
        TreeNode root = BinaryTreeUtility.put();
        Scanner sc = new Scanner(System.in);
        System.out.println("Counter value:");
        int N = sc.nextInt();
        Problem11 prob = new Problem11();
        prob.postOrder(root, N);
    }

    public void postOrder(TreeNode root, int N) {
        if(root != null) {
            postOrder(root.left, N);
            postOrder(root.right, N);
            count++;
            if(count == N) {
                System.out.println(root.data);
            }
        }
    }
}