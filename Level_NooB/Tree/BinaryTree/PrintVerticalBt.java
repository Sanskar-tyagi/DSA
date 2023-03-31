package Tree.BinaryTree;

import java.util.*;

// MY Approach
public class PrintVerticalBt {
    // ! https://www.geeksforgeeks.org/print-binary-tree-vertical-order
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static class Level {
        Node curr;
        Integer level;

        Level() {
            curr = null;
            level = 0;
        }

        Level(Integer l, Node curr) {
            this.curr = curr;
            this.level = l;
        }
    }

    static class Pair {
        Node node;
        int state;

        Pair(Node node) {
            this.node = node;
            this.state = 0;
        }
    }

    static List<Level> getLevels(Node root, List<Level> ans, Integer c) {
        if (root == null) {
            return ans;
        }
        ans.add(new Level(c, root));
        getLevels(root.left, ans, c - 1);
        getLevels(root.right, ans, c + 1);
        return ans;
    }

    static void print(List<Level> ans) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Level l : ans) {
            map.put(l.curr.data, l.level + 3);
        }
        Map<Integer, List<Integer>> result = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            List<Integer> keys = result.getOrDefault(value, new ArrayList<>());
            keys.add(key);
            result.put(value, keys);
        }
        for (List<Integer> keys : result.values()) {
            if (keys.size() > 1) {
                System.out.println("Keys with same value:");
                for (int key : keys) {
                    System.out.println(key);
                }
            }
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

    public static void main(String[] args) {
        Integer arr[] = { 10, 20, 40, 60, null, null, null, 50, 70, null, null, 80, null, null, 30, null, 90, 100, null,
                null, null };
        Node root = construct(arr);
        List<Level> ans = getLevels(root, new ArrayList<Level>(), 0);
        print(ans);
    }
}

// GFG solution

// package Tree.BinaryTree;

// import java.util.*;

// public class PrintVerticalBt {

// static class Node {
// int data;
// Node left, right;

// Node(int item) {
// data = item;
// left = right = null;
// }
// }

// static class Pair {
// Node node;
// int state;

// Pair(Node node) {
// this.node = node;
// this.state = 0;
// }
// }

// public static Node construct(Integer[] arr) {
// Node root = new Node(arr[0]);
// Stack<Pair> st = new Stack<>();
// st.push(new Pair(root));
// int idx = 1;
// while (st.size() > 0) {
// Pair top = st.peek();
// if (top.state == 0) {
// Integer val = arr[idx];
// if (val != null) {
// Node child = new Node(val);
// top.node.left = child;
// st.push(new Pair(child));
// }
// top.state++;
// idx++;
// } else if (top.state == 1) {
// Integer val = arr[idx];
// if (val != null) {
// Node child = new Node(val);
// top.node.right = child;
// st.push(new Pair(child));
// }
// top.state++;
// idx++;
// } else if (top.state == 2) {
// st.pop();
// }
// }
// return root;
// }

// public static void printVerticalOrder(Node root) {
// TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
// getVerticalOrder(root, 0, map);

// for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
// ArrayList<Integer> list = entry.getValue();
// for (Integer i : list) {
// System.out.print(i + " ");
// }
// System.out.println();
// }
// }

// private static void getVerticalOrder(Node root, int hd, TreeMap<Integer,
// ArrayList<Integer>> map) {
// if (root == null) {
// return;
// }

// ArrayList<Integer> list = map.get(hd);
// if (list == null) {
// list = new ArrayList<>();
// list.add(root.data);
// } else {
// list.add(root.data);
// }
// map.put(hd, list);

// getVerticalOrder(root.left, hd - 1, map);
// getVerticalOrder(root.right, hd + 1, map);
// }

// public static void main(String[] args) {
// Integer arr[] = {
// 10, 20, 40, 60, null, null, null, 50, 70, null, null, 80, null, null, 30,
// null, 90, 100, null,
// null, null };
// Node root = construct(arr);
// printVerticalOrder(root);
// }
// }
