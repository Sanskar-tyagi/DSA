package Tree.BST;

import java.util.*; 

public class LCA {
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
        int s2 = sc.nextInt();
        int arr[] = { 10, 22, 3, 211, 4, 45, 21, 1, 32, 44, 212, 110 };
        Arrays.sort(arr);
        Node root = construct(arr, 0, arr.length - 1);
        display(root);
        System.out.println(getLCA(s, s2, root));
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

    public static int getLCA(int k, int r, Node root) {
        List<Integer> Fl = getPath(root, k);
        List<Integer> Fx = getPath(root, r);
        int i = 0;
        while (Fl.get(i) == Fx.get(i)) {
            i++;
        }
        return Fl.get(i - 1);
    }
}
