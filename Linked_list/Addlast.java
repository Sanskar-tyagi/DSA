package Linked_list;

public class Addlast {

    // we will create firstlly an instance NODE of the linked list
    // each link will have its node and each node will contain 2 things
    // the data stored in it and the adress to the next node
    // the Data can be of anytype but thte adress will be of node type itself
    // So the structure of a node can be :-
    // class node{
    // int data;
    // Node next;
    // }
    public static class Node {
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
                this.head = node; // creates a new Node which is the starting of the Link list
                this.tail = node;// Points to it self (to its own node)
            } else {
                this.tail.next = node;// now as its not the first node do one thing the node in the linked list
                // calling you make its next
                // as the head of this node of the linked list
                this.tail = node;// make the tail of this
            }
            this.size++;// and increase the size of the linked list
        }

        public void addFirst(int val) {
            Node node = new Node();
            node.data = val;
            if (this.size == 0) {
                this.head = node; // creates a new Node which is the starting of the Link list
                this.tail = node;// Points to it self (to its own node)
            } else {
                node.next = this.head;
                this.head = node;
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
    }

    // head=null;tail=null;size=0; --->Linklist empty

    public static void main(String[] args) {
        Linklist li = new Linklist();
        // New memory is created in heap
        li.addLast(1);
        li.display();
        li.addLast(2);
        li.display();
        li.addFirst(3);
        li.display();
        li.addFirst(4);
        li.display();

    }
}
