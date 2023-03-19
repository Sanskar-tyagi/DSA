package Tree.BST;

import java.util.*;

public class NodeToRootPath {
    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data, Node ri, Node li) {
            this.data = data;
            this.left = li;
            this.right = ri;
        }
    }

    public static Node construct(int[] arr, int lo, int ri) {
        if (lo > ri) {
            return null;
        }
        int mid = (lo + ri) / 2;
        Node left = construct(arr, lo, mid - 1);
        Node right = construct(arr, mid + 1, ri);
        Node root = new Node(arr[mid], right, left);
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

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number to Search in Bst");
        int s = sc.nextInt();
        int arr[] = { 10, 22, 3, 211, 4, 45, 21, 1 };
        Arrays.sort(arr);
        Node root = construct(arr, 0, arr.length - 1);
        display(root);
        List<Integer> ans = getPath(root, s);
        for (Integer child : ans) {
            System.out.println(child);
        }
    }

    public static List<Integer> getPath(Node root, int k) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> li = new ArrayList<>();
        while (root != null) {
            li.add(root.data);
            if (k > root.data) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return li;
    }
}
