package Tree.GenericTree;

import java.util.*;

public class NodeToRootPath {

    public static void main(String[] args) {
        Integer[] arr = { 10, 20, 50, null, 60, null, null, 30, 70, 90, null, 100, null, 110, null, null, null, 40, 80,
                null, null, null };
        Node root = construct(arr);
        List<Integer> ans = new ArrayList<>();
        ans = getInt(root, 110, ans);
        if (ans == null) {
            System.out.println("Not There :3");
        } else {
            for (int i : ans) {
                System.out.print(i + " ");
                System.out.println();
            }

        }

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

    static int size(Node n) {
        int count = 1;
        for (Node m : n.children) {
            count += size(m);
        }
        return count;
    }

    public static List<Integer> getInt(Node root, int k, List<Integer> ans) {
        if (root.data == k) {
            ans.add(root.data);
            return ans;
        }
        for (Node child : root.children) {
            List<Integer> add = getInt(child, k, ans);
            if (add != null) {
                ans.add(root.data);
                return ans;
            }
        }
        return null;
    }
}
