package leetcode.trees.practice;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes
 */

public class MinimumDistanceBetweenBSTNodes {
    public int minDiffInBST(TreeNode root) {
        if(root == null) {
            return 0;
        }
        LinkedList<Integer> list = new LinkedList();
        inorder(root, list);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<list.size() - 1; i++) {
            int diff = Math.abs(list.get(i) - list.get(i + 1));
            if(min > diff) {
                min = diff;
            }
        }
        return min;
    }

    public void inorder(TreeNode root, LinkedList<Integer> list) {
        if(root != null) {
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }
}
