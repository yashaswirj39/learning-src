package leetcode.trees.traversals.problems;

import leetcode.trees.traversals.BinaryTreeConstruction;


/**
 * Inorder Tree Traversal without recursion and without stack!
 * https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
 * @Approach:
 * 1. Initialize current as root
 * 2. While current is not NULL
 *    If the current does not have left child
 *       a) Print current’s data
 *       b) Go to the right, i.e., current = current->right
 *    Else
 *       a) Make current as the right child of the rightmost
 *          node in current's left subtree
 *       b) Go to this left child, i.e., current = current->left
 */
public class Problem3 {
    public static void main(String[] args) {
        BinaryTreeConstruction btc = new BinaryTreeConstruction();
        BinaryTreeConstruction.TreeNode root = btc.put();
        morrisTraversal(root);
    }

    public static void morrisTraversal(BinaryTreeConstruction.TreeNode root) {
        BinaryTreeConstruction.TreeNode current = root;
        BinaryTreeConstruction.TreeNode pre = root;

        while (current != null) {
            if(current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {

                /* Find the inorder predecessor of current */

                pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }

                /* Make current as right child of its inorder predecessor */
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    /* Revert the changes made in the 'if' part to restore the
                    original tree i.e., fix the right child of predecessor*/
                    pre.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }
    }
}
