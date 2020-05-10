package leetcode.trees.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */

public class BTLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>(new ArrayList<>());
        }

        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> childList = new ArrayList<>();
            for(int i = 0; i< size; i++) {
                TreeNode temp = queue.poll();
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
                childList.add(temp.val);
            }
            list.add(childList);
        }
        return list;
    }
}
