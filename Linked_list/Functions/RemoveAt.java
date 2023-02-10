package Linked_list.Functions;

public class RemoveAt {
    public static class Node {
        int data;
        Node next;
    }

    static class Linklist {
        Node head;
        Node tail;
        int size;

        public void removeAt(int idx) {

            if (this.size == 0) {
                throw new IllegalStateException("List is empty");
            } else if (idx >= this.size || idx < 0) {
                throw new IllegalArgumentException("Invalid index");
            } else if (idx == 0) {
                Node pre = this.head.next;
                this.head.next = null;
                this.head = pre;
                size--;
            } else {
                Node pre = this.head;
                Node tar = pre.next;
                int count = 1;
                while (idx != count) {
                    pre = tar;
                    tar = tar.next;
                    count++;
                }
                size--;
                pre.next = tar.next;
                tar.next = null;
                if (idx == this.size) {
                    this.tail = pre;
                }
            }

        }

        int size() {
            return this.size;
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

        void display() {
            Node ptr = this.head;
            while (ptr != null) {
                System.out.print(ptr.data + "   ");
                ptr = ptr.next;
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Linklist li = new Linklist();
        li.addFirst(0);
        li.addFirst(1);
        li.addFirst(2);
        li.addFirst(3);
        li.display();
        li.removeAt(3);
        li.display();

    }
}
