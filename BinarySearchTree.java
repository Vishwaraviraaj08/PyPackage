import java.util.function.Consumer;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    private static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void insert(T data) {
        root = insertRecursive(root, data);
    }

    private Node<T> insertRecursive(Node<T> current, T data) {
        if (current == null) {
            return new Node<>(data);
        }

        int cmp = data.compareTo(current.data);
        if (cmp < 0) {
            current.left = insertRecursive(current.left, data);
        } else if (cmp > 0) {
            current.right = insertRecursive(current.right, data);
        }

        return current;
    }

    public boolean contains(T data) {
        return containsRecursive(root, data);
    }

    private boolean containsRecursive(Node<T> current, T data) {
        if (current == null) {
            return false;
        }

        int cmp = data.compareTo(current.data);
        if (cmp == 0) {
            return true;
        } else if (cmp < 0) {
            return containsRecursive(current.left, data);
        } else {
            return containsRecursive(current.right, data);
        }
    }

    public void printInOrder() {
        printInOrderRecursive(root, System.out::print);
        System.out.println();
    }

    private void printInOrderRecursive(Node<T> current, Consumer<T> action) {
        if (current != null) {
            printInOrderRecursive(current.left, action);
            action.accept(current.data);
            printInOrderRecursive(current.right, action);
        }
    }

    public void printPreOrder() {
        printPreOrderRecursive(root, System.out::print);
        System.out.println();
    }

    private void printPreOrderRecursive(Node<T> current, Consumer<T> action) {
        if (current != null) {
            action.accept(current.data);
            printPreOrderRecursive(current.left, action);
            printPreOrderRecursive(current.right, action);
        }
    }

    public void printPostOrder() {
        printPostOrderRecursive(root, System.out::print);
        System.out.println();
    }

    private void printPostOrderRecursive(Node<T> current, Consumer<T> action) {
        if (current != null) {
            printPostOrderRecursive(current.left, action);
            printPostOrderRecursive(current.right, action);
            action.accept(current.data);
        }
    }

    public static void main(String[] args) {

        BinarySearchTree<Integer> intTree = new BinarySearchTree<>();
        intTree.insert(5);
        intTree.insert(3);
        intTree.insert(7);
        intTree.insert(2);
        intTree.insert(4);
        intTree.insert(6);
        intTree.insert(8);
        intTree.printInOrder();
        intTree.printPreOrder();
        intTree.printPostOrder();

        BinarySearchTree<String> stringTree = new BinarySearchTree<>();
        stringTree.insert("banana");
        stringTree.insert("apple");
        stringTree.insert("grape");
        stringTree.insert("orange");
        stringTree.insert("kiwi");
        stringTree.printInOrder();
        stringTree.printPreOrder();
        stringTree.printPostOrder();
    }
}
