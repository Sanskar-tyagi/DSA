package Tree.BinaryTree.LeetCode;

public class CreateBTpostorderinorder {
    // https://leetcode.com/problems/construct-binary-tree-from-inorder-and-inorder-traversal
    // Intuition
    // To construct a binary tree from inorder and postorder traversal arrays, we
    // first need to understand what each of these traversals represents.
    // Inorder traversal visits the nodes in ascending order of their values, i.e.,
    // left child, parent, and right child. On the other hand, postorder traversal
    // visits the nodes in the order left child, right child, and parent.
    // Knowing this, we can say that the last element in the postorder array is the
    // root node, and its index in the inorder array divides the tree into left and
    // right subtrees. We can recursively apply this logic to construct the entire
    // binary tree.

    // Approach
    // Start with the last element of the postorder array as the root node.
    // Find the index of the root node in the inorder array.
    // Divide the inorder array into left and right subtrees based on the index of
    // the root node.
    // Divide the postorder array into left and right subtrees based on the number
    // of elements
    // in the left and right subtrees of the inorder array.
    // Recursively construct the left and right subtrees.

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public Node GenTree(int[] inorder, int[] postorder) {
        // Call the recursive function with full arrays and return the result
        return buildTree(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private Node buildTree(int[] inorder, int inStart, int inEnd,
            int[] postorder, int postStart, int postEnd) {
        // Base case
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        // Find the root node from the last element of postorder traversal
        int data = postorder[postEnd];
        Node root = new Node(data);

        // Find the index of the root node in inorder traversal
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == data) {
                rootIndex = i;
                break;
            }
        }

        // Recursively build the left and right subtrees
        int leftSize = rootIndex - inStart;
        int rightSize = inEnd - rootIndex;

        root.left = buildTree(inorder, inStart, rootIndex - 1, postorder,
                postStart, postStart + leftSize - 1);
        root.right = buildTree(inorder, rootIndex + 1, inEnd, postorder,
                postEnd - rightSize, postEnd - 1);

        return root;
    }

    class Solution {// TC: O(n), SC: O(height)
        static class TreeNode {
            TreeNode left;
            TreeNode right;
            int data;

            TreeNode(int data) {
                this.data = data;
                left = right = null;
            }
        }

        int i, p; // i as index for inorder, p as index for preorder

        public TreeNode buildTree(int[] pre, int[] in) {
            i = p = 0;
            return dfs(pre, in, 3001);
        }

        private TreeNode dfs(int[] pre, int[] in, int rightBoundary) {
            if (p == pre.length || in[i] == rightBoundary)
                return null;

            TreeNode node = new TreeNode(pre[p++]);
            node.left = dfs(pre, in, node.data);
            i++;
            node.right = dfs(pre, in, rightBoundary);
            return node;
        }
    }
}
