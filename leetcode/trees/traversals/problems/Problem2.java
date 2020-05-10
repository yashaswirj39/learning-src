package leetcode.trees.traversals.problems;

import leetcode.trees.traversals.BinaryTreeConstruction;

import java.util.Stack;

/**
 * Inorder Tree Traversal without Recursion
 * https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
 * @Approach:
 * 1) Create an empty stack S.
 * 2) Initialize current node as root
 * 3) Push the current node to S and set current = current->left until current is NULL
 * 4) If current is NULL and stack is not empty then
 *      a) Pop the top item from stack.
 *      b) Print the popped item, set current = popped_item->right
 *      c) Go to step 3.
 * 5) If current is NULL and stack is empty then we are done.
 */
public class Problem2 {
    public static void main(String[] args) {
        BinaryTreeConstruction btc = new BinaryTreeConstruction();
        BinaryTreeConstruction.TreeNode root = btc.put();
        inorderTraversalWithoutRecursion(root);
    }

    public static void inorderTraversalWithoutRecursion(BinaryTreeConstruction.TreeNode root) {
        Stack<BinaryTreeConstruction.TreeNode> stack = new Stack<>();

        BinaryTreeConstruction.TreeNode current = root;

        while (current != null || stack.size() > 0) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            System.out.print(current.data + " ");

            current = current.right;
        }
    }
}
