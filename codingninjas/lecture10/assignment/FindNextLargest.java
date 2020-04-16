package codingninjas.lecture10.assignment;

import codingninjas.lecture10.trees.TreeNode;
import codingninjas.lecture10.trees.TreeUse;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class FindNextLargest {
    public static void main(String[] args) {
        TreeNode<Integer> root = TreeUse.takeInputLevelWise();
        //System.out.println(findNextLargerNode(root, 21).data);
        //System.out.println(findSecondLargest(root).data);
        System.out.println(countLeafNodes(root));
    }

    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n) {
        String diff = "";
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<Integer> temp = queue.poll();
            for (int i = 0; i < temp.children.size(); i++) {
                queue.add(temp.children.get(i));
            }
            if (diff.isEmpty()) {
                int res = (temp.data - n) > 0 ? (temp.data - n) : 0;
                if (res == 0) {
                    continue;
                } else {
                    diff = temp.data + ":" + res;
                }
            } else {
                int res = (temp.data - n) > 0 ? (temp.data - n) : 0;
                if (res == 0) {
                    continue;
                } else if (Integer.parseInt(diff.split(":")[1]) > res) {
                    diff = temp.data + ":" + res;
                }
            }
        }
        return diff.isEmpty() ? null : new TreeNode<Integer>(Integer.parseInt(diff.split(":")[0]));
    }

    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){
        if (root.children.isEmpty()) {
            return root;
        }
        TreeSet<Integer> ts = new TreeSet<>();
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<Integer> temp = queue.poll();
            //System.out.println("temp data: " + temp.data);
            ts.add(temp.data);
            for (int i = 0; i < temp.children.size(); i++) {
                queue.add(temp.children.get(i));
            }
        }
        System.out.println(ts);
        ts.pollLast();
        System.out.println(ts);
        return new TreeNode<>(ts.pollLast());
    }

    public static int countLeafNodes(TreeNode<Integer> root){
        if (root == null) {
            return 0;
        }
        int count = 0;
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<Integer> temp = queue.poll();
            if (temp.children.isEmpty()) {
                count++;
            }
            for (int i = 0; i < temp.children.size(); i++) {
                queue.add(temp.children.get(i));
            }
        }
        return count;
    }
}