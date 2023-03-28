package Graphs;

import java.util.*;

public class BFS {
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
    }

    static void bfs(ArrayList<Edge> graph[], boolean vis[], Deque<Integer> level) {
        if (level.size() == 0) {
            return;
        }
        int src = level.pop();
        if (!vis[src]) {
            vis[src] = true;
            for (Edge e : graph[src]) {
                System.out.println(src);
                level.add(e.nbr);
                bfs(graph, vis, level);
            }
        }
    }
}
