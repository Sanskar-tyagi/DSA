package StacknDeque;

import java.util.Scanner;

public class DynamicQueue {
    // ! Motive
    // ! The motive of this class is to create a clone of ArrayDeque Data structure
    // ! and implementing its various function in FIFO methodolgy
    // ! First we create some Global Variables that will help us To implement the
    // ! functions
    int size; // Size to Capture the Current Deque size;
    int data[];// Array to store the elements
    int first;// And the first element to simply Apply PoP function

    public DynamicQueue(int cap) {
        data = new int[cap];
        size = 0;
        first = 0;// We create attributes of the class
    }

    static int Size(DynamicQueue Q) { // Size To get the current size of Deque
        int n = Q.size;
        return n;
    }

    static void addLast(DynamicQueue Q, int a) {// ? As the Deque follows FIFO we fist check if the size of the current
                                                // ? Queue and the Capacity avilable
        int n = Q.size;
        int max = Q.data.length;
        if (n >= max) { // ? if We are at Max Capacity Just double the current Array and Add new Value
                        // ? at Last in FIFO manner
            int arr[] = new int[2 * Q.data.length];
            for (int i = 0; i < Q.size; i++) {
                arr[i] = Q.data[i];
            }
            Q.data = arr;
            Q.data[n + 1] = a;
            Q.size += 1;
        } else if (n < max && n != 0) {
            Q.data[n] = a;
            Q.size += 1;
        }

        else if (n == 0) {// Assigning the First Variable and creating the Queue
            Q.data[0] = a;
            Q.size += 1;
            Q.first = a;
        } else { // Queue OverFlow
            System.out.print("Error Queue At itss CAP");
            return;
        }
    }

    static void RemoveFirst(DynamicQueue Q) {
        int n = Q.size;
        if (n != 0 && n != 1) {// Checking it the size is not empty or 1
            int x = 0;
            while (x < n) {// Swapping the first Element till the last index
                int temp = Q.data[x + 1];
                Q.data[x + 1] = Q.data[x];
                Q.data[x] = temp;
                x++;
            }
            Q.first = Q.data[0]; // Changing the first variable to current First after swap
            Q.data[x] = 0;// Removing the Variable by setting it to Default Value
            Q.size -= 1;// Decreasing the current size of Queue
        } else if (n == 1) {
            Q.data[0] = 0;
            Q.size = 0;
            Q.first = 0;
        } else {
            System.out.print("Error Queue EMPTY");
            return;
        }
    }

    static int Peek(DynamicQueue nq) {
        return nq.first;
    }

    static void display(DynamicQueue ns) {
        for (int i : ns.data) {
            if (i != 0 && i + 1 != 0) {
                System.out.println(i);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Cap");
        int n = sc.nextInt();
        DynamicQueue ns = new DynamicQueue(n);// Creating the Instance of the class
        System.out.println("Enter Value TO add");
        int x = sc.nextInt();
        addLast(ns, x);// Allocate memory for ns on the heap
                       // and assign its reference to the ns variable
        System.out.println("Enter Value TO add");
        x = sc.nextInt();
        addLast(ns, x);
        System.out.println("Enter Value TO add");
        x = sc.nextInt();
        addLast(ns, x);
        System.out.println("Enter Value TO add");
        x = sc.nextInt();
        addLast(ns, x);
        System.out.println("Enter Value TO add");
        x = sc.nextInt();
        addLast(ns, x);
        System.out.println("Enter Value TO add");
        x = sc.nextInt();
        addLast(ns, x);
        System.out.println("Queue Now");
        display(ns);
        RemoveFirst(ns);
        System.out.println("Queue After POP ");// In FIFO
        display(ns);
        System.out.println("Queue Peek " + Peek(ns));// In FIFO
        System.out.println("Queue After POP ");// In FIFO
        display(ns);
        RemoveFirst(ns);
        System.out.println("Queue After POP ");// In FIFO
        display(ns);
        RemoveFirst(ns);
        System.out.println("Queue After POP ");// In FIFO
        display(ns);
    }

}
