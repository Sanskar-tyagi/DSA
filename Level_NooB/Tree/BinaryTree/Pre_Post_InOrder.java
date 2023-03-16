package Tree.BinaryTree;

import java.util.*;

public class Pre_Post_InOrder {

    // Pre-> Node Left Right
    // IN-> Left Node Right
    // Post -> Left Right Node

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

    public static void main(String[] args) {
        Integer arr[] = { 10, 20, 40, 60, null, null, null, 50, 70, null, null, 80, null, null, 30, null, 90, 100, null,
                null, null };
        Node root = construct(arr);
        System.out.print("Pre order ");
        displayPre(root);
        System.out.println();
        System.out.print("In order ");
        displayInOrder(root);
        System.out.println();
        System.out.print("Post Order ");
        displayPost(root);
    }

    static void displayPre(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        displayPre(node.left);
        displayPre(node.right);

    }

    static void displayInOrder(Node node) {
        if (node == null)
            return;
        displayInOrder(node.left);
        System.out.print(node.data + " ");
        displayInOrder(node.right);

    }

    static void displayPost(Node node) {
        if (node == null)
            return;
        displayPost(node.left);
        displayPost(node.right);
        System.out.print(node.data + " ");

    }
}
