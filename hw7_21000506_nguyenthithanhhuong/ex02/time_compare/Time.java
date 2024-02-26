package hw7_21000506_nguyenthithanhhuong.ex02.time_compare;

import hw7_21000506_nguyenthithanhhuong.ex02.binary_search_tree.BinarySearchTree;

public class Time {
    public static void timeSort(int n) {
        System.out.printf("N = %d\n", n);
        System.out.printf("1. Sequential Search: %fms\n", timeSequentialSearch(n));
        System.out.printf("2. Binary Search: %fms\n", timeBinarySearch(n));
        System.out.printf("3. Binary Search Tree: %fms\n", timeBinarySearchTree(n));
    }

    // evaluate time run sequential search algorithm
    public static double timeSequentialSearch(int n) {
        Integer[] array = new Integer[n];
        array = Generate.createSequentialSearchArray(array);
        Integer key = Generate.CreateKey(n);

        long start = System.nanoTime();
        Search.SequentialSearch(array, key);
        long end = System.nanoTime();

        return (end - start)/1000000.0;
    }

    // evaluate time run binary search algorithm
    public static double timeBinarySearch(int n) {
        Integer[] array = new Integer[n];
        array = Generate.createBinarySearchArray(array);
        Integer key = Generate.CreateKey(n);

        long start = System.nanoTime();
        Search.BinarySearch(array, key);
        long end = System.nanoTime();

        return (end - start)/1000000.0;
    }

    // evaluate time run binary search tree algorithm
    public static double timeBinarySearchTree(int n) {
        BinarySearchTree<Integer> tree = Generate.createBinarySearchTree(n);
        Integer key = Generate.CreateKey(n);

        long start = System.nanoTime();
        Search.BinarySearchTree(tree, key);
        long end = System.nanoTime();

        return (end - start)/1000000.0;
    }
}
