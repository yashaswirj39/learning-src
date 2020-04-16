package codingninjas.lecture10.assignment;

import codingninjas.lecture10.trees.TreeNode;
import codingninjas.lecture10.trees.TreeUse;

import java.util.LinkedList;
import java.util.Queue;

public class MaxChildrenSum {
    public static void main(String[] args) {
        TreeNode<Integer> root = TreeUse.takeInputLevelWise();
        System.out.println(maxSumNode(root).data);
    }

    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
        if (root.children.isEmpty()) {
            return root;
        }

        String max = "";
        Queue<TreeNode<Integer>> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<Integer> temp = queue.poll();
            int sum = 0;
            for (int i = 0; i < temp.children.size(); i++) {
                queue.add(temp.children.get(i));
                sum += sum+temp.children.get(i).data;
            }

            if (max.isEmpty()) {
                max = temp.data + ":" + sum;
            } else {
                if (Integer.parseInt(max.split(":")[1]) <= sum) {
                    max = temp.data + ":" + sum;
                }
            }
        }
        return new TreeNode<Integer>(Integer.parseInt(max.split(":")[0]));
    }
}