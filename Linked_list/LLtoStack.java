package Linked_list;

public class LLtoStack {
    // ? Note -> The intention is to use linked list functions to achieve the
    // ? purpose of a stack. All the functions should work in constant time.

    // ? 1. You are required to complete the code of our LLToStackAdapter class.
    // ? 2. As data members, you've a linkedlist available in the class.
    // ? 3. Here is the list of functions that you are supposed to complete
    // ? 3.1. push -> Should accept new data in LIFO manner
    // ? 3.2. pop -> Should remove and return data in LIFO manner. If not
    // ? available, print "Stack underflow" and return -1.
    // ? 3.3. top -> Should return data in LIFO manner. If not available, print
    // ? "Stack underflow" and return -1.
    // ? 3.4. size -> Should return the number of elements available in the
    // ? stack

    public static class Node {
        int Data;
        Node next;
    }

    static class LinkList {
        Node head;
        Node tail;
        int size;

        int size() {
            return this.size;
        }

        void push(int data) {
            Node n1 = new Node();
            n1.Data = data;
            if (this.size == 0) {
                this.head = n1;
                this.tail = n1;
                this.size++;
            }
            this.tail.next = n1;
            this.tail = n1;
        }

        int top() {
            Node n1 = new Node();
            return n1.Data;
        }

        void display() {
            Node ptr = this.head;
            while (ptr != null) {
                System.out.print(ptr.Data + "   ");
                ptr = ptr.next;
            }
            System.out.println("");
            System.out.println("");
        }

    }

    static void pop(LinkList li) {
        if (li.size == 0) {
            System.out.print("Poped element -->" + -1);
        } else if (li.size == 1) {
            int ans = li.tail.Data;
            li.head = null;
            li.tail = null;
            li.size = 0;
            System.out.print("Poped element -->" + ans);
        } else {
            Node n1 = new Node();
            Node pre = new Node();
            int d = li.tail.Data;
            n1 = li.head.next;
            pre = li.head;
            while (n1.next != null) {
                n1 = n1.next;
                pre = pre.next;
            }
            li.tail = pre;
            pre.next = null;
            li.size--;
            System.out.print("Poped element -->" + d);
        }
    }

    public static void main(String[] args) {
        LinkList li = new LinkList();
        li.push(9);
        li.push(10);
        li.push(11);
        li.push(12);
        li.display();
        pop(li);
        li.display();
    }
}
