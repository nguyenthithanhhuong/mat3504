package hw7_21000506_nguyenthithanhhuong.ex02.binary_search_tree;

import hw7_21000506_nguyenthithanhhuong.ex02.binary_tree_hw5.LinkedBinaryTree;

public class BinarySearchTree<E extends Comparable<E>> extends LinkedBinaryTree<E, LinkedBinaryTree.Node<E>> {

    public E findMin() {
        if (root() == null) return null;
        return findMin(root());
    }

    private E findMin(Node<E> root) {
        if (root == null) return null;
        while (root.getLeft() != null) root = root.getLeft();
        return root.getElement();
    }

    public Node<E> search(E x) {
        if (root() == null) return null;
        Node<E> node = root();
        while (node != null) {
            if (x.equals(node.getElement())) {
                return node;
            } else if (x.compareTo(node.getElement()) < 0) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }
        return null;
    }

    public boolean insert(E x) {
        return insert(root(), x);
    }

    private boolean insert(Node<E> node, E x) {
        if (x == null) return false;
        if (root() == null) {
            addRoot(x);
            return true;
        }
        while (root() != null) {
            if (x.equals(node.getElement())) return false;
            if (x.compareTo(node.getElement()) < 0) {
                if (node.getLeft() == null) {
                    addLeft(node, x);
                    return true;
                }
                return insert(node.getLeft(), x);
            } else if (x.compareTo(node.getElement()) > 0) {
                if (node.getRight() == null) {
                    addRight(node, x);
                    return true;
                }
                return insert(node.getRight(), x);
            } else {
                return false;
            }
        }
        return false;
    }

    public Node<E> delete(E x) {
        if (x == null) return root();
        return delete(root(), x);
    }

    private Node<E> delete(Node<E> node, E x) {
        if (node == null) return null;
        // case 1 ~ node has no children
        if (node.getLeft() == null && node.getRight() == null) {
            if (x.equals(node.getElement())) return null;
            return node;
        }
        // case 2(a) ~ node has only left child
        if (node.getLeft() != null && node.getRight() == null) {
            if (x.equals(node.getElement())) {
                return node.getLeft();
            }
            node.setLeft(delete(node.getLeft(), x));
            if (node.getLeft() != null) node.getLeft().setParent(node);
            return node;
        }
        // case 2(b) ~ node has only right child
        if (node.getLeft() == null && node.getRight() != null) {
            if (x.equals(node.getElement())) {
                return node.getRight();
            }
            node.setRight(delete(node.getRight(), x));
            if (node.getRight() != null) node.getRight().setParent(node);
            return node;
        }
        // case 3 ~ node has two children
        if (x.equals(node.getElement())) {
            node.setElement(findMin(node.getRight()));
            node.setRight(delete(node.getRight(), node.getElement()));
        } else if (x.compareTo(node.getElement()) < 0) {
            node.setLeft(delete(node.getLeft(), x));
        } else {
            node.setRight(delete(node.getRight(), x));
        }
        return node;
    }
}
