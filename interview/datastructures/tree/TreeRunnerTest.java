package interview.datastructures.tree;

public class TreeRunnerTest {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int[] in = {4,2,5,1,6,3,7};
        int[] level = {1,2,3,4,5,6,7};
        BinaryTree.TreeNode node = bt.constructBT(in, level);

        bt.inorderTraversal(node);
        System.out.println();
        System.out.println("iterative preOrder: ");
        bt.iterativePreOrder(node);
        System.out.println("iterative inOrder: ");
        bt.iterativeInorder(node);
        System.out.println("iterative levelOrder: ");
        bt.iterativeLevelOrder(node);
        System.out.println("calculating size of BT ");
        int sizeOfBt = bt.iterSizeOfBt(node);
        System.out.println("size of BT: " + sizeOfBt);
        System.out.println("iter height of bt: " + bt.iterHeightOfBT(node));
        System.out.println("recur height of bt: " + bt.recurHeightOfBT(node));
    }
    /**
     * 1. Initialize current as root
     * 2. While current is not NULL
     *    If the current does not have left child
     *       a) Print current’s data
     *       b) Go to the right, i.e., current = current->right
     *    Else
     *       a) Make current as the right child of the rightmost
     *          node in current's left subtree
     *       b) Go to this left child, i.e., current = current->left
     */
}