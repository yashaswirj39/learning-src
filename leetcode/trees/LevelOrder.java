package leetcode.trees;

import java.util.ArrayList;
import java.util.Scanner;

public class LevelOrder {

    private class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        public TreeNode(TreeNode left, TreeNode right, int data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }

    TreeNode root;
    private ArrayList<Integer> preOrder = new ArrayList<>();

    public boolean add(int data) {
        root = add(root, data);
        return true;
    }

    private TreeNode add(TreeNode node, int data) {
        if (node == null) {
            node = new TreeNode(null, null, data);
        } else {
            if (data < root.data)
                node.left = add(node.left, data);
            else
                node.right = add(node.right, data);
        }
        return root;
    }

    public ArrayList<Integer> preOrder(TreeNode node) {
        if (node == null) return null;

        if (node != null) {
            preOrder.add(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
        return preOrder;
    }

    public static void main(String[] args) {

        LevelOrder lo = new LevelOrder();

        Scanner scanner = new Scanner(System.in);

        int sizeOfTree = scanner.nextInt();

        for (int i = 0; i < sizeOfTree; i++) {
            lo.add(scanner.nextInt());
        }

        System.out.println(lo.preOrder(lo.root));
    }
}