package Heap_PriorityQueue;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        System.out.println(pq);
        pq.add(10);
        pq.add(-1);
        pq.add(2);
        pq.add(15);
        pq.add(3);
        pq.add(4);
        System.out.println(pq);
        System.out.println(pq.peek());
        System.out.println(pq.size());
        while (pq.size() > 0) {
            System.out.print(pq.remove() + " ");
        }
    }

}
