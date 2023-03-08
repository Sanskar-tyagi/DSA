package Tree.GenericTree;

import java.util.*;;

public class Pre_PostOderTraverse {

    // 1. You are given a partially written GenericTree class.
    // 2. You are required to complete the body of traversals function. The function
    // is expected to visit every node. While traversing the function must print
    // following content in different situations.
    // 2.1. When the control reaches the node for the first time -> "Node Pre"
    // node.data.
    // 2.2. Before the control leaves for a child node from a node -> "Edge Pre"
    // node.data--child.data.
    // 2.3. After the control comes back to a node from a child -> "Edge Post"
    // node.data-
    // -child.data.
    // 2.4. When the control is about to leave node, after the children have been
    // visited
    // -> "Node Post" node.data.
    public static void main(String[] args) {
        Integer[] arr = { 10, 20, 50, null, 60, null, null, 30, 70, 90, null, 100, null, 110, null, null, null, 40, 80,
                null, null, null };
        Node root = construct(arr);
        display(root);
        int treeSize = height(root);
        System.out.println(treeSize);
    }

    public static void Traverse(Node n) {
        System.out.println("NODE PRE" + n.data);
        for (Node x : n.children) {
            System.out.println("EDGE PRE" + n.data + "--->" + x.data);
            Traverse(x);
            System.out.println("EDGE POST" + n.data + "--->" + x.data);
        }
        System.out.println("NODE POST" + n.data);

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

    public static Node construct(Integer arr[]) { // we will use Integer wrapper class instead of small int because we
                                                  // will be identifying end & leafnodes by adding null.
        Node root = new Node(arr[0]);
        Stack<Node> helper = new Stack<>();
        int idx = 1;
        helper.add(root);
        while (idx < arr.length) {
            Integer val = arr[idx];
            if (arr[idx] == null) {
                helper.pop(); // Meaning it has no more chlid nodes so we wont be Using it as parent anymore.
            } else {
                Node child = new Node(val);
                Node par = helper.peek();
                par.children.add(child);
                helper.push(child); // Now Child will be parent.
            }
            idx++;
        }
        return root;

    }

    static int size(Node n) {
        int count = 1;
        for (Node m : n.children) {
            count += size(m);
        }
        return count;
    }

    static int maxval(Node n, int maxsofar) { // My approch
        int max = n.data;
        for (Node m : n.children) {
            int childMax = maxval(m, maxsofar);
            if (childMax > max) {
                max = childMax;
            }
        }
        if (max > maxsofar) {
            return max;
        } else {
            return maxsofar;
        }
    }

    public static int max(Node node) { // Teacher's Approach
        int res = Integer.MIN_VALUE;
        for (Node child : node.children) {
            res = Math.max(res, max(child));
        }
        return Math.max(res, node.data);
    }

    public static int height(Node node) {
        if (node == null) {
            return 0;
        }

        int maxChildHeight = 0;
        for (Node child : node.children) {
            int childHeight = height(child);
            if (childHeight > maxChildHeight) {
                maxChildHeight = childHeight;
            }
        }

        return 1 + maxChildHeight;
    }

}
