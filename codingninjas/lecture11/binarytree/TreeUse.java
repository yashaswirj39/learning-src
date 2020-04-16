package codingninjas.lecture11.binarytree;

import java.util.*;

public class TreeUse<T> {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInpputLeveLWise();
        printLevelWise(root);
        //printLevelWiseInFormat(root);
        //System.out.println(countNodes(root));
        //System.out.println(heightOfBinaryTree(root));
        //mirrorBinaryTree(root);
        //System.out.println("diameter: " + diameter(root));
        /*System.out.println("diameter: " + heightDiameter(root).second + "\n" +
                "height: " + heightDiameter(root).first);*/
        /*int inorder[] = {4,2,5,1,3,7};
        int preorder[] = {1,2,4,5,3,7};

        BinaryTreeNode<Integer> resRoot = buildTree(inorder,preorder);
        printLevelWise(resRoot);*/
        /*BinaryTreeNode<Integer> leafDeleted = deleteLeafNode(root);
        printLevelWise(leafDeleted);*/
        /*ArrayList<Node<BinaryTreeNode<Integer>>> llForEachlvl = LLForEachLevel(root);*/
        printZigZag(root);
    }

    public static BinaryTreeNode<Integer> takeInpputLeveLWise() {
        Scanner s = new Scanner(System.in);
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();

        System.out.println("Enter root data:");
        int rootData = s.nextInt();

        if (rootData == -1) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> temp = queue.poll();
            System.out.println("Enter left child of node: " + temp.data);
            int leftChild = s.nextInt();
            if (leftChild != -1) {
                BinaryTreeNode<Integer> left = new BinaryTreeNode<>(leftChild);
                queue.add(left);
                temp.left = left;
            }
            System.out.println("Enter right child of node: " + temp.data);
            int rightChild = s.nextInt();
            if (rightChild != -1) {
                BinaryTreeNode<Integer> right = new BinaryTreeNode<>(rightChild);
                queue.add(right);
                temp.right = right;
            }
        }
        return root;
    }

    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode<Integer> temp = queue.poll();
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            System.out.println();
        }
    }

    public static void printLevelWiseInFormat(BinaryTreeNode<Integer> root) {
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode<Integer> temp = queue.poll();
                System.out.print(temp.data + ": ");
                if (temp.left != null) {
                    System.out.print("L:" + temp.left.data + ",");
                    queue.add(temp.left);
                } else {
                    System.out.print("L:" + -1 + ",");
                }

                if (temp.right != null) {
                    System.out.println("R:" + temp.right.data);
                    queue.add(temp.right);
                } else {
                    System.out.println("R:" + -1);
                }
            }
            System.out.println();
        }
    }

    public static int countNodes(BinaryTreeNode<Integer> root) {
        int count = 0;
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> temp = queue.poll();
            count++;
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        return count;
    }

    public static int heightOfBinaryTree(BinaryTreeNode<Integer> root) {
        int count = 0;
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode<Integer> temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            count++;
        }
        return count;
    }

    public static void mirrorBinaryTree(BinaryTreeNode<Integer> root) {
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> temp = queue.poll();
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }

            if (temp.left != null && temp.right != null) {
                BinaryTreeNode<Integer> tempNode = temp.left;
                temp.left = temp.right;
                temp.right = tempNode;
            }
        }
        printLevelWise(root);
    }

    public static int diameter(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int option1 = height(root.left) + height(root.right);
        int option2 = diameter(root.left);
        int option3 = diameter(root.right);

        return Math.max(option1, Math.max(option2, option3));
    }

    private static int height(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    /**
     * Beetter way to find dia,eter of a tree. Must learn this
     *
     * @param root
     * @return
     */
    public static Pair<Integer, Integer> heightDiameter(BinaryTreeNode<Integer> root) {
        if (root == null) {
            Pair<Integer, Integer> output = new Pair<>();
            output.first = 0;
            output.second = 0;
            return output;
        }

        Pair<Integer, Integer> lo = heightDiameter(root.left);
        Pair<Integer, Integer> ro = heightDiameter(root.right);

        int height = 1 + Math.max(lo.first, ro.first);
        int option1 = lo.first + ro.first;
        int option2 = lo.second;
        int option3 = ro.second;
        int diameter = Math.max(option1, Math.max(option2, option3));
        Pair<Integer, Integer> output = new Pair<>();
        output.first = height;
        output.second = diameter;
        return output;
    }

    public static BinaryTreeNode<Integer> buildTree(int in[], int pre[]) {
        return buildTreeHelper(in, pre, 0, in.length - 1, 0, pre.length - 1);
    }

    private static BinaryTreeNode<Integer> buildTreeHelper(int[] in, int[] pre, int inS, int inE, int preS, int preE) {
        if (inS > inE)
            return null;

        int rootData = pre[preS];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        int rootIndex = -1;
        for (int i = inS; i <= inE; i++) {
            if (in[i] == rootData) {
                rootIndex = i;
            }
        }

        if (rootIndex == -1) {
            return null;
        }

        int leftinS = inS;
        int leftinE = rootIndex - 1;
        int leftpreS = preS + 1;
        int leftpreE = leftinE - leftinS + leftpreS;

        int rightinS = rootIndex + 1;
        int rightinE = inE;
        int rightpreS = leftpreE + 1;
        int rightpreE = preE;

        root.left = buildTreeHelper(in, pre, leftinS, leftinE, leftpreS, leftpreE);
        root.right = buildTreeHelper(in, pre, rightinS, rightinE, rightpreS, rightpreE);

        return root;
    }

    private static BinaryTreeNode<Integer> deleteLeafNode(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return null;
        }

        root.left = deleteLeafNode(root.left);
        root.right = deleteLeafNode(root.right);

        return root;
    }

    public static ArrayList<Node<BinaryTreeNode<Integer>>> LLForEachLevel(BinaryTreeNode<Integer> root) {
        ArrayList<Node<BinaryTreeNode<Integer>>> resultList = new ArrayList<>();
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            Node<BinaryTreeNode<Integer>> head = null;
            Node<BinaryTreeNode<Integer>> tail = null;

            for (int i = 0; i < size; i++) {
                BinaryTreeNode<Integer> temp = queue.poll();
                Node<BinaryTreeNode<Integer>> node = new Node<>(temp);
                if (head == null) {
                    head = node;
                    tail = head;
                } else {
                    tail.next = node;
                    tail = tail.next;
                }

                if (temp.left != null) {
                    queue.add(temp.left);
                }

                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            resultList.add(head);
        }
        return resultList;
    }

    public static void printZigZag(BinaryTreeNode<Integer> root) {
        LinkedList<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (count % 2 == 0) {
                    BinaryTreeNode<Integer> temp = queue.pollFirst();
                    System.out.print(temp.data + " ");
                    if (temp.left != null) {
                        queue.add(temp.left);
                    }
                    if (temp.right != null) {
                        queue.add(temp.right);
                    }
                } else {
                    BinaryTreeNode<Integer> temp = queue.poll();
                    list.add(temp.data);
                    if (temp.left != null) {
                        queue.add(temp.left);
                    }
                    if (temp.right != null) {
                        queue.add(temp.right);
                    }
                }
            }
            if (!list.isEmpty()) {
                Collections.reverse(list);
                for (int i = 0; i < list.size(); i++) {
                    System.out.print(list.get(i) + " ");

                }
                list.clear();
            }
            count++;
            System.out.println();
        }
    }
}

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
    }
}