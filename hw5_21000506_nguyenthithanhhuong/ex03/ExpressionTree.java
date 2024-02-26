package hw5_21000506_nguyenthithanhhuong.ex03;

import hw5_21000506_nguyenthithanhhuong.ex01.binary_tree.LinkedBinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionTree {
    private static LinkedBinaryTree tree;

    public ExpressionTree(LinkedBinaryTree tree) {
        this.tree = tree;
    }
    public static List<String> infixToPostfix(String[] tokens) {
        Stack<String> stack = new Stack<>();
        List<String> postfix = new ArrayList<>();

        for (int i = 0; i < tokens.length; i++) {
            if (isNumber(tokens[i])) {
                postfix.add(tokens[i]);
            } else if (tokens[i].equals("(")) {
                stack.push(tokens[i]);
            } else if (tokens[i].equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix.add(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty()
                        && precedence(tokens[i]) <= precedence(stack.peek())) {
                    postfix.add(stack.pop());
                }
                stack.push(tokens[i]);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek().equals("("))
                System.out.println("Invalid Expression");
            postfix.add(stack.peek());
            stack.pop();
        }
        return postfix;
    }

    // Precedence of operation
    // higher value ~ higher precedence
    public static int precedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return -1;
        }
    }

    // Check a String is a number or not
    public static boolean isNumber(String str) {
        Integer num = null;
        try {
            num = Integer.parseInt(str);
        } catch (Exception e) {

        }
        if (num == null) return false;
        return true;
    }

    public static LinkedBinaryTree postfixToTree(List<String> postfix) {
        Stack<LinkedBinaryTree.Node> nodes = new Stack<LinkedBinaryTree.Node>();
        for (String token : postfix) {
            if (!isOperator(token)) {
                nodes.push(new LinkedBinaryTree.Node<>(token, null, null, null));
            } else {
                LinkedBinaryTree.Node<String> left = nodes.pop();
                LinkedBinaryTree.Node<String> right = nodes.pop();

                LinkedBinaryTree.Node<String> newNode = new LinkedBinaryTree.Node();
                newNode.setElement(token);
                newNode.setLeft(left);
                newNode.setRight(right);
                nodes.push(newNode);
            }
        }
        LinkedBinaryTree.Node root = nodes.pop();
        tree.addRoot(root);
        return tree;
    }

    public static boolean isOperator(String op) {
        if (op == null) return false;
        return op.equals("+")
                || op.equals("-")
                || op.equals("*")
                || op.equals("/");
    }

    public String toString() {
        return tree.toString();
    }

    public static void main(String[] args) {
        String[] tokens = {"(", "6", "/", "2", "+", "3", ")", "*", "(", "7", "-", "4", ")"};
        List postfix = infixToPostfix(tokens);
        LinkedBinaryTree tree = new LinkedBinaryTree<>();
        tree = postfixToTree(postfix);
        System.out.println(tree.toString());
    }
}
