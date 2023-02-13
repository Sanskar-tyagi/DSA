package Linked_list;

public class DisplayLLRecursive {
    // ?You are required to complete the body of displayReverse and
    // ? displayReverseHelper functions. The function are expected to print in
    // ? reverse the linked list without actually reversing it.
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

        private void displayReverseHelper(Node node) {
            // write your code here
        }

        public void displayReverse() {
            displayReverseHelper(head);
            System.out.println();
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

    }
}
