package Graphs;

import java.util.*;

public class MultiSolver {
    // ! Motive-> we will be passed an graph in the form of input as
    // ! Vertices edges and Src -> Nbr and the cost to travel from source to nbr
    // We need to find the path that costs Min to reach from src to destination
    // input by the user
    // We need to find the path that costs the most to travel from src to des.
    // We need to find the Kth largest Costs to travel
    // We need to find the Ceil and the Floor value for a input by user according to
    // the cost
    static class Pair {
        int cost;
        String path;

        Pair(int cost, String Path) {
            this.cost = cost;
            this.path = Path;
        }
    }

    static String minCostsString, maxCostsString, kthCoststsString;
    static int Ceil, minCost = Integer.MAX_VALUE;
    static int Floor, maxCost, Kthmax = Integer.MIN_VALUE;
    static int constarint;
    static PriorityQueue<Pair> li;

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
        int vertNum = sc.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[vertNum];
        int edNum = sc.nextInt();
        for (int i = 0; i < vertNum; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edNum; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            graph[v1].add(new Edge(v1, v2, cost));
            graph[v2].add(new Edge(v2, v1, cost));
        }
        for (ArrayList<Edge> list : graph) {
            for (Edge e : list) {
                System.out.println(e.src + "--> " + e.nbr);
            }
        }

    }

    static Pair getKth(int k) {
        PriorityQueue<Pair> list = li;
        while (k != 0) {
            list.remove();
        }
        return list.remove();
    }

    static Pair getCeil() {
        PriorityQueue<Pair> list = li;
        Pair p = list.remove();
        int curr = p.cost;
        p = list.remove();
        Pair temp = p;
        while (curr < p.cost && p.cost > constarint) {
            temp = p;
            p = list.remove();
        }
        return temp;
    }

    public static void isPath(ArrayList<Edge>[] graph, int src, int des, boolean arr[], String ansf,
            int costSoFar) {
        if (des == src) {
            li.add(new Pair(costSoFar, ansf));
            if (costSoFar < minCost) {
                minCost = costSoFar;
            }
            if (costSoFar > maxCost) {
                maxCost = costSoFar;
            }
            return;
        }
        arr[src] = true;
        for (Edge e : graph[src]) {
            if (!arr[e.nbr]) {
                isPath(graph, src, des, arr, ansf + e.nbr, costSoFar + e.cost);
            }
        }
        arr[src] = false;

    }

}