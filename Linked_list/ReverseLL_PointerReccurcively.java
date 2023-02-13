package Linked_list;

public class ReverseLL_PointerReccurcively {

    // ?You are required to complete the body of reversePR and reversePRHelper
    // ? functions. functions are expected to reverse the linked list by using
    // ? recursion and changing the "next" data member of nodes.

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
            for (Node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " ");
            }
            System.out.println();
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

        private void reversePRHelper(Node node) {
            if (node == null) {
                return;
            }
            if (node == tail) {
                return;
            }
            reversePRHelper(node.next);
            node = node.next.next;
            System.out.print(node.data);
        }

        public void reversePR() {
            reversePRHelper(head);
            System.out.println();
        }

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
        li.reversePR();
    }
}

// TIME COMPLEXITY
