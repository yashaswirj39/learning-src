package leetcode.trees.traversals.problems;


/**
 * Print Postorder traversal from given Inorder and Preorder traversals
 * @reference - https://www.youtube.com/watch?v=GeltTz3Z1rw
 * Input:
 * Inorder traversal in[] = {4, 2, 5, 1, 3, 6}
 * Preorder traversal pre[] = {1, 2, 4, 5, 3, 6}
 *
 * Output:
 * Postorder traversal is {4, 5, 2, 6, 3, 1}
 */
public class Problem4 {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    private static TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if(preStart > preorder.length || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);

        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if(root.data == inorder[i]) {
                inIndex = i;
            }
        }

        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);

        return root;
    }

    public static void printPostOrder(TreeNode node) {
        if(node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.println(node.data + " ");
        }
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(preorder, inorder);
        printPostOrder(root);
    }
}
