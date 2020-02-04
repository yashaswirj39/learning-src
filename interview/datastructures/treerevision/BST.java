package interview.datastructures.treerevision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<T extends Comparable<T>> implements BinaryTreeImpl{
    TreeNode root;

    public boolean add(int elem) {
        root = insertIntoBST(root, elem);
        return true;
    }

    @Override
    public TreeNode insertIntoBST(TreeNode node, int elem) {
        if (node == null) {
            node = new TreeNode(null, null, elem);
        } else {
            if (elem < node.data) {
                node.left = insertIntoBST(node.left, elem);
            } else {
                node.right = insertIntoBST(node.right, elem);
            }
        }
        return node;
    }

    @Override
    public ArrayList preOrderIterative(TreeNode node) {
        ArrayList<Integer> al = new ArrayList<>();
        Stack<TreeNode> queue = new Stack<>();
        queue.push(node);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.pop();
            al.add(temp.data);
            if (temp.left != null) queue.push(temp.left);
            if (temp.right != null) queue.push(temp.right);
        }
        return al;
    }

    @Override
    public ArrayList inOrderIterative(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (node != null){

        }
        return null;
    }


}