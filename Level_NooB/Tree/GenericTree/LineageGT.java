package Tree.GenericTree;

import java.text.NumberFormat.Style;
import java.util.*;;

public class LineageGT {
    // ! Q-> https://nados.io/question/linearize-a-generic-tree
    // ! Linearize A Generic Tree

    // You are required to complete the body of linearize function. The function is
    // expected to create a linear tree i.e. every node will have a single child
    // only.
    public static void main(String[] args) {
        Integer[] arr = { 10, 20, 50, null, 60, null, null, 30, 70, 90, null, 100, null, 110, null, null, null, 40, 80,
                null, null, null };
        Node root = construct(arr);
    }

    static class Node {
        Integer data;
        ArrayList<Node> children;

        Node(int val) {
            this.data = val;
            children = new ArrayList<>();
        }
    }

    static void display(Node n) {

        System.out.print(n.data + " --> ");
        for (Node m : n.children) {
            System.out.print(m.data + " ");
        }
        System.out.println(" LeafNode");
        for (Node m : n.children) {
            display(m);
        }
    }

    public static Node construct(Integer arr[]) {
        Node root = new Node(arr[0]);
        Stack<Node> helper = new Stack<>();
        int idx = 1;
        helper.add(root);
        while (idx < arr.length) {
            Integer val = arr[idx];
            if (arr[idx] == null) {
                helper.pop();
            } else {
                Node child = new Node(val);
                Node par = helper.peek();
                par.children.add(child);
                helper.push(child);
            }
            idx++;
        }
        return root;
    }

    public static void LineageTree(Node node) {
        if (node.children.size() == 0)
            return;
        System.out.println(node.data);
        for (Node child : node.children) {
            LineageTree(child);
        }
        while (node.children.size() > 1) {
            Node Lc = node.children.get(node.children.size() - 1);
            Node sLc = node.children.get(node.children.size() - 2);
            node.children.remove(node.children.size() - 1);
            Node tailNode = getTailNode(sLc);
            tailNode.children.add(Lc);
        }
    }

    public static Node getTailNode(Node node) {
        while (node.children.size() != 0) {
            node = node.children.get(0);
        }
        return node;
    }

}
