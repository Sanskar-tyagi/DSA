
public class Delete {
    // ! Question link -->
    // ! https://leetcode.com/problems/delete-node-in-a-linked-list/
    static class Node {
        int data;
        Node next;
    }

    static class Linklist {
        Node head;
        Node tail;
        int size;

        public void addLast(int val) {
            Node node = new Node();
            node.data = val;
            if (this.size == 0) {
                this.head = node;
                this.tail = node;
            } else {
                this.tail.next = node;
                this.tail = node;
            }
            this.size++;
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

        public void deleteNode(Node node) {
            if (node == null)
                return;
            ;
            if (node.next != null) {
                int nextValue = node.next.data;
                node.next = node.next.next;
                node.data = nextValue;
            }
        }
    }
}
