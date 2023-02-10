package Linked_list.Questions;

import Linked_list.Functions.removeLast;

public class FindMid {
    // ? Define a function such that it should be an iterative function and should
    // ? return the mid of linked list. Also, make sure to not use size data member
    // ? directly or indirectly (by calculating size via making a traversal).
    // ? In linked list of odd size, mid is unambigous.
    // ? In linked list of even size, consider end of first half as mid.
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
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

        void findMidUsingSize() {
            Node slow = this.head;
            Node fast = this.head;
            if (this.size / 2 == 0) {
                while (fast != null && fast != this.tail) {
                    slow = slow.next;
                    fast = fast.next.next;
                }
                System.out.println(slow.data);
            } else {
                while (fast.next != null && fast.next != this.tail) {
                    slow = slow.next;
                    fast = fast.next.next;
                }
                System.out.println(slow.data);
            }
        }

        int FindMid() {
            Node slow = this.head;
            Node fast = this.head;
            while (fast != this.tail && fast.next != this.tail) {
                slow = slow.next;
                fast = fast.next.next;
            }
            int ans = slow.data;
            System.out.println(ans);
            return ans;
        }

        public int size() {
            return this.size;
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

    public static void main(String[] args) {
        LinkedList li = new LinkedList();
        li.addLast(4);
        li.addLast(2);
        li.addLast(3);
        li.addLast(0);
        li.addLast(0);
        System.out.println("List");
        li.display();
        System.out.println("MID");
        li.FindMid();
        System.out.println("MID Using Size");
        li.findMidUsingSize();

    }
}
