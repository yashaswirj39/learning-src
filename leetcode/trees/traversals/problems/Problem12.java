package leetcode.trees.traversals.problems;

import java.util.LinkedList;
import java.util.Queue;


/**
 * Level Order Tree Traversal
 * https://www.geeksforgeeks.org/level-order-tree-traversal/
 */
public class Problem12 {
    public static void main(String[] args) {
        TreeNode root = BinaryTreeUtility.put();
        Problem12 prob = new Problem12();
        prob.printLevelOrder(root);
    }

    public void printLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                System.out.print(temp.data + " ");
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
            System.out.println();
        }
    }
}
