package leetcode.trees.traversals.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUtility {
    public static TreeNode put() {
        Scanner s = new Scanner(System.in);
        Queue<TreeNode> queue = new LinkedList<>();

        System.out.println("Enter root data:");
        int rootData = s.nextInt();

        if (rootData == -1) {
            return null;
        }

        TreeNode root = new TreeNode(rootData);
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.println("Enter left child of node: " + temp.data);
            int leftChild = s.nextInt();
            if (leftChild != -1) {
                TreeNode left = new TreeNode(leftChild);
                queue.add(left);
                temp.left = left;
            }
            System.out.println("Enter right child of node: " + temp.data);
            int rightChild = s.nextInt();
            if (rightChild != -1) {
                TreeNode right = new TreeNode(rightChild);
                queue.add(right);
                temp.right = right;
            }
        }
        return root;
    }
}
