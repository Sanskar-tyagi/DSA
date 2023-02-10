package Linked_list.Functions;

public class AddAt {
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

        void addAt(int data, int idx) {
            Node temp = new Node();
            temp.data = data;
            if (size == 0 || idx == 0) {
                head = tail = temp;
                size++;
            } else {
                while (idx != 0) {
                    size++;
                }

            }

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

    }
}
