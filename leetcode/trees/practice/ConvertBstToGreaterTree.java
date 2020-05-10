package leetcode.trees.practice;


/**
 *  https://leetcode.com/problems/convert-bst-to-greater-tree/
 */

public class ConvertBstToGreaterTree {

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum = sum + root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
