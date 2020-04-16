package codingninjas.lecture12.bst;

import codingninjas.lecture11.binarytree.BinaryTreeNode;

import java.util.*;

public class TreeUseBST<T> {
    public static void main(String[] args) {
        /*BinaryTreeNode<Integer> root = TreeUse.takeInpputLeveLWise();
        TreeUse.printLevelWise(root);
        System.out.println("===============================");*/
        /*LinkedListNode<Integer> head = BSTToSortedLL(root);
        printList(head);*/
        //System.out.println(findPath(root, 2));

//        Scanner sc = new Scanner(System.in);
        /*BinarySearchTree bst = new BinarySearchTree();
        for (int i = 0; i < 7; i++) {
            bst.insertData(sc.nextInt());
        }*/
        //System.out.println(bst.hasData(20));
        //BinarySearchTree.nodesSumToS(root, 17);

        String str = "abc|def|fre";
        String res[] = str.split("\\|");
        for (String a:res) {
            System.out.println(a);
        }
    }

    public static void printList(LinkedListNode<Integer> node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static BinarySearchTreeNode<Integer> takeInpputLeveLWise() {
        Scanner s = new Scanner(System.in);
        Queue<BinarySearchTreeNode<Integer>> queue = new LinkedList<>();

        System.out.println("Enter root data:");
        int rootData = s.nextInt();

        if (rootData == -1) {
            return null;
        }

        BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(rootData);
        queue.add(root);

        while (!queue.isEmpty()) {
            BinarySearchTreeNode<Integer> temp = queue.poll();
            System.out.println("Enter left child of node: " + temp.data);
            int leftChild = s.nextInt();
            if (leftChild != -1) {
                BinarySearchTreeNode<Integer> left = new BinarySearchTreeNode<>(leftChild);
                queue.add(left);
                temp.left = left;
            }
            System.out.println("Enter right child of node: " + temp.data);
            int rightChild = s.nextInt();
            if (rightChild != -1) {
                BinarySearchTreeNode<Integer> right = new BinarySearchTreeNode<>(rightChild);
                queue.add(right);
                temp.right = right;
            }
        }
        return root;
    }

    public static boolean isBST(BinarySearchTreeNode<Integer> root) {
        if (root == null) {
            return true;
        }

        int leftMax = maximum(root.left);
        int rightMin = minimum(root.left);

        if (root.data <= leftMax) {
            return false;
        }

        if (root.data >= rightMin) {
            return false;
        }

        boolean isleftBst = isBST(root.left);
        boolean isRightBst = isBST(root.right);

        if (isleftBst && isRightBst) {
            return true;
        } else return false;
    }

    private static int minimum(BinarySearchTreeNode<Integer> root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        return Math.min(root.data, Math.min(minimum(root.left), minimum(root.right)));
    }

    private static int maximum(BinarySearchTreeNode<Integer> left) {
        return 0;
    }

    public static BinarySearchTreeNode<Integer> SortedArrayToBST(int[] arr){
        return SortedArrayToBSTHelper(arr, 0, arr.length - 1);
    }

    public static BinarySearchTreeNode<Integer> SortedArrayToBSTHelper(int[] arr, int start, int end){
        if(start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(arr[mid]);
        root.left = SortedArrayToBSTHelper(arr, start, mid - 1);
        root.right = SortedArrayToBSTHelper(arr, mid+1, end);
        return root;
    }

    public static LinkedListNode<Integer> BSTToSortedLL(BinaryTreeNode<Integer> root){
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> tail = null;
        while (true){
            if (root!=null){
                stack.push(root);
                root = root.left;
            } else {
                if (stack.isEmpty()) break;

                BinaryTreeNode<Integer> temp = stack.pop();
                if(head == null) {
                    head = new LinkedListNode(temp.data);
                    tail = head;
                    System.out.println(tail.data + " ");
                } else {
                    tail.next = new LinkedListNode(temp.data);
                    tail = tail.next;
                    System.out.println(tail.data + " ");
                }
                root = temp.right;
            }
        }
        return head;
    }

    public static ArrayList<Integer> findPath(BinaryTreeNode<Integer> root, int data){
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if(root == null) {
            return null;
        }
        ArrayList<Integer> al = new ArrayList<>();
        while(root != null) {
            if(root.data.compareTo(data) > 0) {
                al.add(root.data);
                root = root.left;
                continue;
            }
            if(root.data.compareTo(data) < 0) {
                al.add(root.data);
                root = root.right;
                continue;
            }
            if(root.data.compareTo(data) == 0) {
                al.add(root.data);
                break;
            }
        }
        if(al.contains(data)) {
            Collections.reverse(al);
        } else al.clear();
        return al;
    }
}

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}