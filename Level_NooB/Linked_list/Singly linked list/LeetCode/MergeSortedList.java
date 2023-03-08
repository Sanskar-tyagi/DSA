public class MergeSortedList {
    // ! Q--> https://leetcode.com/problems/merge-two-sorted-lists/description/

    // You are given the heads of two sorted linked lists list1 and list2.
    // Merge the two lists in a one sorted list. The list should be made by splicing
    // together the nodes of the first two lists.
    static class Node {
        int data;
        Node next;
    }

    static class Linklist {
        Node head;
        Node tail;
        int size;

        public void addLast(int data) {
            Node node = new Node();
            node.data = data;
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

    }

    public Node mergeTwoLists(Linklist list1, Linklist list2) {
        Node dummyHead = new Node();
        Node tail = dummyHead;
        Node p1 = list1.head;
        Node p2 = list2.head;

        while (p1 != null && p2 != null) {
            if (p1.data < p2.data) {
                tail.next = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                p2 = p2.next;
            }
            tail = tail.next;
        }

        if (p1 != null) {
            tail.next = p1;
        } else {
            tail.next = p2;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        Linklist li = new Linklist();
        li.addLast(1);
        li.addLast(2);
        li.addLast(3);
        li.addLast(4);
        li.addLast(5);
        li.addLast(6);
        li.display();
        Linklist li2 = new Linklist();
        li2.addLast(1);
        li2.addLast(2);
        li2.addLast(3);
        li2.addLast(4);
        li2.addLast(5);
        li2.display();
        MergeSortedList ms = new MergeSortedList();
        Node mergedList = ms.mergeTwoLists(li, li2);
        Linklist l3 = new Linklist();
        l3.head = mergedList;
        l3.display();
    }

}
