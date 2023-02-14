
public class RemoveDublicates {
    // Q https://leetcode.com/problems/remove-duplicates-from-sorted-list/

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

        void RemoveDub() {

            Node curr = this.head;
            while (curr != null && curr.next != null) { // iterate over linked list
                if (curr.data == curr.next.data) { // if duplicate found
                    curr.next = curr.next.next; // remove duplicate
                    this.size--; // decrement size
                } else {
                    curr = curr.next; // move to next node
                }
            }
            this.tail = curr; // update tail
        }
    }

    public static void main(String[] args) {
        Linklist li = new Linklist();
        li.addLast(1);
        li.addLast(2);
        li.addLast(2);
        li.addLast(2);
        li.addLast(3);
        li.addLast(5);
        li.addLast(5);
        li.addLast(5);
        li.addLast(5);
        li.display();
        li.RemoveDub();
        li.display();
    }
}
