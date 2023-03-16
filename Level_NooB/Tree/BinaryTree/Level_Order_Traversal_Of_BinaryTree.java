package Tree.BinaryTree;

import java.util.*;

public class Level_Order_Traversal_Of_BinaryTree {
    // print tree level by level, left to right. Each level must be on a separate
    // line and elements of same level should be separated by space

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node) {
            this.node = node;
            this.state = 0;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0]);
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root));
        int idx = 1;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 0) {
                Integer val = arr[idx];
                if (val != null) {
                    Node child = new Node(val);
                    top.node.left = child;
                    st.push(new Pair(child));
                }
                top.state++;
                idx++;
            } else if (top.state == 1) {
                Integer val = arr[idx];
                if (val != null) {
                    Node child = new Node(val);
                    top.node.right = child;
                    st.push(new Pair(child));
                }
                top.state++;
                idx++;
            } else if (top.state == 2) {
                st.pop();
            }
        }
        return root;
    }

    static void display(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.left == null ? "." : node.left.data);
        System.out.print(" <- " + node.data + " -> ");
        System.out.print(node.right == null ? "." : node.right.data);
        System.out.println();
        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) {
        Integer arr[] = { 10, 20, 40, 60, null, null, null, 50, 70, null, null, 80, null, null, 30, null, 90, 100, null,
                null, null };
        Node root = construct(arr);
        displayLevelOrder(root);
    }

    static void displayLevelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> main = new ArrayDeque<>();
        Queue<Node> helper = new ArrayDeque<>(); 
        main.add(root);
        while (main.size() > 0) {
            Node pr = main.remove();
            System.out.println(pr.data);
            if (pr.left != null) {
                helper.add(pr.left);
            }
            if (pr.right != null) {
                helper.add(pr.right);
            }
            if (main.size() == 0) {
                Queue<Node> temp = main;
                main = helper;
                helper = temp;
            }
        }

    }
}
