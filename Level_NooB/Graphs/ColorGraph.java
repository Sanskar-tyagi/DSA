
package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public boolean isBipartite(int[][] graph) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);

        for (int src = 0; src < graph.length; src++) {
            if (!map.containsKey(src)) {
                map.put(src, new ArrayList<Integer>());
            }
            for (int v : graph[src]) {
                map.get(src).add(v);
            }
        }
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1 && !dfs(i, 0, colors, map)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, int color, int[] colors, HashMap<Integer, ArrayList<Integer>> map) {
        if (colors[node] != -1) {
            return colors[node] == color;
        }
        colors[node] = color;
        if (map.containsKey(node)) {
            for (int v : map.get(node)) {
                if (!dfs(v, 1 - color, colors, map)) {
                    return false;
                }
            }
        }
        return true;
    }
}
