package interview.datastructures.treerevision;

import java.util.ArrayList;

public interface BinaryTreeImpl<T> {
    TreeNode insertIntoBST(TreeNode node, int elem);
    ArrayList<T>  preOrderIterative(TreeNode node);
    ArrayList<T>  inOrderIterative(TreeNode node);
}
