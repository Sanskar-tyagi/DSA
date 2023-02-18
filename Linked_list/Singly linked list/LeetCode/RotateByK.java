public class RotateByK {

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

        public Node rotateRight(Node head, int k) {
            if (head == null || head.next == null || k == 0) {
                return head;
            }
            int size = 1;
            Node s = head;
            while (s.next != null) {
                s = s.next;
                size++;
            }
            int r = k % size;
            if (r == 0) {
                return head;
            }
            Node temp = head;
            Node slow = null;
            for (int i = 0; i < size - r; i++) {
                slow = temp;
                temp = temp.next;
            }
            slow.next = null;
            s.next = head;
            head = temp;
            return head;
        }
    }

    public static void main(String[] args) {
        Linklist li = new Linklist();
        li.addLast(1);
        li.addLast(2);
        li.addLast(3);
        li.addLast(4);
        li.addLast(5);
        li.addLast(6);
        li.addLast(7);
        li.display();
        li.head = li.rotateRight(li.head, 3);
        li.display();
    }
}
