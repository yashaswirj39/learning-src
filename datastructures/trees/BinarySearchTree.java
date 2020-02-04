package datastructures.trees;

import java.util.*;

public class BinarySearchTree<T extends Comparable<T>> {

    private int nodeCount = 0;

    private Node root;

    private class Node {
        T data;
        Node left;
        Node right;

        public Node(Node left, Node right, T elem) {
            this.left = left;
            this.right = right;
            this.data = elem;
        }
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int size(){
        return nodeCount;
    }

    public boolean add(T elem){
        if (contains(elem))
            return false;
        else {
            root = add(root, elem);
            nodeCount++;
            return true;
        }
    }

    private Node add(Node node, T elem){
        if (node == null)
            node = new Node(null, null, elem);
        else {
            if (elem.compareTo(node.data) < 0){
                node.left = add(node.left, elem);
            } else {
                node.right = add(node.right, elem);
            }
        }
        return node;
    }

    public boolean contains(T elem){
        return contains(root, elem);
    }

    private boolean contains(Node node, T elem){
        if (node == null) return false;

        int cmp = elem.compareTo(node.data);

        if (cmp < 0) return contains(node.left, elem);

        if (cmp > 0) return contains(node.right,elem);

        else return true;
    }

    public int height(){
        return height(this.root);
    }

    private int height(Node node){
        if (node == null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        //return Math.max(height(node.left), height(node.right)) + 1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean remove(T elem) {
        if (contains(elem)) {
            root = remove(root, elem);
            nodeCount--;
            return true;
        }
        return false;
    }

    private Node remove(Node node, T elem){
        if (node == null) return null;

        int compare = elem.compareTo(node.data);


        if (compare<0){
            node.left = remove(node.left, elem);
        } else if (compare > 0){
            node.right = remove(node.right, elem);
        } else {
            if (node.left == null) {

                Node rightChild = node.right;

                node.data = null;
                node = null;

                return rightChild;

                // This is the case with only a left subtree or
                // no subtree at all. In this situation just
                // swap the node we wish to remove with its left child.
            } else if (node.right == null) {

                Node leftChild = node.left;

                node.data = null;
                node = null;

                return leftChild;
            } else {
                Node tmp = findMin(node.right);
                node.data =tmp.data;
                node.right = remove(node.right,tmp.data);
            }
        }
        return node;
    }

    private Node findMin(Node node) {
        while(node.left != null)
            node = node.left;
        return node;
    }

    // Helper method to find the rightmost node (which has the largest value)
    private Node findMax(Node node) {
        while(node.right != null)
            node = node.right;
        return node;
    }

    public List<T> traverse(TreeTraversal order){
        switch (order){
            case PRE_ORDER: return preOrder();
            case IN_ORDER: return inOrder();
            case POST_ORDER: return postOrder();
            case LEVEL_ORDER: return levelOrder();
            default:return null;
        }
    }

    public List<T> preOrder(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        List<T> preorder = new ArrayList<>();
        /*while (!stack.isEmpty()){
            Node node = stack.pop();
            preorder.add(node.data);
            if (node.right!=null) stack.push(node.right);
            if (node.left!=null) stack.push(node.left);
        }*/
        return preOrder(stack, preorder);
    }

    private List<T> preOrder(Stack<Node> stack, List<T> preorder){
        while (!stack.isEmpty()){
            Node node = stack.pop();
            preorder.add(node.data);
            if (node.right!=null) stack.push(node.right);
            if (node.left!=null) stack.push(node.left);
            //preOrder(stack, preorder);
        }
        return preorder;
    }

    public List<T> inOrder(){

        Stack<Node> stack = new Stack<>();

        List<T> inorder = new ArrayList<>();
        Node node = root;
        while (true){
            if (node!=null){
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) break;

                node = stack.pop();
                inorder.add(node.data);
                node = node.right;
            }
        }
        return inorder;
    }

    private List<T> postOrder(){
        List<T> list = new ArrayList<>();
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()){
            Node node = stack1.pop();
            stack2.push(node);
            list.add(node.data);
            if (node.left!=null) stack1.push(node.left);
            if (node.right!=null) stack1.push(node.right);
        }
        return list;
    }

    private List<T> levelOrder(){
        return null;
    }
}
