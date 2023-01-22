package Linked_list;

public class removeLast {
    public static class Node {
        int data;
        Node next;
    }

    static class Linklist {
        Node head;
        Node tail;
        int size;

        public void removeLast() {

            if (this.size == 0) {
                return;
            } else {
                Node pre = this.head.next;
                this.head.next = null;
                this.head = pre;
                size--;
            }

        }

        int size() {
            return this.size;
        }

        void display() {
            Node ptr = this.head;
            while (ptr != null) {
                System.out.print(ptr.data + "   ");
                ptr = ptr.next;
            }
            System.out.println("");
            System.out.println("");
        }
    }

}
