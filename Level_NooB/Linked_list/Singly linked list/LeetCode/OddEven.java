public class OddEven {

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

        public void reorder() {
            // My approach
            // Node ptr;
            // Node frwd;
            // int x=this.size/2;
            // int n=this.size/2;
            // while(x!=0){
            // ptr=FindNodeAt(n);
            // frwd=FindNodeAt(n);
            // n++;
            // x--;
            // }
            if (head == null || head.next == null) {
                return;
            } else {

                Node ptr = getMid(head);
                Node frwd = ptr.next;
                ptr.next = null;
                frwd = reverse(frwd);
                Node p1 = head, p2 = frwd;

                Node dummy = new Node();

                Node p3 = dummy;
                while (p1 != null && p2 != null) {
                    p3.next = p1;
                    p1 = p1.next;
                    p3 = p3.next;

                    p3.next = p2;
                    p2 = p2.next;
                    p3 = p3.next;
                }
                p3.next = p1;
            }
        }

        public Node getMid(Node head) {
            if (head == null || head.next == null)
                return head;

            Node slow = head, fast = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        Node reverse(Node head) {
            if (head == null || head.next == null)
                return head;
            Node curr = head;
            Node prev = null;
            while (curr != null) {
                Node nbr = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nbr;
            }

            return prev;
        }

        Node divide(Node head) {
            if (head == null || head.next == null) {
                return head;
            }
            Node even = new Node();
            Node odd = new Node();
            Node evenTail = even, oddTail = odd;
            Node curr = head;
            while (curr != null) {
                if (curr.data % 2 == 0) {
                    evenTail.next = curr;
                    evenTail = evenTail.next;
                } else {
                    oddTail.next = curr;
                    oddTail = oddTail.next;
                }
                curr = curr.next;
            }
            oddTail.next = null;
            evenTail.next = null;
            evenTail.next = odd.next;
            return even.next;
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
        li.addLast(8);
        li.addLast(9);
        li.display();
        li.head = li.divide(li.head);
        li.display();
    }
}
