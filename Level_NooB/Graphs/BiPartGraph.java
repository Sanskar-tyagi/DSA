package Graphs;

import java.util.*;

public class BiPartGraph {

    public static class Edge {
        int src, nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    static class Pair {
        int curr;
        int Level;
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

}
