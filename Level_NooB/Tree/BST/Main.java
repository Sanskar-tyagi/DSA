package Tree.BST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

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
        System.out.println("Enter the Numbers to create BST and any charchter to display and stop.");
        String s = sc.next();
        ArrayList<Integer> li = new ArrayList<>();
        while (s.matches("^[0-9]+$")) {
            if (s.equals(null) || s.equals("null")) {
                break;
            }
            li.add(Integer.parseInt(s));
            System.out.println("Enter the Numbers to create BST and any charchter to display and stop.");
            s = sc.next();
        }
        int[] arr = new int[li.size()];
        for (int i = 0; i < li.size(); i++) {
            arr[i] = li.get(i);
        }
        Node root = construct(arr, 0, arr.length - 1);
        display(root);

    }
}
