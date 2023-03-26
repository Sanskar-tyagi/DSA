package Graphs;

import java.util.*;

public class FindAllPaths {
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
        // Graph construction using Array of arrayList
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
        // Printing of Graph
        for (ArrayList<Edge> list : graph) {
            for (Edge e : list) {
                System.out.println(e.src + "--> " + e.nbr);
            }
        }
    }

    public static void isPath(ArrayList<Edge>[] graph, int src, int des, boolean arr[], String ansf) {
        if (des == src) {
            System.out.println(ansf);
            return;
        }
        arr[src] = true;
        for (Edge e : graph[src]) {
            if (!arr[e.nbr]) {
                isPath(graph, src, des, arr, ansf + e.nbr);
            }
        }
        arr[src] = false;
    }
}
