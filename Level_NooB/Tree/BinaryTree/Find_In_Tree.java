package Tree.BinaryTree;

import java.util.*;

public class Find_In_Tree {

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

    static boolean findK(int k, Node root) {
        if (root == null) {
            return false;
        }
        if (root.data == k) {
            return true;
        }
        if (findK(k, root.left) || findK(k, root.right)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Integer arr[] = { 10, 20, 40, 60, null, null, null, 50, 70, null, null, 80, null, null, 30, null, 90, 100,
                null,
                null, null };
        Node root = construct(arr);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the num to find");
        int k = sc.nextInt();
        boolean ans = findK(k, root);
        System.out.println(ans);
    }
}