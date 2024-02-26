package hw7_21000506_nguyenthithanhhuong.ex01;

public class Test {
    public static void main(String[] args) {
        // test case
        Integer[] test = CreateTestCase.arrayTest();

        // 1. Test search UnsortedArrayList
        CreateTestCase.TestUnsortedArrayList(test);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        // 2. Test search SortedArrayList
        CreateTestCase.TestSortedArrayList(test);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        // 3. Test search UnsortedLinkedList
        CreateTestCase.TestUnsortedLinkedList(test);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        // 4. Test search SortedLinkedList
        CreateTestCase.TestSortedLinkedList(test);
    }
}

//    Result:
//    1. Test search UnsortedArrayList:
//    List: [4, 1, 5, 8, 9, 6]
//    List is contain 1 ~ isContain(1): true
//    List is contain 4 ~ isContain(4): true
//    List is contain 7 ~ isContain(7): false
//    List is contain 8 ~ isContain(8): true
//    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    2. Test search SortedArrayList:
//    List: [1, 4, 5, 6, 8, 9]
//    List is contain 1 ~ isContain(1): true
//    List is contain 4 ~ isContain(4): true
//    List is contain 7 ~ isContain(7): false
//    List is contain 8 ~ isContain(8): true
//    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    3. Test search UnsortedLinkedList:
//    List: [4, 1, 5, 8, 9, 6]
//    List is contain 1 ~ isContain(1): true
//    List is contain 4 ~ isContain(4): true
//    List is contain 7 ~ isContain(7): false
//    List is contain 8 ~ isContain(8): true
//    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    4. Test search SortedLinkedList:
//    List: [1, 4, 5, 6, 8, 9]
//    List is contain 1 ~ isContain(1): true
//    List is contain 4 ~ isContain(4): true
//    List is contain 7 ~ isContain(7): false
//    List is contain 8 ~ isContain(8): true
