package Linked_list.Questions;

public class InterSection {
    // ? findIntersection function.
    // ? The function is passed two linked lists which
    // ? start separately but merge at a node and become common thereafter.
    // ? The function is expected to find the point where two linked lists merge.
    // ? You are not allowed to use arrays to solve the problem.

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

    static void MergeListAt(int k, Linklist L1, Linklist L2) {
        Node temp1 = L1.head;
        while (k != 0) {
            temp1 = temp1.next;
            k--;
        }
        L2.tail.next = temp1;
        L2.display();
        L1.display();
    }

    static void findMergedIndex(Linklist L1, Linklist L2) {
        Node temp1 = L1.head;
        Node temp2 = L2.head;
        int x = L1.size - L2.size;
        int index = 0;
        if (x < 0) {
            while (x != 0) {
                temp2 = temp2.next;
                index += 1;
                x++;
            }
        } else if (x > 0) {
            while (x != 0) {
                temp1 = temp1.next;
                index += 1;
                x--;
            }
        }
        while (temp1 != null && temp2 != null && temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
            index += 1;
        }
        System.out.println("The List is merged at Index -->" + index);
        if (temp1 != null) {
            System.out.println("The Common Node Data is1 -->" + temp1.data);
        } else {
            System.out.println("The Common Node Data is2 -->" + temp2.data);
        }
    }

    public static void main(String[] args) {
        Linklist li = new Linklist();
        Linklist L2 = new Linklist();
        li.addLast(1);
        li.addLast(2);
        li.addLast(3);
        li.addLast(7);
        li.addLast(8);
        li.addLast(9);
        li.addLast(10);
        L2.addLast(4);
        L2.addLast(5);
        L2.addLast(6);
        System.out.println("List 1");
        li.display();
        System.out.println("List 2");
        L2.display();
        System.out.println("Merged L2 At 3rd index of L1");
        MergeListAt(5, li, L2);
        findMergedIndex(li, L2);
    }
}