package Linked_list.Algorithm;

public class Floyds_CircularAlgo {
    // Question -->
    // https://practice.geeksforgeeks.org/problems/circular-linked-list/1

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

        public int size() {
            return this.size;
        }

        void display() {
            Node ptr = this.head;
            while (ptr != null) {
                System.out.print(ptr.data + "   ");
                ptr = ptr.next;
            }
            System.out.println("");
        }
    }

    static boolean IsCyclic(LinkedList li) {
        Node fast = li.head;
        Node slow = li.head;
        while (fast.next != null && fast != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    static void MakeCycleAt(int x, LinkedList li) {
        Node temp = li.head;
        while (x != 0) {
            temp = temp.next;
            x--;
        }
        li.tail.next = temp;
    }

    public static void main(String[] args) {
        LinkedList li = new LinkedList();
        li.addLast(4);
        li.addLast(2);
        li.addLast(3);
        li.addLast(0);
        li.addLast(0);
        System.out.println("List");
        li.display();
        MakeCycleAt(4, li);
        IsCyclic(li);

    }
}
