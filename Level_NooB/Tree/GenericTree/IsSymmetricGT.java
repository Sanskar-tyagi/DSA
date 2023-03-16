package Tree.GenericTree;

import java.util.*;;

public class IsSymmetricGT {

    public static void main(String[] args) {
        Integer[] arr = { 10, 20, 30, null, 40, null, null, null };
        Integer[] nonSymmetricArray = { 10, 20, 50, null, 60, null, null, 30, 70, 90, null, 100, null, 110, null, null,
                null, 40, 80,
                null, null, null };

        Node root = construct(arr);
        Node root2 = construct(nonSymmetricArray);
        boolean ans = isSymmetricGt(root, true);
        boolean nonSymmetric = isSymmetricGt(root2, true);
        System.out.println(ans);
        System.out.println(nonSymmetric);
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

    public static boolean isSymmetricGt(Node node, boolean flag) {
        if (node.children.size() == 0) {
            return flag;
        }
        for (Node child : node.children) {
            int i = 0;
            int j = node.children.size() - 1;
            while (i <= j && flag) {
                Node ith = node.children.get(i);
                Node jth = node.children.get(j);
                if (ith.children.size() != jth.children.size()) {
                    flag = false;
                    return false;
                }
                i++;
                j--;
            }
            isSymmetricGt(child, flag);
        }
        return flag;
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