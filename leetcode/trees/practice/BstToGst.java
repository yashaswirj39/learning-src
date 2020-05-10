package leetcode.trees.practice;

public class BstToGst {
    private int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            bstToGst(root.right);
            sum = sum + root.val;
            root.val = sum;
            bstToGst(root.left);
        }
        return root;
    }
}
