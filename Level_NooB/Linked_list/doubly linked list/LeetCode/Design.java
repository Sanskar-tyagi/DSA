class MyLinkedList {
    // Question link-->https://leetcode.com/problems/design-linked-list/
    public static class Node {
        int val;
        Node next;
        Node prev;
    }

    Node head, tail;
    int size;

    public MyLinkedList() {
        this.head = this.tail = null;
        this.size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= this.size)
            return -1;
        Node ptr = this.head;
        while (index != 0) {
            ptr = ptr.next;
            index--;
        }
        return ptr.val;
    }

    public void addAtHead(int val) {
        Node node = new Node();
        node.val = val;

        if (this.size == 0) {
            this.head = this.tail = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }

        this.size++;
    }

    public void addAtTail(int val) {
        Node node = new Node();
        node.val = val;

        if (this.size == 0) {
            this.head = this.tail = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
        this.size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > this.size)
            return;
        else if (index == this.size)
            this.addAtTail(val);
        else if (index == 0)
            this.addAtHead(val);
        else {
            Node node = new Node();
            node.val = val;
            Node prevNode = null, currNode = this.head;
            while (index != 0) {
                prevNode = currNode;
                currNode = currNode.next;
                index--;
            }

            prevNode.next = node;
            node.prev = prevNode;

            node.next = currNode;
            currNode.prev = node;
            this.size++;
        }
    }

    public void deleteAtHead() {
        if (this.size == 0)
            return;
        else if (this.size == 1) {
            this.head = this.tail = null;
            this.size = 0;
        } else {
            Node nbr = this.head.next;
            this.head.next = null;
            nbr.prev = null;
            this.head = nbr;
            this.size--;
        }
    }

    public void deleteAtTail() {
        if (this.size == 0)
            return;
        else if (this.size == 1) {
            this.head = this.tail = null;
            this.size = 0;
        } else {
            Node prv = this.tail.prev;
            prv.next = null;
            this.tail.prev = null;
            this.tail = prv;
            this.size--;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= this.size)
            return;
        else if (index == 0)
            this.deleteAtHead();
        else if (index == this.size - 1)
            this.deleteAtTail();
        else {
            Node currNode = this.head;

            while (index != 0) {
                currNode = currNode.next;
                index--;
            }

            Node prvNode = currNode.prev;
            Node nxtNode = currNode.next;

            prvNode.next = nxtNode;
            nxtNode.prev = prvNode;

            currNode.next = null;
            currNode.prev = null;

            this.size--;
        }
    }

    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        ll.addAtHead(0);
        ll.addAtHead(2);
        ll.addAtHead(3);
        ll.addAtTail(0);
    }
}
