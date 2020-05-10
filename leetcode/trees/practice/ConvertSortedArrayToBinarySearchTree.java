package leetcode.trees.practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConvertSortedArrayToBinarySearchTree {

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return null;
        }
        TreeNode root = null;
        int start = 0;
        int end = nums.length - 1;
        return sortedArrayToBSTHelper(nums, root, start, end);
    }

    public static TreeNode sortedArrayToBSTHelper(int[] nums, TreeNode currentRoot, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (currentRoot == null) {
                currentRoot = new TreeNode(nums[mid]);
            }
            currentRoot.left = sortedArrayToBSTHelper(nums, currentRoot.left, start, mid - 1);
            currentRoot.right = sortedArrayToBSTHelper(nums, currentRoot.right, mid + 1, end);
        }
        return currentRoot;
    }

    public static void printTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                System.out.print(temp.val + " ");
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] sortedArray = new int[n];
        for (int i = 0; i < n; i++) {
            sortedArray[i] = sc.nextInt();
        }
        printTree(sortedArrayToBST(sortedArray));
    }
}