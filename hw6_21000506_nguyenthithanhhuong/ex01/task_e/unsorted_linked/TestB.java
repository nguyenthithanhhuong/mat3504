package hw6_21000506_nguyenthithanhhuong.ex01.task_e.unsorted_linked;

import hw6_21000506_nguyenthithanhhuong.ex01.priority_queue.UnsortedLinkedPriorityQueue;
import hw6_21000506_nguyenthithanhhuong.ex01.test_case.TestEB;

public class TestB {
    public static void main(String[] args) {
        UnsortedLinkedPriorityQueue<Integer, String> priorityQueue = new UnsortedLinkedPriorityQueue<>();

        new TestEB(priorityQueue);
    }
}

//    Result:
//    Priority Queue: {(1,product01), (3,product03), (4,product04), (2,product02)}
//    1. Test isEmpty(): false
//    2. Test size(): 4
//    3. Test min(): (1,product01)
//    4. Test removeMin():
//        min(): (1,product01)
//        priority queue after removeMin(): {(3,product03), (4,product04), (2,product02)}