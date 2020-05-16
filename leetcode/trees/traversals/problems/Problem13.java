package leetcode.trees.traversals.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem13 {

    public static void main(String[] args) {
        TreeNode root = BinaryTreeUtility.put();
        Problem13 prob = new Problem13();
        prob.zigzagLevelOrder(root);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>(new ArrayList<>());
        }

        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int counter = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> childList = new ArrayList<>();
            for(int i = 0; i< size; i++) {
                TreeNode temp = queue.poll();
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
                if (counter % 2 == 0) {
                    childList.add(temp.data);
                } else {
                    childList.add(0, temp.data);
                }
            }
            counter++;
            list.add(childList);
        }
        return list;
    }
}