package Linked_list.Questions;

public class MergelistAt {

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

        void display() {
            Node ptr = this.head;
            while (ptr != null) {
                System.out.print(ptr.data + "   ");
                ptr = ptr.next;
            }
            System.out.println("");
        }
    }

    static void mergeList(Linklist L1, Linklist L2) {
        L1.tail.next = L2.head;
        L1.tail = L2.tail;
        L1.display();
    }

    static void MergeListAt(int k, Linklist L1, Linklist L2) {
        Node temp1 = L1.head;
        while (k != 0) {
            temp1 = temp1.next;
            k--;
        }
        L2.tail.data = temp1.data;
        L2.tail.next = temp1.next;
        L2.display();
        L1.display();
    }

    public static void main(String[] args) {
        Linklist li = new Linklist();
        Linklist L2 = new Linklist();
        li.addLast(1);
        li.addLast(2);
        li.addLast(3);
        li.addLast(4);
        L2.addLast(11);
        L2.addLast(12);
        L2.addLast(13);
        L2.addLast(14);
        L2.addLast(15);
        System.out.println("List 1");
        li.display();
        System.out.println("List 2");
        L2.display();
        System.out.println("Merged L2 At 3rd index of L1");
        MergeListAt(2, li, L2);

    }
}
