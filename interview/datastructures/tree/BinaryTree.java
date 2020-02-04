package interview.datastructures.tree;


import java.util.*;

public class BinaryTree implements TreeImpl {

    @Override
    public TreeNode constructBT(int[] in, int[] level) {
        /**
         * create a map to efficeiently find index of an element in level order sequence
         */
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < level.length; i++) {
            map.put(level[i], i);
        }

        /**
         * construct the tree and return it
         */
        return constructBT(in, 0, in.length - 1, map);
    }

    @Override
    public TreeNode iterativePreOrder(TreeNode node) {
        if (node == null) return null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.println(temp.data);
            if (temp.right != null) stack.push(temp.right);
            if (temp.left != null) stack.push(temp.left);
        }
        return null;
    }

    @Override
    public TreeNode iterativeInorder(TreeNode node) {
        if (node == null) return null;

        Stack<TreeNode> stack = new Stack<>();

        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) break;

                node = stack.pop();
                System.out.println(node.data);
                node = node.right;
            }
        }
        return null;
    }

    @Override
    public TreeNode iterativeLevelOrder(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode tn = queue.poll();
            System.out.println(tn.data);
            if (tn.left != null) queue.add(tn.left);
            if (tn.right != null) queue.add(tn.right);
        }
        return node;
    }

    @Override
    public TreeNode iterativeInorderNRNS(TreeNode node) {

        return null;
    }

    @Override
    public int iterSizeOfBt(TreeNode node) {
        int count = 0;
        if (node == null) return 0;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            count++;
            if (temp.left != null) stack.push(temp.left);
            if (temp.right != null) stack.push(temp.right);
        }
        //System.out.println("size of BT is: " + count);
        return count;
    }

    @Override
    public int recurSizeOfBt(TreeNode node) {
        if (node == null) return 0;

        int leftSize = recurSizeOfBt(node.left);
        int rightSize = recurSizeOfBt(node.right);
        return leftSize + rightSize + 1;
    }

    /**
     * Need to write function for iterative logic
     * @param node1
     * @param node2
     * @return
     */
    @Override
    public boolean recurIsSameBT(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }

        return node1.data == node2.data && recurIsSameBT(node1.left, node2.left) && recurIsSameBT(node1.right, node2.right);
    }

    @Override
    public int iterHeightOfBT(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        int height = 0;
        queue.add(node);
        while (true) {
            int nodeCount = queue.size();
            if (nodeCount == 0) {
                break;
            }
            height++;
            while (nodeCount > 0) {
                TreeNode tempNode = queue.poll();
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
                nodeCount--;
            }
        }
        return height;
    }

    @Override
    public int recurHeightOfBT(TreeNode node) {
        while (node == null) {
            return 0;
        }
        int left = recurHeightOfBT(node.left);
        int right = recurHeightOfBT(node.right);
        return 1 + Math.max(left, right);
    }

    /**
     * Recursive function to construct a binary tree from inorder and level order traversal.
     *
     * @param in
     * @param start
     * @param end
     * @param map
     * @return
     */
    public TreeNode constructBT(int[] in, int start, int end, Map<Integer, Integer> map) {

        //base case
        if (start > end)
            return null;
        /**
         * find the index of root node in inorder to determine the 
         * boundary od left and right subtree.
         * int[] in = {4,2,5,1,6,3,7};
         * int[] level = {1,2,3,4,5,6,7};
         */
        int index = start;

        for (int i = start + 1; i < end; i++) {
            if (map.get(in[i]) < map.get(in[index])) {
                index = i;
            }
        }
        //construct the root node
        TreeNode node = new TreeNode(in[index], null, null);

        //recursively construct the left subtree
        node.left = constructBT(in, start, index - 1, map);

        //recursively construct the right subtree
        node.right = constructBT(in, index + 1, end, map);
        return node;
    }

    /**
     * Recursive function to perform inorder traversal of a binary tree
     *
     * @param node
     */
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
