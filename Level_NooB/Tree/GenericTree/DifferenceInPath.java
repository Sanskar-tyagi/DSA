package Tree.GenericTree;

import java.util.*;;

public class DifferenceInPath {

    public static void main(String[] args) {
        Integer[] arr = { 10, 20, 50, null, 60, null, null, 30, 70, 90, null, 100, null, 110, null, null, null, 40, 80,
                null, null, null };
        Node root = construct(arr);
        display(root);
        System.out.println("Input the number to find");
        Scanner sc = new Scanner(System.in);
        int d1 = sc.nextInt();
        System.out.println("Input the number to find");
        int d2 = sc.nextInt();

        int ans = getPath(d1, d2, root);
        System.out.println(ans);
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

    public static List<Integer> getNodePath(Node root, int k, List<Integer> ans) {
        if (root.data == k) {
            ans.add(root.data);
            return ans;
        }
        for (Node child : root.children) {
            List<Integer> add = getNodePath(child, k, ans);
            if (add != null) {
                ans.add(root.data);
                return ans;
            }
        }
        return null;
    }

    public static int getPath(int k, int d, Node root) {

        List<Integer> l1 = new ArrayList<>();
        l1 = getNodePath(root, k, l1);

        List<Integer> l2 = new ArrayList<>();
        l2 = getNodePath(root, d, l2);
        int i = l1.size() - 1;
        int j = l2.size() - 1;
        int cout = 0;
        while (l1.get(i) == l2.get(j)) {
            i--;
            j--;
            cout += 2;
        }
        return l1.size() + l2.size() - cout;
    }
}
