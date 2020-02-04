package leetcode.trees;


import java.util.Stack;

public class RangeSum<T extends Comparable<T>> {

    private int nodecount = 0;
    private Node root;

    private class Node{
        Node left;
        Node right;
        T data;

        public Node(Node left, Node right, T data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }

    public boolean add(T elem) {
        root = add(root, elem);
        nodecount++;
        return true;
    }

    private Node add(Node node, T elem) {
        if (node == null) {
            node = new Node( null, null, elem);
        } else {
            if (elem.compareTo(node.data) < 0) {
                node.left = add(node.left, elem);
            } else {
                node.right = add(node.right, elem);
            }
        }
        return node;
    }

    private int rangeSumBST(Node node, T L, T R) {
        Stack<Node> stack = new Stack<>();
        int sum = 0;
        while (true){
            if (node != null){
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) break;
                node = stack.pop();
                if ( (node.data.compareTo(L) >= 0) &&
                        (node.data.compareTo(R) <= 0)){
                    sum += (Integer) node.data;
                }
                node = node.right;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        RangeSum<Integer> rs= new RangeSum<>();
        //int[] arr = {10, 5, 15, 3, 7, 0, 18};
        int[] arr = {10,5,15,3,7,13,18,1,0,6};
        for (int a : arr){
            rs.add(a);
        }
        //System.out.println(rs.rangeSumBST(rs.root, 7, 15));
        System.out.println(rs.rangeSumBST(rs.root, 6, 10));
    }
}
