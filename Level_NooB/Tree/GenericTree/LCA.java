package Tree.GenericTree;

import java.util.*;;

public class LCA {

    // Lowest Common Ancestor is the node which is the common ancestor for both the
    // nodes and is the closest to them (or farthest from root). It is guaranteed
    // that both the nodes are present in the tree. Hence, there will always be the
    // lowest common ancestor possible.

    public static void main(String[] args) {
        Integer[] arr = { 10, 20, 50, null, 60, null, null, 30, 70, 90, null, 100, null, 110, null, null, null, 40, 80,
                null, null, null };
        Node root = construct(arr);
        System.out.println("Input the number to find");
        Scanner sc = new Scanner(System.in);
        int d1 = sc.nextInt();
        System.out.println("Input the number to find");
        int d2 = sc.nextInt();
        int temp = LowestCommanAncestor(d2, d1, root);
        System.out.println(temp);
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

    public static int LowestCommanAncestor(int k, int d, Node root) {
        List<Integer> l1 = new ArrayList<>();
        l1 = getInt(root, k, l1);
        List<Integer> l2 = new ArrayList<>();
        l2 = getInt(root, d, l2);
        int i = l1.size() - 1;
        int j = l2.size() - 1;
        while (j >= 0 && i >= 0) {
            if (l1.get(i) != l2.get(j)) {
                break;
            }
            i--;
            j--;
        }

        return l1.get(i + 1);
    }
}
