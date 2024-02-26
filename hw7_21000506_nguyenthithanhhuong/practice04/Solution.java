package hw7_21000506_nguyenthithanhhuong.practice04;

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
    public int getCount(Node root, int l, int h) {
        List<Integer> elements = new ArrayList<>();
        inorderTraversal(root, elements);

        int count = 0;

        for (Integer element : elements) {
            if (element >= l && element <= h) count++;
        }

        return count;
    }

    // create in-order traversal of tree
    public static void inorderTraversal(Node root, List<Integer> elements) {
        if (root != null) {
            inorderTraversal(root.left, elements);
            elements.add(root.data);
            inorderTraversal(root.right, elements);
        }
    }
}
