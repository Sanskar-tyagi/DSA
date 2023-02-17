
public class ReverseLLinRange {
    // Q_Link -->https://leetcode.com/problems/reverse-linked-list-ii/description/
    // Given the head of a singly linked list and two integers left and right
    // where left <= right, reverse the nodes of the list from position left to
    // position right, and return the reversed list.

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
    }

    public static void main(String[] args) {
        Linklist li = new Linklist();
        li.addLast(1);
        li.addLast(2);
        li.addLast(2);
        li.addLast(2);
        li.addLast(3);
        li.addLast(4);
        li.addLast(5);
        li.addLast(5);
        li.addLast(5);
        li.display();
        li.reverseBetween(li.head, 2, 5);
        li.display();
    }
}