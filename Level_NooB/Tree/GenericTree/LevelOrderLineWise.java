package Tree.GenericTree;

import java.util.*;;

public class LevelOrderLineWise {

    // 1. You are given a partially written GenericTree class.
    // 2. You are required to complete the body of levelorder function. The function
    // is expected to visit every node in "levelorder fashion". Please check the
    // question video for more details.
    // 3. Input is managed for you.
    public static void main(String[] args) {
        Integer[] arr = { 10, 20, 50, null, 60, null, null, 30, 70, 90, null, 100, null, 110, null, null, null, 40, 80,
                null, null, null };
        Node root = construct(arr);
        display(root);
        int treeSize = height(root);
        System.out.println(treeSize);
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

    public static void levelOrderLinewise(Node node) {
        Queue<Node> mq = new ArrayDeque<>();
        Queue<Node> hq = new ArrayDeque<>();
        mq.add(node);

        while (mq.size() > 0) {
            Node rem = mq.remove();
            System.out.print(rem.data + " ");

            for (Node child : rem.children) {
                hq.add(child);
            }

            if (mq.size() == 0) {
                System.out.println();
                Queue<Node> tq = mq;
                mq = hq;
                hq = tq;
            }
        }
    }
}
