package Tree.BinaryTree;

import java.util.*;

public class RemoveLeaves {
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

    public static Node removeLeave(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        root.left = removeLeave(root.left);
        root.right = removeLeave(root.right);
        return root;
    }

    public static void main(String[] args) {
        Integer arr[] = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };
        Node root = construct(arr);
        display(root);
        removeLeave(root);
        display(root);

    }
}
