package codingninjas.lecture10.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeUse {
    public static void main(String[] args) {
        /*TreeNode<Integer> root = new TreeNode<>(4);
        TreeNode<Integer> node1 = new TreeNode<>(2);
        TreeNode<Integer> node2 = new TreeNode<>(3);
        TreeNode<Integer> node3 = new TreeNode<>(4);
        TreeNode<Integer> node4 = new TreeNode<>(6);
        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);
        node2.children.add(node4);
        System.out.println(root);*/

        //Scanner sc = new Scanner(System.in);
        //TreeNode<Integer> root = takeInput(sc);
        TreeNode<Integer> root = takeInputLevelWise();
        printLevelWise(root);
        /*System.out.println("count");
        System.out.println(numNodes(root));*/
        //System.out.println("sum");
        //System.out.println(sumNodes(root));
        //System.out.println(largest(root));
        /*System.out.println("numNodeGreater:");
        System.out.println(numNodeGreater(root, 10));*/
        //System.out.println("height -----> " + height(root));
        printAtK(root, 2);
    }

    private static TreeNode<Integer> takeInput(Scanner sc) {
        int n;
        System.out.println("Enter next node data:");
        n = sc.nextInt();
        TreeNode<Integer> root = new TreeNode<>(n);
        System.out.println("Enter no. of children for " + n);
        int childCount = sc.nextInt();
        for (int i = 0; i < childCount; i++) {
            TreeNode<Integer> child = takeInput(sc);
            root.children.add(child);
        }
        return root;
    }

    public static TreeNode<Integer> takeInputLevelWise() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter root data:");
        int rootData = sc.nextInt();
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        TreeNode<Integer> root = new TreeNode<>(rootData);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<Integer> frontNode = queue.poll();
            System.out.println("Enter number of children of " + frontNode.data);
            int numOfChildren = sc.nextInt();
            for (int i = 0; i < numOfChildren; i++) {
                System.out.println("Enter " + (i + 1) + "th child of " + frontNode.data);
                int childInput = sc.nextInt();
                TreeNode<Integer> childNode = new TreeNode<>(childInput);
                frontNode.children.add(childNode);
                queue.add(childNode);
            }
        }
        return root;
    }

    /**
     * Ned to complete the logic after getting help from coding ninja
     * @param root
     */
    public static void printLevelWise(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        System.out.println(root.data);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode<Integer> node = queue.poll();
                for (int j = 0; j < node.children.size(); j++) {
                    queue.add(node.children.get(j));
                    System.out.print(node.children.get(j).data + " ");
                }
            }
            System.out.println();
        }
    }

    public static void print(TreeNode<Integer> root) {
        String s = root.data + ":";
        for (int i = 0; i < root.children.size(); i++) {
            s += root.children.get(i).data + ",";
        }
        System.out.println(s);
        for (int i = 0; i < root.children.size(); i++) {
            print(root.children.get(i));
        }
    }

    public static int numNodes(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int count = 1;

        for (int i = 0; i < root.children.size(); i++) {
            count += numNodes(root.children.get(i));
        }
        return count;
    }

    public static int sumNodes(TreeNode<Integer> root) {
        /*int sum = 0;

        for (int i = 0; i < root.children.size(); i++) {
            sum = sum + root.children.get(i).data;
            sumNodes(root.children.get(i));
        }
        return sum + root.data;*/
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode<Integer> node = queue.poll();
                for (int j = 0; j < node.children.size(); j++) {
                    queue.add(node.children.get(j));
                    sum += node.children.get(j).data;
                }
            }
        }
        return sum + root.data;
    }

    public static int largest(TreeNode<Integer> root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int ans = root.data;

        for (int i = 0; i < root.children.size(); i++) {
            int childLargest = largest(root.children.get(i));
            if (childLargest > ans) {
                ans = childLargest;
            }
        }
        return ans;
    }

    public static int numNodeGreater(TreeNode<Integer> root,int x) {
        int count = 0;

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode<Integer> temp = queue.poll();
            if(temp.data.compareTo(x) > 0) {
                count++;
            }
            for (int i = 0; i < temp.children.size(); i++) {
                queue.add(temp.children.get(i));
            }
        }
        return count;
    }

    public static int height(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode<Integer> node = queue.poll();
                for (int j = 0; j < node.children.size(); j++) {
                    queue.add(node.children.get(j));
                }
            }
            count++;
        }
        return count;
    }

    public static void printAtK(TreeNode<Integer> root, int k) {
        if (k < 0) {
            return;
        }

        if (k==0) {
            System.out.println(root.data);
            return;
        }

        for (int i = 0; i < root.children.size(); i++) {
            printAtK(root.children.get(i), k - 1);
        }
    }
}