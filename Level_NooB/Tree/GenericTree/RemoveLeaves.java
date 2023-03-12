package Tree.GenericTree;

import java.util.*;;

public class RemoveLeaves {

    public static void main(String[] args) {
        Integer[] arr = { 10, 20, 50, null, 60, null, null, 30, 70, 90, null, 100, null, 110, null, null, null, 40, 80,
                null, null, null };
        Node root = construct(arr);
        display(root);
        System.out.println("Removedd");
        Remove(root);
        display(root);
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

    public static void Remove(Node node) {
        for (int i = node.children.size() - 1; i >= 0; i--) {
            Node child = node.children.get(i);
            if (child.children.size() == 0) {
                node.children.remove(i);
            }
        }

        for (Node child : node.children) {
            Remove(child);
        }
    }
}
