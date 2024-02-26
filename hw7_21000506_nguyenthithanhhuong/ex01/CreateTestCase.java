package hw7_21000506_nguyenthithanhhuong.ex01;

import hw7_21000506_nguyenthithanhhuong.ex01.list_hw3.*;

public class CreateTestCase {
    // Test case
     public static Integer[] arrayTest() {
        Integer[] array = {4, 1, 5, 8, 9, 6};
        return array;
    }

    // Test search UnsortedArrayList
    public static void TestUnsortedArrayList(Integer[] array) {
        System.out.println("1. Test search UnsortedArrayList: ");

        ListInterface<Integer> list = new UnsortedArrayList<>(array.length);
        for (Integer element : array) {
            list.add(element);
        }
        System.out.printf("List: %s\n", list.toString());

        System.out.printf("List is contain %d ~ isContain(%d): %s\n", 1, 1, list.isContain(1));
        System.out.printf("List is contain %d ~ isContain(%d): %s\n", 4, 4, list.isContain(4));
        System.out.printf("List is contain %d ~ isContain(%d): %s\n", 7, 7, list.isContain(7));
        System.out.printf("List is contain %d ~ isContain(%d): %s\n", 8, 8, list.isContain(8));
    }

    // Test search SortedArrayList
    public static void TestSortedArrayList(Integer[] array) {
        System.out.println("2. Test search SortedArrayList: ");

        ListInterface<Integer> list = new SortedArrayList<>(array.length);
        for (Integer element : array) {
            list.add(element);
        }
        System.out.printf("List: %s\n", list.toString());

        System.out.printf("List is contain %d ~ isContain(%d): %s\n", 1, 1, list.isContain(1));
        System.out.printf("List is contain %d ~ isContain(%d): %s\n", 4, 4, list.isContain(4));
        System.out.printf("List is contain %d ~ isContain(%d): %s\n", 7, 7, list.isContain(7));
        System.out.printf("List is contain %d ~ isContain(%d): %s\n", 8, 8, list.isContain(8));
    }

    // Test search UnsortedLinkedList
    public static void TestUnsortedLinkedList(Integer[] array) {
        System.out.println("3. Test search UnsortedLinkedList: ");

        ListInterface<Integer> list = new UnsortedLinkedList<>();
        for (Integer element : array) {
            list.add(element);
        }
        System.out.printf("List: %s\n", list.toString());

        System.out.printf("List is contain %d ~ isContain(%d): %s\n", 1, 1, list.isContain(1));
        System.out.printf("List is contain %d ~ isContain(%d): %s\n", 4, 4, list.isContain(4));
        System.out.printf("List is contain %d ~ isContain(%d): %s\n", 7, 7, list.isContain(7));
        System.out.printf("List is contain %d ~ isContain(%d): %s\n", 8, 8, list.isContain(8));
    }

    // Test search SortedLinkedList
    public static void TestSortedLinkedList(Integer[] array) {
        System.out.println("4. Test search SortedLinkedList: ");

        ListInterface<Integer> list = new SortedLinkedList<>();
        for (Integer element : array) {
            list.add(element);
        }
        System.out.printf("List: %s\n", list.toString());

        System.out.printf("List is contain %d ~ isContain(%d): %s\n", 1, 1, list.isContain(1));
        System.out.printf("List is contain %d ~ isContain(%d): %s\n", 4, 4, list.isContain(4));
        System.out.printf("List is contain %d ~ isContain(%d): %s\n", 7, 7, list.isContain(7));
        System.out.printf("List is contain %d ~ isContain(%d): %s\n", 8, 8, list.isContain(8));
    }
}
