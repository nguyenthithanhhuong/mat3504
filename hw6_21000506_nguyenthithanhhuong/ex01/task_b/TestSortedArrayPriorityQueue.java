package hw6_21000506_nguyenthithanhhuong.ex01.task_b;


import hw6_21000506_nguyenthithanhhuong.ex01.priority_queue.PriorityQueueInterface;
import hw6_21000506_nguyenthithanhhuong.ex01.priority_queue.SortedArrayPriorityQueue;
import hw6_21000506_nguyenthithanhhuong.ex01.test_case.Test00;

public class TestSortedArrayPriorityQueue {
    public static void main(String[] args) {
        PriorityQueueInterface<Integer, String> priorityQueue = new SortedArrayPriorityQueue<>();

        new Test00(priorityQueue);
    }
}

//    Result:
//    1. Test isEmpty(): true
//    2. Test size(): 0
//    3. Test insert(K k, E e):
//    insert(1, "a"): {(1,a)}
//    insert(3, "c"): {(1,a), (3,c)}
//    insert(5, "e"): {(1,a), (3,c), (5,e)}
//    insert(2, "b"): {(1,a), (2,b), (3,c), (5,e)}
//    insert(4, "d"): {(1,a), (2,b), (3,c), (4,d), (5,e)}
//    4. Test isEmpty() after use insert(): false
//    5. Test size() after use insert(): 5
//    6. Test min(): (1,a)
//    7. Test removeMin():
//          removeMin(): (1,a)
//          Priority queue after first removeMin() : {(3,c), (5,e), (2,b), (4,d)}
//          removeMin(): (2,b)
//          Priority queue after second removeMin(): {(3,c), (5,e), (4,d)}