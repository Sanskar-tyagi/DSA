 
public class removeLast {
    public static class Node {
        int data;
        Node next;
    }

    static class Linklist {
        Node head;
        Node tail;
        int size;

        public void removeFirst() {

            if (this.size == 0) {
                return;
            } else {
                Node pre = this.head.next;
                this.head.next = null;
                this.head = pre;
                size--;
            }

        }

        public void removeLast() {
            if (this.size == 0) {
                return;
            } else if (this.size == 1) {
                this.head = null;
                this.tail = null;
                this.size = 0;
            } else {
                Node pre = this.head;
                while (pre.next.next != null) {
                    pre = pre.next;
                }
                pre.next = null;
                this.tail = pre;
                this.size--;
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
        li.addFirst(1);
        li.addFirst(22);
        li.addFirst(55);
        li.addFirst(2);
        li.addFirst(23);
        li.display();
        li.removeLast();
        li.display();
    }
}
