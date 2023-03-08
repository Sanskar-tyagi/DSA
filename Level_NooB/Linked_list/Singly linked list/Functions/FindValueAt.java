 
import java.util.*;
import java.util.function.Supplier;

public class FindValueAt {
    // ? You are required to complete the body of getFirst, getLast and getAt
    // ? function
    // ? --> getFirst - Should return the data of first element. If empty should
    // ? return -1 and print "List is empty".
    // ? --> getLast - Should return the data of last element. If empty should
    // ? return
    // ? -1 and print "List is empty".
    // ? --> getAt - Should return the data of element available at the index
    // ? passed.
    // ? --> If empty should return -1 and print "List is empty". If invalid index
    // ? is
    // ? passed, should return -1 and print "Invalid arguments".
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }

            size++;
        }

        void addFirst(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = head;

            if (size == 0) {
                head = tail = temp;
            } else {
                head = temp;
            }

            size++;
        }

        public int size() {
            return size;
        }

        public void display() {
            for (Node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }

        public int getFirst() {
            if (this.size == 0) {
                return -1;
            }
            int ans = this.head.data;
            return ans;
        }

        public int getLast() {
            if (this.size == 0) {
                return -1;
            }
            int ans = this.tail.data;
            return ans;
        }

        public void printAns(String calledFunction, Supplier<Integer> getVal) {
            int ans = getVal.get();
            if (ans == -1) {
                System.out.println("List is empty");
            } else {
                System.out.println(calledFunction + " " + ans);
            }
        }

        public int FindVal(int tar) {
            if (this.size == 0) {
                return -1;
            }
            int n = 1;
            Node next = this.head;
            while (n < this.size) {
                next = next.next;
                int ans = next.data;
                if (ans == tar) {
                    return n;
                }
                n++;
            }
            return -1;
        }
    }

    public void PrintFind(int ans) {
        if (ans == -1) {
            System.out.println("Not found");
        } else {
            System.out.println("element" + " found at " + ans);
        }

    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter your List Size");
        int n = sc.nextInt();
        LinkedList li = new LinkedList();
        for (int i = 0; i < n; i++) {
            li.addLast(sc.nextInt());
        }
        li.addLast(5);
        li.display();
        li.addFirst(0);
        li.display();
        li.printAns("First Value", li::getFirst);
        li.printAns("Last Value", li::getLast);
        // * */ passing a function as a parameter to another function in Java using
        // * */ functional interfaces
        System.out.println();
        // * */ This approach is not very efficient, especially for large linked lists,
        // * */ as it has a time complexity of O(n), where n is the number of nodes in
        // * */ the linked list.
    }

}
