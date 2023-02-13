package Linked_list;

public class ReverseLL_PointerIteratively {

    // ? You are required to complete the body of reversePI function. The function
    // ? should be an iterative function and should reverse the contents of linked
    // ? list by changing the "next" property of nodes.

    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        public int size() {
            return size;
        }

        public void display() {
            Node current = this.head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
        }

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

        public void reversePI() {
            Node prev = null;
            Node curr = this.head;
            Node next = null;
            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            this.tail = this.head;
            this.head = prev;
            this.display();
        }

        // public void Swap() {
        // Node N1 = this.tail;
        // Node Helper = this.head.next;
        // this.tail = this.head;
        // this.tail.next = null;
        // this.head = N1;
        // this.head.next = Helper;
        // this.display();
        // }

        public Node FindNodeAt(int tar) {
            if (this.size == 0) {
                return null;
            }

            Node next = this.head;
            for (int i = 0; i < tar; i++) {
                next = next.next;
            }
            return next;
        }
    }

    public static void main(String[] args) {
        LinkedList li = new LinkedList();
        li.addLast(0);
        li.addLast(1);
        li.addLast(2);
        li.addLast(3);
        li.display();
        System.out.println("Reversed");
        li.reversePI();
    }
}
