package hw7_21000506_nguyenthithanhhuong.ex02.time_compare;

public class Main {
    public static void main(String[] args) {
        Time.timeSort(1000000);
        Time.timeSort(10000000);
        Time.timeSort(100000000);
    }
}
//Result:
//    N = 1000000
//    1. Sequential Search: 7.325000ms
//    2. Binary Search: 0.032100ms
//    3. Binary Search Tree: 0.016300ms
//    N = 10000000
//    1. Sequential Search: 4.308200ms
//    2. Binary Search: 0.010800ms
//    3. Binary Search Tree: 0.009200ms
//    N = 100000000
//    1. Sequential Search: 79.480500ms
//    2. Binary Search: 0.017800ms