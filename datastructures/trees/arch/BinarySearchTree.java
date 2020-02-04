package datastructures.trees.arch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> implements Tree {

    private ArrayList<T> preOrder = new ArrayList<>();
    private ArrayList<T> inOrder = new ArrayList<>();
    private ArrayList<T> postOrder = new ArrayList<>();
    private ArrayList<T> levelOrder = new ArrayList<>();
    private ArrayList<T> leafList = new ArrayList<>();
    public TreeNode<T> root;
    boolean flag = false;

    private TreeNode<T> add(TreeNode<T> node, T elem) {
        if (node == null) {
            node = new TreeNode<>(null, null, elem);
        } else {
            if (elem.compareTo(node.data) < 0) {
                node.left = add(node.left, elem);
            } else {
                node.right = add(node.right, elem);
            }
        }
        return node;
    }

    @Override
    public boolean add(Object elem) {
        root = add(root, (T) elem);
        return true;
    }

    @Override
    public ArrayList<T> preOrder(TreeNode node) {
        if (node == null) return null;

        if (node != null) {
            preOrder.add((T) node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
        return preOrder;
    }

    @Override
    public ArrayList<T> inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            inOrder.add((T) node.data);
            inOrder(node.right);
        }
        return inOrder;
    }

    @Override
    public ArrayList postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            postOrder.add((T) node.data);
        }
        return postOrder;
    }

    @Override
    public ArrayList levelOrder(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            TreeNode node1 = queue.poll();
            levelOrder.add((T) node1.data);
            if (node1.left != null)
                queue.add(node1.left);
            if (node1.right != null)
                queue.add(node1.right);
        }
        return levelOrder;
    }

    @Override
    public TreeNode<T> merge(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;

        t1.data = (int) t1.data + (int) t2.data;
        t1.left = merge(t1.left, t2.left);
        t1.right = merge(t1.right, t2.right);

        return t1;
    }

    @Override
    public TreeNode searchInABST(TreeNode node, Object elem) {
        if (contains(elem)) {
            node = searchInABST(node, (T) elem);
        }
        return node;
    }

    private TreeNode<T> searchInABST(TreeNode<T> node, T elem) {

        if (node == null) return null;

        if (node != null) {
            if (elem.compareTo(node.data) < 0) {
                return node.left = searchInABST(node.left, elem);
            }

            if (elem.compareTo(node.data) > 0) {
                return node.right = searchInABST(node.right, elem);
            }
        }
        return node;
    }

    @Override
    public boolean contains(Object elem) {
        return contains(root, (T) elem);
    }

    @Override
    public ArrayList leafList(TreeNode node) {

        if (node != null) {
            leafList(node.left);
            if (node.left == null && node.right == null) {
                leafList.add((T) node.data);
            }
            leafList(node.right);
        }
        return leafList;
    }

    @Override
    public boolean checkLeafSimilarTree(TreeNode node1, TreeNode node2) {

        if (node1 != null && node2 != null) {
            checkLeafSimilarTree(node1.left, node2.left);
            if (node1.left == null && node1.right == null
                    && node2.left == null && node2.right == null) {
                if (node1.data == node2.data) {
                    flag = true;
                } else {
                    flag = false;
                }
            }
            checkLeafSimilarTree(node1.right, node2.right);
        }
        return flag;
    }

    public static boolean similarLeafTree(ArrayList list1, ArrayList list2) {

        if (list1.equals(list2)) {
            System.out.println("Inside if");
            return true;
        }
        return false;
    }

    private boolean contains(TreeNode<T> node, T elem) {
        if (node == null) return false;

        int cmp = elem.compareTo(node.data);

        if (cmp < 0) {
            return contains(node.left, elem);
        }

        if (cmp > 0) {
            return contains(node.right, elem);
        }

        return true;
    }
}
