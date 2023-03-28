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
    // INPUT
    // 7
    // 9
    // 0 1 10
    // 1 2 10
    // 2 3 10
    // 0 3 40
    // 3 4 2
    // 4 5 3
    // 5 6 3
    // 4 6 8
    // 2 5 5
    // 0
    // 6
    // 30
    // 4

    static class Pair implements Comparable<Pair> {
        int cost;
        String path;

        Pair(int cost, String Path) {
            this.cost = cost;
            this.path = Path;
        }

        public int compareTo(Pair other) {
            return Integer.compare(cost, other.cost);
        }

    }

    static String minCostsString, maxCostsString, kthCoststsString, ceilString, floorString;
    static int Ceil, minCost = Integer.MAX_VALUE;
    static int Floor, maxCost = Integer.MIN_VALUE;
    static int constraint, k;
    static PriorityQueue<Pair> li = new PriorityQueue<>();

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
        System.out.println("Enter Src");
        int src = sc.nextInt();
        System.out.println("Enter Des");
        int dest = sc.nextInt();
        System.out.println("Enter Cosntraint");
        int criteria = sc.nextInt();
        System.out.println("Enter Kth");
        int x = sc.nextInt();
        k = x;
        constraint = criteria;
        boolean[] visited = new boolean[vtces];
        multisolver(graph, src, dest, visited, "", 0);
        System.out.println("Smallest Path = " + minCostsString + "@" + minCost);
        System.out.println("Largest Path = " + maxCostsString + "@" + maxCost);
        System.out.println("Just Larger Path than " + criteria + " = " + ceilString + "@" + Ceil);
        System.out.println("Just Smaller Path than " + criteria + " = " + floorString + "@" + Floor);
        System.out.println(k + "th largest path = " + li.peek().path + "@" + li.peek().cost);
    }

    public static void multisolver(ArrayList<Edge>[] graph, int src, int des, boolean arr[], String ansf,
            int costSoFar) {
        if (des == src) {
            if (costSoFar < minCost) {
                minCost = costSoFar;
                minCostsString = ansf;
            }
            if (costSoFar > maxCost) {
                maxCost = costSoFar;
                maxCostsString = ansf;
            }
            if (li.size() < k) {
                li.add(new Pair(costSoFar, ansf));
            } else if (li.peek().cost < costSoFar) {
                li.remove();
                li.add(new Pair(costSoFar, ansf));
            }
            if (costSoFar > constraint && costSoFar < Ceil) {
                Ceil = costSoFar;
                ceilString = ansf;
            }
            if (costSoFar < constraint && costSoFar > Floor) {
                floorString = ansf;
                Floor = costSoFar;
            }
            return;
        }
        arr[src] = true;
        for (Edge e : graph[src]) {
            if (!arr[e.nbr]) {
                multisolver(graph, e.nbr, des, arr, ansf + e.nbr, costSoFar + e.cost);
            }
        }
        arr[src] = false;
    }

}