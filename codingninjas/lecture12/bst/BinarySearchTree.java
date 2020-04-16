package codingninjas.lecture12.bst;

import codingninjas.lecture11.binarytree.BinaryTreeNode;

import java.util.ArrayList;

public class BinarySearchTree {

    private BinaryTreeNode<Integer> root;

    public boolean insertData(int data) {
        root = insertDataHelper(data, root);
        return true;
    }

    private BinaryTreeNode<Integer> insertDataHelper(int data, BinaryTreeNode<Integer> root) {
        if (root == null) {
            root = new BinaryTreeNode<>(data);
        }

        if (root.data > data) {
            root.left = insertDataHelper(data, root.left);
        } else if (root.data < data){
            root.right = insertDataHelper(data, root.right);
        }
        return root;
    }

    public void deleteData(int data) {

    }

    public boolean hasData(int data) {
        return hasDataHelper(data, root);
    }

    private boolean hasDataHelper(int data, BinaryTreeNode<Integer> root) {
        if (root == null) {
            throw new RuntimeException("Tree does not exists");
        }

        if (root.data.equals(data)) {
            return true;
        } else if (data < root.data) {
            //call left;
            return hasDataHelper(data, root.left);
        } else  {
            //call right
            return hasDataHelper(data, root.right);
        }
    }

    public void delete(int data) {
        root = deleteHelper(data, root);
    }

    private BinaryTreeNode<Integer> deleteHelper(int data, BinaryTreeNode<Integer> root) {
        if (root == null) {
            return null;
        }

        if (root.data > data) {
            root.left= deleteHelper(data,root.left);
            return root;
        } else if (root.data < data) {
            root.right = deleteHelper(data, root.right);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if(root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                BinaryTreeNode<Integer> minNode = root.right;
                while (minNode.left != null) {
                    minNode = minNode.left;
                }
                root.data = minNode.data;
                root.right = deleteHelper(minNode.data, root.right);
                return root;
            }
        }
        return root;
    }

    private void printTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        String toBePrinted = root.data + "";
        if (root.left != null) {
            toBePrinted += "L:"+root.left.data+",";
        }

        if (root.right != null) {
            toBePrinted += "R:"+root.right.data+",";
        }

        System.out.println(toBePrinted);
        printTree(root.left);
        printTree(root.right);
    }

    public void printTree() {
        printTree(root);
    }

    public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
        BinaryTreeNode<Integer> oldRoot;
        if(root == null)
            return;

        insertDuplicateNode(root.left);
        insertDuplicateNode(root.right);

        oldRoot = root.left;
        root.left = new BinaryTreeNode<>(root.data);
        root.left.left = oldRoot;
    }

    /**
     * lowest common ancestor for binary tree
     * @param root
     * @param a
     * @param b
     * @return
     */
    public static int lcaBinaryTree(BinaryTreeNode <Integer> root , int a, int b){
        return lcaBinaryTreeHelper(root, a, b) != null ? lcaBinaryTreeHelper(root, a, b).data : -1;
    }

    public static BinaryTreeNode<Integer> lcaBinaryTreeHelper(BinaryTreeNode <Integer> root , int a, int b){
        if(root == null) {
            return null;
        }

        if(root.data.equals(a) || root.data.equals(b)) {
            return root;
        }
        root.left = lcaBinaryTreeHelper(root.left, a, b);
        root.right = lcaBinaryTreeHelper(root.right, a, b);

        if(root.left != null && root.right != null) return root;

        if(root.left == null && root.right == null) return null;

        return root.left != null ? root.left : root.right;
    }

    public static int lcaInBST(BinaryTreeNode<Integer> root , int a , int b){
        return lcaBSTHelper(root, a, b) != null ? lcaBSTHelper(root, a, b).data : -1;
    }

    /**
     * lowest common ancestor of Binary Search Tree
     * @param root
     * @param a
     * @param b
     * @return
     */
    public static BinaryTreeNode<Integer> lcaBSTHelper(BinaryTreeNode<Integer> root , int a , int b) {
        if(root.data > Math.max(a,b)) {
            return lcaBSTHelper(root.left, a, b);
        } else if(root.data < Math.min(a,b)) {
            return lcaBSTHelper(root.right, a, b);
        } else return root;
    }

    /**
     * Pair Sum Binary Tree
     * @param root
     * @param sum
     */
    public static void nodesSumToS(BinaryTreeNode<Integer> root, int sum) {
        ArrayList<Integer> al = new ArrayList<>();
        nodesSumToSHelper(root, sum, al);
    }

    public static void nodesSumToSHelper(BinaryTreeNode<Integer> root, int sum, ArrayList<Integer> list) {
        if(root != null) {
            if(root.left != null) {
                nodesSumToSHelper(root.left, sum, list);
            }
            if(!list.contains(sum - root.data)) {
                list.add(root.data);
            } else {
                int data = (sum - root.data);
                if(root.data < data){
                    System.out.println(root.data + " " + data);
                } else {
                    System.out.println(data + " " + root.data);
                }
            }
            if(root.right != null) {
                nodesSumToSHelper(root.right, sum, list);
            }
        }
    }
}