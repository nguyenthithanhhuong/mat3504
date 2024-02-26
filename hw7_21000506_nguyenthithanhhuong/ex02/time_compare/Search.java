package hw7_21000506_nguyenthithanhhuong.ex02.time_compare;

import hw7_21000506_nguyenthithanhhuong.ex02.binary_search_tree.BinarySearchTree;

public class Search {
    // sequential search algorithm
    public static boolean SequentialSearch(Integer[] array, Integer key) {
        for (Integer element : array) {
            if (key.equals(element)) {
                return true;
            }
        }
        return false;
    }

    // binary search algorithm
    public static boolean BinarySearch(Integer[] array, Integer key) {
        Integer first = 0;
        Integer last = array.length - 1;

        while (first <= last) {
            int mid = (first + last)/2;
            if (array[mid].equals(key)) return true;
            if (array[mid].compareTo(key) < 0) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }
        return false;
    }

    // binary search tree algorithm
    public static void BinarySearchTree(BinarySearchTree<Integer> tree, Integer key) {
        tree.search(key);
    }
}
