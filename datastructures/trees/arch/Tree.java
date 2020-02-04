package datastructures.trees.arch;

import java.util.ArrayList;

public interface Tree<T> {
    boolean add(T elem);
    ArrayList<T> preOrder(TreeNode<T> node);
    ArrayList<T> inOrder(TreeNode<T> node);
    ArrayList<T> postOrder(TreeNode<T> node);
    ArrayList<T> levelOrder(TreeNode<T> node);
    TreeNode<T> merge(TreeNode<T> t1, TreeNode<T> t2);
    TreeNode<T> searchInABST(TreeNode<T> node, T elem);
    boolean contains(T elem);
    ArrayList<T> leafList(TreeNode<T> node);
    boolean checkLeafSimilarTree(TreeNode<T> node1, TreeNode<T> node2);
}
