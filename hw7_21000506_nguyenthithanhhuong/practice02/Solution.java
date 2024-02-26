package hw7_21000506_nguyenthithanhhuong.practice02;

public class Solution {
     public static class Node {
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
    public static boolean isBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBST(Node root, int min, int max) {
        if (root == null) return true;
        if (root.data < min || root.data > max) return false;

        return (isBST(root.left, min, root.data - 1)
                && isBST(root.right, root.data + 1, max));
    }
}
