package codingninjas.lecture12.bst;

public class BinarySearchTreeNode<T> {
    T data;
    BinarySearchTreeNode<T> left;
    BinarySearchTreeNode<T> right;

    public BinarySearchTreeNode(T data) {
        this.data = data;
    }
}
