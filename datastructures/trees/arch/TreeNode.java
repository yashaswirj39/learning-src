package datastructures.trees.arch;


public class TreeNode<T> {
    public TreeNode<T> left;
    public TreeNode<T> right;
    public T data;

    public TreeNode(TreeNode<T> left, TreeNode<T> right, T elem) {
        this.left = left;
        this.right = right;
        this.data = elem;
    }
}
