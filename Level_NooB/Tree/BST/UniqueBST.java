package Tree.BST;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UniqueBST {
    // https://leetcode.com/problems/unique-binary-search-trees-ii/
    // Given an integer n, return all the structurally unique BST's (binary search
    // trees), which has exactly n nodes of unique values from 1 to n. Return the
    // answer in any order.

    // Example 1:
    // Input: n = 3
    // Output:
    // [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    static List<Node> getPath(int src, int des) {
        List<Node> ans = new ArrayList<>();
        if (src > des) {
            ans.add(null);
            return ans;
        }
        List<Node> lLeft = getPath(src, des - 1);
        List<Node> lRight = getPath(src + 1, des);

        for (Node l : lLeft) {
            for (Node r : lRight) {
                Node root = new Node(src);
                root.left = l;
                root.right = r;
                ans.add(root);
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N");
        int s = sc.nextInt();
        if (s == 0) {
            System.out.println("Aham Aham ERRORRRRR!");
        }
        List<Node> ans = getPath(1, s); 
    }

}
