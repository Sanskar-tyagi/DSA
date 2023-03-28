package Graphs;

import java.util.*;

public class GetConnected {

    public static class Edge {
        int src, nbr, cost;

        Edge(int src, int nbr, int cost) {
            this.src = src;
            this.nbr = nbr;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter verticies");
        int vtces = sc.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }
        System.out.println("Enter Edges");
        int edges = sc.nextInt();
        for (int i = 0; i < edges; i++) {
            System.out.println("Enter V1-> V2 -> W");
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int wt = sc.nextInt();
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }
        isConnected(graph);
    }

    static ArrayList<ArrayList<Integer>> getAllComponents(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                ArrayList<Integer> temp = new ArrayList<>();
                addComp(graph, vis, i, temp);
                ans.add(temp);
            }
        }
        return ans;
    }

    static void addComp(ArrayList<Edge>[] graph, boolean[] vis, int src, ArrayList<Integer> comp) {
        vis[src] = true;
        comp.add(src);
        for (Edge e : graph[src]) {
            if (!vis[e.nbr]) {
                addComp(graph, vis, e.nbr, comp);
            }
        }
    }

    static void isConnected(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        int comparator = 0;
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                isAllConnected(graph, vis, i, comparator);
            }
        }
        if (vis.length != comparator) {
            System.out.println("is not a connected graph");
        } else {
            System.out.println(" is a connected graph");
        }
    }

    static void isAllConnected(ArrayList<Edge>[] graph, boolean[] vis, int src, int comp) {
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.nbr]) {
                isAllConnected(graph, vis, e.nbr, comp + 1);
            }
        }
    }

}