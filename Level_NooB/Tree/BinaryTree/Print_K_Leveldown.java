package Tree.BinaryTree;
 
import java.util.*;

public class Print_K_Leveldown {

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node) {
            this.node = node;
            this.state = 0;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0]);
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root));
        int idx = 1;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 0) {
                Integer val = arr[idx];
                if (val != null) {
                    Node child = new Node(val);
                    top.node.left = child;
                    st.push(new Pair(child));
                }
                top.state++;
                idx++;
            } else if (top.state == 1) {
                Integer val = arr[idx];
                if (val != null) {
                    Node child = new Node(val);
                    top.node.right = child;
                    st.push(new Pair(child));
                }
                top.state++;
                idx++;
            } else if (top.state == 2) {
                st.pop();
            }
        }
        return root;
    }

    static boolean findK(int k, Node root) {
        if (root == null) {
            return false;
        }
        if (root.data == k) {
            return true;
        }
        if (findK(k, root.left) || findK(k, root.right)) {
            return true;
        }

        return false;
    }

    static void Print_K_Level(Node root, int k) {
        int idx = 0;
        Queue<Node> main = new ArrayDeque<>();
        Queue<Node> helper = new ArrayDeque<>();
        main.add(root);
        while (main.size() > 0) {
            Node pr = main.remove();
            if (idx >= k) {
                System.out.println(pr.data);
            }
            if (pr.left != null) {
                helper.add(pr.left);
            }
            if (pr.right != null) {
                helper.add(pr.right);
            }
            if (main.size() == 0) {
                Queue<Node> temp = main;
                main = helper;
                helper = temp;
                idx++;
            }
        }
    }

    static void Print_K_LevelReccursively(Node root, int k) {
        if (root == null) {
            return;
        }
        if (k <= 0) {
            System.out.println(root.data);
            return;
        }
        Print_K_LevelReccursively(root.left, k - 1);
        Print_K_LevelReccursively(root.right, k - 1);
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
        Integer arr[] = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };
        Node root = construct(arr);
        Scanner sc = new Scanner(System.in);
        display(root);
        System.out.println("Enter the num to find");
        int k = sc.nextInt();
        Print_K_LevelReccursively(root, k);
    }
}