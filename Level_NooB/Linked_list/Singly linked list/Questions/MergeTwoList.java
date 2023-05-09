
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

    public static void main(String[] args) {
        Linklist li = new Linklist();
        Linklist L2 = new Linklist();
        L2.addLast(1);
        L2.addLast(2);
        L2.addLast(3);
        li.addLast(0);
        li.addLast(0);
        System.out.println("List 1");
        li.display();
        System.out.println("List 2");
        L2.display();
        System.out.println("Merged");
        mergeList(li, L2);
    }
}
