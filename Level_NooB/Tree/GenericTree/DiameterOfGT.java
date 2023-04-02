package Tree.GenericTree;

import java.util.*;

public class DiameterOfGT {
    static class Node {
        int n;
        ArrayList<Node> children;

        Node(int val) {
            this.n = val;
            children = new ArrayList<>();
        }
    }

    public static class CustomPair {
        int dia, ht;

        CustomPair(int ht, int dia) {
            this.dia = dia;
            this.ht = ht;
        }
    }

    void construct(Integer arr[]) {
        Node root = new Node(arr[0]);
        Stack<Node> helper = new Stack<>();
        int idx = 1;
        while (idx < arr.length) {
            if (arr[idx] == null) {
                helper.pop();
            } else {
                Node child = new Node(arr[idx]);
                Node par = helper.peek();
                par.children.add(child);
                helper.push(child);
            }
            idx++;
        }
    }

}
