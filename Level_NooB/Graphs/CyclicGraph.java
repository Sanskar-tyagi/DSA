package Graphs;

import java.util.*;

public class CyclicGraph {
    // if ever our vis array contains any point where the node is marked visited
    // before and is called it will be cycle detected

    public static class Edge {
        int src, nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertNum = sc.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[vertNum];
        int edNum = sc.nextInt();
        for (int i = 0; i < vertNum; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edNum; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }
        isGraphCyclic(graph);
    }
    static boolean isComponentCyclic(ArrayList<Edge> graph[], int vtx, boolean vis[]) {
        Queue<Integer> level = new ArrayDeque<>();
        level.add(vtx);
        while (level.size() > 0) {
            int src = level.remove();
            if (vis[src] == true) {
                return true;
            } else {
                vis[src] = true;
                for (Edge e : graph[src]) {
                    if (!vis[e.nbr]) {
                        level.add(e.nbr);
                    }
                }
            }
        }
        return false;

    }

    static boolean isGraphCyclic(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                boolean ans = isComponentCyclic(graph, i, vis);
                if (ans)
                    return ans;
            }
        }

        return false;
    }
}
