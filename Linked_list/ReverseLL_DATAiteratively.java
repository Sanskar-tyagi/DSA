package Linked_list;

public class ReverseLL_DATAiteratively {

    // ?We need to reverse the Data of the linkled list iteratively without changing
    // ?The address of the nodes

    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        public int size() {
            return size;
        }

        public void display() {
            for (Node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }

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

        void ReverseData() {
            // int e = this.size;
            // int s = 0;
            // Node temp_e = this.head;
            // Node temp_s = this.tail;
            // int temp;

            // while (s < e) {
            // if (s != 0) {
            // temp = e;
            // while (temp != 0) {
            // temp_s = temp_e.next;
            // }
            // }
            // int x = temp_e.data;
            // this.head.data = temp_s.data;
            // this.tail.data = x;
            // e--;
            // s++;
            // }

            // Correct approach
            int e = this.size;
            int s = 0;
            while (s < e) {
                Node n1 = this.FindNodeAt(s);
                Node n2 = this.FindNodeAt(e);
                int temp = n1.data;
                n1.data = n2.data;
                n2.data = temp;
                e++;
                s++;
            }
        }

        public Node FindNodeAt(int tar) {
            if (this.size == 0) {
                return null;
            }

            Node next = this.head;
            for (int i = 0; i < tar; i++) {
                next = next.next;
            }
            return next;
        }
    }
}

// TIME COMPLEXITY
// the line --> Node n1 = this.FindNodeAt(s); will have complexity of O(n), so
// will the line Node n2 = this.FindNodeAt(e);
// Complexity for the while loop would be n/2
// So the total complexity would be
// n/2(2*(O(n)))
// O(N^2)