package datastructures.trees.arch;

public class TestBinaryTree {
    public  TreeNode buildTree(int inorder[], int preOrder[]) {
        return buildTree(inorder, preOrder, 0, inorder.length - 1, 0, preOrder.length - 1);
    }

    public TreeNode buildTree(int[] inOrder, int[] preOrder, int inS, int inE, int preS, int preE) {
        if (inS > inE)
            return null;
        int rootData = preOrder[preS];
        TreeNode node = new TreeNode(rootData, null, null);

        int rootIndex = -1;
        for (int i = inS; i < inE; i++) {
            if (inOrder[i] == rootData){
                rootIndex = i;
                break;
            }
        }

        if (rootIndex == -1) {
            return null;
        }

        int leftInS = inS;
        int leftInE = rootIndex - 1;
        int leftPreS = preS + 1;
        int leftPreE = leftInE - leftInS + leftPreS;
        int rightInS = rootIndex + 1;
        int rightInE = inE;
        int rightPreS = leftPreE + 1;
        int rightPreE = preE;

        node.left = buildTree(inOrder, preOrder, leftInS, leftInE, leftPreS, leftPreE);
        node.right = buildTree(inOrder, preOrder, rightInS, rightInE, rightPreS, rightPreE);
        return node;
    }

    public void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);
        System.out.print(node.data + " ");
        inorderTraversal(node.right);
    }

    protected class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
