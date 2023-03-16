package Tree.BinaryTree;

import java.util.Stack;

public class Main {

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static class Pair { // helper class for pairing of left and right and mainting state to process a
                               // Child
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

    static int getsize(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSize = getsize(root.left);
        int rightSize = getsize(root.right);
        return 1 + leftSize + rightSize;
    }

    static int getsum(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSize = getsum(root.left);
        int rightSize = getsum(root.right);
        return root.data + leftSize + rightSize;
    }

    static int getMax(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int l = getMax(node.left);
        int r = getMax(node.right);

        return Math.max(Math.max(l, r), node.data);
    }

    static int getHeight(Node node) {
        if (node == null) {
            return -1;
         }
        int L = getHeight(node.left);
        int r = getHeight(node.right);

        int ans = Math.max(L, r);

        return ans + 1;

    }

    public static void main(String[] args) {
        Integer arr[] = { 10, 20, 40, 60, null, null, null, 50, 70, null, null, 80, null, null, 30, null, 90, 100, null,
                null, null };
        Node root = construct(arr);
        display(root);
        int ans = getsize(root);
        int sum = getsum(root);
        System.out.println("Size " + ans);
        System.out.println("Sum of the Tree " + sum);
        System.out.println("The biggest of all isss " + getMax(root));
        System.out.println("Depth " + getHeight(root));
    }
}
