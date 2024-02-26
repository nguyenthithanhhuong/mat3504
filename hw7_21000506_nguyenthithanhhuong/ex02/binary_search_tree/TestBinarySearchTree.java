package hw7_21000506_nguyenthithanhhuong.ex02.binary_search_tree;

public class TestBinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        System.out.println("1. Test insert(): ");
        System.out.println("insert(12): ");
        tree.insert(12);
        System.out.println(tree.toString());
        System.out.println("insert(18): ");
        tree.insert(18);
        System.out.println(tree.toString());
        System.out.println("insert(15): ");
        tree.insert(15);
        System.out.println(tree.toString());
        System.out.println("insert(10): ");
        tree.insert(10);
        System.out.println(tree.toString());

        System.out.print("2. Test findMin(): ");
        System.out.println(tree.findMin());

        System.out.println("3. Test search(): ");
        System.out.print("\tsearch(12): ");
        System.out.println(tree.search(12));
        System.out.print("\tsearch(8): ");
        System.out.println(tree.search(8));

        System.out.println("4. Test delete(): ");
        System.out.print("\tdelete(18): ");
        System.out.println(tree.delete(18));
        System.out.println("\ttree after delete(18): ");
        System.out.println(tree.toString());
    }
}

//    Result
//    1. Test insert():
//    insert(12):
//    12
//
//    insert(18):
//          18
//    12
//
//    insert(15):
//          18
//                 15
//    12
//
//    insert(10):
//          18
//                15
//    12
//          10
//
//    2. Test findMin(): 10
//    3. Test search():
//        search(12): 12
//        search(8): null
//    4. Test delete():
//        delete(18): 12
//          15
//    12
//          10
