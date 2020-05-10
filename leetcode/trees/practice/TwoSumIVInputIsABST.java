package leetcode.trees.practice;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


/**
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 */
public class TwoSumIVInputIsABST {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> hs = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                int diff = k - temp.val;
                if(!hs.contains(diff)) {
                    hs.add(root.val);
                } else {
                    return true;
                }
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
        }
        return false;
    }
}
