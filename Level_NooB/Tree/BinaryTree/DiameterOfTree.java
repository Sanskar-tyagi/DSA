package Tree.BinaryTree;

import java.util.*;;

public class DiameterOfTree {
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
        Integer arr[] = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };
        Node root = construct(arr);
        display(root);
        CustomPair res = Diameter(root);
        System.out.println(res.dia);

    }

    public static class CustomPair {
        int dia, ht;

        CustomPair(int ht, int dia) {
            this.dia = dia;
            this.ht = ht;
        }
    }

    public static CustomPair Diameter(Node root) {
        if (root == null) {// We put the value for the diameter and Height of a node as -1 because
                           // when we calculate a leaf nodes Height it is done by calculating ->
                           // Max(LeftHt,RightHt)+1 which will be zero which is correct for a leafNode
                           // For Diameter we have algo as (Leftchild+Rightchild+2)= 0;
            return new CustomPair(-1, -1);
        }

        CustomPair leftPair = Diameter(root.left);
        CustomPair rightPair = Diameter(root.right);

        int Mydia = leftPair.ht + rightPair.ht + 2;
        int MyHt = Math.max(leftPair.ht, rightPair.ht) + 1;
        int OverAllDia = Math.max(Mydia, Math.max(leftPair.dia, rightPair.dia));
        return new CustomPair(MyHt, OverAllDia);
    }

    // time complexity -> O(N) because each node is visited thrice in Pre Post and
    // IN order
    // O(3N)= O(N)
}
