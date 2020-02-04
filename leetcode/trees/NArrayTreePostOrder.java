package leetcode.trees;

import java.util.*;

public class NArrayTreePostOrder {
Solution s = new Solution();

}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
class Solution {
    public static List<Integer> postorder(Node root) {
        Stack<Node> stack = new Stack<>();
        LinkedList<Integer> output = new LinkedList<>();

        if (root == null)
            return output;

        stack.push(root);
        while (!stack.empty()){
            Node node = stack.pop();
            output.addFirst(node.val);
            for (Node child : node.children){
                stack.push(child);
            }
        }

        return output;
    }
}