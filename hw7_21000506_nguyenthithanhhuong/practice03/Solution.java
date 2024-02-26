package hw7_21000506_nguyenthithanhhuong.practice03;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }

    // Solve
    public static float findMedian(Node root) {
        List<Integer> elements = new ArrayList<>();
        inorderTraversal(root, elements);

        if (elements.size() % 2 != 0) {
            return elements.get(elements.size()/2);
        } else {
            int temp1 = elements.size()/2;
            int temp2 = elements.size()/2 - 1;
            return (float) ((elements.get(temp1) + elements.get(temp2))/2.0);
        }
    }

    // create list in-order traversal of tree
    public static void inorderTraversal(Node root, List<Integer> elements) {
        if (root != null) {
            inorderTraversal(root.left, elements);
            elements.add(root.data);
            inorderTraversal(root.right, elements);
        }
    }
}
