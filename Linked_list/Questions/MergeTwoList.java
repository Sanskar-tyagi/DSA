package Linked_list.Questions;

public class MergeTwoList {
    static class Node {
        Node next;
        int data;
    }

    static class Linklist {
        Node head;
        Node tail;
        int size;

        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
            size++;
        }
        
    }
}
