package Tree.GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class CeilFloorInGT {
    static class Node {
        int n;
        ArrayList<Node> children;

        Node(int val) {
            this.n = val;
            children = new ArrayList<>();
        }
    }

    void construct(Integer arr[]) {
        Node root = new Node(arr[0]);
        Stack<Node> helper = new Stack<>();
        int idx = 1;
        while (idx < arr.length) {
            if (arr[idx] == null) {
                helper.pop();
            } else {
                Node child = new Node(arr[idx]);
                Node par = helper.peek();
                par.children.add(child);
                helper.push(child);
            }
            idx++;
        }
    }

    int GetCeil(Node root, int k) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int Ceil = Integer.MAX_VALUE;
        Stack<Node> helper = new Stack<>();
        helper.add(root);
        while (helper.size() != 0) {

            Node curr = helper.pop();
            if (curr.n >= k && curr.n < Ceil) {
                Ceil = curr.n;
            }
            for (Node child : curr.children) {
                helper.push(child);
            }
        }
        return Ceil;
    }

    int GetFloor(Node root, int k) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int Floor = Integer.MIN_VALUE;
        Stack<Node> helper = new Stack<>();
        helper.add(root);
        while (helper.size() != 0) {
            Node curr = helper.pop();
            if (curr.n <= k && curr.n > Floor) {
                Floor = curr.n;
            }
            for (Node child : curr.children) {
                helper.push(child);
            }
        }
        return Floor;
    }
}
