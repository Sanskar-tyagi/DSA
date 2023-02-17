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

        public Node reverseBetween(Node head, int left, int right) {
            Node dummy = new Node();
            dummy.next = head;
            Node prev = dummy;

            for (int i = 0; i < left - 1; i++)
                prev = prev.next;
            Node curr = prev.next;

            for (int i = 0; i < right - left; i++) {
                Node forw = curr.next;
                curr.next = forw.next;
                forw.next = prev.next;
                prev.next = forw;
            }
            return dummy.next;
        }

        public Node rotateRight(Node head, int k) {
            if (head == null || head.next == null) {
                return head;
            }
            int len = this.size;
            k = k % len;
            if (k == 0)
                return head;

            Node slow = head, fast = head;
            while (k != 0) {
                fast = fast.next;
                k--;
            }
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }

            Node nbr = slow.next;
            slow.next = null;
            fast.next = head;
            return nbr;
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
        li.head = li.reverseBetween(li.head, 3, li.size);
        li.display();
    }
}
