package Tree.GenericTree;

import java.util.*;;

public class KthLargest {
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
        helper.add(root);
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

    int GetFloor(Node root, int k) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int Floor = Integer.MAX_VALUE;
        Stack<Node> helper = new Stack<>();
        helper.add(root);
        while (helper.size() != 0) {

            Node curr = helper.pop();
            if (curr.n >= k && curr.n < Floor) {
                Floor = curr.n;
            }
            for (Node child : curr.children) {
                helper.push(child);
            }
        }
        return Floor;
    }

    int GetCeil(Node root, int k) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int Ceil = Integer.MIN_VALUE;
        Stack<Node> helper = new Stack<>();
        helper.add(root);
        while (helper.size() != 0) {
            Node curr = helper.pop();
            if (curr.n <= k && curr.n > Ceil) {
                Ceil = curr.n;
            }
            for (Node child : curr.children) {
                helper.push(child);
            }
        }
        return Ceil;
    }

    void getKthLargest(Node root, int k) {
        int c = GetCeil(root, Integer.MAX_VALUE);
        while (k != 1) {
            c = GetCeil(root, c);
            k--;
        }
    }
}
