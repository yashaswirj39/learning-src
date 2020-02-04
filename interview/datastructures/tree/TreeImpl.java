package interview.datastructures.tree;

/**
 * It contains all problems from "https://www.techiedelight.com".
 * @param <T>
 */
public interface TreeImpl {
    /**
     * Construct a binary tree from inorder and level order sequence.
     * @param in, level
     * @return
     */
    BinaryTree.TreeNode constructBT(int[] in, int[] level);
    BinaryTree.TreeNode iterativePreOrder(BinaryTree.TreeNode node);
    BinaryTree.TreeNode iterativeInorder(BinaryTree.TreeNode node);
    BinaryTree.TreeNode iterativeLevelOrder(BinaryTree.TreeNode node);
    BinaryTree.TreeNode iterativeInorderNRNS(BinaryTree.TreeNode node);
    int iterSizeOfBt(BinaryTree.TreeNode node);
    int recurSizeOfBt(BinaryTree.TreeNode node);
    boolean recurIsSameBT(BinaryTree.TreeNode node1, BinaryTree.TreeNode node2);
    int iterHeightOfBT(BinaryTree.TreeNode node);
    int recurHeightOfBT(BinaryTree.TreeNode node);
}
