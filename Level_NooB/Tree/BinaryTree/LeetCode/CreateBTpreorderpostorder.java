package Tree.BinaryTree.LeetCode;

import java.util.*;;

public class CreateBTpreorderpostorder {
    // Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
    // Output: [1,2,3,4,5,6,7]
    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        int p[] = { 1, 2, 4, 5, 3, 6, 7 };
        int pos[] = { 4, 5, 2, 6, 7, 3, 1 };
        Node ans = constructFromPrePost(p, pos);
        printNodeArray(ans);
    }

    static Node tree_builder(int[] preorder, int preStart, int preEnd, int[] postorder, int poStart, int posEnd) {
        if (preStart > preEnd) {
            return null;
        }

        Node root = new Node(preorder[preStart]);
        if (preStart == preEnd)
            return root;
        int idx = poStart;
        while (postorder[idx] != preorder[preStart + 1]) {
            idx++;
        }
        int total_elements = (idx - poStart) + 1;
        root.left = tree_builder(preorder, preStart + 1, preStart + total_elements, postorder, poStart, idx);
        root.right = tree_builder(preorder, preStart + total_elements + 1, preEnd, postorder, idx + 1, posEnd - 1);

        return root;
    }

    public static Node constructFromPrePost(int[] preorder, int[] postorder) {
        return tree_builder(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public static void printNodeArray(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        addNodeToArray(root, arr);
        System.out.println(arr);
    }

    public static void addNodeToArray(Node node, ArrayList<Integer> arr) {
        if (node != null) {
            arr.add(node.data);
            addNodeToArray(node.left, arr);
            addNodeToArray(node.right, arr);
        }
    }

}
