package hw7_21000506_nguyenthithanhhuong.ex02.time_compare;

import hw7_21000506_nguyenthithanhhuong.ex02.binary_search_tree.BinarySearchTree;

public class Generate {
    // Create random key between 1-n
    public static Integer CreateKey(int n) {
        int min = 1;
        int max = n;
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    // Create array test for sequential search
    public static Integer[] createSequentialSearchArray(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = CreateKey(array.length);
        }
        return array;
    }

    // Create array test for binary search
    public static Integer[] createBinarySearchArray(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        return array;
    }

    // Create tree test for binary search tree
    public static BinarySearchTree<Integer> createBinarySearchTree(int n) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for (int i = 0; i < n; i++) {
            tree.insert(CreateKey(n));
        }
        return tree;
    }
}
